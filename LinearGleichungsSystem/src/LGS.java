import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class LGS {

	static BigDecimal[][] matrix;
	static String[] loesung;
	static int skala = 4;

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		eingeben();
		ausgeben();
		System.out.println();
		loesen();
		loesungAusgeben();
		System.out.println();
		ausgeben();
	}
	
	private static BigDecimal bd(double wert) {
		return new BigDecimal(Double.toString(wert));
	}
	
	private static boolean eq(BigDecimal a, BigDecimal b) {
		return a.setScale(skala - 1, RoundingMode.HALF_UP).equals(b.setScale(skala - 1, RoundingMode.HALF_UP));
	}

	private static void loesen() {
		lgsOrganisieren();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length - 1; j++) {
				BigDecimal faktor = bd(0);
				if (!eq(matrix[i][i], bd(0))) {
					faktor = bd(-1).multiply(matrix[j][i]).divide(matrix[i][i], RoundingMode.HALF_UP);
				}
				
				if (i != j) {
					lgsAddieren(faktor, i, j);
				} else if (!eq(matrix[i][i], bd(0))) {
					lgsDividieren(matrix[i][i], i);
				}
			}
		}
	}
	
	private static void loesungAusgeben() {
		for (int i = 0; i < matrix.length; i++) {
			if (!eq(matrix[i][i], bd(1)) && !leerChecken(matrix[i])) {
				System.out.println("Dieses LGS hat keine Lösung");
				System.out.println("L = []");
				return;
			} else {
				loesungAusgabeRechnen();
			}
		}
		
		if (enthaeltP()) {
			System.out.println("Dieses LGS hat unendlich viele Lösungen");
		} else {
			System.out.println("Dieses LGS hat eine Lösung");
		}
		System.out.println("L = " + Arrays.toString(loesung));
	}
	
	private static void loesungAusgabeRechnen() {
		loesung = new String[matrix.length];
		for (int i = matrix.length - 1; i >= 0; i--) {
			if (leerChecken(matrix[i])) {
				loesung[i] = "p" + i;
			} else {
				loesung[i] = matrix[i][matrix[i].length - 1].setScale(skala - 1, RoundingMode.HALF_UP).toString();
				for (int j = i + 1; j < matrix[i].length - 1; j++) {
					if (!eq(matrix[i][j], bd(0))) {
						if (matrix[i][j].signum() == 1) {
							loesung[i] += " - " + matrix[i][j].setScale(skala - 1, RoundingMode.HALF_UP).toString();
						} else if (matrix[i][j].signum() == -1) {
							loesung[i] += " + " + matrix[i][j].negate().setScale(skala - 1, RoundingMode.HALF_UP).toString();
						}
						loesung[i] += loesung[j];
					}
				}
			}
		}
	}
	
	private static boolean enthaeltP() {
		for (int i = 0; i < loesung.length; i++) {
			if (loesung[i].contains("p")) {
				return true;
			}
		}
		return false;
	}

	private static void ausgeben() {
		String ausgabe = "";
		char alphabet;
		
		for (int i = 0; i < matrix.length; i++) {
			alphabet = 'x';
			for (int j = 4; j < matrix[i].length; j++) {
				alphabet--;
			}
			
			for (int j = 0; j < matrix[i].length; j++) {
				ausgabe += matrix[i][j].setScale(skala - 1, RoundingMode.HALF_UP);
				if (j < matrix[i].length - 1) {
					ausgabe += Character.toString(alphabet);
				}
				if (j < matrix[i].length - 2) {
					ausgabe += " + ";
					alphabet++;
				} else if (j == matrix[i].length - 2) {
					ausgabe += " = ";
				}
			}
			ausgabe += "\n";
		}
		System.out.print(ausgabe);
	}

	private static void eingeben() {
		System.out.println("Dimensionen der Matrix?");
		int dimension = sc.nextInt();
		System.out.println("Skala?");
		skala = sc.nextInt() + 1;

		matrix = new BigDecimal[dimension][dimension + 1];

		for (int i = 0; i < dimension; i++) {
			System.out.println((i + 1) + ". Gleichung:");
			for (int j = 0; j < dimension + 1; j++) {
				if (j == matrix[i].length - 1) {
					System.out.println("Antwort:");
				} else {
					System.out.println((j + 1) + ". Wert:");
				}
				matrix[i][j] = bd(sc.nextDouble());
			}
		}
	}

	private static BigDecimal[] multiplizieren(BigDecimal faktor, int zeile) {
		BigDecimal[] multiplizierteGleichung = new BigDecimal[matrix[zeile].length];
		for (int i = 0; i < matrix[zeile].length; i++) {
			multiplizierteGleichung[i] = matrix[zeile][i].multiply(faktor).setScale(skala, RoundingMode.HALF_UP);
		}
		return multiplizierteGleichung;
	}
	
	private static BigDecimal[] dividieren(BigDecimal faktor, int zeile) {
		BigDecimal[] dividierteGleichung = new BigDecimal[matrix[zeile].length];
		for (int i = 0; i < matrix[zeile].length; i++) {
			dividierteGleichung[i] = matrix[zeile][i].divide(faktor, RoundingMode.HALF_UP).setScale(skala, RoundingMode.HALF_UP);
		}
		return dividierteGleichung;
	}

	private static BigDecimal[] addieren(BigDecimal faktor, int von, int zu) {
		BigDecimal[] multiplizierteGleichung = multiplizieren(faktor, von);

		BigDecimal[] addierteGleichung = new BigDecimal[matrix[zu].length];
		for (int i = 0; i < matrix[zu].length; i++) {
			addierteGleichung[i] = matrix[zu][i].add(multiplizierteGleichung[i]).setScale(skala, RoundingMode.HALF_UP);
		}
		return addierteGleichung;
	}
	
	private static void lgsOrganisieren() {
		int nichtLeereGleichungenAnzahl = matrix.length;
		
		for (int i = 0; i < matrix.length; i++) {
			if(leerChecken(matrix[i]) && i < matrix.length / 2) {
				lgsVertauschen(i, matrix.length - 1 - i);
				nichtLeereGleichungenAnzahl = matrix.length - i;
			}
		}
		
		for (int i = 0; i < nichtLeereGleichungenAnzahl; i++) {
			if (eq(matrix[i][i], bd(0)) && !leerChecken(matrix[i])) {
				for (int j = matrix.length - 1; j >= 0; j--) {
					if (!eq(matrix[j][i], bd(0))) {
						lgsVertauschen(i, j);
					}
				}
			}
		}
	}
	
	private static boolean leerChecken(BigDecimal[] array) {
		for (int i = 0; i < array.length; i++) {
			if (!eq(array[i], bd(0))) {
				return false;
			}
		}
		return true;
	}

	/*
	private static void lgsMultiplizieren(BigDecimal faktor, int zeile) {
		matrix[zeile] = multiplizieren(faktor, zeile);
	}
	*/
	
	private static void lgsDividieren(BigDecimal faktor, int zeile) {
		matrix[zeile] = dividieren(faktor, zeile);
	}

	private static void lgsAddieren(BigDecimal faktor, int von, int zu) {
		matrix[zu] = addieren(faktor, von, zu);
	}
	
	private static void lgsVertauschen(int a, int b) {
		BigDecimal[] temporaereLagerung = matrix[a];
		matrix[a] = matrix[b];
		matrix[b] = temporaereLagerung;
	}
}
