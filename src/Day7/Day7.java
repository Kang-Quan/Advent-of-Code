package Day7;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day7 {
    public static FileTree buildTree() {
        File file = new File("src\\inputs\\input7.txt");
        FileTree dir = new FileTree();
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        while (sc.hasNextLine()) {
            String currentString = sc.nextLine();
            String[] splitString = currentString.split(" ");
            int numOfKeyword = splitString.length;
            //for 3 letter 
            if (numOfKeyword == 3) {
                if (splitString[2].equals("/")) {
                    dir.cdRoot();
                } else if (splitString[2].equals("..")) {
                    dir.cdBack();
                } else {
                    dir.cdNext(splitString[2]);
                }
            } else {
                if (splitString[0].equals("dir")) {
                    dir.insertDir(splitString[1]);
                } else if (!splitString[0].equals("$")) {
                    int size = Integer.parseInt(splitString[0]);
                    dir.insertFile(splitString[1], size);
                }
            }
        }
        sc.close();
        return dir;
    }

    public static int count1() {
        FileTree dir = buildTree();
        return dir.getPart1();
    }

    public static int count2() {
        FileTree dir = buildTree();
        return dir.getPart2();
    }

    public static void main(String[] args) {
        //buildTree();
        //System.out.println("done");
        System.out.println(count1());
        System.out.println(count2());
    }
}
