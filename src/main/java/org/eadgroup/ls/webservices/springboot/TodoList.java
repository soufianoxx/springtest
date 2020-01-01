package org.eadgroup.ls.webservices.springboot;

import java.util.Set;

import javax.persistence.*;

@Entity
public class TodoList {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@Column(nullable = false)
private String name;
@OneToMany(
mappedBy = "list",
cascade = CascadeType.ALL,
orphanRemoval = true,
fetch = FetchType.EAGER
)
private Set<TodoListItem> items;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Set<TodoListItem> getItems() {
	return items;
}
public void setItems(Set<TodoListItem> items) {
	this.items = items;
}
public TodoList(Long id, String name, Set<TodoListItem> items) {
	super();
	this.id = id;
	this.name = name;
	this.items = items;
}



public TodoList() {
	super();
}
public TodoList(String name) {
	super();
	this.name = name;
}


public TodoList( Set<TodoListItem> items) {
	super();
	this.items = items;
}


}