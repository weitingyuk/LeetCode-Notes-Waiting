package Leetcode;

public class Exist12 {
  /**Method: DFS; Time:O(MN * 3^K); Space: O(K) **/
  /**
   深度优先搜索（DFS）+ 剪枝
   标记当前矩阵元素： 将 board[i][j] 修改为 空字符 '' ，代表此元素已访问过，防止之后搜索时重复访问。
   搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 连接 （代表只需找到一条可行路径就直接返回，不再做后续 DFS ），并记录结果至 res 。
   还原当前矩阵元素： 将 board[i][j] 元素还原至初始值，即 word[k] 。
   **/
  public boolean exist(char[][] board, String word) {
    char[] words = word.toCharArray();
    for(int i=0; i<board.length; i++) {
      for(int j=0; j<board[0].length; j++) {
        if(dfs(board, words, i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, char[] word, int i, int j, int index) {
    if(i<0 || i>=board.length || j<0 || j >= board[0].length || board[i][j] != word[index] ) {
      return false;
    }
    if(index == word.length -1) {
      return true;
    }
    board[i][j] = '\0'; //board[i][j] = '0/' 来防止 ”走回头路“
    boolean res = dfs(board, word, i+1, j, index+1) || dfs(board, word, i-1, j, index+1) ||
        dfs(board, word, i, j+1, index+1) || dfs(board, word, i, j-1, index+1);
    board[i][j] = word[index];
    return res;
  }

}
