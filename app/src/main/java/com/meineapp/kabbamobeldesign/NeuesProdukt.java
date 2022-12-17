package com.meineapp.kabbamobeldesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.meineapp.kabbamobeldesign.DB.Firestore_DB;
import com.meineapp.kabbamobeldesign.Entities.Product;

public class NeuesProdukt extends AppCompatActivity {

    private Button akTButton;
    private EditText editName, editBeschreibung, editPreis;
    private Firestore_DB firestore_db;
    private ImageView editImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_KabbaMöbelStore);
        setContentView(R.layout.activity_neues_produkt);

        akTButton = (Button) findViewById(R.id.akTButton);
        editName = (EditText) findViewById(R.id.editName);
        editBeschreibung = (EditText) findViewById(R.id.editBeschreibung);
        editPreis = (EditText) findViewById(R.id.editPreis);
        editImage = (ImageView) findViewById(R.id.editImage);

        firestore_db = new Firestore_DB();

        akTButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product product = new Product(
                        editName.getText().toString(),
                        editBeschreibung.getText().toString(),
                        editPreis.getText().toString(),
                        (R.drawable.upload_image_kb)

                );

                firestore_db.insertData(product);
                Intent toMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(toMain);

            }
        });

    }
}