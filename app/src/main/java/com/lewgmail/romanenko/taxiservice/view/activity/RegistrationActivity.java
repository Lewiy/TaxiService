package com.lewgmail.romanenko.taxiservice.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.lewgmail.romanenko.taxiservice.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrationActivity extends AppCompatActivity {


    private static final int INDEX_OF_CATEGORY_SPINNER_CAR_TYPE = 1;
    private static final int INDEX_OF_CATEGORY_SPINNER_NUM_PASSENGER = 1;

    @BindView(R.id.driver_registration)
    FrameLayout checkBoxDriverRegistration;
    @BindView(R.id.set_car_type)
    Spinner mSpinnerCarType;
    @BindView(R.id.set_num_passenger)
    Spinner mSpinnerNumPassenger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
        initialiseComponent();
    }

   /* private void setVisibleRegistrationDriverOption(){

    }*/

    @OnClick(R.id.check_box_registration)
    public void setVisibleRegistrationDriverOption() {
        hideShowTexiDriverRegisterInform(checkBoxDriverRegistration);

    }

    private void hideShowTexiDriverRegisterInform(FrameLayout frameLayout) {
        if (frameLayout.getVisibility() != View.VISIBLE) {

            frameLayout.setVisibility(View.VISIBLE);
        } else {

            frameLayout.setVisibility(View.GONE);
        }
    }

    private void initialiseComponent() {

        initializeSpinner();
    }

    private void initializeSpinner() {
        ArrayAdapter<CharSequence> adapterSpinnerCarType =
                ArrayAdapter.createFromResource(this, R.array.set_car_type, android.R.layout.simple_spinner_item);
        adapterSpinnerCarType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerCarType.setAdapter(adapterSpinnerCarType);
        ArrayAdapter<CharSequence> adapterSpinnerNumPassenger =
                ArrayAdapter.createFromResource(this, R.array.set_num_passenger, android.R.layout.simple_spinner_item);
        adapterSpinnerCarType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerNumPassenger.setAdapter(adapterSpinnerNumPassenger);
    }
}
