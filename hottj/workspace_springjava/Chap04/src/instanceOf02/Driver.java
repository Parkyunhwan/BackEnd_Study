package instanceOf02;

class 동물 {

}

class 조류 extends 동물 {

}

class 펭귄 extends 조류 {

}

public class Driver {
	public static void main(String[] args) {
		동물 동물객체 = new 동물();
		동물 조류객체 = new 조류();
		동물 펭귄객체 = new 펭귄();

		System.out.println(동물객체 instanceof 동물);
		// 네
		System.out.println(조류객체 instanceof 동물);
		// 네
		System.out.println(조류객체 instanceof 조류);
		// 조류객체는 동물의 역할이지만 실제 만들어진 건 조류이므로, true가 나온다.
		System.out.println(펭귄객체 instanceof 동물);
		System.out.println(펭귄객체 instanceof 조류);
		System.out.println(펭귄객체 instanceof 펭귄);

		System.out.println(펭귄객체 instanceof Object);
	}
}

// 참조자료형이 어떤 역할을 하냐가 아니라 어떤 걸 가리키냐가이다.