package dsa.with.shagun.scaler.advance.array.array3;

import java.util.ArrayList;
import java.util.Comparator;

public class InsertInterval {

    static class Interval {

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

    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(2, 6));
        list.add(new Interval(8, 10));
        list.add(new Interval(15, 18));

        ArrayList<Interval> list1 = new ArrayList<>();
        list1.add(new Interval(6037774, 6198243));
        list1.add(new Interval(6726550, 7004541));
        list1.add(new Interval(8842554, 10866536));
        list1.add(new Interval(11027721, 11341296));
        list1.add(new Interval(11972532, 14746848));
        list1.add(new Interval(16374805, 16706396));
        list1.add(new Interval(17557262, 20518214));
        list1.add(new Interval(22139780, 22379559));
        list1.add(new Interval(27212352, 28404611));
        list1.add(new Interval(28921768, 29621583));
        list1.add(new Interval(29823256, 32060921));
        list1.add(new Interval(33950165, 36418956));
        list1.add(new Interval(37225039, 37785557));
        list1.add(new Interval(40087908, 41184444));
        list1.add(new Interval(41922814, 45297414));
        list1.add(new Interval(48142402, 48244133));
        list1.add(new Interval(48622983, 50443163));
        list1.add(new Interval(50898369, 55612831));
        list1.add(new Interval(57030757, 58120901));
        list1.add(new Interval(59772759, 59943999));
        list1.add(new Interval(61141939, 64859907));
        list1.add(new Interval(65277782, 65296274));
        list1.add(new Interval(67497842, 68386607));
        list1.add(new Interval(70414085, 73339545));
        list1.add(new Interval(73896106, 75605861));
        list1.add(new Interval(79672668, 84539434));
        list1.add(new Interval(84821550, 86558001));
        list1.add(new Interval(91116470, 92198054));
        list1.add(new Interval(96147808, 98979097));

        //insert(list1, new Interval(36210193, 61984219));

        ArrayList<Interval> list2 = new ArrayList<>();
        list2.add(new Interval(1, 2));
        list2.add(new Interval(3, 6));

        insert(list2, new Interval(10, 8));

    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        //Given interval is not necessarily sorted i.e. start<end

        int start = Math.min(newInterval.start, newInterval.end);
        int end = Math.max(newInterval.start, newInterval.end);

        Interval sortedNewInt = new Interval(start, end);

        int flag = 0;
        for (int i = 0; i < intervals.size(); i++) {
            if (start <= intervals.get(i).end) {
                intervals.add(sortedNewInt);
                flag = 1;
                break;
            }
        }

        if (flag == 0) { // new Interval is not inserted
            intervals.add(sortedNewInt);
        }

        return getNonOverlapList(intervals);
    }

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
    }
}