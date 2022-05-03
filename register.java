package com.example.nidaapp2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class register extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://console.firebase.google.com/u/0/project/nida-9e504/database/nida-9e504-default-rtdb/data/~2F");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText firstname=findViewById(R.id.usrFirstName);
        final EditText Lastname=findViewById(R.id.usrLastName);
        final EditText phone=findViewById(R.id.usrPhone);
        final EditText password=findViewById(R.id.usrPassword);
        final EditText conPassword=findViewById(R.id.usrConfirmPW);

        final Button registerBtn=findViewById(R.id.btnRegister);
        final TextView loginNowBtn=findViewById(R.id.loginBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String firstnameTxt=firstname.getText().toString();
                final String phoneTxt=phone.getText().toString();
                final String passwordTxt=password.getText().toString();
                final String conPasswordTxt=conPassword.getText().toString();
                if (firstnameTxt.isEmpty()||phoneTxt.isEmpty()||passwordTxt.isEmpty()||passwordTxt.isEmpty()){
                    Toast.makeText(register.this,"Please fill all fields",Toast.LENGTH_SHORT).show();
                }
                else if (!passwordTxt.equals(conPasswordTxt)){
                    Toast.makeText(register.this,"passwords are not matching",Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(phoneTxt)){
                                Toast.makeText(register.this,"Phone is already registered",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                databaseReference.child("users").child(phoneTxt).child("fullname").setValue(firstname);
                                databaseReference.child("users").child(phoneTxt).child("password").setValue(passwordTxt);
                                databaseReference.child("users").child(phoneTxt).child("phone").setValue(phoneTxt);
                                databaseReference.child("users").child(phoneTxt).child("consPassword").setValue(conPasswordTxt);

                                Toast.makeText(register.this,"User registration successful",Toast.LENGTH_SHORT).show();
                                finish();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });
        loginNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
