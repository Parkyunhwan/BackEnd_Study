# 7주차 면접 스터디 정리

## 기수정렬이란
- 0~9 까지의 Bucket(Queue 자료구조의)을 준비한다.
- 모든 데이터에 대하여 가장 낮은 자리수에 해당하는 Bucket에 차례대로 데이터를 둔다.
- 0부터 차례대로 버킷에서 데이터를 다시 가져온다.
- 가장 높은 자리수를 기준으로 하여 자리수를 높여가며 2번 3번 과정을 반복한다.
- 시간 복잡도는 O(dn)
- 자리수가 고정되어 있어서 안정성이 있는 정렬 방식
- [참고](https://lktprogrammer.tistory.com/48)

## OSI7 계층
[참고](https://velog.io/@inyong_pang/OSI-7-%EA%B3%84%EC%B8%B5%EA%B3%BC-TCPIP-%EA%B3%84%EC%B8%B5)
- 사용 이유
    - 통신이 일어나는 과정을 단계별로 알 수 있고, 특정한 곳에 이상이 생기면 그 단계만 수정할 수 있기 때문이다.
- 장점
    - 계층을 나눠 통신이 일어나는 과정을 단계별로 한눈에 파악할 수 있다.
    - 문제 발생 시 다른 단계에 영향을 주지 않고 이상이 생긴 단계만 고칠 수 있다.
- OSI 7계층과 TCP/IP 5계층을 나눈 이유?
    - [참고](https://middleware.tistory.com/entry/TCPIP%EC%99%80-OSI-7%EA%B3%84%EC%B8%B5-%ED%94%84%EB%A1%9C%ED%86%A0%EC%BD%9C%EC%9D%98-%EB%B9%84%EA%B5%90)
- 2계층에서의 데이터 주고 받는 과정 설명
    - '포인트 투 포인트'간 신뢰성있는 전송을 보장하기 위한 계층
    - 단위 : 프레임 → 맥 주소를 가지고 통신
    - CRC 기반의 '오류제어'와 '흐름제어' (물리계층에서 발생하는 오류를 찾아내어 수정함)
    - MAC address는 네트워크 카드가 만들어질 때 할당된다.
- 각 계층별 데이터송수신 흐름
    - 2계층
    - ![KakaoTalk_Photo_2021-04-30-20-44-20](https://user-images.githubusercontent.com/47052106/116690856-f9068300-a9f4-11eb-81cc-51cc3429c8b0.png)
    - 3계층
    - ![KakaoTalk_Photo_2021-04-30-20-44-28](https://user-images.githubusercontent.com/47052106/116690863-fc017380-a9f4-11eb-84e0-de01f388787d.png)
    - 4계층
    - ![KakaoTalk_Photo_2021-04-30-20-44-34](https://user-images.githubusercontent.com/47052106/116690868-fd32a080-a9f4-11eb-8374-24e66f03d35c.png)
    - 5계층
    - ![KakaoTalk_Photo_2021-04-30-20-44-44](https://user-images.githubusercontent.com/47052106/116690872-fdcb3700-a9f4-11eb-9368-4557fa95479b.png)

## 시스템콜 쓰는 이유?
- 시스템콜 필요성과 정의
    - 사용자영역의 응용프로그램에서 운영체제에게 커널영역의 기능을 수행해달라고 요청하는 것
    - 해커가 피해를 입히기 위해 악의적으로 시스템 콜을 사용하는 경우나 초보 사용자가 하드웨어 명령어를 잘 몰라서 아무렇게 함수를 호출했을 경우에 시스템 전체를 망가뜨릴 수도 있기 때문입니다. 따라서 이러한 명령어들은 특별하게 커널 모드에서만 실행할 수 있도록 설계됨.
- 사용자가 임의로 접근할 경우엔?
    - 유저 모드에서 시스템 콜을 호출할 경우에는 운영체제에서 불법적인 접근이라 여기고 trap을 발생시킵니다.

## Spring 주요특징들
- IOC / DI
    - [참고](https://galid1.tistory.com/493?category=769011)
- PSA
    - 추상화계층을 사용하여 어떤 기술을 내부에 숨기고 개발자에게 편의성을 제공해주는 것
    - @Controller, @Service, @Mapper 등
    - [참고](https://velog.io/@jbb9229/springpsa)
- AOP
    - [참고](https://engkimbs.tistory.com/746)
- POJO 객체란?
    - EJB처럼 복잡하고 많은 기술을 사용하는 것보다 자바의 단순 오브젝트르 이용해 비즈니스로직을 구현
    - 객체지향원리에 충실하면서, 환경과 기술에 종속되지 않고 재활용될 수 있는 방식으로 설계된 오브젝트
    - 장점
        - 자동화 테스트, 객체지향 설계 깔끔한 코드
    - POJO프레임워크
        - Spring Framework, Hibernate
    - [참고](https://m.blog.naver.com/writer0713/220700687650)

## MVC?
- MVC1 vs MVC2
    - JSP Model1
        - 로직 + 출력 코드가 한 페이지에 삽입
        - 쉬운 코딩
        - 어려운 유지보수
        - 뷰와 로직이 섞인다
        - 구조가 단순
    - JSP Model2
        - MVC 패턴을 웹에 적용
        - 비지니스/출력 로직의 분리
        - 유지 보수가 용이
        - 뷰, 로직에 대한 분업이 가능
        - 모델1에 비해 습득이 어렵고 작업량이 많다
- MVC?
    - [MVC](https://m.blog.naver.com/jhc9639/220967034588)