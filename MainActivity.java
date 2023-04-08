package com.grozziie.settingbluetooth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.grozziie.printer_setter.CustomAlertDialouge;
import com.grozziie.printer_setter.DialougeShowingClass;
import com.grozziie.printer_setter.MessageLibrary;

public class MainActivity extends AppCompatActivity {
Button gettingdata;
TextView alldataget;
FirebaseFirestore firebaseFirestore;
int total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  CustomAlertDialouge customAlertDialouge=new CustomAlertDialouge(MainActivity.this);
      ///  customAlertDialouge.myCustomAlert(MainActivity.this,"Confirmation","Do you want to add this printer?","No","Yes");
        gettingdata=findViewById(R.id.gettingdata);
        alldataget=findViewById(R.id.alldataget);
        firebaseFirestore=FirebaseFirestore.getInstance();
        gettingdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseFirestore.collection("Package_User")
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                                for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshots) {
                                    String dta = documentSnapshot.getString("username");
                                    String status=documentSnapshot.getString("status");
                                    if (status.toLowerCase().equals("active")) {
                                        int ncount=0;
                                        int count11 = 0;
                                        for (DocumentSnapshot document :queryDocumentSnapshots) {
                                            count11++;
                                        }
                                        Toast.makeText(MainActivity.this, ""+count11, Toast.LENGTH_SHORT).show();

                                        firebaseFirestore.collection("Income_History")
                                                .document(dta.toLowerCase().toString()+"@gmail.com")
                                                .collection("List")
                                                .get()
                                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                        int ncount=0;
                                                        int count = 0;
                                                        for (DocumentSnapshot document : task.getResult()) {
                                                            count++;
                                                            secondd++;
                                                        }
                                                        total=total+count;
                                                        message=message+"\n"+dta+"("+count+")"+"Final Value : "+total;
                                                        ///  Toast.makeText(MainActivity.this, ""+total, Toast.LENGTH_SHORT).show();

                                                        alldataget.setText(""+" : "+message+"\n\n\n"+secondd);
                                                    }
                                                });

                                    }



                                }
                            }
                        });
            }
        });


    }
    int secondd=0;
    String message="\n";
}