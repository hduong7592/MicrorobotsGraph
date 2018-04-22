import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class GraphAL<T>{
	ArrayList<Vertex<T>> verts;
	
	public GraphAL(){
		verts = new ArrayList();
	}
	
	public void addVertex(T data){
		verts.add(new Vertex(data));
	}
	
	public void addEdge(T data1, T data2){
		Vertex<T> v1 = null;
		for(int i =0; i<verts.size(); i++){
			//System.out.println("Vertex: "+verts.get(i).getData());
			Vertex<T> v = verts.get(i);
			if(v.equals(data1))
				//System.out.println("Vertex: "+v.getData());
				v1 = v;

		}
			//if(verts.get(i).equals(data1)) v1 = verts.get(i);
		
		Vertex<T> v2 = null;
		for(int i =0; i<verts.size(); i++)
			if(verts.get(i).equals(data2)) v2 = verts.get(i);
		
		if(v1==null) throw new RuntimeException("That data(1) is not in the graph...shame");
		if(v2==null) throw new RuntimeException("That data(2) is not in the graph...shame");
		v1.addEdge(v2);
	}

	public void DFS(int ind, T data) {
		//defaults to 0, but just for coverage
		int[] visited = new int[verts.size()];
		for (int i = 0; i < visited.length; i++) visited[i] = 0;

		// Create a queue for BFS
		LinkedList<Integer> discoveredVerts = new LinkedList<>();

		discoveredVerts.push(ind);
		while (!discoveredVerts.isEmpty()) {
			int cInd = discoveredVerts.pop();
			if (verts.get(cInd).equals(data)) {
				return;
			}
			visited[cInd] = 1; //visit our ind first
		}
	}


	public static void main(String[] args){
		/*
		Spot: blue:1
Spot: red:2
Spot: white:4
Spot: yellow:1
Spot: red:5
Spot: green:1
Spot: white:1
Spot: green:2
Spot: green:6
Spot: yellow:6
Spot: blue:5
Spot: red:1
Spot: yellow:2
Spot: white:2
Spot: pink:4
Spot: pink:1
Spot: yellow:5
Spot: pink:6
Spot: pink:3
Spot: yellow:3
Spot: green:3
Spot: blue:2
Spot: white:3
Spot: white:5
Spot: pink:2
Spot: red:4
Spot: green:5
Spot: blue:6
Spot: yellow:4
Spot: green:4
Spot: pink:5
Spot: red:6
Spot: blue:4
Spot: white:6
Spot: red:3
Spot: blue:3

		GraphAL<Integer> graphAL = new GraphAL<>();
		Vertex<Integer> vertex = new Vertex<>(1);
		System.out.println("My vertex: "+vertex.getData());
		//vertex.addEdge(new Vertex<>(1));
		graphAL.addVertex(1);
		graphAL.addVertex(2);
		graphAL.addEdge(1,2);

*/
		GraphAL<Spot> spotGraphAL = new GraphAL<>();
		spotGraphAL.addVertex(new Spot(4, 1));
		//spotGraphAL.addVertex(new Spot(6,1));
		spotGraphAL.addEdge(new Spot(4,1), new Spot(6,1));
	}

}