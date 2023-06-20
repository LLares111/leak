package com.example.leak;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private static View redSquare;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the LinearLayout and Button
        layout = new LinearLayout(this);
        Button button = new Button(this);
        button.setText("Add/Remove red square");

        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        button.setLayoutParams(buttonParams);

        // Set the button click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (redSquare == null) {
                    // Create and add the red square View to the LinearLayout
                    redSquare = new View(MainActivity.this);
                    redSquare.setBackgroundColor(getColor(android.R.color.holo_red_light));
                    LinearLayout.LayoutParams squareParams = new LinearLayout.LayoutParams(200, 200);
                    redSquare.setLayoutParams(squareParams);
                    layout.addView(redSquare);
                } else {
                    // Remove the red square View from the LinearLayout and destroy it
                    layout.removeView(redSquare);
                    //redSquare = null;
                }
            }
        });

        // Add the button to the LinearLayout and set the LinearLayout as the activity content
        layout.addView(button);
        setContentView(layout);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Do not nullify the redSquare here to simulate the memory leak.
        // redSquare = null;
    }
}
