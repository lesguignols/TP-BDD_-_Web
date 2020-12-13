import { DeveloppersService } from '../services/developper.service';
import { Component, OnInit } from '@angular/core';
import { Developper } from '../models/developper';
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-developper-list',
  templateUrl: './developper-list.component.html',
  styleUrls: ['./developper-list.component.css']
})
export class DevelopperListComponent implements OnInit {


  public developpers: Developper[];

  public showSpinner: boolean;

  constructor(private developpersService: DeveloppersService) { }

  ngOnInit(): void {
    this.showSpinner = true;
    this.developpersService.getDeveloppersList()
    .pipe(delay(2000))
    .subscribe((developpersResponse => {
      this.developpers = developpersResponse;
      this.showSpinner = false;
    }));
  }

  deleteDevelopper(id: number): void {
    this.developpersService.deleteDevelopper(id).subscribe((deleteResponse) => {
      this.developpers = this.developpers.filter(s => s.id !== id);
    }, (error) => {
      // TODO
    });
  }
  /* Callback of child component */
  addDevelopper(newDevelopper: Developper): void {
    this.developpers.push(newDevelopper);
  }

}
