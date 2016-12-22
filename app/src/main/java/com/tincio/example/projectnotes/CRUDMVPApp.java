package com.tincio.example.projectnotes;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class CRUDMVPApp extends Application {

        private static Context mContext;

        @Override
        public void onCreate() {
            super.onCreate();
            mContext = this;
/*            RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().name(Realm.DEFAULT_REALM_NAME)
                    .schemaVersion(0)
                    .deleteRealmIfMigrationNeeded()
                    .build();
            Realm.setDefaultConfiguration(realmConfiguration);*/
        }

    public static Context getContext() {
        return mContext;
    }


}
