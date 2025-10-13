package Dao.impl;

import Dao.TaskDao;
import java.sql.*;
import java.util.*;
import model.Task;

public class TaskDaoimpl implements TaskDao{
    private Connection connection;


    public TaskDaoimpl(Connection conect){
        this.connection  = conect;
    }

    @Override 
    public addTask(Task task){
        String sql = "Insert"
    }

}
