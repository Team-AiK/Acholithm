import java.util.Stack;

public class Palindrome {
	Stack<Integer> stackIn = new Stack<Integer>();
	Stack<Integer> stackOut = new Stack<Integer>();

	public Palindrome(int input) {
		if (input < 0) {
			System.out.println(false);
		} else {
			while (input > 0) {
				stackIn.push(input % 10);// 각 자리마다 스택에 push
				input = input / 10;
			}
			int len = stackIn.size() / 2;
			for (int index = 0; index <len; index++) {
				stackOut.push(stackIn.pop());
			}
			
			System.out.println(stackIn.containsAll(stackOut));
		}

	}

	public static void main(String[] args) {
		new Palindrome(12345);
		new Palindrome(-101);
		new Palindrome(111111);
		new Palindrome(12421);


	}
}

