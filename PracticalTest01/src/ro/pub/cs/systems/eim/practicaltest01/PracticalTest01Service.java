package ro.pub.cs.systems.eim.practicaltest01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Service extends Service {

	public PracticalTest01Service() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		
		int firstNumber = intent.getIntExtra("firstNumber", -1);
	    int secondNumber = intent.getIntExtra("secondNumber", -1);
	    
        ProcessingThread processingThread = new ProcessingThread(this,firstNumber,secondNumber);
        processingThread.start();
	    
	    return Service.START_REDELIVER_INTENT;
	}

}
