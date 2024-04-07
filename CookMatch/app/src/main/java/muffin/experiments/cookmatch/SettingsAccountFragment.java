package muffin.experiments.cookmatch;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import muffin.experiments.cookmatch.databinding.FragmentSettingsAccountBinding;

public class SettingsAccountFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentSettingsAccountBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings_account, container, false);
        View view = binding.getRoot();

        binding.buttonSeeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new ProfileFragment());
            }
        });

        binding.imageViewCloseSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new ProfileFragment());
            }
        });

        return view;
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.place_holder, fragment);
        fragmentTransaction.commit();
    }
}