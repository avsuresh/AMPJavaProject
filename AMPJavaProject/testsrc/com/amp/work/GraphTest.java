package com.amp.work;

import org.junit.Before;
import org.junit.Test;

import static com.amp.work.Contants.ConnectionState.CONNECTED;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class GraphTest {

    private Graph graphUnderTest;

    @Before
    public void setUp() {
        graphUnderTest = new Graph();
        graphUnderTest.addNodesToGraph("New York, Chicago");
        graphUnderTest.addNodesToGraph("Denver, Kansas City");
        graphUnderTest.addNodesToGraph("Chicago, Los Angeles");
        graphUnderTest.addNodesToGraph("Kansas City, Nashville");
    }

    @Test
    public void checkCitiesConnectedIfSame() {
        String source = "New York";
        String dest = "New York";
        String expectedResult = CONNECTED.value();
        assertEquals(expectedResult, graphUnderTest.checkCitiesConnection(source, dest));
    }

    @Test
    public void checkCitiesConnected() {
        String source = "New York";
        String dest = "Los Angeles";
        String expectedResult = CONNECTED.value();
        assertEquals(expectedResult, graphUnderTest.checkCitiesConnection(source, dest));
    }
    @Test
    public void checkCitiesNotConnected() {
        String source = "New York";
        String dest = "Nashville";
        String expectedResult = CONNECTED.value();
        assertNotEquals(expectedResult, graphUnderTest.checkCitiesConnection(source, dest));
    }

    @Test
    public void checkNullSourceCity() {
        String source = "New York";
        String dest = null;
        String expectedResult = CONNECTED.value();
        assertNotEquals(expectedResult, graphUnderTest.checkCitiesConnection(source, dest));
    }

    @Test
    public void checkNullDestinationCity() {
        String source = null;
        String dest = "New York";
        String expectedResult = CONNECTED.value();
        assertNotEquals(expectedResult, graphUnderTest.checkCitiesConnection(source, dest));
    }

    @Test
    public void checkEmptyCity() {
        String source = "";
        String dest = "New York";
        String expectedResult = CONNECTED.value();
        assertNotEquals(expectedResult, graphUnderTest.checkCitiesConnection(source, dest));
    }

    @Test
    public void addNodesToGraph() {
        String line = "New York, Nashville";
        graphUnderTest.addNodesToGraph(line);
        String source = "New York";
        String dest = "Nashville";
        String expectedResult = CONNECTED.value();
        assertEquals(expectedResult, graphUnderTest.checkCitiesConnection(source, dest));
    }

    @Test
    public void testCreateGraphNotConnected(){
        String file = "C:\\Users\\Suresh\\Desktop\\cities2.txt";
        graphUnderTest.createGraph(file);
        String source = "New York";
        String dest = "Nashville";
        String expectedResult = CONNECTED.value();
        assertNotEquals(expectedResult, graphUnderTest.checkCitiesConnection(source, dest));
    }

    @Test
    public void testCreateGraphConnected(){
        String file = "C:\\Users\\Suresh\\Desktop\\cities2.txt";
        graphUnderTest.createGraph(file);
        String source = "Seattle";
        String dest = "Charlotte";
        String expectedResult = CONNECTED.value();
        assertEquals(expectedResult, graphUnderTest.checkCitiesConnection(dest, source));
    }
}