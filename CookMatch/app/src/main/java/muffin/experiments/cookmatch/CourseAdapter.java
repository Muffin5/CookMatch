package muffin.experiments.cookmatch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(CourseModel item);
    }

    private OnItemClickListener listener;

    public CourseAdapter(Context context, ArrayList<CourseModel> courseModelArrayList, OnItemClickListener listener) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView courseIV;
        private final TextView courseNameTV;
        //private final TextView courseRatingTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseIV = itemView.findViewById(R.id.card_image);
            courseNameTV = itemView.findViewById(R.id.card_name_recipe);
            //courseRatingTV = itemView.findViewById(R.id.card_name_autor);
        }

        public void bind(CourseModel item, OnItemClickListener listener) {
            courseNameTV.setText(item.getCourse_name());
            //courseRatingTV.setText(item.getCourse_rating());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    private final Context context;
    private final ArrayList<CourseModel> courseModelArrayList;

    // Constructor

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(v);
    }
    
    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {
        // to set data to textview and imageview of each card layout
        CourseModel model = courseModelArrayList.get(position);
        holder.courseNameTV.setText(model.getCourse_name());
        //holder.courseRatingTV.setText("" + model.getCourse_rating());
        holder.courseIV.setImageResource(model.getCourse_image());

        holder.bind(courseModelArrayList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number of card items in recycler view
        return courseModelArrayList.size();
    }



    // View holder class for initializing of your views such as TextView and Imageview
}
