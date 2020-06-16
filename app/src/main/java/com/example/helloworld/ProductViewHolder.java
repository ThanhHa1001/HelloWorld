package com.example.helloworld;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder {
   TextView txtProductName;
   Button btnFavorite;
   Button btnShare;
   Product product;
   View itemView;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        txtProductName = itemView.findViewById(R.id.txt_product_name);
        btnFavorite = itemView.findViewById(R.id.btn_favorite);
        btnShare = itemView.findViewById(R.id.btn_share);
    }
}
