package com.lewgmail.romanenko.taxiservice.view.fragmentClient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.lewgmail.romanenko.taxiservice.R;
import com.lewgmail.romanenko.taxiservice.presenter.adapters.TestDataForList;
import com.lewgmail.romanenko.taxiservice.view.adapters.AdapterForListOrderClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lev on 25.11.2016.
 */

public class OrderListFragment extends android.support.v4.app.Fragment {

    @BindView(R.id.expListView)
    ExpandableListView expListView;
    ExpandableListAdapter expListAdapter;
    List<String> expListTitle;
    private HashMap<String, List<String>> expListDetail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_list_client, container, false);
        ButterKnife.bind(this, view);
        initialiseExpList();
        return view;
    }

    private void initialiseExpList() {

        expListDetail = TestDataForList.loadData();

        expListTitle = new ArrayList<>(expListDetail.keySet());
        expListAdapter = new AdapterForListOrderClient(this.getActivity(), expListTitle, expListDetail);

        expListView.setAdapter(expListAdapter);
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
               /* Toast.makeText(getApplicationContext(),
                        expListTitle.get(groupPosition) + " Список раскрыт.",
                        Toast.LENGTH_SHORT).show();*/
            }
        });

        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
               /* Toast.makeText(getApplicationContext(),
                        expListTitle.get(groupPosition) + " Список скрыт.",
                        Toast.LENGTH_SHORT).show();*/

            }
        });

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
               /* Toast.makeText(getApplicationContext(),
                        expListTitle.get(groupPosition)
                                + " : " + expListDetail.get(expListTitle.get(groupPosition))
                                .get(childPosition), Toast.LENGTH_SHORT).show();*/
                return false;
            }
        });
    }
}
