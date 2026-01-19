/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.stackfx.controller;
import com.mycompany.stackfx.model.Stack;
import com.mycompany.stackfx.view.StackCanvas;
import java.util.NoSuchElementException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;


public class StackController {
@FXML
   private TextField txtValue;
   @FXML
   private StackPane canvasHolder;
   private StackCanvas canvas;
   
   private final Stack stack = new Stack();
   @FXML
    private Label lblStatus;
   @FXML
    private void initialize() {
        canvas = new StackCanvas();
        canvasHolder.getChildren().add(canvas);

        canvas.clearHighlight();
        refreshView();
    }

    @FXML
    private void push() {
        System.out.println("Hola Pedro");
        Integer v = readInt();
        if (v == null) {
            //lblStatus.setText("Entrada inválida.");
            return;
        }

        stack.push(v);
        canvas.clearHighlight();
        canvas.render();
        //lblStatus.setText("Insertado al inicio: " + v);
        txtValue.selectAll();
        txtValue.requestFocus();
        refreshView();
    }

    @FXML
    private void pop() {
        try {
            int removed = stack.pop();              // 1) operación del modelo
            //lblStatus.setText("Pop → " + removed);  // 2) feedback al usuario
            refreshView();                          // 3) actualizar la vista
        } catch (NoSuchElementException ex) {
            //lblStatus.setText(ex.getMessage());
        }
    }
    @FXML
    private void peek() {
    try {
        int top = stack.peek();          // 1) Obtener tope del modelo

        canvas.clearHighlight();         // limpiar resaltado previo
        canvas.setHighlightIndex(0);     // 2) Resaltar el nodo top (índice 0)

        canvas.render();                 // 3) Redibujar vista
        refreshView();

        System.out.println("Peek → " + top);

    } catch (NoSuchElementException ex) {
        System.out.println("Pila vacía");
    }
}

    @FXML
private void isEmpty() {
    boolean empty = stack.isEmpty();

    canvas.clearHighlight();
    canvas.render();

    if (empty) {
        lblStatus.setText("La pila está vacía.");
    } else {
        lblStatus.setText("La pila tiene elementos.");
    }
}



    
    private Integer readInt() {
        try {
            String s = (txtValue.getText() == null) ? "" : txtValue.getText().trim();
            if (s.isEmpty()) {
                return null;
            }
            return Integer.valueOf(s);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    private void refreshView() {
        canvas.setValues(stack.toList());
        canvas.render();
    }
}
