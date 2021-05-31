## 기수정렬

기수정렬은 O(N)이라는 굉장히 빠른 시간 복잡도를 가진다.

**기수정렬의 정렬 방법**

 0. 0 ~ 9까지 Bucket을 준비한다. (큐 자료구조 사용)

1. 1의 자릿수를 보면서 각각의 버킷에 담아준다. 담은 버킷에서 순차적으로 빼면서 1의 자릿수에 맞게 정렬한다.
2. 1)에 의해서 정렬된 배열에서, 10의 자릿수를 비교해서 버킷에 담고 순차적으로 빼준다.
3. 2)에 의해서 정렬된 배열에서, 100의 자릿수를 비교해서 버킷에 담고 순차적으로 빼준다.
4. 최대 자릿수까지 반복한다.

기수정렬법은 '버킷'으로 추가적인 메모리용량이 필요하며 최대자릿수가 증가하면 그만큼 시간을 잡아먹게된다.

## OSI 7 계층

> 네트워크에서 통신이 일어나는 과정을 7단계로 나눈것을 말함

- 장점
    - 계층을 나눠 통신이 일어나는 과정을 단계별로 한눈에 파악할 수 있다.
    - **문제 발생 시 다른 단계에 영향을 주지 않고 이상이 생긴 단계만 고칠 수 있다.**
        - ex) 피시방 게임 연결 문제
            1. 모든 PC가 문제라면 라우터문제
            2. 한 PC만 문제고 게임자체가 문제라면 7계층
            3. 스위치 문제라면 2계층

            으로 계층별 문제를 판단해 문제가 있는 계층만 고칠 수 있다.

### 1계층 - Physical Layer

> 비트 단위의 전기적 데이터 전송

이 계층은 단지 데이터를 전달할 뿐 "데이터가 무엇인지 에러가 있는지" 신경쓰지 않는다.

ex) 케이블, 리피터, 허브

### 2계층 - DataLink Layer

> 물리계층에서 송수되는 정보의 오류와 흐름을 관리하여 안전한 정보 전달을 도와주는 계층

**'포인트 투 포인트'간 신뢰성있는 전송을 보장하기 위한 계층**

단위 : 프레임

→ 맥 주소를 가지고 통신

**CRC 기반의 '오류제어'와 '흐름제어' (물리계층에서 발생하는 오류를 찾아내어 수정함)**

MAC address는 네트워크 카드가 만들어질 때 할당된다.

### 3계층 - Network Layer

> 데이터를 목적지까지 '안전하고 빠르게' 라우팅해주는 계층

**라우팅, 흐름 제어, 세그멘테이션, 오류제어, 인터네트워킹을 수행한다.**

→ IP 주소 부여, 경로설정

- IP계층
    - IP 패킷의 전달 및 라우팅을 담당하는 계층
- IP프로토콜
    - TCP/IP 기반의 인터넷 망을 통해 데이터그램의 전달을 담당하는 프로토콜
    - Best-Effort → '신뢰성', '흐름제어' 없음 (오직 전달만)
    - 비연결성 데이터그램 방식
    - TCP, UDP, ICMP, IGMP 등이 IP 데이터그램에 실려 전송 됨.

### 4계층 - Transport Layer

> 양 끝단의 사용자들이 신뢰성있는 데이터를 주고 받을 수 있게해주는 계층

이후 상위계층은 더이상 데이터 전달의 유효성을 생각하지 않아도 된다.

기능 → 오류검출, 복구, 흐름제어, 신뢰성

- TCP 프로토콜
    - IP의 비연결, 비신뢰 서비스에 신뢰성있고 연결지향성 서비스를 제공
    - 3 way, 4 way handshaking

    신뢰성 보장, 연결지향적

- UDP 프로토콜
    - 비연결성, 신뢰성 낮음, 순서화되지 않은 데이터그램 (거의 기능없음)
    - 실시간 응용 및 멀티캐스팅(1대다) 가능
    - 헤더가 단순함 (기능이 없어서..)

### 5계층 - Session Layer

> 양 끝단의 '응용 프로세스'가 통신을 관리하기 위한 계층

- 동시송수신방식, 반이중방식, 전이중방식 통신
- TCP/IP 세션을 만들고 없애는 책임을 짐.

### 6계층 - Presentation Layer

> 코드 간 번역을 당담하여 사용자 시스템과 데이터의 형식상 차이의 부담을 응용계층에서 덜어준다.

- MIME 인코딩, 암호화 동작
- EBCDIC인코딩 파일을 ASCII로 인코딩된 파일로 바꿈
- 해당 데이터가 TEXT, GIF, PNG인지 구분하는 역할

### 7계층 - Application Layer

