package Tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.setLeftnode(treeNode2);
        treeNode1.setRightnode(treeNode3);
        treeNode2.setLeftnode(treeNode4);
        treeNode2.setRightnode(treeNode5);
        treeNode5.setLeftnode(treeNode6);
        treeNode5.setRightnode(treeNode7);

        BinaryTree binaryTree = new BinaryTree(treeNode1);
        binaryTree.preOrder();
        System.out.println("**************");
        binaryTree.middleOrder();
        System.out.println("**************");
        binaryTree.afterOrder();

    }
}

class BinaryTree{
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }
    //εεΊιε
    public void preOrder(){
        root.preOrder();
    }
    public void middleOrder(){
        root.middleOrder();
    }
    public void afterOrder(){
        root.afterOrder();
    }

}
class TreeNode{
    private int id;
    private String name;
    private TreeNode leftnode;
    private TreeNode rightnode;

    public TreeNode(int id) {
        this.id = id;
    }

    public TreeNode getLeftnode() {
        return leftnode;
    }

    public void setLeftnode(TreeNode leftnode) {
        this.leftnode = leftnode;
    }

    public TreeNode getRightnode() {
        return rightnode;
    }

    public void setRightnode(TreeNode rightnode) {
        this.rightnode = rightnode;
    }

    public TreeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //εεΊιε ηΆε·¦ε³
    public void preOrder(){
        System.out.println(this);
        if (this.leftnode != null){
            this.leftnode.preOrder();
        }
        if (this.rightnode != null){
            this.rightnode.preOrder();
        }
    }

    //δΈ­εΊιε ε·¦ηΆε³
    public void middleOrder(){
        if (this.leftnode != null){
            this.leftnode.middleOrder();
        }
        System.out.println(this);
        if (this.rightnode != null){
            this.rightnode.middleOrder();
        }
    }

    public void afterOrder(){
        if (this.leftnode != null){
            this.leftnode.afterOrder();
        }

        if (this.rightnode != null){
            this.rightnode.afterOrder();
        }
        System.out.println(this);
    }

}