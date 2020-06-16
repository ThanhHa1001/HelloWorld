package com.example.helloworld;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProductAdapter productAdapter = new ProductAdapter(dummyProductList(),
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ProductViewHolder viewHolder = (ProductViewHolder) view.getTag();
                        String content = "Favorite - " + viewHolder.product.getId() + " - " + viewHolder.product.getName();
                        Toast.makeText(MainActivity.this, content, Toast.LENGTH_SHORT).show();
                    }
                },
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ProductViewHolder viewHolder = (ProductViewHolder) view.getTag();
                        String content = "Share - " + viewHolder.product.getId() + " - " + viewHolder.product.getName();
                        Toast.makeText(MainActivity.this, content, Toast.LENGTH_SHORT).show();
                    }
                });
        productList = findViewById(R.id.product_list);
        productList.hasFixedSize();
        productList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        productList.setAdapter(productAdapter);
    }

    private List<Product> dummyProductList() {
        List<Product> products = new ArrayList<>();
        Product product;
        for (int i = 0; i < 20; i++) {
            product = new Product(i, "San pham " + i);
            products.add(product);
        }
        return products;
    }
}
