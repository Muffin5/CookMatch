package muffin.experiments.cookmatch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

import muffin.experiments.cookmatch.databinding.FragmentBottomSheetBinding;

public class BottomSheetFragment extends Fragment {

    private View imgArrow;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        BottomSheetBehavior bottomSheetBehaviour = BottomSheetBehavior.from(container);
        bottomSheetBehaviour.setState(BottomSheetBehavior.STATE_COLLAPSED);

        FragmentBottomSheetBinding binding_bottom_sheet = DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_sheet, container,false);
        View view_bottom_sheet = binding_bottom_sheet.getRoot();

        RecyclerView courseRV = view_bottom_sheet.findViewById(R.id.idRVCourse);

        // Here, we have created new array list and added data to it
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();
        courseModelArrayList.add(new CourseModel("DSA in Java", 4));
        courseModelArrayList.add(new CourseModel("Java Course", 4));
        courseModelArrayList.add(new CourseModel("C++ Course", 4));
        courseModelArrayList.add(new CourseModel("DSA in C++", 4));
        courseModelArrayList.add(new CourseModel("Kotlin for Android", 4));
        courseModelArrayList.add(new CourseModel("Java for Android", 4));
        courseModelArrayList.add(new CourseModel("HTML and CSS", 4));

        // we are initializing our adapter class and passing our arraylist to it.
        CourseAdapter courseAdapter = new CourseAdapter(getContext(), courseModelArrayList, new CourseAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(CourseModel item) {
                Toast.makeText(getContext(), item.getCourse_name().toString(), Toast.LENGTH_LONG).show();
            }
        });

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view_bottom_sheet.getContext(), LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(courseAdapter);

        return view_bottom_sheet;
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