package com.lewgmail.romanenko.taxiservice.view.fragmentClient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lewgmail.romanenko.taxiservice.R;

/**
 * Created by Lev on 25.11.2016.
 */

public class AddOrderFragment extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_client_add_order, container, false);
    }
}
