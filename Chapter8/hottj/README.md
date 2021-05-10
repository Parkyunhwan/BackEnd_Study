# IPC
- PIPE
    - 하나의 프로세스는 쓰기만, 하나의 프로세스는 읽기만
    - 둘다하려면 파이프 2개로 -> 구현 어려움
    - 통신할 프로세스를 명확하게 알때
- Named PIPE
    - 전혀 모르는 상태의 프로세스 사이의 통신
- 메시지큐
    - 프로듀서 , 컨슈머
    - 메모리공간
    - 메시지큐에 쓸 데이터에 번호를 붙임
- 공유 메모리
    - 데이터를 아예 공유
- 메모리맵
    - 열린 파일을 메모리에 매핑시켜서 공유
- 소켓
- 세마포어
    - 프로세스간 데이터 동기화
[참고](https://jwprogramming.tistory.com/54)

# Call by Value vs Call by Reference
[참고](http://mussebio.blogspot.com/2012/05/java-call-by-valuereference.html)

# Primitive vs Reference Type
- 자바
    - 원시 자료형 (primitive type) : call-by-value 로 동작 (int, short, long, float, double, char, boolean )
    - 참조 자료형 (reference type): call-by-reference 로 동작 (Array, Class Instance)
[참고](https://wayhome25.github.io/cs/2017/04/11/cs-13/)

# Java Collection
[참고](https://velog.io/@gillog/Collections-%ED%81%B4%EB%9E%98%EC%8A%A4)

# JDBC / SQLMAPPER / ORM
- 공통점
    - 영속성
        - 데이터를 생성한 프로그램의 실행이 종료되더라도 사라지지 않는 데이터의 특성
            - 영구히 저장되는 그 어떤 것
            - 램에 저장(휘발성)

- JDBC
    - JDBC API
    - DB 커넥터에 대한 니즈로 자바 진영의 데이터베이스 연결 표준 인터페이스
    - 드라이버 매니저가 커넥션 객체를 얻고, 커넥션을 통해서 statement를 얻고 statement를 이용해 resultset을 얻음
    - 불편한 점
        - 커넥션 객체를 관리
        - 중복 코드 많음
        - SQL 일일이 입력
- SQLMAPPER
    - MyBatis
        - SQL 분리하자!
        - 쿼리를 자바에서 xml로
        - 복잡한 jdbc 코드 x
        - resultset과 같이 결과값을 매핑하는 객체 x
        - 간단한 설정
        - 관심사 분리
        - 자바 단에서는 쿼리를 모르지만 xml에 매핑되어 있다
    - Spring JDBC
        - JDBC를 한단계 더 추상해놓음
        - DataSource
        - JDBC Temmplate
        - RowMapper
        - 불편한 것들을 많이 추상화 시킴
- ORM
    - JPA
    - Hibernate
    - DATA JPA
        - 레포지토리
        - 자바 JPA보다 한단계 더 추상화
    - Spring DATA JDBC
        - 레포지토리
        - SIMPLE
        - DDD
            - 뭉탱이로 넣고 뺌
        - 엔티티매니저같은거 안쓰고 JDBC API를 추상화
    - 객체지향으로 가자!!!!!

    ```java
    public class Crew{
            private int id;
            private String name;
    }
    ```

    ```java
    public class Crew{
        private int id;
        private String name;
        private String nickname; // 추가
    }
    ```
    아래로 변경이 일어남

    - sql문이 "Insert into CREW(CREW_ID,NAME,NICKNAME) VALUES(?,?,?)";로 바뀜
    - SELECT crew_id,name,nickname from crew where crew_id=?

    ```java
        public class Crew{
        private int id;
        private String name;
        private String nickname;
        private Team team; // RDBMS에서 객체를 갖는게 가능한가...?
    }
    ```
    - 물리적으로 SQL과 JDBC API를 데이터 접근 계층에 숨기는데 성공했을지는 몰라도 논리적으로는 엔티티와 아주 강한 의존 관계를 가지고 있다
    - 엔티티를 변경하면 DB도 변경이 일어나고 DB를 변경하면 엔티티도 변경이 일어나게된다
    - JPA
        - 엔티티매니저
        - 영속성 컨텍스트
        - lazy loading
            - 필요한 것만 가져오자
        - dirty check
            - 어디어디 바뀌었나
        - 캐싱
            - 디비까지 안가고 캐시에 있으면 바로줌