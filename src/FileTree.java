public class FileTree {
    private Node root;
    private Node currentNode;

    FileTree() {
        this.root = new Node(0, "/");
        this.currentNode = this.root;
    }

    //insert directory
    public void insertDir(String name) {
        this.currentNode.insertChild(name, 0, true);
    }

    //insert file
    public void insertFile(String name, int fileSize) {
        this.currentNode.insertChild(name, fileSize, false);

        Node pointer = this.currentNode;
        pointer = pointer.goBack();
        while (pointer != null) {
            pointer.addSize(fileSize);
            pointer = pointer.goBack();
        }
    }


    //cd
    public void cdNext(String name) {
        this.currentNode = this.currentNode.getChild(name);
    }

    public void cdBack() {
        this.currentNode = this.currentNode.goBack();
    }

    public void cdRoot() {
        this.currentNode = this.root;
    }

    
    public int getPart1() {
        return this.root.countPart1(root);
    }
    
    public int getPart2() {
        return this.root.countPart2(root);
    }




    
}
