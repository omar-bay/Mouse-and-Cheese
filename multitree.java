public class multitree<T> {

    protected multinode root;
    protected int nbnodes = 1;
    protected boolean flag = false;
    protected multinode current = null;
    
    public multitree()
    {
        root=null;
    }
    public multitree(T data) {
        root = new multinode(data, 1);
    }
    public void setRoot(T data){
        root = new multinode(data, 1);
    }
    public multinode search_id(int id) {
        current = null;
        flag =false;
        search_id(id, root);
        return current;
    }
    public void search_id(int id, multinode node) {
        if (flag == true || node == null) {
            return;
        }
        if (node.id == id) {
            flag = true;
            current = node;
            return;
        } else {
            for (int i = 0; i < node.child.size(); i++) {
                search_id(id, (multinode) node.child.get(i)); 
            }
        }
    }
    public multinode search_data(T t) {
        current = null;
        flag =false;
        search_data(t, root);
        return current;
    }
    public void search_data(T t, multinode node) {
        if (flag == true || node == null) {
            return ;
        }
        T tt=(T)node.getData();
        if (tt==t) {
            flag = true;
            current = node;
            return;
        } else {
            for (int i = 0; i < node.child.size(); i++) {
                search_data(t, (multinode) node.child.get(i));
            }
        }
    }
    public boolean insertnode(T data, int Parentid) {
        multinode n = search_id(Parentid);
        if (n != null) {
            n.insertChild(data,++nbnodes);
            return true;
        }
        return false;
    }
    public void display()
    {
        display(root,null);
    }
    public void display(multinode node,multinode nodep)
    {
        if(node!=null)
        {
            if(nodep!=null)
                 System.out.println(nodep.getData()+": "+node.id+": "+node.getData());
            else
                 System.out.println("N: "+node.id+": "+node.getData());
            for(int i=0; i<node.child.size(); i++)
            {
                display(node.getNode(i),node);
            }
        }
    }
    public void display_solution(multinode node)
    {
        if(node!=null)
        {
            display_solution(node.getParent());
            System.out.println(node.getData());
        }
    }
}

