package com.example.ast.teleafya.Ui.Patient_Ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ast.teleafya.R;
import com.example.ast.teleafya.Ui.Adapters.Patient_LastTransaction_ListAdapter;

/**
 * Created by AST on 10/30/2017.
 */

public class Successfuly_Payment_Patient extends android.support.v4.app.Fragment {


    ImageView imageView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.successfuly_payment,null);

            imageView = (ImageView)view.findViewById(R.id.back_home);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(getActivity() , Patient_PaymentActivity.class);
                    startActivity(intent);

                }
            });

        return view;
    }
}
