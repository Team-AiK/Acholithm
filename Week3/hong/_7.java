public class _7 {
	int n;
	int cornerN;
	int wWallN;
	String corner = "+";
	String wWall = "=";
	String hWall = "|";
	boolean start = true;
	boolean end = false;

	public _7(int n) {
		this.n = n;
		this.cornerN = n + 1;
		this.wWallN = n;

	}
    
	public void sideWall() {
		System.out.print(hWall);
		for (int i = 0; i < wWallN; i++) {
			System.out.print("  ");
		}
		System.out.println(hWall);
	}

	public void upDownWall() {
		int count = wWallN;
		for (int i = 0; i < cornerN; i++) {
			System.out.print(corner);
			if (count != 0) {
				if (i == 0 && start) {
					System.out.print(" ");

				} else if (i == cornerN -2 && end) {
					System.out.print(" ");


				} else {
					System.out.print(wWall);
				}
				count--;
			}

		}
		System.out.println();
		if(start){
			start=false;
			end=true;
		}else if(end){
			end=false;
			start=true;
		}
	}

	public void makeWall() {
		for (int i = 0; i < n; i++) {
			upDownWall();
			sideWall();
		}
		upDownWall();
	}

	public static void main(String[] args) {
		_7 m = new _7(5);
		m.makeWall();

	}
}

