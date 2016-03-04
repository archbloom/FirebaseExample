package io.github.archbloom.weather;

import com.firebase.client.Firebase;

/**
 * Created by archbloom on 29/2/16.
 */
public class WeatherCondition extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
