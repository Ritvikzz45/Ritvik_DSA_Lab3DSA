package binary_searchtree;

import java.util.*;

public class pairs_in_tree {
    // node class structure
    static class Node {
        int data;
        Node left, right;
    };

    // utility function that returns the new node
    static Node NewNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    // inserting node at correct position in BST
    static Node insert(Node root, int key) {
        if (root == null)
            return NewNode(key);
        if (key < root.data)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);
        return root;
    }

    static boolean findpairUtil(Node root, int sum, HashSet<Integer> set) {
        // base case
        if (root == null)
            return false;

        if (findpairUtil(root.left, sum, set))
            return true;

        if (set.contains(sum - root.data)) {
            System.out.println("Pair is found (" + (sum - root.data) + ", " + root.data + ")");
            return true;
        } else
            set.add(root.data);

        return findpairUtil(root.right, sum, set);
    }

    static void findPair(Node root, int sum) {
        HashSet<Integer> set = new HashSet<Integer>();
        if (!findpairUtil(root, sum, set))
            System.out.print("Pairs do not exist \n");
    }

    // Driver code to test above function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;

        System.out.print("Enter the number of elements in the BST: ");
        int n = scanner.nextInt();

        System.out.print("Enter the elements of the BST: ");
        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            root = insert(root, element);
        }

        System.out.print("Enter the sum to find pairs: ");
        int sum = scanner.nextInt();

        findPair(root, sum);
    }

    
}
 
 