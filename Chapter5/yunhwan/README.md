### JVM이란?

자바 가상머신으로서 소프트웨어로 구현한 물리적 머신이라고 볼수 있다.

- **JVM의 역할**
    - 자바 애플리케이션을 클래스 로더를 통해 읽어들이고 자바 API와 함께 실행하는 역할
- **JVM의 특징**
    - JAVA와 OS사이에서 **중개자** **역할** 수행 (OS 종속적이지 않음)
    - Garbage Collection을 통해 메모리 관리를 해준다.
- **JVM 구성**
    - Class Loader
        - 생성한 인스턴스가 Runtime시점에 메모리에 로드하게 함
    - Runtime Data Areas
        - JVM이 프로그램을 수행하기 위해 별도로 할당받은 메모리 공간
            - PC Register, Java Virtual Machine Stack, Native Method Stack, Method Area, Heap
    - Execution Engine
        - Runtime Data Areas에 로드된 바이트 코드가 Execution Engine에 의해서 실행됨

### 자바프로그램의 실행 과정

1. 프로그램 실행 시 JVM이 OS로 부터 프로그램에 필요한 메모리를 할당받는다.
2. 자바 소스코드를 자바 컴파일러가 바이트코드로 변환시킨다.
3. **클래스 로더**를 통해 바이트코드로 변환된 클래스 파일들을 로딩한다.
4. 로딩된 클래스 파일이 을 통해 해석된다.

    **Execution engine**

5. 해석된 바이트코드가 에 배치되어 프로그램의 동작이 이뤄진다.

    **Runtime Data Areas**

### Interpreter

Execution Engine이 바이트 코드를 명령어 단위로 읽어서 수행한다. 한 줄씩 수행하기 때문에 느리다는 단점이 있다.

### JIT(Just In Time)

인터프리터 방식으로 프로그램을 수행하다가 일정한 기준을 넘어가면 바이트 코드 전체를 컴파일하여 네이티브 코드로 변환시킨다. 이 후 인터프리터 방식을 사용하지 않고 네이티브 코드를 바로 실행한다. JIT를 사용하는 JVM은 해당 메서드가 얼마나 자주 사용되는지 체크하고 일정기준을 넘어서면 컴파일을 수행하게 된다.

### JDK

Java Development Kit의 약자로 자바 개발 시 필요한 툴킷을 제공하는 도구 모음이다.
JDK 안에는 실행환경인 JRE가 포함되어있다.

### JRE

자바 프로그램 실행 환경을 구성해주는 도구. JAVA로 개발할 필요는 없고 실행만 필요할 때 JRE가 필요하다.


