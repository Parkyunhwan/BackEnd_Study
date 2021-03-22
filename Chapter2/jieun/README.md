# 2 주차

## 1. TCP/UDP
- **개념**
    - TCP : 
        - Transmission Control Protocol
        - 연결 지향적 프로토콜 : 클라이언트와 서버가 연결된 상태에서 데이터를 주고 받는 프로토콜
        - 사전에 3-way handshake라는 과정을 통해 연결을 설정하고 통신 시작
        - 4-way handshake 과정을 통해 연결을 해제
        - 흐름 제어, 혼잡 제어, 오류 제어를 통해 신뢰성 보장하지만 속도는 UDP보다 느림
        - 데이터 전송 순서를 보장, 수신 여부 확인 가능
        - P2P socket 통신 등 네트워크를 통한 통신을 할 때 많이 사용

    - UDP : 
      - User Datagram Protocol
      - 전송계층의 비연결 지향적 프로토콜 : 연결 절차를 거치지 않고 발신자가 일방적으로 데이터를 발신 -> 속도는 빠르지만 신뢰성 떨어짐
      - 중간에 패킷이 유실이나 변조가 되어도 재전송을 하지 않음

- **TCP 흐름 제어**
- 송신측과 수신측 사이의 데이터 처리 속도 차이를 해결하기 위한 기법
    - Stop and Wait
      - 매번 전송한 패킷에 대한 확인 응답을 받아야 그 다음 패킷을 전송 가능 -> 비효율적
  
    - Sliding Window
      - 수신측에서 설정한 윈도우 크기만큼 송신측에서 확인 응답 없이 세그먼트를 전송 가능. 데이터 흐름 동적으로 조절할 수 있음

- **TCP 오류 제어**
- ARQ(Automatic Repeat Request)기법을 통해서 프레임이 손상되었거나 손실되었을 경우 재전송을 통해 오류를 복구
  
  - Stop and Wait ARQ
    - 송신측에서 1개의 프레임을 송신하고 수신측에서 수신된 프레임의 에러 유무 판단에 따라 ACK/NAK를 보내는 방식
    - NAK -> 재전송
    - ACK 분실 -> 타임 아웃 -> 재전송
  
  - Go-Back-n ARQ
    - 프레임 손상/ACK 분실로 인한 타임 아웃 -> 확인된 마지막 프레임 이후로 모든 프레임 재전송
    - ACK -> 다음 프레임 전송
    - NAK -> 전송된 프레임 자체 번호를 반환


- **TCP 혼잡 제어**
- 네트워크 내의 패킷 수가 넘치게 증가하지 않도록 방지

    <br>
    </br>

## 2. HTTPS
- **개념**
   - HTTP 통신하는 소켓 부분을 인터넷 상에서 정보를 암호화하는 SSL라는 프로토콜로 대체한 것
   - 웹 서버와 클라이언트 간의 문서를 교환하기 위한 통신 규약인 HTTP는 도청, 위장, 변조가 가능하므로 보안성을 높히기 위해 HTTPS 등장
   - HTTP->SSL->TCP 통신
   - 대칭키 암호화 방식과 공개키 암호화 방식 모두 사용
   <br>
   </br>

- **통신 흐름(SSL handshake)**
1) 애플리케이션 서버(A)를 만드는 기업은 HTTPS를 적용하기 위해 공개키와 개인키를 만든다.

2) 신뢰할 수 있는 CA 기업을 선택하고, 그 기업에게 내 공개키 관리를 부탁하며 계약을 한다.

***CA란?*** : Certificate Authority로, 공개키를 저장해주는 신뢰성이 검증된 민간기업

3) 계약 완료된 CA 기업은 해당 기업의 이름, A서버 공개키, 공개키 암호화 방법을 담은 인증서를 만들고, 해당 인증서를 CA 기업의 개인키로 암호화해서 A서버에게 제공한다.

4) A서버는 암호화된 인증서를 갖게 되었다. 이제 A서버는 A서버의 공개키로 암호화된 HTTPS 요청이 아닌 요청이 오면, 이 암호화된 인증서를 클라이언트에게 건내준다.

5) 클라이언트는 `main.html` 파일을 달라고 A서버에 요청했다고 가정하자. HTTPS 요청이 아니기 때문에 CA기업이 A서버의 정보를 CA 기업의 개인키로 암호화한 인증서를 받게 된다.

CA 기업의 공개키는 브라우저가 이미 알고있다. (세계적으로 신뢰할 수 있는 기업으로 등록되어 있기 때문에, 브라우저가 인증서를 탐색하여 해독이 가능한 것)

6) 브라우저는 해독한 뒤 A서버의 공개키를 얻게 되었다. 이제 A서버와 통신할 대는 얻은 A서버의 공개키로 암호화해서 요청을 날리게 된다.
    <br>
    </br>


## 3. REST API

- **개념**
    - Representational State Transfer의 약자
    - 웹의 장점을 최대한 활용할 수 있는 Client와 Server 간 통신 방식 중 하나
    - 설계된 기본 규칙으로 URL를 통해 자원을 명시하고 HTTP method를 통해 자원을 처리하도록 설계
    <br>
    </br>

    <br>
    </br>

## 4. Quick 정렬

- **퀵 정렬이란?**
    - 분할 정복 알고리즘(Divide and Conquer)의 하나로 매우 빠른 수행 속도가 특징
    - 합병 정렬(Merge Sort)과 달리 리스트를 비균등하게 분할한다.

    1. 배열 가운데서 하나의 원소를 고른다. 이렇게 고른 원소는 피벗(pivot)이라고 한다.
    2. 피벗 앞에는 피벗보다 값이 작은 모든 원소들이 오고, 피벗 뒤에는 피벗보다 값이 큰 모든 원소들이 오도록 피벗을 기준으로 배열을 둘로 나눈다. 이렇게 배열을 둘로 나누는 것을 분할(Divide)이라고 한다. 분할을 마친 뒤에 피벗은 더 이상 움직이지 않는다.
    3. 분할 된 두 개의 작은 배열에 대해 재귀적으로 이 과정을 반복한다.
    <br>
    </br>

- **삽입 정렬의 시간 복잡도**
    - 시간 복잡도 최선, 평균 : O(nlogn)
      - 순환 호출의 깊이(logn) * 순환 호출 단계의 비교 연산(n) = nlogn
    - 시간 복잡도 최악 : O(n^2)
      - 순환 호출의 깊이(n) * 순환 호출 단계의 비교 연상(n) = O(n^2)
    <br>
    </br>

## 5. Merge 정렬

- **합병 정렬이란?**
    - 분할 정복 방법(Divide and Conquer)을 통해 구현
    - 입력 데이터가 무엇이든 간에 정렬되는 시간은 동일 -> O(nlogn)

    1. 입력 배열을 같은 크기의 2개의 부분 배열로 분할한다.
    2. 부분 배열을 정렬한다. 부분 배열의 크기가 충분히 작지 않으면 순환 호출을 이용하여 다시 분할 정복 방법을 적용한다.
    3. 정렬된 부분 배열들을 하나의 배열에 합병한다.
    <br>
    </br>

- **거품 정렬의 시간 복잡도**
    - 시간 복잡도 최선, 평균, 최악 : O(nlogn)
    <br>
    </br>