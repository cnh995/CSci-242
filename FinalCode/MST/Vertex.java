import java.util.ArrayList;

public class Vertex {
 
    public ArrayList<Edge> edgeList;
    public String city;
    public boolean explored;
    public int id;
    public Vertex(String city){
      this.city = city;
      this.explored = false;
      this.edgeList = new ArrayList<Edge>();
    }
    
    public void makeEdgeList(ArrayList<Edge> edges)
	{
		for(Edge e : edges)
		{
			if(this.equals(e.v) && !edgeList.contains(e))
			{
				edgeList.add(e);
			}
		}
	}

	public void printEdgeList()
	{
		for(Edge e : edgeList)
			System.out.println(e);
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
 
    Edge removeEdge(int index){
        return this.edgeList.remove(index);
    }
 
    public void removeEdge(Edge e){
        this.edgeList.remove(e);
    }
   
   public int getNeighborCount(){
        return this.edgeList.size();
    }
     
    public String toString(){
        return "Vertex " + city;
    }
    
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
