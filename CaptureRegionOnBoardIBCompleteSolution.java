
//Editorial

public class Solution {
    public void solve(ArrayList<ArrayList<Character>> a) {
        
        //go through the edges, if theres an 'O' then do dfs and fill then with 'E'
        //go through matrix, if theres an 'O' fill it with 'X'
        //go through matrix, if theres an 'E' fill it with 'O'

        for(int i=0; i<a.size(); i++){
            for(int j=0; j<a.get(0).size(); j++){
                if(i==0 || j==0 || i==a.size()-1 || j==a.get(0).size()-1){
                    if(a.get(i).get(j)=='O'){
                        floodFill(i,j,a);
                    }
                }
            }
        }
        //System.out.println(a);

        for(int i=0; i<a.size(); i++){
            for(int j=0; j<a.get(0).size(); j++){
                if(a.get(i).get(j)=='O'){
                    a.get(i).set(j, 'X');
                }
            }
        }

        for(int i=0; i<a.size(); i++){
            for(int j=0; j<a.get(0).size(); j++){
                if(a.get(i).get(j)=='E'){
                    a.get(i).set(j, 'O');
                }
            }
        }

        
    }

    public void floodFill(int i, int j, ArrayList<ArrayList<Character>> a){

        if(isInvalid(i,j,a)) return;

        a.get(i).set(j, 'E');

        int[] cx = new int[]{0,0,1,-1};
        int[] cy = new int[]{1,-1,0,0};

        for(int n=0; n<4; n++){
            int x=i+cx[n];
            int y=j+cy[n];

            floodFill(x,y,a);
        }
    }

    public boolean isInvalid(int i, int j, ArrayList<ArrayList<Character>> a){

        //If i,j is out of bounds or if the element is not 'O' then it is invalid
        if(i<0||i>a.size()-1||j<0||j>a.get(0).size()-1||a.get(i).get(j)!='O')
            return true;
        return false;
    }
}

//fastest
class Solution2 {
    public void solve(ArrayList<ArrayList<Character>> a) {

        int n=a.size();
        int m=a.get(0).size();

        for(int i=0;i<m;i++)
        {
            if(a.get(0).get(i)=='O')
            {
                dfs(a,0,i);
            }
            if(a.get(n-1).get(i)=='O')
            {
                dfs(a,n-1,i);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(a.get(i).get(0)=='O')
            {
                dfs(a,i,0);
            }
            if(a.get(i).get(m-1)=='O')
            {
                dfs(a,i,m-1);
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a.get(i).get(j)=='O')
                {
                    a.get(i).set(j,'X');
                }
                else if(a.get(i).get(j)=='*')
                {
                    a.get(i).set(j,'O');
                }
            }
        }
    }

    public void dfs(ArrayList<ArrayList<Character>> a, int x, int y)
    {
        if(x<0 || y<0 || x>=a.size() || y>=a.get(0).size() || a.get(x).get(y)!='O')
        {
            return;
        }
        a.get(x).set(y,'*');
        dfs(a,x-1,y);
        dfs(a,x+1,y);
        dfs(a,x,y-1);
        dfs(a,x,y+1);
    }

}

//lightweight

public class Solution {
    private Queue<Integer> queue = new LinkedList<Integer>();
	public void solve(ArrayList<ArrayList<Character>> a) {
	    char[][] b = new char[a.size()][a.get(0).size()];
	    
	    for(int i=0; i<a.size(); i++){
	        for (int j=0; j<a.get(0).size(); j++){
	            b[i][j] = a.get(i).get(j);
	        }
	    }
	    
	    solve(b);
	    for(int i=0; i<a.size(); i++){
	        for (int j=0; j<a.get(0).size(); j++){
	            a.get(i).set(j,b[i][j]);
	        }
	    }
	    
	}
	
	
 
	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;
 
		int m = board.length;
		int n = board[0].length;
 
		// merge O's on left & right boarder
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') {
				bfs(board, i, 0);
			}
 
			if (board[i][n - 1] == 'O') {
				bfs(board, i, n - 1);
			}
		}
 
		// merge O's on top & bottom boarder
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O') {
				bfs(board, 0, j);
			}
 
			if (board[m - 1][j] == 'O') {
				bfs(board, m - 1, j);
			}
		}
 
		// process the board
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
	}
 
	private void bfs(char[][] board, int i, int j) {
		int n = board[0].length;
 
		// fill current first and then its neighbors
		fillCell(board, i, j);
 
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int x = cur / n;
			int y = cur % n;
 
			fillCell(board, x - 1, y);
			fillCell(board, x + 1, y);
			fillCell(board, x, y - 1);
			fillCell(board, x, y + 1);
		}
	}
 
	private void fillCell(char[][] board, int i, int j) {
		int m = board.length;
		int n = board[0].length;
		if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O')
			return;
 
		// add current cell is queue & then process its neighbors in bfs
		queue.offer(i * n + j);
		board[i][j] = '#';
	}
}
