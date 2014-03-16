package search;

/**
 * Created by usman on 16/03/2014.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;


    public Value get(Key key) {

        return get(root, key);
    }

    private Value get(Node root, Key key) {
        if (key == null) {
            return null;
        }
        int comparison = key.compareTo(root.getKey());
        if (comparison < 0) {
            return get(root.getLeft(), key);
        } else if (comparison > 0) {
            return get(root.getRight(), key);
        } else {
            return root.value;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node root, Key key, Value value) {
        if (root == null) {
            return new Node(key, value, 1);
        }
        int comparison = key.compareTo(root.getKey());
        if (comparison < 0) {
            root.setLeft(put(root.getLeft(), key, value));
        } else if (comparison > 0) {
            root.setRight(put(root.getRight(), key, value));
        } else {
            root.setValue(value);// overwrite the old value
        }
        int size = size(root.left) + size(root.right) + 1;
        root.setSize(size);
        return root;
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            return root.size;
        }
    }


    private class Node {
        private final Key key;
        private Value value;
        private Node left;
        private Node right;
        private int size;

        private Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }

        public Key getKey() {
            return key;
        }

        public Value getValue() {
            return value;
        }

        public void setValue(Value value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
}
