package inheritance03;

public class Driver {
	public static void main(String[] args) {
		Penguin pororo = new Penguin(); // 펭귄 객체를 힙에 올림. 근데 펭귄은 애니몰을 상속하므로, 애니몰 객체도 힙에 올린다. 애니몰은 오브젝트를 상속하므로 오브젝트도 올림.
		// 얘는 :펭귄을 가리킴
		pororo.name = "뽀로로"; // pororo라는 객체 참조 변수.
		pororo.habitat = "남극";

		pororo.showName();
		pororo.showHabitat();

		Animal pingu = new Penguin(); // 펭귄 태어났는데 동물 역할
		// 얘는 :애니몰을 가리킴
		pingu.name = "핑구";
		//pingu.habitat = "EBS"; 애니몰은 habitat이 없다. 주석풀면 오류남.
		((Penguin)pingu).habitat = "EBS"; // 라고하면 쓸 수 있다.

		Penguin pinguSame = ((Penguin)pingu); // 얘는 펭귄을 가리킴

		pingu.showName();
		// pingu.showHabitat();

		// Penguin happyfeet = new Animal();
	}
}

