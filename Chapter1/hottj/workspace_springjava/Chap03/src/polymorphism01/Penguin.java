package polymorphism01;

public class Penguin extends Animal { // 애니몰을 확장
	public String habitat;	// 속성

	public void showHabitat() { // 자기만의 메소드
		System.out.printf("%s는 %s에 살아\n", name, habitat);
	}

	//오버라이딩 - 재정의: 상위클래스의 메서드와 같은 메서드 이름, 같은 인자 리스트
	public void showName() {
		System.out.println("어머 재정의 내 이름은 알아서 뭐하게요?");
	}

	// 오버로딩 - 중복정의: 같은 메서드 이름, 다른 인자 리스트
	public void showName(String yourName) {
		System.out.printf("%s 안녕 중복정의, 나는 %s라고 해\n", yourName, name);
	}
}