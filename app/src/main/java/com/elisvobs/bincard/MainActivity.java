package com.elisvobs.bincard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import static com.elisvobs.bincard.R.array.industry_types;

public class MainActivity extends AppCompatActivity {
    //declare variables
    private EditText companyName;
    private TextView industry;
    Button startButton;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        companyName = (EditText)findViewById(R.id.companyName);
        startButton =(Button)findViewById(R.id.startButton);
        spinner = (Spinner)findViewById(R.id.spinner);

        // add data to the spinner using the array adapter
        ArrayAdapter<CharSequence> adapter;


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // convert editable text to a string
                String name = companyName.getText().toString();
                //Instantiate second activity
                StartInfo();
            }
        });


        //initialize adapter from the data source (each item layout)
        adapter = ArrayAdapter.createFromResource(this, industry_types, android.R.layout.simple_spinner_item);
        //specify layout of each dropdown list for the spinner (dropdown view resource)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //add adapter into the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /* the invoked when the user select an item from the spinner
                create toast to indicate the selected item*/
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void StartInfo() {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }
}
