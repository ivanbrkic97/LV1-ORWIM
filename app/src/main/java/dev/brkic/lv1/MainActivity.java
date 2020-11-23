package dev.brkic.lv1;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dev.brkic.lv1.adapters.RecyclerAdapter;
import dev.brkic.lv1.common.NameClickListener;
import dev.brkic.lv1.models.Athlete;

public class MainActivity extends AppCompatActivity implements NameClickListener {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private List<Athlete> athletes = new ArrayList<Athlete>();
    private RadioButton firstAthleteRadioButton;
    private RadioButton secondPersonRadioButton;
    private RadioButton thirdPersonRadioButton;
    private RadioGroup radioGroup;
    Random random = new Random();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecycler();
        setupRecyclerData();
        radioGroup = findViewById(R.id.radioGroup);
        firstAthleteRadioButton = findViewById(R.id.firstPersonRadioButton);
        secondPersonRadioButton = findViewById(R.id.secondPersonRadioButton);
        thirdPersonRadioButton = findViewById(R.id.thirdPersonRadioButton);
    }

    private RadioButton radioButtonCheck(RadioGroup radioGroup)
    {
        return findViewById(radioGroup.getCheckedRadioButtonId());
    }

    public void addDescription(View view)
    {
        updateDescription(radioButtonCheck(radioGroup),firstAthleteRadioButton,secondPersonRadioButton,thirdPersonRadioButton);
    }


    private void updateDescription(RadioButton selectedRadioButton, RadioButton first,RadioButton second, RadioButton third)
    {
        EditText editText = findViewById(R.id.descriptionEditTextView);
        if(selectedRadioButton == first)
        {
            Athlete athlete = athletes.get(0);
            athlete.setDescription(editText.getText().toString());
            adapter.updateRecycler(0);
        }
        if(selectedRadioButton == second)
        {
            Athlete athlete = athletes.get(1);
            athlete.setDescription(editText.getText().toString());
            adapter.updateRecycler(1);
        }
        if(selectedRadioButton == third)
        {
            Athlete athlete = athletes.get(2);
            athlete.setDescription(editText.getText().toString());
            adapter.updateRecycler(2);
        }
        else
        {
            Toast.makeText(this, getText(R.string.errorRadioButton), Toast.LENGTH_SHORT).show();
        }
    }

    private  void setupRecycler()
    {
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    public  void showInspiration(View view)
    {
        int randomNumber = random.nextInt(3);
        if(randomNumber == 1)
        {
            Toast.makeText(this,getText(R.string.first_athlete_name) + " " + getText(R.string.first_athlete_inspiration), Toast.LENGTH_SHORT).show();
        }
        else if(randomNumber == 2)
        {
            Toast.makeText(this, getText(R.string.second_athlete_name) + " " + getText(R.string.second_athlete_inspiration), Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, getText(R.string.third_athlete_name) + " " + getText(R.string.third_athlete_inspiration), Toast.LENGTH_SHORT).show();
        }

    }

    public void setupRecyclerData()
    {
        athletes.add(new Athlete(getString(R.string.first_athlete_name),getString(R.string.first_athlete_born_died),getString(R.string.first_athlete_description),R.drawable.ibra));
        athletes.add(new Athlete(getString(R.string.second_athlete_name),getString(R.string.second_athlete_born_died),getString(R.string.second_athlete_description),R.drawable.vardy));
        athletes.add(new Athlete(getString(R.string.third_athlete_name),getString(R.string.third_athlete_born_died),getString(R.string.third_athlete_description),R.drawable.prso));
        adapter.addData(athletes);
    }

    @Override
    public void onNameClick(int position)
    {
       adapter.removeImage(position);
    }
}