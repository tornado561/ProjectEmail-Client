package com.EmailClient;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class GUI extends  JFrame{

    private JLabel labelRecipient = new JLabel("Recipient: ");
    private JLabel labelTitle = new JLabel("Title: ");
    private JLabel labelContent = new JLabel("Content: ");
    private JTextField textRecipient = new JTextField(20);
    private JTextField fieldTitle = new JTextField(20);
    private JTextArea fieldContent = new JTextArea();

    private JButton buttonLogin ;

    public  GUI() {
        super("EmailClient");


        JPanel newPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);


        constraints.gridx = 0;
        constraints.gridy = 0;
        newPanel.add(labelRecipient, constraints);

        constraints.gridx = 1;
        newPanel.add(textRecipient, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        newPanel.add(labelTitle, constraints);

        constraints.gridx = 1;
        newPanel.add(fieldTitle, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        newPanel.add(labelContent, constraints);

        constraints.gridx = 1;
        fieldContent.setPreferredSize(new Dimension(300,100));
        newPanel.add(fieldContent, constraints);


        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;

        //przycisk wysylania inicjalizacja
        buttonLogin = new JButton("Send");
        newPanel.add(buttonLogin,constraints);

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.exampleHttpClientForPostMethod(textRecipient.getText(),fieldTitle.getText(),fieldContent.getText());

                } catch (IOException e1) {

                    e1.printStackTrace();
                }
            }
        });

        newPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Email Sending"));
        add(newPanel);
        pack();
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }



}