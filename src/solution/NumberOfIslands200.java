package solution;

/**
 * @author linglifan
 * @date 2022/09/14 19:24
 */
public class NumberOfIslands200 {
    int count = 0;
    public int numIslands(char[][] grid) {
        for (int r=0;r<grid.length;r++){
            for (int c=0;c<grid[0].length;c++){
                if (grid[r][c] == '1'){
                    count++;
                    dfs(grid,r,c);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int r,int c){
        if (r>grid.length || r<0 || c>grid[0].length || c<0){
            return;
        }
        if (grid[r][c] == '0' || grid[r][c] == '2'){
            return;
        }
        grid[r][c] = '2';
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);

    }


}
