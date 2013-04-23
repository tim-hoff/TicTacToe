package com.example.tictactoetitan;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

public class MessgeDialogFragment extends DialogFragment{
	
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
	    LayoutInflater inflater = getActivity().getLayoutInflater();
	    
	    builder.setTitle("Connecting to server. Please Wait...");

//	    builder.setView(inflater.inflate(R.layout.dialog_progress, null));    
	    return builder.create();
	}	

}
