import java.util.Arrays;
import java.util.Random;

public class DutchNationalFlag {
	enum DutchColors {
		WHITE, RED, BLUE
	}

	private static void dutchNationalFlagSort(DutchColors[] items, DutchColors pivot) {
		int lo = 0, mid = 0, hi = items.length - 1;

		while (mid <= hi) {
			if (items[mid].ordinal() < pivot.ordinal()) {
				swap(items, lo++, mid++);

			} else if (items[mid].ordinal() == pivot.ordinal()) {
				mid++;
			} else {
				swap(items, mid, hi--);
			}
		}
	}

	private static void swap(DutchColors[] arr, int a, int b) {
		DutchColors tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public static void main(String[] args) {
		DutchColors[] balls = new DutchColors[12];

		DutchColors[] values = DutchColors.values();
		Random rand = new Random();
		for (int i = 0; i < balls.length; i++)
			balls[i] = values[rand.nextInt(values.length)];

		System.out.println("Before: " + Arrays.toString(balls));

		dutchNationalFlagSort(balls, DutchColors.RED);

		System.out.println("After : " + Arrays.toString(balls));
	}
}