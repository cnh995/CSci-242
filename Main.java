import java.io.*;
import java.util.*;

public class Main
{
 public static void main(String[] args) throws FileNotFoundException
 {
  File dataFile = new File("Data.txt");
  Scanner inputFile = new Scanner(dataFile);

  ArrayList<Vertex> vertices = new ArrayList<Vertex>();
  ArrayList<Edge>  edges = new ArrayList<Edge>();
  String line;
  String[] parts;
  Vertex dest;
  Vertex source;
  int i = 0;

  while(inputFile.hasNext())
  {
   line = inputFile.nextLine();
   parts = line.split("%");
   
   source = new Vertex(parts[0]);
   dest = new Vertex(parts[1]);
   if(!vertices.contains(source))
    vertices.add(source);
   if(!vertices.contains(dest))
    vertices.add(dest);
   edges.add(new Edge(source, dest, Integer.parseInt(parts[2])));
   i++;
  }
  inputFile.close();
  for(i = 0; i < vertices.size(); i++)
  {
   vertices.get(i).makeEdgeList(edges);
  }
 Vertex v = vertices.get(0);
 for(i=0; i <vertices.size();i++){
   if(vertices.get(i).city.compareTo("Grand Forks")==0){
     v = vertices.get(i);
     break;
   }
 }
 //System.out.println(v.city);
 DFS(v);
 }
 
 public static void DFS(Vertex v){
    int index =0, weightTot=0;
    ArrayList<Edge> Discoveries = new ArrayList<Edge>();
    ArrayList<Edge> Back = new ArrayList<Edge>();
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
    System.out.println("The total weight traveled over the traverse is:   "+weightTot);
    return;
  }
}
