public class Edge implements Comparable<Edge> {
    public Vertex v, u;
    public boolean explored;
    public int weight;
    
    public Edge(Vertex one, Vertex two, int num){
      this.explored = false;
      this.v = one;
      this.u = two;
      this.weight = num;
      one.addEdge(this);
    }
     
   /* public Vertex getNeighbor(Vertex current){
        if(!(current.equals(v) || current.equals(u))){
            return null;
        }
        return (current));
    }*/

    public int compareTo(Edge other){
        return this.weight - other.weight;
    }
     
    public String toString(){
        return "({" + v + ", " + u + "}, " + weight + ")";
    }
     
    public boolean equals(Object other){
        if(!(other instanceof Edge)){
            return false;
        }
         
        Edge e = (Edge)other;
        return e.v.equals(this.v) && e.u.equals(this.u);
    }  
}
