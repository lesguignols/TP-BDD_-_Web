import { StudentListComponent } from './student-list/student-list.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentDetailComponent } from './student-detail/student-detail.component';
import { DevelopperListComponent } from './developper-list/developper-list.component';
import { DevelopperDetailComponent } from './developper-detail/developper-detail.component';

const routes: Routes = [
  {path: 'students', component: StudentListComponent},
  {path: 'students/:id', component: StudentDetailComponent},
  {path: 'developpers', component: DevelopperListComponent},
  {path: 'developpers/:id', component: DevelopperDetailComponent},
  {path: '', redirectTo: 'students', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
