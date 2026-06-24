import java.util.*;

class Node {
    public int data;
    public Node right;
    public Node left;

    public Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }
}

class BinarySearchTree {
    Node root = null;

    public Node insert(Node root, int data) {
        if(root == null) {
            Node newNode = new Node(data);
            root = newNode;
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        }

        else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public Node delete(Node root, int key) {
        if(root == null) {
            return null;
        }

        // Search
        if(key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            // Case 1 and 2 (No leaf or 1 leaf)
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } 
            
            // Case 3 (two nodes)
            else {
                Node successor = minimum(root.right);
                root.data = successor.data;
                root.right = delete(root.right, successor.data);
            }

        }

        return root;
    }

    public void inorder(Node root) {
        
        if(root!=null) {
            inorder(root.left);
            System.out.print(root.data+" --> ");
            inorder(root.right);
        }   
    }

    public void preorder(Node root) {
        if(root!=null) {
            System.out.print(root.data+" --> ");
            preorder(root.left);
            preorder(root.right);
        } 
    }
    
    public void postorder(Node root) {
        if(root!=null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" --> ");
        }
    }

    public static Node minimum(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        System.out.println("Minimum element: "+root.data);
        return root;
    }

    public static void maximum(Node root) {
        while(root.right != null) {
            root = root.right;
        }
        System.out.println("Maximum element: "+root.data);
    }

    public void count(Node root) {

    }

    public void sumNodes(Node root) {

    }

    public void minDepth(Node root) {

    }

    public void maxDepth(Node root) {

    }
}



public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        int data;

        while(true) {
            System.out.println("\n\nOptions: ");
            System.out.println("1. Insert \n2. Delete \n3. Inorder \n4. Preorder \n5.Postorder \n6. Minimum \n7. Maximum \n8. Exit");
            System.out.print("\nEnter Operation: ");
            int choice = sc.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter value to insert: ");
                    data = sc.nextInt();
                    System.out.println();
                    tree.root = tree.insert(tree.root, data);
                    break;
                case 2:
                    System.out.print("\nEnter value to delete: ");
                    data = sc.nextInt();
                    System.out.println();
                    tree.root = tree.delete(tree.root, data);
                    break;
                case 3:
                    System.out.println("Inorder Traversal: ");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Preorder Traversal");
                    tree.preorder(tree.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Postorder Traversal");
                    tree.postorder(tree.root);
                    System.out.println();
                    break;
                case 6:
                    tree.minimum(tree.root);
                    System.out.println();
                    break;
                case 7:
                    tree.maximum(tree.root);
                    System.out.println();
                    break;
                case 8:
                    end = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

            if(end) {
                break;
            }
        }
        sc.close();
    }
}
