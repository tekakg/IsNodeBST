import java.util.*;

class Node {
    private int data;
    private Node left;
    private Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    int getData() {
        return data;
    }

    Node getLeft() {
        return left;
    }

    Node getRight() {
        return right;
    }

    void setLeft(Node leftNode) {
        this.left = leftNode;
    }

    void setRight(Node rightNode) {
        this.right = rightNode;
    }


}

class SelfBinaryTree {
    Node root;

    SelfBinaryTree() {

    }

    Node CreateBinaryTree() {
        Scanner src = new Scanner(System.in);
        int val = src.nextInt();
        if (val != -1)
            root = new Node(val);
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (queue.size() > 0) {
            val = src.nextInt();
            Node top = queue.getFirst();
            queue.removeFirst();
            if (val != -1) {
                top.setLeft(new Node(val));
                queue.add(top.getLeft());
            }
            val = src.nextInt();
            if (val != -1) {
                top.setRight(new Node(val));
                queue.add(top.getRight());
            }
        }
        return root;
    }

    void PrintBinaryTree(Node head) {
        if (head == null)
            return;
        System.out.println(head.getData());
        PrintBinaryTree(head.getLeft());
        PrintBinaryTree(head.getRight());
    }
}

class Bst {
    public static boolean isBST(Node head, int leftVal, int rightVal) {
        if (head == null) return true;
        if (head.getData() < leftVal || head.getData() > rightVal) return false;
        return isBST(head.getLeft(), Integer.min(leftVal, head.getData()), head.getData()) &&
                isBST(head.getRight(), head.getData(), Integer.max(rightVal, head.getData()));
    }

}


public class Main {
    public static void main(String[] args) {
        SelfBinaryTree NewTree = new SelfBinaryTree();
        Node head = NewTree.CreateBinaryTree();
        NewTree.PrintBinaryTree(head);
        System.out.println(Bst.isBST(head, Integer.MIN_VALUE, Integer.MAX_VALUE));


    }
}
