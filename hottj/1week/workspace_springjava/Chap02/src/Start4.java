public class Start4 {
	public static void main(String[] args) {
		int k = 5;
		int m;
		m = square(k);
	}

	private static int square(int k) { // 메인의 k와는 call by value. 서로 영향 주지 않는다.
		int result;		
		k = 25;
		result = k;
		return result;
	}
}

// 메인 스택 프레임과, 스퀘어 스택 프레임 두개가 만들어진다. (메인 외부 스퀘어)
// 메인 스택 프레임안에 k, m, args() 공간 생성
// 스퀘어 스택 프레임안에 result, k, 반환값 공간 생성(void가 아니므로)
