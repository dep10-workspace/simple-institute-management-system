import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ManageStudentComponent } from './view/manage-student/manage-student.component';
import { ManageCoursesComponent } from './view/manage-courses/manage-courses.component';

@NgModule({
  declarations: [
    AppComponent,
    ManageStudentComponent,
    ManageCoursesComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
