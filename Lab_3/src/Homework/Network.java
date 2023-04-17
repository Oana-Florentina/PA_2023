package Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void printNetwork() {
        // compute importance of each node
        for (Node node : nodes) {
            node.computeImportance();
        }

        // sort nodes by importance
        Collections.sort(nodes);

        // print network
        for (Node node : nodes) {
            System.out.println(node.toString());
        }
    }
}