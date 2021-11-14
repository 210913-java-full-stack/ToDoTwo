import { Component, OnInit } from '@angular/core';
import { observable } from 'rxjs';
import { ApiServiceService } from '../api-service.service';

@Component({
  selector: 'app-to-do-item-form',
  templateUrl: './to-do-item-form.component.html',
  styleUrls: ['./to-do-item-form.component.css']
})
export class ToDoItemFormComponent implements OnInit {

  message: string = '';
  service: ApiServiceService;

  constructor(_service: ApiServiceService) { 
    this.service = _service;
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.service.createNewToDoItem(this.message).subscribe(data => {
      console.log(data);
    })
    
  }

}
