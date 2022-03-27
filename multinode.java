
import java.util.ArrayList;

public class multinode <T> {
    protected T data;
    protected int id=1;
    protected multinode parent=null;
    protected ArrayList<multinode> child;
    
    public multinode(T data,int id)
    {
        this.data = data;
        child = new ArrayList<multinode>();
        parent=null;
        this.id=id;
    }
    public multinode(T data,multinode p,int id)
    {
        this.data = data;
        child = new ArrayList<multinode>();
        parent=p;
        this.id=id;
    }
    public void setData(T data)
    {
        this.data = data;
    }
    public T getData()
    {
        return data;
    }
    public multinode getNode(int x)
    {
        if (x >= 0 && x < child.size()) {
            return child.get(x);

        } else {
            return null;

        }
    }
    public multinode getParent()
    {
        return parent;
    }
    public void insertChild(T data,int id)
    {
        multinode n=new multinode(data,this,id);
        child.add(n);
    }
    boolean isEmpty()
    {
        return data==null;
    }
}
