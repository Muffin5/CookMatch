package muffin.experiments.cookmatch;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

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

        final BottomSheetFragment bottomFragment = new BottomSheetFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerBottomSheet, bottomFragment)
                .commit();
        View container_t = view.findViewById(R.id.containerBottomSheet);
        BottomSheetBehavior<View> bottomSheetBehaviour = BottomSheetBehavior.from(container_t);

        bottomSheetBehaviour.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == 3) {
                    Toast.makeText(getActivity().getApplicationContext(), "Полностью открыт экран", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                if (v >= 0) {
                    bottomFragment.setOpenProgress(v);
                }
            }
        });
        return view;
    }
}