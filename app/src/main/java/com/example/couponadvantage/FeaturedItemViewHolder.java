package com.example.couponadvantage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class FeaturedItemViewHolder extends RecyclerView.ViewHolder {
    TextView title, description, location, price, category;
    ImageView imageView;

    public FeaturedItemViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.titleTextView);
        description = itemView.findViewById(R.id.descriptionTextView);
        location = itemView.findViewById(R.id.locationTextView);
        price = itemView.findViewById(R.id.priceTextView);
        imageView = itemView.findViewById(R.id.imageViewAd);
        category = itemView.findViewById(R.id.categoryTextView);
    }

    public void bind(FeaturedItem featuredItem) {
        title.setText(featuredItem.getTitle());
        description.setText(featuredItem.getDescription());
        location.setText(featuredItem.getLocation());
        price.setText(featuredItem.getPrice());
        category.setText(featuredItem.getCategoryId());

        Glide.with(imageView.getContext())
                .load(featuredItem.getImageURLs())
                .apply(new RequestOptions()
                        .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                        .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                        .circleCrop())
                .into(imageView);
    }
}

