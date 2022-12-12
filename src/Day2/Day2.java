package Day2;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2 {

    public static int shapePoints(String shape) {
        if (shape.equals("X")) {
            return 1;
        } else if (shape.equals("Y")) {
            return 2;
        } else if (shape.equals("Z")) {
            return 3;
        }
        return -1;
    }

    public static int outcomePoints(String opp, String user) {
        //draw 
        if (opp.equals("A") && user.equals("X") 
            || opp.equals("B") && user.equals("Y")
            || opp.equals("C") && user.equals("Z")) {
            return 3;
        } 
        
        //win 
        if (opp.equals("A") && user.equals("Y") 
            || opp.equals("B") && user.equals("Z")
            || opp.equals("C") && user.equals("X")) {
            return 6;
        } 

        return 0;
    }

    public static String findMove(String opp, String status) {
        if (status.equals("X")) {
            //lose
            if (opp.equals("A")) {
                return "Z";
            } else if (opp.equals("B")) {
                return "X";
            } else if (opp.equals("C")) {
                return "Y";
            }
        } else if (status.equals("Y")) {
            //draw
            if (opp.equals("A")) {
                return "X";
            } else if (opp.equals("B")) {
                return "Y";
            } else if (opp.equals("C")) {
                return "Z";
            }
        } else if (status.equals("Z")) {
            //win
            if (opp.equals("A")) {
                return "Y";
            } else if (opp.equals("B")) {
                return "Z";
            } else if (opp.equals("C")) {
                return "X";
            }
        }
        
        
        
        return "";
    }

    public static int count2() {
        String opponent = "";
        String user = "";
        int total = 0;
        File file = new File("src\\inputs\\input2.txt");

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
            String[] moves = currentString.split(" ");
            opponent = moves[0];
            user = moves[1];

            String myMove = findMove(opponent, user); 

            total += shapePoints(myMove);
            total += outcomePoints(opponent, myMove);
        }

        
        sc.close();
        return total;
    }

    public static int count1() {
        String opponent = "";
        String user = "";
        int total = 0;
        File file = new File("src\\inputs\\input2.txt");

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
            String[] moves = currentString.split(" ");
            opponent = moves[0];
            user = moves[1];

            total += shapePoints(user);
            total += outcomePoints(opponent, user);
        }

        
        sc.close();
        return total;
    }



    public static void main(String[] args) {
        System.out.println(count1());
        System.out.println(count2());
    }
}
