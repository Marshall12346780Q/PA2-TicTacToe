import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe {

	JButton[] buttons = new JButton[9];
	JButton reset = new JButton();
	JFrame frame = new JFrame();
	JPanel topPane = new JPanel();
	JPanel bottomPane = new JPanel();
	JLabel textfield = new JLabel();
    boolean p1flag;

	public TicTacToe(){
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500,500);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		bottomPane.setLayout(new GridLayout(3,3));
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			bottomPane.add(buttons[i]);
			buttons[i].setFont(new Font("Sans-Serif" ,Font.BOLD,120));
			buttons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i=0;i<9;i++) {
						if(e.getSource()==buttons[i]) {
							if(p1flag) {
								if(buttons[i].getText()=="") {
									buttons[i].setText("O");
									p1flag=false;
									textfield.setText("X turn");
									checkForWinner();
								}
							}
							else {
								if(buttons[i].getText()=="") {
									buttons[i].setText("X");
									p1flag=true;
									textfield.setText("O turn");
									checkForWinner();
								}
							}
						}			
					}
				}
			});
		}
		
		topPane.add(textfield);
		topPane.add(reset);
		reset.setText("RESET");
		reset.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < 9; i++) {
					buttons[i].setEnabled(true);
				}
				for (int i = 0; i < 9; i++) {
					buttons[i].setText("");
				}
			}
		});
		frame.add(topPane,BorderLayout.NORTH);
		frame.add(bottomPane);
		
	}
	
	public void checkForWinner() {
		// Y wins
		if((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[0].getText().equals("O"))) {
			hasWinner("O");
		}
		if((buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O"))) {
			hasWinner("O");
		}
		if((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
			hasWinner("O");
		}
		if((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
			hasWinner("O");
		}
		if((buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText()=="O")) {
			hasWinner("O");
		}
		if((buttons[0].getText().equals("O")) &&(buttons[1].getText().equals("O")) &&(buttons[2].getText().equals("O"))) {
			hasWinner("O");
		}
		if(	(buttons[3].getText().equals("O")) &&	(buttons[4].getText().equals("O")) &&(buttons[5].getText().equals("O"))) {
			hasWinner("O");
		}
		if((buttons[6].getText().equals("O")) &&(buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
			hasWinner("O");
		}
		// X wins 
		if((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) &&(buttons[6].getText().equals("X"))) {
			hasWinner("X");
		}
		if((buttons[1].getText().equals("X")) &&(buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X"))) {
			hasWinner("X");
		}
		if((buttons[2].getText().equals("X")) &&(buttons[5].getText().equals("X")) &&(buttons[8].getText().equals("X"))) {
			hasWinner("X");
		}
		if((buttons[0].getText().equals("X")) &&(buttons[4].getText().equals("X")) &&(buttons[8].getText().equals("X"))) {
			hasWinner("X");
		}
		if((buttons[2].getText().equals("X")) &&(buttons[4].getText().equals("X")) &&(buttons[6].getText().equals("X"))) {
			hasWinner("X");
		}
		if((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))) {
			hasWinner("X");
		}
		if((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))) {
			hasWinner("X");
		}
		if((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) &&(buttons[9].getText().equals("X"))) {
			hasWinner("X");
		}
		
		
		
	}
	
	public void hasWinner(String winner) {
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		if (winner.equals("X")) 
			textfield.setText("X wins");
		if (winner.equals("O")) 
			textfield.setText("O wins");
		
		
	}
	
}

