package com.zipcodewilmington.singlylinkedlist;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T>{

    private Node<T> head;
    private Node<T> tail;
    private Integer size;

    public SinglyLinkedList(){
        head = null;
        tail = null;
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
            Node<T> newNode = new Node<T>();
            newNode.setValue(obj);
            head = newNode;
            tail = newNode;
            size++;
        }else if(head != null){
            Node<T> newNode = new Node<T>();
            newNode.setValue(obj);
            tail.setNextNode(newNode);
            tail = newNode;
            size++;
        }
        return true;
    }

    public Boolean remove(T obj){
        Node<T> iterateNode = head;
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
        Node<T> iterateNode = head;
        for (int i = 0; i < size; i++) {
            if(iterateNode.getValue().equals(obj))
                return true;
            iterateNode = iterateNode.getNext();
        }
        return false;
    }

    public Integer find(T obj){
        Node<T> iterateNode = head;
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
        Node<T> iterateNode = head;
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
        for (Node<T> i = head; i.getNext() != null ; i = i.getNext()) {
            for (Node<T> j = i.getNext(); j != null; j = j.getNext()){
                if(i.compareTo(j) > 0){
                    T val = i.getValue();
                    i.setValue(j.getValue());
                    j.setValue(val);
                }
            }
        }
    }

    public SinglyLinkedList slice(Integer startIndex, Integer endIndex){
        SinglyLinkedList retList = new SinglyLinkedList();
        Node startNode = head;
        if(startIndex >= 0 && endIndex < size && startIndex < endIndex){
            for (int i = 0; i < size; i++, startNode = startNode.getNext()) {
                if(i >= startIndex)
                    retList.add(startNode.value);
            }
        }
        else
            throw new IndexOutOfBoundsException();
        return retList;
    }

    public SinglyLinkedList reverse(){
        SinglyLinkedList retList = new SinglyLinkedList();
        for (int i = size-1; i >= 0  ; i--) {
            Node startNode = head;
            for (int j = 0; j <= i; j++) {
                if(j == i)
                    retList.add(startNode.value);
                startNode = startNode.getNext();
            }
        }
        return retList;
    }

    public static class Node<T> implements Comparable<Node<T>>{

        private Node<T> next;
        private T value;

        public Node(){
            next = null;
            value = null;
        }

        protected void setNextNode(Node<T> nextNode){
            next = nextNode;
        }

        protected Node<T>getNext(){
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

        public int compareTo(Node<T> o) {
            return value.toString().compareTo(o.getValue().toString());
        }
    }
}


