package com.example.nawaf.myapp2;

import android.app.Activity;
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

public class NumbersFragment extends Fragment {
    private TextToSpeech tts;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_numbers,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ArrayList<Item> arr_nbs = new ArrayList<Item>();

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

        arr_nbs.add(new Item("One", "واحد", R.drawable.number_one));
        arr_nbs.add(new Item("Two", "إثنان", R.drawable.number_two));
        arr_nbs.add(new Item("Three", "ثلاثة", R.drawable.number_three));
        arr_nbs.add(new Item("Four", "أربعة", R.drawable.number_four));

        arr_nbs.add(new Item("Five", "خمسة", R.drawable.number_five));
        arr_nbs.add(new Item("Six", "ستة", R.drawable.number_six));
        arr_nbs.add(new Item("Seven", "سبعة", R.drawable.number_seven));
        arr_nbs.add(new Item("Eight", "ثمانية", R.drawable.number_eight));

        arr_nbs.add(new Item("Nine", "تسعة", R.drawable.number_nine));
        arr_nbs.add(new Item("Ten", "عشرة", R.drawable.number_ten));


        final ItemAdapter adapter_nbs = new ItemAdapter(getActivity(), arr_nbs, R.color.colorNumbers);

        final ListView list = (ListView) getActivity().findViewById(R.id.list_numbers);
        list.setAdapter(adapter_nbs);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tts.speak(adapter_nbs.getItem(position).getS1(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}
