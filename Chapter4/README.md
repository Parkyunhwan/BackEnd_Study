# 4주차 질문 정리

### ✋🏻 관계형 데이터베이스란?

- 키와 값을 관계로 묶어 테이블 형태로 저장하는 것

- 데이터 항목은 각 행에 저장되고 속성은 열에 표현된다.

- 관계형 데이터베스에서 "관계"란 각 테이블의 행과 행이 연결되는 관계를 맺을 수 있기 때문이다.

### ✋🏻 관계형 데이터베이스의 장점은 무엇이 있나요?

정규화를 통해 중복을 줄일 수 있다.

### ✋🏻 동시성 제어를 사용하는 이유는 무엇인가요?

다중 사용자 환경을 지원하는 DB 시스템에서 여러 트랜잭션이 동시에 데이터베이스의 일관성을 파괴하지 않고 성공적으로 실행될 수 있도록 트랜잭션 간의 상호작용을 제어한다.

### ✋🏻  동시성 제어에는 무슨 방법이 있나요?

- 잠금(Locking)
    - 확장 - 차단 - 수축
        - 트랜잭션 lock 획득 → 데이터 연산 수행 → 트랜잭션 lock 반납
        - 직렬성을 보장하지만 교착상태를 예방할 수 없다.

- 타임 스탬프 방식
    - 트랜잭션 간의 처리 순서를 미리 선택하는 기법
    - 교착 상태가 발생하지 않는다.

### ✋🏻   트랜잭션의 정의와 사용하는 이유는 무엇인가요?

데이터베이스 상태를 변화시키기 위해서 수행하는 작업의 단위

ACID를 통해서 트랜잭션이 안전하게 수행되어 데이터베이스에 이상이 생기지 않도록 한다.

- 원자성(Atomicity) : 트랜잭션이 DB에 모두 반영되거나, 혹은 전혀 반영되지 않아야 한다.
- 일관성(Consistency) : 트랜잭션의 작업 처리 결과는 항상 일관성이 있어야 한다.
- 독립성(Isolation) : 둘 이상의 트랜잭션이 동시에 병행 실행되고 있을 때, 어떤 트랜잭션도 다른 트랜잭션 연산에 끼어들 수 없다.
- 영속성(Durability) : 트랜잭션이 성공적으로 완료 되었으면 결과는 영구적으로 반영되어야 한다.


### ✋🏻   DDL, DML, DCL의 정의에 대해 말해주세요

- DDL : 데이터, 제약 조건 생성. 데이터 전체 구조 결정 ex) create, alter, drop, truncate
- DML : 데이터베이스의 레코드를 조회, 수정, 삭제 ex) select, insert, update, delete
- DCL : 데이터베이스에 접근하거나 객체에 권한을 주는 등 ex) grant, revoke, commit, rollback

### ✋🏻   프로세스와 쓰레드의 차이는 무엇이 있나요?

### 프로세스란?

- **메모리에 올라와서 실행되고 있는 프로그램의 인스턴스**
- 운영체제로 부터 **시스템 자원을 할당받는 작업의 단위**
    - 할당받는 자원 : CPU 타임, [Code, Data, Stack, Heap]으로 구성된 메모리 영역
- 기본적으로 프로세스당 최소 1개의 쓰레드를 가짐

각 프로세스는 서로 독립적인 주소 공간에서 실행되므로 다른 프로세스의 변수 또는 자료구조에 접근할 수 없다. 한 프로세스가 다른 프로세스에 접근하기 위해선 IPC(Inter-Process-Communication)을 사용해야만 한다.

### 쓰레드란?

- 프로세스 내에서 실행되는 **여러 흐름의 단위**
- 프로세스가 할당받은 자원을 이용하는 실행의 단위

- 특징
    - 쓰레드는 프로세스 내의 Code, Data, Heap영역은 공유하고 Stack영역만 따로 할당받아 사용한다.
    - 쓰레드는 프로세스 내에서 여러 흐름이 실행되는 것이므로 프로세스 내 자원을 서로 공유하며 실행할 수 있다.
    - 각각의 쓰레드는 별도의 레지스터와 스택을 가진다.

### ✋🏻   힙과 스택의 차이는 무엇인가요?

- 힙 : 사용자의 동적 할당. 런타임에 크기 결정

- 스택 : 지역 변수, 매개 변수. 컴파일 타임에 크기 결정

스택을 스레드마다 독립적으로 할당하여 독립적인 실행의 흐름을 가질 수 있다. 

### ✋🏻   PCB란?

- PCB 는 특정 프로세스에 대한 중요한 정보를 저장 하고 있는 운영체제의 자료구조이다. 
- 프로세스 전환이 발생하면 진행하던 작업을 저장하고 CPU 를 반환해야 하는데, 이때 작업의 진행 상황을 모두 PCB 에 저장하게 된다. 그리고 다시 CPU 를 할당받게 되면 PCB 에 저장되어있던 내용을 불러와 이전에 종료됐던 시점부터 다시 작업을 수행한다.

### ✋🏻   자바에서 프로세스가 존재할까요?

- 존재하지 않는다

  - 자바에는 프로세스가 존재하지 않고 스레드만 존재하며, 자바 스레드는 JVM에 의해 스케줄되는 실행 단위 코드 블록이다.
  - 스레드 개념만 존재하며 JVM이 멀티스래딩만 지원
  - JVM이 운영체제 역할을 한다.
  - 즉 개발자는 자바 스레드로 작동할 스레드 코드를 작성하고 스레드 코드가 생명을 가지고 실행을 하도록 JVM에 요청


### ✋🏻   잠금 기법의 단점과 그에 대한 해결책은 무엇이 있을까요?

- 단점 : 하나의 프로세스가 해당 자원에 대한 처리가 끝날 때까지 다른 프로세스가 기다려야 하며 데드락이 발생할 수도 있다.

- 해결책 : 공유되는 자원을 최대한 줄인다 ex) 전역변수 최소화

### ✋🏻   쿠키와 세션에 대해 설명해주세요

세션은 서버의 자원을 사용하며 쿠키는 서버의 자원을 사용하지 않는다.
보안은 세션이 뛰어나고 속도는 쿠기가 빠르다.
쿠키는 브라우저 종료와 상관없이 유효기간 까지 유지되지만 세션은 브라우저 종료 시 삭제된다.

### ✋🏻   쿠키 대신 세션을 사용할 때의 단점은 무엇일까요?

세션을 많이 사용하면 보안성이 좋아지지만 서버의 메모리를 많이 사용해 서버의 성능이 하락할 수 있으므로 쿠키와 세션을 적절하게 사용해야 한다.

### ✋🏻   쿠키의 종류에 대해 설명해주세요

- Session Cookie : 보통 만료시간(Expire date) 설정하고 메모리에만 저장되며 브라우저 종료시 쿠키를 삭제.
- Persistent Cookie	: 장기간 유지되는 쿠키(예를 들어 Max-Age 1년), 파일로 저장되어 브라우저 종료와 관계없이 사용.
- Secure Cookie	: HTTPS에서만 사용, 쿠키 정보가 암호화 되어 전송.
- Third-Party Cookie : 방문한 도메인과 다른 도메인의 쿠키 보통 광고 베너 등을 관리할 때 유입 경로를 추적하기 위해 사용.

쿠키는 브라우저에 저장되므로 보안성이 상대적으로 약하다.
이를 위해서 중요한 정보는 secure cookie를 사용
