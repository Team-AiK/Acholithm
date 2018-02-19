public class Longest {
	int over = 0;
	int unvalue = 0;
	boolean flag = false;
	boolean conflag = false;

	public Longest(int[] input) {
		int len = input.length;
		for (int i = 0; i < len - 1; i++) {
			process(input[i], input[i + 1]);
		}
		if (conflag)
			over++;
		if (unvalue == 1 && over == 1) {
			over = 0;
		}
		System.out.println(len - over - unvalue);

	}

	public void process(int curr, int next) {
		if (curr > next) {
			unvalue++;
			flag = false;
			if (conflag) {
				over++;
			}
			conflag = false;
		} else if (curr < next) {
			if (flag) {
				conflag = true;
			}
			flag = true;
		}
	}

	public static void main(String[] args) {

		int[] c1 = { 10, 9, 0, 7, 2, 5 };
		int[] c2 = { 0, 8, 12, 2, 6, 14, 9, 5, 13, 3, 11, 7, 15 };
		int[] c3 = { 7, 8, 9, 10, 6, 5, 12, 14, 13, 1, 2, 3, 4 };
		int[] c4 = { 1, 0, 2, 4 };
		new Longest(c1);
		new Longest(c2);
		new Longest(c3);
		new Longest(c4);
	}
}

