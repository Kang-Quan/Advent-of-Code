import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day10 {
    public static int count1() {
        int total = 0;
        File file = new File("src\\input10.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

        int cycle = 1;
        int X = 1;
        while (sc.hasNextLine()) {        
            if (cycle > 220) {
                break;
            }
            String currentString = sc.nextLine();

            String[] split = currentString.split(" ");

            if (split.length == 2) {
                int toAdd = Integer.parseInt(split[1]);
                for (int i = 0; i < 2; i++) {
                    if (isAdded(cycle)) {
                        total += X * cycle;
                    }
                    cycle++;
                }
                X += toAdd;
            } else {
                if (isAdded(cycle)) {
                    total += X * cycle;
                }
                cycle += 1;
            }
            
            
            

        }
        sc.close();
        //System.out.println(cycle);
        return total;
    }


    public static void count2() {
        String ans = "";
        File file = new File("src\\input10.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        int cycle = 1;
        int X = 1;
        while (sc.hasNextLine()) {        
            String currentString = sc.nextLine();

            String[] split = currentString.split(" ");

            if (split.length == 2) {
                int toAdd = Integer.parseInt(split[1]);
                for (int i = 0; i < 2; i++) {
                    if (isHashtag(cycle, X)) {
                        ans += "#";
                    } else {
                        ans += ".";
                    }
                    cycle++;
                    if (cycle == 41) {
                        //System.out.println("no");
                        cycle = 1;
                        ans += "\n";
                    }
                }
                X += toAdd;
            } else {
                if (isHashtag(cycle, X)) {
                    ans += "#";
                } else {
                    ans += ".";
                }
                cycle++;
                if (cycle == 41) {
                    //System.out.println("hi");
                    cycle = 1;
                    ans += "\n";
                }
            }
            
            
            

        }
        sc.close();
        System.out.println(ans);
        return;
    }

    public static boolean isAdded(int cycle) {
        return ((cycle - 20) % 40) == 0;
    }

    public static boolean isHashtag(int cycle, int X) {
        //System.out.println(cycle);
        //System.out.println(X);
        return cycle - X == 0 || cycle - X == 1 || cycle - X == 2;
    }

    public static void main(String[] args) {
        System.out.println(count1());
        count2();
    }
}
