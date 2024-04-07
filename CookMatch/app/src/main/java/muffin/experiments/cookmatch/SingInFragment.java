package muffin.experiments.cookmatch;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import muffin.experiments.cookmatch.databinding.FragmentSingInBinding;

public class SingInFragment extends Fragment {

    private ImageView ImagePreview;

    final int SELECT_PICTURE = 200;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentSingInBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sing_in, container, false);
        View view = binding.getRoot();

        ImagePreview = binding.imageViewAvatar;

        binding.buttonSingin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.editName.getText().toString().trim().equals("")){
                    Toast.makeText(getActivity().getApplicationContext(), binding.editName.getHint().toString(), Toast.LENGTH_SHORT).show();
                }else if(binding.editPassword.getText().toString().trim().equals("")){
                    Toast.makeText(getActivity().getApplicationContext(), binding.editPassword.getHint().toString(), Toast.LENGTH_SHORT).show();
                }else if(binding.editEmail.getText().toString().trim().equals("")){
                    Toast.makeText(getActivity().getApplicationContext(), binding.editEmail.getHint().toString(), Toast.LENGTH_SHORT).show();
                }else if(binding.editPhone.getText().toString().trim().equals("")){
                    Toast.makeText(getActivity().getApplicationContext(), binding.editPhone.getHint().toString(), Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(getContext(), Home.class);
                    startActivity(intent);
                }
            }
        });

        binding.imageViewAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
            }
        });

        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    ImagePreview.setImageURI(selectedImageUri);
                    Bitmap img = ((BitmapDrawable)ImagePreview.getDrawable()).getBitmap();
                    Bitmap bitmap = Bitmap.createScaledBitmap(img, 150, 150, true);
                    ImagePreview.setImageBitmap(bitmap);
                }
            }
        }
    }
}