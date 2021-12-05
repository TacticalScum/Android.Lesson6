package ru.gb.lesson6.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;

import ru.gb.lesson6.R;
import ru.gb.lesson6.domain.Tasks;

public class TasksDetailActivity extends AppCompatActivity {
    public static final String EXTRA_TASK = "EXTRA_TASK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_detail);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
        } else {
            FragmentManager fm = getSupportFragmentManager();

            Tasks tasks = getIntent().getParcelableExtra(EXTRA_TASK);

            fm.beginTransaction()
                    .replace(R.id.containerDetails, TasksDetailFragment.newInstance(tasks))
                    .commit();
        }
    }
}