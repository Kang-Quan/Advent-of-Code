package Day12;
public class NodeBFS {
    private int x;
    private int y;
    private int steps;
    private char letter;
    private NodeBFS parent;

    NodeBFS(int x, int y, int steps, char letter, NodeBFS parent) {
        this.x = x;
        this.y = y;
        this.steps = steps;
        this.letter = letter;
        this.parent = parent;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getSteps() {
        return this.steps;
    }

    public char getLetter() {
        return this.letter;
    }

    public NodeBFS getParent() {
        return this.parent;
    }
}
