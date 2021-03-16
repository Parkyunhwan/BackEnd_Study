public class Start3 {
	public static void main(String[] args) {
		int i = 10;
		int k = 20;

		if(i == 10) {
			int m = k + 5;
			k = m;
		} else {
			int p = k + 10;
			k = p;
		}

		//k = m + p; -> 주석 풀면 m과 p는 선언되어있지 않았다는 오류 메시지 출력될 것
	}
}

// 1. 자바랭, 스타트3 자바 클래스 올라감
// 2. 메인 스택 프레임안에 k,i,args 들어감
// 3. 메인 스택 프레임 안에 if(true) 스택 프레임이 하나 더 생김 (메인 안에 있으므로)
// 4. m은 if 스택 프레임안에 할당됨. 그리고 메인 스택 프레임 안에 있는 k에 m 을 할당
// 5. 9번째 } 을 만나 if 스택 프레임 메모리 해제
// 6. else 는 실행안되므로 쳐다도 보지마라
