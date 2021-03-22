package polymorphism01;

public class Driver {
	public static void main(String[] args) {
		Penguin pororo = new Penguin();

		pororo.name = "뽀로로";
		pororo.habitat = "남극";

		pororo.showName(); // 펭귄으로 오버라이딩한 메소드가 실행된다. 재정의
		pororo.showName("초보람보"); // 펭귄으로 오버로드된 메소드가 실행된다. 중복정의
		pororo.showHabitat();

		Animal pingu = new Penguin(); // 펭귄이 태어났는데 동물의 역할

		pingu.name = "핑구"; 
		pingu.showName(); // 동물에 정의된 showName() 이 나올 것인가 펭귄에 정의된 showName()이 나올 것인가?
		// 펭귄에 정의된게 나온다. 왜냐면 펭귄에서 오버라이딩하면 힙영역 메모리에 있는 showName()이 :Animal에 있던 showName()까지 덮어버린다.
		// 이게 다형성이 주는 편리함이다.
	}
}

// 재정의는 힙영역 메모리에 있는 :penguin 과 :animal 영역에 있는 showName()을 재정의한걸로 덮어버린다.