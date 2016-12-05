package com.lewgmail.romanenko.taxiservice.view.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.lewgmail.romanenko.taxiservice.R;
import com.lewgmail.romanenko.taxiservice.view.dialogFragment.DatePickerFragment;
import com.lewgmail.romanenko.taxiservice.view.dialogFragment.TimePickerFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Lev on 29.11.2016.
 */

public class EditOrderActivity extends FragmentActivity implements
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    @BindView(R.id.start_point_act)
    EditText startPointAct;
    @BindView(R.id.end_point_act)
    EditText endPointAct;
    @BindView(R.id.date_ride_act)
    EditText dateRideAct;
    @BindView(R.id.time_ride_act)
    EditText timeRideAct;
    @BindView(R.id.set_status_order_act)
    Spinner mSpinnerStatusType;
    @BindView(R.id.value_requirements_car)
    Spinner mSpinnerCarType;
    @BindView(R.id.additional_requirements_value_reckoning)
    Spinner mSpinnerReckoning;

    private SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_oreder_client);
        ButterKnife.bind(this);
        initializeSpinner();
    }

   /* private void initialization() {
        startPointAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(EditOrderActivity.this, MapActivity.class);
                myIntent.putExtra("keyAddressFromMarker", "StartPoint");//Optional parameters
                EditOrderActivity.this.startActivityForResult(myIntent, 1);
            }
        });
        endPointAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(EditOrderActivity.this, MapActivity.class);
                myIntent.putExtra("keyAddressFromMarker", "EndPoint"); //Optional parameters
                EditOrderActivity.this.startActivityForResult(myIntent, 1);
            }
        });
    }*/


    @OnClick(R.id.start_point_act)
    public void onClickStartPoint() {
        Intent myIntent = new Intent(EditOrderActivity.this, MapActivity.class);
        myIntent.putExtra("keyAddressFromMarker", "StartPoint");//Optional parameters
        EditOrderActivity.this.startActivityForResult(myIntent, 1);
    }

    @OnClick(R.id.end_point_act)
    public void onClickEndPoint() {
        Intent myIntent = new Intent(EditOrderActivity.this, MapActivity.class);
        myIntent.putExtra("keyAddressFromMarker", "EndPoint"); //Optional parameters
        EditOrderActivity.this.startActivityForResult(myIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        String address = data.getStringExtra("StartPoint");
        if (address != null)
            startPointAct.setText(address);
        address = data.getStringExtra("EndPoint");
        if (address != null)
            endPointAct.setText(address);
    }

    @OnClick(R.id.date_ride_act)
    public void onClickDataPiker() {
        DatePickerFragment dialog = new DatePickerFragment();
        dialog.show(getFragmentManager(), "datePicker");
        // dialog.show(fm, DIALOG_DATE);
    }

    @OnClick(R.id.time_ride_act)
    public void onClickTimePicker() {
        TimePickerFragment dialog = new TimePickerFragment();
        dialog.show(getFragmentManager(), "timePicker");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        dateRideAct.setText(Integer.toString(dayOfMonth) + "." + Integer.toString(monthOfYear)
                + "." + Integer.toString(year));
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        timeRideAct.setText(Integer.toString(hourOfDay) + ":" + Integer.toString(minute));
    }

    private void initializeSpinner() {
        ArrayAdapter<CharSequence> adapterSpinnerCarType =
                ArrayAdapter.createFromResource(this, R.array.set_type_status_order, android.R.layout.simple_spinner_item);
        adapterSpinnerCarType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerStatusType.setAdapter(adapterSpinnerCarType);

        ArrayAdapter<CharSequence> adapterSpinnerNumPassenger =
                ArrayAdapter.createFromResource(this, R.array.set_car_type, android.R.layout.simple_spinner_item);
        adapterSpinnerNumPassenger.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerCarType.setAdapter(adapterSpinnerNumPassenger);

        ArrayAdapter<CharSequence> adapterSpinnerTypeReckoning =
                ArrayAdapter.createFromResource(this, R.array.set_type_reckoning, android.R.layout.simple_spinner_item);
        adapterSpinnerTypeReckoning.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerReckoning.setAdapter(adapterSpinnerTypeReckoning);
    }
}
