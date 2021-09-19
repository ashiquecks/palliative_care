package com.example.sargamdesign.ui.share;

public class Upload {

    private String productID;
    private String mName;
    private String mPrice;
    private String mDescription;
    private String mCtegory;
    private String mImageUrl;

    public Upload() {

    }

    public Upload(String name, String imageUrl) {

        mName = name;
        mImageUrl = imageUrl;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmCtegory() {
        return mCtegory;
    }

    public void setmCtegory(String mCtegory) {
        this.mCtegory = mCtegory;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
