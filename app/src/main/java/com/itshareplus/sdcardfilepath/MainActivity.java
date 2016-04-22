package com.itshareplus.sdcardfilepath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import FileManager.FileManager;

public class MainActivity extends AppCompatActivity {

    TextView txtExternalStorageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtExternalStorageList = (TextView) findViewById(R.id.txtExternalStorageList);

        txtExternalStorageList.setText("Available SDCards on this device\n");
        File files[] = FileManager.getAllAvailableSDCards(getApplicationContext());
        for (int i = 0; i < files.length; ++i)
            txtExternalStorageList.append(String.format("%d. %s\n", i+1, files[i].getAbsolutePath()));

        txtExternalStorageList.append("\nExternal SDCard Storage:\n");
        File externalSDCard = FileManager.getExternalSDCard(getApplicationContext());
        if (externalSDCard != null) {
            txtExternalStorageList.append(externalSDCard.getAbsolutePath());
        } else {
            txtExternalStorageList.append("  not available on this device");
        }


        Toast.makeText(this, "Completed!", Toast.LENGTH_SHORT).show();
    }
}
