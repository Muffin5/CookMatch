package muffin.experiments.cookmatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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

        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        //DatabaseReference num = FirebaseDatabase.getInstance().getReference("Numbers");
        //num.child("numer").setValue("12");

        final BottomSheetFragment bottomFragment = new BottomSheetFragment();
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
    }
}