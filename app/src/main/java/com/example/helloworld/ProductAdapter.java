package com.example.helloworld;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private List<Product> products;
    private final View.OnClickListener onFavoriteClickListener;
    private final View.OnClickListener onShareClickListener;

    public ProductAdapter(List<Product> products, View.OnClickListener onFavoriteClickListener, View.OnClickListener onShareClickListener) {
        this.products = products;
        this.onFavoriteClickListener = onFavoriteClickListener;
        this.onShareClickListener = onShareClickListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);

        // set product value for ViewHolder.Product
        holder.product = product;

        String productName = product.getId() + " - " + product.getName();
        holder.txtProductName.setText(productName);

        holder.btnFavorite.setTag(holder);
        holder.btnFavorite.setOnClickListener(onFavoriteClickListener);

        holder.btnShare.setTag(holder);
        holder.btnShare.setOnClickListener(onShareClickListener);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
