import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;



public class DFS{
  
  public void DFS(Vertex v){
    int index =0, weightTot=0;
    ArrayList Discoveries = new ArrayList<Edge>;
    ArrayList Back = new ArrayList<Edge>;
    Edge e;
    Vertex w;
    v.explored = true;
    System.out.println(v.city);
    while(index<=v.edgeList.size()){
      e = v.edgeList.get(index);
      if(e.explored=false){
        w = e.u;
        if(w.explored==false){
          Discoveries.add(e);
          weightTot+=e.weight;
          DFS(w);
        }
        else{
          Back.add(e);
        }
      }
      e.explored = true;
      index++;
    }
    index = 0;
    while(index<=Discoveries.size()){
      e = Discoveries.get(index);
      System.out.println("DISCOVERY EDGES");
      System.out.println(e.v.city+"   to   "+e.u.city);
      index++;
    }
    index=0;
    while(index<=Back.size()){
      e = Back.get(index);
      System.out.println("BACK EDGES");
      System.out.println(e.v.city+"   to   "+e.u.city);
      index++;
    }
    println("The total weight traveled over the traverse is:   "+weightTot);
    return;
  }
  
  public SSSP(Vertex v){
    
  }
}
