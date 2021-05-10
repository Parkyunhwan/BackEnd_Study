# 기수 정렬

#### Comparison Sort

---

> N개 원소의 배열이 있을 때, 이를 모두 정렬하는 가짓수는 N!임
>
> 따라서, Comparison Sort를 통해 생기는 <u>트리의 말단 노드</u>가 N! 이상의 노드 갯수를 갖기 위해서는, 2^h >= N! 를 만족하는 h를 가져야 하고, 이 식을 h > O(nlgn)을 가져야 한다. (h는 트리의 높이,,, 즉 Comparison sort의 시간 복잡도임)

이런 O(nlgn)을 줄일 수 있는 방법은 Comparison을 하지 않는 것



#### Radix sort

----

데이터를 구성하는 기본 요소 (Radix) 를 이용하여 정렬을 진행하는 방식

> 입력 데이터의 최대값에 따라서 Counting Sort의 비효율성을 개선하기 위해서, Radix Sort를 사용할 수 있음.
>
> 자릿수의 값 별로 (예) 둘째 자리, 첫째 자리) 정렬을 하므로, 나올 수 있는 값의 최대 사이즈는 9임 (범위 : 0 ~ 9)

* 시간 복잡도 : O(d * (n + b))  

  -> d는 정렬할 숫자의 자릿수, b는 10 (k와 같으나 10으로 고정되어 있다.)

  ( Counting Sort의 경우 : O(n + k) 로 배열의 최댓값 k에 영향을 받음 )

* 장점 : 문자열, 정수 정렬 가능

* 단점 : 자릿수가 없는 것은 정렬할 수 없음. (부동 소숫점)

  중간 결과를 저장할 bucket 공간이 필요함.

#### 소스 코드

```c
void countSort(int arr[], int n, int exp) {
	int buffer[n];
    int i, count[10] = {0};
    
    // exp의 자릿수에 해당하는 count 증가
    for (i = 0; i < n; i++){
        count[(arr[i] / exp) % 10]++;
    }
    // 누적합 구하기
    for (i = 1; i < 10; i++) {
        count[i] += count[i - 1];
    }
    // 일반적인 Counting sort 과정
    for (i = n - 1; i >= 0; i--) {
        buffer[count[(arr[i]/exp) % 10] - 1] = arr[i];
        count[(arr[i] / exp) % 10]--;
    }
    for (i = 0; i < n; i++){
        arr[i] = buffer[i];
    }
}

void radixsort(int arr[], int n) {
     // 최댓값 자리만큼 돌기
    int m = getMax(arr, n);
    
    // 최댓값을 나눴을 때, 0이 나오면 모든 숫자가 exp의 아래
    for (int exp = 1; m / exp > 0; exp *= 10) {
        countSort(arr, n, exp);
    }
}
int main() {
    int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
    int n = sizeof(arr) / sizeof(arr[0]);			// 좋은 습관
    radixsort(arr, n);
    
    for (int i = 0; i < n; i++){
        cout << arr[i] << " ";
    }
    return 0;
}
```



#### 질문

---

Q1) 왜 낮은 자리수부터 정렬을 합니까?

MSD (Most-Significant-Digit) 과 LSD (Least-Significant-Digit)을 비교하라는 질문

MSD는 가장 큰 자리수부터 Counting sort 하는 것을 의미하고, LSD는 가장 낮은 자리수부터 Counting sort 하는 것을 의미함. (즉, 둘 다 할 수 있음)

* LSD의 경우 1600000 과 1을 비교할 때, Digit의 갯수만큼 따져야하는 단점이 있음.
  그에 반해 MSD는 마지막 자리수까지 확인해 볼 필요가 없음.
* LSD는 중간에 정렬 결과를 알 수 없음. (예) 10004와 70002의 비교)
  반면, MSD는 중간에 중요한 숫자를 알 수 있음. 따라서 시간을 줄일 수 있음. 그러나, 정렬이 되었는지 확인하는 과정이 필요하고, 이 때문에 메모리를 더 사용
* LSD는 알고리즘이 일관됨 (Branch Free algorithm)
  그러나 MSD는 일관되지 못함. --> 따라서 Radix sort는 주로 LSD를 언급함.
* LSD는 자릿수가 정해진 경우 좀 더 빠를 수 있음.

# OSI 7 계층

