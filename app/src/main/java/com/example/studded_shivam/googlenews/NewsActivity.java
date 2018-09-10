package com.example.studded_shivam.googlenews;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity
{boolean doubleBackToExitPressedOnce = false;
    List<News> data;
    WebView ourBrow;
    public static final String LOG_TAG = NewsActivity.class.getName();
    private NewsAdapter madapter;
    private static final String News_Query="https://newsapi.org/v1/articles?source=google-news&sortBy=top&apiKey=39427ed9e2d143a29696048897be3276";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        data=GetBackgroundData.getData();

        final ListView newslistview=(ListView)findViewById(R.id.list);


        madapter=new NewsAdapter(this,new ArrayList<News>());
        madapter.addAll(data);
        newslistview.setAdapter(madapter);

        newslistview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                News curr_news=madapter.getItem(position);

                //  Uri news_uri=Uri.parse(curr_news.getmUrl());
                 Intent intent=new Intent(NewsActivity.this,WebViewActivity.class);
                  intent.putExtra("URL",curr_news.getmUrl());
                     startActivity(intent);
            }
        });

      //  NewsAsyncTask task=new NewsAsyncTask();
      //  task.execute(News_Query);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 3000);
    }
    /*  private class NewsAsyncTask extends AsyncTask<String, Void, List<News>> {

        @Override
        protected List<News> doInBackground(String... urls) {

            if(urls.length<1 || urls[0]==null)
                    return null;
            List<News> result= QueryUtils.fetchNewsData(urls[0]);
            return  result;
        }

        @Override
        protected void onPostExecute(List<News> data)
        {
            IntentFlag object=new IntentFlag();
            object.setFlag(0);
          View loader=findViewById(R.id.progress_bar);

            loader.setVisibility(View.GONE);
            madapter.clear();
            if(data!=null && !data.isEmpty())
                madapter.addAll(data);

        }
    }*/

}
