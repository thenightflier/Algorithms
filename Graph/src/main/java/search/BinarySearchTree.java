package search;

/**
 * Created by usman on 16/03/2014.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;

    public boolean isBinarySearchTree(Node root) {
        return isBinarySearchTree(root, null, null);
    }

    private boolean isBinarySearchTree(Node root, Key min, Key max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.key.compareTo(min) < 0) {
            return false;
        }
        if (max != null && root.key.compareTo(max) > 0) {
            return false;
        }

        return isBinarySearchTree(root.left, min, root.key) && isBinarySearchTree(root.right, root.key, max);
    }

    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    public Key ceil(Key key) {
        Node node = ceil(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    private Node ceil(Node root, Key key) {
        if (root == null) {
            return null;
        }
        int comparison = root.key.compareTo(key);
        if (comparison == 0) {
            return root;
        }
        if (comparison < 0) {
            return ceil(root.right, key);
        }
        Node node = ceil(root.left, key);
        if (node != null) {
            return node;
        }
        return root;
    }

    private Node floor(Node root, Key key) {
        if (root == null) {
            return null;
        }
        int comparison = root.key.compareTo(key);
        if (comparison == 0) {
            return root;
        }
        if (comparison > 0) {
            return floor(root.left, key);
        }
        Node node = floor(root.right, key);
        if (node != null) {
            return node;
        }
        return root;
    }

    public Value get(Key key) {

        return get(root, key);
    }

    public Key minimum() {
        if (root == null) {
            return null;
        }
        return minimum(root).getKey();
    }

    public Key maximum() {
        if (root == null) {
            return null;
        }
        return maximum(root).key;
    }

    private Node maximum(Node root) {
        if (root.right == null) {
            return root;
        }
        return maximum(root.right);
    }

    private Node minimum(Node root) {
        if (root.left == null) {
            return root;
        }
        Node min = minimum(root.left);
        return min;
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
