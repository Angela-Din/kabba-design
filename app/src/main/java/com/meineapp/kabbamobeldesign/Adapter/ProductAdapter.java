package com.meineapp.kabbamobeldesign.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.meineapp.kabbamobeldesign.Entities.Product;
import com.meineapp.kabbamobeldesign.ProductDetails;
import com.meineapp.kabbamobeldesign.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Product> arrayProducts;

    public ProductAdapter(Context context, ArrayList<Product> arrayProducts) {
        this.context = context;
        this.arrayProducts = arrayProducts;
    }
    public ArrayList<Product> getArrayProducts() {
        return arrayProducts;
    }

    public void setArrayProducts(ArrayList<Product> arrayProducts) {
        this.arrayProducts = arrayProducts;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayProducts.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayProducts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override     //This method recalls a for loop, will iterate through array length

    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater myLayoutInflater = LayoutInflater.from(this.context);
        view = myLayoutInflater.inflate(R.layout.product_template, null); //Here product template is referenced/

        Product product = arrayProducts.get(position);

        ImageView imageRef = (ImageView) view.findViewById(R.id.editImage);
        TextView prodName = (TextView) view.findViewById(R.id.txtName);
        TextView prodDescription = (TextView) view.findViewById(R.id.txtBeschreibung);
        TextView prodPrice = (TextView) view.findViewById(R.id.txtPreis);

        imageRef.setImageResource(product.getImageRef());
        prodName.setText(product.getName());
        prodDescription.setText(product.getBeschreibung());
        prodPrice.setText(product.getPreis());


        imageRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent produktDetails = new Intent(context.getApplicationContext(), ProductDetails.class);
                produktDetails.putExtra("image", product.getImageRef());
                produktDetails.putExtra("name", product.getName());
                produktDetails.putExtra("beschreibung", product.getBeschreibung());
                produktDetails.putExtra("preis", product.getPreis());
                context.startActivity(produktDetails);
            }
        });

        return view;
    }
}
