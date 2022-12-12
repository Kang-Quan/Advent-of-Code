import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Day8 {
    List<List<String>> table = new ArrayList<>();

    public static int count1() {
        int total = 0;
        List<List<Integer>> table = new ArrayList<>();

        File file = new File("src\\input8.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

        while (sc.hasNextLine()) {
            String currentString = sc.nextLine();
            List<Integer> newRow = new ArrayList<>();
            for (int i = 0; i < currentString.length(); i++) {
                int newNum = (int) currentString.charAt(i) - '0';
                newRow.add(newNum);
            }
            table.add(newRow);
        }

        // String result = "";
        // for(int i = 0; i < table.size(); i++){
        //     for(int j = 0; j < table.get(i).size(); j++){
        //         result += table.get(i).get(j);
        //     }
        //     System.out.println(result);
        // }

        //System.out.println(table.get(0).size());
        //System.out.println(table.size());

        int[][] added = new int[table.size()][table.get(0).size()];

        //left to right
        for (int i = 1; i < table.size() - 1; i++) {
            int behindHighest = table.get(i).get(0);
            for (int j = 1; j < table.get(0).size() - 1; j++) {
                int currentHeight = table.get(i).get(j);
                if (currentHeight > behindHighest) {
                    behindHighest = currentHeight;
                    if (added[i][j] == 0) {
                        total++;
                        added[i][j] = 1;
                    }
                } 

            }
        }

        

        //right to left
        for (int i = 1; i < table.size() - 1; i++) {
            int behindHighest = table.get(i).get(table.get(i).size() - 1);
            //System.out.println(table.get(0).size() - 2);
            for (int j = table.get(0).size() - 2; j > 0; j--) {
                int currentHeight = table.get(i).get(j);
                //System.out.println(currentHeight);
                //System.out.println("height");
                if (currentHeight > behindHighest) {
                    behindHighest = currentHeight;
                    if (added[i][j] == 0) {
                        total++;
                        added[i][j] = 1;
                    }
                } 
            }
        }
        //System.out.println(total);

        //up to down
        for (int j = 1; j < table.size() - 1; j++) {
            int behindHighest = table.get(0).get(j);
            for (int i = 1; i < table.size() - 1; i++) {
                int currentHeight = table.get(i).get(j);
                if (currentHeight > behindHighest) {
                    behindHighest = currentHeight;
                    if (added[i][j] == 0) {
                        total++;
                        added[i][j] = 1;
                    }
                } 
            }
        }

        //down to up
        for (int j = 1; j < table.size() - 1; j++) {
            int behindHighest = table.get(table.size() - 1).get(j);
            for (int i = table.size() - 2; i > 0; i--) {
                int currentHeight = table.get(i).get(j);
                if (currentHeight > behindHighest) {
                    behindHighest = currentHeight;
                    if (added[i][j] == 0) {
                        total++;
                        added[i][j] = 1;
                    }
                } 
            }
        }

        //add perimeter
        total += (table.size() - 2) * 2;
        total += (table.get(0).size() - 2) * 2;
        total += 4;

        sc.close();
        return total;
    }

    public static int count2() {
        int highest = 0;
        List<List<Integer>> table = new ArrayList<>();

        File file = new File("src\\input8.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

        while (sc.hasNextLine()) {
            String currentString = sc.nextLine();
            List<Integer> newRow = new ArrayList<>();
            for (int i = 0; i < currentString.length(); i++) {
                int newNum = (int) currentString.charAt(i) - '0';
                newRow.add(newNum);
            }
            table.add(newRow);
        }

        for (int i = 1; i < table.size() - 1; i++) {
            for (int j = 1; j < table.get(0).size() - 1; j++) {
                int score = calculateScore(table, i, j);
                if (score > highest) {
                    highest = score;
                }

            }
        }

        

        sc.close();
        return highest;
    }

    public static int calculateScore(List<List<Integer>> table, int row, int col) {
        int total = 1;
        int currentHeight = table.get(row).get(col);
        //up
        int up = 0;
        for (int i = row - 1; i >= 0; i--) {
            int newHeight = table.get(i).get(col);
            up++;
            if (currentHeight <= newHeight) {
                break;
            }
        }

        //down
        int down = 0;
        for (int i = row + 1; i < table.size(); i++) {
            int newHeight = table.get(i).get(col);
            down++;
            if (currentHeight <= newHeight) {
                break;
            }
        }

        //left
        int left = 0;
        for (int i = col - 1; i >= 0; i--) {
            int newHeight = table.get(row).get(i);
            left++;
            if (currentHeight <= newHeight) {
                break;
            }
        }

        //right
        int right = 0;
        for (int i = col + 1; i < table.get(row).size(); i++) {
            int newHeight = table.get(row).get(i);
            right++;
            if (currentHeight <= newHeight) {
                break;
            }
        }
        total = up * down * left * right;
        return total;
    }

    public static void main(String[] args) {
        System.out.println(count1());
        System.out.println(count2());
    }
}
