

# 정규화와 이상현상

## 정규화
개념 : 잘못 설계한 관계형 데이터베이스에 더 작은 속성 집합으로 분해하여 바람직하게 만드는 과정
	즉, 이상현상이 제거된 릴레이션으로 만드는 과정
목적 : -어떤 릴레이션이라도 데이터베이스 내에서 표현 가능하도록 만듬
	-릴레이션에서 바람직하지 않은 삽입,삭제,갱신이상이 발생하지 않도록 함
	-보다 간단한 관계연산에 기초하여 검색 알고리즘을 효과적으로 만듬
	
비정규 -> 제1정규형 -> 제2정규형 ->제3정규형->BCNF ->제4정규형 ->제5정규형

** 제 1정규형
	어떤 릴레이션의 모든 도메인들의 값이 오직 원자값만 가짐

**제2정규형
	어떤 릴레이션이 1NF 를 만족하면서, 릴레이션에 존재하는 부분함수적종속을 제거하여 모든 속성이
	기본키에 완전함수 종속임

- 부분함수 종속 ( 제1정규형 -> 제2정규형)
	기본키가 여러개의 필드로 구성되어 있을때, 그 중 일부 필드에 의해서 또다른 속성이 결정된다면
	이것은 부분 함수 종속성이 존재하는 것
	ex) 기본키가 학번, 과목코드라면  학년과 성적에 포함되버림
	제 1정규형에서 부분적 함수 종속성을 제거하면 제2정규형 테이블이 된다

**제3정규형
	어떤 릴레이션이 2NF만족하면서, 릴레이션을 구성하는 속성 간 이행 함수적 종속이 없음
- 이행 함수 종속(제2정규형 ->제3정규형)
	속성 A,B,C 사이에서 A->B, B->C 이면 A->C인 관계
	*함수 종속관계표현?
	(A->B : B가 A에 종속한다. A 결정자, B 종속자)
  
**보이스/코드 정규형
	어떤 릴레이션이 3NF만족하면서 모든 결정자가 super key 인 경우

**제4정규형
	어떤 릴레이션이 BCNF만족하면서, 릴레이션에서 다치 종속을 제거

- 다치종속?
	두 속성이 1대다 대응이 되는 경우 
	학번과 수강과목 속성이 있으면 한 한색이 여러 과목을 수강할 수 있는 경우, 하나의 학번은 여러개의 수강과목에 대응
	*다치종속관계표현?
	(A->->B : B가 A에 다치 종속한다)

**제5정규형 
	어떤 릴레이션이 4NF를 만족하면서, 후보키를 통하지 않은 조인종속을 제거
	속성 A,B,….Z가 있다면, 릴레이션이 자신의 프로젝션 A,B….Z를 조인한 결과와 똑같은 경우

## 이상현상
정의 : 테이블내의 데이터 중복성에 의해서 방생되는 데이터 불일치 현상
종류 : 삽입이상, 삭제이상, 갱신이상

1. 삽입이상 : 내가 원하는 값만 테이블에 삽입하고 싶은데, 테이블에 필요하지 않은 필드들 때문에 원치않는
	필드값도 삽입해야하는 경우
2. 삭제이상 :  내가 원하는 값만 테이블에 삭제하고 싶은데, 하나의 튜플이 삭제를 원하지 않는 속성값도 갖고 있기
	때문에 같이 지워져서 발생하는 문제
3. 갱신이상 : 어떤 값을 업데이트 했을때 그 속성의 다른 속성값들과의 불일치가 발생하는 현상 






# JVM
https://asfirstalways.tistory.com/158

JDK : Java SE Development Kit, 자바개발키트, JRE+컴파일러, 디버거 등의 개발도구
JRE : Java SE Runtime Environmnet, 자바 구동환경, JVM +시스템 라이브러리
JVM : Java Virtual  Machine, 자바 가상머신, 운영체제 독립적으로 동작하기 위해 필요 
jvm < jre< jdk 

① Garbage collector(GC)Permalink
잠시 후에 공부할 Runtime Data Area 중 Heap영역에 더 이상 사용하지 않고 자리만 차지하고 있는 객체들을 제거하는 역할을 합니다. 
자동으로 실행되기 때문에 언제 정확히 언제 실행되는지 알기 어렵고 사용자가 임의로 GC를 발생시키는 것은 좋은 발상이 아니기에 JVM에 맡기는 것이 좋습니다. 
기본적인 특징은 GC가 수행되는 동안 GC를 실행하는 쓰레드 외 모든 쓰레드가 일시정지 됩니다.

② Class LoaderPermalink
개발의 결과물로 우리는 .java파일을 생성합니다. 
이러한 .java파일은 컴파일러(javac)에 의해 .class파일 즉 JAVA Byte Code(바이트코드) 로 컴파일되고, 
이렇게 컴파일된 바이트코드들을 Class Loader가 운영체제에 의해 메모리를 할당 받은 Runtime Data Area으로 적재하는 역할을 합니다.

