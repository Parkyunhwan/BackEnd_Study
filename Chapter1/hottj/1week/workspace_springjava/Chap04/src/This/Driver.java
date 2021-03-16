package This;

class 펭귄 {
	int var = 10; // 객체 멤버 속성

	void test() {
		int var = 20; // 지역 변수

		System.out.println(var); // 지역 변수
		System.out.println(this.var); // 속성 변수
	}
}

// 펭귄이 만들어질때마다 test()를 계속 만들어주면 낭비이므로, 자바 컴파일러가 지능적으로 펭귄의 속성만 가져가고 메소드는 정적멤버로 바꾸고 스태틱영역에 올린다. this.test

public class Driver {
	public static void main(String[] args) {
		펭귄 뽀로로 = new 펭귄();
		뽀로로.test(); // 사실 뽀로로.test()지만 펭귄.test()로 실행된다. test() 메소드는 스태틱영역에 펭귄클래스안에 올라가므로
	}
}