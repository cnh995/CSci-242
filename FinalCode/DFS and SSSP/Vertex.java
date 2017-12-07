import java.util.ArrayList;


public class Vertex
{
	String city = "";
	int value = Integer.MAX_VALUE;
	boolean visited = false;
	int edgeValue = 0;
	Vertex[] connectedVertices = new Vertex[113];
	int connectedVerticeNum = 0;
	int connectedEdgesNum = 0;
	Edge[] connectedEdges = new Edge[287];
	Vertex parent = null;
	boolean visited2 = false;

	public void setVisited2(boolean check)
	{
		visited2 = check;
	}

	public boolean getVisited2()
	{
		return visited2;
	}

	public Vertex getParent()
	{
		return parent;
	}

	public void setParent(Vertex parent)
	{
		this.parent = parent;
	}

	public Vertex(String city)
	{
		this.city = city;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	public boolean isVisited()
	{
		return visited;
	}

	public void setVisited(boolean visited)
	{
		this.visited = visited;
	}

	public void addVerticie(Vertex vertice)
	{
		connectedVertices[connectedVerticeNum] = vertice;
		connectedVerticeNum++;
	}

	public int getConnectedVerticeNum()
	{
		return connectedVerticeNum;
	}

	public void addEdge(Edge edge)
	{
		connectedEdges[connectedEdgesNum] = edge;
		connectedEdgesNum++;
		if(connectedEdges[1] != null)
		{
			BubbleSort();
		}
	}

	public int getConnectedEdgesNum()
	{
		return connectedVerticeNum;
	}

	public Edge[] getEdges()
	{
		return connectedEdges;
	}

	public Edge getEdge(int x)
	{
		return connectedEdges[x];
	}

	public boolean getVisited()
	{
		return visited;
	}

	public Vertex[] getVertices()
	{
		return connectedVertices;
	}

	public void BubbleSort()
	{
	     int j;
	     boolean flag = true;   // set flag to true to begin first pass
	     Edge temp;   //holding variable

	     while ( flag )
	     {
	            flag= false;    //set flag to false awaiting a possible swap
	            for( j=0;  j < connectedEdges.length -1;  j++ )
	            {

		            	if(j + 1 <= connectedEdges.length && connectedEdges[j+1] != null)
				{
		                   if ( connectedEdges[j].getWeight() > connectedEdges[j+1].getWeight())   // change to > for ascending sort
		                   {
		                           temp = connectedEdges[ j ];                //swap elements
		                           connectedEdges[ j ] = connectedEdges[ j+1 ];
		                           connectedEdges[ j+1 ] = temp;
		                          flag = true;              //shows a swap occurred
		                  }
		            }
	            }
	      }
	}
}
