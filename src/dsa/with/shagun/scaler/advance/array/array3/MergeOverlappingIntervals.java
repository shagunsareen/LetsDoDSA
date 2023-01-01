package dsa.with.shagun.scaler.advance.array.array3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

//return list of non-overlapping intervals
public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(2, 6));
        list.add(new Interval(8, 10));
        list.add(new Interval(15, 18));

        ArrayList<Interval> list1 = new ArrayList<>();
        list1.add(new Interval(1, 10));
        list1.add(new Interval(2, 9));
        list1.add(new Interval(3, 8));
        list1.add(new Interval(4, 7));
        list1.add(new Interval(5, 6));
        list1.add(new Interval(6, 6));

        getNonOverlapList(list1);
    }

    //TC : O(NLogN) ,SC : O(N)
    public static ArrayList<Interval> getNonOverlapList(ArrayList<Interval> intervals) {

        intervals.sort(Comparator.comparingInt(a -> a.start));

        ArrayList<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval currInt = intervals.get(i);
            Interval oldInt = res.get(res.size() - 1);

            if (currInt.start <= oldInt.end) {
                // merge intervals as these are overlapping

                currInt.start = Math.min(currInt.start, oldInt.start);
                currInt.end = Math.max(currInt.end, oldInt.end);

                res.remove(oldInt);
                res.add(currInt);
            } else {
                //non-overlapping intervals
                res.add(currInt);
            }
        }
        return res;


        //Not-working

        /*int x = intervals.get(0).start;
        int y = intervals.get(0).end;

        ArrayList<Interval> newList = new ArrayList<>();

        for (int i = 1; i < intervals.size(); i++) {
            int start2 = intervals.get(i).start;
            int end2 = intervals.get(i).end;

            if (start2 <= y) {
                // merge intervals as these are overlapping
                y = Math.max(y, end2);
                //newList.add(new Interval(x, y)); //updated new interval in list
                Interval newInterval = new Interval(x, y);
                if (!newList.contains(newInterval)) {
                    newList.add(newInterval); //updated new interval in list
                }
            } else {
                //non-overlapping intervals
                x = start2;
                y = end2;
                newList.add(new Interval(x, y));
            }
        }
        return newList;*/
    }
}
