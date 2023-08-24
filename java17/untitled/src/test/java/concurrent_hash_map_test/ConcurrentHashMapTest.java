package concurrent_hash_map_test;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.jupiter.api.Test;

/**
 * packageName :  PACKAGE_NAME
 * fileName : concurrent_hash_map_test.ConcurrentHashMapTest
 * author :  ddh96
 * date : 2023-08-24 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-08-24                ddh96             최초 생성
 */
public class ConcurrentHashMapTest {

	/**
	 *
	 */
	@Test
	void concurrentHashMapTest() {

		ConcurrentHashMap<String,String> testMap=new ConcurrentHashMap<>();
		//스레드 경합 과정을 보기 위한 init data
		testMap.put("1번 key","1-1번 value");
		testMap.put("2번 key","2-1번 value");



		//경합 스레드 생성

		Thread t1 = new Thread(()->testMap.put("1번 key","1-2번 value"));
		Thread t2 = new Thread(()->testMap.put("1번 key","1-3번 value"));
		Thread t3 = new Thread(()->testMap.put("2번 key","2-2번 value"));
		Thread t4 = new Thread(()->testMap.put("2번 key","2-3번 value"));


		//경합 스레드 이름 설정
		t1.setName("user1");
		t2.setName("user2");
		t3.setName("user3");
		t4.setName("user4");


		/**
		 * 	여기에 디버깅 포인트 걸고 시작
		 * 	디버깅 시작버튼 누르고 여기서 멈춘후에  ConcurrentHashMap -> putVAL 메소드에 브레이크 걸고 시작
		 * 	main worker thread 끝까지 실행후 각각의 스레드 포인트 실행 (ConcurrentHashMap -> putVal)
		 * 	버킷별로 스레드가 경합하는 과정을 볼수있음
		 * 	1번키 끼리 2번키 끼리 경합하는것을 볼수있음
		 * 	running thread 와 monitor thread 를 확인
		 */

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
