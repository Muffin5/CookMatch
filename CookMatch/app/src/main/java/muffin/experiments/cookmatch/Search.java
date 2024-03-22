package muffin.experiments.cookmatch;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;

import java.util.ArrayList;

import muffin.experiments.cookmatch.databinding.ActivityHomeBinding;
import muffin.experiments.cookmatch.databinding.SearchBinding;

public class Search extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        SearchBinding binding = DataBindingUtil.setContentView(this, R.layout.search);

        ArrayList<String> programmingLanguagesList = new ArrayList<>();
        programmingLanguagesList.add("C");
        programmingLanguagesList.add("C#");
        programmingLanguagesList.add("Java");
        programmingLanguagesList.add("Javascript");
        programmingLanguagesList.add("Python");
        programmingLanguagesList.add("Dart");
        programmingLanguagesList.add("Kotlin");
        programmingLanguagesList.add("Typescript");

        ArrayAdapter<String> listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, programmingLanguagesList);

        binding.idLVProgrammingLanguages.setAdapter(listAdapter);

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (programmingLanguagesList.contains(query)) {
                    listAdapter.getFilter().filter(query);
                } else {
                    Toast.makeText(getApplicationContext(), "No results found", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
