package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {
  /* Method : HashMap + DLinkedNode, Time: O(1), Space:O(capacity)**/
  class DLinkedNode {
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
  private Map<Integer, DLinkedNode> map = new HashMap<>();
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

  public int get(int key) {
    DLinkedNode node = map.get(key);
    if(node == null) {
      return -1;
    }
    moveToHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    DLinkedNode node = map.get(key);
    if(node != null) {
      node.value = value;
      moveToHead(node);
    } else {
      DLinkedNode newNode = new DLinkedNode(key, value);
      map.put(key, newNode);
      addToHead(newNode);
      ++size;
      if(size > capacity) {
        DLinkedNode tail = removeTail();
        map.remove(tail.key);
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
