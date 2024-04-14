package muffin.experiments.cookmatch;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import muffin.experiments.cookmatch.databinding.FragmentChooseIngredientsBinding;

public class ChooseIngredientsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentChooseIngredientsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_choose_ingredients, container, false);
        View view = binding.getRoot();

        replaceFragment(new ChoosedIngredientsFragment());

        /*binding.searchIngredients.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SearchIngredientsFragment());
            }
        });

        binding.searchIngredients.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SearchIngredientsFragment());
            }
        });*/

        return view;
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.place_holder_ingredients, fragment);
        fragmentTransaction.commit();
    }
}