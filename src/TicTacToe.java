import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class TicTacToe {

	JButton[] buttons = new JButton[9];
	JButton reset = new JButton();
	JFrame frame = new JFrame();
	JPanel topPane = new JPanel();
	JPanel bottomPane = new JPanel();
	JLabel textfield = new JLabel();
	JLabel timerlabel = new JLabel("1:00");
	
    boolean p1flag;

	public TicTacToe(){
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500,500);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		final Timer t = new Timer(1000, new ActionListener() {
			int time = 60;
			@Override
			public void actionPerformed(ActionEvent e) {
				time--;
				timerlabel.setText(formatTime(time/60) + ":" + formatTime(time % 60));
				if (time == 0) {
					final Timer timer = (Timer) e.getSource();
					timer.stop();
					timerlabel.setText("TIME ENDED GAME STOPPED");
					for(int i = 0; i < 9; i++) {
						buttons[i].setEnabled(true);
					}
					for (int i = 0; i < 9; i++) {
						buttons[i].setText("");
					}
				}
				
			}
		});
		
		
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
									boolean check = checkForWinner();
									if (check) 
										t.stop();
								}
							}
							else {
								if(buttons[i].getText()=="") {
									buttons[i].setText("X");
									p1flag=true;
									textfield.setText("O turn");
									boolean check = checkForWinner();
									if (check) 
										t.stop();	
								}
							}
						}			
					}
				}
			});
		}
		
		topPane.add(textfield);
		topPane.add(reset);
		t.start();
		topPane.add(timerlabel);
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
	
	public boolean checkForWinner() {
		// Y wins
		if((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[0].getText().equals("O"))) {
			return hasWinner("O");
		}
		if((buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O"))) {
			return hasWinner("O");
		}
		if((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
			return hasWinner("O");
		}
		if((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
			return hasWinner("O");
		}
		if((buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText()=="O")) {
			return hasWinner("O");
		}
		if((buttons[0].getText().equals("O")) &&(buttons[1].getText().equals("O")) &&(buttons[2].getText().equals("O"))) {
			return hasWinner("O");
		}
		if(	(buttons[3].getText().equals("O")) &&	(buttons[4].getText().equals("O")) &&(buttons[5].getText().equals("O"))) {
			return hasWinner("O");
		}
		if((buttons[6].getText().equals("O")) &&(buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
			return hasWinner("O");
		}
		// X wins 
		if((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) &&(buttons[6].getText().equals("X"))) {
			return hasWinner("X");
		}
		if((buttons[1].getText().equals("X")) &&(buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X"))) {
			return hasWinner("X");
		}
		if((buttons[2].getText().equals("X")) &&(buttons[5].getText().equals("X")) &&(buttons[8].getText().equals("X"))) {
			return hasWinner("X");
		}
		if((buttons[0].getText().equals("X")) &&(buttons[4].getText().equals("X")) &&(buttons[8].getText().equals("X"))) {
			return hasWinner("X");
		}
		if((buttons[2].getText().equals("X")) &&(buttons[4].getText().equals("X")) &&(buttons[6].getText().equals("X"))) {
			return hasWinner("X");
		}
		if((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))) {
			return hasWinner("X");
		}
		if((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))) {
			return hasWinner("X");
		}
		if((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) &&(buttons[9].getText().equals("X"))) {
			return hasWinner("X");
		}
		return false;
		
		
		
	}
	
	public boolean hasWinner(String winner) {
		
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		if (winner.equals("X")) 
			textfield.setText("X wins");
		if (winner.equals("O")) 
			textfield.setText("O wins");
		
		return true;
		
	}
	
	private static String formatTime(int i) {
        String result = String.valueOf(i);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }
	
}

