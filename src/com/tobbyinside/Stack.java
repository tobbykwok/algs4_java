package com.tobbyinside;

import java.util.Iterator;

/**
 * Created by Tobby on 2016/1/6.
 * 下压栈, 链表实现
 */
public class Stack<Item> implements Iterable<Item>{

    private Node first;     //栈顶(最近添加的元素)
    private int N;          //元素数量

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;   // 或 N == 0
    }

    public int size(){
        return N;
    }

    public void push(Item item){        //??
        Node temp = new Node();
        temp.next = first;
        temp.item = item;
        first = temp;
        N++;
    }

    public Item pop(){
        Item temp = first.item;
        first = first.next;
        N--;
        return temp;
    }

    public Iterator<Item> iterator(){
        return new FooIterator();
    }


    private class FooIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public Item next(){
            Item temp = current.item;
            current = current.next;
            return temp;
        }

    }
}
