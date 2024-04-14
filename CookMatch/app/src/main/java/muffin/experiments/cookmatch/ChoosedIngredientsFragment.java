package muffin.experiments.cookmatch;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import muffin.experiments.cookmatch.databinding.FragmentChoosedIngredientsBinding;
import muffin.experiments.cookmatch.databinding.CardIngredientBinding;

public class ChoosedIngredientsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentChoosedIngredientsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_choosed_ingredients, container, false);
        View view = binding.getRoot();

        CardView cardview = new CardView(getContext());

        cardview.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                -100
        ));

        cardview.setBackgroundColor(getResources().getColor(R.color.grey));
        //cardview.setRadius(8f);

        LinearLayout layout_ = new LinearLayout(getContext());

        layout_.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));

        layout_.setOrientation(LinearLayout.HORIZONTAL);

        TextView text = new TextView(getContext());

        text.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        text.setTextSize(30);

        text.setGravity(Gravity.CENTER);
        text.setText("Сережа");
        text.setTextColor(getResources().getColor(R.color.white));

        ImageView img = new ImageView(getContext());

        img.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        img.setImageResource(R.drawable.profile_fill);

        layout_.addView(text);
        layout_.addView(img);

        cardview.addView(layout_);




        CardView cardview2 = new CardView(getContext());

        cardview2.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                200
        ));

        cardview2.setBackgroundColor(getResources().getColor(R.color.grey));
        //cardview.setRadius(8f);

        LinearLayout layout_2 = new LinearLayout(getContext());

        layout_2.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));

        layout_2.setOrientation(LinearLayout.HORIZONTAL);

        TextView text2 = new TextView(getContext());

        text2.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        text2.setTextSize(30);

        text2.setGravity(Gravity.CENTER);
        text2.setText("Сбрил брови сыну");
        text2.setTextColor(getResources().getColor(R.color.white));

        ImageView img2 = new ImageView(getContext());

        img2.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        img2.setImageResource(R.drawable.profile_fill);

        layout_2.addView(text2);
        layout_2.addView(img2);

        cardview2.addView(layout_2);

        /*ViewGroup.LayoutParams layoutparams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        cardview.setLayoutParams(layoutparams);*/
        //cardview = (CardView) LayoutInflater.from(getContext()).inflate(R.layout.card_ingredient, null);

        //CardIngredientBinding binding_in = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.card_ingredient, cardview.getChil, false);
        //cardview.getChildAt(0);

        binding.testHolder.addView(cardview2);
        binding.testHolder.addView(cardview);

        return view;
    }
}