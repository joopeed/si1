package models;

import java.util.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

/*
 * Classe que representa uma task no sistema
 * 
 */
@SuppressWarnings("serial")
@Entity
public class Task extends Model {
	
	/*
	 * O id da Task
	 */
	@Id
	private Long id;
	/*
	 * O título da task
	 */
	@Required
	private String label;
	/*
	 * A prioridade da task
	 */
	@Required
	private int priority;
	/*
	 *  O projeto ao qual a task está associada
	 */
	@Required
	private String project;
	/*
	 *  A descricao da task
	 */
	@Required
	private String description;
	/*
	 * Define se a task ja foi feita
	 */

	private boolean isDone;

	public static Finder<Long, Task> find = new Finder<Long, Task>(Long.class,
			Task.class);

	/**
	 * Retorna uma lista de tasks que já foram feitas
	 * @return List<Task>
	 */
	public static List<Task> allDone() {
		return find.orderBy("priority").where("isDone = TRUE").findList();
		// return find.all();
	}

	/**
	 * Retorna uma lista de tasks que não foram feitas
	 * @return List<Task>
	 */
	
	public static List<Task> allUndone() {
		return find.orderBy("priority").where("isDone = FALSE").findList();
		// return find.all();
	}

	/**
	 * Retorn uma lista de todas as tasks
	 * @return List<Task>
	 */
	public static List<Task> all() {
		return find.all();
	}
	
	/**
	 * Salva uma task no BD
	 * @param task
	 * 		A Task a ser salva no BD
	 */

	public static void create(Task task) {
		task.save();
	}

	/**
	 *  Apaga uma task no BD
	 * @param id
	 * 		O id da task a ser apagada do BD
	 */
	public static void delete(Long id) {
		find.ref(id).delete();
	}

	/**
	 * Atualiza uma task no BD
	 * @param task
	 * 		A task a ser atualizada
	 */
	public static void update(Task task) {
		task.update();
	}

	/**
	 * Marca como feita uma task
	 * @param id
	 * 		O id da task a ser marcada como feita
	 */
	public static void markAsDone(Long id) {
		Task task = find.byId(id);
		task.setDone(true);
		Task.update(task);
	}
	
	/**
	 * Retorna o titulo da tarefa
	 * @return 
	 */

	public String getLabel() {
		return label;
	}

	/**
	 * Altera o título da tarefa
	 * @param label
	 * 	O titulo da tarefa
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Retorna a prioridade da tarefa
	 * @return 
	 */
	
	public int getPriority() {
		return priority;
	}

	/**
	 * Altera a prioridade da tarefa
	 * @param priority
	 *  Um inteiro que representa a prioridade
	 *  Menores tem mais prioridade 
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	/**
	 * Retorna projeto associado da tarefa
	 * @return 
	 */

	public String getProject() {
		return project;
	}

	/**
	 * Altera o projeto associado da tarefa
	 * @param project
	 *  O nome do novo projeto
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * Retorna a descricao da tarefa
	 * @return 
	 */
	
	public String getDescription() {
		return description;
	}

	/**
	 * Altera da descricao do projeto
	 * @param description
	 * 		A nova descricao
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Retorna do Id da tarefa
	 * @return
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Retorna se a tarefa esta feita
	 * @return
	 */
	public boolean isDone() {
		return isDone;
	}

	/**
	 * Altera o status de afazer da tarefa
	 * @param isDone
	 * 		Um boolean, sendo true para feita
	 */
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

}
