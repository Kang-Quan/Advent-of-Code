package Day9;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;

public class Day9 {
    public static int count1() {
        File file = new File("src\\inputs\\input9.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

        HashSet<Key> table = new HashSet<>();
        Key head = new Key(0, 0);
        Key tail = new Key(0, 0);
        table.add(tail);
        while (sc.hasNextLine()) {
            String currentString = sc.nextLine();
            String[] items = currentString.split(" ");
            
            String direction = items[0];
            int numberOfSteps = Integer.parseInt(items[1]);

            for (int i = 0; i < numberOfSteps; i++) {
                head = head.moveHead(direction);
                if (!Key.isConnected(head, tail)) {
                    tail = head.moveTail(direction);
                    if (!table.contains(tail)) {
                        table.add(tail);
                    }
                }
            }
            



        }
        sc.close();
        return table.size();
    }

    public static int count2() {
        File file = new File("src\\inputs\\input9.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

        HashSet<Key> table = new HashSet<>();
        Key[] rope = new Key[10];
        for (int i = 0; i < rope.length; i++) {
            rope[i] = new Key(0, 0);
        }
        table.add(rope[9]);
        while (sc.hasNextLine()) {
            String currentString = sc.nextLine();
            String[] items = currentString.split(" ");
            
            String direction = items[0];
            int numberOfSteps = Integer.parseInt(items[1]);

            for (int i = 0; i < numberOfSteps; i++) {
                
                rope[0] = rope[0].moveHead(direction);
                for (int j = 1; j < rope.length; j++) {
                    if (!Key.isConnected(rope[j - 1], rope[j])) {
                        String nextDirection = rope[j].giveDirections(rope[j - 1], rope[j]);
                        rope[j] = rope[j].moveTail2(nextDirection);
                    } else {
                        break;
                    }
                        

                }

                if (!table.contains(rope[9])) {
                    //System.out.println(rope[9]);
                    table.add(rope[9]);
                }
                // for (int k = 0; k < rope.length; k++) {
                //     System.out.print(rope[k] + " ");
                // }
                // System.out.println();
            }
            
            
            



        }
        sc.close();
        return table.size();
    }


    public static void main(String[] args) {
        System.out.println(count1());
        System.out.println(count2());
    }
}
