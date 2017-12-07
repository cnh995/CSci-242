import java.io.*;
import java.util.*;
import java.lang.*;

public class Main
{
	public static void Dijkstras(Vertex[] vertices, Vertex src){

		Vertex name = null;
		int weight = 0;
		boolean check = false;
		int edgeWeight = 0;
		Edge edge = null;

		src.setVisited(true);
		for(int x = 0; x < src.getConnectedEdgesNum(); x++)
		{
			if(src.getEdge(x).getCity1().getCity().equals(src.getCity()))
			{
				name = src.getEdge(x).getCity2();
			}
			if(src.getEdge(x).getCity2().getCity().equals(src.getCity()))
			{
				name = src.getEdge(x).getCity1();
			}


			for(int y = 0; y < vertices.length; y++)
			{
				edgeWeight = src.getEdge(x).getWeight();
				weight = src.getEdge(x).getWeight() + src.getValue();


					check = name.getCity().equals(vertices[y].getCity());
					if (check)
					{
						if(vertices[y].getCity().equals("Seattle"))
						{
							int r = 0;
							r = 20;
						}

						if(vertices[y].getValue() > weight)
						{
							vertices[y].setValue(weight);
							vertices[y].setParent(src);
							
						}
						break;
					}
			}
		}

		for(int y = 0; y < src.getConnectedVerticeNum(); y++)
		{
			for(int z = 0; z < vertices.length; z++)
			{
				if (src.getVertices()[y].getCity().equals(vertices[z].getCity()))
				{
					name = vertices[z];
					break;
				}
			}

			if(name.getVisited() == false)
			{
				Dijkstras(vertices, name);
			}

		}

	}

	public static void DijkstrasSecond(Vertex[] vertices, Vertex src)
	{
		Vertex name = null;
		int weight = 0;
		boolean check = false;
		int edgeWeight = 0;
		Edge edge = null;

		src.setVisited2(true);
		for(int x = 0; x < src.getConnectedEdgesNum(); x++)
		{
			if(src.getEdge(x).getCity1().getCity().equals(src.getCity()))
			{
				name = src.getEdge(x).getCity2();
			}
			if(src.getEdge(x).getCity2().getCity().equals(src.getCity()))
			{
				name = src.getEdge(x).getCity1();
			}


			for(int y = 0; y < vertices.length; y++)
			{
				edgeWeight = src.getEdge(x).getWeight();
				weight = src.getEdge(x).getWeight() + src.getValue();
				check = name.getCity().equals(vertices[y].getCity());
					if (check)
					{
						System.out.println("\nSource: " + src.getCity() + " value: " + src.getValue());
						System.out.println("Destination: " + vertices[y].getCity() + " value: " + vertices[y].getValue() );
						System.out.println("Edge: \n" + src.getEdge(x).getCity1().getCity() + " -- to -- " + src.getEdge(x).getCity2().getCity() + " --value: " + src.getEdge(x).getWeight() + "");


						if(vertices[y].getCity().equals("Seattle"))
						{
							int r = 0;
							r = 20;
						}

						if(vertices[y].getValue() > weight)
						{
							vertices[y].setValue(weight);
							vertices[y].setParent(src);
							System.out.println("Destination City post change: " + vertices[y].getCity() + " value: " + vertices[y].getValue() + " parent: " + vertices[y].getParent().getCity() + "\n");
						}
						System.out.println("\n");
						break;
					}



			}
		}

		for(int y = 0; y < src.getConnectedVerticeNum(); y++)
		{
			for(int z = 0; z < vertices.length; z++)
			{
				if (src.getVertices()[y].getCity().equals(vertices[z].getCity()))
				{
					name = vertices[z];
					break;
				}
			}

			if(name.getVisited() == false)
			{
				Dijkstras(vertices, name);
			}

		}

	}

