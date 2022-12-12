import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class Day3 {
    
    public static int count1() {
        int total = 0;
        File file = new File("src\\input3.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

        while (sc.hasNextLine()) {
            Set<Character> set1 = new HashSet<Character>();
            Set<Character> set2 = new HashSet<Character>();
            String currentString = sc.nextLine();

            int stringLength = currentString.length();
            
            for (int i = 0; i < stringLength / 2; i++) {
                set1.add(currentString.charAt(i));
            }

            for (int i = stringLength/2; i < stringLength; i++) {
                set2.add(currentString.charAt(i));
            }
            set1.retainAll(set2);
            char duplicate = 'a';
            for (char c : set1) {
                duplicate = c;
            }
            //System.out.println((int) duplicate);
            if (Character.isUpperCase(duplicate)) {
                total += (int) duplicate - 65 + 27;
            } else {
                total += (int) duplicate - 96;
            }
        }
        sc.close();
        return total;
    }

    public static int count2() {
        int total = 0;
        File file = new File("src\\input3.txt");
        List<String> arrlist = new ArrayList<>();

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

        while (sc.hasNextLine()) {
            arrlist.add(sc.nextLine());
        }
        
        for (int i = 0; i < arrlist.size() / 3; i++) {
            Set<Character> set1 = new HashSet<Character>();
            Set<Character> set2 = new HashSet<Character>();
            Set<Character> set3 = new HashSet<Character>();
            String one = arrlist.get(i * 3);
            String two = arrlist.get(i * 3 + 1);
            String three = arrlist.get(i * 3 + 2);

            for (int j = 0; j < one.length(); j++) {
                set1.add(one.charAt(j));
            }

            for (int j = 0; j < two.length(); j++) {
                set2.add(two.charAt(j));
            }

            for (int j = 0; j < three.length(); j++) {
                set3.add(three.charAt(j));
            }

            set1.retainAll(set3);
            set1.retainAll(set2);

            char duplicate = 'a';
            for (char c : set1) {
                duplicate = c;
            }

            if (Character.isUpperCase(duplicate)) {
                total += (int) duplicate - 65 + 27;
            } else {
                total += (int) duplicate - 96;
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
