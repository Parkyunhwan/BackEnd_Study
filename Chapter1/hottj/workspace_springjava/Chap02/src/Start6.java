public class Start6 extends Thread {
	static int share;

	public static void main(String[] args) {
		Start6 t1 = new Start6();
		Start6 t2 = new Start6();

		t1.start();
		t2.start();
	}

	public void run() {
		for (int count = 0; count < 10; count++) {
			System.out.println(share++);

			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}

// 멀티 스레드는 T 메모리 모델의 아래 왼쪽인 스택 영역을 스레드 개수만큼 분할해서 쓰는 것
// 멀티 프로세스는 다수의 T 메로리를 갖는 구조

// 멀티 스레드 전역변수 공유로 인한 낭패
// 해결법 - 전역변수 사용하지 않는다. or 락 사용
// 락 사용은 멀티 스레드의 장점을 버린 것과 마찬가지. 락의 busy waiting으로 인한 메모리 사용량 증가 -> 멀티스레드의 장점은 멀티프로세스에 비해 메모리를 아낀 다는 장점.
// 으로 추측...