package Leetcode;

public class CopyRandomList138 {

  /*Method : Two pointers, Time: O(N), Space:O(1)**/
  public Node copyRandomList(Node head) {
    if(head == null) {
      return null;
    }
    Node cur = head;

    while(cur != null) {
      Node copyNode = new Node(cur.val);
      copyNode.next = cur.next;
      cur.next = copyNode;
      cur = copyNode.next;
    }
    cur = head;
    while(cur != null) {
      cur.next.random = cur.random == null? null : cur.random.next;
      cur = cur.next.next;
    }

    Node newHead = head.next;

    Node newCur = newHead;
    Node oldCur = head;
    while(oldCur != null) {
      oldCur.next = oldCur.next.next;
      newCur.next = newCur.next == null ? null : newCur.next.next;
      oldCur = oldCur.next;
      newCur = newCur.next;
    }
    return newHead;
  }

  // Definition for a Node.
  class Node {
      int val;
      Node next;
      Node random;

      public Node(int val) {
          this.val = val;
          this.next = null;
          this.random = null;
      }
  }

}
