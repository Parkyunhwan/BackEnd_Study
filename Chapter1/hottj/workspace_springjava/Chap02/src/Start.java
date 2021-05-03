public class Start {
	public static void main(String[] args) {
		System.out.println("Hello OOP!!!");
	}
}

// 1. java lang 패키지와 Start, main(args:String[]) 이 먼저 메모리에 올라온다.
// 2. main() 스택 프레임을 스택 영역에 올린다.
// 3. main함수가 가지고 있는 인자 args를 메인 스택 프레임안에 변수 공간을 만든다.
// 4. 화면에 Hello OOP!!!가 출력. 메모리 상에는 아무 변화가 없다. 데이터 저장 영역이므로 코드 실행 영역과 별개다.
// 5. 4번째 라인인 } 를 만나면 main() 스택 프레임이 메모리에서 사라진다.
// 6. 종료

// 메소드 블록, if, for 블록이 생길 때마다 프레임이 생긴다고 보면 된다. 클래스 선언 블록 제외하고.
