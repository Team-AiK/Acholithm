public class Bracket {
	int count = 0;

	public Bracket(String data, int num) {
		bracket(data, num, num);
		System.out.println();
	}

	public void bracket(String data, int open, int close) {
		if (open > close)
			return;
		if (open == 0 && close == 0) {
			count++;
			System.out.println("[" + count + "]: " + data);
			return;
		}
		if (open < 0 || close < 0)
			return;
		bracket(data + '(', open - 1, close);
		bracket(data + ')', open, close - 1);
	}

	public static void main(String[] args) {
		new Bracket("", 1);
		new Bracket("", 2);
		new Bracket("", 3);
	}
}

