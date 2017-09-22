package com.example.nawaf.myapp2;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class Colors extends AppCompatActivity {

    private TextToSpeech tts;



    @Override
    protected void onDestroy(){
        super.onDestroy();
        tts.shutdown();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        final ArrayList<Item>  arr_clrs =  new ArrayList<Item>();
        arr_clrs.add(new Item("Red","أحمر" ,R.drawable.color_red ));
        arr_clrs.add(new Item("Black","أسود" ,R.drawable.color_black));
        arr_clrs.add(new Item("White","أبيض" ,R.drawable.color_white ));
        arr_clrs.add(new Item("Green","أخضر" , R.drawable.color_green ));
        arr_clrs.add(new Item("Brown","بُني" ,R.drawable.color_brown));
        arr_clrs.add(new Item("Gray","رمادي" , R.drawable.color_gray ));

        // inistials TextToSpeach
        tts = new TextToSpeech(getBaseContext(), new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status) {
                if (status  == TextToSpeech.SUCCESS){
                    int res = tts.setLanguage(Locale.US);
                    if(res == TextToSpeech.LANG_MISSING_DATA || res == TextToSpeech.LANG_NOT_SUPPORTED ){
                        Log.d("TTS","First error");
                    }


                }else {
                    Log.d("TTS","Second error");
                }
            }
        });

        final ItemAdapter adapter_clrs = new ItemAdapter(this,arr_clrs,R.color.colorColors);

        ListView list = (ListView) findViewById(R.id.list_colors);
        list.setAdapter(adapter_clrs);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tts.speak(adapter_clrs.getItem(position).getS1(),TextToSpeech.QUEUE_FLUSH,null);

            }
        });




    }

}
