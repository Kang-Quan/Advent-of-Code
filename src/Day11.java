import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day11 {
    public static int count1() {
        List<Double> item = new ArrayList<>(Arrays.asList(54.0 , 89.0, 94.0));
        Monkey monkey0 = new Monkey(item, false, 7, 17, 5, 3);

        item = new ArrayList<>(
            List.of(66.0,71.0));
        Monkey monkey1 = new Monkey(item, true, 4, 3, 0, 3);

        item = new ArrayList<>(
            List.of(76.0, 55.0, 80.0, 55.0, 55.0, 96.0, 78.0));
        Monkey monkey2 = new Monkey(item, true, 2, 5, 7, 4);

        item = new ArrayList<>(
            List.of(93.0, 69.0, 76.0, 66.0, 89.0, 54.0, 59.0, 94.0));
        Monkey monkey3 = new Monkey(item, true, 7, 7, 5, 2);

        item = new ArrayList<>(
            List.of(80.0, 54.0, 58.0, 75.0, 99.0));
        Monkey monkey4 = new Monkey(item, false, 17, 11, 1, 6);

        item = new ArrayList<>(
            List.of(69.0, 70.0, 85.0, 83.0));
        Monkey monkey5 = new Monkey(item, true, 8, 19, 2, 7);

        item = new ArrayList<>(
            List.of(89.0));
        Monkey monkey6 = new Monkey(item, true, 6, 2, 0, 1);

        item = new ArrayList<>(
            List.of(62.0, 80.0, 58.0, 57.0, 93.0, 56.0));
        Monkey monkey7 = new Monkey(item, false, -1, 13, 6, 4);

        List<Monkey> monkeys = new ArrayList<>();

        monkeys.add(monkey0);
        monkeys.add(monkey1);
        monkeys.add(monkey2);
        monkeys.add(monkey3);
        monkeys.add(monkey4);
        monkeys.add(monkey5);
        monkeys.add(monkey6);
        monkeys.add(monkey7);
            
        MonkeyList monkeyList = new MonkeyList(monkeys);
        int ans = 0;

        for (int i = 0; i < 20; i++) {
            ans = monkeyList.FullRoutine();
        }
        return ans;
    }

    public static long count2() {
        List<Double> item = new ArrayList<>(Arrays.asList(54.0 , 89.0, 94.0));
        Monkey monkey0 = new Monkey(item, false, 7, 17, 5, 3);

        item = new ArrayList<>(
            List.of(66.0,71.0));
        Monkey monkey1 = new Monkey(item, true, 4, 3, 0, 3);

        item = new ArrayList<>(
            List.of(76.0, 55.0, 80.0, 55.0, 55.0, 96.0, 78.0));
        Monkey monkey2 = new Monkey(item, true, 2, 5, 7, 4);

        item = new ArrayList<>(
            List.of(93.0, 69.0, 76.0, 66.0, 89.0, 54.0, 59.0, 94.0));
        Monkey monkey3 = new Monkey(item, true, 7, 7, 5, 2);

        item = new ArrayList<>(
            List.of(80.0, 54.0, 58.0, 75.0, 99.0));
        Monkey monkey4 = new Monkey(item, false, 17, 11, 1, 6);

        item = new ArrayList<>(
            List.of(69.0, 70.0, 85.0, 83.0));
        Monkey monkey5 = new Monkey(item, true, 8, 19, 2, 7);

        item = new ArrayList<>(
            List.of(89.0));
        Monkey monkey6 = new Monkey(item, true, 6, 2, 0, 1);

        item = new ArrayList<>(
            List.of(62.0, 80.0, 58.0, 57.0, 93.0, 56.0));
        Monkey monkey7 = new Monkey(item, false, -1, 13, 6, 4);

        List<Monkey> monkeys = new ArrayList<>();

        monkeys.add(monkey0);
        monkeys.add(monkey1);
        monkeys.add(monkey2);
        monkeys.add(monkey3);
        monkeys.add(monkey4);
        monkeys.add(monkey5);
        monkeys.add(monkey6);
        monkeys.add(monkey7);
            
        MonkeyList monkeyList = new MonkeyList(monkeys);
        long ans = 0;
        int multiplier = 17 * 3 * 5 * 7 * 11 * 19 * 2 * 13;
        for (int i = 0; i < 10000; i++) {
            ans = monkeyList.FullRoutine2(multiplier);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(count1());
        System.out.println(count2());
    }
}
