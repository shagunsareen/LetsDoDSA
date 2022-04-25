package dsa.with.shagun.leetcode.HashMap;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem { //TC : O(1), SC : O(n)

    Map<Integer, Pair<String, Integer>> passengerCheckInMap;
    Map<String, Pair<Double, Integer>> routeMap;

    public UndergroundSystem() {
        passengerCheckInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        if (!passengerCheckInMap.containsKey(id)) {  // if key is already present don't insert another route for same candidate
            passengerCheckInMap.put(id, new Pair<>(stationName, t)); // insert only if key doesn't exist
        }
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> passengerCheckInDetails = passengerCheckInMap.get(id);
        passengerCheckInMap.remove(id); // remove details when once used

        int totalTime = t - passengerCheckInDetails.getValue();
        String routeName = passengerCheckInDetails.getKey() + "_" + stationName;

        Pair<Double, Integer> route = routeMap.getOrDefault(routeName, new Pair<>(0.0, 0));
        routeMap.put(routeName, new Pair<>(route.getKey() + totalTime, route.getValue() + 1));
    }

    public double getAverageTime(String startStation, String endStation) {
        Pair<Double, Integer> routeTrip = routeMap.get(startStation + "_" + endStation);
        return routeTrip.getKey() / routeTrip.getValue();
    }

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
}
