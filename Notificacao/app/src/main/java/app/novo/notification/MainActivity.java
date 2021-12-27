package app.novo.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;


public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    String tokenAPP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("Push", MODE_PRIVATE);

        String mensagem = "50% de desconto";
        String titulo = "MEGA PROMOÇÃO";

        //notificarUsuario(mensagem, titulo);

        getTokenFCM();
    }

    private void getTokenFCM() {

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnSuccessListener(MainActivity.this,
                        new OnSuccessListener<InstanceIdResult>() {
                            @Override
                            public void onSuccess(InstanceIdResult instanceIdResult) {

                                tokenAPP = instanceIdResult.getToken();

                                salvarTokenFCM();

                            }
                        });
    }

    private void salvarTokenFCM() {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("tokenAPP", tokenAPP);
        Log.i("App_Push",tokenAPP);
        edit.apply();
    }

    private void notificarUsuario(String mensagem, String titulo) {

        NotificationCompat.Builder notificacao = new NotificationCompat.Builder(getBaseContext());

        notificacao.setContentTitle(titulo);
        notificacao.setContentText(mensagem);
        notificacao.setPriority(Notification.PRIORITY_HIGH);

        notificacao.setLargeIcon(BitmapFactory.decodeResource(getBaseContext().getResources(), R.mipmap.notification));

        notificacao.setSmallIcon(R.drawable.comment);

        Intent intent = new Intent(getBaseContext(), NotificacaoActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(getBaseContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        notificacao.setAutoCancel(true);
        notificacao.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getBaseContext().getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(900, notificacao.build());

    }
}