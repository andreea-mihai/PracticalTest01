package ro.pub.cs.systems.eim.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01SecondaryActivity extends Activity {
	
	private Button buttonOk = null;
	private Button buttonCancel = null;
	private ButtonListener listener = new ButtonListener();
	
	private EditText text = null;

	private class ButtonListener implements View.OnClickListener {

		@Override
		public void onClick(View view) {
			switch (view.getId()) {
			case R.id.ok:
				setResult(RESULT_OK, null);
				break;
			case R.id.cancel:
				setResult(RESULT_CANCELED, null);
				break;
			}
			finish();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_practical_test01_secondary);
		 
		 buttonOk = (Button)findViewById(R.id.ok);
		 buttonCancel = (Button)findViewById(R.id.cancel);
		 text = (EditText)findViewById(R.id.answer);
		 
		 buttonOk.setOnClickListener(listener);
		 buttonCancel.setOnClickListener(listener);
		 
		 Intent intent = getIntent();
		int count = intent.getIntExtra("sum", -1);
		 text.setText(String.valueOf(count));
		 
	}

}
