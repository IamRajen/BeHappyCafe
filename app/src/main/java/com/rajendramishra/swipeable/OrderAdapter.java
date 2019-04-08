package com.rajendramishra.swipeable;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class OrderAdapter extends ArrayAdapter<Orders> {

    private Activity context;
    private List<Orders> productList;
    DatabaseHelperYourOrders databaseHelperYourOrders;

    public OrderAdapter(Activity context, List<Orders> productList) {
        super(context, R.layout.order_layout, productList);
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.order_layout, null, true);

        TextView textViewProductName = (TextView) listViewItem.findViewById(R.id.date_of_order);
        TextView textViewQuantity = (TextView) listViewItem.findViewById(R.id.itemName);
        TextView textViewPrice = (TextView) listViewItem.findViewById(R.id.total_price);

        Orders product = productList.get(position);
        textViewProductName.setText(product.getItemWithQuantityAndPrice());
        textViewQuantity.setText(product.getTotal_price());
        textViewPrice.setText(product.getCurrentDate());

        return listViewItem;
    }



}
