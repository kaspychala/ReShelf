package com.apps.kabzer.reshelf;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.io.File;
import java.util.List;

public class ReshelfActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView;
    DatabaseHandler db;
    List<Books> books;
    ListAdapter adapter;
    RowBook RowBook_data[];
    Integer count = new Integer(0);
    String genre = "All";
    Button btnClosePopup;
    PopupWindow pwindo;
    Bitmap thePic;
    ImageView imageView;
    Integer itemPosition = new Integer(0);
    Intent settings;

    public void initiatePopupWindow() {
        try {
            LayoutInflater inflater = (LayoutInflater) ReshelfActivity.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popup,
                    (ViewGroup) findViewById(R.id.popup_element));
            thePic = BitmapFactory.decodeFile(books.get(itemPosition).getPath());
            imageView = (ImageView)layout.findViewById(R.id.popUpImage);
            imageView.setImageBitmap(thePic);
            pwindo = new PopupWindow(layout, 600, 860, true);
            pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);

            btnClosePopup = (Button) layout.findViewById(R.id.btn_close_popup);
            btnClosePopup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pwindo.dismiss();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void redraw(String genre){
        db = new DatabaseHandler(this);
        books = db.getAllBooks();

        RowBook_data = new RowBook[books.size()];
        if(genre.equals("All")) {
            for (int i = 0; i < books.size(); i++) {
                RowBook_data[i] = new RowBook(R.drawable.add_plain, books.get(i).getTitle(), books.get(i).getAuthor());
            }
        }
        //Refresh fantasy section
        else if(genre.equals("Fantasy")) {
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getGenre().equals(genre)) {
                    count++;
                }
            }
            RowBook_data = new RowBook[count];
            count = 0;
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getGenre().equals(genre)) {
                    RowBook_data[count] = new RowBook(R.drawable.add_plain, books.get(i).getTitle(), books.get(i).getAuthor());
                    count++;
                }
            }
            count = 0;
        }

        else if(genre.equals("Biography")) {
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getGenre().equals(genre)) {
                    count++;
                }
            }
            RowBook_data = new RowBook[count];
            count = 0;
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getGenre().equals(genre)) {
                    RowBook_data[count] = new RowBook(R.drawable.add_plain, books.get(i).getTitle(), books.get(i).getAuthor());
                    count++;
                }
            }
            count = 0;
        }

        else if(genre.equals("History")) {
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getGenre().equals(genre)) {
                    count++;
                }
            }
            RowBook_data = new RowBook[count];
            count = 0;
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getGenre().equals(genre)) {
                    RowBook_data[count] = new RowBook(R.drawable.add_plain, books.get(i).getTitle(), books.get(i).getAuthor());
                    count++;
                }
            }
            count = 0;
        }

        else if(genre.equals("Horror")) {
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getGenre().equals(genre)) {
                    count++;
                }
            }
            RowBook_data = new RowBook[count];
            count = 0;
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getGenre().equals(genre)) {
                    RowBook_data[count] = new RowBook(R.drawable.add_plain, books.get(i).getTitle(), books.get(i).getAuthor());
                    count++;
                }
            }
            count = 0;
        }

        else if(genre.equals("Adventure")) {
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getGenre().equals(genre)) {
                    count++;
                }
            }
            RowBook_data = new RowBook[count];
            count = 0;
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getGenre().equals(genre)) {
                    RowBook_data[count] = new RowBook(R.drawable.add_plain, books.get(i).getTitle(), books.get(i).getAuthor());
                    count++;
                }
            }
            count = 0;
        }

        else if(genre.equals("Sci-Fi")) {
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getGenre().equals(genre)) {
                    count++;
                }
            }
            RowBook_data = new RowBook[count];
            count = 0;
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getGenre().equals(genre)) {
                    RowBook_data[count] = new RowBook(R.drawable.add_plain, books.get(i).getTitle(), books.get(i).getAuthor());
                    count++;
                }
            }
            count = 0;
        }

        else if(genre.equals("Thriller")) {
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getGenre().equals(genre)) {
                    count++;
                }
            }
            RowBook_data = new RowBook[count];
            count = 0;
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getGenre().equals(genre)) {
                    RowBook_data[count] = new RowBook(R.drawable.add_plain, books.get(i).getTitle(), books.get(i).getAuthor());
                    count++;
                }
            }
            count = 0;
        }


        adapter = new ListAdapter(this, R.layout.row_book, RowBook_data);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reshelf);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Intent intent = new Intent(this,AddBook.class);
        settings = new Intent(this, Settings.class);
        getSupportActionBar().setTitle("All");
        redraw("all");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(genre.equals("All")) {
                    itemPosition = position;
                }
                else {
                    for (int i = 0; i < books.size(); i++) {
                        if (RowBook_data[position].getTitle().equals(books.get(i).getTitle())) {
                            itemPosition = i;
                        }
                    }
                }
                initiatePopupWindow();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           final int pos, long id) {
                new AlertDialog.Builder(ReshelfActivity.this)
                        .setTitle("Delete book")
                        .setMessage("Do you want to delete this book?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if (genre.equals("All")) {
                                    db.deleteBooks(books.get(pos));
                                    File file = new File(books.get(pos).getPath());
                                    file.delete();
                                } else {
                                    for (int i = 0; i < books.size(); i++) {
                                        if (RowBook_data[pos].getTitle().equals(books.get(i).getTitle())) {
                                            db.deleteBooks(books.get(i));
                                            File file = new File(books.get(i).getPath());
                                            file.delete();
                                        }
                                    }
                                }
                                redraw(genre);
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


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.reshelf, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(settings);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.library_all) {
            getSupportActionBar().setTitle("All");
            genre = "All";
            redraw(genre);
        } else if (id == R.id.library_fantasy) {
            getSupportActionBar().setTitle("Fantasy");
            genre = "Fantasy";
            redraw(genre);
        } else if (id == R.id.library_biography) {
            getSupportActionBar().setTitle("Biography");
            genre = "Biography";
            redraw(genre);
        } else if (id == R.id.library_history) {
            getSupportActionBar().setTitle("History");
            genre = "History";
            redraw(genre);
        }else if (id == R.id.library_horror) {
            getSupportActionBar().setTitle("Horror");
            genre = "Horror";
            redraw(genre);
        } else if (id == R.id.library_adventure) {
            getSupportActionBar().setTitle("Adventure");
            genre = "Adventure";
            redraw(genre);
        } else if (id == R.id.library_sci_fi) {
            getSupportActionBar().setTitle("Sci-Fi");
            genre = "Sci-Fi";
            redraw(genre);
        } else if (id == R.id.library_thriller) {
            getSupportActionBar().setTitle("Thriller");
            genre = "Thriller";
            redraw(genre);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onResume(){
        super.onResume();
        redraw(genre);
    }
}

