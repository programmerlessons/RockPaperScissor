package com.jennifer;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainGame extends JFrame {

	/**
	 * @param args
	 */
	
    private LoginDialog passDialog;
    private GameFrame gameFrame;

    public MainGame() {
    	gameFrame = new GameFrame();
    	
        passDialog = new LoginDialog(gameFrame, true);
        passDialog.setVisible(true);
    }
    
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            //@Override
            public void run() {
                JFrame frame = new MainGame();
                frame.getContentPane().setBackground(Color.BLACK);
                frame.setTitle("Logged In");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
		

	}

}
