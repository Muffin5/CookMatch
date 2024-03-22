package muffin.experiments.cookmatch;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import muffin.experiments.cookmatch.databinding.FragmentFavouriteBinding;

public class FavouriteFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentFavouriteBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourite, container,false);
        View view = binding.getRoot();

        RecyclerView courseRV = view.findViewById(R.id.idRVCourse);

        // Here, we have created new array list and added data to it
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();
        courseModelArrayList.add(new CourseModel("DSA in Java", 4));
        courseModelArrayList.add(new CourseModel("Java Course", 3));
        courseModelArrayList.add(new CourseModel("C++ Course", 4));
        courseModelArrayList.add(new CourseModel("DSA in C++", 4));
        courseModelArrayList.add(new CourseModel("Kotlin for Android", 4));
        courseModelArrayList.add(new CourseModel("Java for Android", 4));
        courseModelArrayList.add(new CourseModel("HTML and CSS", 4));

        // we are initializing our adapter class and passing our arraylist to it.
        CourseAdapter courseAdapter = new CourseAdapter(view.getContext(), courseModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(courseAdapter);

        return view;
    }
}