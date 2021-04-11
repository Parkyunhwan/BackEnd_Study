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

