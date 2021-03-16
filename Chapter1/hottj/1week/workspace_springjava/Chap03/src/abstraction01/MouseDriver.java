package abstraction01;

public class MouseDriver {
	public static void main(String[] args) {
		Mouse mickey = new Mouse(); // mickey 는 객체참조변수

		mickey.name = "미키"; // . 은 참조연산자
		mickey.age = 85;
		mickey.countOfTail = 1;

		mickey.sing();

		mickey = null;

		Mouse jerry = new Mouse();

		jerry.name = "제리";
		jerry.age = 73;
		jerry.countOfTail = 1;

		jerry.sing();
	}
}

// 자바는 숫자인경우 0 , 참조인 경우 null 로 자동초기화
// :Mouse = Mouse 객체란 뜻 UML표기법

// 스태틱 영역 : 자바랭, 마우스드라이버,main / 마우스,name,age,countOfTail,sing() 올라감
// 스택 영역 : 메인 스택 프레임 생성, mickey라는 참조변수,args 생성. 참조변수는 주소값을 가지고 있음.
// 힙 영역 : 5라인이 실행되면 :Mouse() 객체가 생성. name : null, age=0, countOftail=0, sing() 올라감. mickey는 이를 참조함. mickey의 주소는 여기를 가리킴.
// mickey. 찍는 순간 얘가 가지고 있는 정보를 찾아 객체를 찾아감. mickey.name = "미키" 를 하면 힙영역에 있는 :Mouse객체의 name에 '미키'가 들어감
// 13째 라인가면 mickey에 널값이므로 이제 참조가 끊김. 주소값이 사라져서 참조를 못함. 그럼 힙영역에 있던 :Mouse는 어떻게 되는가?
// 아무도 참조하지 않으면 가비지 컬렉션에 의해서 자동으로 해제됨. 자동으로 되는건 아니고 메모리가 어느정도 차면 알아서 참조하지 않는 객체들을 정리해준다.
// 가비지 컬렉션은 힙에 있는 객체들만 정리한다. 
// 스택 영역은 다 지역변수이므로 메소드가 끝날때 자동으로 해제됨.
// 스태틱 영역은 한번 올라가면 자바 가상 머신이 끝날 때 스레드가 종료될 때 해제된다.
// 15번째 실행되면 힙 영역에 새로운 :Mouse 생성. 

// 모든 객체가 같은 값을 갖고 있다면, 얘는 클래스의 속성으로 만들어줄 수 있다.