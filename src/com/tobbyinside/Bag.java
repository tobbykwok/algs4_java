package com.tobbyinside;

import java.util.Iterator;

/**
 * Created by Tobby on 2016/1/6.
 * 背包: 不支持从中删除元素的集合类型(用于收集元素, 并迭代遍历所有收集到的元素)
 * 链表实现 后进先出
 */
public class Bag<Item> implements Iterable<Item> {
    private Node first;

    private class Node{
        Item item;
        Node next;
    }

    public void add(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current!=null;
        }
        public void remove(){

        }

        public Item next(){
            Item temp = current.item;
            current = current.next;
            return temp;
        }
    }

}
