package com.volodiachornenkyy.circleci_example;

import android.content.Context;

import java.util.Locale;

public class GreetingCreator {

    public String get(Context context, String name) {
        if (context == null || name == null) {
            return null;
        }
        return String.format(Locale.getDefault(), context.getString(R.string.greating), name);
    }
}
