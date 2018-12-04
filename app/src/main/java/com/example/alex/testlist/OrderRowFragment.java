package com.example.alex.testlist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderRowFragment extends Fragment {
    private String name;
    private String mainInfo;
    private String orderSum;
    private TextView textViewName;
    private TextView textViewmainInfo;
    private TextView textVieworderSum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(String mainInfo) {
        this.mainInfo = mainInfo;

    }

    public String getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(String orderSum) {
        this.orderSum = orderSum;

    }

    public OrderRowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View linearLayout = inflater.inflate(R.layout.order_row_fragment, container, false);
        textViewName = linearLayout.findViewById(R.id.textViewName);
        textViewmainInfo = linearLayout.findViewById(R.id.textViewMainInfo);
        textVieworderSum = linearLayout.findViewById(R.id.textViewOrderSum);

        textViewName.setText(name);
        textViewmainInfo.setText(mainInfo);
        textVieworderSum.setText(orderSum);

        return linearLayout;
    }

}
