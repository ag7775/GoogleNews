package com.example.studded_shivam.googlenews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by StudDed_SHIVAM on 18-Sep-17.
 */

public class splashActivity extends AppCompatActivity
{
    int flag=1;
    private static final String News_Query="https://newsapi.org/v1/articles?source=google-news&sortBy=top&apiKey=39427ed9e2d143a29696048897be3276";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Background background = new Background();
        background.execute(News_Query);

        Thread t = new Thread(){
            @Override
            public void run()
            {
                while(flag==1)
                {
                    int x=IntentFlag.getFlag();
                    if(x==0)
                    {
                        Intent intent = new Intent(splashActivity.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                        flag=0;
                    }
                }
            }
        };
        t.start();
    }

    public void fun(List<News> data)
    {
       GetBackgroundData.setData(data);
    }

}


