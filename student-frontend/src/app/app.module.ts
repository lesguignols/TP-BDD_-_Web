import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component';
import { HttpClientModule } from '@angular/common/http';
import { CreateStudentComponent } from './create-student/create-student.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { StudentDetailComponent } from './student-detail/student-detail.component';
import { DevelopperListComponent } from './developper-list/developper-list.component';
import { CreateDevelopperComponent } from './create-developper/create-developper.component';
import { DevelopperDetailComponent } from './developper-detail/developper-detail.component';


@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    CreateStudentComponent,
    StudentDetailComponent,
    DevelopperListComponent,
    CreateDevelopperComponent,
    DevelopperDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
