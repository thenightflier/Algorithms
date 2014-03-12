import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by usman on 09/03/2014.
 */
public class Solver {

    private static List<Item> items;

    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("/Users/usman/IdeaProjects/Algorithms/Knapsack/src/main/resources", "ks_19_0");
        items = getItems(path);
        Collections.sort(items);
        System.out.println(items);
        int capacity = getCapacity(path);
        int estimate = getEstimate(items);
        Node parent = new Node(new ArrayList<Item>(), estimate, capacity, 0);
        Node best = solve(0, parent, parent);
        System.out.println(best);
    }

    private static int getEstimate(List<Item> items) {
        int estimate = 0;
        for (Item item : items) {
            estimate = estimate + item.getValue();
        }
        return estimate;
    }

    public static List<Item> getItems(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
        System.out.println(lines);
        List<Item> items = new ArrayList<Item>();
        int capacity = 0;
        for (int i = 1; i < lines.size(); i++) {
            String line[] = lines.get(i).split(" ");
            items.add(new Item(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }
        System.out.println(items);
        return items;
    }

    public static int getCapacity(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
        String first = lines.get(0);
        int capacity = Integer.parseInt(first.split(" ")[1]);
        System.out.println(capacity);
        return capacity;
    }

    public static Node solve(int currentItemIndex, Node parent, Node best) {
        if (currentItemIndex >= items.size()) {// no more node to visit
            return parent;
        }
//        visited.add(parent);
        Item currentItem = items.get(currentItemIndex);
        int newEstimate = parent.getEstimate() - currentItem.getValue();
        Node rightChild = new Node(parent.getItems(), newEstimate, parent.getRoom(), parent.getValue());
        int newRoom = parent.getRoom() - currentItem.getWeight();
        int newValue = parent.getValue() + currentItem.getValue();
        List<Item> items = Lists.newArrayList(parent.getItems());
        items.add(currentItem);
        Node leftChild = new Node(items, parent.getEstimate(), newRoom, newValue);// selected item
        List<Node> children = new LinkedList<Node>();
        children.add(leftChild);
        children.add(rightChild);
        for (Node node : children) {
//            if (!visited.contains(node)) {
            if (node.getRoom() > 0 && node.getEstimate() > best.getValue()) {
                Node node1 = solve(currentItemIndex + 1, node, best);
                best = node1.compareTo(best) < 0 ? best : node1;
            }

//            }
        }
        return best;


    }

    private static Node bestNode(Node best, Node leftChild, Node rightChild) {
        if (best == null) {
            return leftChild.compareTo(rightChild) < 0 ? rightChild : leftChild;
        } else {
            if (leftChild.compareTo(rightChild) < 0) {
                return rightChild.compareTo(best) < 0 ? best : rightChild;
            } else {
                return leftChild.compareTo(best) < 0 ? best : leftChild;
            }
        }

    }


    static class Node implements Comparable<Node> {
        private int value;
        private int room;
        private int estimate;
        private List<Item> items;

        Node(List<Item> items, int estimate, int room, int value) {
            this.items = items;
            this.estimate = estimate;
            this.room = room;
            this.value = value;
        }

        public List<Item> getItems() {
            return items;
        }

        public int getValue() {
            return value;
        }

        public int getRoom() {
            return room;
        }

        public int getEstimate() {
            return estimate;
        }

        @Override
        public int compareTo(Node o) {
            return ComparisonChain.start().compare(value, o.getValue()).compare(room, o.room).result();
        }


        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("value ", value)
                    .add("room", room)
                    .add("estimate ", estimate)
                    .addValue(items)
                    .toString();
        }
    }

    static class Item implements Comparable<Item> {
        private final int weight;
        private final int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public int getValue() {
            return value;
        }

        public double getDensity() {
            return value / weight;
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this).add("weight", weight).add("value", value).toString();
        }

        @Override
        public int compareTo(Item o) {
            return ComparisonChain.start()
                    .compare(getDensity(), o.getDensity())
                    .compare(value, o.value)
                    .compare(weight, o.weight)
                    .result();

        }
    }
}