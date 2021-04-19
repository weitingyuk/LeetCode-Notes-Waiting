package Leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javafx.util.Pair;

public class NumIslands200 {

  /**Method: BFS; Time:O(M*N); Space:O(min(M, N))**/
  /**
   为什么时间复杂度是min(M. N)?
   深度优先算法是 像一条蛇一样，不停的往前走。 所以时间复杂度是所有的格子的数量M*N 。
   广度优先算法就是 二叉树中的按层遍历。每次扫描一层。
   在这个题目中，的按层遍历（广度优先）不是按行，也不是按列，而是按照斜率为45度的方向 斜着斜着的扫描。因为最长的斜线 斜着的格子的数量等于min（M, N） 所以，斜着扫描（广度优先）的空间复杂度等就是 min（M, N）。
   **/
  /**
   BFS 方法：
   借用一个队列 queue，判断队列首部节点 (i, j) 是否未越界且为 1：
   若是则置零（删除岛屿节点），并将此节点上下左右节点 (i+1,j),(i-1,j),(i,j+1),(i,j-1) 加入队列；
   若不是则跳过此节点；
   **/
  public int numIslands(char[][] grid) {
    int count =0;
    for(int i=0; i<grid.length; i++) {
      for(int j =0; j<grid[0].length; j++) {
        if(grid[i][j] == '1') { //等于1的时候深度遍历
          bfs(grid, i, j);
          count ++;
        }
      }
    }
    return count;
  }
  private void bfs(char[][] grid, int i, int j) {
    Queue<int[]> list = new LinkedList<>(); //借用一个队列 queue，判断队列首部节点 (i, j) 是否未越界且为 1
    list.add(new int[]{i,j});
    while(!list.isEmpty()) {
      int[] cur = list.remove(); //remove方法
      i = cur[0];
      j = cur[1];
      if(i>=0 && j>=0 && i< grid.length && j<grid[0].length && grid[i][j] == '1') {
        grid[i][j] = '0';
        list.add(new int[]{i,j+1});
        list.add(new int[]{i+1,j});
        list.add(new int[]{i,j-1});
        list.add(new int[]{i-1,j});
      }
    }
  }

  /**Method: DFS; Time:O(M*N); Space:O(M*N)**/
  /**
   深度优先遍历DFS：上下左右相连的 1 都被认为是连续岛屿。
   遍历整个矩阵，当遇到 grid[i][j] == '1' 时，从此点开始做深度优先搜索 dfs，岛屿数 count + 1 且在深度优先搜索中删除此岛屿。
   **/
  public int numIslands2(char[][] grid) {
    int count =0;
    for(int i=0; i<grid.length; i++) {
      for(int j =0; j<grid[0].length; j++) {
        if(grid[i][j] == '1') { //等于1的时候深度遍历
          dfs(grid, i, j);
          count ++;
        }
      }
    }
    return count;
  }

  private void dfs(char[][] grid, int i, int j) {
    if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || grid[i][j] == '0') {
      return;
    }
    grid[i][j] = '0';
    dfs(grid, i+1, j);
    dfs(grid, i, j+1);
    dfs(grid, i-1, j);
    dfs(grid, i, j-1);
  }

}
