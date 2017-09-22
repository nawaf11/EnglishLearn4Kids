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

public class FamilyFragment extends Fragment {
    private TextToSpeech tts;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_family,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ArrayList<Item> arr_fam =  new ArrayList<Item>();
        arr_fam.add(new Item("Father","الأب" ,R.drawable.family_father ));
        arr_fam.add(new Item("Mother","الأم" , R.drawable.family_mother));
        arr_fam.add(new Item("Sister","الأخت" ,R.drawable.family_younger_sister));
        arr_fam.add(new Item("Daughter","البنت" , R.drawable.family_daughter));
        arr_fam.add(new Item("Son","الإبن" , R.drawable.family_son));
        arr_fam.add(new Item("Grandfather","الجد" ,R.drawable.family_grandfather));
        arr_fam.add(new Item("Grandmother","الجدة" , R.drawable.family_grandmother));

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

        final ItemAdapter adapter_fam = new ItemAdapter(getActivity(),arr_fam , R.color.colorFamily);
        ListView list = (ListView) getActivity().findViewById(R.id.list_family);
        list.setAdapter(adapter_fam);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                tts.speak(adapter_fam.getItem(position).getS1(),TextToSpeech.QUEUE_FLUSH,null);



            }
        });

    }
}
