package pt.ezn.apps.servicereports;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ClientFragment.OnFragmentInteractionListener,
        ActivityFragment.OnFragmentInteractionListener, ExpenseFragment.OnFragmentInteractionListener{

    NavigationView navigationView = null;
    Toolbar toolbar = null;
    public static final String PREF_FILE_NAME = "servicepref";


    ReportsDatabaseAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //colocar o fragmento inicial/actividades
        loadFragmentActivities();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    protected void onRestart() {
        setActionBarTitle("Service  Reports");
        super.onRestart();
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            loadFragmentSettings();
            return true;
        }
        if (id == R.id.action_cancel_add_activity){
            //loadFragmentActivities();
            onBackPressed();
            return true;
        }
        if (id == R.id.action_cancel_add_expense){
            //loadFragmentExpenses();
            onBackPressed();
            return true;
        }
        if (id == R.id.action_cancel_add_client){
            //loadFragmentClients();
            onBackPressed();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_activities) {
            loadFragmentActivities();

        } else if (id == R.id.nav_clients) {
            loadFragmentClients();

        } else if (id == R.id.nav_expenses) {
            loadFragmentExpenses();

        } else if (id == R.id.nav_report_expenses) {
            loadFragmentClient();

        } else if (id == R.id.nav_report_activities) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void loadFragmentClient() {
        ClientFragment fragment = new ClientFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment, fragment.getTag());
        fragmentTransaction.addToBackStack(null);
        ;
        fragmentTransaction.commit();
    }

    public void loadFragmentExpenses() {
        //colocar o fragmento despesas
        ExpensesFragment fragment = new ExpensesFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment, fragment.getTag());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void loadFragmentClients() {
        //colocar o fragmento clientes
        ClientsFragment fragment = new ClientsFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment, fragment.getTag());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void loadFragmentActivities() {
        //colocar o fragmento actividades
        ActivitiesFragment fragment = new ActivitiesFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment, fragment.getTag());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void loadFragmentActivity() {
        //colocar o fragmento actividades
        ActivityFragment fragment = new ActivityFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment, fragment.getTag());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void loadFragmentExpense() {
        //colocar o fragmento actividades
        ExpenseFragment fragment = new ExpenseFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment, fragment.getTag());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void loadFragmentSettings() {
        //colocar o fragmento actividades
        SettingsFragment fragment = new SettingsFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment, fragment.getTag());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }



    //para os fragmentos poderem mudar o titulo da toolbar
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    //metodo para guardar preferencias
    public static void saveToPreferences (Context context,String preferenceName, String preferenceValue ){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();

    }

    public static String readFromPreferences (Context context,String preferenceName, String defaulltValue ){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName, defaulltValue);
    }

}
