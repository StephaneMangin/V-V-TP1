package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    }

    @Test
    public void testClear() throws Exception {
        //Lucas
    }

    @Test
    public void testAddAll() throws Exception {
        //Stéphane
    }

    @Test
    public void testRemoveRange() throws Exception {
        //Lucas
    }

    @Test
    public void testRemoveAll() throws Exception {
        //Stéphane
    }
}