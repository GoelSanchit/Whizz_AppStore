package corp.mahisan.medicinastore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;


public class Mood_Scanner extends ActionBarActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_scanner);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mood Scanner");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(2000);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent openStartingPoint = new Intent(Mood_Scanner.this, Mood.class);
                    startActivity(openStartingPoint);
                }
            }
        };
        timer.start();
        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id ==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        if(id == R.id.tour){
            Intent intent = new Intent(this,ListView1.class);
            startActivity(intent);
        }
        if(id == R.id.Medicina){
            Intent intent = new Intent(this,ListView2.class);
            startActivity(intent);
        }
        if(id == R.id.Social){
            Intent intent = new Intent(this,ListView3.class);
            startActivity(intent);
        }
        if(id == R.id.Shopping){
            Intent intent = new Intent(this,ListView4.class);
            startActivity(intent);
        }
        if(id == R.id.News){
            Intent intent = new Intent(this,ListView5.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Mood_Scanner.this,ListView2.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        super.onBackPressed();
    }
}

