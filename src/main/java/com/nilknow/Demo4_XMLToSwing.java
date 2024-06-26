package com.nilknow;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo4_XMLToSwing {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Demo4_XMLToSwing().createAndShowGUI("index.xml"));
    }

    private void createAndShowGUI(String xmlFilePath) {
        JFrame frame = new JFrame("XML to Swing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel contentPane = new JPanel(new FlowLayout());

        try {
            List<Component> components = parseXML(xmlFilePath);
            for (Component component : components) {
                contentPane.add(component, BorderLayout.CENTER);
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            JOptionPane.showMessageDialog(frame, "Error parsing XML: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        frame.setContentPane(contentPane);
        frame.setVisible(true);
    }

    private List<Component> parseXML(String xmlFilePath) throws ParserConfigurationException, IOException, SAXException {
        List<Component> components = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(getClass().getResourceAsStream(xmlFilePath));

        Element rootElement = document.getDocumentElement();
        NodeList children = rootElement.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) child;
                String tagName = element.getTagName();
                String textContent = element.getTextContent();

                switch (tagName) {
                    case "label":
                        components.add(new JLabel(textContent));
                        break;
                    case "textField":
                        components.add(new JTextField(textContent));
                        break;
                    case "button":
                        JButton button = new JButton(textContent);
                        // Add action listener if needed
                        button.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                            }
                        });
                        components.add(button);
                        break;
                    default:
                        // Handle other elements as needed
                        break;
                }
            }
        }

        return components;
    }
}