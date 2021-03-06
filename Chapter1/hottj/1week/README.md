# 1 주차
# oopinspring
[스프링 입문을 위한 (자바) 객체 지향의 원리와 이해](http://book.naver.com/bookdb/book_detail.nhn?bid=8920762)

## 객체
- 세상에 존재하는 모든 것은 사물, 즉 객체다
- **각각의 사물은 고유하다**
- 사물은 속성을 갖는다
- 사물은 행위를 한다 (무생물은 의인화 필요)
- 객체를 인지할 때 우리는 분류한다.
    - 직립 보행을 하며 말을 하는 존재들을 ㅇㅇ이라고 분류한다.
    - 연미복, 짧은 다리, 날지 못하는 새들을 ㅇㅇ이라고 분류한다.
    - 밤하늘에 반짝이는 사물들을 ㅇㅇ이라고 분류한다.

## 클래스 vs 객체
    - 사람 분류
        - 사람 클래스의 인스턴스(객체)들
            - 김종민
            - 원빈
            - 현빈
    - 사람(분류) vs 김종민(실체)
    - 펭귄(분류) vs 뽀로로(실체)

## 객체지향의 4대 특성
    - 캡! 상추다
        - 캡슐화
            - 정보 은닉
                - 본인 통장 객체. 잔액이란 속성. 누군가 잔액이란 속성을 접근? 이는 안됨. public 메소드로 통해서만 접근해야하고 private balance로 해야함.
        - 상속
            - 재사용 + 확장
        - 추상화
            - 모델링
        - 다형성
            - 사용 편의

## 클래스와 객체 필요 충분 조건
- 클래스 객체참조변수명 = new 클래스()
    - 펭귄 뽀로로 = new 펭귄()
        - 펭귄이 하나 태어나 펭귄 역할을 하는 뽀로로라고 이름지었다.

## 추상화
- 추상화의 대가는?
    - 피카소
- 추상화란?
    - 추상 그림 : abstract painting
    - 추상화 : abstraction
    - 추상화란 구체적인 것을 분해해서 관심 영역에 대한 특성만을 가지고 재조합 하는 것
- 추상화는 모델링이다
    - DNA 모델
        - 분자 구조. DNA와 똑같이 만들 수 없다.
    - 태양계 모델
    - 사실 그대로 옮길 수도 없고 그럴 필요도 없다. 시뮬레이션일 뿐
    - 추상화란 구체적인 것을 분해해서 관심 영역(애플리케이션 경계)에 있는 특성만을 가지고 재조합하는 것 = 모델링
    - 추상화의 안경을 쓰고 객체들을 통해 클래스를 모델링해야한다
    - 애플리케이션의 경계 / 도메인 / 컨텍스트에 따라 모델링해야한다.
        - 애플리케이션의 경계 : 사람이란. 클래스 모델링
        - 병원 애플리케이션 : 사람은 환자다.
            - 시력,몸무게,혈액형,키,나이,먹다(),자다(),운전하다()
                - 직업,연봉은 관심없다.
        - 은행 애플리케이션 : 사람은 고객이다.
            - 나이,직업,연봉,일하다(),입금하다(),출금하다(),이체하다(),대출하다()
                - 시력,몸무게,혈액형,키는 관심없다.

- 객체 지향의 추상화는 자바의 무엇으로 표현될까요?
    - class
    - 여기서의 추상화는 abstract 키워드를 의미하는게 아니다

## 정적 멤버
- 사람 클래스의 인구
    - 정학제의 인구?
- 고양이 클래스의 다리 개수
    - 4개
- 승용차 클래스의 바퀴 개수
    - 4개
- 답할 수 있다면 static
- 정적 속성은 해당 클래스의 모든 객체가 같은 값을 가질 때 사용하는 것이 기본이다. 물론 이 외의 경우에도 쓸 수는 있겠지만 그 때는 정당한 논리를 가지고 써야 한다.

## 알면 좋은 것들
- 객체의 동의어
    - 인스턴스
    - 클래스의 인스턴스
    - 오브젝트
- 정적 멤버 동의어
    - 클래스 멤버
    - Static 멤버
- 객체 멤버 동의어
    - 인스턴스 멤버
- 함수와 메소드의 차이
- 함수와 프로시저의 차이

## 상속
- 상속은 계층이나 조직이 아니다
    - 할아버지 -> 아버지 -> 아들, 딸
- ㅇㅇ의 상속은 뭔데?
    - 확장이다.
    - 자바 키워드에는 inheritance가 없다
    - 자바에서 상속을 위한 키워드는 extends다
- ㅇㅇ 상속의 올바른 예시도
    - 분류도
    - 동물 -> 포유류 -> 고래 , 박쥐
        - 고래는 포유류인데 바다에 산다. (확장)
        - 위로 갈수록 추상화(일반화), 아래로 갈수록 구체화(특수화)
        - 부모,자식클래스가 아니다. 고래는 포유류의 자식이 아니다. 상위,하위 클래스라고 해야한다.
    - 하위 클래스는 상위 클래스다.(리스코프 치환 LSP)
- 자바는 다중 상속이 안됨(C++은 가능)
    - 인어 클래스는 사람,물고기 클래스 두개를 상속받을 수 있다.
    - 사람의 기능중에 달려봐(). 를 인어에게 하라하면...?
    - 물고기의 기능중에 아가미호흡해봐() 를 인어에게 하라하면...?
    - 둘의 모두 할 수 있는 수영해봐()를 인어에게 하면, 사람은 다리로 수영, 물고기는 꼬리로 수영. 인어는 뭐로 해야하지?
    - 고려해야할 것들이 너무 많음.
- 상속은 is a 관례를 만족해야 한다.
    - 포유류 is a 동물 (50점)
    - 포유류 is a kind of 동물 (100점)
- 상속 vs 인터페이스
    - 상속
        - 확장
        - 목적 : 재사용
    - 인터페이스
        - 구현
            -목적 : 구현 강제, 표준 준수(JPA 사용시 맨 밑 구현체가 무엇이든 상관없음. jdbc 사용시 오라클, mysql 등 이게 뭔지가 중요하지 않다.)
            - 병뚜껑 사이즈는 표준이다. 그래서 뚜껑은 바꿔 끼워도 상관없음. 이게 바로 표준의 힘이다.
        - 구현체 is able to 인터페이스
            - 새는 날 수 있다
- 자바 안의 인터페이스
    - 직렬화할 수 있는
    - 복제화 할 수 있는
    - 비교할 수 있는
    - 실행할 수 있는
- 상속이란 재사용과 확장 이다.
- 상위 클래스는 풍성할수록 좋은가? 빈약할수록 좋은가? (하나의 상위클래스안에 여러 속성)
    - 상위는 풍성. 상속은 재사용하기 위함. 재사용하면 할 수록 좋으므로 풍성하게 좋다. 하지만 너무 많아도 안됨.
    - (Penguin)pingu.habitat 와 같이 캐스팅 작업할 필요가 줄어듦
    - 사실 habitat은 펭귄뿐 아니라 애니몰에 갖다놓는게 좋음. 애니몰 모두 서식지는 있으므로.
- 인터페이스는 풍성할수록 좋은가? 빈약할수록 좋은가?
    - 인터는 심플
        ISP, 인터페이스는 최소주의
- 상속된 하위 객체를 만들면 상위 객체도 같이 만들어진다. 상위 객체를 상속하는 구조이므로

## 캡슐화
- 왜 하냐?
    - 늘 듣던 이야기 : 정보 은닉
        - 변화에 유연한 대처
            - DI
            - 전략패턴
            - get / set
                - 1.주민등록번호 get/set 없이 보여주기 (퍼블릭)
                - 2.주민등록번호 뒤 7 자리는 *으로 보이게 (퍼블릭으로 할 경우 대처하기 어렵다)
                - 3.본인이 접근한 경우에는 다 보이게 (if문 하나면 됨.get 사용할 경우)
                - n.프로그램이 폐기되기 전까지는 변화에 유연한 대치
            - 방법
                - 표준을 따르게
                    - 공통 상위 클래스
                    - 인터페이스
                - 속성 자체를 노출하지 말고 메소드를 통해 노출
        - 관련 키워드
            - 접근 제한자
                - private
                - protected
                - public
                - [default]
        - 관련 기법
            - getter / setter
- 화장
    - 미인 되는법
        - 화장빨
            - 혼자 변하면 된다.
                - OCP
        - 조명빨
            - 주변 조작
        - 술빨
            - 세상 사람 다 술 먹여야 한다.
- 의복
    - 피부 보호
    - 멋도 내고
    - 의복이 좋기만 한가?
    - 변화 대응
        - 춘추복
        - 하복
        - 동복
        - 등산복
        - 수영복
        - 체조복
- 퍼블릭 속성에는 값만 갖고 있지 로직을 갖고 있지 않기때문에 변경에 용이하지 않다.
## 다형성
- 상속에서의 다형성
- 인터페이스(interface)와 그 구현체의 다형성
- 오버라이딩
- 오버로딩
    - 컴파일러가 이름 구분해주는거라 ㅇㅇ랑 상관이 없다고 보는 이견도 있다.
- 라이더가 될 것인가? 로더가 될 것인가?
    - ride : 올라타다
    - load : 적재하다, 짐들을 여러개 적재함. 즉, 중복정의. 같은 메소드 이름. 인자는 다름. 같은 배송 포장지이지만 안은 조금씩 다른 것처럼.
- 목적
    - 코딩 편의 제공
- 다형성이 지원되지 않는다면?
    - 고객 : 두 숫자를 더하는 프로그램을 원해요
        - int add(int,int)
        - int add(int,short) : 중복정의를 할 수 없으므로 이름이 겹치지 않도록 int addShort(int,short)같이 만듦
        - 자바는 숫자형 7개
            - 7*7 - 7 = 42개의 메소드를 구현해야함. add를 정의하기위해 42개의 다른 이름 메소드... 같은 기능인데 이렇게나 많이..?

## Call By
- Value
    - 값에 의한 전달
    - 기본 자료형은 저장하고 있는 값이 전달
        - 대입문 사용시
        - 인자 전달시
        - 메소드 리턴시
- Refrence
- 기본 자료형이던 참조 자료형이던 해당 변수가 가지고 있는 것이 전달된다.
- 문제는 전달된 것을 값으로 해석 / 전달된 것을 포인터로 해석

## 추상클래스와 추상메서드 : abstract
- 추상클래스 필요성
    - 누가 실수로 동물객체를 만들면 어떡하지?
    - 동물객체는 어떻게 울어야하지?
- 추상메서드 필요성
    - 울어보세요()
    - 하위 클래스에 구현을 강제로하고 싶은게 있을때
- 추상속성...
    - x

## 그 외
- Aggregation (집합)
    - 자동차 vs 타이어 (생명 주기 다름)
    - 속이 빈 마름모
- Composition (포함)
    - 사람 vs 심장 (생명 주기 같음)
    - 속이 찬 마름모

## SOLID
- 자바(OOP 4대 특성) : 주방 도구
- OOD 5 원칙 : 주방 도구 사용 설명서
- Design Pattern : 레시피
- SRP : 단일 책임 원칙
- OCP : 개방 폐쇄 원칙
- LSP : 리스코프 치환 원칙
- ISP : 인터페이스 분리 원칙
- DIP : 의존 역전 원칙
- 응집도는 높이고 결합도는 낮추라는 고전 원칙을 객체 지향의 관점에서 재정립된 것
- SRP
    - 남자 클래스에 의존하는 다양한 클래스가 있다.
        - 여자친구 클래스 : 남자친구 역할 (기념일챙기기(),키스하기())
        - 어머니 : 아들 역할
        - 직장상사 : 사원 역할
        - 소대장 : 소대원 역할
        - 여자친구랑 헤어짐. 짜증남 (side effect). 엄마에게 짜증냄. 상사한테 소리지름 등
    - 남자 클래스에 단일 책임 원칙을 적용해 여러 개의 클래스로 분리
        - 남자친구라는 클래스 생성
        - 아들이라는 클래스 생성
        - 사원이라는 클래스 생성
        - 소대원이라는 클래스 생성
        - 즉 책임을 하나만 가지게 해라! 관심사가 분리되어야 나중에 변경이 일어났을때 부수효과들이 분산된다.

    ```java
    class{
        String  군번
    }
    사람 로미오 = new 사람();
    사람 줄리엣 = new 사람();
    줄리엣.군번 = "15-~" ; // ??
    ```

    - 어떤 클래스,메소드,패키지들을 변경해야 하는 이유는 오직 하나뿐이어야한다.
        - 회계패키지가 인사관련기능까지 들어가있으면 안된다.
- OCP
    - 소프트웨어 엔티티(클래스, 모듈, 함수 등)는 확장에 대해서는 개방돼야 하지만 변경에 대해서는 폐쇄돼야 한다.
    - 자신의 확장에는 개방돼 있고, 주변의 변화에 대해서는 폐쇄돼 있어야 한다
    - 운전자 -> 마티즈 : 창문수동개방(), 기어수동조작()
    - 운전자 -> 소나타 : 창문자동개방(), 기어자동조작() - 차를 마티즈에서 소나타로 변경
        - 이는 운전자의 운전습관에 영향을 줌. 개방 폐쇄 원칙에 위배. 운전자가 차종에 따라 운전습관을 바꾸면안됨. (현실세계는 가능)
    - 자동차라는 상위클래스. 하위클래스에 마티즈, 쏘나타. 운전자는 마티즈인지 쏘나타인지 모르고 그냥 기어조작()만 가지고 오버라이딩된 기어조작()을 통해 운전하게됨.
        - 자동차는 자신의 확장에는 개방돼있는 것이고 운전자 입장에서는 주변의 변화에 폐쇄돼 있는 것이다.
    - JDBC 인터페이스가 이를 적용한 사례. 고객이 오라클에서 MySQL로 바꿔도 과거에는 자바 애플리케이션을 뜯어 고쳤지만 이제는 JDBC 인터페이스 덕분에 뜯어고칠 필요가 없다.
    - 자바 inputStream도 또 하나의 예시

- LSP
    - 서브 타입은 언제나 자신의 기반 타입으로 교체할 수 있어야 한다.
    - 객체지향의 상속이라는 특성을 올바르게 활용하면 자연스럽게 얻어지는 것
    - 하위 클래스 is a kind of 상위 클래스 - 하위 분류는 상위 분류의 한 종류다. 펭귄은 동물의 한 종류다.
    - 구현 클래스 is able to 인터페이스 - 구현 분류는 인터페이스 할 수 있어야 한다. 펭귄은 헤엄칠 수 있어야한다.
    - 하위형에서 선행 조건은 강화될 수 없다
    - 하위형에서 후행 조건은 약화될 수 없다
    - 하위형에서 상위형의 불변 조건은 반드시 유지

- ISP
    - 클라이언트는 자신이 사용하지 않는 메서드,클래스,패키지등에 의존 관계를 맺으면 안 된다.
    - 남자를 분할해 남자친구, 사원, 아들, 소대원 클래스를 만드는게 아니라 남자클래스는 냅두고 남자친구 인터페이스, 사원 인터페이스들을 만드는 것이다.
    - 남자친구 정학제 = new 남자();
    - SRP가 더 좋은 솔루션이라고 함

- DIP
    - 고차원 모듈은 저차원 모듈에 의존하면 안 된다. 이 두 모듈 모두 다른 추상화된 것에 의존해야 한다.
    - 추상화된 것은 구체적인 것에 의존하면 안된다. 구체적인 것이 추상화된 것에 의존해야 한다.
    - 자주 변경되는 구체 클래스에 의존하지 마라
    - 자동차 -> 스노우타이어 (겨울). 스노우타이어를 일반타이어로 교체할 때 자동차는 그 영향에 노출.
    - 자동차 -> 타이어 인터페이스. 타이어 하위클래스에 스노우타이어 / 일반타이어 / 광폭타이어
    ```java
    class Car{
        SnowTire st = new SnowTire(); // 타이어가 일반타이어로 변경될 시 Car 클래스에 영향줌. 일반타이어 st = new 일반타이어();
    }

    class Car{
        Tire t = new SnowTire(); // 인터페이스. 이것역시 변경은 해줘야함. new 일반타이어();
    }
    ```

    - new 하는 부분을 car가 직접 받지말고, 외부에서 injection 으로 처리해야한다.
    ```java
    class Car{
        Tire t;

        void setTire(Tire t){ // 스노우타이어가 들어오든, 일반타이어가 들어오든 Car 클래스는 영향안받음.
            this.t = t; // 외부로부터 속성 주입
        }
    }
    ```

    - 자동차는 10년 타야하는데, 타이어는 자주 교체되어야함.
    - 자기보다 구체적인 것들에게 의존하던 것을 역전하여 구체적인 것이 추상적인 것에 의존하도록 한다.
    - 자신보다 변하기 쉬운 것에 의존하지마라!!!
    - 상위 클래스일수록, 인터페이스일수록, 추상클래스일수록 변하지 않을 가능성이 높기에 하위 클래스나 구체 클래스가 아닌 상위 클래스, 인터페이스, 추상클래스를 통해 의존하라는 것이 바로 의존 역전 원칙이다.

## SOC
- 솔리드를 이야기할 때 빼놓을 수 없는 것이 SOC. SOC는 관심사의 분리의 머리글자다. 관심이 같은 것끼리는 하나의 객체 안으로 또는 친한 객체로 모으고, 관심이 다른 것은 가능한 따로 떨어져 서로 영향을 주지 않도록 분리하라는 것이다. 하나의 속성, 하나의 메서드, 하나의 클래스, 하나의 모듈, 또는 하나의 패키지에는 하나의 관심사만 들어있어야 한다는 것이 SoC이다. 관심사가 다르고 변화의 시기가 다르면 분리해야한다. SoC를 적용하면 자연스럽게 단일책임원칙, 인터페이스분리원칙, 개방폐쇄원칙에 도달. 스프링 또한 SoC를 통해 솔리드를 극한까지 적용

# 알고리즘
## 거품 정렬
- 서로 인접한 두 원소 대소 비교하여 크면 swap, 작으면 stay
- 2회전 : 맨 끝 원소가 가장 큼. 이는 제외하고 진행. 이를 반복
- O(n^2) / 안정 정렬 / 비효율적

## 선택 정렬
- 넣을 위치는 이미 정해져있고, 어떤 원소를 넣을지 선택
- 최소값을 찾아서 맨앞에 있는 숫자와 swap
- 2회전부터는 2번째 배열부터 끝까지 최소값 찾고 최소값과 2번째 배열 swap. 이를 반복
- O(n^2) / 불안정 정렬 / 비효율적

## 삽입 정렬
- 두번째 원소부터 시작
- 이전에 있는 원소들과 비교하여 나보다 크면 swap. 작은게 나오면 stay. 이를 반복
- 최선 : O(n) / 최악 : O(n^2) / 안정 정렬 / 최선의 경우 효율적

# HTTP
- 인터넷상의 커뮤니케이션에 사용되는 형식들 중 하나이다. www. 앞에 http:// 와 같이 형식을 써줘야 서버는 내가 보내는 정보를 HTTP 형식으로 읽어본 다음 이런이런 페이지를 보여달라는거구나 하고 알아듣고서 그에 맞는 응답을 보내줍니다. 응답을 받은 내 컴퓨터는 이걸 HTTP 형식에 따라 해독해서 화면을 보여주게 되는 것이다.

## HTTP 요청 프로토콜
- 요청하는 방식을 정의하고 요청 프로토콜 구조, 클라이언트의 정보를 담고 있는
    - Reqeust Line : 첫번째 줄
        - `GET /produ/content.asp?code=sch-v310 HTTP/1.1`
            - 요청타입 + 공백 + URI + 공백 + HTTP 버전
    - Headers : 두번째 줄부터. 옵션같은 것들
    - 공백 : 한줄
    - Body : 데이터를 요청할 때 보내는 추가적인 데이터들

## HTTP Status Code

- 10x : 정보 확인
- 20x : 통신 성공
- 30x : 리다이렉트
- 40x : 클라이언트 오류
- 50x : 서버 오류

## HTTPS

- HTTP + Secure. 안전하다. 내가 어떤 웹사이트에 보내는 정보를 다른 누군가가 훔쳐보지 못한다. 접속한 사이트가 믿을 만한 곳인지를 알려주는 역할을 합니다. 공개키와 개인키를 사용하여 암호를 복호화합니다. 사용자는 공개키로 비밀번호를 암호화해서 서버에게 보내면 서버에 있는 개인키로 이를 복호화합니다. 같은 공개키로는 암호를 풀어낼 수 없습니다. 서버에서 사용자에게 보내는 정보 중 일부는 서버의 개인키로 암호화되어있다. 이는 서버의 공개키로만 풀어서 알아볼 수 있기 때문에 해당 서버가 맞음을 알 수 있다. 클라이언트는 아직 서버를 신뢰하지 못한다. 클라이언트는 어떤 랜덤 데이터를 생성해서 서버로 보낸다. 이걸 받은 서버는 답변으로 역시 서버측에서 생성한 무작위의 데이터, 그리고 해당 서버의 인증서를 실어보낸다. 이를 핸드셰이크라고 한다. 이제 이 클라이언트는 이 인증서가 진짜인지 브라우저에 내장된 CA들의 정보들을 통해 확인한다. CA의 인증을 받은 인증서들은 해당 CA의 개인키로 암호화가 되어있다. 이게 진짜라면 그 브라우저에 저장된 그 CA의 공개키로 복호화할 수 있다. 성공적으로 복호화된 인증서에는 서버의 공개키가 포함되어있다. 핸드셰이크과정에서 서로 무작위 데이터를 주고 받았는데, 클라이언트는 이 둘을 혼합해서 어떤 임시 키를 만든다. 이 임시 키는 앞으로 통신에 사용할 대칭키인데 이를 서버의 공개키로 암호화돼서 서버로 보내집니다. 서버는 이를 자신의 개인키로 복호화합니다. 이후 서버는 이 대칭키를 이용하여 클라이언트에게 보낼 평문을 암호화하여 보냅니다. 즉, 대칭키를 주고받을 때만 공개키 암호화 방식을 사용하고 이후에는 계속 대칭키 암호화 방식으로 통신하는 것 입니다.

## HTTP Method
- GET과 POST를 제외하고 나머지는 보안상 문제가 된다.
### GET
- 서버에게 Resource를 보내도록 요청하는데 사용 (서버의 Resource를 읽음)
- 클라이언트가 서버로부터 문서를 읽어오려 할 때 사용
- 요청하면서 데이터를 보낼 수 있다.
- Read

### HEAD
- GET과 동일하지만 서버에서 Body를 Return 하지 않음
- Resource를 받지 않고 오직 찾기만 원할때
- object가 존재할 경우 응답의 상태 코드를 확인할때
- 서버의 응답 헤더를 봄으로써 Resource가 수정 되었는지 확인
- 페이지의 특정 정보를 보내달라고 함

### PUT
- 서버에 문서를 쓸때 사용 (GET과 반대)
- 클라이언트가 서버에 특정 자원을 업로드할때 사용. PUT을 사용하면 무조건 업로드되므로 보안상 문제가 될 수 있다.
- PUT 메소드는 서버가 Client 요청의 Body를 확인한다.
- 요청된 URL에 정의된 새로운 Resource를 생성하기 위함
- 요청된 URL이 존재할 경우 대체하여 사용
- Create

### POST
- Server에 Input Data를 보내기 위함 (HTML form에 많이 사용)
- 클라이언트가 서버에게 데이터를 보낼 때 사용
- 데이터를 보내면서 요청을 할 수 있다. (GET과 똑같은건가...?)
    - GET은 서버에 데이터를 보낼 때 주소창 URL에 데이터를 포함시켜 보낸다.
        - ~~웹툰인데 목요일꺼를 보여줘.
    - POST는 주소창이 아니라 body에 포함시켜 보낸다.
        - 주소창에 보여지면 안되는 id, password와 같은건 post를 사용한다. 중요 데이터는 get방식으로 하면 안된다.
        - 근데 사실 이것도 보일 수 있으므로 HTTPS를 사용해야한다.
            - 대부분 로그인할때만큼은 HTTPS사용
- Update
- PUT vs. POST
    — PUT은 서버의 Resource에 Data를 저장하기 위한 용도
    — POST는 서버에 DATA를 보내기 위한 용도


### TRACE
- Client로 부터 Request Packet이 방화벽, Proxy Server, Gateway등을 거치면서 packet의 변조가 일어날 수 있는데, 이 때 Server에 도달 했을 때의 최종 Packet의 Request Packet을 볼수 있다.
    - 즉, Original Data와 서버에 도달했을 때의 비교본 Data를 서버의 응답 Body를 통해 확인 할 수 있다.
    - 요청의 최종 수신자는 반드시 송신자에게 200(OK) 응답의 내용(Body)로 수신한 메세지를 반송해야 한다.
    - 최초 Client의 요청에는 Body가 포함될수 없다.

### OPTION
- Target Server의 지원 가능한 method(ex> GET, POST …)를 알아보기 위함

### DELETE
- Delete
- 요청 Resource를 삭제하도록 요청
- 그러나!! HTTP 규격에는 Client의 요청에도 서버가 무효화 시킬수 있도록 정의되어 있음
- DELETE Method는 항상 보장되지 않는다.
- 내가 네이버에 있는 웹툰을 보낼 수 있을까?????
    - 즉 이런건 서버에서 막아놓음
