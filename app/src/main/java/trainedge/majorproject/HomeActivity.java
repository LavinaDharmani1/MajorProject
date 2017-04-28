package trainedge.majorproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.home, menu);
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
            Intent gotoSetting = new Intent(HomeActivity.this, Settings.class);
            startActivity(gotoSetting);
            return true;
        }
        if(id == R.id.action_feedback){
            Intent gotoFeedback=new Intent(HomeActivity.this,Feedback.class);
            startActivity(gotoFeedback);
            return true;
        }

        if(id == R.id.action_about){
            Intent gotoAbout=new Intent(HomeActivity.this,About.class);
            startActivity(gotoAbout);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_google) {
            Intent gotoGoogleActivity = new Intent(HomeActivity.this, GoogleActivity.class);
            startActivity(gotoGoogleActivity);

        } else if (id == R.id.nav_linkedin) {
            Intent gotoLinkedInActivity = new Intent(HomeActivity.this, LinkedInActivity.class);
            startActivity(gotoLinkedInActivity);

        } else if (id == R.id.nav_twitter) {
            Intent gotoTwitterActivity = new Intent(HomeActivity.this, TwitterActivity.class);
            startActivity(gotoTwitterActivity);

        } else if (id == R.id.nav_facebook) {
            Intent gotoFacebookAcitivity = new Intent(HomeActivity.this, FacebookAcitivity.class);
            startActivity(gotoFacebookAcitivity);

        } else if (id == R.id.nav_instagram) {
            Intent gotoInstagramActivity = new Intent(HomeActivity.this, InstagramActivity.class);
            startActivity(gotoInstagramActivity);

        } else if (id == R.id.nav_myspace) {
            Intent gotoMySpaceActivity = new Intent(HomeActivity.this, MySpaceActivity.class);
            startActivity(gotoMySpaceActivity);

        } else if (id == R.id.nav_pinterest) {
            Intent gotoPinterestActivity = new Intent(HomeActivity.this, PinterestActivity.class);
            startActivity(gotoPinterestActivity);

        } else if (id == R.id.nav_tumblr) {
            Intent gotoTumblrActivity = new Intent(HomeActivity.this, TumblrActivity.class);
            startActivity(gotoTumblrActivity);

        } else if (id == R.id.nav_flickr) {
            Intent gotoFlickrActivity = new Intent(HomeActivity.this, FlickrActivity.class);
            startActivity(gotoFlickrActivity);

        } else if (id == R.id.nav_quora) {
            Intent gotoQuoraActivity = new Intent(HomeActivity.this, QuoraActivity.class);
            startActivity(gotoQuoraActivity);

        } else if (id == R.id.nav_tagged) {
            Intent gotoTaggedActivity = new Intent(HomeActivity.this, TaggedActivity.class);
            startActivity(gotoTaggedActivity);

        } else if (id == R.id.btnLogout) {
            Intent gotoLogoutActivity = new Intent(HomeActivity.this, LogoutActivity.class);
            startActivity(gotoLogoutActivity);

        } else if (id == R.id.nav_share) {
            Intent gotoFirebaseDatabaseDemo = new Intent(HomeActivity.this, FirebaseDatabaseDemo.class);
            startActivity(gotoFirebaseDatabaseDemo);

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
