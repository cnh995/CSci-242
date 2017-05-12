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

		
	}
}
