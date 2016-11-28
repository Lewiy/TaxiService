package com.lewgmail.romanenko.taxiservice.view.fragmentClient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.lewgmail.romanenko.taxiservice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lev on 25.11.2016.
 */

public class EditProfileFragment extends android.support.v4.app.Fragment {

    // @BindView(R.id.driver__personal_page)
    // FrameLayout checkBoxDriverRegistration;
    @BindView(R.id.set_num_passenger_personal_page)
    Spinner mSpinnerCarType;
    @BindView(R.id.set_car_type_personal_page)
    Spinner mSpinnerNumPassenger;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_page, container, false);
        ButterKnife.bind(this, view);
        initialiseComponent();
        return view;
    }

    private void initialiseComponent() {

        initializeSpinner();
    }

    private void initializeSpinner() {
        ArrayAdapter<CharSequence> adapterSpinnerCarType =
                ArrayAdapter.createFromResource(this.getActivity(), R.array.set_car_type, android.R.layout.simple_spinner_item);
        adapterSpinnerCarType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerCarType.setAdapter(adapterSpinnerCarType);
        ArrayAdapter<CharSequence> adapterSpinnerNumPassenger =
                ArrayAdapter.createFromResource(this.getActivity(), R.array.set_num_passenger, android.R.layout.simple_spinner_item);
        adapterSpinnerCarType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerNumPassenger.setAdapter(adapterSpinnerNumPassenger);
    }
}
