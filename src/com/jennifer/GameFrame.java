package com.jennifer;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;

public class GameFrame extends JFrame implements ActionListener, ItemListener {
	//Where the GUI is created:
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;
	ScoreBoardDialog scoreboard;
	JLabel lblComputer = new JLabel("Computer chooses:");
	JLabel lblMyself = new JLabel("I choose:",SwingConstants.RIGHT);
	String user_choice_str;
	int user_choice;
	int pc_choice;
	String output_print;
	int result,last_score;
	int[][] matrix_A = {{0,-1,1},{1,0,-1},{-1,1,0}};
	JPanel myPanel = new JPanel(new GridLayout(1,2));
	JPanel myRadioPanel = new JPanel(new GridLayout(3,1));
	JPanel computerPanel = new JPanel(new GridLayout(1,2));
	JPanel compRadioPanel = new JPanel(new GridLayout(3,1));
	JRadioButton my_paper, my_rock, my_scissor, comp_paper, comp_rock, comp_scissor;
	ButtonGroup my_choice, comp_choice;
	String last_score_file;
	JButton btnGame = new JButton("Submit the Move.");
	JFrame thisFrame;
	int score = 0;
	public GameFrame() {
		try {
			File myObj = new File("D:\\Eclipse-Workspace\\Console_backend\\src\\last_score.txt");
		    Scanner myReader = new Scanner(myObj);
		    last_score_file = myReader.next();
		    
		    last_score = Integer.parseInt(last_score_file);
		    //JOptionPane.showMessageDialog(null, "The last high score : "+last_score, "Leader Board",  JOptionPane.INFORMATION_MESSAGE);
			}
			catch( NumberFormatException e) {System.out.println("This is first execution."); last_score = 0;}
			catch (FileNotFoundException e) {
				 System.out.println("This is first execution. So no last score available to display");
		}
		this.setTitle("Rock Paper Scissor Game");
		scoreboard= new ScoreBoardDialog(this, true,last_score);
		
		menuBar= new JMenuBar();
		menu = new JMenu("menu");
		menuItem = new JMenuItem("Score Board", KeyEvent.VK_T);
		menu.add(menuItem);
		menuBar.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scoreboard.setVisible(true);
			
			}
		});
		
		this.setJMenuBar(menuBar);
		drawLayout();
		this.setSize(400,900);
		this.setLayout(null);
		this.thisFrame = this;
	}	
	
	public void drawLayout() {
		try {
			File myObj = new File("D:\\Eclipse-Workspace\\Console_backend\\src\\last_score.txt");
		    Scanner myReader = new Scanner(myObj);
		    last_score_file = myReader.next();
		    
		    last_score = Integer.parseInt(last_score_file);
		    JOptionPane.showMessageDialog(null, "The last high score : "+last_score, "Leader Board",  JOptionPane.INFORMATION_MESSAGE);
			}
			catch( NumberFormatException e) {System.out.println("This is first execution."); last_score = 0;}
			catch (FileNotFoundException e) {
				 System.out.println("This is first execution. So no last score available to display");
		}
		comp_paper = new JRadioButton("Paper");
		comp_paper.setActionCommand("1");
		comp_rock = new JRadioButton("Rock");
		comp_rock.setActionCommand("0");
		comp_scissor = new JRadioButton("Scissor");
		comp_scissor.setActionCommand("2");
		comp_choice = new ButtonGroup();
		comp_choice.add(comp_rock);
		comp_choice.add(comp_paper);
		comp_choice.add(comp_scissor);
		
		JFrame this_frame = this;
		
		compRadioPanel.add(comp_rock);
		compRadioPanel.add(comp_paper);
		compRadioPanel.add(comp_scissor);
		
		computerPanel.add(lblComputer);
		computerPanel.add(compRadioPanel);
		computerPanel.setBackground(Color.pink);
		computerPanel.setBorder(BorderFactory.createLineBorder(Color.red));

		
		my_paper = new JRadioButton("Paper");
		my_paper.setActionCommand("1");
		
		my_rock = new JRadioButton("Rock");
		my_rock.setActionCommand("0");
		my_scissor = new JRadioButton("Scissor");
		my_scissor.setActionCommand("2");
		my_choice = new ButtonGroup();
		my_choice.add(my_rock);
		my_choice.add(my_paper);
		my_choice.add(my_scissor);
		
		myRadioPanel.add(my_rock);
		myRadioPanel.add(my_paper);
		myRadioPanel.add(my_scissor);
		myRadioPanel.setBackground(Color.CYAN);
		
		myPanel.add(lblMyself);
		myPanel.add(myRadioPanel);
		myPanel.setBackground(Color.CYAN);
		myPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
				
		Random rand = new Random();
		pc_choice = rand.nextInt(3);
		switch(pc_choice) {
		case 0: comp_rock.setSelected(true); break;
		case 1:comp_paper.setSelected(true); break;
		case 2:comp_scissor.setSelected(true); break;
		}
		
		btnGame.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				user_choice_str = my_choice.getSelection().getActionCommand();
				user_choice = Integer.parseInt(user_choice_str);
				result = matrix_A[pc_choice][user_choice];
				switch(result) {
				case -1:
					output_print = "You win the game";
					score = score + 1;
					break;
				case 0:
					output_print = "Draw match";
					break;
				case 1:
					output_print = "You lost the game";
					score = score -1;
					break;
				}
				int continue_next = JOptionPane.showConfirmDialog(null,output_print+"\nDo you want to continue ? ","continue?" ,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if (continue_next == JOptionPane.YES_OPTION) {
					my_choice.clearSelection();
					comp_choice.clearSelection();
					Random rand = new Random();
					pc_choice = rand.nextInt(3);
					switch(pc_choice) {
					case 0: comp_rock.setSelected(true); break;
					case 1:comp_paper.setSelected(true); break;
					case 2:comp_scissor.setSelected(true); break;
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Score is "+score, "Happy Ending",  JOptionPane.INFORMATION_MESSAGE);
					if(score >= last_score) {
					try {
						FileWriter myWriter = new FileWriter(new File("D:\\Eclipse-Workspace\\Console_backend\\src\\last_score.txt"));
						myWriter.write(Integer.toString(score));
						myWriter.close();
						System.out.println("File Rewritten successfully !");
						}
						catch(IOException e1) {
							System.out.println("Cannot write to file!");
						}
					
					System.exit(0);
				}}
			}
		});
		
	
		
		
		
		JPanel p5 = new JPanel(new BorderLayout());
		
		p5.add(computerPanel, BorderLayout.NORTH);
		p5.add(myPanel, BorderLayout.CENTER);
		p5.add(btnGame, BorderLayout.SOUTH);
		
        setLayout(new BorderLayout());
        add(p5, BorderLayout.CENTER);
		//add(p5, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //this.add(my_choice);
        //this.add(comp_choice);
	}

	/*
    public void actionPerformed(ActionEvent e) {
    	String command = e.getActionCommand();
    	System.out.print(command);
    	if(command.equals("Submit the Move.")) {
    		user_choice_str = my_choice.getSelection().getActionCommand();
			user_choice = Integer.parseInt(user_choice_str);
			result = matrix_A[pc_choice][user_choice];
			switch(result) {
			case -1:
				output_print = "You win the game";
				break;
			case 0:
				output_print = "Draw match";
				break;
			case 1:
				output_print = "You lost the game";
				break;
			}
			int continue_next = JOptionPane.showConfirmDialog(null,output_print+"\nDo you want to continue ? ","continue?" ,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			
    	}
    }*/
    
    
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getID());
		// TODO Auto-generated method stub
		
	}
	
	public void clear_form() {
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("action-"+e.getSource());
		
	}

}
