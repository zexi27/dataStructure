package com.zlq.day280;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/8/5 17:55
 */
public class DaemonThreadExample {

	public static void main(String[] args) {
		Thread daemonThread = new Thread(new DaemonTask());
		daemonThread.setDaemon(true);  // 设置为守护线程
		daemonThread.start();

		Thread userThread = new Thread(new UserTask());
		System.out.println("Main thread is finished.");
	}

	static class DaemonTask implements Runnable {
		@Override
		public void run() {

			while (true) {
				System.out.println("Daemon thread is running...");
				try {
					Thread.sleep(1000);  // 每秒钟输出一次
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
	}

	static class UserTask implements Runnable {
		@Override
		public void run() {
			try {
				Thread.sleep(3000);  // 模拟用户线程执行时间
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			System.out.println("User thread is finished.");
		}
	}
}
