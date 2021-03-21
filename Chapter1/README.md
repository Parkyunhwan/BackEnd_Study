# OOP

### Q. 객체프로그래밍이란?
*  `상태` 와 `행위` 를 가진 객체 간에 상호작용하여 프로그래밍하는 것
*  강한 응집력과 약한 결합력을 가져, 재사용성 확장성 즉, 유지보수가 용이

절차지향 프로그래밍
  - Top-down 방식
  - 특정기능을 수행하려면 그 일을 해주는 메소드를 직접 호출
  - (vs 객체지향에서는 특정 기능을 수행하는 메소드를 가진 객체를 만들어서, 그 인스턴스를 이용해 메소드 호출)


### Q. 클래스와 객체란
- 객체 : 속성과 행동으로 구성되어 있는 하나의 단위
- 클래스 : 객체를 만드는 설계도
- 인스턴스 : 클래스를 new 명령문으로 메모리에 생성한 객체

우리가 프로그래밍으로 표현하려는 실체는 객체,
이러한 실체를 추상화한 설계도는 클래스
클래스를 인스턴화하여 객체가 생성

### Q. 추상클래스와 인터페이스
- 공통점 : 선언만 있고 구현 내용이 없다. 새로운 인스턴스(객체)생성 X

`추상클래스`
  - 상속을 통해서 자손 클래스에서 완성하도록 유도
  - abstract, 0개 이상의 추상메소드(아직 구현되지 않는 메소드), 일반메소드, 일반 변수 가질수 있음

`인터페이스`
  - 다중상속, 설계도(=명세)
  - 모든 메소드가 추상메소드, 일반변수 가질수없음

### Q. 객체지향의 특징

추상화, 캡슐화, 상속, 다형성이 있습니다.
`추상화`는 불필요한 정보는 빼고 공통적인 속성을 하나의 개념으로 다루는 것

`캡슐화`는 외부에서 객체의 특정 속성이나 메서드를 접근하지 못하게 하는 것. 이를 통해 객체 내부가 변경되도 외부의 다른 객체에 영향을 주지 않는 것

`상속` 은 부모 클래스의 속성과 기능을 이어 받아 코드를 재사용하고 기능을 수정하거나 확장할 때 상속 받은 클래스만 수정해서 사용할 수 있음

`다형성` 은 같은 메시지로 요청을 받았을 때 서로 다른 방식으로 처리하는 것을 뜻

### Q. 객체지향의 설계원칙

- SRP

`단일 책임 원칙`은 모든 클래스는 하나의 책임만을 가진다는 뜻.
이는 변경 발생 시 다른 객체에 영향을 주지 않기 때문에 유지보수성을 높힐 수 있음 
또한 응집도는 높고 결합도는 낮은 프로그램을 만들 수 있음

- OCP

`개방 폐쇄 원칙`은 확장에는 열려있고 수정에는 닫혀있다는 뜻
요구사항 변경 시 기존의 코드를 변경하지 않고 기능을 추가할 수 있는 설계

- LSP

`리스코프 치환 법칙`은 자식클래스가 부모 클래스를 대체할 수 있다는 뜻
자식클래스는 부모 클래스의 책임(기능)을 변경하지 않고 오직 확장만을 수행

- ISP

`인터페이스 분리 원칙`은 하나의 클래스가 자신이 사용하지 않는 인터페이스를 구현하지 않는 것
다시 말해서, 자신이 사용하지 않는 기능에 영향을 받지 않도록 하는 것


# HTTP

### Q. HTTP란 
인터넷에서 데이터를 주고 받는데 사용되는 프로토콜(규약)

### Q. HTTP 특징
`비연결성`
  - 클라이언트와 서버가 한번 연결을 맺은 후, 클라이언트 요청에 대해 서버가 응답을 마치면 맺었던 연결을 끊어 버리는 성질
  - 장점 
    - 연결을 유지하기 윈한 리소스를 줄이면 더 많은 연결을 할 수 있으므로
   - 단점
    - 연결/해제에 대한 오버헤드가 발생
    - 오버헤드를 줄이기 위해 KeepAlive 속성을 사용
      (지정된 시간동안 서버와 클라이언트 사이에서 패킷 교환이 없을 경우, 안부를 묻기위해 패킷을 주기적으로 보냄)
      
