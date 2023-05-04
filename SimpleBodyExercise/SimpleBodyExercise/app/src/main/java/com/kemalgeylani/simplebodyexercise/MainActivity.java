package com.kemalgeylani.simplebodyexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.view.View;
import com.kemalgeylani.simplebodyexercise.databinding.ActivityMainBinding;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> exerciseList = new ArrayList<>();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        exerciseList.add("Squats");
        exerciseList.add("Push-ups");
        exerciseList.add("Lunges");
        exerciseList.add("Plank");
        exerciseList.add("Sit-ups");
        exerciseList.add("Burpees");
        exerciseList.add("Jumping jacks");
        exerciseList.add("Dumbbell curls");

        // RecyclerView
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ExerciseAdapter exerciseAdapter = new ExerciseAdapter(exerciseList);
        binding.recyclerView.setAdapter(exerciseAdapter);


        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Seçilen egzersizin pozisyonunu alın
                String selectedExercise = (String) exercises.get(position);

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("selectedExercise",selectedExercise);
                startActivity(intent);
            }
        });

         */
    }
}