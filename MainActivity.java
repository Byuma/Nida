package com.example.nidaapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuHome:
                //
                break;
            case R.id.menuAbout:
                //
                break;
            case R.id.menuLocation:
                Toast.makeText(this, "Selected Location", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuContact:
                Toast.makeText(this, "Selected Contact", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuServices:
                startActivity(new Intent(MainActivity.this, Recycler.class));
                break;
            case R.id.menuLogin:
                Toast.makeText(this, "Selected Login.java", Toast.LENGTH_SHORT).show();
                //callDialog();
                callCustomDialog();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void callCustomDialog() {
        MaterialAlertDialogBuilder thedialog = new MaterialAlertDialogBuilder(this);
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.custom_dialog, null);
        TextInputEditText dialogEmail= view.findViewById(R.id.dialogEmail);
        TextInputEditText dialogPass = view.findViewById(R.id.dialogPass);
        thedialog.setView(view);
        thedialog.setTitle("Input your Information to continue:");
        thedialog.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "" + dialogEmail.getText().toString() + "\n" + dialogPass.getText().toString() , Toast.LENGTH_LONG).show();

            }
        });
        thedialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        thedialog.setCancelable(false);
        thedialog.show();

        }
    }
