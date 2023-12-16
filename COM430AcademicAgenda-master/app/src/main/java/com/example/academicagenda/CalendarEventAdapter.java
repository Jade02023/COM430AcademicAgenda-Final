package com.example.academicagenda;

import android.view.View;
import android.view.ViewGroup;

public interface CalendarEventAdapter {
    View getView(int position, ViewGroup parent, View convertView);

    default View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
