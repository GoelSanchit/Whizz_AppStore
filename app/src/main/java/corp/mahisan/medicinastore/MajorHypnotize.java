package corp.mahisan.medicinastore;

import android.app.Activity
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by user on 05-02-2015.
 */
public class MajorHypnotize extends Activity {
    Animation animTogether;
    ImageView hypnosis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.majorhypnotize);
        hypnosis = (ImageView) findViewById(R.id.hypnosis);
        // load the animation
        animTogether = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.hypnotize);
        hypnosis.startAnimation(animTogether);
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(MajorHypnotize.this,Hypnotize.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        super.onBackPressed();
    }
}
