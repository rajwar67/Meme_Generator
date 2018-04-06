package com.example.android.meme_generator;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class top_section extends Fragment{

    public static EditText topLine,bottomLine;

    TopSectionInterface activityCommander;
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.top_section,container,false);
        topLine=(EditText) view.findViewById(R.id.memeline1);
        bottomLine=(EditText)view.findViewById(R.id.memeline2);
        Button button =view.findViewById(R.id.addLineButton);

        button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        //Log.d("testing","hello");
                        addLinesFunc(v);

                    }
                }
        );

        return view;
    }

    public interface TopSectionInterface{
        public void createMeme(String top,String bottom);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try
        {
            activityCommander=(TopSectionInterface) context;
        }
        catch(ClassCastException e)
        {
            throw new ClassCastException(context.toString());

        }
    }

    public void addLinesFunc(View view)
    {


        activityCommander.createMeme(topLine.getText().toString(),bottomLine.getText().toString());
    }
}
