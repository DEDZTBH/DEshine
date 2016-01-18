package com.example.dedztbh.deshine.app;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v4.view.MenuItemCompat;

import com.example.dedztbh.deshine.R;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = "#DEshine";
    private static String forecastStr;

    public DetailActivity(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new DetailFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class DetailFragment extends Fragment {

        public DetailFragment() {
            setHasOptionsMenu(true);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            Intent intent = getActivity().getIntent();
            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
            if(intent!=null && intent.hasExtra(Intent.EXTRA_TEXT)){
                forecastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
                        ((TextView) rootView.findViewById((R.id.detail_text)))
                        .setText(forecastStr);
            }
            return rootView;
        }

        @Override
        public void onCreateOptionsMenu(Menu menu,MenuInflater inflater){
            inflater.inflate(R.menu.forecastfragment, menu);
            MenuItem menuItem = menu.findItem(R.string.action_share);
            ShareActionProvider sap = (ShareActionProvider)MenuItemCompat.getActionProvider(menuItem);

            if (sap != null){
                sap.setShareIntent(createShareForecastIntent());
            }else {
                Log.d("sap","sap is null");
            }
        }


        private Intent createShareForecastIntent(){
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
            shareIntent.setType("text/plan");
            shareIntent.putExtra(Intent.EXTRA_TEXT,forecastStr+FORECAST_SHARE_HASHTAG);
            return shareIntent;
        }
    }
}