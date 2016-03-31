package ro.pub.cs.systems.eim.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends Activity {
	private EditText text1 = null;
	private EditText text2 = null;

	private Button button1 = null;
	private Button button2 = null;
	private Button button3 = null;
	
	private int nr1 = 0;
	private int nr2 = 0;

	private ButtonListener listener = new ButtonListener();

	private class ButtonListener implements View.OnClickListener {

		@Override
		public void onClick(View view) {
			switch (view.getId()) {
			case R.id.left_button:
				System.out.println("BUM heeeeeeeeeeeeeeere");
				int nr1 = Integer.parseInt(text1.getText().toString());
				nr1++;
				text1.setText(String.valueOf(nr1));
				// text1.setText(nr1);
				break;
			case R.id.right_button:
				int nr2 = Integer.parseInt(text2.getText().toString());
				nr2++;
				text2.setText(String.valueOf(nr2));
				break;
			case R.id.navigate_to_secondary_activity_button:
				Intent intent = new Intent(getApplicationContext(),PracticalTest01SecondaryActivity.class);
				int count = Integer.parseInt(text1.getText().toString())+Integer.parseInt(text2.getText().toString());
				intent.putExtra("sum", count);
    			startActivityForResult(intent, 1);
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);

		text1 = (EditText) findViewById(R.id.left_edit_text);
		text2 = (EditText) findViewById(R.id.right_edit_text);

		button1 = (Button) findViewById(R.id.left_button);
		button2 = (Button) findViewById(R.id.right_button);
		button3 = (Button) findViewById(R.id.navigate_to_secondary_activity_button);

		text1.setText(String.valueOf(0));
		text2.setText(String.valueOf(0));

		button1.setOnClickListener(listener);
		button2.setOnClickListener(listener);
		button3.setOnClickListener(listener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		
	
		EditText passwordEditText = (EditText) findViewById(R.id.right_edit_text);

		savedInstanceState.putString("text1", text1.getText().toString());
		savedInstanceState.putString("text2", text2.getText().toString());

	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		if (savedInstanceState.containsKey("text1")) {
			text1.setText(savedInstanceState.getString("text1"));
		}
		if (savedInstanceState.containsKey("text2")) {
			text1.setText(savedInstanceState.getString("text2"));
		}
	}
	
	@Override
	  protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    if (requestCode == 1) {
	      Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
	    }
	  }

}