③ Execution EnginePermalink
Class Loader에 의해 Runtime Data Area에 적제된 .class파일들을 하나의 명령단위로 읽어서 컴퓨터가 이해할 수 있는 기계어로 번역하고 명령을 실행합니다. 
Interperter방식과 JIT(Just-In-Time) 방식이 존재하고 추후 포스트에 자세히 다루어 보겠습니다.

④ Runtime Data AreaPermalink
JVM메모리 영역으로 OS로부터 별도로 메모리 공간을 할당받고 JAVA 어플리케이션을 실행할 때 사용됩니다.
Method Area, Heap Area, Stack Area, PC register, Native Method Stack 총 5가지로 구분됩니다.


## 자바 프로그램 실행 과정
프로그램이 실행되면 JVM은 OS로부터 이 프로그램이 필요로 하는 메모리를 할당받는다. JVM은 이 메모리를 용도에 맞게 여러 영역으로 나누어 관리한다.
자바 컴파일러(javac)가 자바 소스코드(.java)를 읽어들여 자바 바이트코드(.class)로 변환시킨다.
클래스 로더를 통해 class 파일들을 JVM으로 로딩한다.
로딩된 class 파일들은 Execution engine을 통해 해석된다.
해석된 바이트코드(.class)는 Runtime Data Areas에 배치되고 수행이 이루어지게 된다. 이러한 과정속에서 JVM은 필요에 따라 GC 같은 관리 작업을 수행한다.

- Runtime Data Areas
런타임 데이터 영역은 프로그램을 수행하기 위해 OS에서 할당받는 메모리 영역이다. 
런타임 데이터 영역은 5개의 영역으로 나눌 수 있다. 
이중 PC 레지스터(PC Register), JVM 스택(JVM Stack), 
네이티브 메서드 스택(Native Method Stack)은 스레드마다 하나씩 생성되며 힙(Heap), 메서드 영역(Method Area) 은 모든 스레드가 공유해서 사용한다.


# PCB 와 Context Switching

- 왜 Context Switching이 필요한가?
  Computer가 매번 하나의 Task만 처리할 수 있다면?
  해당 Task가 끝날때까지 다음 Task는 기다릴 수 밖에 없습니다.
  또한 반응속도가 매우 느리고 사용하기 불편합니다.

- 그렇다면 다양한 사람들이 동시에 사용하는 것처럼 하기 위해선?
  Computer multitasking을 통해 빠른 반응속도로 응답할 수 있습니다.
  빠른 속도로 Task를 바꿔 가며 실행하기 때문에 사람의 눈으론 실시간처럼 보이게 되는 장점이 있습니다.
  CPU가 Task를 바꿔 가며 실행하기 위해 Context Switching이 필요하게 되었습니다.
  
- Context Switching이란?
  현재 진행하고 있는 Task(Process, Thread)의 상태를 저장하고 다음 진행할 Task의 상태 값을 읽어 적용하는 과정을 말합니다.
  
- 어떻게 Context Switching은 진행될까요?
    Task의 대부분 정보는 Register에 저장되고 PCB(Process Control Block)로 관리되고 있습니다.
    현재 실행하고 있는 Task의 PCB 정보를 저장하게 됩니다. (Process Stack, Ready Queue)
    다음 실행할 Task의 PCB 정보를 읽어 Register에 적재하고 CPU가 이전에 진행했던 과정을 연속적으로 수행을 할 수 있습니다.

- Context Switching Cost
 - Context Switching이 발생하게 되면 많은 Cost가 소요됩니다.
    Cache 초기화
    Memory Mapping 초기화
    Kernel은 항상 실행되어야 합니다. (메모리의 접근을 위해서..)
- Process vs Thread
    Context Switching 비용은 Process가 Thread보다 많이 듭니다.
    Thread는 Stack 영역을 제외한 모든 메모리를 공유하기 때문에
    Context Switching 발생시 Stack 영역만 변경을 진행하면 됩니다.



# 웹서버와 WAS
- WEB 서버 : HTML, CSS, js, jpg 등 정적인 데이터를 처리하는 웹서버 입니다.
WEB Server로 가장 많이 쓰는 프로그램으로는 Apache재단의 Apache가 있고, Microsoft사의 IIS, nginx등이 있습니다.
웹서버의 아파치나 IIS 와 같은 소프트웨어는 HTML/CGI 나 기타 웹 문서들을 HTTP 규약에 따라 웹 클라이언트와 주고받으며 통신하는 것이 주 역할

- WAS(Web Application Server) 서버: JSP, ASP, PHP 등 사용자의 입력을 받아 서버에서 무언가를 처리하고 그 결과를 보여주는 동적인 데이터를 처리하는 웹서버 입니다.
WAS로 가장 많이 쓰는 프로그램으로는 BEA사의 Web Logic, IBM사의 Web Sphere, T-max사의 Jeus, Tomcat, Redhot사의 JBoss 등이 있습니다.
WAS는 규모가 크고 엔터프라이즈 환경에 필요한 트랜잭션, 보안, 트래픽관리, DB커넥션 풀, 사용자 관리 등등의 다양하고 강력한 기능을 제공하는 S/W 를 의미





