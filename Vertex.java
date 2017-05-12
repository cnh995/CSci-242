import java.util.ArrayList;

public class Vertex {
 
    public ArrayList<Edge> edgeList;
    private String city;
    private int explore = 0;
    public Vertex(String city){
      this.city = city;
      this.explore = 0;
      this.edgeList = new ArrayList<Edge>();
    }
    
    public void setCity(String town){
      this.city = town;
    }
    
    public void explored(){
      this.explore = 1;
    }

    public void addEdge(Edge edge){
        if(this.edgeList.contains(edge)){
            return;
        }
        this.edgeList.add(edge);
    }
    
    public boolean containsEdge(Edge other){
        return this.edgeList.contains(other);
    }
     
    public Edge getEdge(int index){
        return this.edgeList.get(index);
    }
     
    /**
     *
     * @param index The index of the edge to remove from this.edgeList
     * @return Edge The removed Edge
     */
    Edge removeEdge(int index){
        return this.edgeList.remove(index);
    }
     
    /**
     *
     * @param e The Edge to remove from this.edgeList
     */
    public void removeEdge(Edge e){
        this.edgeList.remove(e);
    }
     
     
    /**
     *
     * @return int The number of neighbors of this Vertex
     */
    public int getNeighborCount(){
        return this.edgeList.size();
    }
     
     
    /**
     *
     * @return String The city of this Vertex
     */
    public String getCity(){
        return this.city;
    }
    public String toString(){
        return "Vertex " + city;
    }
 /*   public int hashCode(){
        return this.city.hashCode();
    }*/

    
    public boolean equals(Object other){
        if(!(other instanceof Vertex)){
            return false;
        }
        Vertex v = (Vertex)other;
        return this.city.equals(v.city);
    }
    
    public ArrayList<Edge> getNeighbors(){
        return new ArrayList<Edge>(this.edgeList);
    }
}
