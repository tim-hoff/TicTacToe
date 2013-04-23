package com.example.tictactoetitan;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class TicTacButton extends Button {
	
	public enum State {cross, circle}
	private int _x,_y;
	private boolean is_assigned = false;
	
	MainActivity activity;
	
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
				if (!is_assigned && !activity.game_state) { changeState(); is_assigned = true;}
			}
		});
	}
	
	public void changeState()
	{
		if (activity.state == State.circle) setText("O");
		if (activity.state == State.cross) setText("X");
		
		activity.changeState(_x,_y);
	}
	
	public void set_x(int x) {_x=x;}
	public void set_y(int y) {_y=y;}
	public int get_x() {return _x;}
	public int get_y() {return _y;}
	
	public void reset() {setText(""); is_assigned = false;}
}
