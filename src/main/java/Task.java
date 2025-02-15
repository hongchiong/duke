public class Task {
  protected String description;
  protected boolean isDone;

  public Task(String description) {
      this.description = description;
      this.isDone = false;
  }

  public String getStatusIcon() {
      return (isDone ? "X" : " "); 
  }
  
  public String getDescription() {
    return (description); 
  }

  public void mark() {
    this.isDone =  true;
  }

  public void unmark() {
    this.isDone =  false;
  }

  public String toString() {
    return "[" + getStatusIcon() + "] " + description;
  }
}
