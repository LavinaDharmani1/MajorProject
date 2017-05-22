package trainedge.majorproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.Toast;


public class Settings extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, TextWatcher, AdapterView.OnItemSelectedListener {


    private EditText etDefEmail;
    private Switch switchWifiOp;
    private Switch switchCloudSyncOp;
    private Button btnClearSettings;
    private SharedPreferences pref;
    private ArrayAdapter<CharSequence> adapter;
    private ArrayAdapter<CharSequence> adapter1;
    private Spinner spinner;
    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//display back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //our code starts here
        //object creation

        etDefEmail = (EditText) findViewById(R.id.etDefEmail);
        switchWifiOp = (Switch) findViewById(R.id.switchWifiOp);
        switchCloudSyncOp = (Switch) findViewById(R.id.switchCloudSyncOp);
        btnClearSettings = (Button) findViewById(R.id.btnClearSettings);

        //SharedPref obj
        pref = getSharedPreferences("setting_pref", MODE_PRIVATE);

    btnClearSettings.setOnClickListener(this);
        switchWifiOp.setOnCheckedChangeListener(this);
        switchCloudSyncOp.setOnCheckedChangeListener(this);
        etDefEmail.addTextChangedListener(this);

        spinner = (Spinner) findViewById(R.id.theme);
// Create an ArrayAdapter using the string array and a default spinner layout
        adapter = ArrayAdapter.createFromResource(this,
                R.array.theme, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



        spinner1 = (Spinner) findViewById(R.id.quality);
// Create an ArrayAdapter using the string array and a default spinner layout
        adapter1 = ArrayAdapter.createFromResource(this,
                R.array.quality, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);


        //read pref to update ui too
        updateUI();
    }

    @Override
    public void onClick(View v) {
//clear settings
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
        //pref.edit().clear().apply();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        SharedPreferences.Editor editor = pref.edit();
        switch (buttonView.getId()) {
            case R.id.switchWifiOp:
                //code
                editor.putBoolean("wifi_option", isChecked);
                break;
            case R.id.switchCloudSyncOp:
                //code
                editor.putBoolean("cloud_option", isChecked);
                break;
        }
        //save setting
        editor.apply();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        //keep it empty
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //keep it empty
    }

    @Override
    public void afterTextChanged(Editable s) {
        //saving email address
        SharedPreferences.Editor editor = pref.edit();
        String email = s.toString();
        if (email.isEmpty() && email.length() < 10 && !email.contains("@")) {
            etDefEmail.setError("Please give default email address");
            return;
        }
        editor.putString("def_email", email);
        editor.apply();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
    }
    private void updateUI() {
        boolean wifi_state = pref.getBoolean("wifi_option", false);
        boolean cloud_state = pref.getBoolean("cloud_option", false);
        String email = pref.getString("def_email", "");
        switchWifiOp.setChecked(wifi_state);
        switchCloudSyncOp.setChecked(cloud_state);
        etDefEmail.setText(email);
        spinner.setSelection(pref.getInt("themepos", 0));
        spinner1.setSelection(pref.getInt("qualitypos", 0));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        SharedPreferences.Editor edit = pref.edit();
        switch (parent.getId()) {
            case R.id.theme:
                edit.putInt("themepos", position);
                edit.putString("theme", String.valueOf(adapter.getItem(position)));
                break;
            case R.id.quality:
                edit.putInt("qualitypos", position);
                edit.putString("theme", String.valueOf(adapter.getItem(position)));
                break;


        }
        edit.apply();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //FirebaseAuth.getInstance().signOut();
    //intent to login activity
    //finish();

}

