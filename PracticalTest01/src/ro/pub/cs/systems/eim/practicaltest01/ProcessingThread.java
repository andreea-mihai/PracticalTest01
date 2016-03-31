package ro.pub.cs.systems.eim.practicaltest01;

import java.util.Random;

import android.content.Context;
import android.content.Intent;

public class ProcessingThread extends Thread {

	private Context context;

	private double arithmeticMean;
	private double geometricMean;
	private String types[] = { "one", "two", "three" };
	private boolean isRunning = true;

	public ProcessingThread(Context context, int firstNumber, int secondNumber) {
		// TODO Auto-generated constructor stub
		this.context = context;
		arithmeticMean = (firstNumber + secondNumber) / 2;
		geometricMean = Math.sqrt(firstNumber * secondNumber);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isRunning) {
			sendMessage();
			sleep();
		}
	}

	private void sleep() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
	}

	private void sendMessage() {
		Intent intent = new Intent();
		Random random = new Random();
		intent.setAction(types[random.nextInt(3)]);
		context.sendBroadcast(intent);
	}

	public void stopThread() {
		isRunning = false;
	}
}
