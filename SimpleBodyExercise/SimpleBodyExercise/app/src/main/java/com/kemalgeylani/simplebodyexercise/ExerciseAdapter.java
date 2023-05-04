package com.kemalgeylani.simplebodyexercise;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kemalgeylani.simplebodyexercise.databinding.ExercisesRowBinding;
import java.util.ArrayList;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseHolder> {

    ArrayList<String> exerciseList;

    public ExerciseAdapter(ArrayList<String> exerciseList) {
        this.exerciseList = exerciseList;
    }

    @NonNull
    @Override
    public ExerciseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ExercisesRowBinding exercisesRowBinding = ExercisesRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ExerciseHolder(exercisesRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseHolder holder, int position) {

        holder.binding.exercisesText.setText(exerciseList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.itemView.getContext(),MainActivity2.class);
                Singleton singleton = Singleton.getInstance();
                singleton.setSentExercise(exerciseList.get(position));
                holder.itemView.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public class ExerciseHolder extends RecyclerView.ViewHolder {

        private ExercisesRowBinding binding;

        public ExerciseHolder(ExercisesRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
