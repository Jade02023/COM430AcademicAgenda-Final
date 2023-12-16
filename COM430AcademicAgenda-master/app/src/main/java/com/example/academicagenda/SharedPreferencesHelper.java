package com.example.academicagenda;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class SharedPreferencesHelper {
    private static final String PREFS_NAME = "MyAppPrefs";

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static void saveRegistrationInfo(Context context, String username, String password, String securityQuestion, String securityAnswer) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.putString("securityQuestion", securityQuestion);
        editor.putString("securityAnswer", securityAnswer);
        editor.apply();
    }

    public static String getUsername(Context context) {
        return getSharedPreferences(context).getString("username", "");
    }

    public static String getPassword(Context context) {
        return getSharedPreferences(context).getString("password", "");
    }

    public static String getSecurityQuestion(Context context) {
        return getSharedPreferences(context).getString("securityQuestion", "");
    }

    public static String getSecurityAnswer(Context context) {
        return getSharedPreferences(context).getString("securityAnswer", "");
    }

    private static final String PREF_NAME = "GradePrefs";
    private static final String GRADES_KEY = "grades";

    public static void saveGrades(Context context, List<Grade> grades) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String gradesJson = gson.toJson(grades);

        editor.putString(GRADES_KEY, gradesJson);
        editor.apply();
    }

    public static List<Grade> getGrades(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String gradesJson = sharedPreferences.getString(GRADES_KEY, "");

        Type type = new TypeToken<List<Grade>>(){}.getType();
        return gson.fromJson(gradesJson, type);
    }
}
