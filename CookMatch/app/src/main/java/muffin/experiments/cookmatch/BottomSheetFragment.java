package muffin.experiments.cookmatch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BottomSheetFragment extends Fragment {

    private View imgArrow;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        BottomSheetBehavior bottomSheetBehaviour = BottomSheetBehavior.from(container);
        bottomSheetBehaviour.setState(BottomSheetBehavior.STATE_COLLAPSED);
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    void setOpenProgress(float progress) {
        // Rotate arrow in 1/3 of the screen to 180
        // meaning that after 1/3 we assume sheet to be opened
        //imgArrow.setRotation(Math.min(180 * progress * 3, 180));
    }
}