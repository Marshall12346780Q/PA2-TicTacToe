
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



public class Menu {

	private JFrame frame = new JFrame();

	private JButton pvpTTT = new JButton("pvp");
	private JButton aiTTT = new JButton("ai");
	private JButton winterTheme = new JButton("winter");
	private JButton summerTheme = new JButton("summer");
//	JButton factory = AbstractButtonFactory.getButtonFactory(ButtonType.WINTER);
//	JButton factory1 = AbstractButtonFactory.getButtonFactory(ButtonType.SUMMER);
	
	
	
	//JButton winter = WinterButton.JButtonSettings();

	public static String aiorpvp;
	public static int season = 0; // 0=default, 1=winter, 2=summer
	


	public Menu() {

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 427, 370);
		//frame.getContentPane().setBackground(new Color(50,50,50));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JLabel lblNewLabel = new JLabel("List Options");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 25, 393, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel1.setBounds(10, 240, 393, 28);
		frame.getContentPane().add(lblNewLabel1);

		pvpTTT.setBounds(10, 82, 393, 28);
		pvpTTT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aiorpvp = "pvp";
				frame.dispose(); // hide is deprecated but still works for now.
				Options op = new Options();
				op.NewScreen();
			}
		});
		
		
		//JButton aiwin = AbstractButtonFactory.getButtonFactory(ButtonType.WINTER);
		

		aiTTT.setBounds(10, 131, 393, 28);
		aiTTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aiorpvp = "ai";
				frame.dispose(); // hide is deprecated but still works for now.
				Options op = new Options();
				op.NewScreen();
			}
		});
		
		
		
		winterTheme.setBounds(10,180, 196, 28);
		winterTheme.setFocusable(true);
		winterTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				winterTheme.setBackground(new Color(59,89,182));
				winterTheme.setForeground(Color.WHITE);
				winterTheme.setFocusPainted(false);
				//winterTheme.setBackground(Color.RGBtoHSB(255, 78, 50, 0.89));
				System.out.println("Theme set to winter");
				season = 1;
				lblNewLabel1.setText("TicTacToe Game will be Winter Theme");
				
			}
		});
		
		summerTheme.setBounds(196,180,206,28);
		summerTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				summerTheme.setBackground(new Color(50,205,50));
				summerTheme.setForeground(Color.WHITE);
				summerTheme.setFocusPainted(false);
				
				season = 2;
				
				lblNewLabel1.setText("TicTacToe Game will be Summer Theme");
			}
		});

		frame.getContentPane().add(pvpTTT);
		frame.getContentPane().add(aiTTT);
		frame.getContentPane().add(winterTheme);
		frame.getContentPane().add(summerTheme);

	}
	

}

