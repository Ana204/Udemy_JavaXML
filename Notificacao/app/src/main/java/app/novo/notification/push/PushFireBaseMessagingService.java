package app.novo.notification.push;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;

public class PushFireBaseMessagingService extends FirebaseMessagingService {

    public void onNewToken(String s){
        super.onNewToken(s);
        Log.e("NEW_TOKEN", s);
    }
}
