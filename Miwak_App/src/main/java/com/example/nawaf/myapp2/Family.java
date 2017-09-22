package com.example.nawaf.myapp2;

import android.content.Context;
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

public class Family extends AppCompatActivity {

    private TextToSpeech tts;

    @Override
    protected void onDestroy(){
        super.onDestroy();
        tts.shutdown();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
                final ArrayList<Item> arr_fam =  new ArrayList<Item>();
        arr_fam.add(new Item("Father","الأب" ,R.drawable.family_father ));
        arr_fam.add(new Item("Mother","الأم" , R.drawable.family_mother));
        arr_fam.add(new Item("Sister","الأخت" ,R.drawable.family_younger_sister));
        arr_fam.add(new Item("Daughter","البنت" , R.drawable.family_daughter));
        arr_fam.add(new Item("Son","الإبن" , R.drawable.family_son));
        arr_fam.add(new Item("Grandfather","الجد" ,R.drawable.family_grandfather));
        arr_fam.add(new Item("Grandmother","الجدة" , R.drawable.family_grandmother));

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

        final ItemAdapter adapter_fam = new ItemAdapter(this,arr_fam , R.color.colorFamily);
        ListView list = (ListView) findViewById(R.id.list_family);
        list.setAdapter(adapter_fam);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                tts.speak(adapter_fam.getItem(position).getS1(),TextToSpeech.QUEUE_FLUSH,null);



            }
        });




    }

}
