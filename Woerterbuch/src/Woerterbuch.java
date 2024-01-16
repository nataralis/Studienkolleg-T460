import java.util.Scanner;
import java.util.TreeMap;

public class Woerterbuch {
	
	/*
	static Scanner sc = new Scanner(System.in);
	
	static String[] deutsch;
	static String[] englisch;
	
	public static void eingeben() {
		System.out.println("Wie viele Wörter möchten Sie eingeben?");
		int woerterAnzahl = sc.nextInt();
		
		deutsch = new String[woerterAnzahl];
		englisch = new String[woerterAnzahl];
		
		for (int i = 0; i < woerterAnzahl; i++) {
			System.out.println("Deutsches Wort?");
			deutsch[i] = sc.next();
			System.out.println("Zugehöriges englisches Wort?");
			englisch[i] = sc.next();
		}
	}
	
	private static int wortSuchen(String wort) {
		for (int i = 0; i < deutsch.length; i++) {
			if (deutsch[i].equals(wort)) {
				return i;
			}
		}
		return -1;
	}
	
	public static void uebersetzen() {
		System.out.println("Bitte geben Sie ein Wort ein");
		String wort = sc.next();
		
		int wortIndex = wortSuchen(wort);
		
		if (wortIndex == -1) {
			System.out.println("Wort nicht gefunden.");
			return;
		}
		System.out.println(englisch[wortIndex]);
	}
	*/
	
	static Scanner sc = new Scanner(System.in);
	static TreeMap<String, String> buch = new TreeMap<>();
	
	public static void eingeben() {
		System.out.println("Wie viele Wörter möchten Sie eingeben?");
		int woerterAnzahl = sc.nextInt();
		
		String deutsch, englisch;
		
		for (int i = 0; i < woerterAnzahl; i++) {
			System.out.println("Deutsches Wort?");
			deutsch = sc.next();
			System.out.println("Zugehöriges englisches Wort?");
			englisch = sc.next();
			buch.put(deutsch, englisch);
		}
	}
	
	public static void uebersetzen() {
		System.out.println("Deutsches Wort zu übersetzen?");
		String wort = sc.next();

		System.out.println(buch.get(wort));
	}
	
	public static void main(String[] args) {
		eingeben();
		uebersetzen();
	}

}
