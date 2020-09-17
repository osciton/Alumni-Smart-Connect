package com.example.alumnismartconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.FederatedSignInActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialAutoCompleteTextView;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;

import static android.app.ProgressDialog.show;
import static android.widget.Toast.LENGTH_SHORT;

public class SignUp extends AppCompatActivity {

    MaterialAutoCompleteTextView fullname, username, email, password, year_of_passout, phone, working_place, designation, briefing;
    Button btnSignUp;
    TextView textViewSignIn;

    ProgressBar progressBar;
    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final ProgressDialog pDialog = new ProgressDialog(this); //Your Activity.this
        pDialog.setMessage("Loading...!");
        pDialog.setCancelable(false);



        textViewSignIn=findViewById(R.id.tvSignIn);
        fullname=findViewById(R.id.FullName);
        username=findViewById(R.id.edtUserName);
        email=findViewById(R.id.Email);
        password=findViewById(R.id.Password);
        year_of_passout=findViewById(R.id.YearOfPassout);
        phone=findViewById(R.id.Phone);
        working_place=findViewById(R.id.WorkingPlace);
        designation=findViewById(R.id.Designation);
        briefing=findViewById(R.id.Briefing);
        btnSignUp=findViewById(R.id.btnSignUp_id);

//        auth=FirebaseAuth.getInstance();
        textViewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp.this,SignIn.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pDialog.show();
                String txt_fullname=fullname.getText().toString();
                String txt_username=username.getText().toString();
                String txt_email=email.getText().toString();
                String txt_password=password.getText().toString();
                String txt_yearofpassout=year_of_passout.getText().toString();
                String txt_phone=phone.getText().toString();
                String txt_workingplace=working_place.getText().toString();
                String txt_designation=designation.getText().toString();
                String txt_briefing=briefing.getText().toString();

                if (TextUtils.isEmpty(txt_fullname) || TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password) || TextUtils.isEmpty(txt_yearofpassout) || TextUtils.isEmpty(txt_phone) || TextUtils.isEmpty(txt_workingplace) || TextUtils.isEmpty(txt_designation) || TextUtils.isEmpty(txt_briefing)){
                    //Toast.makeText(context:SignUp.this, text "All fields are required", LENGTH_SHORT).show();
                    Toast.makeText(SignUp.this, "All fields are required", LENGTH_SHORT).show();
                } else if (txt_password.length()< 6){
                    Toast.makeText(SignUp.this, "password must be at least 6 characters", LENGTH_SHORT).show();
                } else{
                    SignUp (txt_fullname, txt_username, txt_email, txt_password, txt_yearofpassout, txt_phone, txt_workingplace,txt_designation,txt_briefing);
                    pDialog.dismiss();
                }
            }
        });
    }

    private void SignUp (final String fullname, final String username, String email, String password, final String year_of_passout, final String phone, final String working_place, final String designation, final String briefing){

//        auth.createUserWithEmailAndPassword(email,password)
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()){
//                            FirebaseUser firebaseUser=auth.getCurrentUser();
//                            String userid=firebaseUser.getUid();

                            reference= FirebaseDatabase.getInstance().getReference("Users").child(phone);

                            HashMap hashMap=new HashMap();
//                            hashMap.put("id", userid);
                            hashMap.put("username", username);
                            hashMap.put("imageURL", "default");
                            hashMap.put("fullName",fullname);
                            hashMap.put("email",email);
                            hashMap.put("password",password);
                            hashMap.put("yearOfPassout",year_of_passout);
                            hashMap.put("phone",phone);
                            hashMap.put("workingPlace",working_place);
                            hashMap.put("designation",designation);
                            hashMap.put("briefing",briefing);

                            reference.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(SignUp.this, "User successfully created..", LENGTH_SHORT).show();
                                        Intent intent= new Intent(SignUp.this, SignIn.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
//                        }else {
//                            Toast.makeText(SignUp.this, "you can't register with this email", LENGTH_SHORT).show();
//
//              });

    }
}
