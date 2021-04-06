package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {
  /* Method : HashMap + DLinkedNode, Time: O(1), Space:O(capacity)**/

  class DLinkedNode { //双向链表的定义
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
    public DLinkedNode() {}
    public DLinkedNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
  private Map<Integer, DLinkedNode> map = new HashMap<>();//key = int, value=node
  private int size;
  private int capacity;
  private DLinkedNode head;
  private DLinkedNode tail;

  public LRUCache146(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.head = new DLinkedNode();
    this.tail = new DLinkedNode();
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) { //每次get结束要move到头节点后面
    DLinkedNode node = map.get(key);//首先判断node是否在map中
    if(node == null) {
      return -1;
    }
    moveToHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    DLinkedNode node = map.get(key);//首先判断node是否在map中
    if(node != null) { // 1.如果有，直接update， moveToHead
      node.value = value;
      moveToHead(node);
    } else {
      node = new DLinkedNode(key, value); // 2.如果没有，put， addToHead
      map.put(key, node); // 注意put key
      addToHead(node);
      size ++;
      if(size > capacity) { // 3.是否需要remove tail前一位
        DLinkedNode tailN = removeTail();
        map.remove(tailN.key);// 注意remove tailNode.key
        --size;
      }
    }
  }

  private void addToHead(DLinkedNode node) {
    node.prev = head;
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
  }
  private void removeNode(DLinkedNode node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }
  private DLinkedNode removeTail() {
    DLinkedNode tailN = tail.prev;
    removeNode(tailN);
    return tailN;
  }
  private void moveToHead(DLinkedNode node) {
    removeNode(node);
    addToHead(node);
  }
}
