public class Edge
{
	Vertex[] names = new Vertex[2];
	int weight = 0;
	boolean discoveryEdge = false;
	boolean backEdge = false;
	
	public Edge(Vertex name1, Vertex name2, int edgeValue)
	{
		names[0] = name1;
		names[1] = name2;
		this.weight = edgeValue;
	}
	
	public Vertex getCity(Vertex town)
	{
		if(town.getCity().equals(names[0].getCity()))
		{
			return getCity2();
		}
		if(town.getCity().equals(names[1].getCity()))
		{
			return getCity1();
		}
		
		return town;		
	}
	
	public Vertex getCity1()
	{
		return names[0];
	}
	
	public Vertex getCity2()
	{
		return names[1];
	}
	
	public int getWeight()
	{
		return weight;
	}

	public boolean getBackEdge()
	{
		
		return backEdge;
	}
	
	public boolean getDiscoverEdge()
	{
		
		return discoveryEdge;
	}
	
	public void setDiscoveryEdge()
	{
		
		discoveryEdge = true;
	}
	
	public void setBackEdge()
	{
		
		backEdge = true;
	}
}
