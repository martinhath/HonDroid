package net.hath.hondroid.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.*;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class NetworkAdapter {

	private static final String HON_URL = "http://www.heroesofnewerth.com/heroes.php";
	private AsyncTask<String, Void, String> rt = new RetreiveTask();

	public ArrayList<Integer> getValidIDs() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		String pattern = "\"\\?hero_id=(\\d+)";
		Pattern p = Pattern.compile(pattern);
		String site = null;
		rt.execute(HON_URL);
		site = rt.toString();
		Matcher m = p.matcher(site);
		while (m.find()) {
			list.add(Integer.parseInt(m.group(1)));
		}
		Collections.sort(list);
		return list;
	}

	class RetreiveTask extends AsyncTask<String, Void, String> {

		private Exception exception;

		protected String doInBackground(String... urls) {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(urls[0]);
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
			return page;
		}
	}

}
