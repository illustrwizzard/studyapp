package com.axis.axislanguageschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;

public class OTP extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText edt1 ,edt2;
    EditText e1,otp0,otp1,otp2,otp3,otp4,otp5;
    CountryCodePicker countryCodepicker_id;
    String country_code,country_selected;
    LinearLayout linearLayout1, linearLayout2;
    Boolean countryselected=false;
    TextView t1,t2;
    String otpgetnumber,mobilenumber;
    PhoneAuthCredential Credential, credential2;
    String mVerificationId,smsget;
    String newuser;
    SQLB sqlb;

ImageButton btn, verifybutton;
    boolean flag=true,flagnew=false,flagtouchZero=false,flagtouch1=false,flagnew1=false,flagtouch2=false,flagtouch3=false,flagtouch4=false,flagtouch5=false,flagnew2=false,flagnew3=false,flagnew4=false;

    @Override
    public void onBackPressed() {
        sqlb.deletetable();
        Intent oi=new Intent(OTP.this,LoginPage.class);

        startActivity(oi);

    }

    public void signInWithPhoneAuthCredentialVerify(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                                Intent i = new Intent(getApplicationContext(),BottomNavigation.class);


                                startActivity(i);





                        } else {
                            LayoutInflater li = getLayoutInflater();
                            //Getting the View object as defined in the customtoast.xml file



                        }
                    }
                });
    }



    private void initiateotp(String otpgetnumber){

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+"+"91"+otpgetnumber)       // Phone number to verify
                        .setTimeout(0l, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                                signInWithPhoneAuthCredentialVerify(phoneAuthCredential);

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {

                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId,
                                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                                Log.d("yo", "onCodeSent:" + verificationId);
                                mVerificationId=verificationId;

                            }



                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);



    }


    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        btn= findViewById(R.id.otpbutton2);
       verifybutton=findViewById(R.id.otpbutton1);
        mAuth = FirebaseAuth.getInstance();
        Intent ioo=getIntent();
        newuser=ioo.getStringExtra("newuser");
        sqlb=new SQLB(this);
       edt1=findViewById(R.id.edittext_entering_number);
//        edt2=findViewById(R.id.editTextTextPersonName3);

        countryCodepicker_id=findViewById(R.id.countryCodepicker_id);

        linearLayout1=findViewById(R.id.layout_entering_number);
        linearLayout2=findViewById(R.id.layout_entering_otp);
        t1=findViewById(R.id.textview_otpget_id);
        t2=findViewById(R.id.textview_mobilenumber);

        otp0=findViewById(R.id.edittext_entering_otp);
        otp1=findViewById(R.id.edittext_entering_otp1);
        otp2=findViewById(R.id.edittext_entering_otp2);
        otp3=findViewById(R.id.edittext_entering_otp3);
        otp4=findViewById(R.id.edittext_entering_otp4);
        otp5=findViewById(R.id.edittext_entering_otp5);


        otp0.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(otp0.getText().length()==6){
                    Log.w("herebbbb","kkkkkkkk");
                    String getotp= String.valueOf(otp0.getText());
                    otp0.setText(getotp.substring(0,1));
                    otp1.setText(getotp.substring(1,2));
                    otp2.setText(getotp.substring(2,3));
                    otp3.setText(getotp.substring(3,4));
                    otp4.setText(getotp.substring(4,5));
                    otp5.setText(getotp.substring(5,6));
                    flagtouchZero=true;
                    flagtouch1=true;




                }
                if (otp0.getText().length()==1)
                {
                    // Perform action on Enter key press
                    //otp0.clearFocus();
//                    InputFilter[] inputFilter=new InputFilter[1];
//                    inputFilter[0]=new InputFilter.LengthFilter(1);
//                    otp0.setFilters(inputFilter);
                    flagnew=true;
                    otp1.requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });




        otp0.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (otp0.getText().length()==1&flagnew==false&flagtouchZero==false)
//                {
//                    // Perform action on Enter key press
//                    //otp0.clearFocus();
//              InputFilter[] inputFilter=new InputFilter[1];
//              inputFilter[0]=new InputFilter.LengthFilter(1);
//              otp0.setFilters(inputFilter);
//                    flagnew=true;
//                    otp1.requestFocus();
//                    return true;
//                }else
                if(otp0.getText().length()==1){

                    otp0.requestFocus();
                }
                return false;
            }
        });



        otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(otp1.getText().length()==6){
                    Log.w("herebbbb","kkkkkkkk");
                    String getotp= String.valueOf(otp1.getText());
                    otp0.setText(getotp.substring(0,1));
                    otp1.setText(getotp.substring(1,2));
                    otp2.setText(getotp.substring(2,3));
                    otp3.setText(getotp.substring(3,4));
                    otp4.setText(getotp.substring(4,5));
                    otp5.setText(getotp.substring(5,6));
                    flagtouch1=true;
                    flagtouchZero=true;
                    flagtouch2=true;
                    flagtouch3=true;
                    flagtouch4=true;
                    flagtouch5=true;






                }
                if (otp1.getText().length()==1)
                {
                    // Perform action on Enter key press
                    //otp0.clearFocus();
//                    InputFilter[] inputFilter=new InputFilter[1];
//                    inputFilter[0]=new InputFilter.LengthFilter(1);
//                    otp0.setFilters(inputFilter);
                    flagnew=true;
                    otp2.requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });





        otp1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
