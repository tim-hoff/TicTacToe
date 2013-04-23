package com.example.tictactoetitan;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

@SuppressLint("NewApi")
public class LoginDialogFragment extends DialogFragment {
	
	public interface LoginDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
    }
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
	    LayoutInflater inflater = getActivity().getLayoutInflater();
	    
	    builder.setTitle("You'll need to login first");

	    builder.setView(inflater.inflate(R.layout.dialog_signin, null))
	           .setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	            	   listener.onDialogPositiveClick(LoginDialogFragment.this);
	               }
	           });    
	    return builder.create();
	}	
	
	 LoginDialogListener listener;
	    
	 @Override
	 public void onAttach(Activity activity) 
	 {
		 super.onAttach(activity);
		 listener = (LoginDialogListener) activity;
	 }
}
