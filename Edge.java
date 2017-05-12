public class Edge implements Comparable<Edge> {
    private Vertex v, u;
    private int weight;
    /*
    public Edge(Vertex one, Vertex two, int num){
        this.v = one;
        this.u = two;
        this.weight = num;
    }*/
    
    public Edge(Vertex one, Vertex two, int weight){
        this.v.setCity(one.getCity());
        this.u.setCity(two.getCity());
        this.weight = weight;
        one.addEdge(this);
    }
     
   /* public Vertex getNeighbor(Vertex current){
        if(!(current.equals(v) || current.equals(u))){
            return null;
        }
        return (current));
    }*/
     
    public Vertex getOne(){
        return this.v;
    }
     
    public Vertex getTwo(){        
      return this.u;
    }
     
     
    public int getWeight(){
        return this.weight;
    }
     
    public void setWeight(int weight){
        this.weight = weight;
    }
     
    public int compareTo(Edge other){
        return this.weight - other.weight;
    }
     
    public String toString(){
        return "({" + v + ", " + u + "}, " + weight + ")";
    }
     
/*    public int hashCode(){
        return (v.getLabel() + u.getLabel()).hashCode();
    }
 */    
    public boolean equals(Object other){
        if(!(other instanceof Edge)){
            return false;
        }
         
        Edge e = (Edge)other;
        return e.v.equals(this.v) && e.u.equals(this.u);
    }  
}