package abstraction02;

public class Mouse {
	public String name; // 객체 멤버 속성
	public int age; // 객체 멤버 속성
	public static int countOfTail = 1; // 모든 객체가 같은 값을 가지고 있을 때 이렇게 수정. 클래스 속성으로 만들어줌. 클래스안에서 관리할 수 있는 메모리 공간 할당
	// 클래스 멤버속성
	// public final static int countOfTail = 1;

	public void sing() { // 객체 멤버 메소드
		System.out.println(name + " 찍찍!!!");
	}
}