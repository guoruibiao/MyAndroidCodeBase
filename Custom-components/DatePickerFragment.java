package com.example.mypickersdemo;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Toast;

public class DatePickerFragment extends DialogFragment 
	implements OnDateSetListener{

	public DatePickerFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@NonNull
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		return new DatePickerDialog(getActivity(), this, year, month, day);
	}
	
	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		//应该注意到的是这里面的月数比正常的数字少一
		Toast.makeText(getActivity(), "我已经检测到了你修改了时间，具体如下：\n"+
			"Year= " + year + " Month = " +  (int)(monthOfYear+1) + " Day = " +  dayOfMonth , 0).show();
		
	}

}
