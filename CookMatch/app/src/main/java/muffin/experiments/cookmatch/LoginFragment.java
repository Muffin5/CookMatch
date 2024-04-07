package muffin.experiments.cookmatch;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import muffin.experiments.cookmatch.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentLoginBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        View view = binding.getRoot();

        binding.changeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editParameter.setHint("Введите имя");
                binding.editParameter.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
            }
        });

        binding.changeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editParameter.setHint("Введите электронную почту");
                binding.editParameter.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS);
            }
        });

        binding.changePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editParameter.setHint("Введите номер телефона");
                binding.editParameter.setInputType(InputType.TYPE_CLASS_PHONE);
            }
        });

        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.editParameter.getText().toString().trim().equals("")){
                    Toast.makeText(getActivity().getApplicationContext(), binding.editParameter.getHint().toString(), Toast.LENGTH_SHORT).show();
                }else if(binding.editPassword.getText().toString().trim().equals("")){
                    Toast.makeText(getActivity().getApplicationContext(), binding.editPassword.getHint().toString(), Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(getContext(), Home.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }
}