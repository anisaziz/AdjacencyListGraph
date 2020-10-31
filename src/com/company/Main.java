package com.company;

public class Main {

    public static void main(String[] args) {

        adjgraph adjgraph = new adjgraph();

        Vertex Eskildstrup = new Vertex("Eskildstrup");
        adjgraph.addVertex(Eskildstrup);

        Vertex Haslev = new Vertex("Haslev");
        adjgraph.addVertex(Haslev);

        Vertex Holbæk = new Vertex("Holbæk");
        adjgraph.addVertex(Holbæk);

        Vertex Jærgerpris = new Vertex("Jægrerpris");
        adjgraph.addVertex(Jærgerpris);

        Vertex Kalundborg = new Vertex("Kalundborg");
        adjgraph.addVertex(Kalundborg);

        Vertex Korsør = new Vertex("Korsør");
        adjgraph.addVertex(Korsør);

        Vertex Køge = new Vertex("Køge");
        adjgraph.addVertex(Køge);

        Vertex Maribo = new Vertex("Maribo");
        adjgraph.addVertex(Maribo);

        Vertex Næstved = new Vertex("Næstved");
        adjgraph.addVertex(Næstved);

        Vertex Ringsted = new Vertex("Ringsted");
        adjgraph.addVertex(Ringsted);

        Vertex Slagelse = new Vertex("Slagelse");
        adjgraph.addVertex(Slagelse);

        Vertex NykøbingF = new Vertex("NykøbingF");
        adjgraph.addVertex(NykøbingF);

        Vertex Roskilde = new Vertex("Roskilde");
        adjgraph.addVertex(Roskilde);

        Vertex Nakskov = new Vertex("Nakskov");
        adjgraph.addVertex(Nakskov);

        Vertex Vordingborg = new Vertex("Vordingborg");
        adjgraph.addVertex(Vordingborg);

        Vertex Sorø = new Vertex("Sorø");
        adjgraph.addVertex(Sorø);



        adjgraph.newEdge(Eskildstrup,Maribo,28);
        adjgraph.newEdge(Eskildstrup, NykøbingF, 13);
        adjgraph.newEdge(Eskildstrup, Vordingborg, 24);

        adjgraph.newEdge(Haslev, Korsør, 60);
        adjgraph.newEdge(Haslev,Køge,24);
        adjgraph.newEdge(Haslev, Næstved, 25);
        adjgraph.newEdge(Haslev, Ringsted, 19);
        adjgraph.newEdge(Haslev, Roskilde, 47);
        adjgraph.newEdge(Haslev,Sorø,34);
        adjgraph.newEdge(Haslev, Vordingborg, 40);

        adjgraph.newEdge(Holbæk, Jærgerpris, 34);
        adjgraph.newEdge(Holbæk, Kalundborg, 44);
        adjgraph.newEdge(Holbæk, Korsør, 66);
        adjgraph.newEdge(Holbæk, Ringsted, 36);
        adjgraph.newEdge(Holbæk, Roskilde, 32);
        adjgraph.newEdge(Holbæk, Slagelse, 46);
        adjgraph.newEdge(Holbæk, Sorø, 34);

        adjgraph.newEdge(Jærgerpris, Korsør, 95);
        adjgraph.newEdge(Jærgerpris, Køge, 58);
        adjgraph.newEdge(Jærgerpris, Ringsted, 56);
        adjgraph.newEdge(Jærgerpris, Roskilde, 33);
        adjgraph.newEdge(Jærgerpris, Slagelse, 74);
        adjgraph.newEdge(Jærgerpris, Sorø, 63);

        adjgraph.newEdge(Kalundborg, Ringsted, 62);
        adjgraph.newEdge(Kalundborg, Roskilde, 70);
        adjgraph.newEdge(Kalundborg, Slagelse, 39);
        adjgraph.newEdge(Kalundborg, Sorø, 51);

        adjgraph.newEdge(Korsør, Næstved, 45);
        adjgraph.newEdge(Korsør, Slagelse, 20);

        adjgraph.newEdge(Køge, Næstved, 45);
        adjgraph.newEdge(Køge, Ringsted, 28);
        adjgraph.newEdge(Køge, Roskilde, 25);
        adjgraph.newEdge(Køge, Vordingborg, 60);

        adjgraph.newEdge(Maribo, Nakskov, 27);
        adjgraph.newEdge(Maribo, NykøbingF,26 );
        adjgraph.newEdge(Næstved, Roskilde,57 );
        adjgraph.newEdge(Næstved, Ringsted,26 );
        adjgraph.newEdge(Næstved, Slagelse,37 );
        adjgraph.newEdge(Næstved, Sorø,32 );
        adjgraph.newEdge(Næstved, Vordingborg,28 );
        adjgraph.newEdge(Ringsted, Roskilde, 31);
        adjgraph.newEdge(Ringsted, Sorø,15 );
        adjgraph.newEdge(Ringsted, Vordingborg,58);
        adjgraph.newEdge(Slagelse, Sorø,14);

        adjgraph.printGraph();
        adjgraph.MSTPrims();


    }
}
