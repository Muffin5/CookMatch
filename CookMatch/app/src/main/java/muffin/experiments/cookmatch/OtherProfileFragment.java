package muffin.experiments.cookmatch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import muffin.experiments.cookmatch.databinding.FragmentOtherProfileBinding;

public class OtherProfileFragment extends Fragment {

    private boolean flag = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentOtherProfileBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_other_profile, container, false);
        View view = binding.getRoot();

        final BSLOtherProfileFragment bottomFragment = new BSLOtherProfileFragment();
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
                    binding.subscribe.setVisibility(View.VISIBLE);
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
                    binding.subscribe.setVisibility(View.GONE);
                }else{
                    //binding.searchView.setVisibility(View.VISIBLE);
                    //binding.button.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flag){
                    binding.subscribe.setText("Подписан(а)");
                    binding.subscribe.setBackgroundColor(getResources().getColor(R.color.disactivated));
                    binding.subscribe.setTextColor(getResources().getColor(R.color.black));
                }else{
                    binding.subscribe.setText("Подписаться");
                    binding.subscribe.setBackgroundColor(getResources().getColor(R.color.grey));
                    binding.subscribe.setTextColor(getResources().getColor(R.color.white));
                }
                flag = !flag;
            }
        });
        return view;
    }
}