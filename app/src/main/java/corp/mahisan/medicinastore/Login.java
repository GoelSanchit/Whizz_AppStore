package corp.mahisan.medicinastore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 19-01-2015.
 */
public class Login extends ActionBarActivity {
    //public static android.content.SharedPreferences SharedPreferences = null;

    private static final String PREFER_NAME = "Reg";

    Button buttonLogin;
    Toolbar toolbar;
    EditText txtUsername, txtPassword

    // User Session Manager Class
    UserSession session;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // User Session Manager
        session = new UserSession(getApplicationContext());
        if (session.isUserLoggedIn() == true) {
            Intent go = new Intent(Login.this, MyActivity.class);
            go.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(go);
        } else {

            // get Email, Password input text
            txtUsername = (EditText) findViewById(R.id.user);
            txtPassword = (EditText) findViewById(R.id.pass);

            Toast.makeText(getApplicationContext(),
                    "User Login Status: " + session.isUserLoggedIn(),
                    Toast.LENGTH_LONG).show();


            // User Login button
            buttonLogin = (Button) findViewById(R.id.sub);

            sharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);
            // Login button click event
            buttonLogin.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {

                    // Get username, password from EditText
                    String username = txtUsername.getText().toString();
                    String password = txtPassword.getText().toString();

                    // Validate if username, password is filled
                    if (username.trim().length() > 0 && password.trim().length() > 0) {
                        String uName = null;
                        String uPassword = null;

                        if (sharedPreferences.contains("Name")) {
                            uName = sharedPreferences.getString("Name", "");

                        }

                        if (sharedPreferences.contains("txtPassword")) {
                            uPassword = sharedPreferences.getString("txtPassword", "");

                        }

                        // Object uName = null;
                        // Object uEmail = null;
                        if (username.equals(uName) && password.equals(uPassword)) {

                            session.createUserLoginSession(uName,
                                    uPassword);

                            // Starting MainActivity
                            Intent i = new Intent(getApplicationContext(), MyActivity.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(i);

                            finish();

                        } else {

                            // username / password doesn't match&
                            Toast.makeText(getApplicationContext(),
                                    "Username/Password is incorrect",
                                    Toast.LENGTH_LONG).show();

                        }
                    } else {

                        // user didn't entered username or password
                        Toast.makeText(getApplicationContext(),
                                "Please enter username and password",
                                Toast.LENGTH_LONG).show();

                    }

                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id ==android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this,Loginact.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        super.onBackPressed();
    }
}
