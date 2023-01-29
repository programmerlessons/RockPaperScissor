package com.jennifer;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.util.Arrays;

public class LoginDialog extends JDialog {

    private final JLabel lblPlayerName = new JLabel("Player Name:");
    //private final JLabel lblAge = new JLabel("Age:");

    private final JTextField txtPlayerName = new JTextField(15);
//    private final JTextField txtAge = new JTextField(3);

    private final JButton btnPlayNow = new JButton("Play Now!");
    private final JButton btnExit = new JButton("Exit");

    private final JLabel lblStatus = new JLabel(" ");

    public LoginDialog() {
        this(null, true);
    }

    public LoginDialog(final JFrame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Let us get started!!!");
        JPanel labelPanel = new JPanel(new GridLayout(2, 1));
        labelPanel.add(lblPlayerName);
        //labelPanel.add(lblAge);

        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.add(txtPlayerName);
        //textPanel.add(txtAge);

        JPanel commonPanel = new JPanel();
        commonPanel.add(labelPanel);
        commonPanel.add(textPanel);

        JPanel p2 = new JPanel();
        p2.add(btnPlayNow);
        p2.add(btnExit);

        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(p2, BorderLayout.CENTER);
        p5.add(lblStatus, BorderLayout.NORTH);
        lblStatus.setForeground(Color.RED);
        lblStatus.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BorderLayout());
        add(commonPanel, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter() {  
            //@Override
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
        });


        btnPlayNow.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
               // if ("10".equalsIgnoreCase(txtAge.getText())
                 //       && "admin".equals(txtPlayerName.getText())) {
                	parent.setVisible(true);
                    setVisible(false);
              /*  } else {
                    lblStatus.setText("Invalid username or password");
                }*/
            }
        });
        btnExit.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                parent.dispose();
                System.exit(0);
            }
        });
    }

}
