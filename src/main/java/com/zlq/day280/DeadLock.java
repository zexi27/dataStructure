package com.zlq.day280;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/6/26 14:52
 */
public class DeadLock {

//	public static final Object o1 = new Object();
//
//	public static final Object o2 = new Object();

	public static final Integer threadCount = 10;

	public static void main(String[] args) {
		Object[] lockArr = new Object[threadCount];
		Thread[] threads = new Thread[threadCount];
		for (int i = 0; i < lockArr.length; i++) {
			lockArr[i] = new Object();

		}

		for (Integer i = 0; i < threadCount; i++) {

			Integer index = i;

			threads[i] = new Thread(() -> {
				Object o1 = lockArr[index];
				Object o2 = lockArr[(index + 1) % threadCount];

				Object firstLock = o1;
				Object secondLock = o2;
//				if (System.identityHashCode(firstLock) > System.identityHashCode(secondLock)){
//					firstLock = o2;
//					secondLock = o1;
//				}
				synchronized (firstLock) {
					System.out.println(Thread.currentThread().getName() + "获取到锁o" + index);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					synchronized (secondLock) {
						System.out.println(Thread.currentThread().getName() + "获取到锁o" + index + 1);
					}
				}
			});
		}

		for (Integer i = 0; i < threadCount; i++) {
			threads[i].start();
		}
	}

}
