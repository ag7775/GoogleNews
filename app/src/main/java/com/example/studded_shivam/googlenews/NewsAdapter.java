package com.example.studded_shivam.googlenews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by StudDed_SHIVAM on 18-Sep-17.
 */

public class NewsAdapter extends ArrayAdapter<News> {

    public static final String LOG_TAG = NewsAdapter.class.getName();

    public NewsAdapter(@NonNull Context context, @NonNull List<News> news) {
        super(context,0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_single_item, parent, false);
        }

        News currNews = getItem(position);
        TextView news_title = (TextView) listView.findViewById(R.id.news_title);
        ImageView news_image = (ImageView) listView.findViewById(R.id.news_image);
        TextView news_description = (TextView) listView.findViewById(R.id.news_description);
        //set description
        news_description.setText(currNews.getmDescription());
        //set title
        news_title.setText(currNews.getmTitle());
        //url to image
        String imageUrl = currNews.getmUrlToImage();
        Picasso.with(getContext()).load(imageUrl).fit().into(news_image);
        return listView;
    }

}
