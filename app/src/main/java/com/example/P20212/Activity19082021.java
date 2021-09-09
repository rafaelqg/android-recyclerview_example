package com.example.P20212;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class Activity19082021 extends AppCompatActivity {
    private int tipo=0;
    public Activity19082021(){
        if(true){
            tipo=3;
        }
    }

    public void clickEditText(View v){
        Log.i("Key", "Edit text clicado");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("INIT","etapa oncreate ciclo de vida");
        super.onCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);

        setContentView(R.layout.activity_19082021);
        this.carregaOpcoesListView();

        findViewById(R.id.editTextValor).setOnKeyListener(
                new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        Log.i("Key", String.valueOf(keyCode));
                        Log.i("ViewID", String.valueOf(v.getId()));
                        Log.i("Key-UNICODE", String.valueOf(event.getUnicodeChar()));
                        Log.i("Event type", String.valueOf(event.getAction()));
                        char tecla= (char) event.getUnicodeChar();
                        Log.i("Key-Char",String.valueOf(tecla));
                        //Log.i("Key-Char: caracters",event.getCharacters());
                        EditText et=findViewById(R.id.editTextValor);

                        TextView tv=findViewById(R.id.textView01);

                        //tv=(TextView)findViewById(R.id.textView01);
                        tv.setText("Digitando:"+et.getText().toString());
                        //tv.setText("Digitando:"+et.getText().toString());
                        if(!String.valueOf(tecla).equals("")) {
                            findViewById(R.id.idButtonProcessar).setEnabled(true);
                            findViewById(R.id.idButtonProcessar).setVisibility(View.INVISIBLE);
                            findViewById(R.id.idButtonProcessar).setVisibility(View.GONE);
                            tv.setTextColor(Color.rgb(5,60,5));
                            Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ascii_table_icon);
                            ImageView iv= (ImageView) findViewById(R.id.idImageView01);
                            iv.setImageBitmap(bitmap);
                        }
                        if(et.getText().toString().equals("")){
                            findViewById(R.id.idButtonProcessar).setEnabled(false);
                            tv.setTextColor(Color.GRAY);
                          //  findViewById(R.id.idButtonProcessar).setVisibility(View.INVISIBLE);
                        }
                        return true;
                    }
                });



        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    private void carregaOpcoesListView(){
        //set itens on list view
        ListView listview = (ListView) findViewById(R.id.idListView);
        List<String> ListElementsArrayList = new ArrayList<String>();
        ListElementsArrayList.add("Java");
        ListElementsArrayList.add("C#");
        ListElementsArrayList.add("PHP");
        ListElementsArrayList.add("Python");
        ListElementsArrayList.add("Node");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListElementsArrayList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Object o = parent.getItemAtPosition(position);
                    String str = (String)o; //As you are using Default String Adapter
                    Log.i("ListView selection: ", str);
            }
        }
        );


        }
}