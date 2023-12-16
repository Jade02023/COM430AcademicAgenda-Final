package com.example.academicagenda;

import androidx.annotation.NonNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
//Adding events to the calendar
public class AcademicCalendar {
    private final List<CalendarEvent> events;

    public AcademicCalendar() {
        events = new ArrayList<>();
    }

    public List<CalendarEvent> getEvents() {
        return events;
    }

    public void addEvent(CalendarEvent event) {
        events.add(event);
    }


    public static class CalendarEvent {
        private String title;
        private Date startDate;
        private Date endDate;

        public CalendarEvent(String title, Date startDate, Date endDate) {
            this.title = title;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public CalendarEvent() {

        }

        public String getTitle() {
            return title;
        }

        public Date getStartDate() {
            return startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        // Additional methods for brevity
        public void setTitle(String title) {
            this.title = title;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }
//Naming calendar events
        @NonNull
        @Override
        public String toString() {
            return "CalendarEvent{" +
                    "title='" + title + '\'' +
                    ", startDate=" + startDate +
                    ", endDate=" + endDate +
                    '}';
        }
    }
}
