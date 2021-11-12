import { Component, OnInit } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { ApiServiceService } from '../api-service.service';
import { ToDoItem } from '../DTOs/ToDoDTO';

@Component({
  selector: 'app-to-do-item-list',
  templateUrl: './to-do-item-list.component.html',
  styleUrls: ['./to-do-item-list.component.css']
})
export class ToDoItemListComponent implements OnInit {
  public apiService : ApiServiceService;
  public toDoItems: ToDoItem[] = [];


  constructor(private _apiService : ApiServiceService) { 
    this.apiService = _apiService;
  }

  ngOnInit(): void {
    this.apiService.getToDoItems().subscribe(data => {
      console.log(data);
      for (const item of data) {
        //let newItem: ToDoItem = JSON.parse(item);
        let {id, message, complete} = item;
        this.toDoItems.push({id, message, complete})
        console.log(item);
        //this.toDoItems.push(newItem);
      }
    })
  }

}
