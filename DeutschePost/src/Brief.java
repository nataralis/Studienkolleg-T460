import javax.swing.JOptionPane;

public class Brief {
	
	double laenge;
	double breite;
	double hoehe;
	double masse;

	public static void main(String[] args) {
		Brief brief = new Brief();
		
		brief.laenge = inputSammeln("Länge");
		brief.breite = inputSammeln("Breite");
		brief.hoehe = inputSammeln("Höhe");
		brief.masse = inputSammeln("Masse");
		
		if (brief.laenge >= 10 && brief.laenge <= 23.5 && brief.breite >= 9
			&& brief.breite <= 12.5 && brief.hoehe <= 0.5 && brief.masse <= 20) {
				JOptionPane.showMessageDialog(null, "0,85€");
			}
		else if (brief.laenge >= 10 && brief.laenge <= 23.5 && brief.breite >= 7
			&& brief.breite <= 12.5 && brief.hoehe <= 1 && brief.masse <= 50) {
				JOptionPane.showMessageDialog(null, "1,00€");
			}
		else if (brief.laenge >= 10 && brief.laenge <= 35.3 && brief.breite >= 7
			&& brief.breite <= 25 && brief.hoehe <= 2 && brief.masse <= 500) {
				JOptionPane.showMessageDialog(null, "1,60€");
			}
		else if (brief.laenge >= 10 && brief.laenge <= 35.3 && brief.breite >= 7
			&& brief.breite <= 25 && brief.hoehe <= 5 && brief.masse <= 1000) {
				JOptionPane.showMessageDialog(null, "2,75€");
			}
		else if (brief.laenge <= 60 && brief.breite <= 30 && brief.hoehe <= 15
			&& brief.masse <= 2000) {
				JOptionPane.showMessageDialog(null, "3,99€");
			}
		else {
			JOptionPane.showMessageDialog(null, "Paket kann nicht abgeschickt werden.");
		}
	}
	
	private static double inputSammeln(String einheit) {
		double zahl;
		
		do {
			String s = JOptionPane.showInputDialog("Bitte geben Sie die " + einheit + " ein.");
			try {
				zahl = Double.parseDouble(s);
			} catch (Exception e) {
				zahl = -1;
			}
			if (zahl < 1) {
				JOptionPane.showMessageDialog(null, "Bitte geben Sie eine positive Zahl ein.");
			}
		} while (zahl < 1);
		
		return zahl;
	}
}
