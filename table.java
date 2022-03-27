
public class table {
    protected int [][]a=new int[5][5];
    protected int i;
    protected int j;
    public int stamina = 0;

    public  table() {
    }
    public  table(int [][]b) {
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                a[i][j]=b[i][j];
            }
        }
    }
    public  table(table b) {
        insertTable(b);
    }
    public void insertTable(table b){
        if(b!=null){
           for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                this.a[i][j]=b.a[i][j];
            }
        }
        }else{
            this.a=null;
        }  
    }
    @Override
    public String toString(){
        String str="";
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                str+=a[i][j]+" ";
            }
            str+="\n";
        }
        return str;
    }   
    
    public boolean isequal(table t){
        if(t==null || this.a==null)
           return false;
        for(int ii=0;ii<5;ii++){
            for(int jj=0;jj<5;jj++){
              if(a[ii][jj]!=t.a[ii][jj]){
                  return false;
              }
            }
        }
        return true;
    }
    
    public void findEntry() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(a[i][j]==1) {
					this.i = i;
					this.j = j;
				}
			}
		}
	}
}