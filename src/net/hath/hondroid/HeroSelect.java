/**
 * 
 * @author MartinHaTh
 *
 */
package net.hath.hondroid;

import android.app.Activity;
import android.os.Bundle;



/**
 * The activity for hero select. 
 *
 */
public class HeroSelect extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(new List(this));
	}
	
}
