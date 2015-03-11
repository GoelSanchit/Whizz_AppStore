package corp.mahisan.medicinastore;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class MyActivity extends ActionBarActivity implements View.OnClickListener {
    ListView lv;
    Context context;
    Toolbar toolbar;
    UserSession session;
    // flag for Internet connection status
    Boolean isInternetPresent = false;

    // Connection detector class
    ConnectionDetector cd;
    private static final String TAG_Tour_Travel = "tourTravel";
    private static final String TAG_Medicina = "Medicina";
    private static final String TAG_Social_Network = "socialNetwork";
    private static final String TAG_Shopping_Utility = "shoppingUtility";
    private static final String TAG_NewsPaper = "newsPaper";

    public static int [] prgmImages={R.drawable.indianrailway,R.drawable.generic_medicines,R.drawable.delhimetro,R.drawable.quit_smoking,R.drawable.facebook,R.drawable.flipkart,R.drawable.newshunt};
    public static String [] prgmNameList={"Indian Railway","Generic Medicines","Delhi Metro","Quit Smoking","Facebook","Flipkart","NewsHunt"};
    public static  String[] prgmDesc={"This Fetches the PNR & Train Enquiry schedule","This Application Give you the information of disease you type","Directions From Delhi Metro App","Quit Smoking App Tells you how much prone you are in keep smoking.","The Facebook App Lets you to intract with your friends","The Flipkart App lets you purchase most valuable products.","NewsHunt App provides you reading all indian newspaper."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Whizz AppStore");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        context=this;
        lv=(ListView) findViewById(R.id.listView);
        // creating connection detector class instance
        cd = new ConnectionDetector(getApplicationContext());
        // get Internet status
        isInternetPresent = cd.isConnectingToInternet();
        // check for Internet status
        if (isInternetPresent) {
            lv.setAdapter(new CustomAdapterMain(this, prgmNameList, prgmImages, prgmDesc));
        }else {
            // Internet connection is not present
            // Ask user to connect to Internet
            showAlertDialog(MyActivity.this, "No Internet Connection",
                    "You don't have internet connection.", false);
        }
        actionBarButton();

    }

    private void actionBarButton() {
        //define the icon for the main floating action button
        ImageView iconActionButton = new ImageView(this);
        iconActionButton.setImageResource(R.drawable.ic_action_new);

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(iconActionButton)
                .setBackgroundDrawable(R.drawable.selector_button_red)
                .build();

        //define the icons for the sub action buttons
        ImageView TourAndTravel = new ImageView(this);
        TourAndTravel.setImageResource(R.drawable.tourtravel);
        ImageView MedicinaStore = new ImageView(this);
        MedicinaStore.setImageResource(R.drawable.medicina);
        ImageView SocialNetwork = new ImageView(this);
        SocialNetwork.setImageResource(R.drawable.socialnetwork);
        ImageView ShoppingAndUtility = new ImageView(this);
        ShoppingAndUtility.setImageResource(R.drawable.shopping);
        ImageView Newspaper = new ImageView(this);
        Newspaper.setImageResource(R.drawable.newspaper);

        //set the background for all the sub buttons
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        itemBuilder.setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_sub_button_gray));

        //build the sub buttons
        SubActionButton Tour = itemBuilder.setContentView(TourAndTravel).build();
        SubActionButton Med = itemBuilder.setContentView(MedicinaStore).build();
        SubActionButton Social = itemBuilder.setContentView(SocialNetwork).build();
        SubActionButton Shopping = itemBuilder.setContentView(ShoppingAndUtility).build();
        SubActionButton News = itemBuilder.setContentView(Newspaper).build();

        Tour.setTag(TAG_Tour_Travel);
        Med.setTag(TAG_Medicina);
        Social.setTag(TAG_Social_Network);
        Shopping.setTag(TAG_Shopping_Utility);
        News.setTag(TAG_NewsPaper);

        Tour.setOnClickListener(this);
        Med.setOnClickListener(this);
        Social.setOnClickListener(this);
        Shopping.setOnClickListener(this);
        News.setOnClickListener(this);

        //add the sub buttons to the main floating action button
        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(Tour)
                .addSubActionView(Med)
                .addSubActionView(Social)
                .addSubActionView(Shopping)
                .addSubActionView(News)
                .attachTo(actionButton)
                .build();
    }

    public void showAlertDialog(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage(message);

        // Setting alert dialog icon
        alertDialog.setIcon(R.drawable.fail);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        // Showing Alert Message
        alertDialog.show();
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
            Intent intent = new Intent(MyActivity.this,ListView1.class);
            startActivity(intent);
        }
        if(id == R.id.Medicina){
            Intent intent = new Intent(MyActivity.this,ListView2.class);
            startActivity(intent);
        }
        if(id == R.id.Social){
            Intent intent = new Intent(MyActivity.this,ListView3.class);
            startActivity(intent);
        }
        if(id == R.id.Shopping){
            Intent intent = new Intent(MyActivity.this,ListView4.class);
            startActivity(intent);
        }
        if(id == R.id.News){
            Intent intent = new Intent(MyActivity.this,ListView5.class);
            startActivity(intent);
        }
        if(id == R.id.Share){
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Share By Medicina,The App That Matters");
            startActivity(Intent.createChooser(shareIntent, "Share your thoughts"));
        }

        if(id == R.id.Logout) {
            session = new UserSession(getApplicationContext());
            session.logoutUser();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        System.exit(0);
                        MyActivity.super.onBackPressed();
                    }
                }).create().show();
    }

    @Override
    public void onClick(View v) {
        if (v.getTag().equals(TAG_Tour_Travel)) {
            Intent i = new Intent (this,ListView1.class);
            startActivity(i);
        }
        if (v.getTag().equals(TAG_Medicina)) {
            Intent i = new Intent (this,ListView2.class);
            startActivity(i);
        }
        if (v.getTag().equals(TAG_Social_Network)) {
            Intent i = new Intent (this,ListView3.class);
            startActivity(i);
        }
        if (v.getTag().equals(TAG_Shopping_Utility)) {
            Intent i = new Intent (this,ListView4.class);
            startActivity(i);
        }
        if (v.getTag().equals(TAG_NewsPaper)) {
            Intent i = new Intent (this,ListView5.class);
            startActivity(i);
        }

    }
}
