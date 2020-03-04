package com.zipcodewilmington.singlylinkedlist;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {

    private Node head;
    private Node tail;
    private Node current;
    private Integer size;

    public SinglyLinkedList(){
        head = null;
        tail = null;
        current = null;
        size = 0;
    }

    public SinglyLinkedList(T... things){
        this();
        for(T i : things){
            add(i);
        }
    }

    public Boolean add(T obj){
        if(head == null){
            Node newNode = new Node();
            newNode.setValue(obj);
            head = newNode;
            tail = newNode;
            current = newNode;
            size++;
        }else if(head != null){
            Node newNode = new Node();
            newNode.setValue(obj);
            tail = newNode;
            current.setNextNode(newNode);
            current = newNode;
            size++;
        }
        return true;
    }

    public Boolean remove(T obj){
        Node iterateNode = head;
        for (int i = 0; i < size; i++) {
            if(iterateNode.getNext().getValue().equals(obj)){
                iterateNode.setNextNode(iterateNode.getNext().getNext());
                size--;
                return true;
            }
        }
        return false;
    }

    public Boolean contains(T obj){
        Node iterateNode = head;
        for (int i = 0; i < size; i++) {
            if(iterateNode.getValue().equals(obj))
                return true;
            iterateNode = iterateNode.getNext();
        }
        return false;
    }

    public Integer find(T obj){
        Node iterateNode = head;
        for (int i = 0; i < size; i++) {
            if(iterateNode.getValue().equals(obj))
                return i;
            iterateNode = iterateNode.getNext();
        }
        return -1;
    }

    public Integer size(){
        return size;
    }

    public T get(Integer index){
        Node iterateNode = head;
        if(index >= 0 && index <= size){
            for (int i = 0; i < index; i++) {
                iterateNode = iterateNode.getNext();
            }
        }else {
            throw new IndexOutOfBoundsException();
        }
        return (T) iterateNode.getValue();
    }

    public SinglyLinkedList copy(){
        SinglyLinkedList newCopy = new SinglyLinkedList();
        for (int i = 0; i < this.size; i++) {
            newCopy.add(this.get(i));
        }
        return newCopy;
    }

    public void sort(){
        for (Node i = head; i.getNext() != null ; i = i.getNext()) {
            for (Node j = i.getNext(); j.getNext() != null; j = j.getNext()){
                if(j.getValue().toString().compareTo(j.getNext().getValue().toString()) == 1){
                    T val = (T) j.getValue();
                    j.setValue(j.getNext().getValue());
                    j.getNext().setValue(val);
                }
            }
        }
    }

    public class Node<T> {

        private Node next;
        private T value;

        public Node(){
            next = null;
            value = null;
        }

        protected void setNextNode(Node nextNode){
            next = nextNode;
        }

        protected Node getNext(){
            if(next != null)
                return next;
            else
                return null;
        }

        protected void setValue(T newValue){
            value = newValue;
        }

        protected T getValue(){
            return value;
        }
    }
}


