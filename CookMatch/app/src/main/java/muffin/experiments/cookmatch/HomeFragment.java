package muffin.experiments.cookmatch;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

import muffin.experiments.cookmatch.databinding.FragmentHomeBinding;
import muffin.experiments.cookmatch.databinding.FragmentBottomSheetBinding;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentHomeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container,false);
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
                if(newState == 3){
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

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DatabaseReference num = FirebaseDatabase.getInstance().getReference("Mudrost");
                //num.child("pora").setValue("spat");
            }
        });

        binding.searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Search.class);
                startActivity(intent);
            }
        });

        return view;
    }
}