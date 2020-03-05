package com.zipcodewilmington.singlylinkedlist;

import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    SinglyLinkedList<Integer> testList;
    Integer testNum1, testNum2;
    Integer[] testArray;
    SinglyLinkedList<String> testList2;
    String testString1, testString2, testString3;
    String[] testArray2;

    private static final Logger LOGGER =
            Logger.getLogger((SinglyLinkedList.class.getName()));

    @Before
    public void init(){
        testList = new SinglyLinkedList<Integer>();
        testNum1 = 1;
        testNum2 = 2;
        testArray = new Integer[]{testNum1, testNum2};

        testList2 = new SinglyLinkedList<String>();
        testString1 = "bob";
        testString2 = "ken";
        testString3 = "hok";
        testArray2 = new String[]{testString1, testString2, testString3};
    }

    @Test
    public void constructorTest(){
        testList = new SinglyLinkedList<Integer>(testArray);
        Integer expected = 2;

        Integer actual = testList.size();

        assertEquals(expected, actual);
    }

    @Test
    public void addTest(){
        Boolean actual = testList.add(testNum1);

        assertTrue(actual);
    }

    @Test
    public void getTest(){
        testList = new SinglyLinkedList<Integer>(testArray);
        Integer expected = 2;

        Integer actual = testList.get(1);

        assertEquals(expected, actual);
    }

    @Test
    public void getTest2(){
        testList2 = new SinglyLinkedList<String>(testArray2);
        String expected = "ken";

        String actual = testList2.get(1);

        assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getTest3(){
        testList2 = new SinglyLinkedList<String>(testArray2);

        String actual = testList2.get(5);
    }

    @Test
    public void removeTest(){
        testList2 = new SinglyLinkedList<String>(testArray2);
        String expected = "hok";
        Integer expectedSize = 2;

        Boolean actualBoolean = testList2.remove("ken");
        String actual = testList2.get(1);
        Integer actualSize = testList2.size();

        assertTrue(actualBoolean);
        assertEquals(expected, actual);
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void removeTest2(){
        testList2 = new SinglyLinkedList<String>(testArray2);

        Boolean actual = testList2.remove("han");

        assertFalse(actual);
    }

    @Test
    public void containTest(){
        testList2 = new SinglyLinkedList<String>(testArray2);

        Boolean actual = testList2.contains("ken");

        assertTrue(actual);
    }

    @Test
    public void containTest2(){
        testList2 = new SinglyLinkedList<String>(testArray2);

        Boolean actual = testList2.contains("han");

        assertFalse(actual);
    }

    @Test
    public void findTest(){
        testList2 = new SinglyLinkedList<String>(testArray2);
        Integer expected = 1;

        Integer actual = testList2.find("ken");

        assertEquals(expected, actual);
    }

    @Test
    public void findTest2(){
        testList2 = new SinglyLinkedList<String>(testArray2);
        Integer expected = -1;

        Integer actual = testList2.find("han");

        assertEquals(expected, actual);
    }

    @Test
    public void copyTest(){
        testList2 = new SinglyLinkedList<String>(testArray2);
        SinglyLinkedList<String> copy2 = testList2.copy();

        assertEquals(testList2.get(1), copy2.get(1));
    }

    @Test
    public void sortTest(){
        Integer[] test = new Integer[]{2, 3, 1, 7, 6, 5, 4};
        Integer[] exp = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        testList = new SinglyLinkedList<Integer>(test);
        SinglyLinkedList<Integer> expected = new SinglyLinkedList<Integer>(exp);
        testList.sort();

        for (int i = 0; i < testList.size(); i++) {
            LOGGER.info("" + testList.get(i));
            assertEquals(expected.get(i), testList.get(i));
        }
    }

    @Test
    public void sortTes2(){
        String[] test = new String[]{"bob", "ken", "tarry", "amanda"};
        String[] exp = new String[]{"amanda", "bob", "ken", "tarry"};
        SinglyLinkedList<String> stringTest = new SinglyLinkedList<String>(test);
        SinglyLinkedList<String> expected = new SinglyLinkedList<String>(exp);
        stringTest.sort();

        for (int i = 0; i < stringTest.size(); i++) {
            LOGGER.info("" + stringTest.get(i));
            assertEquals(expected.get(i), stringTest.get(i));
        }
    }

    @Test
    public void sortTes3(){
        Double[] test = new Double[]{50.0, 45.0, 45.1, 75.6, 36.3};
        Double[] exp = new Double[]{36.3, 45.0, 45.1, 50.0, 75.6};
        SinglyLinkedList<Double> doubleTest = new SinglyLinkedList<Double>(test);
        SinglyLinkedList<Double> expected = new SinglyLinkedList<Double>(exp);
        doubleTest.sort();

        for (int i = 0; i < doubleTest.size(); i++) {
            LOGGER.info("" + doubleTest.get(i));
            assertEquals(expected.get(i), doubleTest.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void sliceTest(){
        testList.slice(100, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void sliceTest1(){
        testList.slice(-1, 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void sliceTest2(){
        Integer[] test = new Integer[]{2, 3, 1, 7, 6, 5, 4};
        testList = new SinglyLinkedList<Integer>(test);

        testList.slice(7, 5);
    }

    @Test
    public void sliceTest3(){
        Integer[] test = new Integer[]{2, 3, 1, 7, 6, 5, 4};
        Integer[] exp = new Integer[]{3, 1, 7, 6};
        testList = new SinglyLinkedList<Integer>(test);
        SinglyLinkedList expected = new SinglyLinkedList(exp);

        SinglyLinkedList actual = testList.slice(1, 5);

        for (int i = 0; i < expected.size(); i++) {
            LOGGER.info("" + actual.get(i));
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void sortTes4(){
        String[] test = new String[]{"bob", "ken", "tarry", "amanda", "exxe", "yummy"};
        String[] exp = new String[]{"tarry", "amanda"};
        SinglyLinkedList<String> stringTest = new SinglyLinkedList<String>(test);
        SinglyLinkedList<String> expected = new SinglyLinkedList<String>(exp);

        SinglyLinkedList actual = stringTest.slice(2, 4);

        for (int i = 0; i < expected.size(); i++) {
            LOGGER.info("" + actual.get(i));
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void reverseTest(){
        String[] test = new String[]{"bob", "ken", "tarry", "amanda", "exxe", "yummy"};
        String[] exp = new String[]{"yummy", "exxe", "amanda", "tarry", "ken", "bob"};
        SinglyLinkedList<String> stringTest = new SinglyLinkedList<String>(test);
        SinglyLinkedList<String> expected = new SinglyLinkedList<String>(exp);

        SinglyLinkedList actual = stringTest.reverse();

        for (int i = 0; i < expected.size(); i++) {
            LOGGER.info("" + actual.get(i));
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}
