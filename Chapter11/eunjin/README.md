### 가비지 컬렉션

**마이너 GC:** Young 영역에서 발생하는 GC

**메이저 GC:** Old 영역이나 Perm 영역에서 발생하는 GC

[[성능튜닝] 가비지 컬렉터(GC) 이해하기](https://12bme.tistory.com/57)

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/cb1bd33d-3a12-4c8d-8d69-39584eedaf06/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/cb1bd33d-3a12-4c8d-8d69-39584eedaf06/Untitled.png)

### 스프링 동작 방식

1. DispatcherServlet이 브라우저로부터 요청을 받는다.

2. DispatcherServlet은 요청된 URL을 HandlerMapping 객체에 넘기고, 호출해야 할 Controller 메소드(핸들러) 정보를 얻는다.

3. DispatcherServlet이 HandlerAdapter 객체를 가져온다.

4. HandlerAdapter 객체의 메소드를 실행한다.

※ 보다 정확하게 표현한다면, HandlerMapping은 DispatcherServlet로부터 전달된 URL을 바탕으로 HandlerAdapter 객체를 포함하는 HandlerExecutionChain 객체를 생성하며, 이후 DispatcherServlet이 HandlerExecutionChain 객체로부터 HandlerAdapter 객체를 가져와서 해당 메소드를 실행하게 된다.

5. Controller 객체는 비즈니스 로직을 처리하고, 그 결과를 바탕으로 뷰(ex. JSP)에 전달할 객체를 Model 객체에 저장한다. DispatcherServlet에게 view name을 리턴한다.

6. DispatcherServlet은 view name을 View Resolver에게 전달하여 View 객체를 얻는다.

7. DispatcherServlet은 View 객체에 화면 표시를 의뢰한다.

8. View 객체는 해당하는 뷰(ex. JSP, Thymeleaf)를 호출하며, 뷰는 Model 객체에서 화면 표시에 필요한 객체를 가져와 화면 표시를 처리한다.

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5edf7824-af7f-4366-88cd-0f123af80c96/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5edf7824-af7f-4366-88cd-0f123af80c96/Untitled.png)

## **Load Balancing이란?**

- 하나의 인터넷 서비스가 발생하는 트래픽이 많을 때 여러 대의 서버가 분산처리하여 서버의 로드율 증가, 부하량, 속도저하 등을 고려하여 적절히 분산처리하여 해결해주는 서비스입니다.

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/76f6561e-0069-41d0-ad06-82311c94698c/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/76f6561e-0069-41d0-ad06-82311c94698c/Untitled.png)

### 주요기능

- Network Address Translation(NAT)

    : Private IP를 Public IP로 바꿈

- Tunneling

    : 데이터를 캡슐화하여 연결된 노드만 캡슐을 해제할 수 있게 만듦

- Dynamic Source Routing protocol(DSR)

    : 요청에 대한 응답을 할 때 로드밸런서가 아닌 클라이언트의 IP로 응답
