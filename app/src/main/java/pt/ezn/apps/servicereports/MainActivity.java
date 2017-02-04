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
import android.view.View;


public class MainActivity extends AppCompatActivity
        implements OnFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener {

    public NavigationView navigationView = null;
    public Toolbar toolbar = null;
    public static final String PREF_FILE_NAME = "servicepref";
    public int level = 0;
    public ReportsDatabaseAdapter db;
    public ActionBarDrawerToggle toggle;
    //tipo de fragments E - edit, V - View, N - new.
    public Character fragmentType;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //carregar o fragmento inicial/actividades
        loadFragmentActivities();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        //para gerir a navegação entre fragmentos. O icon "back" só aparece quando está carregado
        //um fragmento de nivel superior a 0 e o backstack é maior que 1.
        getSupportFragmentManager().addOnBackStackChangedListener(new android.support.v4.app.FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (getSupportFragmentManager().getBackStackEntryCount() > 1 && level > 0) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true); // show back button
                    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onBackPressed();
                        }
                    });
                } else {
                    //show hamburger
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                    toggle.syncState();
                    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            drawer.openDrawer(GravityCompat.START);
                        }
                    });
                }
            }
        });

    }



    @Override
    protected void onRestart() {
        setActionBarTitle("Service  Reports");
        super.onRestart();
    }

    @Override
    public void onBackPressed() {
        level--;
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

        //toggle.setDrawerIndicatorEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


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
        // navigation view item clicks.
        int id = item.getItemId();

        if (id == R.id.nav_activities) {
            level = 0;
            loadFragmentActivities();

        } else if (id == R.id.nav_clients) {
            level = 0;
            loadFragmentClients();

        } else if (id == R.id.nav_expenses) {
            level = 0;
            loadFragmentExpenses();

        } else if (id == R.id.nav_report_expenses) {


        } else if (id == R.id.nav_report_activities) {

        } else if (id == R.id.nav_settings){
            level = 0;
            loadFragmentSettings();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





    public void loadFragmentExpenses() {
        //carregar o fragmento despesas
        level = 0;
        ExpensesFragment fragment = new ExpensesFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment, fragment.getTag());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void loadFragmentClients() {
        //carregar o fragmento clientes
        level = 0;
        ClientsFragment fragment = new ClientsFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment, fragment.getTag());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void loadFragmentActivities() {
        //carregar o fragmento actividades
        level = 0;
        ActivitiesFragment fragment = new ActivitiesFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment, fragment.getTag());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void loadFragmentClient() {
        //carregar o fragmento client
        level = 1;
        ClientFragment fragment = new ClientFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment, fragment.getTag());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    public void loadFragmentActivity() {
        //carregar o fragmento actividades
        level = 1;
        ActivityFragment fragment = new ActivityFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment, fragment.getTag());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void loadFragmentExpense() {
        //carregar o fragmento actividades
        level = 1;
        ExpenseFragment fragment = new ExpenseFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment, fragment.getTag());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void loadFragmentSettings() {
        //carregar o fragmento actividades
        level = 0;
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

    //metodo para ler preferencias
    public static String readFromPreferences (Context context,String preferenceName, String defaulltValue ){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName, defaulltValue);
    }

}
