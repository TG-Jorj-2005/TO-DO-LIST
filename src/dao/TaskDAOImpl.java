public class TaskDAOImpl implements TaskDAO {
    string filepath;
    gson gso;
    List<Task> tasks;

    public TaskDAOImpl(string filepath) {
        this.filepath = filepath;
        this.gso = new gson();
        this.tasks = loadTasksFromFile();
    }
  
    public Task getTasksById(int id) {
          for(Task t:tasks){
            if(t.getId() ==id){
                return t;
            }
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
        saveTasksToFile();
    }
    public void updateTask(Task task) {
      for(int i=0;i<tasks.size();i++){
        if(tasks.get(i).getId() == task.getId()){
            tasks.set(i, task);
            break;
        }

      }
        saveTasksToFile();
    }
    public boolean deleteTask(Long id) {
        for(task p:tasks){
            if(p.getId() ==id){
                tasks.remove(p);
                saveTasksToFile();
                return true;
            }else{
                return false;
            }
        }

    }
    public List<Task> getAllTasks() {
        return tasks;
    }
    
    public void saveAll() {
        saveTasksToFile();
    }
}
