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

		Vertex v1 = verts.get(((Spot)data1).getGraphIndex());
		Vertex v2 = verts.get(((Spot)data2).getGraphIndex());

		if(v1==null) throw new RuntimeException("That data(1) is not exist in the graph.");
		if(v2==null) throw new RuntimeException("That data(2) is not exist in the graph.");

		v1.addEdge(v2);
	}

	//Precondition: source and sink are vertices of the graph
	//Postcondition: returns an iteratable list such that following the path from 0 -> n will take us from the source to the sink. The source and the sink may/may not be in the sequence. 

	public ArrayList<T> getShortestPath(T source, T sink){

		ArrayList<T> path = new ArrayList<>();
		Spot roboSpot = (Spot)source;
		Spot goalSpot = (Spot)sink;

		System.out.println("Goal Spot: "+goalSpot+", index: "+goalSpot.getGraphIndex());

		boolean visited[] = new boolean[verts.size()];

		LinkedList<Vertex> queue = new LinkedList<>();

		// Mark the current node as visited and enqueue it
		visited[roboSpot.getGraphIndex()]=true;
		Vertex v = verts.get(roboSpot.getGraphIndex());
		queue.add(v);

		while (queue.size() != 0)
		{
			// Dequeue a vertex from queue
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
					//System.out.print(edge+" ");
					//System.out.println("Path");
					path.add((T)edge);
				}
				if(!visited[edge.getGraphIndex()]){
					visited[edge.getGraphIndex()]=true;
					queue.add(verts.get(edge.getGraphIndex()));
				}
			}
		}
		return path;
	}

	//Precondition: v1 and v2 are vertices of the graph
	//Postcondition: returns true if there is an edge from v1 to v2, false otherwise
	public boolean isAdjacent(T v1, T v2) {
		boolean isAdjacent = false;
		Vertex vertex1 = (Vertex) v1;
		Vertex vertex2 = (Vertex) v2;

		ArrayList<Vertex<Spot>> v1edges = vertex1.getConnected();
		ArrayList<Vertex<Spot>> v2edges = vertex2.getConnected();

		for (int i = 0; i < v1edges.size(); i++) {
			Spot v1edge = v1edges.get(i).getData();

			for (int j = 0; j < v2edges.size(); j++) {
				Spot v2edge = v2edges.get(j).getData();
				if (v1edge.getGraphIndex() == v2edge.getGraphIndex()) {
					isAdjacent = true;
				}
			}
		}
		return isAdjacent;
	}
}