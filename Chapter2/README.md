# :book: :two:주차 정리

### ✔️ TCP vs UDP
- 공통점
  - 포트 번호를 이용하여 주소를 지정한다.
    - 두 애플리케이션이 통신하기 위해 반드시 포트 번호를 결정해야 한다.
  - 데이터 오류를 체크한다. (헤더에 체크섬이 존재)
    - IP가 제공하는 오류 체크 기능은 프로토콜 동작을 위해 반드시 필요한 부분에만 국한된다. 즉 IP헤더에 대한 오류는 체크하지만 데이터에 대한 오류는 체크하지 않는다. 반면, TCP와 UDP는 헤더와 데이터에 대한 오류를 체크한다. 
- 차이점
  - TCP / UDP
  - 연결형 / 비연결형
  - 데이터 경계를 구분x / 데이터 경계를 구분
  - 신뢰적 / 비신뢰적
  - 1대1 통신 / 1대1, 1대다, 다대다 통신
  - 속도가 느림 /  속도가 빠름
  - 패킷 관리가 필요x / 패킷 관리 필요
  - 데이터의 전송 순서 보장 / 데이터의 전송 순서 보장하지 않음
  - 데이터 수신 여부 확인 / 데이터 수신 여부 확인하지 않음

- 3way handshaking
  - [STEP 1]
    - A클라이언트는 B서버에 접속을 요청하는 SYN 패킷을 보낸다. 이때 A클라이언트는 SYN 을 보내고 SYN/ACK 응답을 기다리는SYN_SENT 상태가 되는 것이다.
  - [STEP 2] 
    - B서버는 SYN요청을 받고 A클라이언트에게 요청을 수락한다는 ACK 와 SYN flag 가 설정된 패킷을 발송하고 A가 다시 ACK으로 응답하기를 기다린다. 이때 B서버는 SYN_RECEIVED 상태가 된다.
  - [STEP 3]
    - A클라이언트는 B서버에게 ACK을 보내고 이후로부터는 연결이 이루어지고 데이터가 오가게 되는것이다. 이때의 B서버 상태가 ESTABLISHED 이다. 
  - 위와 같은 방식으로 통신하는것이 신뢰성 있는 연결을 맺어 준다는 TCP의 3 Way handshake 방식이다.
  <img width="617" alt="스크린샷 2021-03-24 오후 7 32 22" src="https://user-images.githubusercontent.com/47052106/112296085-e56e4b00-8cd7-11eb-9c63-61be99e140e0.png">
- 4way handshaking
  - [STEP 1]
    - 클라이언트가 연결을 종료하겠다는 FIN플래그를 전송한다.
  - [STEP 2] 
    - 서버는 일단 확인메시지를 보내고 자신의 통신이 끝날때까지 기다리는데 이 상태가 TIME_WAIT상태다.
  - [STEP 3]
    - 서버가 통신이 끝났으면 연결이 종료되었다고 클라이언트에게 FIN플래그를 전송한다.
  - [STEP 4]
    - 클라이언트는 확인했다는 메시지를 보낸다. 그런데 만약 "Server에서 FIN을 전송하기 전에 전송한 패킷이 Routing 지연이나 패킷 유실로 인한 재전송 등으로 인해 FIN패킷보다 늦게 도착하는 상황"이 발생한다면 어떻게 될까요? 
Client에서 세션을 종료시킨 후 뒤늦게 도착하는 패킷이 있다면 이 패킷은 Drop되고 데이터는 유실될 것입니다. 이러한 현상에 대비하여 Client는 Server로부터 FIN을 수신하더라도 일정시간(디폴트 240초) 동안 세션을 남겨놓고 잉여 패킷을 기다리는 과정을 거치게 되는데 이 과정을 "TIME_WAIT" 라고 합니다.
<img width="605" alt="스크린샷 2021-03-24 오후 7 32 47" src="https://user-images.githubusercontent.com/47052106/112296068-e1422d80-8cd7-11eb-8a27-0fcde8cb35eb.png">

- 클라이언트가 ACK을 받지 못하면?
  - 일정 시간이 지나고도 ACK을 받지 못하면 데이터를 재전송한다.
  
- PDU
  - PDU(Protocol Data Unit)은 통신 프레임을 의미한다. TCP의 PDU는 Segment라고 부르고 UDP의 PDU는 Datagram이라고 하고 IP의 PDU는 Packet이라고 한다. IP 아래 계층의 Link 계층의 PDU를 Frame이라고 한다. Link 계층에 Ethernet이 사용될 때의 PDU는 Ethernet Frame이라고 한다.

### ✔️ REST API
- REST?
  - 개발자들 사이의 규약
- RESTful API
  - 첫 번째, URI는 정보의 자원을 표현해야 한다.
  - 두 번째, 자원에 대한 행위는 HTTP Method(GET, POST, PUT, DELETE)로 표현한다.
- 사용 이유
  - 일관성, 쉬운 유지보수, URI만 봐도 무슨 행위인지 추측
