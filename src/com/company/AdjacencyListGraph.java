package com.company;
import java.util.ArrayList;

class adjgraph {
    private ArrayList<Vertex> vertices;
    public adjgraph(){
        vertices = new ArrayList<Vertex>();
    }
    public void addVertex(Vertex v){
        vertices.add(v);
    }
    public void newEdge(Vertex from, Vertex to, Integer distance){
        if(!(vertices.contains(from) && vertices.contains(to))){
            System.out.println("Vertex not found");
            return;
        }
        Edge newEdge = new Edge(from, to, distance);
    }
    public void printGraph(){
        Vertex currentVertex;
        for (int i = 0; i < vertices.size(); i++){
            currentVertex = vertices.get(i);
            System.out.println(" Edges from Vertex: " + currentVertex.getName());
            for (int j = 0; j< currentVertex.getOutEdges().size(); j++){
                System.out.println(" To " + currentVertex.getOutEdges().get(j).getToVertex()
                        .getName() + " distance: " + currentVertex.getOutEdges().get(j).getWeight() + " Km");
            }
            System.out.println(" ");
        }
    }
}
class Vertex implements Comparable<Vertex>{
    private String Name;
    private ArrayList<Edge> outEdges;
    Integer distance = Integer.MAX_VALUE;
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public ArrayList<Edge> getOutEdges() {
        return outEdges;
    }
    public void setOutEdges(ArrayList<Edge> outEdges) {
        this.outEdges = outEdges;
    }
    public Integer getDistance() {
        return distance;
    }
    public void setDistance(Integer distance) {
        this.distance = distance;
    }
    public Vertex(String id)
    {
        this.Name = id;
        outEdges = new ArrayList<>();
    }
    public void addOutEdge(Edge outEdge){
        outEdges.add(outEdge);
    }

    @Override
    public int compareTo(Vertex o) {
        if (this.distance < o.distance){
            return -1;
        }
        if(this.distance > o.distance){
            return 1;
        }
        return 0;
    }
}

class Edge{
    private Vertex fromVertex;
    private Vertex toVertex;
    private Integer weight;
    public Edge(Vertex from, Vertex to, Integer costWeight){
        fromVertex = from;
        toVertex = to;
        weight = costWeight;
        from.addOutEdge(this);
    }
    public Vertex getFromVertex() {
        return fromVertex;
    }
    public void setFromVertex(Vertex fromVertex) {
        this.fromVertex = fromVertex;
    }
    public Vertex getToVertex() {
        return toVertex;
    }
    public void setToVertex(Vertex toVertex) {
        this.toVertex = toVertex;
    }
    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}