package datastructures;

import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by usman on 03/03/2014.
 */
public class PriorityQueueImp<E extends Comparable<E>> implements Iterable<E> {

    private E keys[];

    // insert
    // deleteMax
    // isEmpty;
    private int size = 0;
    private Comparator<E> comparator;


    public PriorityQueueImp(int maximumSize) {
        keys = (E[]) new Comparable[maximumSize + 1];// 0 index is unused
    }

    public PriorityQueueImp(int maximumSize, Comparator<E> comparator) {
        keys = (E[]) new Comparable[maximumSize + 1];// 0 index is unused
        this.comparator = comparator;
    }

    public static void main(String[] args) {
        Ordering<Integer> natural = new Ordering<Integer>() {
            @Override
            public int compare(Integer integer, Integer integer2) {
                return integer.compareTo(integer2);
            }
        };
        PriorityQueueImp<Integer> pq = new PriorityQueueImp<Integer>(10, natural.reverse());
        pq.insert(4);
        pq.insert(3);
        pq.insert(1);
        pq.insert(8);
        pq.insert(2);
        pq.insert(5);
        printPriorityQueue(pq);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        printPriorityQueue(pq);
    }

    private static void printPriorityQueue(PriorityQueueImp<Integer> pq) {
        Iterator<Integer> it = pq.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (next != null) {
                System.out.println("it = " + next);
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(E element) {
        keys[++size] = element;
        swim(size);
    }

    private void swim(int currentPosition) {
        int parent = currentPosition / 2;
        while (parent > 0 && isPrefferedOver(currentPosition, parent)) {
            exchange(currentPosition, parent);
            currentPosition = parent; // jump to parent
            parent = parent / 2;
        }
    }

    private void exchange(int size, int i) {
        E temp = keys[size];
        keys[size] = keys[i];
        keys[i] = temp;
    }

    private boolean isPrefferedOver(int currentPosition, int i) {
        if (comparator == null) {
            return less(currentPosition, i);
        } else {
            return comparator.compare(keys[currentPosition], keys[i]) < 0;
        }
    }

    private boolean less(int size, int i) {
        return keys[size].compareTo(keys[i]) < 0;
    }

    public E poll() {
        E root = keys[1];
        exchange(1, size);
        keys[size] = null;
        size--;
        sink(1);
        return root;
    }

    private void sink(int currentIndex) {
        while (2 * currentIndex < size) {
            int leftIndex = 2 * currentIndex;
            int rightNext = leftIndex + 1;
            if (leftIndex < size && isPrefferedOver(leftIndex, rightNext)) {//right is less than left
                if (isPrefferedOver(leftIndex, currentIndex)) {
                    exchange(currentIndex, leftIndex);
                    currentIndex = leftIndex;
                } else {
                    break;
                }

            } else if (leftIndex < size && isPrefferedOver(rightNext, leftIndex)) {
                if (isPrefferedOver(rightNext, currentIndex)) {
                    exchange(currentIndex, rightNext);
                    currentIndex = rightNext;
                } else {
                    break;
                }

            } else {
                break;
            }
        }
    }

    @Override
    public Iterator iterator() {
        return Iterators.forArray(keys);
    }
}
