package muffin.experiments.cookmatch;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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

        //FragmentBottomSheetBinding bindingbsl = DataBindingUtil.inflate(inflater,R.layout.fragment_bottom_sheet,container,false);

        final BottomSheetFragment bottomFragment = new BottomSheetFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerBottomSheet, bottomFragment)
                .commit();
        View container_t = view.findViewById(R.id.containerBottomSheet);
        BottomSheetBehavior<View> bottomSheetBehaviour = BottomSheetBehavior.from(container_t);

        //bindingbsl.textViewBsl.setText("Популярные рецепты");

        bottomSheetBehaviour.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(newState == 3){
                    //Toast.makeText(getActivity().getApplicationContext(), "Полностью открыт экран", Toast.LENGTH_SHORT).show();
                }else{
                    binding.searchView.setVisibility(View.VISIBLE);
                    binding.button.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                if (v >= 0.5f) {
                    bottomFragment.setOpenProgress(v);
                    binding.searchView.setVisibility(View.GONE);
                    binding.button.setVisibility(View.GONE);
                }else{
                    //binding.searchView.setVisibility(View.VISIBLE);
                    //binding.button.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DatabaseReference num = FirebaseDatabase.getInstance().getReference("Mudrost");
                //num.child("pora").setValue("spat");
                replaceFragment(new ChooseIngredientsFragment());
            }
        });

        binding.searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.searchView.clearFocus();
                Intent intent = new Intent(getActivity().getApplicationContext(), Search.class);
                startActivity(intent);
            }
        });

        binding.searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.searchView.clearFocus();
                binding.searchView.onActionViewCollapsed();
                Intent intent = new Intent(getActivity().getApplicationContext(), Search.class);
                startActivity(intent);
            }
        });


        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                //nothing
            }
        };

        getActivity().getOnBackPressedDispatcher().addCallback(onBackPressedCallback);

        return view;
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.place_holder, fragment);
        fragmentTransaction.commit();
    }

}