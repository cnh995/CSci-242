 import java.util.*;
public class Graph {
     
    private HashMap<String, Vertex> vertices;
    private HashMap<Integer, Edge> edges;
     
    public Graph(){
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
} 

public Graph(ArrayList<Vertex> vertices){
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
        for(Vertex v: vertices){
            this.vertices.put(v.getCity(), v);
        }         
}

public boolean addEdge(Vertex one, Vertex two){
        return addEdge(one, two, 1);
      }
    public boolean addEdge(Vertex one, Vertex two, int weight){
        if(one.equals(two)){
            return false;  
        }
        Edge e = new Edge(one, two, weight);
        if(edges.containsKey(e.hashCode())){
            return false;
        }
        else if(one.containsEdge(e) || two.containsEdge(e)){
            return false;
        }
        edges.put(e.hashCode(), e);
        one.addEdge(e);
        two.addEdge(e);
        return true;
}

public boolean containsEdge(Edge e){
        if(e.getOne() == null || e.getTwo() == null){
            return false;
        }
        return this.edges.containsKey(e.hashCode());
}
     
public Edge removeEdge(Edge e){
       e.getOne().removeEdge(e);
       e.getTwo().removeEdge(e);
       return this.edges.remove(e.hashCode());
}
  
public boolean containsVertex(Vertex vertex){
        return this.vertices.get(vertex.getCity()) != null;
}

public Vertex getVertex(String city){
        return vertices.get(city);
}

public boolean addVertex(Vertex vertex, boolean overwriteExisting){
  Vertex current = this.vertices.get(vertex.getCity());
  if(current != null){
    if(!overwriteExisting){
      return false; 
    }
    while(current.getNeighborCount() > 0){
      this.removeEdge(current.getEdge(0)); 
    }
  } 
  vertices.put(vertex.getCity(), vertex);
  return true;  
}

public void DFS(Graph G, Vertex v){
  v.explored();
  /*while(v.edgeList.){
    
  }*/
}
/*public Vertex removeVertex(String city){
        Vertex v = vertices.remove(city);
        while(v.getNeighborCount() > 0){
            this.removeEdge(v.getNeighbor((0)));
        }
        return v;
    }
    public Set<String> vertexKeys(){
        return this.vertices.keySet();
    }
    public Set<Edge> getEdges(){

        return new HashSet<Edge>(this.edges.values());

    }*/
}
