package edu.tamu.ece.t9_intents_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ImgDisp extends AppCompatActivity {

    private static final String[] WORDS ={"Tiger","Eagle","Frog"};
    private static final String[] CLAS ={"Mammal","Bird","Amphibian"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_disp);

        Intent forwardIntent = getIntent();
        String extra = forwardIntent.getStringExtra("animal");
        ImageView img = (ImageView) findViewById(R.id.myimg);

        if (extra.equals(WORDS[0])) {
            img.setImageResource(R.drawable.tiger);
        }

        if (extra.equals(WORDS[1])) {
            img.setImageResource(R.drawable.eagle);
        }

        if (extra.equals(WORDS[2])) {
            img.setImageResource(R.drawable.frog);
        }
    }

    public void myclick (View view){

        EditText anstxt = (EditText) findViewById(R.id.myans);
        String ans;

        //Returning the answer back to the calling activity
        Intent backIntent = new Intent();
        ans = anstxt.getText().toString();
        backIntent.putExtra("family", ans);
        setResult(RESULT_OK, backIntent);
        finish();
    }
}

