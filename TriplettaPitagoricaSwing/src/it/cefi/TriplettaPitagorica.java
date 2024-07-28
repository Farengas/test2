package it.cefi;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TriplettaPitagorica extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTextArea textArea;
    
    Color almondColor = new Color(0xffebcd);
    Color salmonColor = new Color(0xe9967a);
    Color darkSalmonColor = new Color(0xcd8162);
    
    public TriplettaPitagorica() {
        
        setTitle("Trova triplette pitagoriche");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(almondColor);
        
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        inputPanel.setBackground(almondColor);
        
        JLabel label = new JLabel("Inserisci il valore di N:");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        
        GridBagConstraints gridBagConstraint = new GridBagConstraints();
        gridBagConstraint .insets = new Insets(5, 5, 5, 5);
        gridBagConstraint .gridx = 0;
        gridBagConstraint .gridy = 0;
        inputPanel.add(label, gridBagConstraint );
        
        textField = new JTextField(10);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        
        gridBagConstraint .gridx = 1;
        inputPanel.add(textField, gridBagConstraint );
        
        JButton button = new JButton("Trova triplette");
        button.setBackground(salmonColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trovaTriplette();
            }
        });
        
        gridBagConstraint .gridx = 2;
        inputPanel.add(button, gridBagConstraint );
        
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.WHITE);
        textArea.setForeground(Color.BLACK);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        add(mainPanel);
        
        setVisible(true);
    }
    
    private void trovaTriplette() {
        textArea.setText("");
        String inputText = textField.getText().trim(); // Rimuove gli spazi vuoti
        if (inputText.isEmpty()) {
            textArea.setText("Inserisci un numero intero per N.");
            return;
        }    
        int N;
        try {
            N = Integer.parseInt(inputText);
            if (N <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            textArea.setText("Inserisci un numero intero positivo valido per N.");
            return;
        }
        ArrayList<String> triplets = new ArrayList<>();
        // Cerca le triplette pitagoriche che soddisfano a + b + c = N
        for (int a = 1; a < N; a++) {
            for (int b = a + 1; b < N; b++) {
                double c = Math.sqrt(a * a + b * b);
                if (c == (int) c && a + b + c == N) {
                    triplets.add("a: " + a + ", b: " + b + ", c: " + (int) c);
                }
            }
        }
        // Mostra le triplette trovate
        if (triplets.isEmpty()) {
            textArea.setText("Nessuna tripletta pitagorica trovata per N = " + N);
        } else {
            StringBuilder result = new StringBuilder();
            result.append("Triplette pitagoriche trovate per N = ").append(N).append(":\n");
            for (String triplet : triplets) {
                result.append(triplet).append("\n");
            }
            textArea.setText(result.toString());
        }
    }
    
    public static void main(String[] args) {
        new TriplettaPitagorica();
    }
        
   }
