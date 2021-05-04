# 8주차 내용 정리

## ✋🏻 IPC란?

IPC ( Inter Process Communication )는 프로세스 사이에서 통신을 가능하게 하는 기술
![image](https://user-images.githubusercontent.com/46014765/116952350-6e0fdc00-acc5-11eb-8823-8bb166cc29fa.png)

Process는 완전히 독립된 실행객체

독립되어 있는 만큼 별도의 설비가 없이는 서로간에 통신이 어렵다는 문제


## ✋🏻 IPC 종류

![image](https://user-images.githubusercontent.com/46014765/116952450-a9aaa600-acc5-11eb-8068-e81709e2926a.png)


#### 1. PIPE

- 익명의 PIPE를 통해서 동일한 PPID를 가진 프로세스들 간에 단방향 통신을 지원
- FIFO 구조
- 생성된 PIPE에 대하여 Write or Read 만 가능
- 부모 자식 프로세스간 통신 할때 사용 

![image](https://user-images.githubusercontent.com/46014765/116952623-11f98780-acc6-11eb-8ccb-65bd4ac30e65.png)


#### 2. Named PIPE

- 이름을 가진 PIPE를 통해서 프로세스들 간에 단방향 통신을 지원
- 서로 다른 프로세스 들이 PIPE의 이름만 알면 통신이 가능
- FIFO구조
- 생성된 PIPE에 대해 Write or Read 만 가능
- 연관이 전혀 없는 프로세스 간에 통신을 할때

![image](https://user-images.githubusercontent.com/46014765/116952716-48370700-acc6-11eb-9a3e-60c6a24e4cb6.png)


#### 3. Message Queue

- 메모리를 사용한 PIPE
- 구조체 기반으로 통신한다
- FIFO구조
- msgtype 에 따라 다른 구조체를 가져올 수 있다
- 프로세스간 다양한 통신을 할 때 사용 

![image](https://user-images.githubusercontent.com/46014765/116952793-816f7700-acc6-11eb-870a-540a8037316f.png)


#### 4. Shared Memory

- 시스템 상의 공유 메모리를 통신한다
- 일정한 크기의 메모리를 프로세스간에 공유하는 구조
- 공유메모리는 커널에서 관리
- 프로세스간 Read,Write 를 모두 필요로 할때 

![image](https://user-images.githubusercontent.com/46014765/116952847-ad8af800-acc6-11eb-9cfe-6ee433128de5.png)


#### 5. Memory Map

- 파일을 프로세스의 메모리에 일정 부분 맵핑 시켜 사용
- 파일로 대용량 데이터를 공유할 떄 사용
- File IO가 느릴때 사용하면 좋다
- 대부분 운영체제에서는 프로세스를 실행할때 실행 파일의 각 세그먼트를 메모리에 사상하기 위해 메모리 맵 파일을 이용

![image](https://user-images.githubusercontent.com/46014765/116952928-e7f49500-acc6-11eb-91df-d4e4bd7512fd.png)



#### 6. Socket

- 네트워크 소켓 통신을 사용한 데이터 공유
- 네트워크 소켓을 이용하여 Client - Server 구조로 데이터 통신
- 원격에서 프로세스간 데이터를 공유할 때 사용

![image](https://user-images.githubusercontent.com/46014765/116952977-0d819e80-acc7-11eb-931b-dab05731107a.png)





## ✋🏻 call by value / reference 정의, 장단점 


#### Call by value

- 값에 의한 호출
- 함수에 매개 변수의 내용물을 전달하여 복사해 사용하는 방식
- 장점 : 복사하여 처리하기 때문에 안전하다. 원래의 값이 보존이 된다.
- 단점 : 복사를 하기 때문에 메모리가 사용량이 늘어난다.

#### Call by reference
- 참조에 의한 호출
- 메모리 공간에서는 함수를 위한 별ㄷ의 임시공간 생성(함수 종료시 사라짐)
- 장점 : 복사하지 않고 직접 참조를 하기에 빠르다.
- 단점 : 직접 참조를 하기에 원래 값이 영향을 받는다.(리스크)



## ✋🏻 왜 자바는 call by value 만 될까?

자바에서 값이 전달 될때는 원시타입은 값이 복사돼서 전달되고, 참조(객체의주소정보) 역시 전달될 때는 참조값 자체가 복사돼서 전달됩니다. 

참조를 직접 전달하는것이 아닌 참조값(value) 자체를 복사해서 전달하는 것

http://mussebio.blogspot.com/2012/05/java-call-by-valuereference.html



## ✋🏻 Array vs LinkedList

Array는 index로 빠르게 값을 찾을 수 있다.

LinkedList는 데이터를 삭제하고 삽입하는데 빠르다

ArrayList는 데이터를 찾는데 빠르지만 데이터의 삽입과 삭제가 느리다.


## ✋🏻 ORM 장단점

#### 장점
- 객체지향적인 코드로 인해 더 직관적이고 로직에 집중할 수 있도록 도와준다
- 재사용 및 유지보수의 편리성이 증가한다
- DBMS에 대한 종속성이 줄어든다

#### 단점
- 완벽한 ORM 으로만 서비스를 구현하기가 어렵다.
- 프로시저가 많은 시스템에선 ORM의 객체 지향적인 장점을 활용하기 어렵다.


#### JDBC

DB에 접근할 수 있도록 JAVA에서 제공하는 API
![image](https://user-images.githubusercontent.com/46014765/116954786-dfeb2400-accb-11eb-8e89-1e634a1374c0.png)



#### JPA

Java Persistence API
자바 ORM 기술에 대한 API 표준 명세서로, 자바에서 제공하는 API
![image](https://user-images.githubusercontent.com/46014765/116954850-06a95a80-accc-11eb-9490-23f72b99cbe9.png)



#### MyBatis
![image](https://user-images.githubusercontent.com/46014765/116954898-1cb71b00-accc-11eb-92c8-d6fb3259f297.png)

- 장점 : SQL에 대한 모든 컨트롤을 하고자 할때 매우 적합
- 단점 : 애플리케이션과 데이터베이스간의 설계에 대한 모든조작을 학자 할때는 적합하지 않다 , 많은 설정을 바꿔야한다