	public static void DijkstrasLongestPath(Vertex[] vertices, Vertex src)
	{
		Vertex name = null;
		int weight = 0;
		boolean check = false;
		int edgeWeight = 0;
		Edge edge = null;

		src.setVisited(true);
		for(int x = 0; x < src.getConnectedEdgesNum(); x++)
		{
			if(src.getEdge(x).getCity1().getCity().equals(src.getCity()))
			{
				name = src.getEdge(x).getCity2();
			}
			if(src.getEdge(x).getCity2().getCity().equals(src.getCity()))
			{
				name = src.getEdge(x).getCity1();
			}

			for(int y = 0; y < vertices.length; y++)
			{
				edgeWeight = src.getEdge(x).getWeight();
				weight = src.getEdge(x).getWeight() + src.getValue();


					check = name.getCity().equals(vertices[y].getCity());
					if (check)
					{
						if(vertices[y].getCity().equals("Seattle"))
						{
							int r = 0;
							r = 20;
						}

						if(vertices[y].getValue() < weight)
						{
							vertices[y].setValue(weight);
							vertices[y].setParent(src);
						}
						break;
					}


			}
		}

		for(int y = 0; y < src.getConnectedVerticeNum(); y++)
		{
			for(int z = 0; z < vertices.length; z++)
			{
				if (src.getVertices()[y].getCity().equals(vertices[z].getCity()))
				{
					name = vertices[z];
					break;
				}
			}

			if(name.getVisited() == false)
			{
				Dijkstras(vertices, name);
			}

		}

	}


	public static void reset(Vertex[] vertices)
	{
		for(int x = 0; x < vertices.length; x++)
		{
			vertices[x].setVisited(false);
			vertices[x].setParent(null);
			vertices[x].setValue(Integer.MAX_VALUE);
		}
	}

	public static void DFS(Vertex[] towns, Vertex town, Edge[] roads, Weight weight)
	{
		System.out.println("Towns traversed through DFS: "+ town.getCity());

		town.setVisited(true);
		town.setValue(weight.getWeight());
		for(int x = 0; x < town.getConnectedVerticeNum(); x++)
		{
			String name = town.getEdge(x).getCity(town).getCity();
			Vertex newTown = findTown(name, towns);
			int newTownWeight = town.getEdge(x).getWeight();

			if(newTown.getVisited() == false)
			{
				setDiscoveryEdge(town.getEdge(x), roads);
				weight.addWeight(newTownWeight);
				DFS(towns, newTown, roads, weight);
			}

		}
	}

	public static Vertex findTown(String name, Vertex[] towns)
	{
		Vertex town = null;

		for(int x = 0; x < towns.length; x++)
		{
			if(towns[x].getCity().equals(name))
			{
				town = towns[x];
			}
		}
		return town;
	}

	public static void findBackEdge(Edge[] roads, Edge[] backEdge)
	{
		int counter = 0;
		for(int x = 0; x < roads.length; x++)
		{
			if(roads[x].getDiscoverEdge() == false)
			{
				backEdge[counter] = roads[x];
				counter++;
			}
		}
	}

	public static void setDiscoveryEdge(Edge road, Edge[] roads)
	{
		int whileCheck = 0;

		for(whileCheck = 0; whileCheck < roads.length; whileCheck++)
		{
			if(roads[whileCheck].equals(road))
			{
				roads[whileCheck].setDiscoveryEdge();
				return;
			}
		}
	}

	public static Vertex getGrandForks(Vertex[] towns)
	{
		Vertex town = null;

		for(int x = 0; x < towns.length; x++)
		{
			if(towns[x].getCity().equals("Grand Forks"))
			{
				town = towns[x];
				return town;
			}
		}

		return town;
	}

	public static void readFile(Vertex[] towns, Edge[] roads, BufferedReader reader) throws NumberFormatException, IOException
	{
		String line = null;
		String[] tokens = new String[3];
		int edgeValue = 0;

		Vertex first = null;
		Vertex second = null;
		Edge edge = null;

		while((line = reader.readLine()) != null)
		{
			tokens = line.split("//");

			edgeValue = Integer.parseInt(tokens[2]);
			first = new Vertex(tokens[0]);
			second = new Vertex(tokens[1]);

			edge = new Edge(first, second, edgeValue);

			boolean check = false;
			for(int x = 0; x < roads.length; x++)
			{
				if(roads[x] == null)
				{
					roads[x] = edge;
				}

				if(roads[x].getCity1().equals(edge.getCity1()) || roads[x].getCity1().equals(edge.getCity2()))
				{
					if(roads[x].getCity2().equals(edge.getCity2()) || roads[x].getCity1().equals(edge.getCity2()))
					{
						check = true;
						break;
					}
				}
			}

			if(check == false)
			{
				for(int x = 0; x < roads.length; x++)
				{
					if(roads[x] == null)
					{
						roads[x] = edge;
					}
				}
			}

			check = false;
			boolean check1 = false;
			int numStore = 0;
			int numStore1 = 0;
			for(int x = 0; x < towns.length; x++)
			{
				if(towns[x] == null)
				{
					break;
				}

				if(towns[x].getCity().equals(tokens[0]))
				{
					check = true;
					numStore = x;
					first = towns[x];
				}

				if(towns[x].getCity().equals(tokens[1]))
				{
					check1 = true;
					numStore1 = x;
					second = towns[x];
				}

				if(check == true && check1 == true)
				{

					break;
				}

			}

			if(check == false)
			{
				for(int x = 0; x < towns.length; x++)
				{
					if(towns[x] == null)
					{
						towns[x] = first;
						numStore = x;
						towns[x].addEdge(edge);
						break;
					}
				}

			}
			else
			{
				towns[numStore].addVerticie(second);
				towns[numStore].addEdge(edge);
			}


			if(check1 == false)
			{
				for(int x = 0; x < towns.length; x++)
				{
					if(towns[x] == null)
					{
						towns[x] = second;
						numStore1 = x;
						towns[x].addEdge(edge);
						break;
					}
				}
			}
			else
			{
				towns[numStore1].addVerticie(first);
				towns[numStore1].addEdge(edge);
			}

			if(check == false)
			{
				towns[numStore].addVerticie(second);
			}
			if(check1 == false)
			{
				towns[numStore1].addVerticie(first);
			}
		}

	}

