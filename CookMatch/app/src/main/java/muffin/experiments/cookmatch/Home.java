package muffin.experiments.cookmatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import muffin.experiments.cookmatch.databinding.ActivityHomeBinding;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        replaceFragment(new HomeFragment());

        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        ColorStateList iconColorStates = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_checked},
                        new int[]{android.R.attr.state_checked}
                },
                new int[]{
                        Color.parseColor("#FFFFFFFF"),
                        Color.parseColor("#FFFFFFFF")
                });

        binding.bottomNavigationView.setItemIconTintList(iconColorStates);
        binding.bottomNavigationView.setItemTextColor(iconColorStates);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.nav_home){
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.nav_favourite) {
                replaceFragment(new FavouriteFragment());
            } else if (item.getItemId() == R.id.nav_profile) {
                replaceFragment(new ProfileFragment());
            }
            return true;
        });


        //DatabaseReference num = FirebaseDatabase.getInstance().getReference("Numbers");
        //num.child("numer").setValue("12");

        /*final BottomSheetFragment bottomFragment = new BottomSheetFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerBottomSheet, bottomFragment)
                .commit();
        View container = findViewById(R.id.containerBottomSheet);
        BottomSheetBehavior<View> bottomSheetBehaviour = BottomSheetBehavior.from(container);
        bottomSheetBehaviour.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(newState == 3){
                    Toast.makeText(getApplicationContext(), "Пора покормить кота!", Toast.LENGTH_SHORT).show();
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
                Intent intent = new Intent(getApplicationContext(), Search.class);
                startActivity(intent);
            }
        });

         */
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.place_holder, fragment);
        fragmentTransaction.commit();
    }
}