import java.util.ArrayList;

/**
 * Vertex class
 *
 * @author Hieu Duong
 * @date 4/20/18
 */

//////////////////////////////////////////////////////////////
public class Vertex <T>{
    T data;
    ArrayList<Vertex<T>> connected;

    public Vertex(T d){
        data=d;
        connected=new ArrayList();
    }

    public void addEdge(Vertex<T> v){
        if(!connected.contains(v)) {
            connected.add(v);
            //System.out.println("Add Edge: "+v.toString()+", size: "+connected.size());
        }
        //Otherwise mission accomplished...nothing to do
    }

    public T getData() {
        return data;
    }

    public ArrayList<Vertex<T>> getConnected() {
        return connected;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                '}';
    }

    public boolean equals(Object o){


        if(o instanceof Vertex){
            return o==this;
        }

        T d = (T) o;
        return o.equals(data);
        /*
        if(o instanceof Integer){
            return o.equals(data);
        }
        */
        //return false;
    }
}