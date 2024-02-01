import java.util.Arrays;

public class Fledermaus {
	
	// Paige Harrison
	// paige.harrison@stud.tu-darmstad.de

	public static void main(String[] args) {
		int[] bsp1 = new int[]{4, 1, 5, 2, 3, 4, 2, 5};
		int[] bsp2 = new int[]{4, 1, 5, 2, 2, 3, 4, 4, 5, 4};
		int[] bsp3 = new int[]{2, 1, 5, 2, 3, 4, 2, 5};
		
		System.out.println(zweier(bsp1));
		System.out.println(zweier(bsp2));
		System.out.println(zweier(bsp3));
		
		int[] bsp4 = new int[]{4, 1, 5, 2, 3, 4, 4, 5, 5, 5, 5, 5};
		
		System.out.println(mehrfach(bsp4));
	}
	
	public static boolean zweier(int[] zahlen) {
		int zaehler = 0;
		int alleinZaehler = 0;
		
		for (int i = 0; i < zahlen.length; i++) {
			if (zahlen[i] == 2) {
				zaehler++;
				if (i != 0 && i != zahlen.length - 1) {
					if (zahlen[i + 1] != 2 && zahlen[i - 1] != 2) {
						alleinZaehler++;
					}
				} else if (i == 0) {
					if (zahlen[i + 1] != 2) {
						alleinZaehler++;
					}
				} else if (i == zahlen.length - 1) {
					if (zahlen[i - 1] != 2) {
						alleinZaehler++;
					}
				}
			}
		}
		
		if (zaehler == 2 && alleinZaehler == 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int mehrfach(int[] zahlen) {
		int zaehler = 0;
		
		Arrays.sort(zahlen);
		for (int i = 0; i < zahlen.length; i++) {
			for (int j = zahlen.length - 1; j >= 0; j--) {
				if (zahlen[i] == zahlen[j] && i != j) {
					zaehler++;
					i = j;
					break;
				}
			}
		}
		
		return zaehler;
	}

}
//11 von 11