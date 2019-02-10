package com.amp.work;

import static com.amp.work.utils.isArgumentsValid;

public class ConnectedCities {

    public static void main(String[] args) {

        Graph graph = new Graph();

        if (!isArgumentsValid(args)) {
            System.out.println("Enter valid input... source, destination, file name");
            System.exit(0);
        }

        String source = args[0]; // source city from input
        String destination = args[1]; // Destination city from input
        graph.createGraph(args[2]); // Creating the graph using given input file

        // Check the input cities and print connection state
        String result = graph.checkCitiesConnection(source, destination);
        System.out.println(result);
    }
}
