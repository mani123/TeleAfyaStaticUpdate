package com.example.ast.teleafya.Ui.DoctorModule;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ast.teleafya.R;
import com.example.ast.teleafya.Ui.Adapters.Patient_LoginPager;
import com.example.ast.teleafya.Ui.Diagnostic_Ui.Diagnostic_Past_Appointment;
import com.example.ast.teleafya.Ui.Diagnostic_Ui.Diagnostic_Request_Appointment;
import com.example.ast.teleafya.Ui.Diagnostic_Ui.Diagnostic_Upcoming_Appointment;
import com.example.ast.teleafya.Ui.Patient_Ui.Map_List;
import com.example.ast.teleafya.Ui.Patient_Ui.Nurses;

import java.util.ArrayList;

/**
 * Created by Kashif on 11/30/2017.
 */

public class Doctor_MyAppointment_Tab extends android.support.v4.app.Fragment {

    public ViewPager viewPager;
    public TabLayout tabLayout;
    public ArrayList<Fragment> arrayList;
    public MY_Appointment_TabRequest myAppointmentTabRequest;
    public My_Appointment_TabUpcoming myAppointmentTabUpcoming;
    public My_Appointment_TabPast myAppointmentTabPast;
    public ArrayList<Fragment> fragments;
    public Patient_LoginPager patientLoginPager;
    ImageView backHome;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.doctor_myappointment_tab , null);

        initView(view);

        backHome = (ImageView)view.findViewById(R.id.back_home);

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getActivity() , Doctor_HomeActivity.class);
                startActivity(intent);
            }
        });
        return view;

    }

    private void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        arrayList = new ArrayList<>();
        myAppointmentTabRequest = new MY_Appointment_TabRequest();
        myAppointmentTabUpcoming = new My_Appointment_TabUpcoming();
        myAppointmentTabPast = new My_Appointment_TabPast();

        arrayList.add(myAppointmentTabRequest);
        arrayList.add(myAppointmentTabUpcoming);
        arrayList.add(myAppointmentTabPast);

        tabLayout.addTab(tabLayout.newTab().setText("REQUESTS"));
        tabLayout.addTab(tabLayout.newTab().setText("UPCOMING"));
        tabLayout.addTab(tabLayout.newTab().setText("PAST"));

        patientLoginPager = new Patient_LoginPager(getActivity().getSupportFragmentManager(), arrayList);
        //is line se tablayout k neche jo shade araaha hai woh change hoga pageviewer k mutabik
        viewPager.setAdapter(patientLoginPager);
        // viewPager.setOffscreenPageLimit(0);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

}
