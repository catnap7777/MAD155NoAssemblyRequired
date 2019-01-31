package mad155.kmathes.mad155noassemblyrequired;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayTools extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_tools);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        String project = "";
        lv = (ListView) findViewById(R.id.listViewTools1);
        ImageView myImage = (ImageView) findViewById(R.id.imageViewProject1);
        TextView toolsTitle = (TextView) findViewById(R.id.textViewToolsTitle1);

        // Get which project to build from intent data passed...
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            project = extras.getString("projectSelected");

        }

        System.out.println("project that was selected: " + project);

        // Check to make sure project isn't null for some reason
        if(project != null && !project.isEmpty()) {

            System.out.println("Project is not empty or null : " + project);
            // For Bicycle...

            if (project.equalsIgnoreCase("bicycle")) {

                // Initializing a string array with the tools needed
                String[] bicycleToolsArray = new String[]{
                        "Wrenches",
                        "Screwdrivers",
                        "Hammer",
                        "Pliers"
                };

                // Convert string array into an array list
                final List<String> bicycleList = new ArrayList<>(Arrays.asList(bicycleToolsArray));

                // Initializing an ArrayAdapter and pointing to simple textView control (list_view_item.xml)
                //  that will be used to populate the listView control on the screen for the tools list
                final ArrayAdapter<String> bicycleArrayAdapter = new ArrayAdapter<String>(
                        this, R.layout.list_view_item, bicycleList) {
                };

                // Set screen title

                //toolsTitle.setText("Tools Required to Build A Bicycle");
                toolsTitle.setText(R.string.txtBicycleTitle);
                // Set screen image
                myImage.setImageResource(R.drawable.bike);
                // Display data from adapter in listView
                lv.setAdapter(bicycleArrayAdapter);
            }

            if (project.equalsIgnoreCase("ikea dresser")) {

                // Initializing a string array with the tools needed
                String[] dresserToolsArray = new String[]{
                        "Level",
                        "Wrenches",
                        "Screwdrivers",
                        "Hammer",
                        "Pliers",
                        "Rubber Mallet"
                };

                // Convert string array into an array list
                final List<String> dresserList = new ArrayList<>(Arrays.asList(dresserToolsArray));

                // Initializing an ArrayAdapter and pointing to simple textView control (list_view_item.xml)
                //  that will be used to populate the listView control on the screen for the tools list
                final ArrayAdapter<String> dresserArrayAdapter = new ArrayAdapter<String>(
                        this, R.layout.list_view_item, dresserList) {
                };


                // Set screen title
                toolsTitle.setText(R.string.txtDresserTitle);
                // Set screen image
                myImage.setImageResource(R.drawable.dresser);
                // Display data from adapter in listView
                lv.setAdapter(dresserArrayAdapter);
            }

            if (project.equalsIgnoreCase("wood patio")) {

                // Initializing a string array with the tools needed
                String[] patioToolsArray = new String[]{
                        "Saw(s)",
                        "Nailgun/Nails",
                        "Wrenches",
                        "Screwdrivers/Screws",
                        "Hammer",
                        "Pliers",
                        "Level",
                        "Post Hole Digger and/or Shovel",
                        "Measuring Tape",
                        "Work Gloves"
                };

                // Convert string array into an array list
                final List<String> patioList = new ArrayList<>(Arrays.asList(patioToolsArray));

                // Initializing an ArrayAdapter and pointing to simple textView control (list_view_item.xml)
                //  that will be used to populate the listView control on the screen for the tools list
                final ArrayAdapter<String> patioArrayAdapter = new ArrayAdapter<String>(
                        this, R.layout.list_view_item, patioList) {
                };

                // Set screen title
                toolsTitle.setText(R.string.txtPatioTitle);
                // Set screen image
                myImage.setImageResource(R.drawable.patio);
                // Display data from adapter in listView
                lv.setAdapter(patioArrayAdapter);

            }
        }
    }
}
