package com.example.tictactoetitan;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class TicTacButton extends Button {
	
	public enum State {cross, circle}
	private State state;
	public MainActivity activity;
	
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
			@Override
			public void onClick(View v) {
				changeState(State.circle);
			}
		});
	}
	
	public void changeState(State s)
	{
		setState(s);
		if (s == State.circle) setText("O");
		if (s == State.cross) setText("X");
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