//
//                if (otp1.getText().length()==1&flagnew1==false&flagtouch1==false)
//                {
//                    // Perform action on Enter key press
//                    //otp1.clearFocus();
//                    flagnew1=true;
//                    otp2.requestFocus();
//                    return true;
//                }else
                if (otp1.getText().length()==1){
                    otp1.requestFocus();

                }
                return false;
            }
        });








        otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(otp2.getText().length()==6){
                    Log.w("herebbbb","kkkkkkkk");
                    String getotp= String.valueOf(otp2.getText());
                    otp0.setText(getotp.substring(0,1));
                    otp1.setText(getotp.substring(1,2));
                    otp2.setText(getotp.substring(2,3));
                    otp3.setText(getotp.substring(3,4));
                    otp4.setText(getotp.substring(4,5));
                    otp5.setText(getotp.substring(5,6));
                    flagtouch1=true;
                    flagtouchZero=true;
                    flagtouch2=true;
                    flagtouch3=true;
                    flagtouch4=true;
                    flagtouch5=true;






                }
                if (otp2.getText().length()==1)
                {
                    // Perform action on Enter key press
                    //otp0.clearFocus();
//                    InputFilter[] inputFilter=new InputFilter[1];
//                    inputFilter[0]=new InputFilter.LengthFilter(1);
//                    otp0.setFilters(inputFilter);
                    flagnew=true;
                    otp3.requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        otp2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
//
//                if (otp2.getText().length()==1&flagnew2==false&flagtouch2==false)
//                {
//                    // Perform action on Enter key press
//
//
//                    flagnew2=true;
//                    otp3.requestFocus();
//                    return true;
//                } else
                if (otp2.getText().length()==1){

                    otp2.requestFocus();

                }
                return false;
            }
        });





        otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(otp3.getText().length()==6){
                    Log.w("herebbbb","kkkkkkkk");
                    String getotp= String.valueOf(otp3.getText());
                    otp0.setText(getotp.substring(0,1));
                    otp1.setText(getotp.substring(1,2));
                    otp2.setText(getotp.substring(2,3));
                    otp3.setText(getotp.substring(3,4));
                    otp4.setText(getotp.substring(4,5));
                    otp5.setText(getotp.substring(5,6));
                    flagtouch1=true;
                    flagtouchZero=true;
                    flagtouch2=true;
                    flagtouch3=true;
                    flagtouch4=true;
                    flagtouch5=true;






                }
                if (otp3.getText().length()==1)
                {
                    // Perform action on Enter key press
                    //otp0.clearFocus();
//                    InputFilter[] inputFilter=new InputFilter[1];
//                    inputFilter[0]=new InputFilter.LengthFilter(1);
//                    otp0.setFilters(inputFilter);
                    flagnew=true;
                    otp4.requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        otp3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

//                if (otp3.getText().length()==1&flagnew3==false&flagtouch3==false)
//                {
//                    // Perform action on Enter key press
//
//
//                    flagnew3=true;
//                    otp4.requestFocus();
//                    return true;
//                } else
                if (otp3.getText().length()==1){

                    otp3.requestFocus();

                }
                return false;
            }
        });






        otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(otp4.getText().length()==6){
                    Log.w("herebbbb","kkkkkkkk");
                    String getotp= String.valueOf(otp4.getText());
                    otp0.setText(getotp.substring(0,1));
                    otp1.setText(getotp.substring(1,2));
                    otp2.setText(getotp.substring(2,3));
                    otp3.setText(getotp.substring(3,4));
                    otp4.setText(getotp.substring(4,5));
                    otp5.setText(getotp.substring(5,6));
                    flagtouch1=true;
                    flagtouchZero=true;
                    flagtouch2=true;
                    flagtouch3=true;
                    flagtouch4=true;
                    flagtouch5=true;






                }
                if (otp4.getText().length()==1)
                {
                    // Perform action on Enter key press
                    //otp0.clearFocus();
//                    InputFilter[] inputFilter=new InputFilter[1];
//                    inputFilter[0]=new InputFilter.LengthFilter(1);
//                    otp0.setFilters(inputFilter);
                    flagnew=true;
                    otp5.requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        otp4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

//                if (otp4.getText().length()==1&flagnew4==false&flagtouch4==false)
//                {
//                    // Perform action on Enter key press
//
//
//                    flagnew4=true;
//                    otp5.requestFocus();
//                    return true;
//                } else
                if (otp4.getText().length()==1){

                    otp4.requestFocus();

                }
                return false;
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number =edt1.getText().toString();

                if (edt1.getText().length()<1 ){
                    Toast.makeText(getApplicationContext(), "Enter your mobile number", Toast.LENGTH_SHORT).show();
                }
                else {
                    btn.setVisibility(Button.GONE);
                    t1.setText("Enter the otp send to " + edt1.getText());
                    mobilenumber = edt1.getText().toString();
                    otpgetnumber = String.valueOf(edt1.getText());
                    initiateotp(number);
                    t2.setText("Enter your otp");
                    linearLayout1.setVisibility(LinearLayout.GONE);
                    linearLayout2.setVisibility(LinearLayout.VISIBLE);
                    verifybutton.setVisibility(View.VISIBLE);


                }

            }

               // initiateotp(number);

        });

        verifybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!otp0.getText().toString().isEmpty()&&!otp1.getText().toString().isEmpty()&&!otp2.getText().toString().isEmpty()&&!otp3.getText().toString().isEmpty()&&!otp4.getText().toString().isEmpty()&&!otp5.getText().toString().isEmpty()&&flag) {


                    Credential = PhoneAuthProvider.getCredential(mVerificationId, otp0.getText().toString() + otp1.getText().toString() + otp2.getText().toString()
                            + otp3.getText().toString() + otp4.getText().toString() + otp5.getText().toString());


                    signInWithPhoneAuthCredentialVerify(Credential);
                }
                Credential=null;
            }
        });
    }
}