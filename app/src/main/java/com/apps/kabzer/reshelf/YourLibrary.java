package com.apps.kabzer.reshelf;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class YourLibrary extends android.support.v4.app.Fragment{
    private ListView listView;

    public YourLibrary() {
        // Required empty public constructor
    }

    public void redraw(View view){
        DatabaseHandler db = new DatabaseHandler(getActivity());
        List<Books> books = db.getAllBooks();

        RowBook RowBook_data[] = new RowBook[books.size()];
        for(int i=0; i<books.size(); i++){
            RowBook_data[i] = new RowBook(R.drawable.add, books.get(i).getTitle() , books.get(i).getAuthor());
        }



        ListAdapter adapter = new ListAdapter(getActivity(), R.layout.row_book, RowBook_data);
        listView = (ListView)view.findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {

        final DatabaseHandler db = new DatabaseHandler(getActivity());
        final List<Books> books = db.getAllBooks();

        RowBook RowBook_data[] = new RowBook[books.size()];
        for(int i=0; i<books.size(); i++){
           RowBook_data[i] = new RowBook(R.drawable.add, books.get(i).getTitle() , books.get(i).getAuthor());
           //RowBook_data[i] = new RowBook(R.drawable.add, "Game of Thrones", "George R.R. Martin");
        }


        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.your_library, container, false);
        final ListAdapter adapter = new ListAdapter(getActivity(), R.layout.row_book, RowBook_data);

        listView = (ListView)view.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           final int pos, long id) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Delete book")
                        .setMessage("Do you want to delete this book?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                               db.deleteBooks(books.get(pos));
                                redraw(view);
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

                return true;
            }
        });
        return view;
    }
}
