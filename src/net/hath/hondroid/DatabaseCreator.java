package net.hath.hondroid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.hath.hondroid.database.DatabaseAdapter;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DatabaseCreator extends Activity {

	private HashMap<Integer, String> pages;
	private static final String HON_URL = "http://www.heroesofnewerth.com/heroes.php";
	private Downloader dl;
	private ProgressBar pb;
	private TextView tv;
	private DatabaseAdapter da;

	private static Handler myHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.db_creator);
		pages = new HashMap<Integer, String>();

		da = new DatabaseAdapter(this);

		tv = (TextView) findViewById(R.id.dbcreator_text);
		pb = (ProgressBar) findViewById(R.id.dbcreator_progress);
		dl = new Downloader();

		if (!isConnected()) {
			tv.setText(R.string.nonetwork);
			return;
		}
		dl.execute(HON_URL);

		myHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {

				if (msg.arg1 == 1) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					String pattern = "\"\\?hero_id=(\\d+)";
					Pattern p = Pattern.compile(pattern);
					Matcher m = p.matcher(pages.get(2)); // Get "main page"
					while (m.find()) {
						list.add(Integer.parseInt(m.group(1)));
					}
					Collections.sort(list);
					// Creates a list of URLs
					String[] urls = new String[10];
					for (int i = 0; i < 10; i++) {
						urls[i] = HON_URL + "?hero_id=" + list.get(i);
					}
					new Downloader().execute(urls);
				}
			}
		};
	}

	private void parse() {
		int i = 0;
		int l = pages.keySet().size();
		for (Integer key : pages.keySet()) {
			Log.d("hath", pages.get(key).length() + "");
			i++;
			// Name
			String pattern = "hero_name\\\">(\\w+)";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(pages.get(key));
			String name = m.find() ? m.group(1) : "";
			// Faction
			pattern = "Team:</span>\\s(\\w+)";
			p = Pattern.compile(pattern);
			m = p.matcher(pages.get(key));
			String faction = m.find() ? m.group(1) : "";
			// Primary attribute
			pattern = "Type:</span>\\s(\\w+)";
			p = Pattern.compile(pattern);
			m = p.matcher(pages.get(key));
			String attribute = m.find() ? m.group(1) : "";
			
			Log.d("hath", String.format("%d, %s, %s, %s",key,name,faction,attribute));
			
			da.addHero(key, name, faction, attribute);
			tv.setText(getString(R.string.managing) + i + "/" + l);
		}
	}

	private boolean isConnected() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = cm.getActiveNetworkInfo();
		return networkInfo != null && networkInfo.isConnected();
	}

	private class Downloader extends AsyncTask<String, Integer, String> {

		@Override
		protected String doInBackground(String... urls) {
			// TODO Auto-generated method stub
			for (int i = 0; i < urls.length; i++) {
				DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet(urls[i]);
				ResponseHandler<String> resHandler = new BasicResponseHandler();
				String page = "";
				try {
					page = httpClient.execute(httpGet, resHandler);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pages.put(urls[i].length()>50?Integer.parseInt(urls[i].substring(50)):2,page);
				publishProgress(i + 1, urls.length);
			}
			return urls.length + "";
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			pb.setMax(values[1]);
			pb.setProgress(values[0]);
			tv.setText(getString(R.string.downloading) + values[0] + "/" + values[1]);
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			Log.d("hath", "onPostExecute");
			if (result.equals("1")) {
				tv.setText(R.string.dbcreator_connected);
				Message msg = myHandler.obtainMessage();
				msg.arg1 = 1;
				myHandler.sendMessage(msg);
				return;
			}
			parse();
		}

	}
}
