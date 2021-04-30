# 관계형 데이터베이스

* 관계형 데이터베이스란?
  
    - 관계형 데이터베이스는 현재 가장 많이 사용되고 있는 데이터베이스의 한 종류입니다.

    - 관계형 데이터베이스란 테이블(table)로 이루어져 있으며, 이 테이블은 키(key)와 값(value)의 관계를 나타냅니다.

    - 이처럼 데이터의 종속성을 관계(relationship)로 표현하는 것이 관계형 데이터베이스의 특징입니다.

* 장점
    
    - 데이터의 성능이 일반적으로 좋아 정렬, 탐색, 분류가 빠름
    - 신뢰성이 높아 데이터의 무결성을 보장
    - 정규화에 따른 갱신 비용을 최소화

* 단점

    - 기존에 작성된 스키마를 수정하기 어려움
    - 데이터베이스의 부하를 분석하기 어려움
    - 빅데이터를 처리하는데 매우 비효율적임

# 데이터베이스 제어 기법

## 병행 제어

### 병행 제어의 개념

- 병행 제어란 다중 프로그램의 이점을 활용하여 동시에 여러개의 트랜잭션을 병행 수행할 때 실행되는 트랜잭션들이 데이터베이스의 일관성을 파괴하지 않도록 트랜잭션 간의 상호 작용을 제어하는 기술이다.

- 병행성이란 여러 개의 트랜잭션들이 동시에 인터리빙(Interleaving)하게 실행되는 것을 의미한다.

### 병행 제어의 목적

- 데이터베이스의 공류를 최대화한다.

- 시스템의 활용도를 최대화한다.

- 사용자에 대한 응답 시간을 최소화한다.

- 단위 시간당 트랜잭션 처리 건수를 최대화한다.

- 데이터베이스의 일관성을 유지한다.

### 병행 제어의 필요성

- 갱신분실

- (Lost Update) 

- 2개 이상의 트랜잭션이 같은 데이터를 공유하여 갱신할 때 갱신 결과의 일부가 없어지는 현상 

- 모순성

- (Inconsistency) 

- 복수의 사용자가 동시에 같은 데이터를 갱신할 때 데이터베이스내의 데이터들이 상호 일치하지 않아 모순된 결과가 발생하는 현상 

- 연쇄 복쉬

- (Cascading Rollback) 

- 병행수행되던 트랜잭션들 중 어느 하나에 문제가 생겨 Rollback되는 경우 다른 트랜잭션들도 함께 Rollback되는 현상 

### 잠금

- 잠금이란 데이터베이스 관리에서 하나의 트랜잭션에 사용되는 데이터를 다른 트랜잭션이 접근하지 못하게 하는 것

- 트랜잭션들은 어떤 데이터를 접근하기 전에 잠금을 요청하여 잠금을 허락받아야 한다.

- 데이터를 갱신할 때는 반드시 잠금(Lock) -> 실행(Execute) -> 해제(Unlock)의 규칙을 따라야 한다.

- 교착상태(Dead Lock) : 어떤 한 트랜잭션이 사용하기 위해 잠가 놓은 자원을 사용하기 위해 기다리므로 모든 트랜잭션들이 실행을 전혀 진전시키지 못하고 무한정 기다리고 있는 상태


### 병행 제어 기법의 종류

(1) 2-단계 잠금 규약(Two-Phase Lock Protocol) 기법

- 트랜잭션 스케쥴의 직렬성을 보장하는 대표적인 잠금 기법이다.

- 스케줄의 직렬성을 보장한다는 장점은 있지만 교착 상태를 예방할 수는 없다는 단점이 있다.

(2) 타임 스탬프 순서(Time Stamp Ordering) 기법

- 타임 스탬프란 시스템이 각 트랜잭션을 실행할 때 부여하는 값이다. 예를 들어, 트랜잭션이 시스템으로 들어오면 그 때의 시스템 시간 값이 그 트랜잭션의 타임 스탬프가 된다.

- 트랜잭션들을 인터리빙하게 실행한 결과가 시간 스템프 순서대로 트랜잭션들을 실행하는 직렬 스케줄의 실행 결과와 항상 동일하다는 것을 보장하는 기법이다.

- 교착 상태가 발생하지 않는다.


# 프로세스 vs 쓰레드

### 프로세스(Process)

프로세스는 실행 중인 프로그램으로 디스크로부터 메모리에 적재되어 CPU 의 할당을 받을 수 있는 것을 말한다. 운영체제로부터 주소 공간, 파일, 메모리 등을 할당받으며 이것들을 총칭하여 프로세스라고 한다. 구체적으로 살펴보면 프로세스는 함수의 매개변수, 복귀 주소와 로컬 변수와 같은 임시 자료를 갖는 프로세스 스택과 전역 변수들을 수록하는 데이터 섹션을 포함한다. 또한 프로세스는 프로세스 실행 중에 동적으로 할당되는 메모리인 힙을 포함한다.

#### 프로세스 제어 블록(Process Control Block, PCB)

