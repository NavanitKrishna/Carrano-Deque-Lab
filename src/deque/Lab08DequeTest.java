package deque;

import student.TestCase;

/**
 * Tests for the DLinkedDeque class.
 *
 * @author Navanit Krishna Satish Kumar 906706354
 * @version 10.18.2024
 */
public class Lab08DequeTest extends TestCase
{

    private Lab08Deque<String> deque;

    /**
     * Creates two new, empty sets for test methods
     */
    public void setUp()
    {
        deque = new Lab08Deque<String>();
    }
   
    /**
     * Tests addToFront method of Lab08Deque
     */
    public void testAddToFront()
    {
        deque.addToFront("first");
        assertEquals("first", deque.getFront());
        deque.addToFront("second");
        assertEquals("second", deque.getFront());
        assertEquals("first", deque.getBack());
        deque.addToFront("third");
        assertEquals("third", deque.getFront());
        assertEquals(3, deque.size());
    }

    /**
     * Tests addToBack method of Lab08Deque
     */
    public void testAddToBack()
    {
        deque.addToBack("first");
        assertEquals("first", deque.getBack());
        deque.addToBack("second");
        assertEquals("second", deque.getBack());
        assertEquals("first", deque.getFront());
        deque.addToBack("third");
        assertEquals("third", deque.getBack());
        assertEquals(3, deque.size());
    }

    /**
     * Tests removeFront method of Lab08Deque
     */
    public void testRemoveFront()
    {
        deque.addToFront("first");
        deque.addToFront("second");
        deque.addToFront("third");
        assertEquals(3, deque.size());
        String removed = deque.removeFront();
        assertEquals("third", removed);        
        assertEquals("second", deque.getFront());
        assertEquals(2, deque.size());
        removed = deque.removeFront();        
        assertEquals("second", removed);        
        assertEquals("first", deque.getFront());
        assertEquals(1, deque.size());
        removed = deque.removeFront();        
        assertEquals("first", removed);
        assertTrue(deque.isEmpty());        
        assertEquals(0, deque.size());
        Exception exception = null;
        try {
            deque.removeFront();
        }
        catch (EmptyQueueException e) {
            exception = e;
        }
        assertNotNull(exception);
    }
   
    /**
     * Tests removeBack method of Lab08Deque
     */
    public void testRemoveBack()
    {
        deque.addToBack("first");
        deque.addToBack("second");
        deque.addToBack("third");
        assertEquals(3, deque.size());
        String removed = deque.removeBack();
        assertEquals("third", removed);        
        assertEquals("second", deque.getBack());
        assertEquals(2, deque.size());
        removed = deque.removeBack();        
        assertEquals("second", removed);
        assertEquals("first", deque.getBack());
        assertEquals(1, deque.size());
        removed = deque.removeBack();
        assertEquals("first", removed);
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
        Exception exception = null;
        try {
            deque.removeBack();
        }
        catch (EmptyQueueException e) {
            exception = e;
        }
        assertNotNull(exception);
    }
   
    /**
     * Tests getFront method of Lab08Deque
     */
    public void testGetFront()
    {
        deque.addToBack("first");
        deque.addToBack("second");
        deque.addToBack("third");
        assertEquals("first", deque.getFront());
        deque.removeFront();
        assertEquals("second", deque.getFront());
        deque.removeFront();
        assertEquals("third", deque.getFront());
        deque.removeFront();
        assertTrue(deque.isEmpty());
        Exception exception = null;
        try {
            deque.getFront();
        }
        catch (EmptyQueueException e) {
            exception = e;
        }
        assertNotNull(exception);
    }

    /**
     * Tests getBack method of Lab08Deque
     */
    public void testGetBack()
    {
        deque.addToFront("first");
        deque.addToFront("second");
        deque.addToFront("third");
        assertEquals("first", deque.getBack());
        deque.removeBack();
        assertEquals("second", deque.getBack());
        deque.removeBack();
        assertEquals("third", deque.getBack());
        deque.removeBack();
        assertTrue(deque.isEmpty());
        Exception exception = null;
        try {
            deque.getBack();
        }
        catch (EmptyQueueException e) {
            exception = e;
        }
        assertNotNull(exception);
    }
   
    /**
     * Tests clear method of Lab08Deque
     */
    public void testClear()
    {
        deque.addToFront("first");
        deque.addToBack("second");
        deque.addToFront("third");
        assertFalse(deque.isEmpty());
        assertEquals(3, deque.size());
        deque.clear();
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
        Exception exception = null;
        try
        {
            deque.getFront();
        }
        catch (EmptyQueueException e)
        {
            exception = e;
        }
        assertNotNull(exception);
        exception = null;
        try
        {
            deque.getBack();
        }
        catch (EmptyQueueException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }
   
    /**
     * Tests toString Method of Lab08Deque
     */
    public void testToString()
    {
        assertEquals("[]", deque.toString());
        deque.addToBack("first");
        assertEquals("[first]", deque.toString());
        deque.addToBack("second");
        assertEquals("[first, second]", deque.toString());
        deque.addToFront("third");
        assertEquals("[third, first, second]", deque.toString());
        deque.addToFront("fourth");
        assertEquals("[fourth, third, first, second]", deque.toString());
        deque.clear();
        assertEquals("[]", deque.toString());
    }
   
    /**
     * Tests default constructor from EmptyQueueException
     */
    public void testEmptyQueueExceptionDefaultConstructor()
    {
        try
        {
            throw new EmptyQueueException();
        }
        catch (EmptyQueueException e)
        {
            assertNull(e.getMessage());
        }
    }


}
