package fr.turfu.urbapp2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import fr.turfu.urbapp2.db.LocalDataSource;

//TODO Gérer le cycle d'activité de façon à ce qu'une seule activité Main puisse exister

public class MainActivity extends AppCompatActivity {

    /**
     * Bouton pour créer un nouveau projet
     */
    private Button b1;

    /**
     * Attribut representing the local database, to try to get data from it
     */
    public static LocalDataSource datasource;
    ListView mListView ;
    /**
     * Projects list
     */
    String[] list_projs = new String[]{
            "Projet 1", "Projet 2", "Projet 3"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Handling toolbar
        Toolbar mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mainToolbar.setTitle("");
        mainToolbar.setSubtitle("");


        // Button new project
        b1 = (Button) findViewById(R.id.buttonNewProject);
        b1.setTextColor(Color.parseColor("#ffffff"));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewProjectActivity.class);
                startActivity(intent);
            }
        });


        /* // trying to create and then get projects from DB... not working, nullpointerexception
        datasource = new LocalDataSource(this);
       // datasource.createProject(21, "TEST");*/

       //Displaying the list
        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, list_projs);
        mListView.setAdapter(adapter);

        // Map
        //TODO : Carte avec géolocalisation
    }


    /**
     * Method to inflate the xml menu file (Ajout des différents onglets dans la toolbar)
     * @param menu the menu
     * @return true if everything went good
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);

        //On sérialise le fichier menu.xml pour l'afficher dans la barre de menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        //Display Username
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String u = preferences.getString("user_preference","");
        MenuItem i = menu.findItem(R.id.connectedAs);
        i.setTitle(u);

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Method to handle the clicks on the items of the toolbar
     *
     * @param item the item
     * @return true if everything went good
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent ;

        switch (item.getItemId()) {
            case R.id.home:
                return true;

           /* case R.id.virtual_reality:
                intent = new Intent(this, AugmentedRealityActivity.class);
                startActivity(intent);
                return true;*/

            case R.id.settings:
                intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
