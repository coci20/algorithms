/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.adtsamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prasannjitk
 */
public class Solution {
    
    public static String readString() {
        BufferedReader reader = 
                new BufferedReader(new InputStreamReader(System.in));
        try{
            String s = reader.readLine();
            return s;
        } catch(IOException ie) {
            Logger.getLogger(Solution.class.getName()).log(Level.SEVERE, null, ie);
        }
        return null;
    }
    
    public static int readNumber() {
        BufferedReader reader = 
                new BufferedReader(new InputStreamReader(System.in));
        try{
            String s = reader.readLine();
            return Integer.parseInt(s);
        } catch(IOException ie) {
            Logger.getLogger(Solution.class.getName()).log(Level.SEVERE, null, ie);
        }
        return -1;
    }
    
    /**
     * stack
     */
    public static void printStack(){
        System.out.println("1 to push "
                + "2 to pop "
                + "3 to peek "
                + "4 to exit"
        );                
        
        Stack<Integer> stack = new Stack<>();
        int choice = readNumber();
        if(choice != 4) {
            while(choice <= 3) {
                switch(choice){
                    case 1:
                        int pushedVal = readNumber();
                        stack.push(pushedVal);
                        break;
                    case 2:
                        if(!stack.isEmpty())
                            System.out.println("popped value"
                                    + "is " + stack.pop());
                        break;
                    case 3:
                        if(!stack.isEmpty())
                            System.out.println("top element"
                                    + "is " + stack.peek());
                        break;
                    case 4:
                        return;                        
                }
                for(int i = 0; i < stack.size(); i++) {
                    System.out.print(stack.get(i) + " ");
                }
                System.out.println("1 to push "
                + "2 to pop "
                + "3 to peek "
                + "4 to exit"
                );
                choice = readNumber();
            }            
        }
        stack.clear();
    }
    
    /**
     * queue
     */
    public static void printQueue(){
        System.out.println("1 to push "
                + "2 to pop "
                + "3 to peek "
                + "4 to exit"
        );
        
        Queue<Integer> queue = new LinkedList<>();
        int choice = readNumber();
        if(choice != 4) {
            while(choice <= 3) {
                switch(choice){
                    case 1:
                        int pushedVal = readNumber();
                        queue.add(pushedVal);
                        break;
                    case 2:
                        if(!queue.isEmpty())
                            System.out.println("popped value"
                                    + "is " + queue.remove());
                        break;
                    case 3:
                        if(!queue.isEmpty())
                            System.out.println("top element"
                                    + "is " + queue.peek());
                        break;
                    case 4:
                        return;                        
                }
                for(int i = 0; i < queue.size(); i++) {
                    System.out.print(Arrays.deepToString(queue.toArray()));
                }
                System.out.println("1 to push "
                + "2 to pop "
                + "3 to peek "
                + "4 to exit"
                );
                choice = readNumber();
            }            
        }
        queue.clear();
    }
    
    /**
     * linked list
     */
    public static void printLinkedList(){
        
    }
    
    /**
     * DEQUE
     */
    public static void printDeque() {
        
    }
    
    /**
     * defining a comparator for the priority queue 
     */
    public static Comparator<Entry<Integer, Integer>> cmprtr = 
                (Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) -> {
                    int v1 = e1.getValue();
                    int v2 = e2.getValue();
                    return v1 - v2;
    };

    public static Comparator<Integer> cmprtr2 = 
                (Integer e1, Integer e2) -> e1 - e2;    
    /**
     * priority queue
     */
    public static void printPriorityQ() {
        System.out.println("1 to push "
                + "2 to pop "
                + "3 to peek "
                + "4 to exit"
        );
        
        PriorityQueue<Integer> priorityQ = 
                new PriorityQueue<>(cmprtr2);
        int choice = readNumber();
        if(choice != 4) {
            while(choice <= 3) {
                switch(choice) {
                    case 1:
                        int pushVal = readNumber();
                        priorityQ.add(pushVal);
                        break;
                    case 2:
                        if(!priorityQ.isEmpty())
                            System.out.println("removed value "
                                    + "is " + priorityQ.remove());
                        break;
                    case 3:
                        if(!priorityQ.isEmpty())
                            System.out.println("top element "
                                    + "is " + priorityQ.peek());
                        break;
                    case 4:
                        return;
                }
                System.out.println(Arrays.deepToString(priorityQ.toArray()));
                System.out.println("1 to push "
                + "2 to pop "
                + "3 to peek "
                + "4 to exit"
                );
                choice = readNumber();
            }
        }
        priorityQ.clear();
    }
    
    public static void main(String[] args) {
        System.out.println("Enter your choice:\n"
                + "1: stack\n"
                + "2: queue\n"
                + "3: priority queue\n"
                + "4: exit\n"
        );
        int choice = readNumber();
        while(choice <= 3) {
            switch(choice) {
                case 1 :
                    printStack();
                    break;
                case 2 :
                    printQueue();
                    break;
                case 3:
                    printPriorityQ();
                    break;
                default:
                    System.exit(0);
            }
            System.out.println("Enter your choice:\n"
                + "1: stack\n"
                + "2: queue\n"
                + "3: priority queue\n"
                + "4: exit\n"
            );
            choice = readNumber();
        }
    }
}
