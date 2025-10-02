public class TaskDAO{
     
        public List<Task> getAllTasks();
        public Task getTaskById(int id);
        public void addTask(Task task);
        public void updateTask(Task task);
        public bolean deleteTask(Long id);
        public void saveAll();


}> 
