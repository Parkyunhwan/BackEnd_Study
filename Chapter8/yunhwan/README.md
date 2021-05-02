# IPC

> 프로세스 간 데이터 통신

프로세스는 완전히 독립된 실행객체.

**커널은 프로세서 통신을 위해 다양한 IPC 매커니즘을 제공.**

예) 센서로 읽은 값을 다른 프로세스에 전달

## IPC의 종류

1. 시그널
    - 이벤트 발생 → 시그널 전달 → 시그널 처리 (프로세스에 신호를 보내는 메커니즘)
2. 파이프

    특징

    - 바이트 스트림(형식없는 데이터)
    - 하나의 프로세스는 읽기만 또 다른 하나는 쓰기만 함.
    - 익명 파이프는 같은 부모 프로세스끼리만 통신 가능.
    - Named PIPE는 부모 프로세스와 무관하게 프로세스 간 통신 가능.

    단점

    - 전이중 통신을 위해선 두개의 파이프를 만들어야 한다.
3. 메시지 큐
    - 메모리 공간
    - 메시지 큐에 쓸 데이터에 번호를 붙임
    - 여러개의 프로세스가 동시에 데이터를 다룰 수 있어짐.
4. 공유 메모리
    - 통신이 아닌 메모리 자체를 공유함.
    - 공유메모리로 데이터 자체를 다른 프로세스가 접근 가능하도록 허용
5. 소켓
    - 프로세들 사이의 기본적 통신
    - 서버 단 → bind, listen, accept
    - 클라이언트 단 → connect를 통해 서버에 요청, 연결 수립 후 socket 통신

# Call by value, Call by Reference

- Call by value는 메서드 호출 시에 사용되는 인자의 메모리에 저장되어 있는 값(value)을 복사하여 보냄.
- Call by reference는 메서드 호출 시에 사용되는 인자가, 값이 아닌 주소(Address)를 넘겨줌으로써, 주소를 참조(Reference)하여 데이터를 변경 가능

**자바는 객체도 메모리 주소를 복사해서 넘기므로 모두 Call by value라고 볼 수도 있다.**

→ 결론적으로, 자바는 Call by value 방식으로 인자값을 받는다고 볼 수 있다.

# Primitive Type, Reference Type

## primitive type과 reference type 차이

프리미티브 타입은 스택에 값을 저장하고 있고, 레퍼런스 타입은 객체가 저장되어 있는 주소가 저장되어 있다.

기본 자료형 -> byte, short, int, long (런타임 스택 영역)

객체 -> String, Class, Interface, Array 등 (가비지 컬렉션 힙 영역)

레퍼런스 타입은 실제 객체의 주소를 가리키기 때문에 `복사` 시에 항상 유의해야 한다.

### Primitive Type(기본형)

- 비객체 타입으로, NULL을 가질 수 없는 형태
- 실제 값을 저장하는 공간으로 스택(Stack) 메모리에 저장된다.

### Reference Type(참조형)

- Object를 상속받으며 기본형이 아닌 경우 객체 타입.
- 값이 저장되어 있는 곳의 주소값을 저장하는 공간으로 힙(Heap) 메모리에 저장된다.

### String Class(특이)

String 또한 참조형(객체)에 속하지만 기본형처럼 사용한다. 또한 immutable객체이다.

**String의 값을 바꿔주는 메서드는 사실상 새로운 String 객체를 만들어주는 것.**

### Wrapper Class (객체)

프리미티브 타입으로 표현할 수 있는 데이터를 **객체로 만들어야하는 경우**에 사용하기 위해 만든 기능

두 타입간 변환을 `Boxing` 과 `Unboxing`이라고 한다.

***Wrapper클래스는 null값을 처리할 수 있기 때문에 SQL과 연동 시에 유용하다.***

### Interface Type

- 인터페이스를 만드는 것은 새로운 "참조 자료형"을 만드는 것과 같다.
- 인터페이스는 자료형으로 자신을 구현한 객체의 주소를 가질 수 있다.
- 인터페이스를 자료형으로 사용하는 객체는 인터페이스에 정의된 메서드만 사용가능하다.

# Java Collection 객체

