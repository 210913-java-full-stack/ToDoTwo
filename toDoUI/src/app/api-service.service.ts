import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError  } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { ToDoItem } from './DTOs/ToDoDTO';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {


  baseUrl = 'http://localhost:8080/ToDoTwo';

  

  constructor(private client: HttpClient) {

   }

   httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  //Get all toDoItems
  getToDoItems(): Observable<ToDoItem[]> {
    return this.client.get<ToDoItem[]>(this.baseUrl + "/ToDoItems")
      .pipe(
        retry(3),
        catchError(this.errorHandler)
      )
  }

  //post toDoItem
  //...


  errorHandler(error: any) {
    let message = '';
    if(error.error instanceof ErrorEvent) {
      // Get client-side error
      message = error.error.message;
    } else {
      // Get server-side error
      message = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(message);
    return throwError(message);
  }
}
