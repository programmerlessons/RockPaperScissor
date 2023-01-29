package com.jennifer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ScoreBoardDialog extends JDialog implements ActionListener {

    private final JLabel lblPlayerName;
    private final JLabel lblAge = new JLabel("Age:");

    private final JTextField txtPlayerName = new JTextField(15);
    private final JTextField txtAge = new JTextField(3);

    private final JButton btnPlayNow = new JButton("Play Now!");
    private final JButton btnExit = new JButton("Exit");

    private final JLabel lblStatus = new JLabel(" ");

    public ScoreBoardDialog() {
        this(null, true,0);
    }

    public ScoreBoardDialog(final JFrame parent, boolean modal,int last_score) {
        super(parent, modal);

        this.setTitle("Score Board");
        JPanel labelPanel = new JPanel(new GridLayout(2, 1));
        lblPlayerName = new JLabel("The last highest score is" + last_score);
        
        labelPanel.add(lblPlayerName);
 
        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(labelPanel, BorderLayout.CENTER);
        p5.add(lblStatus, BorderLayout.NORTH);
        lblStatus.setForeground(Color.RED);
        lblStatus.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BorderLayout());
        add(p5, BorderLayout.CENTER);
  
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    
    public void actionPerformed(ActionEvent e) {
        dispose();
    }


}
