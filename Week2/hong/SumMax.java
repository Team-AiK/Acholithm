//시간 복잡도 O(n) 생각
public class SumMax {

	public SumMax(int[] input) {
		int max = input[0];
		int result = max;
		for (int index = 1; index < input.length; index++) {
			if (input[index - 1] > 0) {
				input[index] += input[index - 1];
				result = input[index];
			} else
				result = input[index];

			if (max < result)
				max = result;

		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		int[] c1 = { -1, 3, -1, 5 };
		int[] c2 = { -5, -3, -1 };
		int[] c3 = { 2, 4, -2, -3, 8 };
		int[] c4 = { 33, 36, -73, 15, 43, -17, 36, -28, -1, 21 };
		int[] c5 = { -3, -5, -1, -2 };

		new SumMax(c1);
		new SumMax(c2);
		new SumMax(c3);
		new SumMax(c4);
		new SumMax(c5);
	}
}

