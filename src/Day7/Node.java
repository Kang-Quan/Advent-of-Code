package Day7;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Node {
    private int fileSize;
    private Node parent;
    private HashMap<String, Node> child;
    private String name;
    private Boolean isDirectory;

    public Node(int fileSize, String name) {
        this.fileSize = fileSize;
        this.parent = null;
        this.child = new HashMap<>();
        this.name = name;
        this.isDirectory = true;
    }

    public Node getChild(String name) {
        return this.child.get(name);
    }

    public Node goBack() {
        return this.parent;
    }

    public void insertChild(String name, int fileSize, Boolean isDirectory) {
        Node newNode = new Node(fileSize, name);
        newNode.parent = this;
        if (!isDirectory) {
            newNode.isDirectory = false;
        }
        this.child.put(name, newNode);
        this.fileSize += fileSize;
    }

    public void addSize(int fileSize) {
        this.fileSize += fileSize;
    }

    public int countPart1(Node root) {
        //I will use bfs to iterate through all the nodes and those directory that has above
        int counter = 0;
        Set<Node> visited = new HashSet<>();
        //initial state
        Node initial = root;

        //fronter
        List<Node> queue = new ArrayList<>();
        queue.add(initial);

        while (!queue.isEmpty()) {
            Node currNode = queue.remove(0);

            if (visited.contains(currNode)) {
                continue;
            } else {
                visited.add(currNode);
            }
            if (currNode.isDirectory && currNode.fileSize <= 100000) {
                counter += currNode.fileSize;
            }

            currNode.child.forEach((key, value) -> queue.add(value));
        }

        return counter;
    }

    public int countPart2(Node root) {
        //I will use bfs to iterate through all the nodes and those directory that has above
        int min = root.fileSize;
        int unusedSpace = 70000000 - min; 
        Set<Node> visited = new HashSet<>();
        //initial state
        Node initial = root;

        //fronter
        List<Node> queue = new ArrayList<>();
        queue.add(initial);

        while (!queue.isEmpty()) {
            Node currNode = queue.remove(0);
            if (visited.contains(currNode)) {
                continue;
            } else {
                visited.add(currNode);
            }
            
            if (currNode.isDirectory) {
                if (currNode.fileSize + unusedSpace >= 30000000) {
                    min = (int) Math.min(min, currNode.fileSize);
                }
            }

            currNode.child.forEach((key, value) -> queue.add(value));
        }

        return min;
    }
}
