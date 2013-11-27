package controllers;

import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;
import models.*;

public class Application extends Controller {

	  static Form<Task> taskForm = Form.form(Task.class);


	/**
	 * Método que responde a rota do diretorio raiz
	 * @return Result
	 */
      public static Result index() {
    	  return redirect(routes.Application.tasks());
      }

      /**
       * Método que responde a rota do diretorio /tasks via GET
       * @return Result
       */
 
      public static Result tasks() { 	
    	  return ok(views.html.index.render(Task.all(), taskForm));
      }
      /**
       * Método que responde a rota do diretorio /tasks via POST
       * E cria uma nova task no BD
       * @return Result
       */
	  public static Result newTask() {
		  Form<Task> filledForm = taskForm.bindFromRequest();
		  if(filledForm.hasErrors()) {
		    return badRequest(
		      views.html.index.render(Task.all(), filledForm)
		    );
		  } else {
		    Task.create(filledForm.get());
		    return redirect(routes.Application.tasks());  
		  }
	  }
	  
	  /**
	   * Método que responde a rota do diretorio /tasks via POST
	   * para apagar um task no bd
	   * @param id
	   * 	O id da task
	   * @return Result
	   */
	  public static Result deleteTask(Long id) {
		  Task.delete(id);
		  return redirect(routes.Application.tasks());	
	  }
	  /**
	   * Método que responde a rota do diretorio /tasks via POST
	   * para mmarcar um task no bd como feito
	   * @param id
	   * 	O id da task
	   * @return Result
	   */
	  
	  public static Result markTaskAsDone(Long id) {
		  Task.markAsDone(id);
		  return redirect(routes.Application.tasks());	
	  }
}