#### 7계층은 왜 나눌까?

통신이 일어나는 과정을 단계별로 알 수 있고, 특정한 곳에 이상이 생기면 그 단계만 수정할 수 있기 때문이다.

<br>

##### 1) 물리(Physical)

> 리피터, 케이블, 허브 등

단지 데이터 전기적인 신호로 변환해서 주고받는 기능을 진행하는 공간

즉, 데이터를 전송하는 역할만 진행한다.

<br>

##### 2) 데이터 링크(Data Link)

> 브릿지, 스위치 등

물리 계층으로 송수신되는 정보를 관리하여 안전하게 전달되도록 도와주는 역할

Mac 주소를 통해 통신한다. 프레임에 Mac 주소를 부여하고 에러검출, 재전송, 흐름제어를 진행한다.

<br>

##### 3) 네트워크(Network)

> 라우터, IP

데이터를 목적지까지 가장 안전하고 빠르게 전달하는 기능을 담당한다.

라우터를 통해 이동할 경로를 선택하여 IP 주소를 지정하고, 해당 경로에 따라 패킷을 전달해준다.

라우팅, 흐름 제어, 오류 제어, 세그먼테이션 등을 수행한다.

<br>

##### 4) 전송(Transport)

> TCP, UDP

TCP와 UDP 프로토콜을 통해 통신을 활성화한다. 포트를 열어두고, 프로그램들이 전송을 할 수 있도록 제공해준다.

- TCP : 신뢰성, 연결지향적

- UDP : 비신뢰성, 비연결성, 실시간

<br>

##### 5) 세션(Session)

> API, Socket

데이터가 통신하기 위한 논리적 연결을 담당한다. TCP/IP 세션을 만들고 없애는 책임을 지니고 있다.

<br>

##### 6) 표현(Presentation)

> JPEG, MPEG 등

데이터 표현에 대한 독립성을 제공하고 암호화하는 역할을 담당한다.

파일 인코딩, 명령어를 포장, 압축, 암호화한다.

<br>

##### 7) 응용(Application)

> HTTP, FTP, DNS 등

최종 목적지로, 응용 프로세스와 직접 관계하여 일반적인 응용 서비스를 수행한다.

사용자 인터페이스, 전자우편, 데이터베이스 관리 등의 서비스를 제공한다.

# 시스템 콜

#### [Operating System] System Call

---

fork( ), exec( ), wait( )와 같은 것들은 Process 생성과 제어를 위한 System call임.

- fork, exec는 새로운 Process 생성과 관련이 되어 있다.
- wait는 Process (Parent)가 만든 다른 Process(child) 가 끝날 때까지 기다리는 명령어임.

---

##### Fork

> 새로운 Process를 생성할 때 사용.
>
> 그러나, 이상한 방식임.

```c
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
    printf("pid : %d", (int) getpid()); // pid : 29146
    
    int rc = fork();					// 주목
    
    if (rc < 0) {
        exit(1);
    }									// (1) fork 실패
    else if (rc == 0) {					// (2) child 인 경우 (fork 값이 0)
        printf("child (pid : %d)", (int) getpid());
    }
    else {								// (3) parent case
        printf("parent of %d (pid : %d)", rc, (int)getpid());
    }
}
```

> pid : 29146
>
> parent of 29147 (pid : 29146)
>
> child (pid : 29147)

을 출력함 (parent와 child의 순서는 non-deterministic함. 즉, 확신할 수 없음. scheduler가 결정하는 일임.)

[해석]

PID :  프로세스 식별자. UNIX 시스템에서는 PID는 프로세스에게 명령을 할 때 사용함.

Fork()가 실행되는 순간. 프로세스가 하나 더 생기는데, 이 때 생긴 프로세스(Child)는 fork를 만든 프로세스(Parent)와 (almost) 동일한 복사본을 갖게 된다. **<u>이 때 OS는 위와 똑같은 2개의 프로그램이 동작한다고 생각하고, fork()가 return될 차례라고 생각한다.</u>** 그 때문에 새로 생성된 Process (child)는 main에서 시작하지 않고, if 문부터 시작하게 된다.

그러나, 차이점이 있었다. 바로 child와 parent의 fork() 값이 다르다는 점이다.
 따라서, 완전히 동일한 복사본이라 할 수 없다. 

