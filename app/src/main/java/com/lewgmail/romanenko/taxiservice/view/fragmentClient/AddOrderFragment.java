package com.lewgmail.romanenko.taxiservice.view.fragmentClient;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.lewgmail.romanenko.taxiservice.R;
import com.lewgmail.romanenko.taxiservice.view.activity.MapActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.value;

/**
 * Created by Lev on 25.11.2016.
 */

public class AddOrderFragment extends android.support.v4.app.Fragment {
    @BindView(R.id.start_point)
    EditText start_point;
    @BindView(R.id.end_point)
    EditText end_point;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_client_add_order, container, false);
        ButterKnife.bind(this, view);
        initialization();
        return view;
    }

    private void initialization() {
        start_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), MapActivity.class);
                myIntent.putExtra("key", value); //Optional parameters
                getActivity().startActivity(myIntent);
            }
        });
        end_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), MapActivity.class);
                myIntent.putExtra("key", value); //Optional parameters
                getActivity().startActivity(myIntent);
            }
        });
    }
}
