package com.meineapp.kabbamobeldesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {

    private TextView prodNameInfo, prodPriceInfo;
    private EditText prodBeschreibung;
    private ImageView imageInfo;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_KabbaMöbelStore);
        setContentView(R.layout.activity_product_details);

        prodNameInfo = (TextView) findViewById(R.id.prodNameInfo);
        prodPriceInfo = (TextView) findViewById(R.id.prodPriceInfo);
        prodBeschreibung = (EditText) findViewById(R.id.prodBeschreibung);
        imageInfo = (ImageView) findViewById(R.id.imageInfo);
        addButton = (Button) findViewById(R.id.addButton);

        Intent intentIN = getIntent();
        prodNameInfo.setText(intentIN.getStringExtra("name"));
        prodPriceInfo.setText(intentIN.getStringExtra("preis"));
        prodBeschreibung.setText(intentIN.getStringExtra("beschreibung"));
        imageInfo.setImageResource(intentIN.getIntExtra("image",0));

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent zuruckWarenkorb = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(zuruckWarenkorb);

            }
        });

    }
}