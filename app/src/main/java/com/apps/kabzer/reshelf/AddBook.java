package com.apps.kabzer.reshelf;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddBook extends AppCompatActivity{
    EditText author;
    EditText title;
    DatabaseHandler db;
    final int CAMERA_CAPTURE = 1;
    final int CROP_PIC = 2;
    private Uri picUri;
    Bitmap thePic;
    File path;
    Button button;
    String genre;
    String currentDateandTime;
    String filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        author = (EditText) findViewById(R.id.EditAuthor);
        title = (EditText) findViewById(R.id.EditTitle);
        button = (Button) findViewById(R.id.button_genre);
        db = new DatabaseHandler(this);

        FloatingActionButton addPhoto = (FloatingActionButton) findViewById(R.id.addPhoto);
        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.addPhoto) {
                    try {
                        // use standard intent to capture an image
                        Intent captureIntent = new Intent(
                                MediaStore.ACTION_IMAGE_CAPTURE);
                        // we will handle the returned data in onActivityResult
                        startActivityForResult(captureIntent, CAMERA_CAPTURE);
                    } catch (ActivityNotFoundException anfe) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Can't crop, sorry m8", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final CharSequence[] items = {"Fantasy", "Biography", "History", "Horror", "Adventure", "Sci-Fi", "Thriller"};
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(AddBook.this);
                dialogBuilder.setTitle("Book genre");
                dialogBuilder.setItems(items, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                            button.setText(items[which]);
                            genre = items[which].toString();
                    }

                });
                dialogBuilder.create().show();
            }
        });
    }

        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (resultCode == RESULT_OK) {
                if (requestCode == CAMERA_CAPTURE) {
                    // get the Uri for the captured image
                    picUri = data.getData();
                    performCrop();
                }
                // user is returning from cropping the image
                else if (requestCode == CROP_PIC) {
                    // get the returned data

                    filePath = path
                            + "/"+currentDateandTime+".jpg";

                     thePic = BitmapFactory.decodeFile(filePath);

                    ImageView picView = (ImageView) findViewById(R.id.addView);
                    picView.setImageBitmap(thePic);
                }
            }
        }

        /**
         * this function does the crop operation.
         */
        private void performCrop() {
            // take care of exceptions
            try {
                // call the standard crop action intent (the user device may not
                // support it)
                Intent cropIntent = new Intent("com.android.camera.action.CROP");
                // indicate image type and Uri
                cropIntent.setDataAndType(picUri, "image/*");
                // set crop properties
                cropIntent.putExtra("crop", "true");
                // indicate output X and Y
                /////intent.putExtra("outputX", 200);
               //////intent.putExtra("outputY", 200);
                // save file on sdcard
                path = new File(Environment.getExternalStorageDirectory(), "reshelf_data");
                if(!path.exists()){
                    try {
                        path.mkdir();
                    } catch (Exception ex) {
                        Log.e("io", ex.getMessage());
                    }

                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
                currentDateandTime = sdf.format(new Date());
                File f = new File(path,
                        "/"+currentDateandTime+".jpg");
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    Log.e("io", ex.getMessage());
                }

                picUri = Uri.fromFile(f);

                cropIntent.putExtra(MediaStore.EXTRA_OUTPUT, picUri);

                // start the activity - we handle returning in onActivityResult
                startActivityForResult(cropIntent, CROP_PIC);
            }
            // respond to users whose devices do not support the crop action
            catch (ActivityNotFoundException anfe) {
                Toast toast = Toast
                        .makeText(this, "This device doesn't support the crop action!", Toast.LENGTH_SHORT);
                toast.show();
            }
        }


    @Override
    public void onBackPressed() {
        finish();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_book, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            db.addBook(new Books(author.getText().toString(), title.getText().toString(), genre, filePath));
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
