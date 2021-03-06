package com.example.mesut.todolist.util;

/**
 * Created by Janik on 31.01.2018.
 *
 */

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.widget.Button;
import android.widget.DatePicker;
import android.app.Dialog;

import com.example.mesut.todolist.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the current date as the default date in the date picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        //Create a new DatePickerDialog instance and return it
        /*
            DatePickerDialog Public Constructors - Here we uses first one
            public DatePickerDialog (Context context, DatePickerDialog.OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth)
            public DatePickerDialog (Context context, int theme, DatePickerDialog.OnDateSetListener listener, int year, int monthOfYear, int dayOfMonth)
         */
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }
    public void onDateSet(DatePicker view, int year, int month, int day) {
        //Do something with the date chosen by the user

        month++; //Faggot fängt bei 0 an zu zählen
        Button dateButton = (Button) getActivity().findViewById(R.id.date_button);
        dateButton.setText(day + "." + month + "." + year);

    }
}