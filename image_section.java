package com.example.android.meme_generator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class image_section extends Fragment {
    private static int PICK_IMAGE_REQUEST=1;
    private static final int PICK_IMAGE=100;
    Uri imageUri;
    private static TextView addLineInMeme1,addLineInMeme2;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.image_section,container,false);
        addLineInMeme1=(TextView)view.findViewById(R.id.meme_line_1);
        addLineInMeme2=(TextView)view.findViewById(R.id.meme_line_2);
        Button insertButton =(Button)view.findViewById(R.id.insert_button);
        imageView = (ImageView)view.findViewById(R.id.imagehere);

        insertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                insertImage();
            }
        });
        return view;
    }

    //adds text to the image in top and bottom textfield

    public void setMemeText(String top,String bottom)
    {
        Toast.makeText(getActivity().getApplicationContext(), "method in image section!", Toast.LENGTH_SHORT).show();
        addLineInMeme1.setText(top);
        addLineInMeme2.setText(bottom);
    }

    public void insertImage()
    {
        Intent intent = new Intent();
// Show only images, no videos or anything else
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
// Always show the chooser (if there are multiple options available)
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
