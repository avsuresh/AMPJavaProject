package com.amp.work;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static com.amp.work.Contants.ConnectionState.CONNECTED;
import static com.amp.work.Contants.ConnectionState.NOTCONNECTED;

/**
 * Graph class stores the graph structure
 *
 * */
public class Graph {
    //Graph is assumed as Un-directed graph and storing the vertexes on Map
    private Map<String, Node> citiesGraph = new HashMap<>();

    /**
     * Checks the connection between given two cities
     *
     * @param source Source city
     * @param destination Target city
     *
     * @return String Connection state (CONNECTED or NOT CONNECTED)
     *
     * */
    public String checkCitiesConnection(String source, String destination) {

        Node start = citiesGraph.get(source);
        Node target = citiesGraph.get(destination);

        // Checking the given cities are valid and present in the graph
        if(null == start || null == target){
            return NOTCONNECTED.value();
        }

        LinkedList<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        // Using the Queue structure to keep the nodes traversal using BFS
        queue.add(start);

        //checking till end of queue to verify there is any path between source and destination
        while (!queue.isEmpty()){
            Node head_node = queue.remove(); // remove the head node as we visit this node
            Node current_node = citiesGraph.get(head_node.data);

            // Checking the target city with the current node in traversal
            if(current_node.data.equals(target.data)){
                return CONNECTED.value();
            }

            // checking the current node is already visited, then continue to next adjacent node
            if(visited.contains(current_node.data)){
                continue;
            }
            //Adding to the visited nodes set
            visited.add(current_node.data);

            // Add all the adjacent vertices of the current node into queue to check is there possible path
            queue.addAll(current_node.adjNodes);
        }
        // There is no path between the two cities given; return NOT CONNECTED
        return NOTCONNECTED.value();
    }

    /**
     * Adds the source and destination city into graph as nodes are adjacent to each other
     *
     * @param line input line from the cities file and split and store it graph
     *
     * */
    void addNodesToGraph(String line) {
        if (!line.isEmpty()) {
            String[] cities = line.split(",");
            if(cities.length ==2){ // Checking the array size to be 2; source and destination city
                //Adding the source city node to the graph
                addNode(cities[0].trim(), cities[1].trim());
                //Adding the destination city node to the graph
                addNode(cities[1].trim(), cities[0].trim());
            }
            else if(cities.length ==1){
                //If there is only one city in the file add it to the graph and make it self referencing
                addNode(cities[0].trim());
            }
        }
    }

    /**
    * Create the graph from the given input file
    * The graph edges and adjacent vertexes are stored in HashMap<String, Node>
    * */
    void createGraph(String fileName){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName)); // Reading the file to create the graph
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            System.exit(-1);
        }

        // Reading each line from the input file and map it to graph
        while (scanner.hasNextLine()) {
            addNodesToGraph(scanner.nextLine());
        }
    }

    /**
     * Add the cities from the given input files to graph
     *
     * */

    private void addNode(String city1, String city2){
        if(citiesGraph.containsKey(city1)){
            citiesGraph.get(city1).adjNodes.add(new Node(city2));
        }else{
            Node node = new Node(city1);
            node.adjNodes.add(new Node(city2));
            citiesGraph.put(city1, node);
        }
    }

    /**
     * If there is only one city present in the file, then add it as isolated city.
     * This can be accessed from itself
     * */
    private void addNode(String city) {
        Node node = new Node(city);
        citiesGraph.put(city, node);
    }
}

/**
 * Class to store the vertex data and adjacent nodes
 *
 * */
class Node {
    String data;
    LinkedList<Node> adjNodes = new LinkedList<>();
    Node(String city) {
        this.data = city;
    }
}
