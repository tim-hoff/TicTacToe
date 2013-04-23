package com.example.tictactoetitan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.tictactoetitan.LoginDialogFragment.LoginDialogListener;
import com.example.tictactoetitan.TicTacButton.State;

public class MainActivity extends FragmentActivity implements LoginDialogListener{
	
	TicTacButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	Button btnRestart, btnDialog, btnActivity;
	State state;
	boolean game_state = false;
	int total_moves = 0; 
	
	State[][] tictac;

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
		
		btn1 = (TicTacButton) findViewById(R.id.button1); btn1.set_x(0); btn1.set_y(0); btn1.activity = this;
		btn2 = (TicTacButton) findViewById(R.id.button2); btn2.set_x(0); btn2.set_y(1); btn2.activity = this;
		btn3 = (TicTacButton) findViewById(R.id.button3); btn3.set_x(0); btn3.set_y(2); btn3.activity = this;
		btn4 = (TicTacButton) findViewById(R.id.button4); btn4.set_x(1); btn4.set_y(0); btn4.activity = this;
		btn5 = (TicTacButton) findViewById(R.id.button5); btn5.set_x(1); btn5.set_y(1); btn5.activity = this;
		btn6 = (TicTacButton) findViewById(R.id.button6); btn6.set_x(1); btn6.set_y(2); btn6.activity = this;
		btn7 = (TicTacButton) findViewById(R.id.button7); btn7.set_x(2); btn7.set_y(0); btn7.activity = this;
		btn8 = (TicTacButton) findViewById(R.id.button8); btn8.set_x(2); btn8.set_y(1); btn8.activity = this;
		btn9 = (TicTacButton) findViewById(R.id.button9); btn9.set_x(2); btn9.set_y(2); btn9.activity = this;
				
		state = State.circle;
		
		btnRestart = (Button) findViewById(R.id.restart);
		btnDialog = (Button) findViewById(R.id.button10);
		
		btnDialog.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				DialogFragment dialog = new LoginDialogFragment();
		        dialog.show(getSupportFragmentManager(), "Login");
			}
		});
		
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
				
				tictac = new State[3][3];
				game_state = false;
				total_moves = 0;
			}
		});
		
		btnActivity = (Button) findViewById(R.id.button11);
		btnActivity.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent myIntent = new Intent(MainActivity.this, SampleActivity.class);
				MainActivity.this.startActivity(myIntent);
			}
		});
	}
	
	public void changeState(int x, int y)
	{
		total_moves++;
		tictac[x][y] = state;
		if (game_over() || total_moves == 9)
		{
			game_state = true;
			if (total_moves == 9 && !game_over())
				toast("Draw!");
			else
			{
				toast(state.toString() + " wins!");
			}
		}
		state = (state == State.circle) ? State.cross : State.circle;
	}
	
	public boolean game_over()
	{
		int d_ctr=0, d2_ctr=0;
		for (int i=0; i<3; i++)
		{
			if (tictac[i][i] == state) d_ctr++;
			if (tictac[2-i][i] == state) d2_ctr++;
			if (d_ctr == 3 || d2_ctr==3) return true;
			for (int j=0; j<3; j++)
			{
				if (tictac[i][j] != state) continue;
				int c_ctr = 0, r_ctr=0;
				for(int k=0; k<3; k++)
				{
					if (tictac[k][j] == state) c_ctr++;
					if (tictac[i][k] == state) r_ctr++;
				}
				
				if (r_ctr == 3 || c_ctr == 3) return true;
			}
		}
		return false;
	}
	
	public void toast(String message){
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onDialogPositiveClick(DialogFragment dialog) {		
		DialogFragment dialog_progress = new MessgeDialogFragment();
        dialog_progress.show(getSupportFragmentManager(), "progress");
	}
}
