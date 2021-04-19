package abstraction02;

public class MouseDriver {
	public static void main(String[] args) {
		// 클래스명.countOfTail
		Mouse.countOfTail = 1; // 스태틱 영역에 있는 countOfTail로 간다.

		Mouse mickey = new Mouse();
		Mouse jerry = new Mouse();
		Mouse mightyMouse = new Mouse();

		// 객체명.countOfTail
		System.out.println(mickey.countOfTail); // 객체에 없으면 static에 있는지 확인한다. 두번 확인해야하므로 좋지 않다.
		System.out.println(jerry.countOfTail);
		System.out.println(mightyMouse.countOfTail);

		// 클래스명.countOfTail
		System.out.println(Mouse.countOfTail);
	}
}