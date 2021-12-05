package ru.gb.lesson6.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentResultListener;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import ru.gb.lesson6.R;
import ru.gb.lesson6.domain.Tasks;
import ru.gb.lesson6.ui.detail.TasksDetailActivity;
import ru.gb.lesson6.ui.detail.TasksDetailFragment;
import ru.gb.lesson6.ui.list.ToDoTasksFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().setFragmentResultListener(ToDoTasksFragment.RESULT_KEY, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Tasks tasks = result.getParcelable(ToDoTasksFragment.ARG_TASK);

                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.landscape_container_details, TasksDetailFragment.newInstance(tasks))
                            .commit();

                } else {

                    Intent intent = new Intent(MainActivity.this, TasksDetailActivity.class);
                    intent.putExtra(TasksDetailActivity.EXTRA_TASK, tasks);
                    startActivity(intent);
                }
            }
        });
    }
}