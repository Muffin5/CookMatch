package muffin.experiments.cookmatch;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import muffin.experiments.cookmatch.databinding.FragmentChoosedIngredientsBinding;

public class ChoosedIngredientsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentChoosedIngredientsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_choosed_ingredients, container, false);
        View view = binding.getRoot();

        return view;
    }
}