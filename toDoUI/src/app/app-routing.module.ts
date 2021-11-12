import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ToDoItemFormComponent } from './to-do-item-form/to-do-item-form.component';
import { ToDoItemListComponent } from './to-do-item-list/to-do-item-list.component';

const routes: Routes = [
  {path: "toDoItemForm", component: ToDoItemFormComponent},
  {path: "toDoItemList", component: ToDoItemListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