	public static void printParents(Vertex[] vertices, String stringName)
	{
		Vertex name = null;
		Vertex parent = null;
		String parentName = "";


		for(int x = 0; x < vertices.length; x++)
		{
			if(vertices[x].getCity().equals(stringName))
			{
				System.out.println("Value of node " + vertices[x].getValue());

				name = null;
				name = vertices[x];

				while(name != null)
				{
					if(name.getParent() == null)
					{
						break;
					}

					System.out.println("Route from destination to start: " + name.getCity() + " To " + name.getParent().getCity());

					parent = name.getParent();
					parentName = parent.getCity();

					for(int y = 0; y < vertices.length; y++)
					{
						if(parentName.equals(vertices[y].getCity()))
						{
							name = vertices[y];
						}
					}
				}
			}
		}
	}

	public static Vertex findVertice(Vertex[] vertices, String name)
	{
		Vertex node = null;
		for(int x =0; x < vertices.length; x++)
		{
			if(vertices[x].getCity().equals(name))
			{
				node = vertices[x];
			}
		}

		return node;
	}

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		FileReader file = new FileReader(new File("Edges.txt"));

        BufferedReader reader = new BufferedReader(file);


		Vertex[] vertices = new Vertex[114];
		Edge[] edges = new Edge[290];

		readFile(vertices, edges, reader);
		
		Vertex town = getGrandForks(vertices);

		System.out.println("Before DFS: " + town.getCity());

		Weight weight = new Weight();

		DFS(vertices, town, edges, weight);

		System.out.println(weight.getWeight());

		Edge[] backEdges = new Edge[290];
		findBackEdge(edges, backEdges);

		for(int x = 0; x < backEdges.length; x++)
		{
			if(backEdges[x] == null)
			{
				break;
			}
		}

		System.out.println();

		Vertex name = null;
		name = findVertice(vertices, "Grand Forks");
		reset(vertices);
		name.setValue(0);
		Dijkstras(vertices, name);
		printParents(vertices, "Seattle");

		System.out.println();

		name = null;
		name = findVertice(vertices, "Seattle");
		reset(vertices);
		name.setValue(0);
		Dijkstras(vertices, name);
		printParents(vertices, "San Diego");

		System.out.println();

		name = null;
		name = findVertice(vertices, "San Diego");
		reset(vertices);
		name.setValue(0);
		Dijkstras(vertices, name);
		printParents(vertices, "Houston");

		System.out.println();

		name = null;
		reset(vertices);
		name = findVertice(vertices, "Houston");
		name.setValue(0);
		Dijkstras(vertices, name);
		printParents(vertices, "Key West");

		System.out.println();

		name = null;
		name = findVertice(vertices, "Key West");
		reset(vertices);
		name.setValue(0);
		Dijkstras(vertices, name);
		printParents(vertices, "New York City");

		System.out.println();

		name = null;
		name = findVertice(vertices, "New York City");
		reset(vertices);
		name.setValue(0);
		Dijkstras(vertices, name);
		printParents(vertices, "Chicago");

		System.out.println();

		name = null;
		name = findVertice(vertices, "Chicago");
		reset(vertices);
		name.setValue(0);
		Dijkstras(vertices, name);
		printParents(vertices, "Grand Forks");

	}

	private static void resetLargest(Vertex[] vertices)
	{
		for(int x = 0; x < vertices.length; x++)
		{
			vertices[x].setVisited(false);
			vertices[x].setVisited2(false);
			vertices[x].setParent(null);
			vertices[x].setValue(0);
		}
	}
}
