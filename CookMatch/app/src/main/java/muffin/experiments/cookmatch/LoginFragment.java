package muffin.experiments.cookmatch;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import muffin.experiments.cookmatch.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private boolean flag_parameter = false;
    private boolean flag_password = false;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentLoginBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        View view = binding.getRoot();

        binding.changeName.setTextColor(getResources().getColor(R.color.white));
        binding.changeEmail.setTextColor(getResources().getColor(R.color.disactivated));
        binding.changePhone.setTextColor(getResources().getColor(R.color.disactivated));

        binding.buttonLogin.getBackground().setAlpha(100);

        binding.changeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.changeName.setTextColor(getResources().getColor(R.color.white));
                binding.changeEmail.setTextColor(getResources().getColor(R.color.disactivated));
                binding.changePhone.setTextColor(getResources().getColor(R.color.disactivated));

                binding.editParameter.setHint("Введите имя");
                binding.editParameter.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
            }
        });

        binding.changeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.changeName.setTextColor(getResources().getColor(R.color.disactivated));
                binding.changeEmail.setTextColor(getResources().getColor(R.color.white));
                binding.changePhone.setTextColor(getResources().getColor(R.color.disactivated));
                binding.editParameter.setHint("Введите электронную почту");
                binding.editParameter.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS);
            }
        });

        binding.changePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.changeName.setTextColor(getResources().getColor(R.color.disactivated));
                binding.changeEmail.setTextColor(getResources().getColor(R.color.disactivated));
                binding.changePhone.setTextColor(getResources().getColor(R.color.white));
                binding.editParameter.setHint("Введите номер телефона");
                binding.editParameter.setInputType(InputType.TYPE_CLASS_PHONE);
            }
        });

        binding.editParameter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (binding.editParameter.getText().toString().equals("")) {
                    flag_parameter = false;
                } else {
                    flag_parameter = true;
                }

                if (!flag_password || !flag_parameter) {
                    binding.buttonLogin.getBackground().setAlpha(100);
                } else {
                    binding.buttonLogin.getBackground().setAlpha(255);
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
                if(binding.editPassword.getText().toString().equals("")){
                    flag_password = false;
                }else{
                    flag_password = true;
                }

                if(!flag_password || !flag_parameter) {
                    binding.buttonLogin.getBackground().setAlpha(100);
                }else{
                    binding.buttonLogin.getBackground().setAlpha(255);
                }
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

                    boolean check = false;

                    FirebaseJavaAPI obj = new FirebaseJavaAPI();
                    String parameter;
                    switch (binding.editParameter.getInputType()){
                        case InputType.TYPE_CLASS_PHONE:
                            parameter = "Phone";
                            break;
                        case InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS:
                            parameter = "Email";
                        default:
                            parameter = "Name";
                            break;
                    }
                    /*

                    ArrayList<DataSnapshot> data = new ArrayList<>();

                    data = obj.takeAll("Users");
                    */

                    /*Log.i("Text", binding.editParameter.getText().toString());


                    DataSnapshot buf = obj.takeOne("Users", binding.editParameter.getText().toString());
                    Log.i("Text", buf.getValue().toString());

                    if(buf.getValue().toString().equals(binding.editParameter.getText().toString())){
                        Toast.makeText(getActivity().getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    }*/

                    /*for (DataSnapshot parent: data) {
                        for (DataSnapshot child : parent.getChildren()) {
                            if(parameter.equals("Name") && child.getValue().toString().equals(binding.editParameter.getText().toString()))
                                Toast.makeText(getActivity().getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();

                        }
                    };*/

                    Intent intent = new Intent(getContext(), Home.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }
}