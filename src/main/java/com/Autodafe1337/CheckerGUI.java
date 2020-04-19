package com.Autodafe1337;

import org.checkerframework.checker.regex.RegexUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

public class CheckerGUI extends JFrame implements ActionListener {

    JTextArea textArea;

    public CheckerGUI(String titleIn) {
        super(titleIn);
        super.setSize(800, 388);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        textArea = new JTextArea(19, 70);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.BLACK);

        JScrollPane jsp = new JScrollPane(textArea);
        jsp.setSize(700,285);
        topPanel.add(jsp);

        JButton button = new JButton("Get Update");
        button.addActionListener(this);

        bottomPanel.add(button);

        super.add(topPanel);
        super.add(bottomPanel, BorderLayout.SOUTH);
        super.setVisible(true);
    }

    public void addText(String str){
        if(!str.isEmpty()){
            textArea.append(str + "\n");
        }
    }

    public void clearText(){
        textArea.setText("");
    }

    public void addText(String[] res){
        try {
            for (String str : res) {
                if (!str.isEmpty()) {
                    textArea.append(str + "\n");
                }
            }
        } catch(NullPointerException ignored){}
    }

    public void addText(ArrayList<String> res){
        try {
            for (String str : res) {
                if (!str.isEmpty()) {
                    textArea.append(str + "\n");
                }
            }
        } catch(NullPointerException ignored){}
    }


    public static void main(String[] args) {
        CheckerGUI w = new CheckerGUI("L2on Parser Gui");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }




}
