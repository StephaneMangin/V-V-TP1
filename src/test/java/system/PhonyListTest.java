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

    /**
     * Tests the "equals" method with a different typed instance.
     *
     * @see PhonyList#equals(Object o)
     * @type Functional
     * @input o=collection("e", "f", "g", "h")
     * @oracle The
     * @passed No
     * @correction
     * Add missing braces to conditions
     */
    @Test
    public void testNotEqualsDifferentTypedInstance() throws Exception {
        List<String> list = collection("e", "f", "g", "h");
        assertEquals(phonyList.equals(list), false);
    }
    /**
     * Tests the "equals" method with a new instance of the list but with different values.
     *
     * @see PhonyList#equals(Object o)
     * @type Functional
     * @input o=phonyListHelper("e", "f", "g", "h")
     * @oracle The
     * @passed Yes
     */
    @Test
    public void testNotEquals() throws Exception {
        PhonyList<String> list = phonylistHelper("e", "f", "g", "h");
        assertEquals(phonyList.equals(list), false);
    }

    /**
     * Tests the "equals" method with different lists lengths
     *
     * @see PhonyList#equals(Object o)
     * @type Functional
     * @input o=phonyListHelper("a", "b", "c" ,"d" ,"e")
     * @oracle The
     * @passed Yes
     */
    @Test
    public void testEqualsDifferentLength() throws Exception {
        //Lucas
        PhonyList<String> list = phonylistHelper("a", "b", "c", "d", "e");
        assertEquals(phonyList.equals(list), false);
    }

    /**
     * Tests the "equals" method with the same instance of the list.
     *
     * @see PhonyList#equals(Object o)
     * @type Functional
     * @input o=phonyList
     * @oracle The
     * @passed Yes
     */
    @Test
    public void testEqualsSameInstance() throws Exception {
        assertEquals(phonyList.equals(phonyList), true);
    }

    /**
     * Tests the "equals" method with a new instance of the list but with the same values.
     *
     * @see PhonyList#equals(Object o)
     * @type Functional
     * @input o=phonyListHelper("a", "b", "c", "d")
     * @oracle The
     * @passed Yes
     */
    @Test
    public void testEquals() throws Exception {
        PhonyList<String> list = phonylistHelper("a", "b", "c", "d");
        assertEquals(phonyList.equals(list), true);
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
        assertEquals(phonyList.size(), 4);
    }

    /**
     * Tests the "isEmpty" method.
     *
     * @see PhonyList#isEmpty()
     * @type Functional
     * @input empty list
     * @oracle The result should be true
     * @passed Yes
     */
    @Test
    public void testIsEmpty_true() throws Exception {
        PhonyList<String> emptyList = phonylistHelper();
        assertEquals(emptyList.isEmpty(), true);
    }

    /**
     * Tests the "isEmpty" method with non empty list
     *
     * @see PhonyList#isEmpty()
     * @type Functional
     * @input non empty list
     * @oracle The result should be false
     * @passed Yes
     */
    @Test
    public void testIsEmpty_false() throws Exception {
        //Lucas
        assertEquals(phonyList.isEmpty(), false);
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
        assertTrue(phonyList.contains("d"));
    }

    /**
     * Tests the "indexOf" method with null value.
     *
     * @see PhonyList#indexOf(Object)
     * @type Functional
     * @input o=null
     * @oracle The result should be 1, the position of b in the list
     * @passed Yes
     */
    @Test
    public void testIndexOf_NullValue() throws Exception {
        phonyList.add(null);
        assertEquals(phonyList.indexOf(null), 4);
    }

    /**
     * Tests the "indexOf" method with a not null value.
     *
     * @see PhonyList#indexOf(Object)
     * @type Functional
     * @input o="b"
     * @oracle The result should be 1, the position of b in the list
     * @passed Yes
     */
    @Test
    public void testIndexOf() throws Exception {
        assertEquals(phonyList.indexOf("b"), 1);
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
        assertNotEquals(phonyList.elementData(4), "d");
    }

    /**
     * Tests the "testGet" method.
     *
     * @see PhonyList#elementData(int i)
     * @type Functional
     * @input PhonyList = ("a", "b", "c") and i=1
     * @oracle The element must be "b" at position 1.
     * @passed Yes
     */
    @Test
    public void testGet() throws Exception {
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
        String oldValue = phonyList.set(3, "z");
        assertEquals(oldValue, "d");
        assertEquals(phonyList.get(3), "z");
    }

    /**
     * Tests the "add" method with a list that extends maximul length of the phonylist.
     *
     * @see PhonyList#add(Object o)
     * @type Functional
     * @input o=collection("i", "j", "k", "l", "m", "n", "o", "p", "q")
     * @oracle The new element must have 13 elements
     * @passed Yes
     */
    @Test
    public void testAddAll_MaxLength() throws Exception {
        List<String> list = collection("i", "j", "k", "l", "m", "n", "o", "p", "q");
        phonyList.addAll(0, list);
        assertEquals(phonyList.size(), 13);
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
        PhonyList<String> listTest = phonylistHelper("a", "b", "c");
        listTest.add("d");
        assertEquals(listTest.get(3), "d");
    }

    /**
     * Tests the "remove" method with a null value on an non emtpy phonylist.
     * Code coverage test
     *
     * @see PhonyList#remove(Object o)
     * @type Functional
     * @input o=null
     * @oracle The list must remains the same
     * @passed No
     * @correction <pre>
     * l.267
     * - if(elementData[index] != null){
     * + if(elementData[index] == null){
     * </pre>
     */
    @Test
    public void testRemoveNullFromNonEmptyListPlusNullValue() throws Exception {
        phonyList.add(null);
        phonyList.remove(null);
        System.out.println(phonyList.get(0));
        assertEquals(4, phonyList.size());
    }

    /**
     * Tests the "remove" method on a null list with a null value.
     * Code coverage test
     *
     * @see PhonyList#remove(Object o)
     * @type Functional
     * @input o=null
     * @oracle The list must remains empty
     * @passed Yes
     */
    @Test
    public void testRemoveEmptyListWithNullValue() throws Exception {
        PhonyList<String> list1 = new PhonyList<>();
        list1.remove(null);
        assertEquals(0, list1.size());
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
    public void testAddAll_EmptyList() throws Exception {
        List<String> list = new ArrayList<String>();
        phonyList.addAll(1, list);
        assertEquals(phonyList.get(0), "a");
        assertEquals(phonyList.get(1), "b");
        assertEquals(phonyList.get(2), "c");
        assertEquals(phonyList.get(3), "d");
        assertEquals(phonyList.size(), 4);
    }

    /**
     * Tests the "addAll" method with a collection at the begining of the phonylist
     *
     * @see PhonyList#addAll(int i, Collection c)
     * @type Functional
     * @input i=4, c=collection("e", "f", "g", "h")
     * @oracle The collection must contains the new list at the end of its previous length
     * @passed Yes
     */
    @Test
    public void testAddAll_MinIndex() throws Exception {
        List<String> list = collection("e", "f", "g", "h");
        phonyList.addAll(0, list);
        assertEquals(phonyList.get(0), "e");
        assertEquals(phonyList.get(1), "f");
        assertEquals(phonyList.get(2), "g");
        assertEquals(phonyList.get(3), "h");
        assertEquals(phonyList.get(4), "a");
        assertEquals(phonyList.get(5), "b");
        assertEquals(phonyList.get(6), "c");
        assertEquals(phonyList.get(7), "d");
        assertEquals(phonyList.size(), 8);
    }

    /**
     * Tests the "addAll" method with a collection inserted in an invalid index
     *
     * @see PhonyList#addAll(int i, Collection c)
     * @type Functional
     * @input i=4, c=collection("e", "f", "g", "h")
     * @oracle The collection must contains the new list at the end of its previous length
     * @passed Yes
     */
    @Test
    public void testAddAll_InvalidIndex() throws Exception {
        List<String> list = collection("e", "f", "g", "h");
        Throwable e = null;
        try {
            phonyList.addAll(5, list);
        } catch (IndexOutOfBoundsException ex) {
            e = ex;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }
    /**
     * Tests the "addAll" method with a collection inserted at the end of the phonylist
     *
     * @see PhonyList#addAll(int i, Collection c)
     * @type Functional
     * @input i=4, c=collection("e", "f", "g", "h")
     * @oracle The collection must contains the new list at the end of its previous length
     * @passed Yes
     */
    @Test
    public void testAddAll_MaxIndex() throws Exception {
        List<String> list = collection("e", "f", "g", "h");
        phonyList.addAll(3, list);
        assertEquals(phonyList.get(0), "a");
        assertEquals(phonyList.get(1), "b");
        assertEquals(phonyList.get(2), "c");
        assertEquals(phonyList.get(3), "e");
        assertEquals(phonyList.get(4), "f");
        assertEquals(phonyList.get(5), "g");
        assertEquals(phonyList.get(6), "h");
        assertEquals(phonyList.get(7), "d");
        assertEquals(phonyList.size(), 8);
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

    /**
     * Tests the "removeRange" method with a collection of 4 elements.
     *
     * @see PhonyList#removeRange(int, int)
     * @type Functional
     * @input c=new ArrayList("a", "b", "c", "d")
     * @oracle Element "a" and "d" must be in the remaining PhonyList.
     * @passed Yes
     */
    @Test
    public void testRemoveRange() throws Exception {
        phonyList.removeRange(1, 3);
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
        Collection<Character> list = collection('b', 'c');
        phonyList.removeAll(list);
        assertTrue(phonyList.contains("a"));
        assertTrue(phonyList.contains("b"));
        assertTrue(phonyList.contains("c"));
        assertTrue(phonyList.contains("d"));
        assertEquals(phonyList.size(), 4);
    }
}