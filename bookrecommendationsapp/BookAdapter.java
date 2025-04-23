package com.example.bookrecommendationsapp;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private Context mContext;
    private Cursor mCursor;
//    private List<BookData> bookList;

    // Constructor
    public BookAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
//        this.bookList = bookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.book_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        BookData book = bookList.get(position);
        if (mCursor.moveToPosition(position)) {
            // Assuming your Cursor has "image_url" and "text" columns
            int imageUrl = mCursor.getInt(mCursor.getColumnIndexOrThrow("cover_image"));
            String title = mCursor.getString(mCursor.getColumnIndexOrThrow("title"));
            String author = mCursor.getString(mCursor.getColumnIndexOrThrow("author"));
            String genre = mCursor.getString(mCursor.getColumnIndexOrThrow("genre"));
            String rating = mCursor.getString(mCursor.getColumnIndexOrThrow("rating"));
            String literature_level = mCursor.getString(mCursor.getColumnIndexOrThrow("literature_level"));

            // Load the image using Picasso
            Picasso.get().load(imageUrl).resize(400, 500).into(holder.imageViewBookCover);
            holder.imageViewBookCover.setOnClickListener(v -> showBookDetailsDialog(title, author, genre, rating, literature_level, imageUrl));
        }
    }

    @Override
    public int getItemCount() {
        return (mCursor == null) ? 0 : mCursor.getCount();
    }

    // Method to swap Cursor when data changes (important for CursorAdapters)
    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close();
        }
        mCursor = newCursor;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewBookCover;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewBookCover = itemView.findViewById(R.id.coverImageView); // Book cover ImageView
        }
    }
    // Method to show book details in a dialog
    private void showBookDetailsDialog(String title, String author, String genre, String rating, String literatureLevel, int imageUrl) {
        // Create the dialog
        Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.activity_book);

        dialog.setCancelable(true);

        // Get references to the dialog's views
        ImageView popupImageViewBookCover = dialog.findViewById(R.id.coverImageView);
        TextView popupTextViewTitle = dialog.findViewById(R.id.titleTextView);
        TextView popupTextViewAuthor = dialog.findViewById(R.id.authorTextView);
        TextView popupTextViewGenre = dialog.findViewById(R.id.genreTextView);
        TextView popupTextViewRating = dialog.findViewById(R.id.ratingTextView);
        TextView popupTextViewLiteratureLevel = dialog.findViewById(R.id.literatureLevelTextView);

        String textAuthor = "Author: " + author;
        String textGenre = "Genre: " + genre;
        String textRating = "Rating: " + rating + "/5";
        String textLevel = "Level: " + literatureLevel;

        // Populate the dialog's views with book details
        Picasso.get().load(imageUrl).resize(400, 500).into(popupImageViewBookCover);
        popupTextViewTitle.setText(title);
        popupTextViewAuthor.setText(textAuthor);
        popupTextViewGenre.setText(textGenre);
        popupTextViewRating.setText(textRating);
        popupTextViewLiteratureLevel.setText(textLevel);

        // Show the dialog
        dialog.show();
    }

}