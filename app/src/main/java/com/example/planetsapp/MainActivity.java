package com.example.planetsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Planet> planets = new ArrayList<>();
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            // 1 - AdapterView: a ListView
            listView = findViewById(R.id.listView);
            // 2 - Data Source: ArrayList<Planet>
            planets.add(new Planet("Earth", "1 Moon", R.drawable.earth));
            planets.add(new Planet("Mercury", "0 Moons", R.drawable.mercury));
            planets.add(new Planet("Venus", "0 Moons", R.drawable.venus));
            planets.add(new Planet("Mars", "2 Moons", R.drawable.mars));
            planets.add(new Planet("Jupiter", "79 Moons", R.drawable.jupiter));
            planets.add(new Planet("Saturn", "83 Moons", R.drawable.saturn));
            planets.add(new Planet("Uranus", "27 Moons", R.drawable.uranus));
            planets.add(new Planet("Neptune", "14 Moons", R.drawable.neptune));
            planets.add(new Planet("Pluto", "0", R.drawable.pluto));

            //Adapter
            customAdapter = new CustomAdapter(planets, this);

            listView.setAdapter(customAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this, "Planet Name: " + customAdapter.getItem(position).getPlanetName(), Toast.LENGTH_SHORT).show();
                }
            });
            return insets;
        });
    }
}