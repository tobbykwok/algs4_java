package com.tobbyinside;

/**
 * Created by Tobby on 2016/1/5.+
 * 定容字符串栈
 */
public class FixedCapacityStackOfStrings{
    private String[] a;
    private int N;
    public FixedCapacityStackOfStrings(int cap){
        this.a = new String[cap];
    }
    public boolean isEmpty(){
        return this.N == 0;
    }
    public int size(){
        return this.N;
    }
    public void push(String item){
        a[N++] = item;
    }
    public String pop(){
        return a[--N];
    }
}