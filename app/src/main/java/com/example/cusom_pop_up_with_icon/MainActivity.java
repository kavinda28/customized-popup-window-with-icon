package com.example.cusom_pop_up_with_icon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button showdialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the view
        showdialog = (Button)findViewById(R.id.showdialog);
        // when clicked
        showdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView cancel;
                //will create a view of our custom dialog layout
                View alertCustomdialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_dialog,null);
                //initialize alert builder.
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                //set our custom alert dialog to tha alertdialog builder
                alert.setView(alertCustomdialog);
                cancel = (ImageView)alertCustomdialog.findViewById(R.id.cancel_button);
                final AlertDialog dialog = alert.create();
                //this line removed app bar from dialog and make it transperent and you see the image is like floating outside dialog box.
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //finally show the dialog box in android all
                dialog.show();
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });


    }
}
