package net.hath.hondroid.database;

import java.util.ArrayList;
import java.util.Collections;

import net.hath.hondroid.Attribute;
import net.hath.hondroid.Faction;
import net.hath.hondroid.Hero;
import net.hath.hondroid.Spell;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseAdapter extends SQLiteOpenHelper {

	private static final String TAG = "DatabaseAdapter";

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "HeroManager";
	private static final String TABLE_HERO = "Hero";
	private static final String TABLE_SPELL = "Spell";
	// Hero table column names
	private static final String KEY_ID = "_id";
	private static final String KEY_NAME = "name";
	private static final String KEY_FACTION = "faction";
	private static final String KEY_ATTRIBUTE = "attribute";
	private static final String KEY_ICON_ID = "icon_id";
	private static final String KEY_DESC = "desc";

	public DatabaseAdapter(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_HERO_TABLE = "CREATE TABLE " + TABLE_HERO + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_FACTION + " TEXT,"
				+ KEY_ATTRIBUTE + " TEXT," + KEY_ICON_ID + " INTEGER" + ")";
		String CREATE_SPELL_TABLE = "CREATE TABLE " + TABLE_SPELL + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_DESC + " TEXT" + ")";
		db.execSQL(CREATE_HERO_TABLE);
		db.execSQL(CREATE_SPELL_TABLE);
	}

	// TODO: Fix function. Does only account for hero table
	public boolean isEmpty() {
		SQLiteDatabase db = this.getReadableDatabase();
		String q = "SELECT * FROM " + TABLE_HERO;
		Cursor cursor = db.rawQuery(q, null);
		Boolean ret = !cursor.moveToFirst();
		db.close();
		return ret;
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_HERO);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SPELL);
		onCreate(db);
	}

	@Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_HERO);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SPELL);
		onCreate(db);
	}

	public void addHero(int id, String name, String fac, String attr) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_ID, id);
		values.put(KEY_NAME, name);
		values.put(KEY_FACTION, fac);
		values.put(KEY_ATTRIBUTE, attr);

		// Inserting Row
		db.insert(TABLE_HERO, null, values);
		db.close(); // Closing database connection
	}

	public Hero getHero(int id) {
		String query = "SELECT * FROM " + TABLE_HERO + " WHERE " + KEY_ID + " = " + id;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		if (!cursor.moveToFirst()) {
			return null;
		}
		Log.i(TAG, "Fetching: " + id + " " + cursor.getString(1));
		Hero h = new Hero(id, cursor.getString(1), Faction.get(cursor.getString(2)), Attribute.get(cursor.getString(3)), getSpells(id));
		db.close();
		return h;
	}

	public ArrayList<Hero> getAllHeroes() {
		ArrayList<Hero> list = new ArrayList<Hero>();
		SQLiteDatabase db = this.getReadableDatabase();
		String query = "SELECT * FROM " + TABLE_HERO;
		Cursor cursor = db.rawQuery(query, null);
		if (!cursor.moveToFirst()) {
			return list;
		}
		do {
			list.add(new Hero(cursor.getInt(0), cursor.getString(1), Faction.get(cursor.getString(2)), Attribute.get(cursor.getString(3)), getSpells(cursor
					.getInt(0))));
		} while (cursor.moveToNext());
		db.close();
		Collections.sort(list);
		return list;
	}

	public void addSpell(int id, int num, String name, String desc) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_ID, id + "" + num);
		values.put(KEY_NAME, name);
		values.put(KEY_DESC, desc);

		// Inserting Row
		db.insert(TABLE_SPELL, null, values);
		db.close(); // Closing database connection
	}

	public Spell[] getSpells(int id) {
		Spell[] spells = new Spell[4];
		for (int i = 0; i < 4; i++) {
			spells[i] = getSpell(id, i);
		}
		return spells;
	}

	public Spell getSpell(int id, int num) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_SPELL, new String[] { KEY_ID, KEY_NAME, KEY_DESC }, KEY_ID + "=" + id + "" + num, null, null, null, null);
		if (!cursor.moveToFirst()) {
			return null;
		}
		Spell spell = new Spell(cursor.getString(1), cursor.getString(2), id, num);
		db.close();
		return spell;
	}
}