PCB 는 특정 **프로세스에 대한 중요한 정보를 저장** 하고 있는 운영체제의 자료구조이다. 운영체제는 프로세스를 관리하기 위해 **프로세스의 생성과 동시에 고유한 PCB 를 생성** 한다. 프로세스는 CPU 를 할당받아 작업을 처리하다가도 프로세스 전환이 발생하면 진행하던 작업을 저장하고 CPU 를 반환해야 하는데, 이때 작업의 진행 상황을 모두 PCB 에 저장하게 된다. 그리고 다시 CPU 를 할당받게 되면 PCB 에 저장되어있던 내용을 불러와 이전에 종료됐던 시점부터 다시 작업을 수행한다.

_PCB 에 저장되는 정보_

* 프로세스 식별자(Process ID, PID) : 프로세스 식별번호
* 프로세스 상태 : new, ready, running, waiting, terminated 등의 상태를 저장
* 프로그램 카운터 : 프로세스가 다음에 실행할 명령어의 주소
* CPU 레지스터
* CPU 스케쥴링 정보 : 프로세스의 우선순위, 스케줄 큐에 대한 포인터 등
* 메모리 관리 정보 : 페이지 테이블 또는 세그먼트 테이블 등과 같은 정보를 포함
* 입출력 상태 정보 : 프로세스에 할당된 입출력 장치들과 열린 파일 목록
* 어카운팅 정보 : 사용된 CPU 시간, 시간제한, 계정번호 등

</br>

### 스레드(Thread)

스레드는 프로세스의 실행 단위라고 할 수 있다. 한 프로세스 내에서 동작되는 여러 실행 흐름으로 프로세스 내의 주소 공간이나 자원을 공유할 수 있다.
스레드는 스레드 ID, 프로그램 카운터, 레지스터 집합, 그리고 스택으로 구성된다. 같은 프로세스에 속한 다른 스레드와 코드, 데이터 섹션, 그리고 열린 파일이나 신호와 같은 운영체제 자원들을 공유한다.
하나의 프로세스를 다수의 실행 단위로 구분하여 자원을 공유하고 자원의 생성과 관리의 중복성을 최소화하여 수행 능력을 향상시키는 것을 멀티스레딩이라고 한다. 이 경우 각각의 스레드는 독립적인 작업을 수행해야 하기 때문에 각자의 스택과 PC 레지스터 값을 갖고 있다.

#### 스택을 스레드마다 독립적으로 할당하는 이유

스택은 함수 호출 시 전달되는 인자, 되돌아갈 주소값 및 함수 내에서 선언하는 변수 등을 저장하기 위해 사용되는 메모리 공간이므로 스택 메모리 공간이 독립적이라는 것은 독립적인 함수 호출이 가능하다는 것이고 이는 독립적인 실행 흐름이 추가되는 것이다. 따라서 스레드의 정의에 따라 독립적인 실행 흐름을 추가하기 위한 최소 조건으로 독립된 스택을 할당한다.

#### PC Register 를 스레드마다 독립적으로 할당하는 이유

PC 값은 스레드가 명령어의 어디까지 수행하였는지를 나타나게 된다. 스레드는 CPU 를 할당받았다가 스케줄러에 의해 다시 선점당한다. 그렇기 때문에 명령어가 연속적으로 수행되지 못하고 어느 부분까지 수행했는지 기억할 필요가 있다. 따라서 PC 레지스터를 독립적으로 할당한다.

# 쿠키와 세션

HTTP는 비상태성(Stateless) 프로토콜로 상태 정보를 유지하지 않는다. 연결을 유지하지 않기 때문에 리소스 낭비가 줄어드는 것은 큰 장점이지만 통신할 때마다 매번 연결 설정을 해야 하며, 이전 요청과 현재 요청이 같은 사용자의 요청인지 알 수 없다는 단점이 존재한다.

쿠키와 세션을 통해서 HTTP의 Stateless한 문제점을 해결할 수 있다.



[저장 위치]

- 쿠키 : 클라인어트의 웹 브라우저가 지정하는 메모리 or 하드 디스크
- 세션 : 서버의 메모리



[만료 시점]

- 쿠키 : 저장할 때, expires 속성을 정의하여 무효화시키면 삭제될 날짜를 지정할 수 있다.
- 세션 : 클라이언트가 로그아웃하거나 설정 시간 동안 반응이 없으면 무효화되기 때문에 정확한 시점을 알 수 없다.



[리소스]

- 쿠키 : 클라이언트에 저장되고 클라이언트의 메모리를 사용하기 때문에 서버 자원을 사용하지 않는다.
- 세션 : 서버에 저장되고, 서버 메모리로 로딩되기 때문에 세션이 생길 때마다 리소스를 차지한다.



[용량 제한]

- 쿠키 : 클라이언트도 모르게 접속되는 사이트에 의하여 설정될 수 있기 때문에 쿠키로 인해 문제가 발생하는 걸 막고자 한 도메인당 20개, 하나의 쿠키당 4KB로 제한해 두었다.
- 세션 : 클라이언트가 접속하면 서버에 의해 생성되므로 개수나 용량 제한이 없다.



[보안]

- 쿠키 : 클라이언트에 저장하기 때문에 보안에 취약하다.
- 세션 : 서버에 저장하기 때문에 쿠키에 비해서는 보안에 우수하다.