package com.example.alex.testlist;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder> {

    private GlobalData globalData;
    private List<Order> orderList;
    private List<OrderRow> orderRowsList = new ArrayList<>();

    private CardView cardView;
    private TextView textViewNumber;
    private TextView textViewDate;
    private TextView textViewOrderSum;
    private TextView textViewSale;
    private TextView textViewDelivery;
    private TextView textViewForPay;
    private TextView textViewStatus;
    private LinearLayout container;
    private TextView textViewRepeat;
    private FragmentManager fm;
    private static AssetManager am;
    private Context context;
    private ViewGroup vg;


    OrderAdapter(Context context, FragmentManager fm, AssetManager am){
        this.fm = fm;
        this.am = am;
        this.context = context;
        this.globalData = globalData.fromJson(loadJSONFromAsset(context));
        this.orderList = globalData.getData();
    }








    public class OrderHolder extends RecyclerView.ViewHolder{
        public OrderHolder(@NonNull CardView itemView) {
            super(itemView);
            cardView = itemView;

        }
    }


    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        cardView = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_order, viewGroup, false);
        textViewNumber = cardView.findViewById(R.id.textViewNumber);
        textViewDate = cardView.findViewById(R.id.textViewDate);
        textViewOrderSum = cardView.findViewById(R.id.textViewOrderSum);
        textViewSale = cardView.findViewById(R.id.textViewSale);
        textViewDelivery = cardView.findViewById(R.id.textViewDelivery);
        textViewForPay = cardView.findViewById(R.id.textViewForPay);
        textViewStatus = cardView.findViewById(R.id.textViewStatus);
        textViewRepeat = cardView.findViewById(R.id.textViewRepeat);
        container = cardView.findViewById(R.id.containerLL);
        vg = viewGroup;

        return new OrderHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder orderHolder, int i) {
        Order order = orderList.get(i);

        formatForString(textViewNumber,context.getString(R.string.number), order.getId());
        textViewDate.setText(order.getDate());
        formatForString(textViewSale,context.getString(R.string.sale), order.getSkidkaRub().toString());
        formatForString(textViewDelivery,context.getString(R.string.delivery), order.getDostavka());
        formatForString(textViewForPay,context.getString(R.string.for_pay), order.getPayed());
        formatForString(textViewStatus,context.getString(R.string.status), order.getStatus());
        orderRowsList = order.getOrderRows();
        textViewRepeat.setText("Повторить заказ");
        int childCount = orderRowsList.size();
        int sum = 0;
        if (container.getChildCount() < childCount) {
            for(int n = 0; n < orderRowsList.size(); n++){
                OrderRow row = orderRowsList.get(n);
                View orderRow = LayoutInflater.from(context).inflate(R.layout.order_row_fragment, vg ,false);
                TextView name = orderRow.findViewById(R.id.textViewName);
                TextView info = orderRow.findViewById(R.id.textViewMainInfo);
                formatForString(name, row.getName());
                formatForString(info,context.getString(R.string.main_info),
                        row.getPrice(), row.getKol(), row.getPrice());
                container.addView(orderRow);
                sum += Integer.parseInt(row.getPrice());
            }
            formatForString(textViewOrderSum,context.getString(R.string.order_sum), sum);
        }

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("data.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    private String formatForString(TextView view, String s, Object...args){
        Spanned text = Html.fromHtml(String.format(s, args));
        view.setText(text);
        return text.toString();
    }
}
