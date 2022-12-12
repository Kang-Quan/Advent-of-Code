import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5 {

    private static List<String> one = new ArrayList<String>(Arrays.asList("B"
    , "S", "V", "Z", "G", "P", "W"));
    
    private static List<String> two = new ArrayList<String>(Arrays.asList("J"
    , "V", "B", "C", "Z", "F"));

    private static List<String> three = new ArrayList<String>(Arrays.asList("V"
    , "L", "M", "H", "N", "Z", "D", "C"));

    private static List<String> four = new ArrayList<String>(Arrays.asList("L"
    , "D", "M", "Z", "P", "F", "J", "B"));

    private static List<String> five = new ArrayList<String>(Arrays.asList("V"
    , "F", "C", "G", "J", "B", "Q", "H"));

    private static List<String> six = new ArrayList<String>(Arrays.asList("G"
    , "F", "Q", "T", "S", "L", "B"));

    private static List<String> seven = new ArrayList<String>(Arrays.asList("L"
    , "G", "C", "Z", "V"));

    private static List<String> eight = new ArrayList<String>(Arrays.asList("N"
    , "L", "G"));
    
    private static List<String> nine = new ArrayList<String>(Arrays.asList("J"
    , "F", "H", "C"));

    



    

    public static void count1() {
        List<List<String>> table = new ArrayList<>();

        table.add(one);
        table.add(two);
        table.add(three);
        table.add(four);
        table.add(five);
        table.add(six);
        table.add(seven);
        table.add(eight);
        table.add(nine);


        File file = new File("src\\inputs\\input5.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        while (sc.hasNextLine()) {
            String currentString = sc.nextLine();

            int indexFrom = currentString.indexOf(" from");
            int indexTo = currentString.indexOf(" to");
            
            int numberOfPop = Integer.parseInt(currentString.substring(5, indexFrom));
            int from = Integer.parseInt(currentString.substring(6 + indexFrom, indexTo)) - 1;
            int to = Integer.parseInt(currentString.substring(4 + indexTo)) - 1;

            for (int i = 0; i < numberOfPop; i++) {
                String element = table.get(from).remove(table.get(from).size() - 1);
                table.get(to).add(element);
            }
        }

        for (int i = 0; i < 9; i++) {
            System.out.println(table.get(i).get(table.get(i).size() - 1));
        }
        sc.close();
    }

    public static void count2() {
        List<List<String>> table = new ArrayList<>();


        table.add(one);
        table.add(two);
        table.add(three);
        table.add(four);
        table.add(five);
        table.add(six);
        table.add(seven);
        table.add(eight);
        table.add(nine);


        File file = new File("src\\inputs\\input5.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        while (sc.hasNextLine()) {
            List<String> flipper = new ArrayList<>();
            String currentString = sc.nextLine();

            int indexFrom = currentString.indexOf(" from");
            int indexTo = currentString.indexOf(" to");
            
            int numberOfPop = Integer.parseInt(currentString.substring(5, indexFrom));
            int from = Integer.parseInt(currentString.substring(6 + indexFrom, indexTo)) - 1;
            int to = Integer.parseInt(currentString.substring(4 + indexTo)) - 1;

            for (int i = 0; i < numberOfPop; i++) {
                String element = table.get(from).remove(table.get(from).size() - 1);
                flipper.add(element);
            }

            for (int i = 0; i < flipper.size(); i++) {
                String element = flipper.get(flipper.size() - 1 - i);
                table.get(to).add(element);
            }

            
        }

        for (int i = 0; i < 9; i++) {
            System.out.println(table.get(i).get(table.get(i).size() - 1));
        }
        sc.close();
    }

    //only call either count1 or count2 at once because I used a shared variable so it will be mutated
    public static void main(String[] args) {
        //count1();
        System.out.println("-----------------------------------------------------------");
        count2();
    }
}
