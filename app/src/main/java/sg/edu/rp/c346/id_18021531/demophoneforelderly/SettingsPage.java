package sg.edu.rp.c346.id_18021531.demophoneforelderly;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SettingsPage extends AppCompatActivity {
Button btnSon, btnDau , btnConfirm;
TextView tvSon, tvDaughter;
    ArrayList<Contacts> al;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
        btnSon = findViewById(R.id.buttonSon);
        btnDau = findViewById(R.id.buttonDaughter);
        tvSon = findViewById(R.id.textViewSonNumber);
        tvDaughter = findViewById(R.id.textViewDaughterNumber);
        btnConfirm = findViewById(R.id.buttonConfirm);
        al = new ArrayList<Contacts>();

        btnSon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService
                        (Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input,null);
                final EditText etNumber = viewDialog.findViewById(R.id.editText);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder
                        (SettingsPage.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Update Son's Number");
                myBuilder.setPositiveButton("Update Contact", new
                        DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Integer num1 = Integer.parseInt(etNumber.getText().toString());
                       tvSon.setText(num1 + "");
                        DBHelper db = new DBHelper(SettingsPage.this);

                        // Insert a task
                        db.insertContact("Low Fang Hong", 92988638,"son");
                        db.close();


                    }
                });
                myBuilder.setNeutralButton("Cancel",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });
         btnDau.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService
                         (Context.LAYOUT_INFLATER_SERVICE);
                 View viewDialog = inflater.inflate(R.layout.input,null);
                 final EditText etNumber = viewDialog.findViewById(R.id.editText);
                 AlertDialog.Builder myBuilder = new AlertDialog.Builder
                         (SettingsPage.this);
                 myBuilder.setView(viewDialog);
                 myBuilder.setTitle("Update Daughter's Number");
                 myBuilder.setPositiveButton("Update Contact", new
                         DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         Integer num1 = Integer.parseInt(etNumber.getText().toString());
                         tvDaughter.setText(num1 + "");
                         DBHelper db = new DBHelper(SettingsPage.this);

                         // Insert a task
                         db.insertContact("Mary", 90188158,"daughter");
                         db.close();

                     }
                 });

                 myBuilder.setNeutralButton("Cancel",null);
                 AlertDialog myDialog = myBuilder.create();
                 myDialog.show();

             }

         });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              // activity's Context
                DBHelper db = new DBHelper(SettingsPage.this);

                // Insert a task
                ArrayList<Integer> data = db.getSonNumber();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". "+data.get(i));
                    txt = i + ". " + data.get(i) + "\n";
                }
                tvSon.setText(txt);
                // activity's Context
                DBHelper db1 = new DBHelper(SettingsPage.this);

                // Insert a task
                ArrayList<Integer> data1 = db.getDaughterNumber();
                db.close();

                String txt1 = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". "+data.get(i));
                    txt = i + ". " + data.get(i) + "\n";
                }
                tvDaughter.setText(txt1);

            }
        });
    }




}