package com.example.alumnismartconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialAutoCompleteTextView;
import com.rengwuxian.materialedittext.MaterialEditText;

import static android.app.ProgressDialog.show;

public class SignIn extends AppCompatActivity {

    MaterialAutoCompleteTextView phone, password;
    Button btnSignIn;
   static User user1;
   TextView textViewSignUp;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


       // auth=FirebaseAuth.getInstance();

        textViewSignUp=findViewById(R.id.tvSignUp);
        phone=findViewById(R.id.edtPhone);
        password=findViewById(R.id.edtPassword);
        btnSignIn=findViewById(R.id.btnSignInId);

        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignIn.this,SignUp.class);
                startActivity(intent);
            }
        });
        final DatabaseReference reference= FirebaseDatabase.getInstance()
                .getReference().child("Users");
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String txt_phone=phone.getText().toString();
                final String txt_password=password.getText().toString();
                if (TextUtils.isEmpty(txt_phone) || TextUtils.isEmpty(txt_password)){
                    // Toast.makeText( SignIn.this, text "", Toast.LENGTH_SHORT).show();
                    Toast.makeText(SignIn.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else{
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.child(txt_phone).exists()){
                                user1=dataSnapshot.child(txt_phone).getValue(User.class);
                                if (user1.getPassword().equals(txt_password)){
                                    Toast.makeText(SignIn.this, "Successful LogIn....", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(SignIn.this, Home.class);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(SignIn.this, "Please re-enter password and phone number!!", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                            Toast.makeText(SignIn.this, "User with "+txt_phone+" does not exist", Toast.LENGTH_SHORT).show();
                        }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });
    }
}
