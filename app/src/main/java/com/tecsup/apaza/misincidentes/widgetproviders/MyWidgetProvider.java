package com.tecsup.apaza.misincidentes.widgetproviders;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;

import com.tecsup.apaza.misincidentes.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Julio Cesar on 29/11/2017.
 */

public class MyWidgetProvider extends AppWidgetProvider {

    private static final String TAG = MyWidgetProvider.class.getSimpleName();

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.d(TAG, "Calling onUpdate...");

       for (int i = 0; i < appWidgetIds.length; i++) {
            Log.d(TAG, "appWidgetIds: " + appWidgetIds[i]);

            String message = "Hola mundo! " + new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());

            // Set layout
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_main);
            remoteViews.setTextViewText(R.id.nombre_text, message);

            // Register an onClickListener on the image button
            Intent intent = new Intent(context, MyWidgetProvider.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.button_widget, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetIds[i], remoteViews);
        }


        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }


    }

    private void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                 int appWidgetId) {

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_main);
        // Construct an Intent object includes web adresss.
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://erenutku.com"));
        // In widget we are not allowing to use intents as usually. We have to use PendingIntent instead of 'startActivity'
           PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        // Here the basic operations the remote view can do.
            views.setOnClickPendingIntent(R.id.nombre_text, pendingIntent);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }


}

