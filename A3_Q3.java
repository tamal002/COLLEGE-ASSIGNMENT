import java.util.*;


class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class TreeBuilder {
    static Node buildTree(int[] preorder, int preStart, int preEnd,
            int[] inorder, int inStart, int inEnd,
            HashMap<Integer, Integer> map) {

        if (preStart > preEnd || inStart > inEnd)
            return null;

        int rootVal = preorder[preStart];
        Node root = new Node(rootVal);

        int inRootIndex = map.get(rootVal);
        int numsLeft = inRootIndex - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft,
                inorder, inStart, inRootIndex - 1, map);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd,
                inorder, inRootIndex + 1, inEnd, map);

        return root;
    }
}

public class A3_Q3 {
    // Helper to print cousins (nodes at same depth > 1)
    public static void printCousins(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (level > 0) {
                    currentLevel.add(curr.data);
                }

                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            }

            if (currentLevel.size() >= 2) {
                System.out.println("Cousins at level " + level + ": " + currentLevel);
            }

            level++;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int n = input.nextInt();

        int[] inorder = new int[n];
        int[] preorder = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        System.out.print("Enter inorder sequence: ");
        for (int i = 0; i < n; i++) {
            inorder[i] = input.nextInt();
        }

        System.out.print("Enter preorder sequence: ");
        for (int i = 0; i < n; i++) {
            preorder[i] = input.nextInt();
            map.put(inorder[i], i); // Inorder index map is required
        }

        Node root = TreeBuilder.buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, map);

        System.out.println("\nCousins in the tree:");
        printCousins(root);
        input.close();
    }
}