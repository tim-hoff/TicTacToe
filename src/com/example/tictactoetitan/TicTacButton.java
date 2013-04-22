package com.example.tictactoetitan;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class TicTacButton extends Button {
	
	public enum State {cross, circle}
	
	public TicTacButton(Context context) {
		super(context);
		initialize();
	}
	
	public TicTacButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize();
	}
	
	public TicTacButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize();
	}
	
	protected void initialize()
	{
		setOnClickListener(new OnClickListener()
		{
			public void onClick(View v) {
				changeState();
			}
		});
	}
	
	public void changeState()
	{
		if (MainActivity.state == State.circle) setText("O");
		if (MainActivity.state == State.cross) setText("X");
		
		MainActivity.changeState();
	}
}
