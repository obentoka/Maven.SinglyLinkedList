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

}
