package edu.sharif.yousefi.first_app.setting;

import android.preference.PreferenceActivity;
import android.os.Bundle;

import edu.sharif.yousefi.first_app.R;
public class SettingActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference_setting);

    }
}
