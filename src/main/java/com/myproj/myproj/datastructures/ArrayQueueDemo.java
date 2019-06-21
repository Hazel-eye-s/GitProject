package com.myproj.myproj.datastructures;

/**
 * Created by wangjinyu on 2019/6/21 17:12.
 */
public class ArrayQueueDemo {


}

//使用数组模拟队列
class ArrayQueue {
    private int maxSize;//数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数据用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;//指向队列头部，分析出front是指向队列头部的前一个位置
        this.rear = -1;//指向队列的尾部。执行队列尾部数据，即队列最后一个数据
    }

    //判断队列是否已满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加数据到队列
    public void addQueue(int n) {

        if (isFull()) {
            System.out.println("队列已满，无法添加");
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列的数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列数据为空");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列数据为空，没有数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据，不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列数据为空，没有数据");
        }
        return arr[front + 1];
    }

}
