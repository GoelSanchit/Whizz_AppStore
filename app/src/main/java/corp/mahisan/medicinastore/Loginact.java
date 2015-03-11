package corp.mahisan.medicinastore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class Loginact extends ActionBarActivity implements View.OnClickListener {
    Button login,register;
    UserSession session;
    Toolbar toolbar;
   // RelativeLayout loginact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginact);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login & Register");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        session = new UserSession(getApplicationContext());
       // loginact = (RelativeLayout) findViewById(R.id.loginact);
        if(session.isUserLoggedIn()==true){
            Intent go = new Intent(Loginact.this,MyActivity.class);
         //   loginact.setVisibility(View.INVISIBLE);
            go.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(go);
        }
        else {
            login = (Button) findViewById(R.id.login);
            register = (Button) findViewById(R.id.register);
            login.setOnClickListener(this);
            register.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                // it was the first button
                Intent login = new Intent(Loginact.this,Login.class);
                login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(login);
                break;
            case R.id.register:
                // it was the second button
                Intent register = new Intent(Loginact.this,Register.class);
                register.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(register);
                break;
        }
    }
}

