package com.example.tictactoetitan;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.tictactoetitan.TicTacButton.State;

public class MainActivity extends Activity {
	
	TicTacButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	static State state;
	static TextView message;
	
	int[][] tictac;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initialize();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
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
		
		message = (TextView) findViewById(R.id.textView1);
		tictac = new int[3][3];
		
		state = State.circle;
	}
	
	public static void changeState()
	{
		state = (state == State.circle) ? State.cross : State.circle;
		message.setText(state.toString());
	}
	
	public void gameStateCheck()
	{
	}
}
