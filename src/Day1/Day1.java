package Day1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static int count() {
        int max = 0;
        int currentElf = 0;
        File file = new File("src\\inputs\\input1.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

        while (sc.hasNextLine()) {
            
            String currentString = sc.nextLine();
            //System.out.println(currentString);
            if (currentString.equals("")) {
                //we compare against max
                if (currentElf > max) {
                    max = currentElf;
                } 
                currentElf = 0;
            } else {
                int currentNumber = Integer.parseInt(currentString);
                currentElf = currentElf + currentNumber;
            }
            

        }

        if (currentElf > max) {
            max = currentElf;
        }
        sc.close();
        return max;
    }

    public static int count2() {
        List<Integer> elfCalories = new ArrayList<>();
        int currentElf = 0;
        File file = new File("src\\inputs\\input1.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

        while (sc.hasNextLine()) {
            
            String currentString = sc.nextLine();
            //System.out.println(currentString);
            if (currentString.equals("")) {
                //we compare against max
                elfCalories.add(currentElf);
                currentElf = 0;
            } else {
                int currentNumber = Integer.parseInt(currentString);
                currentElf = currentElf + currentNumber;
            }
            

        }
        int ans = 0;
        elfCalories.add(currentElf);
        elfCalories.sort(null);
        for (int i = 0; i < 3; i++) {
            ans += elfCalories.get(elfCalories.size() - i - 1);
        }
        sc.close();
        return ans;
    }
    

    public static void main(String[] args) {
        System.out.println(count());
        System.out.println(count2());
    }
}
