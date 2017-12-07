import java.util.*;
import java.lang.*;
import java.io.*;

public class MST
{
	public static int find(Subset subsets[], int i)
	{
		if (subsets[i].parent != i)
		{
			subsets[i].parent = find(subsets, subsets[i].parent);
		}

		return subsets[i].parent;
	}

	public static void main (String[] args) throws FileNotFoundException
	{
		File dataFile = new File("data.txt");
		Scanner inputFile = new Scanner(dataFile);
		


		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		ArrayList<Edge>  edges = new ArrayList<Edge>();
		String line;
		String[] parts;
		Vertex dest;
		Vertex source;
		int i = 0;
		int count = 0;

		while(inputFile.hasNext())
		{
			line = inputFile.nextLine();
			parts = line.split("%");
			
			source = new Vertex(parts[0]);
			dest = new Vertex(parts[1]);

			

			if(!vertices.contains(source))
			{
				source.id = count;
				count++;
				vertices.add(source);
			}

			if(!vertices.contains(dest))
			{
				dest.id = count;
				count++;
				vertices.add(dest);
			}

			edges.add(new Edge(source, dest, Integer.parseInt(parts[2])));
			i++;
		}

		inputFile.close();
		
		for(i = 0; i < vertices.size(); i++)
		{
			vertices.get(i).makeEdgeList(edges);
		}
	
		int V = vertices.size();  // Number of vertices in graph
		int E = edges.size();  // Number of edges in graph
		
		Edge result[] = new Edge[V];
		int e = 0;
		i = 0;
 
		//Sort array
		Edge edgeList[] = new Edge[edges.size()];
		edgeList = edges.toArray(edgeList);
		Arrays.sort(edgeList);
 
		Subset subsets[] = new Subset[V];
		for(i=0; i<V; ++i)
		{
			subsets[i]=new Subset();
		}
 
		// Create subsets for every Vertex
		for (int v = 0; v < V; ++v)
		{
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}
 
		i = 0;
 
		while (e < V - 1)
		{
			//Take smallest weighted edge
			Edge next_edge = new Edge(edgeList[i].v, edgeList[i].u, edgeList[i].weight);
 
			int x = find(subsets, edgeList[i].v.id);
			int y = find(subsets, edgeList[i].u.id);
 
			// If including this edge does't cause cycle, include it
			if (x != y)
			{
				result[e] = new Edge(next_edge.v, next_edge.u, next_edge.weight);
				
				int xroot = find(subsets, x);
				int yroot = find(subsets, y);
		 
				if (subsets[xroot].rank < subsets[yroot].rank)
				{
					subsets[xroot].parent = yroot;
				}
				else if (subsets[xroot].rank > subsets[yroot].rank)
				{
					subsets[yroot].parent = xroot;
				}
				else
				{
					subsets[yroot].parent = xroot;
					subsets[xroot].rank++;
				}
			}
			e++;
			i++;
		}
 
		// print the edges in MST
		System.out.println("Following are the edges in the constructed MST");
		int totalWeight = 0;
		int totalEdges = 0;
		for (i = 0; i < e; i++)
		{
			if(result[i] instanceof Edge)
			{
				System.out.println(result[i].v+" -- "+result[i].u+" == "+result[i].weight);
				totalWeight = totalWeight + result[i].weight;
				totalEdges++;
			}
		}
		System.out.println("\nTotal weight of MST: "+totalWeight);
		System.out.println("Number of Edges in MST: "+totalEdges);
	}
}
