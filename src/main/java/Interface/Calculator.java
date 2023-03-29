package main.java.Interface;
import main.java.Data.Polynom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator extends JDialog{
    private JTextField fieldPolynom1;
    private JTextField fieldPolynom2;
    private JButton btnMultiplicate;
    private JButton btnDerive;
    private JButton btnSubstract;
    private JButton btnAdd;
    private JButton exitButton;
    private JTextPane resultPolynom;
    private JPanel mainPanel;

    private void performOperation(String poly1txt, String poly2txt, BiFunction<Polynom, Polynom, Polynom> operation) {
        Polynom polinom1 = parsePolinom(poly1txt);
        Polynom polinom2 = parsePolinom(poly2txt);
        Polynom rez = operation.apply(polinom1, polinom2);
        displayPolynom(rez);
    }

    public Calculator(JFrame parent) {

        super(parent);
        setTitle("Polynomial calculator");
        setContentPane(mainPanel);
        setSize(new Dimension(550, 400));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setLocationRelativeTo(parent);


        btnDerive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String poly1txt = fieldPolynom1.getText().trim();
                Polynom polinom1 = parsePolinom(poly1txt);
                Polynom rez = Polynom.derivative(polinom1);
                displayPolynom(rez);
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String poly1txt = fieldPolynom1.getText().trim();
                String poly2txt = fieldPolynom2.getText().trim();
                performOperation(poly1txt, poly2txt, Polynom::add);
            }
        });

        btnSubstract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String poly1txt = fieldPolynom1.getText().trim();
                String poly2txt = fieldPolynom2.getText().trim();
                performOperation(poly1txt, poly2txt, Polynom::substract);
            }
        });

        btnMultiplicate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String poly1txt = fieldPolynom1.getText().trim();
                String poly2txt = fieldPolynom2.getText().trim();
                performOperation(poly1txt, poly2txt, Polynom::multiply);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window window = SwingUtilities.getWindowAncestor(exitButton);
                window.dispose();

            }
        });
        setVisible(true);
    }

    private void displayPolynom(Polynom polynom){
        resultPolynom.setText(polynom.toString());
    }

    public static Polynom parsePolinom(String polytext){
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(polytext);
        Map<Integer, Integer> terms = new HashMap<>();

        while(matcher.find()){
            String term = matcher.group();
            int coeficient, exponent;
            if(term.contains("x")){
                String[] parts = term.split("x\\^");
                if(parts.length == 2){
                    if(parts[0].equals("+"))
                        coeficient = 1;
                    else  if(parts[0].equals("-"))
                        coeficient = -1;
                    else coeficient = Integer.parseInt(parts[0]);
                    exponent = Integer.parseInt(parts[1]);
                }
                else if(parts.length == 1 && term.contains("x")) {
                    if (term.startsWith("x"))
                        coeficient = 1;
                    else if (term.equals("-x"))
                        coeficient = -1;
                    else coeficient = Integer.parseInt(parts[0]);
                    exponent = 1;
                }
                else {  coeficient = 1;
                        exponent = 1;
                }
            }
            else {  coeficient = Integer.parseInt(term);
                    exponent = 0;
            }
            terms.put(exponent, coeficient);
        }
        return new Polynom(terms);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(null);
    }

}