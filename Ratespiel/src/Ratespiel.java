import javax.swing.JOptionPane;

public class Ratespiel {

	public static void main(String[] args) {
		int schaetzung;
		
		int geheimzahl = (int)(Math.random() * 100 + 1);
		
		do {
			schaetzung = inputSammeln();
			
			if (schaetzung < geheimzahl) {
				JOptionPane.showMessageDialog(null, "Schätzung zu klein!");
			} else if (schaetzung > geheimzahl) {
				JOptionPane.showMessageDialog(null, "Schätzung zu groß!");
			}
		} while (schaetzung != geheimzahl);
		JOptionPane.showMessageDialog(null, "Du gewinnst! Die Geheimzahl war " + geheimzahl + ".");
	}
	
	private static int inputSammeln() {
		int zahl;
		
		do {
			String s = JOptionPane.showInputDialog("Bitte errät eine natürliche Zahl zwischen 1 und 100");
			try {
				zahl = Integer.parseInt(s);
			} catch (Exception e) {
				zahl = 0;
			}
		} while (zahl < 1 || zahl > 100);
		
		return zahl;
	}

}
