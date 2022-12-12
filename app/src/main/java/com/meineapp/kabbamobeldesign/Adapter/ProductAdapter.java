package com.meineapp.kabbamobeldesign.Adapter;

import android.content.Context;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.meineapp.kabbamobeldesign.Entities.Product;
import com.meineapp.kabbamobeldesign.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Product> arrayProducts;

    public ProductAdapter(Context context, ArrayList<Product> arrayProducts) {
        this.context = context;
        this.arrayProducts = arrayProducts;
    }

    @Override
    public int getCount() {
        return arrayProducts.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProducts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override     //This method recalls a for loop, will iterate through array lenght
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater myLayoutInflater = LayoutInflater.from(this.context);
        view = myLayoutInflater.inflate(R.layout.product_template, null); //Here product template is referenced/

        ImageView imageRef = (ImageView) view.findViewById(R.id.prodImage);
        TextView prodName = (TextView) view.findViewById(R.id.prodName);
        TextView prodDescription = (TextView) view.findViewById(R.id.prodShortD);
        TextView prodPrice = (TextView) view.findViewById(R.id.prodPrice);

        Product product = arrayProducts.get(i);

        imageRef.setImageResource(product.getImageRef());
        prodName.setText(product.getName());
        prodDescription.setText(product.getBeschreibung());
        prodPrice.setText(product.getPreis());

        return view;
    }
}
