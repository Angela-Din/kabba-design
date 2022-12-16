package com.meineapp.kabbamobeldesign.DB;

import static android.service.controls.ControlsProviderService.TAG;

import android.content.ContentValues;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.meineapp.kabbamobeldesign.Adapter.ProductAdapter;
import com.meineapp.kabbamobeldesign.Entities.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Firestore_DB {
    private FirebaseFirestore db;

    public Firestore_DB(){
        this.db = FirebaseFirestore.getInstance();
        //CollectionReference myservice = db.collection("produkts");
    }

    public void insertData (Product product){
        //Create a Hashmap to insert product data

        Map<String, Object> produkt = new HashMap<>();
        produkt.put("image", product.getImageRef());
        produkt.put("name", product.getName());
        produkt.put("beschreibung", product.getBeschreibung());
        produkt.put("preis", product.getPreis());

        //New document with generated ID
        db.collection("produkts").add(produkt);
    }

    public void getData(ProductAdapter adapter){
        db.collection("produkts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Product> list = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Product product = new Product(
                                        document.getData().get("name").toString(),
                                        document.getData().get("beschreibung").toString(),
                                        document.getData().get("preis").toString(),
                                        Integer.parseInt(document.getData().get("image").toString())

                                );
                                list.add(product);
                            }
                            adapter.setArrayProducts(list);
                            adapter.notifyDataSetChanged();
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

    }

    public void deleteData(String id){
        db.collection("produkts").document(id)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(ContentValues.TAG, "DocumentSnapshot successfully deleted!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(ContentValues.TAG, "Error deleting document", e);
                    }
                });
    }
}
