package deque;

/**
 * A deque implemented using a doubly-linked chain.
 *
 * @param <T>
 *            The type of elements contained in the deque.
 *
 * @author Navanit Krishna Satish Kumar 906706354
 * @version 10.18.2024
 */
public class Lab08Deque<T> extends DLinkedDeque<T> {

    /**
     * Inserts a new item at the front of the deque.
     * 
     * @param newEntry
     *            the item to insert.
     */
    public void addToFront(T newEntry) {
        DLNode<T> newNode = new DLNode<>(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        }
        else {
            newNode.setNextNode(firstNode);
            firstNode.setPreviousNode(newNode);
            firstNode = newNode;
        }
        size++;
    }

    /**
     * Insert a new item at the rear of the deque.
     * 
     * @param newEntry
     *            the item to insert.
     */
    public void addToBack(T newEntry) {
        DLNode<T> newNode = new DLNode<>(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        }
        else
        {
            newNode.setPreviousNode(lastNode);
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        }
        size++;
    }
    
    /**
     * Remove the item at the front of the deque.
     * 
     * @return The item that was removed
     * @throws EmptyQueueException
     *             if there is not an element at the front
     */
    public T removeFront() {
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty");
        }
        T frontData = firstNode.getData();
        firstNode = firstNode.getNextNode();
        if (firstNode == null) {
            lastNode = null;
        }
        else
        {
            firstNode.setPreviousNode(null);
        }
        size--;
        return frontData;
    }

    /**
     * Remove the item at the rear of the deque.
     * 
     * @return The item that was removed
     * @throws EmptyQueueException
     *             if there is no element at the front
     */
    public T removeBack() {
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty");
        }
        T backData = lastNode.getData();
        lastNode = lastNode.getPreviousNode();
        if (lastNode == null) {
            firstNode = null;
        }
        else
        {
            lastNode.setNextNode(null);
        }
        size--;
        return backData;
    }

    /**
     * Get the item at the front (the head) of the deque. Does not alter the
     * deque.
     * 
     * @return the item at the front of the deque.
     * @throws EmptyQueueException
     *             if no element at the front
     */
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty");
        }
        return firstNode.getData();
    }

    /**
     * Get the item at the rear (the tail) of the deque. Does not alter the
     * deque.
     * 
     * @return the item at the rear of the deque.
     * @throws EmptyQueueException
     *             if no element at rear
     * 
     */
    public T getBack() {
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty");
        }
        return lastNode.getData();
    }

    /**
     * Check if the deque is empty
     * 
     * @return true if the deque has no items
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Empty the deque.
     */
    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * Returns a string representation of this deque. A deque's string
     * representation is written as a comma-separated list of its contents (in
     * front-to-rear order) surrounded by square brackets, like this:
     * 
     * [52, 14, 12, 119, 73, 80, 35]
     * 
     * An empty deque is simply [].
     *
     * @return a string representation of the deque
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        DLNode<T> p = firstNode;
        while (p != null) {
            if (s.length() > 1) {
                s.append(", ");
            }
            s.append(p.getData());
            p = p.getNextNode();
        }
        s.append("]");
        return s.toString();
    }

}
