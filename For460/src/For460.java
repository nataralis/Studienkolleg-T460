public class For460 {

	public static void main(String[] args) {
		// Aufgabe 1
		for (int i = 0; i < 10; i++) {
			System.out.print((i + 1) + "\t");
		}
		
		System.out.println("\n");
		
		// Aufgabe 2
		for (int i = 0; i < 10; i++) {
			System.out.print((i + 1) * 7 + "\t");
		}
		
		System.out.println("\n");
		
		// Aufgabe 3
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				System.out.println(i + " * " + j + " = " + (i * j));
			}
		}
		
		System.out.println();
		
		// Aufgabe 4a
		for (int i = 0; i < 6; i++) {
			System.out.println("xxxxxxxxxx");
		}
		
		System.out.println();
		
		//Aufgabe 4b
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print("x");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// Aufgabe 5
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("x");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// Aufgabe 6
		for (int i = 1; i <= 6; i++) {
			for (int j = 11; j >= (2 * i) - 1; j--) {
				System.out.print("x");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// Aufgabe 7a
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < 2 * i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// Aufgabe 7b
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < 11 - i * 2; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// Aufgabe 7c
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		
		System.out.println();
		
		//Aufgabe 7d
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
	}

}
