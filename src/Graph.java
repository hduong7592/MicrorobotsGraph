import java.util.*;

///////////////////////////////////////////////////////////////
//
// TODO: Complete Graph Code Below
//
///////////////////////////////////////////////////////////////

public class Graph<T>{
	//Need Structure to Hold verts, edges (Must complete methods)
	ArrayList<Vertex<T>> verts;

	public Graph(){
		verts = new ArrayList();
	}
	//Precondition: data will become a new vertex...data is not null
	//Postcondition: data will get added to the graph with no edges in or out.
	public void addVertex(T data){
		verts.add(new Vertex(data));
	}
	
	//Precondition: v1 and v2 are vertices of the graph
	//Postcondition: will construct an edge between v1 and v2, will be undirected.
	public void addEdge(T data1, T data2){

		//System.out.println("data1: "+data1);
		//System.out.println("data2: "+data2);

		Vertex v1 = verts.get(((Spot)data1).getGraphIndex());
		//System.out.println("V1: "+v1.toString());

		Vertex v2 = verts.get(((Spot)data2).getGraphIndex());
		//System.out.println("V2: "+v2.toString());
		/*
		Vertex<T> v1 = null;
		for(int i =0; i<verts.size(); i++){
			//System.out.println("Vertex: "+verts.get(i));
			if(verts.get(i).getData().equals(data1)){
				System.out.println("Vertex1: "+verts.get(i));
			}
			//if(verts.get(i).equals(data1)) v1 = verts.get(i);
		}

		Vertex<T> v2 = null;
		for(int i =0; i<verts.size(); i++) {
			//if (verts.get(i).equals(data2)) v2 = verts.get(i);
			if(verts.get(i).getData().equals(data2)){
				System.out.println("Vertex2: "+verts.get(i));
			}
		}

		//if(v1==null) throw new RuntimeException("That data(1) is not exist in the graph.");
		//if(v2==null) throw new RuntimeException("That data(2) is not exist in the graph.");
		System.out.println("V1: "+v1.toString());
		System.out.println("V2: "+v2.toString());
*/
		v1.addEdge(v2);
	}

	//Precondition: source and sink are vertices of the graph
	//Postcondition: returns an iteratable list such that following the path from 0 -> n will take us from the source to the sink. The source and the sink may/may not be in the sequence. 
	/*
	public ArrayList<T> getShortestPath(T source, T sink){
		Spot roboSpot = (Spot)source;
		Spot goalSpot = (Spot)sink;
		System.out.println("Souce: "+source.toString()+", index: "+roboSpot.getGraphIndex());
		System.out.println("Sink: "+sink.toString()+", index: "+goalSpot.getGraphIndex());

		Vertex v = verts.get(roboSpot.getGraphIndex());
		System.out.println("Vertex: "+v.toString());

		ArrayList<Vertex<Spot>> edges = v.getConnected();
		System.out.println("Edge size: "+ edges.size());
		for(int i=0; i<edges.size(); i++){
			Spot edge = edges.get(i).getData();
			if(edge.equals(goalSpot)){
				System.out.println("Found path");
			}
			System.out.println("Edges: "+edge.toString());
		}
		return new ArrayList();
	}
*/
	public void getShortestPath(T source, T sink){
		Spot roboSpot = (Spot)source;
		Spot goalSpot = (Spot)sink;

		/*
		if(roboSpot.equals(goalSpot)){
			System.out.println("Found path");
			return;
		}
		//System.out.println("Souce: "+source.toString()+", index: "+roboSpot.getGraphIndex());
		//System.out.println("Sink: "+sink.toString()+", index: "+goalSpot.getGraphIndex());

		Vertex v = verts.get(roboSpot.getGraphIndex());
		System.out.println("Vertex: "+v.toString());

		ArrayList<Vertex<Spot>> edges = v.getConnected();
		System.out.println("Edge size: "+ edges.size());
		for(int i=0; i<edges.size(); i++){
			Spot edge = edges.get(i).getData();
			getShortestPath((T)edge, (T)goalSpot);
		}
		*/

		// Mark all the vertices as not visited(By default
		// set as false)
/*
		Vertex goalS = verts.get(goalSpot.getGraphIndex());
		System.out.println("Goal vertex: "+goalS+", index: "+((Spot)goalS.getData()).getGraphIndex());

		ArrayList<Vertex<Spot>> goalEdges = goalS.getConnected();

		for(int i=0; i<goalEdges.size(); i++){
			Spot edge = goalEdges.get(i).getData();
			System.out.println("goal Edges: "+edge.toString()+", index: "+edge.getGraphIndex());

		}
*/

		//Vertex goalS = verts.get(goalSpot.getGraphIndex());
		System.out.println("Goal Spot: "+goalSpot+", index: "+goalSpot.getGraphIndex());

		//ArrayList<Vertex<Spot>> goalEdges = goalS.getConnected();

		boolean visited[] = new boolean[verts.size()];

		// Create a queue for BFS
		LinkedList<Vertex> queue = new LinkedList<Vertex>();

		// Mark the current node as visited and enqueue it
		visited[roboSpot.getGraphIndex()]=true;
		Vertex v = verts.get(roboSpot.getGraphIndex());
		queue.add(v);

		while (queue.size() != 0)
		{
			// Dequeue a vertex from queue and print it
			Vertex vt = queue.poll();
			System.out.print(vt+" ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it







			ArrayList<Vertex<Spot>> edges = vt.getConnected();
			//System.out.println("Edge size: "+ edges.size());
			for(int i=0; i<edges.size(); i++){
				Spot edge = edges.get(i).getData();
				//System.out.println("robo Edges: "+edge.toString()+", index: "+edge.getGraphIndex());
				if(edge.getGraphIndex()==goalSpot.getGraphIndex()){
					System.out.print(edge+" ");
					System.out.println("Path");
					return;
				}
				if(!visited[edge.getGraphIndex()]){
					visited[edge.getGraphIndex()]=true;
					queue.add(verts.get(edge.getGraphIndex()));
				}
			}
		}
	}
	
	//Precondition: v1 and v2 are vertices of the graph
	//Postcondition: returns true if there is an edge from v1 to v2, false otherwise
	public boolean isAdjacent(T v1, T v2){
		return v1.equals(v2); //this is not correct...just here as a placeholder
	} 

}