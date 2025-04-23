package com.example.bookrecommendationsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "books.db";
    private static final int DATABASE_VERSION = 2; // Increment the version to force an upgrade

    private static final String TABLE_BOOKS = "books";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_AUTHOR = "author";
    private static final String COLUMN_GENRE = "genre";
    private static final String COLUMN_RATING = "rating";
    private static final String COLUMN_LITERATURE_LEVEL = "literature_level"; // New column
    private static final String COLUMN_COVER_IMAGE = "cover_image";

    public Cursor getBookByLevel(String Level) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = "literature_level=?";
        String[] selectionArgs = {Level};

        return db.query(TABLE_BOOKS, null, selection, selectionArgs, null, null, null);
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Updated table creation SQL query to include literature_level column
        String CREATE_TABLE = "CREATE TABLE " + TABLE_BOOKS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_AUTHOR + " TEXT,"
                + COLUMN_GENRE + " TEXT,"
                + COLUMN_RATING + " REAL,"
                + COLUMN_LITERATURE_LEVEL + " INTEGER," // New column
                + COLUMN_COVER_IMAGE + " INTEGER"
                + ")";
        db.execSQL(CREATE_TABLE);

        // Insert sample data
        insertSampleData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the old table and recreate it if the database version changes
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
        onCreate(db);
    }

    private void insertSampleData(SQLiteDatabase db) {
        // Insert books with the new literature_level field
        insertBook(db, "1984", "George Orwell", "Dystopian", 4.7, 3,R.drawable.nineteen_eighty_four);
        insertBook(db, "To Kill a Mockingbird", "Harper Lee", "Fiction", 4.8, 2, R.drawable.to_kill_a_mockingbird);
        insertBook(db, "Moby-Dick", "Herman Melville", "Adventure", 4.1, 3, R.drawable.moby_dick);
        insertBook(db, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 4.4, 3, R.drawable.the_great_gatsby);
        insertBook(db, "Pride and Prejudice", "Jane Austen", "Romance", 4.6, 2, R.drawable.pride_and_prejudice);
        insertBook(db, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 4.0, 2, R.drawable.the_catcher_in_the_rye);
        insertBook(db, "The Hobbit", "J.R.R. Tolkien", "Fantasy", 4.9, 1, R.drawable.the_hobbit);
        insertBook(db, "Brave New World", "Aldous Huxley", "Sci-Fi", 4.5, 3, R.drawable.brave_new_world);
        insertBook(db, "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 4.9, 2, R.drawable.the_lord_of_rings);
        insertBook(db, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", 4.8, 1, R.drawable.harry_potter_and_the_sorcerers_stone);
        insertBook(db, "The Hunger Games", "Suzanne Collins", "Dystopian", 4.7, 1, R.drawable.the_hunger_games);
        insertBook(db, "The Da Vinci Code", "Dan Brown", "Thriller", 4.3, 2, R.drawable.the_da_vinci_code);
        insertBook(db, "The Alchemist", "Paulo Coelho", "Adventure", 4.6, 1, R.drawable.the_alchemist);
    }

    private void insertBook(SQLiteDatabase db, String title, String author, String genre, double rating, int literatureLevel, int coverImage) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_AUTHOR, author);
        values.put(COLUMN_GENRE, genre);
        values.put(COLUMN_RATING, rating);
        values.put(COLUMN_LITERATURE_LEVEL, literatureLevel); // Insert literature level
        values.put(COLUMN_COVER_IMAGE,coverImage);
        db.insert(TABLE_BOOKS, null, values);
    }

    public Cursor getAllBooks() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_BOOKS,
                null, null, null, null, null, null);
    }

    public BookData getBook(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BOOKS, null, COLUMN_ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            BookData book = new BookData(
                    cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AUTHOR)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_GENRE)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_RATING)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_LITERATURE_LEVEL)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_COVER_IMAGE))// Retrieve literature level
            );
            cursor.close();
            return book;
        }
        return null;
    }
}
