package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class adjgraph {
    //private int[] WeightGraph;
    private ArrayList<Vertex> vertices;

    public adjgraph() {
        vertices = new ArrayList<Vertex>();
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public void newEdge(Vertex from, Vertex to, Integer distance) {
        if (!(vertices.contains(from) && vertices.contains(to))) {
            System.out.println("Vertex not found");
            return;
        }
        Edge newEdge = new Edge(from, to, distance);
        Edge newEdgeRev = new Edge(to, from, distance);
        //Edge fromTo =
          //      Edge toFrom
    }

    public void printGraph() {
        Vertex currentVertex;
        for (int i = 0; i < vertices.size(); i++) {
            currentVertex = vertices.get(i);
            System.out.println(" Edges from Vertex: " + currentVertex.getName());
            for (int j = 0; j < currentVertex.getOutEdges().size(); j++) {
                System.out.println(" To " + currentVertex.getOutEdges().get(j).getToVertex()
                        .getName() + " distance: " + currentVertex.getOutEdges().get(j).getWeight() + " Km");
            }
            System.out.println(" ");
        }
    }

    /*
        public void MSTPrims() {
            int[] Distance = new int[vertices.size()];
            int[] predecessor = new int[vertices.size()];
            int[] visited = new int[vertices.size()];
            PriorityQueue<Pair> Q = new PriorityQueue<Pair>();
            Arrays.fill(Distance, Integer.MAX_VALUE); //Max value som infinity.
            Arrays.fill(predecessor, -1);
            Arrays.fill(visited, 0);
            if (vertices.size() > 0) {
                Distance[0] = 0;
                Q.offer(new Pair(0, 0)); // tilføje første element til queuen.
            }
            int counter = 0;
            int MST = 0;
            while (!Q.isEmpty() && counter < vertices.size()) {
                Pair u = Q.poll();
                if (visited[u.index] != 1) {
                    //For loop løber gennem alle vertices
                    for (int v = 0; v < vertices.size(); v++) {
                        if (vertices.get(v).distance < Distance[v]) { // u er den der er taget ud af køen, hvor v er det vi skal gøre det med. lolwut.
                            Distance[v] = vertices.get(v).distance;
                            predecessor[v] = v;
                            Q.offer(new Pair(Distance[v], v));
                        }
                    }
                }
                visited[u.index] = 1; //Mna har besøgt den.
                counter++; //Man har tilføjet u til graffen.
                MST += Distance[u.index];
            }
            System.out.println(" Minimum spanning Tree Distance: " + MST);
            //PrintMST(predecessor, Distance);

        }

     */
    public void MSTPrims(){
        PriorityQueue<Vertex> Q = new PriorityQueue<>();
        //ArrayList<Vertex> predecessor =
/*
        int[] predecessor = new int[vertices.size()];
        int[] distance = new int[vertices.size()];
  */
        //ArrayList<Vertex> reached = new ArrayList<Vertex>();
        //ArrayList<Vertex> unReached = vertices;
        //int[] Distance = new int[vertices.size()];


        //reached.add(0, vertices.get(0));
        //unReached.remove(0);
        //Distance[0] = Integer.MAX_VALUE;
        if(vertices.size() > 0) {
            vertices.get(0).setDistance(0); //We set the first element in the graph's distance to 0, because that is where we currently are.
            Q.offer(vertices.get(0)); //We add the first element to the queue
        }

        int reachedIndex = 0; //ligesom counter i det fra Line. Tror ikke vi har brug for det, da vi har queue. Behøver måske heller ikke
        //int unReachedIndex = 0;
        int MST = 0;

        while (!Q.isEmpty() && reachedIndex < vertices.size()) { //If the q is not empty (we still have) elements left and if we have not reached all of the elements.
            Vertex currentVertex = Q.poll(); //Get the first element in the queue. The first one (in the first run-through) or the one we are now looking at.
            int iCurrentVertex = vertices.indexOf(currentVertex);

            if (!currentVertex.isVisited()) {
                //ArrayList<Edge> outEdgesCurrentVertex = currentVertex.getOutEdges();
                ArrayList<Edge> outEdgesCurrentVertex = currentVertex.getOutEdges();


                for (int i = 0; i < outEdgesCurrentVertex.size(); i++) {
                    int oECVWeight = outEdgesCurrentVertex.get(i).getWeight(); //outedge of current vertex' weight.
                    Vertex oEToCV = outEdgesCurrentVertex.get(i).getToVertex();

                    if (oECVWeight < oEToCV.getDistance() && !oEToCV.isVisited()) { //Is the weight of the current vertex's outedge (the one we are checking) smaller than the weight of the vertex that comes before(?). And is the vertex we are coming from not visited(?)
                        oEToCV.setDistance(oECVWeight); //Set the distance of the outEdge of the vertex going to the current vertex, to that of the current vertex, since it is smaller.
                        //Set predecessor mangler jeg
                        //predecessor[i] = iCurrentVertex;

                        oEToCV.setPredecessor(iCurrentVertex);

                        Q.offer(oEToCV);

                        /*
                        reached.add(vertices.get(i));
                        unReached.remove(i);
                        System.out.println(Distance[reachedIndex]);
                        */

                    }
                }

                //Er måske forkert. Skal  lige kigge på.
                vertices.get(iCurrentVertex).setVisited(true); //Set the current vertice to visited.

                reachedIndex++;
                MST += currentVertex.getDistance();
                //MST += reached.get(reachedIndex).distance; //Prøver at få den fra loopet ovenover
                //MST += Distance.get(reachedIndex);
            }
        }
        System.out.println(" Minimum spanning tree Distance: " + MST);
        int price = MST * 1000000;
        System.out.println(" The minimum price for an electricity grid that covers all of the stations would be " + price + " kr");
        printMST();
    }

    public void printMST(){
        String startVertex = vertices.get(0).getName();

        System.out.println("\nThe grid starts with " + startVertex + " which goes to the next city, which is ");

        for(int i = 0; i < vertices.size(); i++){
            if(vertices.get(i).getPredecessor() != -1){
                System.out.println(" going from " + vertices.get(vertices.get(i).getPredecessor()).getName() + " to " + vertices.get(i).getName() + " with a distance of " + vertices.get(i).getDistance() + " KM");
                if(i < (vertices.size()-1)) {
                    System.out.println(" and then ");
                }
            }
            /*
            String name = vertices.get(i).getName();
            Integer pre = vertices.get(vertices.get(i).getPredecessor());

            if(!pre.equals(-1)) {
                System.out.println(" Going from " + pre.getName() + " to " + name + " with a distance of " + vertices.get(i).getDistance());
            }
             */
            }
    }
}



class Vertex implements Comparable<Vertex>{
    private String Name;
    private ArrayList<Edge> outEdges;
    Integer distance = Integer.MAX_VALUE;
    boolean visited = false; //Bruge get visited i prims.
    private int predecessor = -1;

    //konstruktør
    public Vertex(String id) {
        this.Name = id;
        outEdges = new ArrayList<>();
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public boolean isVisited() {
        return visited;
    }
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
    public void addOutEdge(Edge outEdge){
        outEdges.add(outEdge);
    }
    public int getPredecessor() {
        return predecessor;
    }
    public void setPredecessor(int predecessor) {
        this.predecessor = predecessor;
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

/*
    class Pair implements Comparable<Pair>{
        Integer distance;
        Integer index;

        public Pair(Integer distance, Integer vertex){
            this.distance = distance;
            this.index = vertex; //vertexen er indexet den er på. Ikke 100% sikker på hvorfor, men det er vel bare hvilken vertex der peges på. Giver mening.
        }

        @Override
        public int compareTo(Pair o) {
            return this.distance.compareTo(o.distance);
        }
    }
 */