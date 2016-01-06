package com.tobbyinside;

//import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        StdOut.println("Hello World StdOut");
        Stack<Integer> intStack = new Stack<Integer>();
        for(int i = 0 ;i<100;i++) {
            intStack.push(i);
        }

        for(int j = 0;j<100;j++){
            StdOut.println(intStack.pop());
        }
        //intStack.pop();
//        for(Iterator<Integer> it = intStack.iterator(); it.hasNext();){
//            StdOut.println(it.next());
//        }
        StdOut.println("isEmpty: " + intStack.isEmpty());
    }
}