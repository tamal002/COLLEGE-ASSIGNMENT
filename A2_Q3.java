import java.util.*;
import java.lang.*;
import java.io.*;

class A2_Q3 {
    static class Node {
        public int data;
        public Node left;
        public Node right;

        // CONSTRUCTOR
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node insertNode(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.left != null) {
                q.add(temp.left);
            } else {
                temp.left = new Node(data);
                return root;
            }

            if (temp.right != null) {
                q.add(temp.right);
            } else {
                temp.right = new Node(data);
                return root;
            }
        }
        return root;
    }

    static void findPath(Node root, ArrayList<Integer> list) {
        // BASE CASE
        if (root == null)
            return;
        if(root.data == -1) return;
        else list.add(root.data);
        if (root.left == null && root.right == null) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            findPath(root.left, list);
            findPath(root.right, list);
        }
        list.remove(list.size() - 1);
    }

    static void printRootToLeaf(Node root) {
        if (root == null) {
            System.out.println("Empty.");
            return;
        }

        ArrayList<Integer> list = new ArrayList<>();
        findPath(root, list);
    }

    // INPUT = [1, 2, 3, NULL(-1), 5]
    public static void main(String[] args) throws java.lang.Exception {
        Scanner input = new Scanner(System.in);
        Node root = null;

        // System.out.print("Before insertion : ");
        // printRootToLeaf(root);
        int n;
        System.out.print("enter the numnber of nodes: ");
        n = input.nextInt();
        // (-1) --> NULL
        for(int i = 0; i < n; i++){
            System.out.print("enter node: ");
            int node = input.nextInt();
            root = insertNode(root, node);
        }
        
        System.out.println("ROOT TO LEAF");
        printRootToLeaf(root);

        input.close();

    }
}
