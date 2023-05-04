package com.kemalgeylani.simplebodyexercise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;
import com.kemalgeylani.simplebodyexercise.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    AlertDialog.Builder alert;
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Intent intent = getIntent();
        //String selectedExercise = intent.getStringExtra("selectedExercise");

        Singleton singleton = Singleton.getInstance();
        String selectedExercise = singleton.getSentExercise();

        binding.textView2.setText("Exercise : " + selectedExercise);
    }

    public void start(View view){


        binding.determinateBar.setVisibility(View.VISIBLE); // görünür hale getir
        binding.determinateBar.setMax(30000);

        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                binding.textView3.setText("Time : " + millisUntilFinished / 1000);
                binding.determinateBar.setProgress(30000 - (int)millisUntilFinished); // ProgressBar'ı güncelle
            }

            @Override
            public void onFinish() {

                alert = new AlertDialog.Builder(MainActivity2.this);

                alert.setTitle("Return to Exercises Page");
                alert.setMessage("Next Exercise");

                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                        startActivity(intent);
                    }
                });

                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        binding.textView3.setText("Let's Take Break :)");
                        Toast.makeText(MainActivity2.this, "Finished !", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.show();
            }
        }.start();
    }

    public void turnback (View view){

        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }
}