`무상태`
 - 비연결성에 해서 HTTP는 이전의 상태정보나 현재 통신의 상태가 남아있지 않음
 - http dycjddms 독립적이며 서버는 클라이언트 상태를 기억하지 못함
  

### Q. METHOD

* Get : 정보를 요청하기 위해 (read)
        캐싱이 가능
        필요한 데이터를 Body가 아닌 쿼리 스트링을 통해 전송
        ex) www.example-url.com/resource?name1=value1&name2=value2
* Post : 정보를 입력하기 위해 (create)
         데이터가 Body로 전송, 크롬개잘바도구를 통해 내용확인가능, 암호화 필요

* Put : 정보를 업데이트하기 위해 (update),자원 내 필드를 전체 수정
* Patch: 요청된 자원을 수정할떄, 자원 내 필드를 일부 수정
* Delete : 정보를 삭제하기 위해 (delete)
* Options : 서버에게 특정 리소스가 어떤 메소드를 지원하는지

-> Spring일경우 web.xml 등을 통해 메소드를 제한할 수 있다.

# 정렬

### Q. 선택정렬

* 해당 순서에 원소를 넣을 위치는 이미 정해져 있고, 어떤 원소를 넣을지 선택하는 알고리즘

1.  주어진 배열 중에 최소값을 찾습니다.
2. 그 값을 맨 앞에 위치한 값과 교체합니다. (pass)
3. 맨 처음 위치를 뺀 나머지 배열을 같은 방법으로 교체합니다.

* 선택 정렬 시간 복잡도 / 공간 복잡도
  *  시간 복잡도 최선, 평균, 최악 : O(n^2)
     *  첫번 째 회전 때 비교 횟수 : 1~(n-1)
     *  두번 째 회전 때 비교 횟수 : 2~(n-2)
  *  공간 복잡도 : 교환을 통해 정렬이 수행되므로 O(n)


### Q. 삽입정렬

* 번째 원소부터 시작하여 그 앞(왼쪽)의 원소들과 비교하여 삽입할 위치를 지정한 후, 원소를 뒤로 옮기고 지정된 자리에 자료를 삽입

1. 정렬은 2번째 위치(index)의 값을 temp에 저장합니다.
2. temp와 이전에 있는 원소들과 비교하며 삽입해나갑니다.
3. '1'번으로 돌아가 다음 위치(index)의 값을 temp에 저장하고, 반복합니다.

* 삽입 정렬 시간 복잡도 / 공간 복잡도

  * 시간 복잡도 최선 : O(n)
  * 시간 복잡도 평균, 최악 : O(n^2)
  * 공간 복잡도 : 교환을 통해 정렬이 수행되므로 O(n)


### Q. 거품정렬


* 서로 인접한 두 원소의 대소를 비교하고, 조건에 맞지 않다면 자리를 교환하며 정렬하는 알고리즘

1. 1회전에 첫 번째 원소와 두 번째 원소를, 두 번째 원소와 세 번째 원소를, 세 번째 원소와 네 번째 원소를, … 이런 식으로 (마지막-1)번째 원소와 마지막 원소를 비교하여 조건에 맞지 않는다면 서로 교환합니다.
2. 1회전을 수행하고 나면 가장 큰 원소가 맨 뒤로 이동하므로 2회전에서는 맨 끝에 있는 원소는 정렬에서 제외되고, 2회전을 수행하고 나면 끝에서 두 번째 원소까지는 정렬에서 제외됩니다. 이렇게 정렬을 1회전 수행할 때마다 정렬에서 제외되는 데이터가 하나씩 늘어납니다.

* 거품 정렬 시간 복잡도 / 공간 복잡도
  * 시간 복잡도 최선, 평균, 최악 : 정렬이 되어 있던, 되어 있지 않던 두 개의 원소를 배열 끝까지 비교하므로 O(n^2)

  * 공간 복잡도 : 교환을 통해 정렬이 수행되므로 O(n)





