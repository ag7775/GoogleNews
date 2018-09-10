package com.example.studded_shivam.googlenews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by StudDed_SHIVAM on 06-Dec-17.
 */

public class LoginActivity extends Activity {
    TextView t1;
    EditText e1,e2;
    public static int flag=0;

    String login_username,login_password;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        e1=(EditText)findViewById(R.id.login_username);
        e2=(EditText)findViewById(R.id.login_password);
        t1=(TextView)findViewById(R.id.signup);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });

    }
    public void login(View view)
    {
        String method="Login";
        login_username=e1.getText().toString();
        login_password=e2.getText().toString();
        BackgroundPhp task=new BackgroundPhp(this);
        task.execute(method,login_username,login_password);
        int m=Redirect.getFlag();
        if(m==1)
        {
            startActivity(new Intent(LoginActivity.this,NewsActivity.class));
        }

    }


}
