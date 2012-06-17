package net.hath.hondroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class HonDroidActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		((ImageView) findViewById(R.id.header_btn_home)).setOnClickListener(new ImageView.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.w("hath", "Home");
			}
		});

		((Button) findViewById(R.id.main_btn_hero)).setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.w("hath", "Hero screen");
				Intent intent = new Intent(HonDroidActivity.this, HeroSelection.class);
				startActivity(intent);
			}
		});
		
		((Button) findViewById(R.id.main_btn_item)).setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.w("hath", "Item screen");
			}
		});
	}
}