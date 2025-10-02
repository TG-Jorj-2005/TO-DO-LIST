public class Subtask extends Task {
    private int id;
    private String name;
    private bool completed;
    private int parentTaskId;

    
    public Subtask(int id, String name, String completed, int parentTaskId) {
        super(id, name, completed);
        this.parentTaskId = parentTaskId;
    }
    public void setName(String name) {
        this.name = name;
    }
    
  public void setId(int id) {
        this.id = id;
    }
  
  public int getid() {
        return id;}
   
  public String getName() {
        return name;}
  
  public String getCompleted() {
        return completed;}
  
  public void setCompleted(String completed) {
        this.completed = completed;

}
