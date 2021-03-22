package reference;

public class CallByReference {
	public static void main(String[] args) {
		Animal ref_a = new Animal();
		Animal ref_b = ref_a; // 주소가 전달
		
		ref_a.age = 10; 
		ref_b.age = 20; // a , b는 같은 객체를 참조한다.
		
		System.out.println(ref_a.age); // 20
		System.out.println(ref_b.age); // 20
	}
}

class Animal {
	public int age;
}

// 메인 스택 프레임안에 a,b 두개가 독립적으로 생긴다. 이 두개는 둘다 모두 힙 영역의 :Animal 객체를 가리키게 된다.
// a ,b 둘 다 같은 주소값이 들어가있다. 
// 결국 call by value나 call by reference나 같은 값을 복사하는 건 똑같다. 단 reference는 주소를 복사한다는 것