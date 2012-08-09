package net.hath.hondroid.network;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.ByteArrayBuffer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.util.Log;

public class Downloader {

	public static Bitmap downloadBitmap(String url) {
		final AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
		final HttpGet getRequest = new HttpGet(url);

		try {
			HttpResponse response = client.execute(getRequest);
			final int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				Log.w("ImageDownloader", "Error " + statusCode + " while retrieving bitmap from " + url);
				return null;
			}

			final HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream inputStream = null;
				try {
					inputStream = entity.getContent();
					final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
					return bitmap;
				} finally {
					if (inputStream != null) {
						inputStream.close();
					}
					entity.consumeContent();
				}
			}
		} catch (Exception e) {
			// Could provide a more explicit error message for IOException or
			// IllegalStateException
			getRequest.abort();
			Log.w("ImageDownloader", "Error while retrieving bitmap from " + url);
		} finally {
			if (client != null) {
				client.close();
			}
		}
		return null;

	}

	public static String downloadHTML(String url) {
		int bufferSize = 50;
		try {
			URL myURL = new URL(url);
			URLConnection ucon = myURL.openConnection();
			ucon.setRequestProperty("Connection", "keep-alive");
			InputStream inputStream = ucon.getInputStream();
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(bufferSize);
			byte[] buf = new byte[bufferSize];
			int read;
			do {
				read = bufferedInputStream.read(buf, 0, buf.length);
				if (read > 0)
					byteArrayBuffer.append(buf, 0, read);
			} while (read >= 0);
			return new String(byteArrayBuffer.toByteArray());
		} catch (Exception e) {
			Log.i("Error", e.toString());
		}
		return null;

	}
}
