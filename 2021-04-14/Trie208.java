package Leetcode;

public class Trie208 {

  /**Method: Prefix Search; Time: O(1), Space: O(N) **/
  Trie208[] children;
  boolean isEnd;
  /** Initialize your data structure here. */
  public Trie208() {
    children = new Trie208[26]; //指向子节点的指针数组children。数组长度为 26，即小写英文字母的数量。
    isEnd = false; //布尔字段 isEnd，表示该节点是否为字符串的结尾。
  }
  /** Inserts a word into the trie.
   1. 子节点存在。沿着指针移动到子节点，继续处理下一个字符。
   2. 子节点不存在。创建一个新的子节点，记录在 \textit{children}children 数组的对应位置上，然后沿着指针移动到子节点，继续搜索下一个字符。
   */
  public void insert(String word) {
    Trie208 node= this;
    for(int i=0; i< word.length();i++) {
      char ch = word.charAt(i);
      int index = getIndex(ch);
      if(node.children[index] == null) {
        node.children[index] = new Trie208();
      }
      node =  node.children[index];
    }
    node.isEnd = true;
  }

  /** Returns if the word is in the trie.
   */
  public boolean search(String word) {
    Trie208 node = searchPrefix(word);
    return node != null && node.isEnd;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    return searchPrefix(prefix) != null;
  }
  /** Search Prefix
   字典树的根开始，查找前缀。
   1. 子节点存在。沿着指针移动到子节点，继续搜索下一个字符。
   2. 子节点不存在。说明字典树中不包含该前缀，返回空指针。
   **/
  private Trie208 searchPrefix(String prefix) {
    Trie208 node = this;
    for(int i=0; i< prefix.length(); i++) {
      char ch = prefix.charAt(i);
      int index = getIndex(ch);
      if(node.children[index] == null) {
        return null;
      }
      node = node.children[index];
    }
    return node;
  }

  private int getIndex(char ch) {
    return ch-'a';
  }
}
