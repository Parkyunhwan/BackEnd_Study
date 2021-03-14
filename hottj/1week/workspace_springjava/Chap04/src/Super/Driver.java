package Super;

class 동물 {
	void method() {
		System.out.println("동물");
	}
}

class 조류 extends 동물 {
	void method() {
		super.method(); // 상위 클래스 메소드 실행. 동물의 super.method()와 "동물" 출력
		System.out.println("조류");
	}
}

class 펭귄 extends 조류 {
	void method() {
		super.method(); // 상위클래스 메소드 실행. 조류의 super.method()와 "조류" 출력
		System.out.println("펭귄");

		// Syntax error on token "super", Identifier expected
		// super.super.method(); -> 굳이 필요없다.
	}
}

public class Driver {
	public static void main(String[] args) {
		동물 뽀로로 = new 펭귄(); // 펭귄 객체, 조류 객체, 동물 객체 전부다 메모리에 올라감
		뽀로로.method(); // 맨 하위객체인 펭귄 메소드가 실행됨
	}
}

