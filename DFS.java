import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;



public class DFS{
  public static void main(String[] args){
    Graph DFSGraph = new Graph();
    Scanner create = new Scanner(new File("Project.txt"));
    Vertex out, in;
    String stOne, stTwo;
    int next = 1; 
    int weight;
    Scanner scan = new Scanner(System.in);
  


    while(create.hasNextLine()){
      Edge connect;
      next = 1;
      while(create.hasNext()){
        if(next == 1){
          stOne = create.next();
          System.out.println(stOne);
        }
        else if(next == 2){
          stTwo = create.next();
          System.out.println(stTwo);
        }
        else if(next == 3){
          weight = create.nextInt();
          Edge newEdge = new Edge(in, out, weight);
        }
        next++;
        create.nextLine();
      }
    }
  }
}
