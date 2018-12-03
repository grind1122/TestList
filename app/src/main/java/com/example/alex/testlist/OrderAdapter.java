package com.example.alex.testlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder> {

    private GlobalData globalData;
    private List<Order> orderList;
    private List<OrderRow> orderRowsList;

    private CardView cardView;
    private TextView textViewNumber;
    private TextView textViewDate;
    private TextView textViewName;
    private TextView textViewMainInfo;
    private TextView textViewOrderSum;
    private TextView textViewSale;
    private TextView textViewDelivery;
    private TextView textViewForPay;
    private TextView textViewStatus;
    private TextView textViewRepeat;








    public class OrderHolder extends RecyclerView.ViewHolder{
        public OrderHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView;

        }
    }


    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CardView cardView = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_order, viewGroup, false);
        textViewNumber = cardView.findViewById(R.id.textViewNumber);
        textViewDate = cardView.findViewById(R.id.textViewDate);
        textViewName = cardView.findViewById(R.id.textViewName);
        textViewMainInfo = cardView.findViewById(R.id.textViewMainInfo);
        textViewOrderSum = cardView.findViewById(R.id.textViewOrderSum);
        textViewSale = cardView.findViewById(R.id.textViewSale);
        textViewDelivery = cardView.findViewById(R.id.textViewDelivery);
        textViewForPay = cardView.findViewById(R.id.textViewForPay);
        textViewStatus = cardView.findViewById(R.id.textViewStatus);
        textViewRepeat = cardView.findViewById(R.id.textViewRepeat);
        return new OrderHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder orderHolder, int i) {
        try {
            globalData = globalData.fromJson(readFile("data/data.json", Charset.defaultCharset()));
            orderList = globalData.getData();
            Order order = orderList.get(i);
            textViewNumber.setText(order.getId());
            textViewDate.setText(order.getDate());
            textViewSale.setText(order.getSkidkaRub());
            textViewDelivery.setText(order.getDostavka());
            textViewForPay.setText(order.getPayed());
            textViewStatus.setText(order.getStatus());
            orderRowsList = order.getOrderRows();





        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
