package inheritance02;

public class 박쥐 extends 포유류 implements 날수있는 { // 박쥐는 포유류를 확장하고 날수있는 기능을 구현했다.
	박쥐() {
		myClass = "박쥐";

	}

	@Override
	public void fly() {
		System.out.println(myClass + " 날고 있삼.. 슈웅!!! 슈웅!!!");
	}
}