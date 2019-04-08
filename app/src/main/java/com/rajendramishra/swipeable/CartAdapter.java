package com.rajendramishra.swipeable;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;




import java.util.List;

public class CartAdapter extends ArrayAdapter<Cart> {

    private Activity context;
    private List<Cart> productList;
    DataBaseHelperAddCart dataBaseHelperAddCart;

    public CartAdapter(Activity context, List<Cart> productList) {
        super(context, R.layout.list_layout, productList);
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewProductName = (TextView) listViewItem.findViewById(R.id.productName);
        TextView textViewQuantity = (TextView) listViewItem.findViewById(R.id.quantity);
        TextView textViewPrice = (TextView) listViewItem.findViewById(R.id.price);

        Cart product = productList.get(position);
        textViewProductName.setText(product.getProduct_name());
        textViewQuantity.setText(product.getQuantity());
        textViewPrice.setText(product.getPrice());

        return listViewItem;
    }


    public void deleteProduct(View view) {

        int id= view.getId();
        int result=dataBaseHelperAddCart.deleteData(id);

    }
}
