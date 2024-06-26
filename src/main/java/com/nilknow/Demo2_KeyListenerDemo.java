package com.nilknow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Demo2_KeyListenerDemo {
    public static void main(String[] args) {
        // Create and set up the window
        JFrame frame = new JFrame("Simple Swing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Create a label
        JLabel label = new JLabel("Hello, Swing!");
        panel.add(label);

        // Create a button
        JButton button = new JButton("press any key to show prompt");
        button.addKeyListener(new MyKeyListener(frame));
        panel.add(button);

        // Add the panel to the frame
        frame.add(panel);

        // Make the window visible
        frame.setVisible(true);
    }

    static class MyKeyListener implements KeyListener {
        private final JFrame frame;

        public MyKeyListener(JFrame frame) {
            this.frame = frame;
        }

        @Override
        public void keyTyped(KeyEvent e) {
            JOptionPane.showMessageDialog(frame, "Keyboard clicked!");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            JOptionPane.showMessageDialog(frame, "Keyboard clicked!");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            JOptionPane.showMessageDialog(frame, "Keyboard clicked!");
        }
    }
}
