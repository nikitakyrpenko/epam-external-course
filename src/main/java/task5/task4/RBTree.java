package task5.task4;

import java.util.List;
import java.util.Map;

public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        K key;
        V value;
        Node left, right;
        boolean color;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }

    public Node root;

    private int size;

    public RBTree(Map<K,V> entries) {
        root = null;
        size = 0;
        for (K entry : entries.keySet())
            this.add(entry, entries.get(entry));
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }

        return node.color;
    }


    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;

        return x;
    }

    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;

        return x;
    }

    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = BLACK;
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    private Node getNode(Node node, K key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else { // if key.compareTo(node.key) > 0
            return getNode(node.right, key);
        }
    }

    private Node minimum(Node node) {

        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }

        return null;
    }

    private Node remove(Node node, K key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {//key.compareTo(node.key) == 0
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;

            return successor;

        }
    }
    /*
    * print left child
    * print root
    * print right child
    */
    private void inOrderTraversing(Node node) {
        if (node != null) {
            inOrderTraversing(node.left);
            System.out.println("Node key : " + node.key + "; " + "Node value : " + node.value);
            inOrderTraversing(node.right);
        }
    }

    /*
    * print left child
    * print right child
    * print root
    */
    private void postOrderTraversing(Node node) {
        if (node != null) {
            postOrderTraversing(node.left);
            postOrderTraversing(node.right);
            System.out.println("Node key : " + node.key + "; " + "Node value : " + node.value);
        }
    }

    /*
    * print root
    * print left child
    * print right child
    */
    private void preOrderTraversing(Node node) {
        if (node != null) {
            System.out.println("Node key : " + node.key + "; " + "Node value : " + node.value);
            preOrderTraversing(node.left);
            preOrderTraversing(node.right);
        }
    }

    public void preOrderTraversing() {
        System.out.println("\t Pre order traversing : ");
        preOrderTraversing(root);
    }

    public void postOrderTraversing(){
        System.out.println("\t Post order traversing : ");
        postOrderTraversing(root);
    }

    public void inOrderTraversing(){
        System.out.println("\t In order traversing : ");
        inOrderTraversing(root);
    }




    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }
}