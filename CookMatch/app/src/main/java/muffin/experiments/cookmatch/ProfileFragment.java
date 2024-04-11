package muffin.experiments.cookmatch;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import muffin.experiments.cookmatch.databinding.FragmentHomeBinding;
import muffin.experiments.cookmatch.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentProfileBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        View view = binding.getRoot();

        binding.imageViewSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SettingsFragment());
            }
        });

        final BSLProfileFragment bottomFragment = new BSLProfileFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerBottomSheet, bottomFragment)
                .commit();
        View container_t = view.findViewById(R.id.containerBottomSheet);
        BottomSheetBehavior<View> bottomSheetBehaviour = BottomSheetBehavior.from(container_t);

        bottomSheetBehaviour.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(newState == 3){
                    //Toast.makeText(getActivity().getApplicationContext(), "Полностью открыт экран", Toast.LENGTH_SHORT).show();
                }else{
                    binding.imageViewSettings.setVisibility(View.VISIBLE);
                    binding.addRecipe.setVisibility(View.VISIBLE);
                    binding.imageViewAvatar.setVisibility(View.VISIBLE);
                    binding.nickname.setVisibility(View.VISIBLE);
                    binding.recipies.setVisibility(View.VISIBLE);
                    binding.subscribes.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                if (v >= 0.5f) {
                    bottomFragment.setOpenProgress(v);
                    binding.subscribes.setVisibility(View.GONE);
                    binding.recipies.setVisibility(View.GONE);
                    binding.nickname.setVisibility(View.GONE);
                    binding.imageViewAvatar.setVisibility(View.GONE);
                    binding.addRecipe.setVisibility(View.GONE);
                    binding.imageViewSettings.setVisibility(View.GONE);
                }else{
                    //binding.searchView.setVisibility(View.VISIBLE);
                    //binding.button.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.addRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new OtherProfileFragment());
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