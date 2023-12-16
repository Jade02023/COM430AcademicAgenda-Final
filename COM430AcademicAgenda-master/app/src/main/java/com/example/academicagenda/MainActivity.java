package com.example.academicagenda;

import static com.example.academicagenda.R.id;
import static com.example.academicagenda.R.layout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<CalendarEvent> calendarEvents = new ArrayList<>();
    private final List<Grade> gradesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        // Example usage:
        addCalendarEvent("Exam Date", new Date());
        addCalendarEvent("Assignment Due", new Date(System.currentTimeMillis() + 86400000)); // Tomorrow

        displayAcademicCalendar();
    }

    private void addCalendarEvent(String title, Date date) {
        calendarEvents.add(new CalendarEvent(title, date));
    }

    private void displayAcademicCalendar() {
        ListView listView = findViewById(id.CalendarEvent); // Assuming you have a ListView with id 'listView'
        CalendarEventAdapter adapter = new CalendarEventAdapter(MainActivity.this, calendarEvents);
        listView.setAdapter(adapter);
    }

    private static class CalendarEventAdapter extends ArrayAdapter<CalendarEvent> {

        public CalendarEventAdapter(@NonNull Context context, List<CalendarEvent> events) {
            super(context, 0, events);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(layout.calendarevent, parent, false);
            }

            CalendarEvent event = getItem(position);

            if (event != null) {
                TextView textViewTitle = view.findViewById(id.textViewTitle);
                TextView textViewDate = view.findViewById(id.textViewDate);

                textViewTitle.setText(event.getTitle());

                @SuppressLint("SimpleDateFormat")
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM dd, yyyy");
                textViewDate.setText(dateFormat.format(event.getDate()));
            }

            return view;
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == id.action_view_calendar) {
            viewAcademicCalendar();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void viewAcademicCalendar() {
        Toast.makeText(this, "Viewing Academic Calendar", Toast.LENGTH_SHORT).show();
    }

    private void logout() {
        Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();

        // Navigate to the login screen or another appropriate screen
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private void enterGrades() {
        // Open a new activity or dialog for entering grades
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(layout.dialogue_enter_grades, null);
        builder.setView(view);

        EditText subjectEditText = view.findViewById(id.subjectEditText);
        EditText gradeEditText = view.findViewById(id.gradeEditText);

        builder.setPositiveButton("Enter", (dialog, which) -> {
            String subject = subjectEditText.getText().toString().trim();
            String grade = gradeEditText.getText().toString().trim();

            if (!subject.isEmpty() && !grade.isEmpty()) {
                Grade newGrade = new Grade(subject, grade);
                gradesList.add(newGrade);

                // Save entered grades to SharedPreferences
                SharedPreferencesHelper.saveGrades(MainActivity.this, gradesList);

                Toast.makeText(this, "Grade entered successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please enter both subject and grade", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", null);

        builder.show();
    }

    private void viewGrades() {
        // Retrieve entered grades from SharedPreferences
        List<Grade> savedGrades = SharedPreferencesHelper.getGrades(MainActivity.this);

        // Display the entered grades
        StringBuilder gradesText = new StringBuilder("Entered Grades:\n");
        for (Grade grade : savedGrades) {
            gradesText.append(grade.getSubject()).append(": ").append(grade.getGrade()).append("\n");
        }

        // Display in a dialog for simplicity
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("View Grades");
        builder.setMessage(gradesText.toString());
        builder.setPositiveButton("OK", null);
        builder.show();
    }

}


