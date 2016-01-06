package com.tobbyinside;

/**
 * Created by Tobby on 2016/1/5.
 */
public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;
    public FixedCapacityStack(int cap){
        this.a = (Item[])new Object[cap];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void push(Item item){
        if(this.a.length == N) this.resize(N*2);
        this.a[N++] = item;
    }

    public Item pop(){
        Item temp = a[--N];
        a[N] = null;
        if(N > 0 && N == this.a.length/4) this.resize(this.a.length/2);
        return temp;
    }

    public int size(){
        return N;
    }

    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i<N; i++){
            temp[i] = this.a[i];
        }
        this.a = temp;
    }
}
