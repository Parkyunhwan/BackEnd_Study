package reference;

public class CallByValue {
	public static void main(String[] args) {
		int a = 10;
		int b = a;
		
		b = 20; // b에 어떤 값을 넣어도 a에 영향을 주지 않는다.
		
		System.out.println(a); // 10
		System.out.println(b); // 20
	}
}

// 메인 스택 프레임안에 a와 b가 독립적으로 공간이 생긴다.