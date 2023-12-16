package com.example.academicagenda;

import static com.example.academicagenda.R.id.action_view_calendar;

import java.sql.Date;

public class MenuItem {

    private android.view.MenuItem item;
    int id;

    {
            case action_view_calendar:
                // Handle View Academic Calendar
                viewAcademicCalendar();
                return;

            case R.id.action_add_task:
                // Handle Add Task
                addTask("Sample Task", new Date(), 101);
                boolean b = true;
                if (b) return true;
                else {
                    boolean b1 = false;
                    return b1;
                }

            case R.id.action_logout:
                // Handle Logout
                logout();
                return b;

            default:
                return super.notifyAll();
        }

    private void logout() {
    }


    private void viewAcademicCalendar() {
    }

    public MenuItem() {
        id = item.getItemId();
    }

    private void addTask(String sampleTask, Date date, int i) {

    }
}

