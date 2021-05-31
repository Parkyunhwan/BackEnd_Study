# java garbage collection

## Garbage Collection

<img src = "https://user-images.githubusercontent.com/33534771/83469636-33049780-a4bb-11ea-8135-9bae85b79a10.png" />

### [Minor GC]

- 새로 생성된 대부분의 객체는 Eden 영역에 위치한다. 
- Eden 영역이 꽉 차게 되면 GC가 발생한다. GC가 발생한 이후, 살아남은 객체는 Survivor 영역 중 하나로 이동한다.
- 이 과정을 반복하다가 계속해서 살아남은 객체는 일정 시간 참조되고 있다는 뜻이므로 Old 영역으로 이동한다.



### [Major GC]

- Old 영역에 있는 모든 객체들을 검사하여 참조되고 있지 않은 객체들을 한꺼번에 삭제한다. 
- 시간이 오래 걸리고 실행 중 프로세스가 정지된다. 이것은 'Stop-the-World'라고 하는데, Major GC가 발생하면 GC를 실행하는 스레드를 제외한 나머지 스레드는 모두 작업을 멈춘다. GC 작업을 완료한 이후에야 중단했던 작업을 다시 시작한다.
- GC의 튜닝은 이 'Stop-the-World'의 시간을 줄이는 것이다. 



### [GC는 어떤 원리로 소멸시킬 대상을 선정하는가?]

- 알고리즘에 따라 동작 방식이 매우 다양하지만 공통적인 원리가 있다. 
- Garbage Collector는 힙 내의 객체 중에서 가비지를 찾아내고 찾아낸 가비지를 처리해서 힙의 메모리를 회수한다. 
- **참조되고 있지 않은 객체를 가비지**라고 하며, 객체가 가비지인지 아닌지 판단하기 위해서 `Reachability`라는 개념을 사용한다.
- 어떤 힙 영역에 할당된 객체가 유효한 참조가 있으면 Reachability
- 없다면  UnReachability로 판단한다.
- 하나의 객체는 다른 객체를 참조하고 다른 객체는 또 다른 객체를 참조할 수 있기 때문에 참조 사슬이 형성된다. 이 참조 사슬 중 최초에 참조한 것을 Root Set이라고 한다. 
- 힙 영역에 있는 객체들을 총 4가지 경우에 대한 참조를 하게 된다. 

<img src = "https://user-images.githubusercontent.com/33534771/83470789-0605b400-a4be-11ea-84e6-6044596242d3.png" />


유효한 최초의 참조가 이루어지지 않은 객체들은 Unreachable Objects로 판단하며, GC에 의해 수거된다. 



인스턴스가 가비지 컬렉션의 대상이 되었다고 해서 바로 소멸이 되는 것은 아니다. 빈번한 가비지 컬렉션의 실행은 시스템에 부담이 될 수 있기 때문이다. 그래서 성능에 영향을 미치지 않도록 가비지 컬렉션 실행 타이밍은 별도의 알고리즘을 기반으로 계산이 되며, 이 계산 결과를 바탕으로 GC가 수행된다.



참고할 만한 블로그

