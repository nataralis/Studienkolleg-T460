public class Matrix {
	
	// Paige Harrison
	// paige.harrison@stud.tu-darmstadt.de
	
	int[][] mx;
	
	public Matrix(int n) {
		mx = new int[n][n];
		
		for (int i = 0; i < mx.length; i++) {
			for (int j = 0; j < mx[i].length; j++) {
				mx[i][j] = (int)(Math.random() * 10);
			}
		}
	}
	
	public String toString() {
		String ausgabe = "";
		
		for(int i = 0; i < mx.length; i++) {
			for (int j = 0; j < mx[i].length; j++) {
				ausgabe += mx[i][j] + "\t";
			}
			if (i < mx.length - 1) {
				ausgabe += "\n";
			}
		}
		
		return ausgabe;
	}
	
	public Matrix addieren(Matrix summand) {
		Matrix summe = new Matrix(mx.length);
		
		if (mx.length != summand.mx.length) {
			System.out.println("Diese Addition-Methode funktioniert nur wenn die Matrizen die gleiche Größe haben!");
			for (int i = 0; i < mx.length; i++) {
				for (int j = 0; j < mx[i].length; j++) {
					summe.mx[i][j] = 0;
				}
			}
			return summe;
		}
		
		for (int i = 0; i < mx.length; i++) {
			for (int j = 0; j < mx[i].length; j++) {
				summe.mx[i][j] = this.mx[i][j] + summand.mx[i][j];
			}
		}
		
		return summe;
	}
	
	public Matrix multiplizieren(Matrix faktor) {
		Matrix produkt = new Matrix(mx.length);
		
		if (mx.length != 2 || faktor.mx.length != 2) {
			System.out.println("Diese Multiplikation-Methode funktioniert nur für 2x2-Matrizen!");
			for (int i = 0; i < mx.length; i++) {
				for (int j = 0; j < mx[i].length; j++) {
					produkt.mx[i][j] = 0;
				}
			}
			return produkt;
		}
		
		for (int i = 0; i < mx.length; i++) {
			for (int j = 0; j < mx[i].length; j++) {
				produkt.mx[i][j] = mx[i][0] * faktor.mx[0][j] + mx[i][1] * faktor.mx[1][j];
			}
		}
		
		return produkt;
	}

	public static void main(String[] args) {
		Matrix a = new Matrix(5);
		System.out.println(a + "\n");
		
		Matrix b = new Matrix(3);
		Matrix c = new Matrix(3);
		System.out.println(b + "\n");
		System.out.println(c + "\n");
		System.out.println(b.addieren(c) + "\n");
		
		Matrix d = new Matrix(2);
		Matrix e = new Matrix(2);
		System.out.println(d + "\n");
		System.out.println(e + "\n");
		System.out.println(d.multiplizieren(e) + "\n");
	}

}
//14 von 14