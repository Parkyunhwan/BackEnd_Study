# final

### final 클래스

final이 클래스에 사용되면 더 이상 클래스를 상속받을 수 없다.

### final 메서드

메서드 앞에 final 속성이 붙으면 이 메서드는 더 이상 오버라이딩 할 수 없음

### final 필드

필드 멤버에 final 키워드를 덧붙여 상수를 정의할 수 있다.

- final로 상수 필드 정의하면 단 한번 초기화가 가능하다.

1. final 멤버 변수가 반드시 상수는 아니다. (한번만 초기화 가능하기 때문)

```java
public class Test {
  private final int value;

  public Test(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
```

생성자를 통해 value가 초기화 되기 때문에 이 클래스의 인스턴스들은 각기 다른 value값을 갖게 된다.

**따라서, 인스턴스 안에서는 상수이지만 클래스 레벨에서 통용되는 상수는 아니다.**

# static 키워드

> static은 해당 데이터의 메모리 할당을 컴파일 시간에 할 것임을 의미

static은 동적데이터와 달리 프로그램 실행 직후 생성되어 끝날 때까지 메모리 수명이 유지된다.

- static 멤버 변수
    - 클래스 변수이다.
    - 특정 인스턴스에 종속되지 않고 모든 해당 클래스는 같은 메모리를 공유해 static멤버 변수에 접근한다.
    - 인스턴스를 만들지 않고 사용가능.
- static 메서드
    - 클래스 메서드이며 인스턴스를 만들지 않고 사용가능
    - 오버라이드 불가능하며 상속 클래스에서 보이지 않는다.
- static 블록
    - 클래스 내부에 만들 수 있는 초기화 블록!
    - 클래스 초기화 시 실행됨. (main보다 먼저 실행)

### static final로 지정하는 의도

- **인스턴스가 만들어질 때마다 새로 메모리를 잡고 클래스 레벨에서 한 번만 잡아서 메모리 공간을 사용 (static)**
- **한번 초기화 된 이후에 변경되지 않음 (final)**

클래스 레벨에서 모두 같은 값을 변경없이 사용할 때 사용

### final 멤버 변수에 static을 사용하지 않는 경우

- Dependency Injection

    ```java
    public class MovieRecommender {

        private final CustomerPreferenceDao customerPreferenceDao;

        @Autowired
        public MovieRecommender(CustomerPreferenceDao customerPreferenceDao) {
            this.customerPreferenceDao = customerPreferenceDao;
        }

        // ...
    }
    ```

    소비자 선호도 조사는 항상 정해져 있는 상수가 아니다.

    초기화 시 의존 관계 주입이 결정되게 된다. (static 사용하면 컴파일 타임에서 결정)

# Blocking Vs Non-Blocking

### Blocking

Blocking I/O 모델에서는 System Call 이 끝날 때까지 프로그램은 대기해야하고 System Call이 완료되면 그때 리턴을 한다.

ex) C언어 scanf()를 사용하면 사용자가 입력하기 전까지 대기한 상태로 return하지 않는다.

### Non-Blocking

System Call이 완료되지 않아도 대기하지 않고 Return 한다.

- 둘의 가장 큰 차이점은 프로그램이 대기하지 않고 바로 실행할 수 있는지 여부이다.

# 동기 vs 비동기

- 동기는 요청 후 응답이 올 때 까지 아무것도 하지 않고 대기한다.
- 비동기는 요청 후 응답이 오지 않아도 다른 일을 하다가 응답이 오면 그 때 결과물을 가져온다.
    - 주로 call back 함수를 통해 결과물을 가져옴

## 락

멀티스레드 프로그래밍을 위해 스레드 동기화 필요

여러 개의 스레드가 프로세스 자원을 공유하면서 작업하는 경우 서로의 작업에 영향을 주기 때문.

- lock은 단 하나의 스레드만이 가질 수 있고, 임계영역 내에서 수행할 코드를 수행한 이후 lock을 반납해야만 한다.

- 임계영역(critical section) : 공유 자원에 대해 단 하나의 스레드만 접근할 수 있는 영역
- 뮤텍스 :
- 세마포어 : 한정된 개수의 자원을 여러 스레드가 사용하려고 할 때 제한
- 대기 가능 타이머 : 특정 시간이 되면 대기중이던 스레드를 깨운다.

- **synchronized를 이용한 동기화 방법**
    - 메서드에 synchronized를 걸어 임계영역을 설정할 수 있다.
