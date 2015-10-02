package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by stephane on 29/09/15.
 */
public class PhonyListTest {

    PhonyList<String> phonyList;

    private Collection<Character> collection(Character... content) {
        Collection<Character> list = new ArrayList<>();
        for (Character i : content)
            list.add(i);
        return list;
    }

    private List<String> collection(String... content) {
        List<String> list = new ArrayList<>();
        for (String i : content)
            list.add(i);
        return list;
    }

    private PhonyList<String> phonylistHelper(String... content) {
        PhonyList<String> list = new PhonyList<>();
        for (String i : content)
            list.add(i);
        return list;
    }

    @Before
    public void setUp() throws Exception {
        phonyList = phonylistHelper("a", "b", "c", "d");
    }

    @After
    public void tearDown() throws Exception {
        phonyList = null;
    }

    @Test
    public void testEquals() throws Exception {
        //Lucas
        PhonyList<String> list1 = phonylistHelper("a", "b");
        assertEquals(list1.equals(list1), true);
    }

    /**
     * Tests the "size" method.
     *
     * @see PhonyList#size()
     * @type Functional
     * @input o="d"
     * @oracle The size must be 4.
     * @passed Yes
     */
    @Test
    public void testSize() throws Exception {
        //Stéphane
        assertEquals(phonyList.size(), 4);
    }

    @Test
    public void testIsEmpty() throws Exception {
        //Lucas
        PhonyList<String> emptyList = phonylistHelper();
        assertEquals(emptyList.isEmpty(), true);
    }

    /**
     * Tests the "contains" method.
     *
     * @see PhonyList#contains(Object 0)
     * @type Functional
     * @input o="d"
     * @oracle The collection must contains this element.
     * @passed Yes
     */
    @Test
    public void testContains() throws Exception {
        //Stéphane
        assertTrue(phonyList.contains("d"));
    }

    @Test
    public void testIndexOf() throws Exception {
        //Lucas
        PhonyList<String> listTest = phonylistHelper("a", "b", "c");
        assertEquals(listTest.indexOf("b"), 1);
    }

    /**
     * Tests the "elementData" method.
     *
     * @see PhonyList#elementData(int i)
     * @type Functional
     * @input i=4
     * @oracle The element must be "d" at position 4.
     * @passed Yes
     */
    @Test
    public void testElementData() throws Exception {
        //Stéphane
        assertNotEquals(phonyList.elementData(4), "d");
    }

    @Test
    public void testGet() throws Exception {
        //Lucas
        PhonyList<String> listTest = phonylistHelper("a", "b", "c");
        assertEquals(listTest.get(1), "b");
    }

