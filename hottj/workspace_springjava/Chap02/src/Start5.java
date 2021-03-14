public class Start5 {
	static int share; // 전역 변수. 공유 변수. 0 으로 초기화가 된다.

	public static void main(String[] args) {
		share = 55;

		int k = fun(5, 7);

		System.out.println(share); // 12
	}

	private static int fun(int m, int p) {
		share = m + p; // 12

		return m - p;
	}
}

// 자바 랭과 스태틱 메모리 영역에 Start5, share, main, fun 이 올라온다. share는 멤버 변수이므로 0으로 초기화가 된다. 
// 메인 / fun 스택 프레임이 각각 생기고, 이 안에 변수들 생김
// 공유 변수를 사용하면 누가 어떻게 변했는지 추적하는게 어렵다. 굳이 쓰겠다면 final로 선언해라.


