package com.example.shakti.studentplanner;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;

public class CalendarScreen extends AppCompatActivity {

    CalendarView calendarView;
    TextView myDate;
    int year, month, dayOfMonth;

    private static final String TAG = "CalendarScreen";

    private Button btnStartPlan;

    @Nullable

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calendar, container, false);
        btnStartPlan = (Button) view.findViewById(R.id.btnStartPlan);
        Log.d(TAG, "onCreateView: Loading...");

        btnStartPlan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to Fragment 1", Toast.LENGTH_SHORT).show();

                ((homeScreen) getActivity()).setViewPager(2);
            }
        });
        return view;
    }





    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        myDate = (TextView) findViewById(R.id.myDate);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            public void onSelectedDayChange(@NonNull CalendarView view, int _year, int _month, int _dayOfMonth) {
                String Date = (month + 1) + " / " + dayOfMonth + " / " + year;
                myDate.setText(Date);
                getDate(_year, _month, _dayOfMonth);
            }
        });


    }

    public void getDate (int _year, int _month, int _dayOfMonth){
        year = _year;
        month = _month;
        dayOfMonth = _dayOfMonth;
    }

    public void onDateSelectedButtonClick(View v){
        // Get the date from our datepicker
        int _day = dayOfMonth;
        int _month = month;
        int _year = year;
        // Create a new calendar set to the date chosen
        // we set the time to midnight (i.e. the first minute of that day)
        Calendar c = Calendar.getInstance();
        c.set(_year, _month, _day);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        // Ask our service to set an alarm for that date, this activity talks to the client that talks to the service
        //scheduleClient.setAlarmForNotification(c);
        // Notify the user what they just did
        Toast.makeText(this, "Notification set for: "+ _day +"/"+ (_month+1) +"/"+ _year, Toast.LENGTH_SHORT).show();
    }


    public Context getActivity() {
        return null;
    }
}