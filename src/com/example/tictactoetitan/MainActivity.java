package com.example.tictactoetitan;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.tictactoetitan.TicTacButton.State;

public class MainActivity extends Activity {
	
	TicTacButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	Button btnRestart;
	static State state;
	static TextView message;
	static boolean game_state = false;
	
	static State[][] tictac;

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
		tictac = new State[3][3];
		
		btn1 = (TicTacButton) findViewById(R.id.button1); btn1.set_x(0); btn1.set_y(0);
		btn2 = (TicTacButton) findViewById(R.id.button2); btn2.set_x(0); btn2.set_y(1);
		btn3 = (TicTacButton) findViewById(R.id.button3); btn3.set_x(0); btn3.set_y(2);
		btn4 = (TicTacButton) findViewById(R.id.button4); btn4.set_x(1); btn4.set_y(0);
		btn5 = (TicTacButton) findViewById(R.id.button5); btn5.set_x(1); btn5.set_y(1);
		btn6 = (TicTacButton) findViewById(R.id.button6); btn6.set_x(1); btn6.set_y(2);
		btn7 = (TicTacButton) findViewById(R.id.button7); btn7.set_x(2); btn7.set_y(0);
		btn8 = (TicTacButton) findViewById(R.id.button8); btn8.set_x(2); btn8.set_y(1);
		btn9 = (TicTacButton) findViewById(R.id.button9); btn9.set_x(2); btn9.set_y(2);
		
		message = (TextView) findViewById(R.id.textView1);
		
		state = State.circle;
		
		btnRestart = (Button) findViewById(R.id.restart);
		btnRestart.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				btn1.reset();
				btn2.reset();
				btn3.reset();
				btn4.reset();
				btn5.reset();
				btn6.reset();
				btn7.reset();
				btn8.reset();
				btn9.reset();
				
				message.setText("");
				
				tictac = new State[3][3];
				game_state = false;
			}
		});
	}
	
	public static void changeState(int x, int y)
	{
		tictac[x][y] = state;
		if (game_over())
		{
			game_state = true;
			message.setText(state.toString() + " wins!");
		}
		state = (state == State.circle) ? State.cross : State.circle;
	}
	
	public static boolean game_over()
	{
		for (int i=0; i<3; i++)
			for (int j=0; j<3; j++)
			{
				if (tictac[i][j] != state) continue;
				int ctr = 0;
				for(int k=0; k<3; k++)
					if (tictac[k][j] == state) ctr++;
				if (ctr == 3) return true;
				
				ctr=0;
				for(int k=0; k<3; k++)
					if (tictac[i][k] == state) ctr++;
				if (ctr == 3) return true;
			}
		
		return false;
	}
}
