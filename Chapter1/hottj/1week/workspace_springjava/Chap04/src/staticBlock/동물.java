package staticBlock;

public class 동물 {
	static { // 스태틱 블록. 한번만 실행
		System.out.println("동물 클래스 레디 온!");
	}

	{ // 넌스태틱 블록. 힙영역에 객체가 만들어질때마다 실행. 모든 객체생성자가 실행되기 전에 얘가 실행
		System.out.println("동물 인스턴스 생성");
	}
}

// 스태틱 메모리 영역에 올라감