package net.hath.hondroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;



/**
 * The activity for hero select. 
 *
 */
public class SelectScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(new List(this, getIntent().getExtras()));
	}
	
}
