package muffin.experiments.cookmatch;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import muffin.experiments.cookmatch.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {
    private boolean flag = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentSettingsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false);
        View view = binding.getRoot();

        binding.timer.setVisibility(View.GONE);
        binding.subAndLikes.setVisibility(View.GONE);

        binding.notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.timer.setVisibility(flag ? View.GONE : View.VISIBLE);
                binding.subAndLikes.setVisibility(flag ? View.GONE : View.VISIBLE);
                flag = !flag;
            }
        });

        binding.settingsAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SettingsAccountFragment());
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