import java.awt.Color;

import javax.swing.JButton;

public abstract class AbstractButtonFactory {
	
	public static JButton getButtonFactory(ButtonType bt) {
		JButton btnFact = null;
		switch (bt) {
		case WINTER:
			System.out.println("Winter opened");
			btnFact = new JButton();
			btnFact.setBackground(new Color(59,89,182));
			btnFact.setForeground(Color.WHITE);
			btnFact.setFocusPainted(false);
			break;
		case SUMMER: 
			System.out.println("Summer opened");
			btnFact = new JButton();
			btnFact = new JButton();
			btnFact.setBackground(new Color(50,205,50));
			btnFact.setForeground(Color.WHITE);
			btnFact.setFocusPainted(false);
		default:
			System.out.println("ERROR");
		}
		System.out.println("returned");
		return btnFact;
	}

}
