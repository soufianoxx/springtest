package org.eadgroup.ls.webservices.springboot;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;


public class Runn implements CommandLineRunner{
	

	@Autowired
	private TodoListRepository todoListRepository;
	public void run(String[] args) throws Exception {

		TodoList privateList = new TodoList("Private List");
		privateList.setItems(new HashSet<TodoListItem>());
		privateList.getItems().add(new TodoListItem("Walk the dog!", false, privateList));
		privateList.getItems().add(new TodoListItem("Buy coffee, lots of coffee!", true,privateList));
		todoListRepository.save(privateList);
		this.todoListRepository.save(new TodoList("Work List -.-"));
		for (TodoList list : this.todoListRepository.findAll()) {
		System.out.println(list.getId() + ": " + list.getName());
		for (TodoListItem item : list.getItems()) {
		System.out.println(String.format("\t%s\t%s",item.isDone() ? "x" : "-",item.getDescription()));
		}
		}
		}
	

}


