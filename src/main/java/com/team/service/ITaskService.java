package com.team.service;

import com.team.bean.ResponseOV;
import com.team.bean.Task;

import java.util.List;

public interface ITaskService {
    Task getTaskById(String id);

    ResponseOV<Task> getTasks(int page, int rows);

    List<Task> getTasks();

    boolean updateTask(Task task);

    boolean deleteByIds(String[] ids);

    boolean insertTask(Task task);

    ResponseOV<Task> searchTaskByCondition(int flag, String searchValue, int page, int rows);
}
