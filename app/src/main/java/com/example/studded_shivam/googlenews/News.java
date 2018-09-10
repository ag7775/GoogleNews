package com.example.studded_shivam.googlenews;

/**
 * Created by StudDed_SHIVAM on 18-Sep-17.
 */

public class News {

    private String mTitle,mDescription,mUrl,mUrlToImage;

    public News(String mTitle, String mDescription, String mUrl, String mUrlToImage) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mUrl = mUrl;
        this.mUrlToImage = mUrlToImage;
    }
    public String getmTitle()
    {
        return mTitle;

    }
    public String getmDescription(){
        return mDescription;
    }
    public String getmUrl(){
        return mUrl;
    }
    public String getmUrlToImage(){
        return mUrlToImage;
    }
}
