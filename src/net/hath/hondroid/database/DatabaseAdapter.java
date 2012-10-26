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
	private static final String DATABASE_NAME = "hondb";
	private static final String TABLE_HERO = "Hero";
	private static final String TABLE_SPELL = "Spell";
	// Hero table column names
	private static final String KEY_ID = "_id";
	private static final String KEY_NAME = "name";
	private static final String KEY_FACTION = "faction";
	private static final String KEY_ATTRIBUTE = "attribute";
	// Spell table column names
	private static final String KEY_HERO_ID = "heroid";
	private static final String KEY_NUM = "num";
	private static final String KEY_DESC = "desc";

	public DatabaseAdapter(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_HERO_TABLE = "CREATE TABLE " + TABLE_HERO + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_FACTION + " TEXT,"
				+ KEY_ATTRIBUTE + " TEXT" + ")";
		String CREATE_SPELL_TABLE = "CREATE TABLE " + TABLE_SPELL + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT," + KEY_DESC
				+ " TEXT," + KEY_HERO_ID + " INTEGER," + KEY_NUM + " INTEGER" + ")";
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
		Log.d(TAG, "Hero added: "+name);
	}

	public Hero getHero(int id) {
		String query = "SELECT * FROM " + TABLE_HERO + " WHERE " + KEY_ID + " = " + id;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		if (!cursor.moveToFirst()) {
			return null;
		}
		Log.i(TAG, "Fetching: " + id + " " + cursor.getString(1));
		Hero h = new Hero(id, cursor.getString(1), Faction.get(cursor.getString(2)), Attribute.get(cursor.getString(3)));
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
			list.add(new Hero(cursor.getInt(0), cursor.getString(1), Faction.get(cursor.getString(2)), Attribute.get(cursor.getString(3))));
		} while (cursor.moveToNext());
		db.close();
		Collections.sort(list);
		return list;
	}

	public void addSpell(int id, int num, String name, String desc) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, name);
		values.put(KEY_DESC, desc);
		values.put(KEY_HERO_ID, id);
		values.put(KEY_NUM, num);

		// Inserting Row
		db.insert(TABLE_SPELL, null, values);
		db.close(); // Closing database connection
		Log.d(TAG, "Spell added: "+name);
	}

	public Spell[] getSpells(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		String query = "SELECT * FROM " + TABLE_SPELL + " WHERE " + KEY_HERO_ID + " = ?";
		Cursor cursor = db.rawQuery(query, new String[] { Integer.toString(id) });
		Spell[] spells = new Spell[4];
		// No match
		if (!cursor.moveToFirst()) { 
			Log.i(TAG, "Spells for Hero id:" + id + " was not found.");
			return null;
		}
		
		int counter = 0;
		do {
			spells[counter++] = new Spell(cursor.getString(1), cursor.getString(2), id, cursor.getInt(4));
		} while (cursor.moveToNext());
		db.close();
		return spells;

	}

	public Spell getSpell(int id, int num) {
		SQLiteDatabase db = this.getReadableDatabase();
		String query = "SELECT * FROM " + TABLE_SPELL + " WHERE " + KEY_HERO_ID + " = ? and " + KEY_NUM + " = ?";
		Cursor cursor = db.rawQuery(query, new String[] { Integer.toString(id), Integer.toString(num) });
		if (!cursor.moveToFirst()) {
			return null;
		}
		Spell spell = new Spell(cursor.getString(1), cursor.getString(2), id, num);
		db.close();
		return spell;
	}
}