> 응용 프로세스와 관계하여 응용 서비스를 수행함

통신의 최종 목적지로 HTTP, FTP, SMTP, Telnet같은 프로토콜이 있다.

우리가 받은 '패킷'은 해당 프로토콜에 의해 처리된다.

또한, 우리가 사용하는 "크롬"등의 브라우저 "GMAIL"은 이러한 프로토콜을 쉽게 사용하게 해주는 응용프로그램이다.

→ 통신의 양 끝단은 HTTP와 같은 프로토콜이지 크롬 같은 응용프로그램이 아니다.

## 시스템 콜

> 사용자영역의 응용프로그램에서 운영체제에게 커널영역의 기능을 수행해달라고 요청하는 것

사용자 프로세스가 인터럽트를 통해 커널의 기능을 요청함

- 처리 방식
    1. 사용자 프로세스가 시스템 콜을 요청하면 제어가 커널로 넘어옴
    2. 커널은 내부적으로 각각의 고유번호에 해당하는 서비스 루틴을 수행
    3. 서비스루틴을 모두 처리하고 커널모드에서 사용자 모드로 전환

- 목적

    해커가 피해를 입히기 위해 악의적으로 시스템 콜을 사용하는 경우나 초보 사용자가 하드웨어 명령어를 잘 몰라서 아무렇게 함수를 호출했을 경우에 시스템 전체를 망가뜨릴 수도 있기 때문입니다. 따라서 이러한 명령어들은 특별하게 커널 모드에서만 실행할 수 있도록 설계되었고, 만약 유저 모드에서 시스템 콜을 호출할 경우에는 운영체제에서 불법적인 접근이라 여기고 trap을 발생시킵니다.

    [https://fjvbn2003.tistory.com/306](https://fjvbn2003.tistory.com/306)

### 시스템 콜의 유형

- 프로세스 제어
    - end, abort, execute, create process, signal event
- 파일 조작
    - open, close, read, write 등
- 장치 관리
    - 장치 요구, 장치 방출
- 정보 유지
    - time, date
- 통신
    - 통신 연결의 생성, 제거

## 스프링의 큰 특징들

### 스프링 프레임워크가 해결하는 핵심 문제

`의존성 주입`과 `IOC`를 사용하면 결합도를 낮게 유지하며 어플리케이션을 개발할 수 있다.

- 스프링 프레임워크의 가장 중요한 특징은 의존성 주입(Dependency Injection)
- 모든 스프링 모듈들의 핵심에는 의존성 주입과 IOC가 존재
- 다양한 모듈제공을 통한 중복코드 감소 및 결합도 낮춤 효과
- 다른 프레임워크들과의 통합이 훌륭함 ex) Hibernate for ORM, JUnit and Mockito

### Spring MVC가 해결하는 핵심 문제

결합도를 낮출 수 있는 웹 애플리케이션 개발 방법을 제공한다.Dispatcher Servelet, ModelAndView, View Resolver와 같은 개념을 통해 개발을 쉽게 해준다.

### Spring Boot

스프링 기반 애플리케이션 개발 시 많은 환경설정을 해줘야만 한다.

예를 들어 Spring MVC 형태를 사용하려면 Component Scan, Dispatcher Servelet, View Resolver, jar 등을 설정해줘야만 한다.

이런 복잡한 환경 설정을 간단하게 만들어주는 것이 Spring Boot이다.

클래스 패스 상에 사용가능한 프레임워크와 기본 환경설정을 제공한다 -> "Auto Configuration"

ex) Hibernate jar가 클래스 패스에 있다면 Data Source를 자동으로 구성

Spring Boot Starter-<?>는 다양한 종속성들을 미리 패키징해놓기 때문에 개발자가 이것을 사용할 때 각 프레임워크의 호환버전을 걱정하지 않고 바로 사용할 수 있다.

이를 통해 스프링 부트를 사용하면 빠른시간안에 웹을 개발할 수 있다는 장점이 있다.

## 스프링 삼각형

### POJO (Plain Old Java Object)

- EJB처럼 복잡하고 많은 기술을 사용하는 것보다 자바의 단순 오브젝트르 이용해 비즈니스로직을 구현하자!
- 객체지향원리에 충실하면서, 환경과 기술에 종속되지 않고 재활용될 수 있는 방식으로 설계된 오브젝트

장점

- 자동화 테스트, 객체지향 설계 깔끔한 코드

POJO프레임워크

- Spring Framework, Hibernate

### IOC / DI (제어의 역전, 의존성주입)

> 두 개의 오브젝트를 인터페이스로 느슨하게 연결한 후 실제 사용 대상을 DI를 통해 외부에서 지정함.

