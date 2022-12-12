package com.meineapp.kabbamobeldesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.meineapp.kabbamobeldesign.Adapter.ProductAdapter;
import com.meineapp.kabbamobeldesign.Entities.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button featuredProduct;
    private ListView prodListView;
    private ProductAdapter productAdapter;
    private ArrayList<Product> productArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_KabbaMöbelStore);
        setContentView(R.layout.activity_main);

        featuredProduct = (Button) findViewById(R.id.button);
        featuredProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_proddet = new Intent(getApplicationContext(), Aktionen.class);
                startActivity(to_proddet);
            }
        });

        prodListView = (ListView) findViewById(R.id.prodListView);
        productArrayList = new ArrayList<>();

        //************ ok, let's generate products arrays **********************//

        Product produkt1 = new Product("Forest Gartenarmlehnstuhl", "Für den Outdoor-Sessel Forest wurde traditionelle Handwerkskunst mit modernster Technologie kombiniert.", "€ 530,00", R.drawable.forestgartenarmlehnstuhl);
        Product produkt2 = new Product("Egg/ Das Ei™ Loungesessel Stoff", "Der Egg Chair wurde 1958 von Arne Jacobsen entworfen - Das Ei ist ein echter Designklassiker! Den berühmten Loungesessel mit Stoff-Bezug vertreibt Fritz Hansen.", "€ 6.760,00", R.drawable.fritzhansenegg);
        Product produkt3 = new Product("Drop™ Stuhl", "Die einzigartige Formgebung fällt sofort ins Auge und ist zugleich absolut zeitlos. Wie ein Tropfen verbreitert sich der Drop Stuhl bis zur Sitzfläche auf 45,5 cm.", "€ 308,00", R.drawable.fritz);
        Product produkt4 = new Product("Vitra.", "Hier kombinieren Sie die futuristische Gestalt des raffinierten Eames Plastic Chairs mit der komfortablen Natürlichkeit eines hochwertigen Lammfells.", "€ 529,00", R.drawable.vitraaktionsseteameslammfell1800);
        Product produkt5 = new Product("Clizia Mama Non Mama Pendelleuchte S", "Die Clizia Mama Non Mama Pendelleuchte S wurde von Adriano Rachele für die Marke Slamp entworfen.", "€ 314,00", R.drawable.slampclizia);
        Product produkt6 = new Product("Bau Pendant Pendelleuchte", "Bau Pendant Pendelleuchte ist ein wahres Kunstwerk von der Designerin Vibeke Fonnesberg Schmidt. Kreiert hat sie es 2010 für den dänischen Hersteller Normann Copenhagen.", "€ 189,00", R.drawable.baupendantpendelleuchte);
        Product produkt7 = new Product("Slamp Clizia Pendelleuchte S", "Die Clizia Pendelleuchte S wurde von Adriano Rachele für die Marke Slamp entworfen. Inspiration fand der italienische Designer in der griechischen Sagenwelt.", "€ 245,00", R.drawable.cliziapendelleuchte);
        Product produkt8 = new Product("Serie 7™ Stuhl Naturfurnier", "Das Designmuseum Danmark in Kopenhagen widmet der Serie einen ganzen Ausstellungsraum. Der Stuhl ist auch im Museum of Modern Art in New York zu sehen.", "€ 536,00", R.drawable.fritzhansenstuhlatur498);
        Product produkt9 = new Product("Hay J77 Stuhl wasserbasiert lackiert", "Bei diesem schlichten Modell trifft klassischer Stil auf modernen. Inspiriert wurde Volther von den berühmten Windsorstühlen, die im 18. Jahrhundert für Furore sorgten.", "€ 171,00", R.drawable.haystuhlwasserbasiertlackiert);
        Product produkt10 = new Product("Arper Leaf Loungesessel", "Der Leaf Loungesessel wurde von Alberto Lievore, Jeanette Altherr und Manel Molina für die Marke Arper entworfen.", "556", R.drawable.arperleafloungesessel);
        Product produkt11 = new Product("Die Ameise™ Stuhl gefärbte Esche", "Aus dem Jahre 1952! Arne Jacobsen war mit diesem Stuhlmodell damals seiner Zeit voraus, denn Herstellungsverfahren und Formgebung waren revolutionär.", "€ 306,00", R.drawable.fritzhansenameisestuhlgefaerbte);
        Product produkt12 = new Product("Arper Leaf Gartentisch dreieckig H74", "Die organische Anmutung des Gartentisches erinnert an einen vom Wasser im Laufe der Jahre glatt geschliffenen Stein.", "€ 504,00", R.drawable.arperleafgartentischdreieckig);

        //********** adding arrays *************// :-)
        productArrayList.add(produkt1);
        productArrayList.add(produkt2);
        productArrayList.add(produkt3);
        productArrayList.add(produkt4);
        productArrayList.add(produkt5);
        productArrayList.add(produkt6);
        productArrayList.add(produkt7);
        productArrayList.add(produkt8);
        productArrayList.add(produkt9);
        productArrayList.add(produkt10);
        productArrayList.add(produkt11);
        productArrayList.add(produkt12);

        // ********************** the end of my catalogue **********************//
        productAdapter = new ProductAdapter(this, productArrayList);

        prodListView.setAdapter(productAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.kabbaactionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


}

