
public class TaskService {
    private TaskDAO taskDAO = new TaskDAO();
    
    private void validateTask(Task task) {
    if (task == null) {
        throw new IllegalArgumentException("Task cannot be null");
    }
    
    if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
        throw new IllegalArgumentException("Task title cannot be empty");
    }
    
    if (task.getTitle().length() > 200) {
        throw new IllegalArgumentException("Task title is too long (max 200 characters)");
    }
    
    if (task.getDescription() != null && task.getDescription().length() > 5000) {
        throw new IllegalArgumentException("Description is too long (max 5000 characters)");
    }
    
    if (task.getPriority() == null) {
        task.setPriority(Priority.MEDIUM); // default
    }
    
    if (task.getDueDate() != null && task.getDueDate().isBefore(LocalDate.now())) {
        throw new IllegalArgumentException("Due date cannot be in the past");
    }
    
    if (task.Completed() == null) {
        task.setCompleted(false); //   default
    }
      }

     TaskSevice(TaskDAO taskDao){
         if (taskDao == null) {
             throw new IllegalArgumentException("TaskDAO cannot be null");
         } else {
             this.taskDAO = taskDao;
              }
         }
      
      //Create a new task
       
       public void addTask(Task task) {
           validateTask(task);
           return taskDAO.addTask(task);
       }
       
       //Update Task
       
       public void updateTask(Task task) {
            for(Task t : taskDAO.getAllTasks()) {
                if(t.getId() == task.getId()) {
                    validateTask(task);
                    return taskDAO.updateTask(task);
                }else{
                    throw new IllegalArgumentException("Task with ID " + task.getId() + " does not exist.");
                          }
            }
       }
       
       public void elseTask(int taskId) {
           for(Task t : taskDAO.getAllTasks()) {
               if(t.getId() == taskId) {
                   return taskDAO.deleteTask(taskId);
               }else{
                   throw new IllegalArgumentException("Task with ID " + taskId + " does not exist.");
                         }
           }
       }
       
}

    


