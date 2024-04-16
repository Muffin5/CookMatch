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

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import muffin.experiments.cookmatch.databinding.FragmentSingInBinding;

public class SingInFragment extends Fragment {

    private boolean flag_name = false;
    private boolean flag_phone = false;
    private boolean flag_email = false;
    private boolean flag_password = false;

    private ImageView ImagePreview;

    final int SELECT_PICTURE = 200;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentSingInBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sing_in, container, false);
        View view = binding.getRoot();

        ImagePreview = binding.imageViewAvatar;

        binding.buttonSingin.getBackground().setAlpha(100);

        binding.editPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(binding.editPhone.getText().toString().equals("")){
                    flag_phone = false;
                }else{
                    flag_phone = true;
                }
                if(!flag_phone || !flag_name || !flag_email || !flag_password){
                    binding.buttonSingin.getBackground().setAlpha(100);
                }else{
                    binding.buttonSingin.getBackground().setAlpha(255);
                }
            }
        });

        binding.editName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(binding.editName.getText().toString().equals("")){
                    flag_name = false;
                }else{
                    flag_name = true;
                }
                if(!flag_phone || !flag_name || !flag_email || !flag_password){
                    binding.buttonSingin.getBackground().setAlpha(100);
                }else{
                    binding.buttonSingin.getBackground().setAlpha(255);
                }
            }
        });

        binding.editEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(binding.editEmail.getText().toString().equals("")){
                    binding.buttonSingin.getBackground().setAlpha(100);
                }else{
                    binding.buttonSingin.getBackground().setAlpha(255);
                }
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(binding.editEmail.getText().toString().equals("")){
                    flag_email = false;
                }else{
                    flag_email = true;
                }
                if(!flag_phone || !flag_name || !flag_email || !flag_password){
                    binding.buttonSingin.getBackground().setAlpha(100);
                }else{
                    binding.buttonSingin.getBackground().setAlpha(255);
                }
            }
        });

        binding.editPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(binding.editPassword.getText().toString().equals("")) {
                    flag_password = false;
                }else{
                    flag_password = true;
                }
                if(!flag_phone || !flag_name || !flag_email || !flag_password){
                    binding.buttonSingin.getBackground().setAlpha(100);
                }else{
                    binding.buttonSingin.getBackground().setAlpha(255);
                }
            }
        });

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
                    DatabaseReference num = FirebaseDatabase.getInstance().getReference("Users/"+binding.editName.getText().toString());
                    num.child("Password").setValue(binding.editPassword.getText().toString());
                    num.child("Phone").setValue(binding.editPhone.getText().toString());
                    num.child("Email").setValue(binding.editEmail.getText().toString());
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