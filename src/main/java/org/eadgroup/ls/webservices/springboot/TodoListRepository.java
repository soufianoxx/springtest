package org.eadgroup.ls.webservices.springboot;

import org.springframework.data.repository.CrudRepository;

public interface TodoListRepository extends CrudRepository<TodoList, Long> {

	
}
