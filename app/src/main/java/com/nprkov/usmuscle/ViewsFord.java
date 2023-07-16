package com.nprkov.usmuscle;


import android.os.Bundle;
import static ie.imobile.extremepush.PushConnector.mPushConnector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nprkov.usmuscle.R;

import java.util.ArrayList;
import java.util.List;

public class ViewsFord extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ford_views);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<CardItem> cardItems = createCardItems();
        cardAdapter = new CardAdapter(cardItems);
        recyclerView.setAdapter(cardAdapter);

    }

    private List<CardItem> createCardItems() {
        List<CardItem> cardItems = new ArrayList<>();
        // Add your card items to the list
        cardItems.add(new CardItem(R.drawable.fordf150, "Ford F150", "The Ford F-150 is a versatile full-size pickup truck known for its ruggedness and capability. It offers a range of engine options to suit different needs, from efficient V6 engines to a powerful V8 and a diesel option.", "2.0", "Learn More"));
        cardItems.add(new CardItem(R.drawable.fordmustang, "Ford Mustang", "The Ford Mustang is an iconic American muscle car that blends power and style. It is available with various engine choices, including an efficient EcoBoost four-cylinder, a V6, and a mighty V8 for exhilarating performance.", "2.0", "Learn More"));
        cardItems.add(new CardItem(R.drawable.fordexplorer, "Ford Explorer", "The Ford Explorer is a popular SUV offering spaciousness and versatility. It comes with a range of engine options, including a turbocharged four-cylinder, a V6, and a hybrid powertrain for improved fuel efficiency.", "2.0", "Learn More"));
        cardItems.add(new CardItem(R.drawable.fordescape, "Ford Escape", "The Ford Escape is a compact SUV designed for everyday practicality. It features a range of engine choices, including a turbocharged three-cylinder, a more powerful turbocharged four-cylinder, and a hybrid option for enhanced fuel economy.", "2.0", "Learn More"));


        return cardItems;
    }
}