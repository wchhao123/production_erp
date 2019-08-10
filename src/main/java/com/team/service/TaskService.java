package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.javafx.tk.Toolkit;
import com.team.bean.ResponseOV;
import com.team.bean.Task;
import com.team.bean.TaskExample;
import com.team.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskService implements ITaskService{

    @Autowired
    private TaskMapper mapper;

    @Override
    public Task getTaskById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public ResponseOV<Task> getTasks(int page, int rows) {
        return searchTaskByCondition(0, null, page, rows);
    }

    @Override
    public List<Task> getTasks() {
        return mapper.selectByExample(null);
    }

    @Override
    public boolean updateTask(Task task) {
        return mapper.updateByPrimaryKey(task) == 1;
    }

    @Override
    public boolean deleteByIds(String[] ids) {
        TaskExample example = new TaskExample();
        example.createCriteria().andTaskIdIn(new ArrayList<>(Arrays.asList(ids)));
        return mapper.deleteByExample(example) != 0;
    }

    @Override
    public boolean insertTask(Task task) {
        return mapper.insert(task) == 1;
    }

    @Override
    public ResponseOV<Task> searchTaskByCondition(int flag, String searchValue, int page, int rows) {
        TaskExample ex = new TaskExample();
        String val = "%" + searchValue + "%";
        if (flag == 1) {
            ex.createCriteria().andTaskIdLike(val);
        } else if (flag == 2) {
            ex.createCriteria().andWorkIdLike(val);
        } else if (flag == 3){
            ex.createCriteria().andManufactureSnLike(val);
        } else {
            ex = null;
        }
        PageHelper.startPage(page, rows);
        List<Task> tasks = mapper.selectByExample(ex);
        PageInfo<Task> info = new PageInfo<>(tasks);

        ResponseOV<Task> ov = new ResponseOV<>();
        ov.setRows(tasks);
        ov.setTotal((int) info.getTotal());
        return ov;
    }
}
