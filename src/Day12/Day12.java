package Day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;

public class Day12 {
    public static List<List<Character>> buildMap() {
        List<List<Character>> map = new ArrayList<>();

        File file = new File("src\\inputs\\input12.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        while (sc.hasNextLine()) {        
            List<Character> row = new ArrayList<>();
            String currentString = sc.nextLine();

            for (int i = 0; i < currentString.length(); i++) {
                row.add(currentString.charAt(i));
            }
            map.add(row);
        }
        sc.close();

        
        // for(int i = 0; i < map.size(); i++){
        //     String result = "";
        //     for(int j = 0; j < map.get(i).size(); j++){
        //         result += map.get(i).get(j);
        //     }
        //     System.out.println(result);
        // }

        //System.out.println(map.get(1).size());
        return map;
    }

    public static int BFS() {
        List<List<Character>> map = buildMap();

        HashSet<Key> visited = new HashSet<>();
        NodeBFS initialState = new NodeBFS(0, 20, 0, 'a', null);
        
        List<NodeBFS> queue = new ArrayList<>();
        queue.add(initialState);


        while (!queue.isEmpty()) {
            NodeBFS currNode = queue.remove(0);
            
            if (isGoal(currNode)) {
                return currNode.getSteps() + 1;
            }

            List<NodeBFS> child = generateChild(currNode, map);
            for (int i = 0; i < child.size(); i++) {
                NodeBFS newChild = child.get(i);
                int newX = newChild.getX();
                int newY = newChild.getY();

                Key key = new Key(newX, newY);

                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(newChild);
                }
            }

        }
        return -1;

    }

    public static Boolean isGoal(NodeBFS currentNode) {
        return (currentNode.getLetter() == 'z');
    }

    public static List<NodeBFS> generateChild(NodeBFS currentNode, List<List<Character>> map) {
        int x = currentNode.getX();
        int y = currentNode.getY();
        int currLetter = currentNode.getLetter();
        int currSteps = currentNode.getSteps();

        List<NodeBFS> child = new ArrayList<>();

        //up
        if (y - 1 >= 0) {
            char letter = map.get(y - 1).get(x);
            if (currLetter + 1 >= letter) {
                NodeBFS newChild = new NodeBFS(x, y - 1, currSteps + 1, letter, currentNode);
                child.add(newChild);
            }
        }

        //down
        if (y + 1 <= 40) {
            char letter = map.get(y + 1).get(x);
            if (currLetter + 1 >= letter) {
                NodeBFS newChild = new NodeBFS(x, y + 1, currSteps + 1, letter, currentNode);
                child.add(newChild);
            }
            
        }

        //left
        if (x - 1 >= 0) {
            char letter = map.get(y).get(x - 1);
            if (currLetter + 1 >= letter) {
                NodeBFS newChild = new NodeBFS(x - 1, y, currSteps + 1, letter, currentNode);
                child.add(newChild);
            }
            
            
        }

        //right
        if (x + 1 < 67) {
            char letter = map.get(y).get(x + 1);
            if (currLetter + 1 >= letter) {
                NodeBFS newChild = new NodeBFS(x + 1, y, currSteps + 1, letter, currentNode);
                child.add(newChild);
            }
        }
        //System.out.println(child.size());
        return child;
    }

    public static int BFS2() {
        List<List<Character>> map = buildMap();

        HashSet<Key> visited = new HashSet<>();
        NodeBFS initialState = new NodeBFS(0, 20, 0, 'a', null);
        
        List<NodeBFS> queue = new ArrayList<>();
        queue.add(initialState);

        for(int i = 0; i < map.size(); i++){
            for(int j = 0; j < map.get(i).size(); j++){
                if (map.get(i).get(j) == 'a') {
                    NodeBFS initial = new NodeBFS(j, i, 0, 'a', null);
                    queue.add(initial); 
                }
            }
        }
        


        while (!queue.isEmpty()) {
            NodeBFS currNode = queue.remove(0);
            
            if (isGoal(currNode)) {
                return currNode.getSteps() + 1;
            }

            List<NodeBFS> child = generateChild(currNode, map);
            for (int i = 0; i < child.size(); i++) {
                NodeBFS newChild = child.get(i);
                int newX = newChild.getX();
                int newY = newChild.getY();

                Key key = new Key(newX, newY);

                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(newChild);
                }
            }

        }
        return -1;

    }

    

    public static void main(String[] args) {
        //buildMap();
        System.out.println(BFS());
        System.out.println(BFS2());
    }
}
