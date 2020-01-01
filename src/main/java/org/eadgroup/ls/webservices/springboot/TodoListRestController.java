package org.eadgroup.ls.webservices.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.eadgroup.ls.webservices.springboot.*;
import java.util.*;

import javax.validation.Valid;
import org.eadgroup.ls.webservices.springboot.*;
@RestController
@RequestMapping("/lists")
public class TodoListRestController {
	private final Map<TodoList, List<TodoListItem>> lists = new HashMap<TodoList, List<TodoListItem>>();
	private final Optional<TodoList>  lists1 = Optional.empty();
@GetMapping
public Set<TodoList> getAllLists() {
return this.lists.keySet();
}
@PostMapping
public ResponseEntity createList(@Valid @RequestBody TodoList list) {
	

if (!this.lists.containsKey(list)) {
list.setId(this.newUniqueId());
this.lists.put(list, new ArrayList<TodoListItem>());
return new ResponseEntity(list, HttpStatus.CREATED);
} else {
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@GetMapping("/{listId}")
public ResponseEntity getList(@PathVariable int listId) {
Optional<TodoList> list = this.getListFromId(listId);
if (list.isPresent()) {
return new ResponseEntity(list.get(), HttpStatus.OK);
}
return new ResponseEntity(HttpStatus.NOT_FOUND);
}
@GetMapping("/{listId}/")
public ResponseEntity getListItems(@PathVariable int listId) {
Optional<TodoList> list = this.getListFromId(listId);
if (list.isPresent()) {
return new ResponseEntity(this.lists.get(list.get()), HttpStatus.OK);
}
return new ResponseEntity(HttpStatus.NOT_FOUND);
}
@PostMapping("/{listId}/items")
public ResponseEntity addItem(
@PathVariable int listId,
@RequestBody TodoListItem item
) {
Optional<TodoList> list = this.getListFromId(listId);
if (list.isPresent()) {
item.setId(this.newUniqueId());
item.setDone(false);
this.lists.get(list.get()).add(item);
return new ResponseEntity(item, HttpStatus.CREATED);
} else {
return new ResponseEntity(HttpStatus.NOT_FOUND);
}
}
private long newUniqueId() {
	return 0;
//
}
private Optional<TodoList> getListFromId(int listId) {
	
	//lists.get(0).get
	
	return this.lists1;
//
}
}