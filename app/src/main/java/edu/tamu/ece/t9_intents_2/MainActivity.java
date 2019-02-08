package edu.tamu.ece.t9_intents_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private static final String[] WORDS ={"Tiger","Eagle","Frog"};
    private static final int REQ_CODE_ANS = 2468;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //attach reference list to mylist
        ListView list = (ListView) findViewById(R.id.mylist);

        final Intent forwardIntent = new Intent(this,ImgDisp.class);

        //Create adapter and attach to WORDS
        ArrayAdapter<String> myadapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,WORDS);

        //Use myadapter as input to list
        list.setAdapter(myadapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String word = parent.getItemAtPosition(position).toString();
                forwardIntent.putExtra("animal",word);

                //Since I want a result to come back
                startActivityForResult(forwardIntent,REQ_CODE_ANS);
            }
        });

    }

    //BackIntent returns control back here
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(requestCode==REQ_CODE_ANS) {
            String ret_ans = intent.getStringExtra("family");
            Toast.makeText(MainActivity.this, ret_ans, Toast.LENGTH_SHORT).show();
        }
    }
}
