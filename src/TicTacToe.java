import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class TicTacToe {

	public JButton[] buttons = new JButton[9];
	protected JButton reset = new JButton();
	protected JFrame frame = new JFrame();
	private JPanel topPane = new JPanel();
	private JPanel bottomPane = new JPanel();
	protected JLabel textfield = new JLabel();
	private JLabel timerlabel = new JLabel("Time Remaining This Turn: 15");
	private int time = 15;
    private boolean p1flag;

	public TicTacToe(){
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500,500);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		topPane.add(textfield);
		topPane.add(reset);
		reset.setText("RESET");
		textfield.setText("X's Turn");
		topPane.add(timerlabel);
		bottomPane.setLayout(new GridLayout(3,3));
		frame.add(topPane,BorderLayout.NORTH);
		frame.add(bottomPane);
		
		final Timer t = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//if reset is clicked
				time--;
				timerlabel.setText("Time Remaining This Turn: " + String.valueOf(time));
				if (time == 0) {
					final Timer timer = (Timer) e.getSource(); //?
					timer.stop();
					//check for whose turn it was, set other as winner
					if(p1flag)
					{
						timerlabel.setText("O'S TURN TIME EXPIRED: X WINS");
					}
					else
					{
						timerlabel.setText("X'S TURN TIME EXPIRED: O WINS");
					}
					for(int i = 0; i < 9; i++) {
						buttons[i].setEnabled(false);
					}
					for (int i = 0; i < 9; i++) {
						buttons[i].setText("");
					}
				}
			}
		});
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			bottomPane.add(buttons[i]);
			buttons[i].setFont(new Font("Sans-Serif" ,Font.BOLD,120));
			buttons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i=0;i<9;i++) {
						if(e.getSource()==buttons[i]) {
							time = 15; //reset move timer
							if(p1flag) {
								if(buttons[i].getText()=="") {
									buttons[i].setText("O");
									p1flag=false;
									textfield.setText("X's turn");
									boolean check = checkForWinner();
									if (check) 
										t.stop();
								}
							}
							else {
								if(buttons[i].getText()=="") {
									buttons[i].setText("X");
									p1flag=true;
									textfield.setText("O's turn");
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
		
		reset.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main.main(null);
				//TicTacToe t = new TicTacToe();
			}
		});		
		
		topPane.add(textfield);
		topPane.add(reset);
		t.start();
		
	}
	
	
	protected boolean checkForWinner() {
		// Y wins
		if((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O"))) {
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
		if((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) &&(buttons[8].getText().equals("X"))) {
			return hasWinner("X");
		}
		//Draw
		boolean drawCheck = true;
		for(int i = 0; i<9; i++)
		{
			if(!(buttons[i].getText().equals("O")||buttons[i].getText().equals("X"))) {
				drawCheck = false;
			}
		}
		if(drawCheck == true)
		{
			return hasWinner("Draw");
		}
		return false;
		
		
		
	}
	
	protected boolean hasWinner(String winner) {
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		if (winner.equals("Draw"))
			textfield.setText("Draw");
		if (winner.equals("X")) 
			textfield.setText("X wins");
		if (winner.equals("O")) 
			textfield.setText("O wins");
		
		return true;
		
	}
	
	
}

