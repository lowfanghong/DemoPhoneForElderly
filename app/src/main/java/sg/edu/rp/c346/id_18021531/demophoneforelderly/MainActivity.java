package sg.edu.rp.c346.id_18021531.demophoneforelderly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnSon,btnDau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btnSon = findViewById(R.id.buttonCallSon);
         btnDau = findViewById(R.id.buttonCallDaughter);

         btnSon.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 92240336 ));
                 startActivity(intentCall);


             }
         });

     btnDau.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 89675543 ));
             startActivity(intentCall);
         }
     });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_info:
                Intent intent = new Intent(MainActivity.this,SettingsPage.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}