- [네이버 D2 블로그](https://d2.naver.com/helloworld/329631)
- [Jungwoon Blog](https://jungwoon.github.io/java,%20gc/2019/07/27/Garbage-Collection.html)


# spring 동작 방식

https://starkying.tistory.com/entry/Spring-MVC-%EB%8F%99%EC%9E%91%EC%9B%90%EB%A6%AC-%EA%B5%AC%EC%84%B1%EC%9A%94%EC%86%8C

<br>

#### Dispatcher-Servlet

>  서블릿 컨테이너에서 HTTP 프로토콜을 통해 들어오는 모든 요청을 제일 앞에서 처리해주는 프론트 컨트롤러를 말함
>
> 따라서 서버가 받기 전에, 공통처리 작업을 디스패처 서블릿이 처리해주고 적절한 세부 컨트롤러로 작업을 위임해줍니다.
>
> 디스패처 서블릿이 처리하는 url 패턴을 지정해줘야 하는데, 일반적으로는 .mvc와 같은 패턴으로 처리하라고 미리 지정해줍니다.
>
> 
> 디스패처 서블릿으로 인해 web.xml이 가진 역할이 상당히 축소되었습니다. 기존에는 모든 서블릿을 url 매핑 활용을 위해 모두 web.xml에 등록해 주었지만, 디스패처 서블릿은 그 전에 모든 요청을 핸들링해주면서 작업을 편리하게 할 수 있도록 도와줍니다. 또한 이 서블릿을 통해 MVC를 사용할 수 있기 때문에 웹 개발 시 큰 장점을 가져다 줍니다.

<br>

#### DI(Dependency Injection)

> 스프링 컨테이너가 지원하는 핵심 개념 중 하나로, 설정 파일을 통해 객체간의 의존관계를 설정하는 역할을 합니다.
>
> 각 클래스 사이에 필요로 하는 의존관계를 Bean 설정 정보 바탕으로 컨테이너가 자동으로 연결합니다.
>
> 객체는 직접 의존하고 있는 객체를 생성하거나 검색할 필요가 없으므로 코드 관리가 쉬워지는 장점이 있습니다.

<br>

#### AOP(Aspect Oriented Programming)

> 공통의 관심 사항을 적용해서 발생하는 의존 관계의 복잡성과 코드 중복을 해소해줍니다.
>
> 각 클래스에서 공통 관심 사항을 구현한 모듈에 대한 의존관계를 갖기 보단, Aspect를 이용해 핵심 로직을 구현한 각 클래스에 공통 기능을 적용합니다.
>
> 간단한 설정만으로도 공통 기능을 여러 클래스에 적용할 수 있는 장점이 있으며 핵심 로직 코드를 수정하지 않고도 웹 애플리케이션의 보안, 로깅, 트랜잭션과 같은 공통 관심 사항을 AOP를 이용해 간단하게 적용할 수 있습니다.

<br>

#### AOP 용어

> Advice : 언제 공통 관심기능을 핵심 로직에 적용할지 정의
>
> Joinpoint : Advice를 적용이 가능한 지점을 의미 (before, after 등등)
>
> Pointcut : Joinpoint의 부분집합으로, 실제로 Advice가 적용되는 Joinpoint를 나타냄
>
> Weaving : Advice를 핵심 로직코드에 적용하는 것
>
> Aspect : 여러 객체에 공통으로 적용되는 공통 관심 사항을 말함. 트랜잭션이나 보안 등이 Aspect의 좋은 예

<br>

#### DAO(Data Access Object)

> DB에 데이터를 조회하거나 조작하는 기능들을 전담합니다.
>
> Mybatis를 이용할 때는, mapper.xml에 쿼리문을 작성하고 이를 mapper 클래스에서 받아와 DAO에게 넘겨주는 식으로 구현합니다.

<br>

#### Annotation

> 소스코드에 @어노테이션의 형태로 표현하며 클래스, 필드, 메소드의 선언부에 적용할 수 있는 특정기능이 부여된 표현법을 말합니다.
>
> 애플리케이션 규모가 커질수록, xml 환경설정이 매우 복잡해지는데 이러한 어려움을 개선시키기 위해 자바 파일에 어노테이션을 적용해서 개발자가 설정 파일 작업을 할 때 발생시키는 오류를 최소화해주는 역할을 합니다.
>
> 어노테이션 사용으로 소스 코드에 메타데이터를 보관할 수 있고, 컴파일 타임의 체크뿐 아니라 어노테이션 API를 사용해 코드 가독성도 높여줍니다.

- @Controller : dispatcher-servlet.xml에서 bean 태그로 정의하는 것과 같음.
- @RequestMapping : 특정 메소드에서 요청되는 URL과 매칭시키는 어노테이션
- @Autowired : 자동으로 의존성 주입하기 위한 어노테이션
- @Service : 비즈니스 로직 처리하는 서비스 클래스에 등록
- @Repository : DAO에 등록

<br>

#### Spring JDBC

> 데이터베이스 테이블과, 자바 객체 사이의 단순한 매핑을 간단한 설정을 통해 처리하는 것
>
> 기존의 JDBC에서는 구현하고 싶은 로직마다 필요한 SQL문이 모두 달랐고, 이에 필요한 Connection, PrepareStatement, ResultSet 등을 생성하고 Exception 처리도 모두 해야하는 번거러움이 존재했습니다.
>
> Spring에서는 JDBC와 ORM 프레임워크를 직접 지원하기 때문에 따로 작성하지 않아도 모두 다 처리해주는 장점이 있습니다.

<br>

#### MyBatis

> 객체, 데이터베이스, Mapper 자체를 독립적으로 작성하고, DTO에 해당하는 부분과 SQL 실행결과를 매핑해서 사용할 수 있도록 지원함
>
> 기존에는 DAO에 모두 SQL문이 자바 소스상에 위치했으나, MyBatis를 통해 SQL은 XML 설정 파일로 관리합니다.
>
> 설정파일로 분리하면, 수정할 때 설정파일만 건드리면 되므로 유지보수에 매우 좋습니다. 또한 매개변수나 리턴 타입으로 매핑되는 모든 DTO에 관련된 부분도 모두 설정파일에서 작업할 수 있는 장점이 있습니다.

<br>

<br>

<br>

# 브라우저

# 브라우저 동작 방법

<br>

***"브라우저가 어떻게 동작하는지 아세요?"***

웹 서핑하다보면 우리는 여러 url을 통해 사이트를 돌아다닌다. 이 url이 입력되었을 때 어떤 과정을 거쳐서 출력되는걸까?

web의 기본적인 개념이지만 설명하기 무지 어렵다.. 렌더링..? 파싱..?

<br>

브라우저 주소 창에 [http://naver.com](http://naver.com)을 입력했을 때 어떤 과정을 거쳐서 네이버 페이지가 화면에 보이는 지 알아보자

>  오픈 소스 브라우저(크롬, 파이어폭스, 사파리 등)로 접속했을 때로 정리

<br>

<br>

#### 브라우저 주요 기능

---

사용자가 선택한 자원을 서버에 요청, 브라우저에 표시

자원은 html 문서, pdf, image 등 다양한 형태

자원의 주소는 URI에 의해 정해짐

<br>

브라우저는 html과 css 명세에 따라 html 파일을 해석해서 표시함

이 '명세'는 웹 표준화 기구인 `W3C(World wide web Consortium)`에서 정해짐

> 예전 브라우저들은 일부만 명세에 따라 구현하고 독자적 방법으로 확장했음
>
> (결국 **심각한 호환성 문제** 발생... 그래서 요즘은 대부분 모두 표준 명세를 따름)

<br>

브라우저가 가진 인터페이스는 보통 비슷비슷한 요소들이 존재

> 시간이 지나면서, 사용자에게 필요한 서비스들로 서로 모방하며 갖춰지게 된 것

- URI 입력하는 주소 표시 줄
- 이전 버튼, 다음 버튼
- 북마크(즐겨찾기)
- 새로 고침 버튼
- 홈 버튼

<br>

<br>

#### 브라우저 기본 구조

---

<img src="https://d2.naver.com/content/images/2015/06/helloworld-59361-1.png">

<br>

##### 사용자 인터페이스

주소 표시줄, 이전/다음 버튼, 북마크 등 사용자가 활용하는 서비스들
(요청한 페이지를 보여주는 창을 제외한 나머지 부분)

##### 브라우저 엔진

사용자 인터페이스와 렌더링 엔진 사이의 동작 제어

##### 렌더링 엔진

요청한 콘텐츠 표시 (html 요청이 들어오면? → html, css 파싱해서 화면에 표시)

##### 통신

http 요청과 같은 네트워크 호출에 사용
(플랫폼의 독립적인 인터페이스로 구성되어있음)

##### UI 백엔드

플랫폼에서 명시하지 않은 일반적 인터페이스. 콤보 박스 창같은 기본적 장치를 그림

##### 자바스크립트 해석기

자바스크립트 코드를 해석하고 실행

##### 자료 저장소

쿠키 등 모든 종류의 자원을 하드 디스크에 저장하는 계층

<br>

<br>

#### ***렌더링이란?***

웹 분야를 공부하다보면 **렌더링**이라는 말을 많이 본다. 동작 과정에 대해 좀 더 자세히 알아보자

<br>

렌더링 엔진은 요청 받은 내용을 브라우저 화면에 표시해준다.

기본적으로 html, xml 문서와 이미지를 표시할 수 있음

추가로 플러그인이나 브라우저 확장 기능으로 pdf 등 다른 유형도 표시가 가능함

(추가로 확장이 필요한 유형은 바로 뜨지 않고 팝업으로 확장 여부를 묻는 것을 볼 수 있을 것임)

<br>

##### 렌더링 엔진 종류

크롬, 사파리 : 웹킷(Webkit) 엔진 사용

파이어폭스 : 게코(Gecko) 엔진 사용

<br>

**웹킷(Webkit)** : 최초 리눅스 플랫폼에 동작하기 위한 오픈소스 엔진
(애플이 맥과 윈도우에서 사파리 브라우저를 지원하기 위해 수정을 더했음)

<br>

##### 렌더링 동작 과정

<img src="https://d2.naver.com/content/images/2015/06/helloworld-59361-2.png">

<br>

```
먼저 html 문서를 파싱한다.

그리고 콘텐츠 트리 내부에서 태그를 모두 DOM 노드로 변환한다.

그 다음 외부 css 파일과 함께 포함된 스타일 요소를 파싱한다.

이 스타일 정보와 html 표시 규칙은 렌더 트리라고 부르는 또 다른 트리를 생성한다.

이렇게 생성된 렌더 트리는 정해진 순서대로 화면에 표시되는데, 생성 과정이 끝났을 때 배치가 진행되면서 노드가 화면의 정확한 위치에 표시되는 것을 의미한다.

이후에 UI 백엔드에서 렌더 트리의 각 노드를 가로지으며 형상을 만드는 그리기 과정이 진행된다.

이러한 과정이 점진적으로 진행되며, 렌더링 엔진은 좀더 빠르게 사용자에게 제공하기 위해 모든 html을 파싱할 때까지 기다리지 않고 배치와 그리기 과정을 시작한다. (마치 비동기처럼..?)

전송을 받고 기다리는 동시에 받은 내용을 먼저 화면에 보여준다
(우리가 웹페이지에 접속할 때 한꺼번에 뜨지 않고 점점 화면에 나오는 것이 이 때문!!!)
```

<br>

***DOM이란?***

Document Object Model(문서 객체 모델)

웹페이지 소스를 까보면 `<html>, <body>`와 같은 태그들이 존재한다. 이를 Javascript가 활용할 수 있는 객체로 만들면 `문서 객체`가 된다.

모델은 말 그대로, 모듈화로 만들었다거나 객체를 인식한다라고 해석하면 된다.

즉, **DOM은 웹 브라우저가 html 페이지를 인식하는 방식**을 말한다. (트리구조)

<br>

##### 웹킷 동작 구조

<img src="https://d2.naver.com/content/images/2015/06/helloworld-59361-3.png">

> **어태치먼트** : 웹킷이 렌더 트리를 생성하기 위해 DOM 노드와 스타일 정보를 연결하는 과정

이제 조금 트리 구조의 진행 방식이 이해되기 시작한다..ㅎㅎ

<br>

<br>

#### 파싱과 DOM 트리 구축

---

파싱이라는 말도 많이 들어봤을 것이다.

파싱은 렌더링 엔진에서 매우 중요한 과정이다.

<br>

##### 파싱(parsing)

문서 파싱은, 브라우저가 코드를 이해하고 사용할 수 있는 구조로 변환하는 것

<br>

문서를 가지고, **어휘 분석과 구문 분석** 과정을 거쳐 파싱 트리를 구축한다.

조금 복잡한데, 어휘 분석기를 통해 언어의 구문 규칙에 따라 문서 구조를 분석한다. 이 과정에서 구문 규칙과 일치하는 지 비교하고, 일치하는 노드만 파싱 트리에 추가시킨다. 
(끝까지 규칙이 맞지 않는 부분은 문서가 유효하지 않고 구문 오류가 포함되어 있다는 것)

<br>

파서 트리가 나왔다고 해서 끝이 아니다.

컴파일의 과정일 뿐, 다시 기계코드 문서로 변환시키는 과정까지 완료되면 최종 결과물이 나오게 된다.

<br>

보통 이런 파서를 생성하는 것은 문법에 대한 규칙 부여 등 복잡하고 최적화하기 힘드므로, 자동으로 생성해주는 `파서 생성기`를 많이 활용한다.

>  웹킷은 플렉스(flex)나 바이슨(bison)을 이용하여 유용하게 파싱이 가능

<br>

우리가 head 태그를 실수로 빠뜨려도, 파서가 돌면서 오류를 수정해줌 ( head 엘리먼트 객체를 암묵적으로 만들어준다)

결국 이 파싱 과정을 거치면서 서버로부터 받은 문서를 브라우저가 이해하고 쉽게 사용할 수 있는 DOM 트리구조로 변환시켜주는 것이다!

<br>

<br>

### 요약

---

- 주소창에 url을 입력하고 Enter를 누르면, **서버에 요청이 전송**됨
- 해당 페이지에 존재하는 여러 자원들(text, image 등등)이 보내짐
- 이제 브라우저는 해당 자원이 담긴 html과 스타일이 담긴 css를 W3C 명세에 따라 해석할 것임
- 이 역할을 하는 것이 **'렌더링 엔진'**
- 렌더링 엔진은 우선 html 파싱 과정을 시작함. html 파서가 문서에 존재하는 어휘와 구문을 분석하면서 DOM 트리를 구축
- 다음엔 css 파싱 과정 시작. css 파서가 모든 css 정보를 스타일 구조체로 생성
- 이 2가지를 연결시켜 **렌더 트리**를 만듬. 렌더 트리를 통해 문서가 **시각적 요소를 포함한 형태로 구성**된 상태
- 화면에 배치를 시작하고, UI 백엔드가 노드를 돌며 형상을 그림
- 이때 빠른 브라우저 화면 표시를 위해 '배치와 그리는 과정'은 페이지 정보를 모두 받고 한꺼번에 진행되지 않음. 자원을 전송받으면, **기다리는 동시에 일부분 먼저 진행하고 화면에 표시**함 

<br>

<br>

##### [참고 자료]

네이버 D2 : [링크](<https://d2.naver.com/helloworld/59361>)

<br>

<br>

# 로드 밸런싱

## 로드 밸런싱(Load Balancing)

> 둘 이상의 CPU or 저장장치와 같은 컴퓨터 자원들에게 작업을 나누는 것

<br>

<img src="https://www.educative.io/api/collection/5668639101419520/5649050225344512/page/5747976207073280/image/5696459148099584.png">

요즘 시대에는 웹사이트에 접속하는 인원이 급격히 늘어나게 되었다.

따라서 이 사람들에 대해 모든 트래픽을 감당하기엔 1대의 서버로는 부족하다. 대응 방안으로 하드웨어의 성능을 올리거나(Scale-up) 여러대의 서버가 나눠서 일하도록 만드는 것(Scale-out)이 있다. 하드웨어 향상 비용이 더욱 비싸기도 하고, 서버가 여러대면 무중단 서비스를 제공하는 환경 구성이 용이하므로 Scale-out이 효과적이다. 이때 여러 서버에게 균등하게 트래픽을 분산시켜주는 것이 바로 **로드 밸런싱**이다.

<br>

**로드 밸런싱**은 분산식 웹 서비스로, 여러 서버에 부하(Load)를 나누어주는 역할을 한다. Load Balancer를 클라이언트와 서버 사이에 두고, 부하가 일어나지 않도록 여러 서버에 분산시켜주는 방식이다. 서비스를 운영하는 사이트의 규모에 따라 웹 서버를 추가로 증설하면서 로드 밸런서로 관리해주면 웹 서버의 부하를 해결할 수 있다.

<br>

#### 로드 밸런서가 서버를 선택하는 방식

- 라운드 로빈(Round Robin) : CPU 스케줄링의 라운드 로빈 방식 활용
- Least Connections : 연결 개수가 가장 적은 서버 선택 (트래픽으로 인해 세션이 길어지는 경우 권장)
- Source : 사용자 IP를 해싱하여 분배 (특정 사용자가 항상 같은 서버로 연결되는 것 보장)

<br>

#### 로드 밸런서 장애 대비

서버를 분배하는 로드 밸런서에 문제가 생길 수 있기 때문에 로드 밸런서를 이중화하여 대비한다.

> Active 상태와 Passive 상태

<br>

##### [참고자료]

- [링크](<https://www.educative.io/courses/grokking-the-system-design-interview/3jEwl04BL7Q>)

- [링크](<https://nesoy.github.io/articles/2018-06/Load-Balancer>)