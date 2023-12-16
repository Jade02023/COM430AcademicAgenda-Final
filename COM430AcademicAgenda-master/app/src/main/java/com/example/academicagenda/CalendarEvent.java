package com.example.academicagenda;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.Date;

public class CalendarEvent extends AcademicCalendar.CalendarEvent {
    public CalendarEvent(String title, Date date) {
        super();
    }

    public Date getDate() {


        return null;
    }
    private static class CalendarEventAdapter extends ArrayAdapter<CalendarEvent> implements com.example.academicagenda.CalendarEventAdapter {

        public CalendarEventAdapter(Context context, List<CalendarEvent> events) {
            super(context, 0, (java.util.List<CalendarEvent>) events);
        }

        /**
         * @param position
         * @param parent
         * @param convertView
         * @return
         */
        @Override
        public View getView(int position, ViewGroup parent, View convertView) {
            return null;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            // Your existing code for getView method
            // ...
            return convertView;
        }
    }
}