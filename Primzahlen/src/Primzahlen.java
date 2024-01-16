import java.util.Arrays;
import java.util.stream.IntStream;

public class Primzahlen {

	public static void main(String[] args) {
		int[] numberList = IntStream.rangeClosed(1, 40).toArray();
		
		System.out.println(Arrays.toString(numberList));
		
		for (int i = 1; i <= (int)Math.sqrt(numberList.length) + 1; i++) {
			if (numberList[i] != 0) {
				for (int j = 2; j <= (40 / (i + 1)); j++) {
					int multipliedNumber = numberList[i] * j;
					numberList[multipliedNumber - 1] = 0;
				}
			}
		}
		
		System.out.println(Arrays.toString(numberList));
	}

}
