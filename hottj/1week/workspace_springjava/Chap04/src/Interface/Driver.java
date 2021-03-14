package Interface;

interface Speakable {
	double PI = 3.14159; // 상수. final 없어도 됨. public 안붙여도 됨
	final double absoluteZeroPoint = -275.15;

	void sayYes(); // 추상메소드만 가질 수 있음. abstract 가 없어도 됨
}

/*
 * interface Speakable { public static double PI = 3.14159; public static final
 * double absoluteZeroPoint = -275.15;
 * 
 * public abstract void sayYes(); }
 */


class Specker implements Speakable {
	@Override // 생략 가능
	public void sayYes() {
		System.out.println("I say NO!!!");
	}
}

public class Driver {
	public static void main(String[] args) {
		System.out.println(Speakable.absoluteZeroPoint);
		System.out.println(Speakable.PI);

		Specker reporter1 = new Specker();
		reporter1.sayYes();
	}

	public static void test() {
		// 에러: The final field Speakable.PI cannot be assigned
		// Speakable.PI = 3.14; -> 다시 정의할 수 없다.

		// 에러: The final field Speakable.absoluteZeroPoint cannot be assigned
		// Speakable.absoluteZeroPoint = -275.0;
	}
}