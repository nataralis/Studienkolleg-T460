import java.util.Scanner;

public class Vektor {
	// 1. Attribute
	double[] x = new double[3];
	Scanner sc = new Scanner(System.in);
	
	// 2. Konstruktoren
	public Vektor() {
		System.out.println("x?");
		x[0] = sc.nextDouble();
		System.out.println("y?");
		x[1] = sc.nextDouble();
		System.out.println("z?");
		x[2] = sc.nextDouble();
	}
	
	public Vektor(double x, double y, double z) {
		this.x[0] = x;
		this.x[1] = y;
		this.x[2] = z;
	}
	
	// 3. Methoden
	public String toString() {
		String str = "(" + x[0] + ", " + x[1] + ", " + x[2] + ")";
		return str;
	}
	
	public Vektor addieren(Vektor summand) {
		Vektor summe = new Vektor(0, 0, 0);
		for (int i = 0; i < 3; i++) {
			summe.x[i] = this.x[i] + summand.x[i];
		}
		return summe;
	}
	
	public Vektor skalarMultiplizieren(double faktor) {
		Vektor produkt = new Vektor(0, 0, 0);
		for (int i = 0; i < 3; i++) {
			produkt.x[i] = this.x[i] * faktor;
		}
		return produkt;
	}

	public double skalarproduktBerechnen(Vektor faktor) {
		double produkt = 0;
		for (int i = 0; i < 3; i++) {
			produkt += this.x[i] * faktor.x[i];
		}
		return produkt;
	}

	public Vektor vektorproduktBerechnen(Vektor faktor) {
		Vektor produkt = new Vektor(0, 0, 0);
		for (int i = 0; i < 3; i++) {
			int ersterIndex = (i + 1) % 3;
			int zweiterIndex = (i + 2) % 3;
			produkt.x[i] = this.x[ersterIndex] * faktor.x[zweiterIndex] - this.x[zweiterIndex] * faktor.x[ersterIndex];
		}
		return produkt;
	}

	public static void main(String[] args) {
		Vektor a = new Vektor();
		System.out.println(a);
		Vektor b = new Vektor();
		System.out.println(b);
		System.out.println(a.addieren(b));
		System.out.println(a.skalarMultiplizieren(4));
		System.out.println(a.skalarproduktBerechnen(b));
		System.out.println(a.vektorproduktBerechnen(b));
	}
}
