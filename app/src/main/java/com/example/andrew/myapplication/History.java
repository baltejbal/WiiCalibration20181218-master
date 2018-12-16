package com.example.andrew.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class History extends AppCompatActivity {
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        expandableListView = findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListViewData.getData();
        expandableListTitle = new ArrayList<>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListView(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });
    }

    public static class ExpandableListViewData {
        public static HashMap<String, List<String>> getData() {
            HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

            List<String> solaros = new ArrayList<String>();
            solaros.add("Data");
            solaros.add("Data");
            solaros.add("Data");
            solaros.add("Data");

            List<String> bali = new ArrayList<String>();
            bali.add("Data");
            bali.add("Data");
            bali.add("Data");
            bali.add("Data");

            List<String> pip = new ArrayList<String>();
            pip.add("Data");
            pip.add("Data");
            pip.add("Data");
            pip.add("Data");



            expandableListDetail.put("solarosflame@hotmail.com", solaros);
            expandableListDetail.put("balibal@live.com", bali);
            expandableListDetail.put("pip@gmail.com", pip);
            return expandableListDetail;
        }
    }
}