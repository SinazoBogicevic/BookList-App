package android.example.booklist;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.BookViewHolder> {

    ArrayList<String> books;
    Context context;

    public RecylerViewAdapter(ArrayList<String> books, Context context) {
        this.books = books;
        this.context = context;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        BookViewHolder holder = new BookViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return books == null ? 0 : books.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView bookCover;
        RelativeLayout layout;

        public BookViewHolder(View view){
            super(view);
            bookCover = view.findViewById(R.id.book_cover);
            layout = view.findViewById(R.id.grid_item);
        }
    }
}
