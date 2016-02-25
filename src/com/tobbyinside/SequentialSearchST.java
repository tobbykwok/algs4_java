package com.tobbyinside;

import edu.princeton.cs.algs4.*;

/**
 * Created by tobby on 16/2/24.
 * 无序符号表 (单链表实现)
 * 主要操作:
 * 1. 定义Node类
 * 2. put(Key,Value) 插入值
 * 3. get(Key) 获取指定键的值
 * 4. size() 获得当前大小
 * 5. delete(Key) 删除键
 */
public class SequentialSearchST<Key, Value> {
    private Node first;
    private int N;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SequentialSearchST() {
        this.N = 0;
    }

    public Value get(Key key) {
        // 查找给定的key, 返回相关val
        for (Node current = this.first; current != null; current = current.next) {
            if (key == current.key) {
                return current.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (val == null || key == null) {
            return;
        }
        for (Node x = this.first; x != null; x = x.next) {
            if (x.key == key) {
                x.val = val;
                this.N++;
                return;
            }
        }
        this.first = new Node(key, val, this.first);
        this.N++;
    }

    public int size() {
        return N;
    }

    public Value delete(Key key) {
        Node p = this.first;
        Node last = null;
        Value res = null;
        while (p != null) {
            if (p.key.equals(key)) {        //相等比较
                if(last == null){
                    this.first = p.next;
                }else {
                    last.next = p.next;
                }
                res = p.val;
                p = null;
                N--;
            } else {
                last = p;
                p = p.next;
            }
        }
        return res;
    }

    /**
     * Returns all keys in the symbol table as an <tt>Iterable</tt>.
     * To iterate over all of the keys in the symbol table named <tt>st</tt>,
     * use the foreach notation: <tt>for (Key key : st.keys())</tt>.
     *
     * @return all keys in the sybol table
     */
    public Iterable<Key> keys() {
        edu.princeton.cs.algs4.Queue<Key> queue = new edu.princeton.cs.algs4.Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }


    /**
     * Unit tests the <tt>SequentialSearchST</tt> data type.
     */
    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        st.delete("A");
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
