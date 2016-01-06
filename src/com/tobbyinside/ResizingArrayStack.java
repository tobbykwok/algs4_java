package com.tobbyinside;

import java.util.Iterator;

/**
 * Created by Tobby on 2016/1/5.
 * 下压 LIFO 栈, 能够动态调整数组大小的实现
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;
    public boolean isEmpty(){return N == 0;}
    public int size(){return N;}
    private void resize(int max){
        Item[] temp = (Item[])new Object[max];
        for(int i = 0;i<N;i++){
            temp[i] = a[i];
        }
        a = temp;
    }
    public void push(Item item){
        if(N == a.length) this.resize(a.length *2);
        a[N++] = item;
    }
    public Item pop(){
        Item temp = a[--N];
        if(N>0 && N==a.length/4) this.resize(a.length/ 2);
        return temp;
    }
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = N;
        public boolean hasNext() {return i>0;}
        public Item next(){return a[--i];}
        public void remove(){}
    }
}
