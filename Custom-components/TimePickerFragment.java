package com.example.mypickersdemo;

import java.util.Calendar;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import android.widget.Toast;



public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

	public TimePickerFragment() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	@NonNull
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		Calendar calendar = Calendar.getInstance();
		
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		
		return new TimePickerDialog(getActivity(), this, hourOfDay, minute, DateFormat.is24HourFormat(getActivity()));
	}


	@Override
	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		Toast.makeText(getActivity(), "time has been changed !\n" +
				"Hour = "+hourOfDay+"   Mimute=  " + minute, 0).show();
		
		
	}
	
	

}
