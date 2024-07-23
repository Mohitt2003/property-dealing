package com.example.project1662.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.project1662.Adapter.NearbyAdapter;
import com.example.project1662.Adapter.RecommendedAdapter;
import com.example.project1662.Domain.PropertyDomain;
import com.example.project1662.R;
import com.example.project1662.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private RecyclerView.Adapter adapterRecommended,adapterNearby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initLocation();
        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<PropertyDomain> items=new ArrayList<>();
        items.add(new PropertyDomain("Apartment","Royal Apartment","LosAngles LA","h_1",1500,2,3,true,4.5,"This 2 bed /1 bath home boasts an enormous,open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings. "));
        items.add(new PropertyDomain("House","House with Great View","Newyork NY","h_2",800,1,2,false,4.9,"This 2 bed /1 bath home boasts an enormous,open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings. "));
        items.add(new PropertyDomain("Villa","Royal Villa","LosAngles La","h_3",999,2,1,true,4.7,"This 2 bed /1 bath home boasts an enormous,open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings. "));

        binding.recommendedView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterRecommended=new RecommendedAdapter(items);
        binding.recommendedView.setAdapter(adapterRecommended);

        binding.nearbyView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapterNearby=new NearbyAdapter(items);
        binding.nearbyView.setAdapter(adapterNearby);
    }

    private void initLocation() {
        String[] items=new String[]{"LosAngles, USA","NewYork, USA"};

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.locationSpin.setAdapter(adapter);
    }
}