→ 의존성을 설정 파일에 모두 모아두고 주입함으로써 재컴파일/재배포 없이 프로그램의 실행 결과를 변경할 수 있다.

- 장점
    - 유연한 확장 가능 (OCP의 '확장에는 열려있다')
    - 변경없이 재사용 가능 (OCP의 '수정에는 닫혀있다')

서비스 오브젝트가 사용화는 DAO가 있을 때

그것의 구현을 바꿔가며 사용하는 것

### AOP (Aspect-Oriented Programming)

> 공통 관심 사항을 구현한 코드를 핵심 로직을 구현한 코드 안에 삽입

→ 다수의 모듈에서 공통적으로 나타나는 관심사를 묶어서 만듬

- AOP 핵심 → 인터페이스, 프록시, 런타임

### PSA (Portable Service Abstraction)

> 일관된 방식으로 기술에 접근할 수 있게함.

 → 일관성 있는 추상화 (스프링 패키지 이외의 것들에 대해 POJO화 시키기위해 껍데기를 씌우는 것)

스프링 프레임워크 표준 기법, 다양한 어댑터를 지원해준다.

→ 같은 일을 하는 다수의 기술을 공통의 인터페이스로 제어할 수 있도록 서비스 추상화함. (JDBC — 데이터베이스 종류와 상관없이 제어할 수 있음)

[https://jinpyo900.tistory.com/55](https://jinpyo900.tistory.com/55)

## 스프링 디자인 (mvc, mvc2, mvcc 등)

### Spring MVC

사용자가 보는페이지(View), 데이터처리(Model), 이 2가지를 중간에서 제어하는 컨트롤러(Controller)

- MVC 패턴의 사용 목적

    서로 분리되어 각자의 역할에 집중할 수 있게끔하여 개발을 하고 그렇게 애플리케이션을 만든다면, **유지보수성, 애플리케이션의 확장성, 그리고 유연성이 증가하고, 중복코딩이라는 문제점 또한 사라지게 되기 때문이다.**

### MVC1

MVC1은 WAS(Web Application Server)에서 모든 파일에 클라이언트가 요청한 로직을 처리하는 경우다.**JSP(Java Server Page)에서 View, Controller의 역할을 담당**하며 그 결과를 클라이언트에게 반환한다.

MVC1은 **아키텍처가 간단**하고 JSP에 거의 모든 로직을 집어넣기 때문에 **작은 웹 어플리케이션을 제작할 때는 큰 무리가 없지만 대규모 웹 어플리케이션을 제작하게 될 시 유지보수에 큰 어려움**이 따른다.

### MVC2

MVC2는 이 MVC1방식을 보완한 아키텍처다.MVC 패턴에 맞게 **Model, Controller, View 부분로 모듈화** 됐고 **JSP는 로직 처리가 없이 단순히 Client에게 보여지는 뷰만을 담당**한다.

이 방식은 **각각이 모듈화되어 있어 유지보수가 매우 쉬워지는 큰 장점**이 있다.현재의 **웹 어플리케이션은 거의 MVC2방식을 따른다** 보면 된다.

[https://gmlwjd9405.github.io/2018/12/20/spring-mvc-framework.html](https://gmlwjd9405.github.io/2018/12/20/spring-mvc-framework.html)

### MVP

MVP 패턴은 Model + View + Presenter를 합친 용어

- 장점

    MVP 패턴의 장점은 View와 Model의 의존성이 없다는 것입니다.
    MVP 패턴은 MVC 패턴의 단점이었던 View와 Model의 의존성을 해결하였습니다. (Presenter를 통해서만 데이터를 전달 받기 때문에..)

- 단점 : View와 Presenter 사이의 의존성이 강해짐.

### MVVM

MVVM 패턴은 Model + View + View Model를 합친 용어

- Model : 어플리케이션에서 사용되는 데이터와 그 데이터를 처리하는 부분입니다.
- View : 사용자에서 보여지는 UI 부분입니다.
- View Model : View를 표현하기 위해 만든 View를 위한 Model입니다. View를 나타내 주기 위한 Model이자 View를 나타내기 위한 데이터 처리를 하는 부분입니다.

- 장점

    MVVM 패턴은 View와 Model 사이의 의존성이 없습니다.

    또한 Command 패턴과 Data Binding을 사용하여

    **View와 View Model 사이의 의존성 또한 없앤 디자인패턴입니다.**

    각각의 부분은 독립적이기 때문에 모듈화 하여 개발할 수 있습니다.

- 단점

    MVVM 패턴의 단점은 View Model의 설계가 쉽지 않다는 점입니다.

[https://beomy.tistory.com/43](https://beomy.tistory.com/43)