/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stackfx.model;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author User
 */
public class Stack {
    private Node top;
    private int size;

    public int size() {
        return size;
    }
    
    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException("La pila vacía");            
        }
        return top.value;
    }

    
    public boolean isEmpty() {
        return top == null;
    }

    // push: apilar (insertar en el tope) -> O(1)
    public void push(int value) {
        Node n = new Node(value);
        n.next = top;
        top = n;
        size++;
    }

    // pop: desapilar (quitar del tope) -> O(1)
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("La pila está vacía");
        }
        int v = top.value;
        top = top.next;
        size--;
        return v;
    }

    public ArrayList<Integer> toList() {
        ArrayList<Integer> out = new ArrayList<>(size);
        Node cur = top;
        while (cur != null) {
            out.add(cur.value);
            cur = cur.next;
        }
        return out;
    }
}
