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

    private PhonyList<String> list(String... content) {
        PhonyList<String> list = new PhonyList<>();
        for (String i : content)
            list.add(i);
        return list;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {
        //Lucas
        PhonyList<String> list1 = list("a", "b");
        assertEquals(list1.equals(list1), true);
    }

    @Test
    public void testSize() throws Exception {
        //Stéphane
        PhonyList<String> phonyList = list("Value1", "Value2", "Value3", "Value4");
        assertEquals(phonyList.size(), 4);
        phonyList.remove("Value3");
        phonyList.remove("Value4");
        assertEquals(phonyList.size(), 2);
    }

    @Test
    public void testIsEmpty() throws Exception {
        //Lucas
        PhonyList<String> emptyList = list();
        assertEquals(emptyList.isEmpty(), true);
    }

    @Test
    public void testContains() throws Exception {
        //Stéphane
        PhonyList<String> phonyList = list("Value1", "Value2", "Value3", "Value4");
        assertTrue(phonyList.contains("Value2"));
        phonyList.remove("Value4");
        assertFalse(phonyList.contains("Value4"));
    }

    @Test
    public void testIndexOf() throws Exception {
        //Lucas
        PhonyList<String> listTest = list("a", "b", "c");
        assertEquals(listTest.indexOf("b"), 1);
    }

    @Test
    public void testElementData() throws Exception {
        //Stéphane
        PhonyList<String> phonyList = list("Value1", "Value2", "Value3", "Value4");
        assertEquals(phonyList.elementData(3), "Value4");
        assertNotEquals(phonyList.elementData(4), "Value4");
    }

    @Test
    public void testGet() throws Exception {
        //Lucas
        PhonyList<String> listTest = list("a", "b", "c");
        assertEquals(listTest.get(1), "b");
    }

    @Test
    public void testSet() throws Exception {
        //Stéphane
        PhonyList<String> phonyList = new PhonyList<>();
        phonyList.set(0, "Value1");
        phonyList.set(1, "Value2");
        phonyList.set(3, "Value3");
        phonyList.set(2, "Value4");
        assertEquals(phonyList.get(0), "Value1");
        assertNotEquals(phonyList.get(2), "Value3");
    }

    @Test
    public void testAdd() throws Exception {
        //Lucas
        PhonyList<String> listTest = list("a", "b", "c");
        listTest.add("d");
        assertEquals(listTest.get(4), "d");
    }

    @Test
    public void testRemove() throws Exception {
        //Stéphane
        PhonyList<String> phonyList = list("Value1", "Value2", "Value3", "Value4");
        phonyList.remove("Value1");
        assertEquals(phonyList.size(), 3);
    }

    @Test
    public void testClear() throws Exception {
        //Lucas
        PhonyList<String> list1 = list("a", "b", "c");
        PhonyList<String> list2 = list();
        list1.clear();
        assertEquals(list1, list2);
    }

    @Test
    public void testAddAll() throws Exception {
        //Stéphane
        PhonyList<String> phonyList = new PhonyList<>();
        List<String> list = new ArrayList<String>();
        list.add("Value1");
        list.add("Value2");
        list.add("Value3");
        list.add("Value4");
        phonyList.addAll(0, list);
        assertTrue(phonyList.contains("Value1"));
        assertTrue(phonyList.contains("Value2"));
        assertTrue(phonyList.contains("Value3"));
        assertTrue(phonyList.contains("Value4"));
    }

    @Test
    public void testRemoveRange() throws Exception {
        //Lucas
        PhonyList<String> list1 = list("a", "b", "c", "d");
        PhonyList<String> list2 = list("b", "c");
        list1.removeRange(1, 2);
        assertEquals(list1, list2);
    }

    @Test
    public void testRemoveAll() throws Exception {
        //Stéphane
        PhonyList<String> phonyList = list("Value1", "Value2", "Value3", "Value4");
        List<String> list = new ArrayList<String>();
        list.add("Value1");
        list.add("Value2");
        list.add("Value3");
        list.add("Value4");
        phonyList.removeAll(list);
        assertFalse(phonyList.contains("Value1"));
        assertFalse(phonyList.contains("Value2"));
        assertFalse(phonyList.contains("Value3"));
        assertFalse(phonyList.contains("Value4"));
    }
}