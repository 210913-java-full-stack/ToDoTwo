import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ToDoItemListComponent } from './to-do-item-list/to-do-item-list.component';
import { ToDoItemFormComponent } from './to-do-item-form/to-do-item-form.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ToDoItemListComponent,
    ToDoItemFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule//oops, another mistake in the notes...
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
