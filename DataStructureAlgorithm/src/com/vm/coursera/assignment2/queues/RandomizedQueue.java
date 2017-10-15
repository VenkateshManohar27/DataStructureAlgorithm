package com.vm.coursera.assignment2.queues;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 * @author Venkatesh Manohar
 *
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    /**
     * Constant used to reduce the array size when the number of elements is
     * less than or equal to quarter.
     */
    private static final int QUARTER = 4;

    /**
     * Queue is implemented using arrays to ensure the performance requirements.
     */
    private Item[] queue;

    /**
     * The no of elements in the queue.
     */
    private int count = 0;

    /**
     * The pointer to last element in queue.
     */
    private int tail = -1;

    /**
     * construct an empty randomized queue.
     */
    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
    }

    /**
     * 
     * @return true if the queue is empty.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * @return the number of items on the randomized queue
     */
    public int size() {
        return count;
    }

    /**
     * add the item.
     * 
     * @param item
     *            value to be inserted
     * @throws java.lang.IllegalArgumentException
     *             if item is null
     */
    public void enqueue(final Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (tail == queue.length - 1) {
            resize(queue.length * 2, queue.length);
        }
        queue[++tail] = item;
        count++;
    }

    /**
     * resize the underlying array holding the elements.
     * 
     * @param capacity
     *            size of new array
     * @param maxIndex
     *            - The max no of elements to iterate while copying.
     */
    private void resize(final int capacity, final int maxIndex) {
        // textbook implementation
        Item[] temp = (Item[]) new Object[capacity];
        int index = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (queue[i] != null) {
                temp[index] = queue[i];
                index++;
            }
        }
        queue = temp;
        tail = index - 1;
    }

    /**
     * 
     * @return remove and return a random item
     * @throws java.util.NoSuchElementException
     *             if queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int random = 0;
        if (tail > 0) {
            random = StdRandom.uniform(tail);
        }
        Item item = queue[random];
        queue[random] = queue[tail];
        queue[tail] = null;
        tail--;
        count--;
        if (count > 0 && count == queue.length / QUARTER) {
            resize(queue.length / 2, queue.length);
        }
        return item;
    }

    /**
     * 
     * @return return a random item (but do not remove it)
     */
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        int random = StdRandom.uniform(count);
        
        return queue[random];
    }

    /**
     * @return an iterator over items in random order.
     */
    public Iterator<Item> iterator() {
        return new RandomQueueIterator<Item>();
    }

    /**
     * 
     * @author Venkatesh Manohar
     *
     * @param <Item>
     */
    private class RandomQueueIterator<Item> implements Iterator<Item> {
        /**
         * Array which holds to queued values in a random order.
         */
        private Item[] arr;
        /**
         * The current index of the array.
         */
        private int current = 0;

        /**
         * The constructors copy all the content of queue and shuffles the array
         * to return the values in random order.
         */
        public RandomQueueIterator() {
            copyQueue();
            StdRandom.shuffle(arr);
        }

        /**
         * Copies the contents of the queue to array.
         */
        private void copyQueue() {
            arr = (Item[]) new Object[count];
            for (int i = 0; i < count; i++) {
                arr[i] = (Item) queue[i];
            }

        }

        /**
         * @return true if the queue has a next element.
         */
        @Override
        public boolean hasNext() {
            return count > current;
        }

        /**
         * Remove is not supported.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /**
         * the next element in the random array.
         */
        @Override
        public Item next() {
            if (current == -1 || current == count) {
                throw new NoSuchElementException("No more items to return.");
            }
            Item item = arr[current];
            current++;
            return item;
        }

    }
}
