/**
 * @Author MartinHaTh
 */
package net.hath.hondroid.activities;

import net.hath.hondroid.R;
import net.hath.hondroid.R.id;
import net.hath.hondroid.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
/**
 * Main activity for the app.
 * Selection screen. 
 * 
 * @author MartinHaTh
 *
 */
public class MainScreen extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		
		// Home
		((ImageView) findViewById(R.id.header_btn_home)).setOnClickListener(new ImageView.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.w("hath", "Home");
			}
		});
		// Hero pick screen
		((Button) findViewById(R.id.main_btn_hero)).setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainScreen.this, SelectScreen.class);
				Bundle b = new Bundle();
				b.putString("type", "hero");
				intent.putExtras(b);
				startActivity(intent);
			}
		});
		// Item pick screen
		((Button) findViewById(R.id.main_btn_item)).setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainScreen.this, SelectScreen.class);
				Bundle b = new Bundle();
				b.putString("type", "item");
				intent.putExtras(b);
				startActivity(intent);
			}
		});
	}
}