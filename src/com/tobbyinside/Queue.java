package com.tobbyinside;

import java.util.Iterator;

/**
 * Created by Tobby on 2016/1/6.
 */
public class Queue<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private class Node{
        Item item;
        Node next;
    }
    private int N;

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void enquene(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()){
            first = last;
        }else{
            oldlast.next = last;
        }
        N++;
    }

    public Item dequene(){
        Item temp = first.item;
        first= first.next;
        if(isEmpty()){
            last = null;
        }
        N--;
        return temp;
    }

    public Iterator<Item> iterator(){
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item temp = current.item;
            current = current.next;
            return temp;
        }
    }
}
