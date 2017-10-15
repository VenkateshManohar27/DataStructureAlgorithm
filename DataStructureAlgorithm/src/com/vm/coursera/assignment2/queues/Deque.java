package com.vm.coursera.assignment2.queues;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double-ended queue or deque is a generalization of a stack and a queue that
 * supports adding and removing items from either the front or the back of the
 * data structure.
 * 
 * @author Venkatesh Manohar
 *
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {
    /**
     * Points to the first element of the queue.
     */
    private Node first = null;
    /**
     * Points to the last element of the queue.
     */
    private Node last = null;
    /**
     * latest size of the queue.
     */
    private int count = 0;

    /**
     * 
     * @author Venkatesh Manohar
     *
     */
    private class Node {
        /**
         * Previous node reference.
         */
        Node prev;
        /**
         * Next node reference.
         */
        Node next;
        /**
         * The item which refers to actual value.
         */
        Item item;

        /**
         * 
         * @param value
         *            - The value of the new node.
         */
        Node(final Item value) {
            this.item = value;
        }
    }

    /**
     * Constructor.
     */
    public Deque() {
        super();
    }

    /**
     * 
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 
     * @return the number of items on the deque
     */
    public int size() {
        return count;
    }

    /**
     * add the item to the front.
     * 
     * @param item
     *            - the value to be added
     */
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        Node node = new Node(item);
        if (count == 0) {
            first = node;
            last = node;
            count++;
        } else {
            first.prev = node;
            node.next = first;
            first = node;
            count++;
        }
    }

    /**
     * add the item to the end.
     * 
     * @param item
     *            the value to be added
     */
    public void addLast(final Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        Node node = new Node(item);
        if (count == 0) {
            first = node;
            last = node;
            count++;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
            count++;
        }
    }

    /**
     * remove and return the item from the front.
     * 
     * @return
     */
    public Item removeFirst() {
        if (count == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        Item item = first.item;
        Node tobeRemoved = first;
        first = first.next;
        if (first != null) {
            first.prev = null;
        }
        tobeRemoved.next = null;
        count--;
        if (count == 0) {
            first = null;
            last = null;
        }
        return item;
    }

    /**
     * remove and return the item from the end.
     * 
     * @return
     */
    public Item removeLast() {
        if (count == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        Item item = last.item;
        Node tobeRemoved = last;
        last = last.prev;
        if (last != null) {
            last.next = null;
        }
        tobeRemoved.prev = null;
        count--;
        if (count == 0) {
            first = null;
            last = null;
        }
        return item;
    }

    /**
     * return an iterator over items in order from front to end.
     * 
     */
    public Iterator<Item> iterator() {

        return new ListIterator();
    }

    /**
     * 
     * @author Venkatesh Manohar
     *
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * Iteration starts from first to last hence current is initiated to
         * first node.
         */
        private Node current = first;

        /**
         * @return true if the list has a next element.
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Remove is not supported.
         */
        public void remove() {
            throw new UnsupportedOperationException(
                    "Operation is not supported!!");
        }

        /**
         * @return the next element in the queue.
         * @throws NoSuchElementException
         *             if the queue is empty or current is null.
         */
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException("Queue is empty");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}