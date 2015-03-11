package corp.mahisan.medicinastore;

import android.app.Activity;
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

/**
 * Created by user on 19-01-2015.
 */
public class Register extends ActionBarActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button buttonReg2;
    Toolbar toolbar;
    EditText txtUsername, txtPassword;
    //UserSession session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        txtUsername = (EditText) findViewById(R.id.user);
        txtPassword = (EditText) findViewById(R.id.pass);

        buttonReg2 = (Button) findViewById(R.id.sub);

// creating an shared Preference file for the information to be stored
// first argument is the name of file and second is the mode, 0 is private mode

        sharedPreferences = getApplicationContext().getSharedPreferences("Reg", 0);
// get editor to edit in file
        editor = sharedPreferences.edit();

        buttonReg2.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v) {
                String name = txtUsername.getText().toString();
                if (!isValidUsername(name)) {
                    txtUsername.setError("Min 2 Max 10");
                }
                String pass = txtPassword.getText().toString();
                if (!isValidPassword(pass)) {
                    txtPassword.setError("Min 2 Max 10");
                }

                if(isValidUsername(name)==true && isValidPassword(pass)==true) {

                    // as now we have information in string. Lets stored them with the help of editor
                    editor.putString("Name", name);
                    editor.putString("txtPassword", pass);
                    editor.commit();   // commit the values

                    // after saving the value open next activity
                    Intent ob = new Intent(Register.this, Login.class);
                    ob.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(ob);
                }
            }
        });
    }
    private boolean isValidUsername(String user) {
        if (user != null && user.length() >= 2 && user.length() <10) {
            return true;
        }
        return false;
    }

    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() >= 2 && pass.length() <10) {
            return true;
        }
        return false;
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
