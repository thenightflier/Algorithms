package datastructures;

import static utils.AlgoUtil.exchange;
import static utils.AlgoUtil.less;

/**
 * Created by usman on 15/03/2014.
 */
public class PriorityQueueReplay {

    private final Comparable items[];
    private final int maximumSize;
    private int size = 0;

    public PriorityQueueReplay(int size) {
        this.items = new Comparable[size];

        maximumSize = size - 1;
    }

    public int getMaximumSize() {
        return maximumSize;
    }

    public void addItem(Comparable item) {
        items[++size] = item;
        swim(size);

    }

    public Comparable deleteMin() {
        if (!isEmpty()) {
            Comparable result = items[1];
            exchange(items, 1, size);
            items[size] = null;
            size--;
            sink(1);
            return result;
        } else {
            throw new IllegalStateException("Queue doesn't contain any item");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void sink(int currentIndex) {
        while (2 * currentIndex <= size) {
            int leftIndex = 2 * currentIndex;
            int childIndex = leftIndex;
            int rightIndex = leftIndex + 1;

            if (leftIndex < size && isRightChildLess(leftIndex)) {
                childIndex = rightIndex;
            }
            if (!less(items[childIndex], items[currentIndex])) {
                break;
            }
            exchange(items, currentIndex, childIndex);
            currentIndex = childIndex;
        }

    }

    private boolean isRightChildLess(int childIndex) {
        return less(items[childIndex + 1], items[childIndex]);
    }

    private void swim(int currentIndex) {
        while (currentIndex / 2 > 0) {
            if (less(items[currentIndex], items[currentIndex / 2])) {
                exchange(items, currentIndex, currentIndex / 2);
            } else {
                break;
            }
            currentIndex = currentIndex / 2;
        }
    }

    public Comparable[] getItems() {
        return items;
    }


}