> Collection 객체란 여러 원소들을 담을 수 있는 자료구조

**데이터를 저장하는 "자료구조"를  한 곳에 모아 편리하게 관리하기 위해 사용..! (List, Set, Map)
→ 오직 참조형만 되고 기본자료형은 안된다.**

그럼 기본자료형은 못쓰나..? ⇒ Wrapper클래스를 이용해서 참조형으로 변환하면 사용할 수 있다.
→ 근데 컴파일러가 또 자동으로 바꿔줘서 그냥 기본형으로 써도 오류 안나고 된다고 함...

### **자바의 자료구조형**

- 배열이 가장 기본. DTO도 하나의 자료구조.
- List, Set, Queue, Map

**배열과 달리 정적 메모리 할당이 아닌 동적 메모리 할당을 한다.**

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d9c7f503-a789-433e-a969-e90dafeb017c/_2021-05-02__11.35.34.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d9c7f503-a789-433e-a969-e90dafeb017c/_2021-05-02__11.35.34.png)

[https://joooootopia.tistory.com/13](https://joooootopia.tistory.com/13)

컬렉션 인터페이스는 ***(리스트, 큐, 세트)***로 나눠진다. (Map은 따로..)

이 인터페이스를 이용해 여러가지 구현체들이 구현을 한다.

- List 인터페이스
    - Collection의 다른 인터페이스와 다르게 **배열처럼 "순서"가 존재한다.**
    - ArrayList, LinkiedList, Vector, Stack (순서있는 Collection)
    - 인덱스로 객체를 검색, 삭제 가능.
    - ArrayList(Thread safe하지 않음), LinkedList(Thread safe함)
        - Thread safe(여러 쓰레드가 접근하여 값을 변경할 때 문제가 생기지 않는 것)
        - 삽입, 삭제는 LinkedList, 조회는 ArrayList

- Map 인터페이스
    - 키, 값을 사용해서 저장 (키와 값은 모두 객체이다.)
    - 데이터 순서는 신경쓰지 않는다.
    - HashMap, TreeMap(저장과 동시에 키값에 대해 정렬)을 사용한다.

# JDBC vs ORM vs SQLMapper

[https://www.youtube.com/watch?v=mezbxKGu68Y](https://www.youtube.com/watch?v=mezbxKGu68Y)

**Persistance 영속성**

데이터를 생성한 프로그램의 실행이 종료되더라도 사라지지 않는 데이터 특성. (램 to 디스크)

**기술이 왜 나왔고 왜 쓰는지 아는 것이 중요하다. (역사와 배경을 통한 기술의 이해)**

### **JDBC** - JDBC API

> 자바에서 **데이터베이스에 접속할 수 있도록 하는 자바 API**
"개방 폐쇄 원칙"이 적용된 모습 어플리케이션은 변화에 영향을 받지 않고 Database확장에는 열려있다.

### **SQLMAPPER** - MaBatis JDBC

> 객체와 SQL문을 매핑하여 데이터를 객체화하는 기술

<SQL문의 질의 결과 + 객체> 1세트로 묶어서 사용

SQLMAPPER →설정 등을 추상화해서 사용.

- MyBatis : SQL이 자바 코드에서 XML로 넘어가게됨. (XML로 DB로직을 분리)
→ SQL에 의존적인 개발...이 단점.

JDBC API 의 등장 → JDBC DriverManager로 구현 → Driver만 바꿔주면됨.

### **ORM** - JPA, HIBERNATE, Spring data JDBC/JPA

> DB의 테이블과 객체를 매핑하여 테이블을 객체지향적으로 사용하는 기술

객체간의 관계를 통해 SQL을 생성해줌.

**엔티티 매니저**

- persist **(객체를 엔티티 매니저의 관리 대상으로 추가)**
- flush (DB로 저장이됨. 영속성이 생김)

    영속성 컨텍스트

    - LAZY LOADING
        - 지금 필요한 것만 가져오자.
    - DIRTY CHECKING
        - 데이터의 변화가 있는 것 체킹
    - CACHING

스프링 데이터 JPA (한번 더 추상화한 것)

- 엔티티 매니저를 직접 부르지 않고 Repository를 이용해서 사용
