package muffin.experiments.cookmatch;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import muffin.experiments.cookmatch.databinding.FragmentRecipeBinding;

public class RecipeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentRecipeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipe, container, false);
        View view = binding.getRoot();

        Bundle bundle = this.getArguments();
        String name = "Иди нахер";
        if (bundle != null) {
            name = bundle.getString("name","");
        }

        binding.fragNameRecipe.setText(name);

        return view;
    }
}