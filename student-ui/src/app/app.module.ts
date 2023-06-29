import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ManageStudentComponent } from './view/manage-student/manage-student.component';
import { ManageCoursesComponent } from './view/manage-courses/manage-courses.component';
import {RouterModule, Routes} from "@angular/router";
import { HomeComponent } from './view/home/home.component';

const router:Routes=[
  {
    path:'students',
    component:ManageStudentComponent
  },
  {
    path:'courses',
    component:ManageCoursesComponent
  }
]
@NgModule({
  declarations: [
    AppComponent,
    ManageStudentComponent,
    ManageCoursesComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(router)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
