package corp.mahisan.medicinastore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends Activity {
//	MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle sanchitgoel) {
		// TODO Auto-generated method stub
		super.onCreate(sanchitgoel);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);    // Removes title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);    // Removes notification bar
		setContentView(R.layout.splash);

        //ourSong = MediaPlayer.create(Splash.this, R.raw.splashsound);
		//SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		//boolean music = getPrefs.getBoolean("checkbox", true);
		//if (music==true)
		//ourSong.start();
		
		
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(2000);
					
				}catch(InterruptedException e){
					e.printStackTrace();
		}finally{
			Intent openStartingPoint = new Intent(Splash.this,Loginact.class);
			startActivity(openStartingPoint);
		}
			}
	};
	
	timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//ourSong.release();
		finish();
	}
	
}
