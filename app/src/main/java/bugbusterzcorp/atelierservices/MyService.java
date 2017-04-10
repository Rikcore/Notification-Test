package bugbusterzcorp.atelierservices;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.RequiresApi;

public class MyService extends Service {

    public static final String INTENT_DISPLAY_NOTIF = "DemoService.DisplayNotif";
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (intent != null){
            if (intent.getAction().equals(INTENT_DISPLAY_NOTIF)){
                displayNotification();
            }

        }
        return Service.START_STICKY;
    }

    private void displayNotification() {
        NotificationManager notifManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification noti = new Notification.Builder(this)
                .setContentTitle("Voici ma premiere notif")
                .setContentText("J'aime les poules")
                .setSmallIcon(R.mipmap.chicken)
                .setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0))
                .build();

        notifManager.notify(0, noti);


    }
}
