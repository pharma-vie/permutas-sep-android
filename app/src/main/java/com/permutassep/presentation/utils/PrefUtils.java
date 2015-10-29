package com.permutassep.presentation.utils;

/**
 * By Jorge E. Hernandez (@lalongooo) 2015
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.permutassep.config.Config;
import com.permutassep.presentation.model.UserModel;

public class PrefUtils {

    /*
    * Preference to store the current user logged
    * in the application (the email and phone of this user can be modified on each post).
    * */
    public static final String PREF_USER_KEY = "permutas_sep_user";

    /*
    * Boolean indicating whether we performed the (first-time) drawer opened.
    * */
    public static final String PREF_DRAWER_OPENED = "pref_drawer_first_time_opened";

    /*
    * Boolean indicating that the news feed should be reloaded
    * */
    public static final String PREF_RELOAD_NEWS_FEED = "pref_reload_news_feed";

    /**
     * Boolean indicating whether ToS has been accepted
     */
    public static final String PREF_TOS_ACCEPTED = "pref_tos_accepted";

    public static boolean firstTimeDrawerOpened(final Context context) {
        SharedPreferences sp = context.getSharedPreferences(Config.APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(PREF_DRAWER_OPENED, false);
    }

    public static void markFirstTimeDrawerOpened(final Context context) {
        SharedPreferences sp = context.getSharedPreferences(Config.APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(PREF_DRAWER_OPENED, true).commit();
    }

    public static boolean shouldReloadNewsFeed(final Context context) {
        SharedPreferences sp = context.getSharedPreferences(Config.APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(PREF_RELOAD_NEWS_FEED, false);
    }

    public static void markNewsFeedToReload(final Context context, boolean reloaded) {
        SharedPreferences sp = context.getSharedPreferences(Config.APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(PREF_RELOAD_NEWS_FEED, reloaded).commit();
    }

    public static void clearApplicationPreferences(Context context) {
        SharedPreferences sp = context.getSharedPreferences(Config.APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
        sp.edit().clear().commit();
    }

    public static void markTosAccepted(final Context context) {
        SharedPreferences sp = context.getSharedPreferences(Config.APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(PREF_TOS_ACCEPTED, true).apply();
    }

    public static boolean isTosAccepted(final Context context) {
        SharedPreferences sp = context.getSharedPreferences(Config.APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(PREF_TOS_ACCEPTED, false);
    }

    public static UserModel getUser(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(Config.APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
        String gson = preferences.getString(PREF_USER_KEY, null);
        if (gson == null) {
            return null;
        } else {
            return new Gson().fromJson(gson, UserModel.class);
        }
    }

    public static void putUser(Context context, UserModel userModel) {
        if (userModel == null) {
            throw new IllegalArgumentException("Parameter userModel is null");
        }
        SharedPreferences sp = context.getSharedPreferences(Config.APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(PREF_USER_KEY, new Gson().toJson(userModel)).apply();
    }
}
