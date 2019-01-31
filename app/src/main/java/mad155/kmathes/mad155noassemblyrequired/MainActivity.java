package mad155.kmathes.mad155noassemblyrequired;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String selectedProject = "";
    int selectedPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // Associate spinner in XML with Java variable
        final Spinner spinner = (Spinner) findViewById(R.id.spnrSelectBuild);

        // Initializing a String Array
        String[] projects = new String[]{
                "Select an item...",
                "Bicycle",
                "IKEA Dresser",
                "Wood Patio"
        };

        // Set up ArrayList
        final List<String> projectList = new ArrayList<>(Arrays.asList(projects));

        // Initializing an ArrayAdapter to point to simple textView layout that
        //  I manually created (spinner_item.xml) which will be used to populate
        //  the listView control
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,projectList){

            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            // Used to make this a dropdown list instead of more traditional spinner
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        // For the spinner array adapter, set the dropdown view to simple textView object (spinner_item.xml)
        //  that was manually created in the layout folder
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        // Set the spinner control on the screen to the array adapter
        spinner.setAdapter(spinnerArrayAdapter);

        // When an item is selected...
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                selectedProject = selectedItemText;
                selectedPosition = position;

                System.out.println("selected position: " + selectedPosition);
                System.out.println("selected project: " + selectedProject);
                Log.d("MyAppKAM","Help me...I am here");

                if(position > 0){
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // When a the button is clicked...
        Button button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedProject.isEmpty() || selectedProject == null ) {
                    System.out.println("SELECTED PROJECT IS EMPTY OR NULL");
                } else {

                    // Put out a toast message if user didn't select anything and hit button
                    if (selectedPosition == 0) {
                        Toast.makeText
                                (getApplicationContext(), "Please select an item" , Toast.LENGTH_SHORT)
                                .show();
                    }

                    if (selectedPosition != 0) {
                        System.out.println("Selected position : " + selectedPosition);
                        System.out.println("Selected project : " + selectedProject);

                        Intent intent1 = new Intent(MainActivity.this, DisplayTools.class);
                        intent1.putExtra("projectSelected", selectedProject);
                        startActivity(intent1);
                    }
                }

            }
        });
    }
}
