package mobile.app.qybae.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.nama)
    EditText nama;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.ttl)
    EditText ttl;
    @BindView(R.id.txtpass)
    EditText txtpass;
    @BindView(R.id.btnregister)
    Button btnregister;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        ButterKnife.bind(this);
        // tanda R itu maksudnya adalah folder res - layout - nama xml

        //tambah child biar dikelompokan
        mDatabase = FirebaseDatabase.getInstance().getReference().child("users");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HashMap<String, String> datamapuser = new HashMap<String, String>();
                String nama = dataSnapshot.getValue().toString();
                long count = dataSnapshot.getChildrenCount();
                
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    @OnClick(R.id.btnregister)
    public void onViewClicked() {
        //create child di root firebase
        //assign value ke child

        //mDatabase.child("Name").setValue("Arif");
        HashMap<String, String> datamapuser = new HashMap<String, String>();
        datamapuser.put("nama", nama.getText().toString().trim());
        datamapuser.put("email", email.getText().toString().trim());
        datamapuser.put("umur", ttl.getText().toString().trim());
        datamapuser.put("password", txtpass.getText().toString().trim());

        //kalo pake push, firebase bakal generate unik key
        //mDatabase.push().setValue(datamapuser);
        //https://www.firebase.com/docs/android/guide/saving-data.html

        mDatabase.child("0003").setValue(datamapuser).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(MainActivity.this, "Thanks for Register", Toast.LENGTH_SHORT).show();

            }
        });

        //penggunaan push ini ketika nanti user melakukan klik secara bersamaaan, maka data tidak terhapu

        nama.setText("");
        email.setText("");
        txtpass.setText("");
        ttl.setText("");

   /*     mDatabase.runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                return null;
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {

            }
        });*/


    }
}


/*
contoh save multiple user dengan hashmap, map didalam map
    Map<String, String> alanisawesomeMap = new HashMap<String, String>();
        alanisawesomeMap.put("birthYear", "1912");
        alanisawesomeMap.put("fullName", "Alan Turing");
        Map<String, Map<String, String>> users = new HashMap<String, Map<String, String>>();
        users.put("alanisawesome", alanisawesomeMap);
        usersRef.setValue(users);*/
