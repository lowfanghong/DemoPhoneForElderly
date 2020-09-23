package sg.edu.rp.c346.id_18021531.demophoneforelderly;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsPage extends AppCompatActivity {
Button btnSon, btnDau;
TextView tvSon, tvDaughter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
        btnSon = findViewById(R.id.buttonSon);
        btnDau = findViewById(R.id.buttonDaughter);
        tvSon = findViewById(R.id.textViewSonNumber);
        tvDaughter = findViewById(R.id.textViewDaughterNumber);

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
                myBuilder.setPositiveButton("Update Contact", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Integer num1 = Integer.parseInt(etNumber.getText().toString());
                       tvSon.setText(num1);
                    }
                });

                myBuilder.setNeutralButton("Cancel",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });


    }
}