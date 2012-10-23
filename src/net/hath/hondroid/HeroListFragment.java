package net.hath.hondroid;

import java.util.ArrayList;

import net.hath.hondroid.database.DatabaseAdapter;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class HeroListFragment extends Fragment {

	public interface OnHeroSelectListener {
		public void onHeroSelected(Hero hero);
	}

	public static final int SIZE = 160;

	public static final String TAG = "HeroListFragment";
	private Hero[] heroes;

	GridView gv;
	OnHeroSelectListener listener;

	public HeroListFragment() {
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		try {
			listener = (OnHeroSelectListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnHeroSelectedListener");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.grid_view, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		gv = (GridView) getActivity().findViewById(R.id.grid_view);

		gv.setAdapter(new ImageAdapter());

		gv.setDrawSelectorOnTop(true);
		gv.setNumColumns(GridView.AUTO_FIT);
		gv.setColumnWidth(SIZE);

		gv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				// TODO Auto-generated method stub
				listener.onHeroSelected(heroes[position]);
			}
		});
	}

	private class ImageAdapter extends BaseAdapter {
		private Activity activity;
		private SparseArray<Bitmap> cache;

		public ImageAdapter() {
			activity = getActivity();
			cache = new SparseArray<Bitmap>();
			DatabaseAdapter da = new DatabaseAdapter(activity);
			ArrayList<Hero> al = da.getAllHeroes();
			heroes = new Hero[al.size()];
			for (int i = 0; i < al.size(); i++) {
				heroes[i] = al.get(i);
			}
			new BitmapDownloader().execute();
		}

		private class BitmapDownloader extends AsyncTask<Void, Integer, Bitmap> {

			@Override
			protected Bitmap doInBackground(Void... arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < heroes.length; i++) {
					cache.put(i, heroes[i].getIcon(activity));
				}
				return null;
			}
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return heroes.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return heroes[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view = convertView;

			ImageView imageView;
			TextView textView;

			if (convertView == null) { // if it's not recycled, initialize some
										// attributes
				LayoutInflater li = getLayoutInflater(getArguments());
				view = li.inflate(R.layout.labeled_icon, null);
			}

			imageView = (ImageView) view.findViewById(R.id.icon_image);
			Bitmap b = cache.get(position);
			if (b == null) {
				b = heroes[position].getIcon(activity);
				imageView.setImageBitmap(b);
				cache.put(position, b);
			} else {
				imageView.setImageBitmap(b);
			}
			imageView.setImageBitmap(b);

			textView = (TextView) view.findViewById(R.id.icon_text);
			textView.setText(heroes[position].getName());

			view.setLayoutParams(new GridView.LayoutParams(SIZE, SIZE));

			return view;
		}

	}

}
