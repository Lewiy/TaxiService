package com.lewgmail.romanenko.taxiservice.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.lewgmail.romanenko.taxiservice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.value;

/**
 * Created by Lev on 29.11.2016.
 */

public class AddOrderActivity extends Activity {

    @BindView(R.id.start_point_act)
    EditText start_point_act;
    @BindView(R.id.end_point_act)
    EditText end_point_act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_oreder_client);
        ButterKnife.bind(this);
        initialization();
    }

    private void initialization() {
        start_point_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(AddOrderActivity.this, MapActivity.class);
                myIntent.putExtra("key", value); //Optional parameters
                AddOrderActivity.this.startActivity(myIntent);
            }
        });
        end_point_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(AddOrderActivity.this, MapActivity.class);
                myIntent.putExtra("key", value); //Optional parameters
                AddOrderActivity.this.startActivity(myIntent);
            }
        });
    }

}
