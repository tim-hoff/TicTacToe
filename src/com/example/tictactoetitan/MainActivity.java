package com.example.tictactoetitan;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {
	
	TicTacButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initialize();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void initialize()
	{
		btn1 = (TicTacButton) findViewById(R.id.button1);
		btn1 = (TicTacButton) findViewById(R.id.button1);
		btn2 = (TicTacButton) findViewById(R.id.button2);
		btn3 = (TicTacButton) findViewById(R.id.button3);
		btn4 = (TicTacButton) findViewById(R.id.button4);
		btn5 = (TicTacButton) findViewById(R.id.button5);
		btn6 = (TicTacButton) findViewById(R.id.button6);
		btn7 = (TicTacButton) findViewById(R.id.button7);
		btn8 = (TicTacButton) findViewById(R.id.button8);
		btn9 = (TicTacButton) findViewById(R.id.button9);
	}
}