- 특징
  - Uniform (유니폼 인터페이스)
    - Uniform Interface는 URI로 지정한 리소스에 대한 조작을 통일되고 한정적인 인터페이스로 수행하는 아키텍처 스타일을 말합니다.
  - Stateless (무상태성)
    - REST는 무상태성 성격을 갖습니다. 다시 말해 작업을 위한 상태정보를 따로 저장하고 관리하지 않습니다. 세션 정보나 쿠키정보를 별도로 저장하고 관리하지 않기 때문에 API 서버는 들어오는 요청만을 단순히 처리하면 됩니다. 때문에 서비스의 자유도가 높아지고 서버에서 불필요한 정보를 관리하지 않음으로써 구현이 단순해집니다.
  - Cacheable (캐시 가능)
    - REST의 가장 큰 특징 중 하나는 HTTP라는 기존 웹표준을 그대로 사용하기 때문에, 웹에서 사용하는 기존 인프라를 그대로 활용이 가능합니다. 따라서 HTTP가 가진 캐싱 기능이 적용 가능합니다. HTTP 프로토콜 표준에서 사용하는 Last-Modified태그나 E-Tag를 이용하면 캐싱 구현이 가능합니다.
  - Self-descriptiveness (자체 표현 구조)
    - REST의 또 다른 큰 특징 중 하나는 REST API 메시지만 보고도 이를 쉽게 이해 할 수 있는 자체 표현 구조로 되어 있다는 것입니다.
  - Client - Server 구조
    - REST 서버는 API 제공, 클라이언트는 사용자 인증이나 컨텍스트(세션, 로그인 정보)등을 직접 관리하는 구조로 각각의 역할이 확실히 구분되기 때문에 클라이언트와 서버에서 개발해야 할 내용이 명확해지고 서로간 의존성이 줄어들게 됩니다.
  - 계층형 구조
    - REST 서버는 다중 계층으로 구성될 수 있으며 보안, 로드 밸런싱, 암호화 계층을 추가해 구조상의 유연성을 둘 수 있고 PROXY, 게이트웨이 같은 네트워크 기반의 중간매체를 사용할 수 있게 합니다.
- 단점
  - [링크](https://wallees.wordpress.com/2018/04/19/rest-api-%EC%9E%A5%EB%8B%A8%EC%A0%90/)

### ✔️ HTTPS
- https?
  - http + secure
  - 제3자가 정보를 가로채지 못하게
  - 서버가 신뢰할 수 있는 곳인지
- 동작원리 (Client 는 크롬과 같은 브라우저를 사용하는데 네이버서버를 접속한다고 가정)
  - 1. Client -> Server  신뢰할수없어 무작위 데이터 보냄
  - 2. Client <- Server  네이버의 무작위 데이터와 해당 서버의 인증서를 보냄
  - 3. Client측 : 이 인증서를 확인하기 위해 브라우저에 내장된 CA 정보를 확인 Server에서 보낸 인증서 내에 CA_개인키로 암호와되어있고, 브라우저에 있는 CA_공개키로 복호화
  - 4. 성공적으로 복호화되면 그 속에 서버의 공개키가 포함 
  - 5. Clinet -> Server :  처음에 보낸 무작위 데이터를 합쳐 임시 키를 만든다. 이를 서버의 공개키로 암호화해서 서버로 보낸다
  - 6. Server : 서버의 개인키로 복호화하여 임시키를 가져온다. 이를 앞으로 대칭키로 활용한다.
  - 요점은, 대칭키를 공유할때는 비대칭키 시스템을 사용한다는 것이다. 비대칭키로 암호화하고 복호화하는 작업은 시간이 오래걸리므로 이후로 데이터를 주고받는건 보다 빠른 대칭키 시스템을 이용!!!

### ✔️ 퀵정렬과 병합정렬
- 퀵 정렬
  - 첫번째 원소를 pivot
  - 왼쪽에서부터 pivot보다 큰 데이터 선택. 오른쪽에서부터 pivot보다 작은 데이터 선택. 두 데이터 swap
  - 큰 데이터와 작은 데이터의 위치가 서로 엇갈리는 시점에 pivot과 두 데이터중 작은 데이터를 swap
  - 이제 pivot을 기준으로 왼쪽은 전부 pivot보다 작고 오른쪽은 pivot보다 큼. <분할>
  - 위의 과정을 왼쪽과 오른쪽 각각 재귀적으로 반복. 왼쪽 그룹의 첫번째 원소가 pivot, 오른쪽 그룹의 첫번째 원소가 pivot이 된다.
  - 평균 : O(n^logn), 최악 : O(n^2) (분할이 일어나지 않으므로) / 불안정 정렬
  - 최악의 경우는, 정렬되어 있는 경우이다. 분할이 균등하게 일어나지 않을 수록 오래걸린다
  - pivot은 항상 첫번째 원소로???
    - [median of three quick sort](https://m.blog.naver.com/occidere/220870294816)
- 병합 정렬
  - 분할 정복
  - 데이터가 하나씩으로 나눠질 때까지 분할
  - 2의 배수로 데이터를 묶으면서 정렬 수행. 하나씩 있던 데이터 두개를 정렬(2개 데이터 정렬). 두개씩 있는 데이터를 정렬(4개 데이터 정렬). 4개씩 있는 데이터를 정렬(8개 데이터 정렬)...
  - 정렬할때, 두 덩어리 데이터를 각각 인덱스 i와 j를 사용하여 정렬 수행. i와 j 인덱스 데이터 비교. i 데이터가 작으면 이를 맨 앞에 넣고, i+1로 인덱스이동. 이를 다시 j인덱스 데이터와 비교... (각 덩어리 데이터는 이미 정렬이 되어있으므로 i 데이터보다 i+1 데이터가 크다는 것을 보장)
  - O(n^logn) / 안정 정렬
