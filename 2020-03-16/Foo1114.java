package Leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Foo1114 {
  /**Method1: AtomicInteger; Space: O(1)**/
  /**
   1. AtomicInteger 的方法：incrementAndGet(), get();
   2. while循环判断是否可以运行
   **/
  AtomicInteger firstDone = new AtomicInteger(0);
  AtomicInteger secondDone = new AtomicInteger(0);
  public Foo1114() {}
  public void first(Runnable printFirst) throws InterruptedException {
    printFirst.run();
    firstDone.incrementAndGet();
  }
  public void second(Runnable printSecond) throws InterruptedException {
    while(firstDone.get() != 1){
    }
    printSecond.run();
    secondDone.incrementAndGet();
  }
  public void third(Runnable printThird) throws InterruptedException {
    while(secondDone.get() != 1){
    }
    printThird.run();
  }
}
class Foo2 {
  /**Method2: synchronized + volatile; Space: O(1)**/
  /**
   1. object 作为被加锁对象： wait(), notifyAll()
   2.  while 判断flag, 不同就一直wait
   **/
  private volatile int flag = 0;
  private final Object object = new Object();
  public Foo2() {}
  public void first(Runnable printFirst) throws InterruptedException {
    synchronized(object) {
      while(flag != 0) {
        object.wait();
      }
      printFirst.run();
      flag=1;
      object.notifyAll();
    }
  }
  public void second(Runnable printSecond) throws InterruptedException {
    synchronized(object) {
      while(flag != 1) {
        object.wait();
      }
      printSecond.run();
      flag = 2;
      object.notifyAll();
    }
  }
  public void third(Runnable printThird) throws InterruptedException {
    synchronized(object) {
      while(flag != 2) {
        object.wait();
      }
      printThird.run();
      flag = 3;
      object.notifyAll();
    }
  }
}
class Foo3 {
  /**Method3: Semaphore; Space: O(1)**/
  /** new Semaphore(0)的时候需要参数， Semaphore方法：acquire， release **/
  Semaphore firstDone = new Semaphore(0);
  Semaphore secondDone = new Semaphore(0);
  public Foo3 () {}
  public void first(Runnable printFirst) throws InterruptedException {
    printFirst.run();
    firstDone.release();
  }
  public void second(Runnable printSecond) throws InterruptedException {
    firstDone.acquire();
    printSecond.run();
    secondDone.release();
  }
  public void third(Runnable printThird) throws InterruptedException {
    secondDone.acquire();
    printThird.run();
  }
}