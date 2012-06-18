package net.hath.hondroid;

import android.content.Context;
import android.widget.ListView;

public class List extends ListView{

	public List(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		setAdapter(new ListAdapter(context, R.layout.list_row, R.id.list_text, Hero.toList()));
	}

}
