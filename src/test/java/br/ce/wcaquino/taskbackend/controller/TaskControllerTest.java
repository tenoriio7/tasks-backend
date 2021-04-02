package br.ce.wcaquino.taskbackend.controller;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.configuration.MockAnnotationProcessor;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;

public class TaskControllerTest {
	
	@Mock
	private TaskRepo taskRepo;
	
	@InjectMocks
	TaskController controller;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void  naoDeveSalvarTarefaSemDescricao() {
		Task todo = new Task(); 
		todo.setDueDate(LocalDate.now());
		
		try {
			controller.save(todo);
		}catch (Exception e) {
			assertEquals("Fill the task description", e.getMessage());

		}
		
	}
	
	@Test
	public void  naoDeveSalvarTarefaSemData() {
		Task todo = new Task(); 
		todo.setTask("Desc");
		try {
			controller.save(todo);
		}catch (Exception e) {
			assertEquals("Fill the due datee", e.getMessage());

		}
		
	}
	
	@Test
	public void  naoDeveSalvarTarefaComDataPassada() throws ValidationException {
		Task todo = new Task(); 
		todo.setTask("Desc");
		todo.setDueDate(LocalDate.now());
		controller.save(todo);
		

	}
	
	public void  DeveSalvarTarefaComSucesso() {
		
	}
}
