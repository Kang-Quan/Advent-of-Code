package Day4;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day4 {
    public static int count1() {
        int total = 0;
        File file = new File("src\\inputs\\input4.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

        while (sc.hasNextLine()) {
            String currentString = sc.nextLine();
            String[] ranges = currentString.split(",");
            String[] range1 = ranges[0].split("-");
            String[] range2 = ranges[1].split("-");

            int min1 = Integer.parseInt(range1[0]);
            int max1 = Integer.parseInt(range1[1]);

            int min2 = Integer.parseInt(range2[0]);
            int max2 = Integer.parseInt(range2[1]);

            if ((min1 >= min2 && max1 <= max2) 
                || (min2 >= min1 && max2 <= max1)) {
                total += 1;
            }
        }
        sc.close();
        return total;
    }

    public static int count2() {
        int total = 0;
        File file = new File("src\\inputs\\input4.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

        while (sc.hasNextLine()) {
            String currentString = sc.nextLine();
            String[] ranges = currentString.split(",");
            String[] range1 = ranges[0].split("-");
            String[] range2 = ranges[1].split("-");

            int min1 = Integer.parseInt(range1[0]);
            int max1 = Integer.parseInt(range1[1]);

            int min2 = Integer.parseInt(range2[0]);
            int max2 = Integer.parseInt(range2[1]);

            if ((min1 <= max2) 
                && (max1 >= min2)) {
                total += 1;
            }
        }
        sc.close();
        return total;
    }

    public static void main(String[] args) {
        System.out.println(count1());
        System.out.println(count2());
    }
}
