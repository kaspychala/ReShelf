package com.apps.kabzer.reshelf;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class YourSale extends android.support.v4.app.Fragment  {
    TextView textView;

    public YourSale() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.your_sale, container, false);
        textView = (TextView)view.findViewById(R.id.textViewSale);
        Bundle bundle = getArguments();
        String message = bundle.getString("count");
        textView.setText(message);
        return view;
    }
}