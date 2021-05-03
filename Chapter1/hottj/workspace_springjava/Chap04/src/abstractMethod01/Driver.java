package abstractMethod01;

public class Driver {
	public static void main(String[] args) {
		동물[] 동물들 = new 동물[5];

		동물들[0] = new 쥐();
		동물들[1] = new 고양이();
		동물들[2] = new 강아지();
		동물들[3] = new 송아지();
		동물들[4] = new 병아리();

		for (int i = 0; i < 동물들.length; i++) {
			동물들[i].울어보세요();
		}

		동물 animal_1 = new 동물(); // 이건 좀 아님. 상속을 하고싶은데 이걸 막기위해 추상 클래스 도입
		animal_1.울어보세요();
	}
}