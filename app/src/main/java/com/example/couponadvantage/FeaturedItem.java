package com.example.couponadvantage;

public class FeaturedItem {
    String CategoryId,
            Description,
            ImageURLs,
            Location,
            Price,
            Title;

    public FeaturedItem() {

    }

    public FeaturedItem(String categoryId, String description, String imageURLs, String location, String price, String title) {
        CategoryId = categoryId;
        Description = description;
        ImageURLs = imageURLs;
        Location = location;
        Price = price;
        Title = title;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public String getDescription() {
        return Description;
    }

    public String getImageURLs() {
        return ImageURLs;
    }

    public String getLocation() {
        return Location;
    }

    public String getPrice() {
        return Price;
    }

    public String getTitle() {
        return Title;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setImageURLs(String imageURLs) {
        ImageURLs = imageURLs;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
