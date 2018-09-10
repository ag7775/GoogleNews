package com.example.studded_shivam.googlenews;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundPhp extends AsyncTask<String,Void,String>
{
    Context ctx;
    private static final String TAG="Background";
    BackgroundPhp(Context ctx)
    {
        this.ctx=ctx;
    }
    String login_url="http://10.0.129.174/Android/login.php";
    String register_url="http://10.0.129.174/Android/register.php";

    @Override
    protected String doInBackground(String... params) {
        String method = params[0];
        if(method=="register")
        {
            String username = params[1];
            String name=params[2];
            String email=params[3];
            String password=params[4];

            try {
                URL url = new URL(register_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data_string = URLEncoder.encode("username","UTF-8") + "=" + URLEncoder.encode(username,"UTF-8") +"&"+
                        URLEncoder.encode("name","UTF-8") + "=" + URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8") + "=" + URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8") + "=" + URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(data_string);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                inputStream.close();
                httpURLConnection.disconnect();
                return "Successfully Register";
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "Problem Please try after some time";
        }
        else if(method.equals("Login"))
        {
            String user_login = params[1];
            String user_pass = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data_string = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(user_login, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8");
                Log.e(TAG,data_string);
                bufferedWriter.write(data_string);

                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String response="";
                String line="";
                while((line=bufferedReader.readLine())!=null)
                    response+=line;
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "Login Failed";
        }
        return null;
    }
    @Override
    protected void onPostExecute(String s) {
        if(s.equals("1"))
        {
            Redirect.setFlag(1);
            Toast.makeText(ctx,"Login Success", Toast.LENGTH_SHORT).show();
        }
        else if(s.equals("0"))
            Toast.makeText(ctx,"Incorrect Username/Password", Toast.LENGTH_SHORT).show();
    }

}