/*
 * Sam Polyakov
 * LinkedList.java
 * 02/26/2023
 * Project 3
 * CS231 B
 */

import java.util.Iterator;    // defines the Iterator interface
import java.util.ArrayList;   
import java.util.Collections; // contains a shuffle function

public class LinkedList<T> implements Iterable<T>{
    
    private class LLIterator implements Iterator<T>{
        Node<T> transversal;

        public LLIterator(Node<T> head){
        // the constructor for the LLIterator given the head of a list.
            transversal = head;
        }

        public boolean hasNext(){
            //returns true if there are still values to traverse
            return (transversal.getNext() != null);
        }
        
        public T next(){
            // returns the next item in the list
            T current = transversal.getData();
            transversal = transversal.getNext();
            return current;
        }

        public void remove(){

        }
    }

    private static class Node<T>{
        T data;
        Node<T> next;

        public Node(T item){
            //a constructor that initializes next to null and the container field to item.
            data = item;
            next = null;
        }

        public Node(T item, Node<T> next){
            // a constructor that initializes next to next and the container field to item.
            data = item;
            this.next = next;
        }

        public T getData(){
            //returns the value of the container field.
            return data;
        }

        public void setNext(Node<T> newNext){
            // sets next to the given node.
            this.next = newNext;
        }

        public Node<T> getNext(){
            //returns the next field.
            return next;
        }
    }
    
    private int size;

    private Node<T> head;

    public Iterator<T> iterator(){
        //// Return a new LLIterator pointing to the head of the list
        return new LLIterator(this.head);
    }

    public LinkedList(){
        //constructor that initializes the fields so it is an empty list.
        size = 0;
        head = null;

    }

    public void add(T item){
        //inserts the item at the beginning of the list.
        Node<T> newNode = new Node<T>(item, head);
        head = newNode;
        size++;
    }

    public T get(int index){
        //returns the item specified by the given index.
        if(index < 0 || index >= size){
            System.out.println("index out of bounds");
            return null;
        }
        Node<T> walker = head;
        for(int i = 0; i < index; i++){
            walker = walker.getNext();
        } 

        return walker.getData();
    }

    public void add(int index, T item){
        // inserts the item at the specified position in the list.
        if(index == 0){
            this.add(item);
        }
        else{
            Node<T> walker = head;
            for(int i = 0; i < index - 1; i++){
                walker = walker.getNext();
            }
            Node<T> newNode = new Node<T>(item, walker.getNext());
            walker.setNext(newNode);
            size++;
        }
    }

    public int size(){
        //returns the size of the list
        return size;
    }

    public boolean isEmpty(){
        // returns true if the list is empty, otherwise this method returns false
        return size == 0;
    }
    
    public void clear(){
        //empties the list (resets the fields so it is an empty list).
        size = 0;
        head = null;
    }
    

    public T remove(){
        //removes the first item of the list and returns it.
        Node<T> removed = head;
        head = head.getNext();
        size--;
        return removed.getData();
    }

    public T remove(int index){
        //removes the item at the specified position in the list and returns it.
        if(index == 0){
            return this.remove();
        }
        else{
            Node<T> walker = head;
            for(int i = 0; i < index - 1 ; i++){
                walker = walker.getNext();
            }
            Node<T> removed = walker.getNext();
            walker.setNext(walker.getNext().getNext());
            size--;
            return removed.getData();
        }
    }

    public boolean contains(Object o){
        //returns true if o is present in this list, otherwise this method returns false.
        for(int i = 0; i < this.size(); i++){
            if(this.get(i).equals(o)){
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object o){
        //returns true if o is a LinkedList that also contains the same items in the same order.
        if (!(o instanceof LinkedList)){
            return false;
        }
        // If I have reached this line, o must be a LinkedList
        @SuppressWarnings("unchecked") // 
        LinkedList<T> oAsALinkedList = (LinkedList<T>) o;
        // Now I have a reference to something Java knows is a LinkedList!
        if(oAsALinkedList.size() != this.size()){
            return false;
        }
        for(int i = 0; i < this.size(); i++){
            if(!oAsALinkedList.get(i).equals(this.get(i))){
                return false;
            }
        }
        return true;
    }


    public ArrayList<T> toArrayList(){
        // converts linkedlist to arraylist
        ArrayList<T> arrLL = new ArrayList<T>(size);
        for(int i = 0; i < this.size(); i++){
            arrLL.add(this.get(i));
        }
        return arrLL;
    }

    public String toString(){
        //returns a String representation of the list.
        String items = "";
        for(int i = 0; i < this.size(); i++){
            items += this.get(i) + " ";
        }
        return items;
    }
}

