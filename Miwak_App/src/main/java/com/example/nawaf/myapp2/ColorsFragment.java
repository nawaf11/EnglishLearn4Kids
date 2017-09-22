package com.example.nawaf.myapp2;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by nawaf on 12/30/16.
 */

public class ColorsFragment extends Fragment {
    private TextToSpeech tts;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_colors ,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ArrayList<Item> arr_clrs =  new ArrayList<Item>();
        arr_clrs.add(new Item("Red","أحمر" ,R.drawable.color_red ));
        arr_clrs.add(new Item("Black","أسود" ,R.drawable.color_black));
        arr_clrs.add(new Item("White","أبيض" ,R.drawable.color_white ));
        arr_clrs.add(new Item("Green","أخضر" , R.drawable.color_green ));
        arr_clrs.add(new Item("Brown","بُني" ,R.drawable.color_brown));
        arr_clrs.add(new Item("Gray","رمادي" , R.drawable.color_gray ));

        // inistials TextToSpeach
        tts = new TextToSpeech(getActivity().getBaseContext(), new TextToSpeech.OnInitListener(){
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

        final ItemAdapter adapter_clrs = new ItemAdapter(getActivity(),arr_clrs,R.color.colorColors);

        ListView list = (ListView) getActivity().findViewById(R.id.list_colors);
        list.setAdapter(adapter_clrs);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tts.speak(adapter_clrs.getItem(position).getS1(),TextToSpeech.QUEUE_FLUSH,null);

            }
        });

    }
}
