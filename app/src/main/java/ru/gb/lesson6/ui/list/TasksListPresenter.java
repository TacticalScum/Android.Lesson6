package ru.gb.lesson6.ui.list;

import java.util.List;

import ru.gb.lesson6.domain.Tasks;
import ru.gb.lesson6.domain.TasksRepository;

public class TasksListPresenter {

    private ToDoTasksView view;

    private TasksRepository repository;

    public TasksListPresenter(ToDoTasksView view, TasksRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void refresh() {
        List<Tasks> resultName = repository.getAllNames();

        view.showTasks(resultName);
    }
}