> Parent의 fork()값 => child의 pid 값
>
> Child의 fork()값 => 0

Parent와 child의 fork 값이 다르다는 점은 매우 유용한 방식이다.

그러나! Scheduler가 부모를 먼저 수행할지 아닐지 확신할 수 없다. 따라서 아래와 같이 출력될 수 있다.

> pid : 29146
>
> child (pid : 29147)
>
> parent of 29147 (pid : 29146)

----

##### wait

> child 프로세스가 종료될 때까지 기다리는 작업

위의 예시에 int wc = wait(NULL)만 추가함.

```C
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {
    printf("pid : %d", (int) getpid()); // pid : 29146
    
    int rc = fork();					// 주목
    
    if (rc < 0) {
        exit(1);
    }									// (1) fork 실패
    else if (rc == 0) {					// (2) child 인 경우 (fork 값이 0)
        printf("child (pid : %d)", (int) getpid());
    }
    else {								// (3) parent case
        int wc = wait(NULL)				// 추가된 부분
        printf("parent of %d (wc : %d / pid : %d)", wc, rc, (int)getpid());
    }
}
```

> pid : 29146
>
> child (pid : 29147)
>
> parent of 29147 (wc : 29147 / pid : 29146)

wait를 통해서, child의 실행이 끝날 때까지 기다려줌. parent가 먼저 실행되더라도, wait ()는 child가 끝나기 전에는 return하지 않으므로, 반드시 child가 먼저 실행됨.

----

##### exec

단순 fork는 동일한 프로세스의 내용을 여러 번 동작할 때 사용함.

child에서는 parent와 다른 동작을 하고 싶을 때는 exec를 사용할 수 있음.

```c
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {
    printf("pid : %d", (int) getpid()); // pid : 29146
    
    int rc = fork();					// 주목
    
    if (rc < 0) {
        exit(1);
    }									// (1) fork 실패
    else if (rc == 0) {					// (2) child 인 경우 (fork 값이 0)
        printf("child (pid : %d)", (int) getpid());
        char *myargs[3];
        myargs[0] = strdup("wc");		// 내가 실행할 파일 이름
        myargs[1] = strdup("p3.c");		// 실행할 파일에 넘겨줄 argument
        myargs[2] = NULL;				// end of array
        execvp(myarges[0], myargs);		// wc 파일 실행.
        printf("this shouldn't print out") // 실행되지 않음.
    }
    else {								// (3) parent case
        int wc = wait(NULL)				// 추가된 부분
        printf("parent of %d (wc : %d / pid : %d)", wc, rc, (int)getpid());
    }
}
```

exec가 실행되면, 

execvp( 실행 파일, 전달 인자 ) 함수는, code segment 영역에 실행 파일의 코드를 읽어와서 덮어 씌운다.

씌운 이후에는,  heap, stack, 다른 메모리 영역이 초기화되고, OS는 그냥 실행한다. 즉, 새로운 Process를 생성하지 않고, 현재 프로그램에 wc라는 파일을 실행한다. 그로인해서, execvp() 이후의 부분은 실행되지 않는다.

# 스프링의 큰 특징들

#### 스프링이란?
자바(JAVA) 엔터프라이즈 개발을 위한 "오픈소스(Open Source)" 애플리케이션 프레임워크(Framework)

#### 스프링 특징

1. "경량 컨테이너"(크기와 부하의 측면)로서 자바 객체를 직접 관리

 - 각각의 객체 생성, 소멸과 같은 라이프 사이클을 관리하며 스프링으로부터 필요한 객체를 얻어올 수 있다.

2. 제어 역행(IoC : Inversion of Control)

 - 애플리케이션의 느슨한 결합을 도모.

 - 컨트롤의 제어권이 사용자가 아니라 프레임워크에 있어 필요에 따라 스프링에서 사용자의 코드를 호출한다.


3. 의존성 주입(DI : Dependency Injection)

> 스프링 컨테이너가 지원하는 핵심 개념 중 하나로, 설정 파일을 통해 객체간의 의존관계를 설정하는 역할을 합니다.
>
> 각 클래스 사이에 필요로 하는 의존관계를 Bean 설정 정보 바탕으로 컨테이너가 자동으로 연결합니다.
>
> 객체는 직접 의존하고 있는 객체를 생성하거나 검색할 필요가 없으므로 코드 관리가 쉬워지는 장점이 있습니다.

