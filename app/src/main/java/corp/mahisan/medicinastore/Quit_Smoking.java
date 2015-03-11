package corp.mahisan.medicinastore;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 13-02-2015.
 */
public class Quit_Smoking extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    TextView tv;
    ImageView iv;
    Toolbar toolbar;
    Animation animFadein,animBounce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quit_smoking);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Quit Smoking");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spin);
        tv = (TextView) findViewById(R.id.textView2);
        iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageResource(R.drawable.smoking1);
        tv.setMovementMethod(new ScrollingMovementMethod());

        List<String> list = new ArrayList<String>();
        list.add("Select Category");
        list.add("1-2 Cigrate");
        list.add("3-4 Cigrate");
        list.add("5-6 Cigrate");
        list.add("7-More Cigrate");

        animFadein = AnimationUtils.loadAnimation(this,
                R.anim.fade_in);
        animBounce = AnimationUtils.loadAnimation(this,
                R.anim.bounce);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list);

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
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
        Intent i = new Intent(Quit_Smoking.this,ListView2.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        super.onBackPressed();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

        switch(position){
            case 1:
                tv.setScrollY(0);
                tv.startAnimation(animBounce);
                tv.setText("Caused Effect:\n" +
                                "Heart and Blood Vessel starting cloting in the inner side of the body creating a dynamic circulation in the bodyPeople who smoke cigarettes are also at a grave risk of heart attack and stroke. The carbon monoxide that lives in cigarette smoke has been associated with hardening of arteries, which can lead to stroke caused by blood clots in the brain." +
                                "\n\nEffect On Lungs:" +
                                "\nIn the initial stage of smoking lungs can't suit. Many subatomic particles effect the alevoli circulation and slowly degrades the portion of lungs." +
                                "\n\nDanger:" +
                                "\nProne level is high as one pack a day but you will live 4 years more than the person who is taking cigrate continuosly." +
                                "\n\nOther Side Effects:" +
                                "\nYellowing of the teeth." +
                                "\n\nDevelopment of wrinkles at an early age." +
                                "\n\nSoar throat" +
                                "\n\nBad breath."
                );
                iv.startAnimation(animFadein);
                iv.setImageResource(R.drawable.smoking1);
                break;
            case 2:
                tv.setScrollY(0);
                tv.startAnimation(animBounce);
                tv.setText("Caused Effect:\n" +
                                "The most common side effect of smoking cigarettes is cancer. While tobacco increases a person’s risk of developing various types of cancers, the most common is lung cancer. Cigarette smoke also significantly increases a person’s risk of developing cancer of the mouth, lips, throat or voice box." +
                                "\n" +
                                "\nEffect On Lungs:" +
                                "\nLung disease is one of the most serious side effects of smoking cigarettes. The chemicals in smoke can damage the cilia, or the little hairs that protect the lungs from dirt and other waste. Over time, dirt will begin to collect on the lungs, leading to lung disease" +
                                "\n" +
                                "\nDanger:" +
                                "\nIf the Human is continuously taking 4 cigrate a day then there is no chance for survive. He will not continue it's cycle of living,and soon there will be many disease to that person." +
                                "\n\nOther Side Effects:" +
                                "\nHigher risk of bone fractures in the wrist, hip or spine\n" +
                                "\nDifficulty sleeping."
                );
                iv.setImageResource(R.drawable.smoking2);
                iv.startAnimation(animFadein);
                break;
            case 3:
                tv.setScrollY(0);
                tv.startAnimation(animBounce);
                tv.setText("Caused Effect:\n" +
                                "The chemicals in tobacco smoke harm your blood cells and damage the function of your heart. This damage increases your risk for:\n\n" +
                                "Atherosclerosis, a disease in which a waxy substance called plaque builds up in your arteries\n\n" +
                                "Aneurysms, which are bulging blood vessels that can burst and cause death\n\n" +
                                "Coronary heart disease (CHD), narrow or blocked arteries around the heart\n\n" +
                                "Heart attack and damage to your arteries\n\n" +
                                "Effect On Lungs:\n" +
                                "Chronic obstructive pulmonary disease (COPD), a disease that gets worse over time and causes wheezing, shortness of breath, chest tightness, and other symptoms\n" +
                                "Emphysema, a condition in which the walls between the air sacs in your lungs lose their ability to stretch and shrink back. Your lung tissue is destroyed, making it difficult or impossible to breathe.\n" +
                                "Tuberculosis \n\n" +
                                "Danger:\n" +
                                "Intense smoking can kill you in one year and can cause cancer in 30 days.Tobacco smoke contains over 60 known cancer-causing chemicals. Smoking harms nearly every organ in the body, causing many diseases and reducing health in general.\n\n" +
                                "Other Side Effects:" +
                                "Bad smell in clothes, skin and hair\n" +
                                "\n" +
                                "Higher risk of bone fractures in the wrist, hip or spine"
                );
                iv.setImageResource(R.drawable.smoking3);
                iv.startAnimation(animBounce);
                break;
            case 4:
                tv.setScrollY(0);
                tv.startAnimation(animBounce);
                tv.setText("Caused Effects:\n" +
                        "Smoking causes many other types of cancer, including cancers of the throat, mouth, nasal cavity, esophagus, stomach, pancreas, kidney, bladder, and cervix, as well as acute myeloid leukemia.\n\n" +
                        "Danger:" +
                        "Smoking kills half of all people who continue to smoke\n\n" +
                        "At least one in four of those people die between the ages of 35-69.\n\n" +
                        "A smoker who does not quit loses on average 10 years of their life.\n\n" +
                        "Smoking is responsible for about 85% of lung cancers.\n\n" +
                        "Smokers are 20 times more likely to develop lung cancer.\n\n" +
                        "Smoking increases the risk of heart attack 2-6 times.\n\n" +
                        "5.6 million children alive today will ultimately die early from smoking. That is equal to 1 child out of every 13 alive in the U.S. today.\n\n" +
                        "Each day, more than 3,200 people under 18 smoke their first cigarette, and approximately 2,100 youth and young adults become daily smokers.");
                iv.startAnimation(animBounce);
                iv.setImageResource(R.drawable.smoking4);
                break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

