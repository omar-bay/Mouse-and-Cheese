import java.util.*;
public class main {
	public static int stamina = 3;
	public static int bonus = 2;
	public static boolean eaten0=false;
	public static boolean eaten1=false;
	public static boolean eaten2=false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cs = new Scanner(System.in);
		System.out.print("Enter Stamina: ");
		stamina = cs.nextInt();
		System.out.print("Enter Bonus: ");
		bonus = cs.nextInt();
		int[][] goal_m = { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,1} };
		int[][] initial_m = { {0,0,0,0,0}, {0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} };
		table goal = new table(goal_m);
		table initial = new table(initial_m);
		initial.stamina = stamina;
		multitree<table> tree = new multitree<table>(initial);
		BFS(tree, goal);
		System.out.println("Done");

	}
	
	public static table apply(char op, table state) {
		state.findEntry();
		int i=state.i;
		int j=state.j;
		table new_table = new table(state.a);
		new_table.stamina = state.stamina;
		if(new_table.stamina<=0)
			return null;
		new_table.stamina--;
		switch(op) {
			case 'u':
				if(i==0)
					return null;
				else {
					if( (i-1==0&&j==0&&!eaten0) || (i-1==2&&j==3&&!eaten1) || (i-1==3&&j==0&&!eaten2) ) {
						new_table.stamina+=bonus;
						if(i-1==0&&j==0) eaten0=true;
						if(i-1==2&&j==3) eaten1=true;
						if(i-1==3&&j==0) eaten2=true;
					}
					new_table.a[i][j] = 0;
					new_table.a[i-1][j] = 1;
				}
				break;
			case 'd':
				if(i==4)
					return null;
				else {
					if( (i+1==0&&j==0&&!eaten0) || (i+1==2&&j==3&&!eaten1) || (i+1==3&&j==0&&!eaten2) ) {
						new_table.stamina+=bonus;
						if(i+1==0&&j==0) eaten0=true;
						if(i+1==2&&j==3) eaten1=true;
						if(i+1==3&&j==0) eaten2=true;
					}
					new_table.a[i][j] = 0;
					new_table.a[i+1][j] = 1;
				}
				break;
			case 'r':
				if(j==4)
					return null;
				else {
					if( (i==0&&j+1==0&&!eaten0) || (i==2&&j+1==3&&!eaten1) || (i==3&&j+1==0&&!eaten2) ) {
						new_table.stamina+=bonus;
						if(i==0&&j+1==0) eaten0=true;
						if(i==2&&j+1==3) eaten1=true;
						if(i==3&&j+1==0) eaten2=true;
					}
					new_table.a[i][j] = 0;
					new_table.a[i][j+1] = 1;
				}
				break;
			case 'l':
				if(j==0)
					return null;
				else {
					if((i==0&&j-1==0&&!eaten0) || (i==2&&j-1==3&&!eaten1) || (i==3&&j-1==0&&!eaten2)) {
						new_table.stamina+=bonus;
						if(i==0&&j-1==0) eaten0=true;
						if(i==2&&j-1==3) eaten1=true;
						if(i==3&&j-1==0) eaten2=true;
					}
					new_table.a[i][j] = 0;
					new_table.a[i][j-1] = 1;
				}
				break;
		}
		return new_table;
	}
	
	public static void BFS(multitree tree, table goal) {
		boolean found = false;
		Queue<multinode> q = new LinkedList<multinode>();
		q.add(tree.root);
		while(!q.isEmpty() && !found) {
			multinode node = q.remove();
			if( ((table)node.data).isequal(goal) ) {
				tree.display_solution(node);
				found=true;
			} else {
				table[] moves = new table[4];
				moves[0] = apply('u', (table)node.data);
				moves[1] = apply('d', (table)node.data);
				moves[2] = apply('l', (table)node.data);
				moves[3] = apply('r', (table)node.data);
				
				for(int i=0;i<4;i++) {
					if(moves[i]!=null && moves[i].a!=null) {
	           		 	tree.insertnode(moves[i],node.id);
					}
				}
				for(multinode<table> kid : (ArrayList<multinode>)node.child) {
            		q.add(kid);
            	}
			}
		}
	}

}
