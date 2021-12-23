package app.novo.notification.push;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class PushFireBaseMessagingService extends FirebaseMessagingService {

    public void onNewToken(String s){
        super.onNewToken(s);
        Log.i("App_Push", "Novo Token" + s);
    }

    public void onMessageReceived(RemoteMessage remoteMessage){
        super.onMessageReceived(remoteMessage);
    }
}