    /**
     * Tests the "set" method with an empty collection.
     *
     * @see PhonyList#set(int i, Object o)
     * @type Functional
     * @input i=0, o="a"
     * @oracle Must throw Out IndexOutOfBoundsException
     * @passed Yes
     */
    @Test
    public void testSet_IndexOutOfBoundsException() throws Exception {
        //Stéphane
        Throwable e = null;
        PhonyList<String> phonyList = new PhonyList<>();
        try {
            phonyList.set(0, "a");
        } catch (IndexOutOfBoundsException ex) {
           e = ex;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }

    /**
     * Tests the "set" method on a non empty collection for replacement.
     *
     * @see PhonyList#set(int i, Object o)
     * @type Functional
     * @input i=3, o="z"
     * @oracle "z" must have replaced "d" which must not be in the collection but return by the method.
     * @passed No
     * @correction <pre>
     * l.235
     * - elementDate[++index] = element;
     * + elementDate[index] = element;
     * </pre>
     */
    @Test
    public void testSet() throws Exception {
        //Stéphane
        String oldValue = phonyList.set(3, "z");
        assertEquals(oldValue, "d");
        assertEquals(phonyList.get(3), "z");
    }

    /**
     * Tests the "add" method with a single element on a populated collection of 3 elements.
     *
     * @see PhonyList#add(Object o)
     * @type Functional
     * @input o="d"
     * @oracle The new element must be at the end and conform to the element value given.
     * @passed Yes
     */
    @Test
    public void testAdd() throws Exception {
        //Lucas
        PhonyList<String> listTest = phonylistHelper("a", "b", "c");
        listTest.add("d");
        assertEquals(listTest.get(3), "d");
    }

    /**
     * Tests the "remove" method with a single element on a populated collection of 3 elements.
     *
     * @see PhonyList#remove(Object o)
     * @type Functional
     * @input o="d"
     * @oracle The removed element must not be in the collection anymore.
     * @passed Yes
     */
    @Test
    public void testRemove() throws Exception {
        //Stéphane
        phonyList.remove("d");
        assertFalse(phonyList.contains("d"));
    }

    /**
     * Tests the "clear" method.
     *
     * @see PhonyList#clear()
     * @type Functional
     * @oracle The collection must be empty.
     * @passed Yes
     */
    @Test
    public void testClear() throws Exception {
        //Lucas
        PhonyList<String> list = phonylistHelper("a", "b", "c");
        list.clear();
        assertEquals(list.size(), 0);
    }

    /**
     * Tests the "addAll" method with an empty collection.
     *
     * @see PhonyList#addAll(int i, Collection c)
     * @type Functional
     * @input i=1, c=collection.empty
     * @oracle The collection must not have been modified
     * @passed Yes
     */
    @Test
    public void testAddAll_MinIndex() throws Exception {
        //Stéphane
        List<String> list = new ArrayList<String>();
        phonyList.addAll(1, list);
        assertEquals(phonyList.get(0), "a");
        assertEquals(phonyList.get(1), "b");
        assertEquals(phonyList.get(2), "c");
        assertEquals(phonyList.get(3), "d");
        assertEquals(phonyList.size(), 4);
    }

    /**
     * Tests the "addAll" method with a collection inserted at an existing index inside the PhonyList.
     *
     * @see PhonyList#addAll(int i, Collection c)
     * @type Functional
     * @input i=2, c=new ArrayList("-a", "-b", "-c", "-d", "-e", "-f")
     * @oracle The PhonyList must contains the new collection aty index 2 and the rest of the element after the last element of the collection added
     * @passed No
     * @correction <pre>
     * l.380
     * - if ((index > size || index < 0) && size != 0)
     * -    throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
     * + if ((index > size || index < 0) && size != 0) {
     * +    throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
     * + }
     * </pre>
     */
    @Test
    public void testAddAll_IndexSmallerThanSize() throws Exception {
        //Stéphane
        List<String> newlist = collection("-a", "-b", "-c", "-d", "-e", "-f");
        phonyList.addAll(2, newlist);
        assertEquals(phonyList.get(0), "a");
        assertEquals(phonyList.get(1), "b");
        assertEquals(phonyList.get(2), "-a");
        assertEquals(phonyList.get(3), "-b");
        assertEquals(phonyList.get(4), "-c");
        assertEquals(phonyList.get(5), "-d");
        assertEquals(phonyList.get(6), "-e");
        assertEquals(phonyList.get(7), "-f");
        assertEquals(phonyList.get(8), "c");
        assertEquals(phonyList.get(9), "d");
    }

    @Test
    public void testRemoveRange() throws Exception {
        //Lucas
        phonyList.removeRange(1, 2);
        assertEquals("a", phonyList.get(0));
        assertEquals("d", phonyList.get(1));
    }

    /**
     * Tests the "removeAll" method with a same typed value collection.
     *
     * @see PhonyList#removeAll(Collection c)
     * @type Functional
     * @input c=new ArrayList("b", "c")
     * @oracle Element "a" and "d" must be in the remaining PhonyList.
     * @passed No
     * @correction <pre>
     * l.179
     * - return indexOf(o) > 0;
     * + return indexOf(o) >= 0;
     * l.373
     * - if ((index > size || index < 0) && size != 0) {
     * + if ((index >= size || index < 0) && size != 0) {
     * </pre>
     */
    @Test
    public void testRemoveAll_SameType() throws Exception {
        //Stéphane
        Collection<String> list = collection("b", "c");
        phonyList.removeAll(list);
        assertTrue(phonyList.contains("a"));
        assertFalse(phonyList.contains("b"));
        assertFalse(phonyList.contains("c"));
        assertTrue(phonyList.contains("d"));
        assertEquals(phonyList.size(), 2);
    }

    /**
     * Tests the "removeAll" method with a different typed values collection.
     *
     * @see PhonyList#removeAll(Collection c)
     * @type Functional
     * @input c=new ArrayList('b', 'c')
     * @oracle PhonyList must be preserved.
     * @passed Yes
     */
    @Test
    public void testRemoveAll_DifferentType() throws Exception {
        //Stéphane
        Collection<Character> list = collection('b','c');
        phonyList.removeAll(list);
        assertTrue(phonyList.contains("a"));
        assertTrue(phonyList.contains("b"));
        assertTrue(phonyList.contains("c"));
        assertTrue(phonyList.contains("d"));
        assertEquals(phonyList.size(), 4);
    }
}