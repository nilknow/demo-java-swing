package com.nilknow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Demo3_OneWayBinding {

    private JTextField textField;
    private JLabel label;

    public Demo3_OneWayBinding() {
        // Create the frame
        JFrame frame = new JFrame("One-Way Binding Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

        // Create the components
        textField = new JTextField(10);
        label = new JLabel("Value: ");

        // Create a panel to hold the components
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(label);
        panel.add(textField);

        // Add the panel to the frame
        frame.add(panel);

        // Add action listener to the text field
        textField.addKeyListener(new MyKeyListener());

        // Set initial value
        textField.setText("Pls input any value to check One-way Binding");
        updateLabel();

        // Make the frame visible
        frame.setVisible(true);
    }

    // Update the label based on the text field value
    private void updateLabel() {
        label.setText("Value: " + textField.getText());
    }

    private class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            updateLabel();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            updateLabel();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            updateLabel();
        }
    }

    public static void main(String[] args) {
        new Demo3_OneWayBinding();
    }
}
