package Leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Foo1114 {
  /**Method1: AtomicInteger; Space: O(1)**/
  private AtomicInteger firstDone = new AtomicInteger(0);
  private AtomicInteger secondDone = new AtomicInteger(0);
  public Foo1114() {}

  public void first(Runnable printFirst) throws InterruptedException {
    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    firstDone.incrementAndGet();
  }

  public void second(Runnable printSecond) throws InterruptedException {
    while(firstDone.get() != 1) {
      //wait for the first done
    }
    // printSecond.run() outputs "second". Do not change or remove this line.
    printSecond.run();
    secondDone.incrementAndGet();
  }

  public void third(Runnable printThird) throws InterruptedException {
    while(secondDone.get() != 1) {
      //wait for the second done
    }
    // printThird.run() outputs "third". Do not change or remove this line.
    printThird.run();
  }
}
class Foo2 {
  /**Method2: synchronized + volatile; Space: O(1)**/
  private volatile int flag = 1;
  private final Object object = new Object();
  public Foo2() {}
  public void first(Runnable printFirst) throws InterruptedException {
    synchronized (object) {
      while(flag != 1) {object.wait();}
      printFirst.run();
      flag = 2;
      object.notifyAll();
    }
  }
  public void second(Runnable printSecond) throws InterruptedException {
    synchronized (object) {
      while(flag != 2) {object.wait();}
      printSecond.run();
      flag = 3;
      object.notifyAll();
    }
  }
  public void third(Runnable printThird) throws InterruptedException {
    synchronized(object) {
      while(flag != 3) {object.wait();}
      printThird.run();
      flag = 4;
      object.notifyAll();
    }
  }
}
class Foo3 {
  /**Method3: Semaphore; Space: O(1)**/
  private Semaphore firstDone = new Semaphore(0);
  private Semaphore secondDone = new Semaphore(0);
  public Foo3() {}
  public void first(Runnable printFirst) throws InterruptedException {
    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    firstDone.release();
  }
  public void second(Runnable printSecond) throws InterruptedException {
    //wait for the first done
    firstDone.acquire();
    // printSecond.run() outputs "second". Do not change or remove this line.
    printSecond.run();
    secondDone.release();
  }
  public void third(Runnable printThird) throws InterruptedException {
    //wait for the second done
    secondDone.acquire();
    // printThird.run() outputs "third". Do not change or remove this line.
    printThird.run();
  }
}