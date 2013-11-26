package models;

import java.util.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Task extends Model{
  @Id  
  public Long id;
  @Required
  public String label;
  
  public boolean isDone;
  @Required
  public int priority; 
  @Required
  public String project;
  
  public static Finder<Long,Task> find = new Finder<Long, Task>(
		    Long.class, Task.class
		  );
  
  public static List<Task> allDone() {
	  return find.orderBy("priority").where("isDone = TRUE").findList();
    //return find.all();
  }
  public static List<Task> allUndone() {
	  return find.orderBy("priority").where("isDone = FALSE").findList();
    //return find.all();
  }
  public static List<Task> all() {
    return find.all();
  }
  
  public static void create(Task task) {
	  task.save();
  }
  
  public static void delete(Long id) {
	  find.ref(id).delete();
  }
  
  public static void update(Task task) {
      task.update();
}
  public static void markAsDone(Long id) {
	  Task task = find.byId(id);
	  task.isDone = true;
	  Task.update(task);
  }


  
}

