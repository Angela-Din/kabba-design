package com.meineapp.kabbamobeldesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Aktionen extends AppCompatActivity {

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

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent zuruckWarenkorb = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(zuruckWarenkorb);
            }
        });

    }
}