import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day6 {
    public static int count1() {
        int right = 0;
        int left = 0;

        int[] table = new int[128];
        String currentString = "";
        File file = new File("src\\input6.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

        while (sc.hasNextLine()) {
            currentString += sc.nextLine();
        }

        //System.out.println(currentString.length());
        
        while (right < currentString.length()) {
            char r = currentString.charAt(right);
            table[r]++;

            while (table[r] > 1) {
                char l = currentString.charAt(left);
                table[l]--;
                left++;
            }

            if (right - left == 3) {
                sc.close();
                return right + 1;
            }
            right++;
        }
        
        sc.close();
        return 0;
    }

    public static int count2() {
        int right = 0;
        int left = 0;

        int[] table = new int[128];
        String currentString = "";
        File file = new File("src\\input6.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

        while (sc.hasNextLine()) {
            currentString += sc.nextLine();
        }

        //System.out.println(currentString.length());
        
        while (right < currentString.length()) {
            char r = currentString.charAt(right);
            table[r]++;

            while (table[r] > 1) {
                char l = currentString.charAt(left);
                table[l]--;
                left++;
            }

            if (right - left == 13) {
                sc.close();
                return right + 1;
            }
            right++;
        }
        
        sc.close();
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(count1());
        System.out.println(count2());
    }
}
