package ru.gb.lesson6.ui.list;

import java.util.List;

import ru.gb.lesson6.domain.Tasks;

public interface ToDoTasksView {

    void showTasks(List<Tasks> tasks);
}