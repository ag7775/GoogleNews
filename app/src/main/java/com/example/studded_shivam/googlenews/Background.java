package com.example.studded_shivam.googlenews;

import android.os.AsyncTask;

import java.util.List;

/**
 * Created by StudDed_SHIVAM on 19-Sep-17.
 */

public class Background extends AsyncTask<String,Void,List<News>>
{


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
        splashActivity splashActivity = new splashActivity();
        splashActivity.fun(data);
    }
}

