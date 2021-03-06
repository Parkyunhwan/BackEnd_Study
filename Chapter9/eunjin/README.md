
# [Java] final | [Java] non-static 멤버와 static 멤버 차이

## 📌 **final 키워드**

간단한 내용이지만, final 키워드가 클래스, 메소드, 변수 앞에 붙었을 때 각각의 의미에 대해서 정확히 정리하려 한다.

- final class
  - 다른 클래스가 상속받지 못한다.
- final method
  - 자식 클래스에서 상위 클래스의 final method를 오버라이드 하지 못한다.
- final variable
  - 변하지 않는 상수 값이 되어 새롭게 값을 할당할 수 없는 변수가 된다.

## 📌 non-static 멤버와 static 멤버의 차이

### non-static 멤버

- 공간적 특성 : 해당 멤버는 객체마다 별도로 존재한다.
  - 인스턴스 멤버라고 부른다.
- 시간적 특성 : 객체 생성 시에 멤버가 생성된다.
  - 객체가 생성될 때, 멤버가 생성되므로 객체 생성 후에 멤버 사용이 가능.
  - 객체가 사라지면 해당 멤버도 사라진다.
- 공유의 특성 : 공유되지 않는다.
  - 멤버는 객체 내에 각각 독립된 공간을 유지하므로 공유되지 않는다.

### static 멤버

- 공간적 특성 : 해당 멤버는 클래스 당 하나만 생성된다.
  - 해당 멤버는 객체 내부가 아닌 별도의 공간에 생성된다.
  - 클래스 멤버라고 부른다.
- 시간적 특성 : 클래스 로딩 시에 멤버가 생성된다.
  - 객체가 생성되기 전에 이미 생성되므로 객체를 생성하지 않고도 사용 가능.
  - 객체가 사라져도 해당 멤버가 사라지지 않는다.
  - 해당 멤버는 프로그램이 종료될 때, 사라진다.
- 공유의 특성 : 동일한 클래스의 모든 객체들에 의해 공유된다. (하나의 클래스로부터 생성된 여러 객체가 공유한다.)






## 동기

동기 방식은 서버에서 요청을 보냈을 때 응답이 돌아와야 다음 동작을 수행할 수 있다. 

즉 A작업이 모두 진행 될때까지 B작업은 대기해야한다.

설계가 매우 간단하고 직관적,
결과가 주어질때까지 아무것도 못하고 대기해야한다는 단점


## 비동기 
비동기 방식은 반대로 요청을 보냈을 때 응답 상태와 상관없이 다음 동작을 수행 할 수 있다.

즉 A작업이 시작하면 동시에 B작업이 실행된다. A작업은 결과값이 나오는대로 출력된다.

동기보다 복잡

결과가 주어지는데 시간이 걸리더라도 그 시간 동안 다른 작업을 할 수 있으므로 자원을 효율적으로 사용 



### 블록
함수A를 호출했을 때, 함수A의 수행이 모두 끝날 때 까지 기다린다(블록). 함수A의 수행이 모두 끝나고 리턴되면, 함수A를 호출한 부분의 다음 부분부터 이어서 실행한다.

### 논블록
함수A를 호출했을 때, 함수A의 실행을 요청하고 바로 리턴된다(논블록).


https://deveric.tistory.com/99



## 락
* 왜 락(lock)이 필요할까요?

먼저 들어가기에 앞서서 공유 자원이란 무엇인지 알아보도록 하겠습니다.

- 지역 변수는 공유 자원일 수 없습니다. 쓰레드 사이에서 공유될 수 없기 때문입니다.
- 전역 변수는 쓰레드 사이 공유되므로 공유 자원입니다.
- 동적인 객체는 쓰레드 사이 공유되므로 공유 자원입니다.
- 프로세스들도 메모리를 공유할 수 있습니다.

=> 동기화(synchronization)를 하여 공유 자원에 대해서 관리를 할 필요가 있습니다


https://medium.com/pocs/%EB%8F%99%EC%8B%9C%EC%84%B1-%EC%A0%9C%EC%96%B4-%EA%B8%B0%EB%B2%95-%EC%9E%A0%EA%B8%88-locking-%EA%B8%B0%EB%B2%95-319bd0e6a68a

