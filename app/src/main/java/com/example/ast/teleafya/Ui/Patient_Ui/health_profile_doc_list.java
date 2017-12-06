package com.example.ast.teleafya.Ui.Patient_Ui;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.ast.teleafya.R;

/**
 * Created by Kashif on 11/27/2017.
 */

public class health_profile_doc_list extends android.support.v4.app.Fragment {

    RelativeLayout relativeLayout;
    ImageView imageView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.health_profile_document_list , null);


        imageView = (ImageView)view.findViewById(R.id.back_home);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getActivity() , Health_VaultActivity.class);
                startActivity(intent);


            }
        });

        relativeLayout = (RelativeLayout)view.findViewById(R.id.docList);


        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager().beginTransaction().add(android.R.id.content ,new  health_profile_doc_details()).commit();


            }
        });

        return view;
    }
}
