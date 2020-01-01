package org.eadgroup.ls.webservices.springboot;

import javax.persistence.*;

@Entity
public class TodoListItem {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@Column(nullable = false)
private String description;
@Column(nullable = false)
private boolean done;
@ManyToOne
@JoinColumn(name = "list_id")
private TodoList list;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public boolean isDone() {
	return done;
}
public void setDone(boolean done) {
	this.done = done;
}
public TodoList getList() {
	return list;
}
public void setList(TodoList list) {
	this.list = list;
}
public TodoListItem() {
	super();
	// TODO Auto-generated constructor stub
}
public TodoListItem(Long id, String description, boolean done, TodoList list) {
	super();
	this.id = id;
	this.description = description;
	this.done = done;
	this.list = list;
}


public TodoListItem( String description, boolean done, TodoList list) {
	super();
	this.description = description;
	this.done = done;
	this.list = list;
}



}