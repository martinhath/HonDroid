package net.hath.hondroid;

import java.io.File;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class Hero implements Comparable<Hero> {
	
	private static final String TAG = "Hero";
	
	private int id;
	private String name;
	private Faction faction;
	private Attribute attribute;
	private Spell[] spells;

	public Hero(int id, String n, Faction f, Attribute a, Spell[] spells) {
		this.id = id;
		name = n;
		faction = f;
		attribute = a;
		this.spells = spells;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Faction getFaction() {
		return faction;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public Bitmap getIcon(Context context) {
		File fname = context.getFileStreamPath("hero_"+id);
		Bitmap bm = BitmapFactory.decodeFile(fname.toString());
		return bm;
	}
	public Bitmap getSpellIcon(Context context, int num){  
		File fname = context.getFileStreamPath("spell_"+num+"_"+id); // spell_num_id
		Bitmap bm = BitmapFactory.decodeFile(fname.toString());
		return bm;
	}

	@Override
	public int compareTo(Hero another) {
		// TODO Auto-generated method stub
		return name.compareTo(another.getName());
	}
	public Spell getSpell(int num){
		return spells[num];
	}
	public Spell[] getSpells(){
		return spells;
	}

}