4. 관점지향 프로그래밍(AOP : Aspect-Oriented Programming)

> 공통의 관심 사항을 적용해서 발생하는 의존 관계의 복잡성과 코드 중복을 해소해줍니다.
>
> 각 클래스에서 공통 관심 사항을 구현한 모듈에 대한 의존관계를 갖기 보단, Aspect를 이용해 핵심 로직을 구현한 각 클래스에 공통 기능을 적용합니다.
>
> 간단한 설정만으로도 공통 기능을 여러 클래스에 적용할 수 있는 장점이 있으며 핵심 로직 코드를 수정하지 않고도 웹 애플리케이션의 보안, 로깅, 트랜잭션과 같은 공통 관심 사항을 AOP를 이용해 간단하게 적용할 수 있습니다.

5. 애플리케이션 객체의 생명 주기와 설정을 포함하고 관리한다는 점에서 일종의 "컨테이너"(Container)라고 할 수 있다.

 - iBatis, myBatis나 Hibernate 등 완성도가 높은 데이터베이스처리 라이브러리와 연결할 수 있는 인터페이스를 제공한다.


6. 트랜잭션 관리 프레임워크

 - 추상화된 트랜잭션 관리를 지원하며 설정파일(xml, java, property 등)을 이용한 선언적인 방식 및 프로그래밍을 통한 방식을 모두 지원한다.

7. 모델-뷰-컨트롤러 패턴

 - 웹 프로그램밍 개발 시 거의 표준적인 방식인 "Spring MVC"라 불리는 모델-뷰-컨트롤러(MVC) 패턴을 사용한다. 

 -  DispatcherServlet이 Controller 역할을 담당하여 각종 요청을 적절한 서비스에 분산시켜주며 이를 각 서비스들이 처리를 하여 결과를 생성하고 그 결과는 다양한 형식의 View 서비스들로 화면에 표시될 수 있다.

8. 배치 프레임워크

 - 스프링은 특정 시간대에 실행하거나 대용량의 자료를 처리하는데 쓰이는 일괄 처리(Batch Processing)을 지원하는 배치 프레임워크를 제공한다. 기본적으로 스프링 배치는 Quartz 기반으로 동작한다.

9. 즉 공통 부분의 소스 코딩이 용이하며 확장성도 매우 높다.

# 스프링 디자인 패턴

1. MVC(model-view-controller)
> Model
모델은 애플리케이션의 데이터를 의미하며, Database의 데이터를 조작하는 layer입니다.
> 
> View
뷰는 사용자에게 보여지는 인터페이스를 의미하며, 웹에서는 HTML문서라고 생각하시면 됩니다.
>
> Controller
컨트롤러는 데이터(model)와 인터페이스(View)간의 상호 동작을 관리합니다.
즉, Model에 명령을 보내 데이터의 상태를 바꾸고, 어떤 화면을 사용자에게 보여줄지 View에 명령을 합니다.

MVC 패턴을 사용하는 목적은 View와 Model사이에 Controller를 두어 View와 Model의 의존성을 없애기 위함입니다.

훌륭한 설계란 인터페이스 간의 의존성(Dependency)를 제거하는것에 있습니다.

2. MVP(model-view-presenter)
Preseneter는 View의 인스턴스를 갖고 있으며 View에서 요청이 발생하면 이벤트에 따른 Model의 상태를 변경시킵니다.

즉, 철저하게 View와 Model를 분리시키고, View와 Model 사이에 다리 역할을 수행합니다.

3. MVVM(model-view-viewModel)

ViewModel은 View를 나타내기 위한 Model이라 이해하시면 됩니다.

MVVM 모델은 MVP 모델과 같이 View에서 입력이 들어옵니다.

입력이 들어오면 Command 패턴을 통해 ViewModel에 명령을 내리게 되고 ViewModel은 Model에게 필요한 데이터를 요청합니다.

Model은 ViewModel에 필요한 데이터를 응답하고 Data Binding을 통해 ViewModel의 값이 변화하면 바로 View의 정보가 바뀌게 됩니다.

즉, Command와 Data Binding을 통해 View의 의존성을 끊어버렸습니다.

이로써 View와 Model의 분리가 이루어졌고, MVP 패턴의 문제점을 해결되었습니다.