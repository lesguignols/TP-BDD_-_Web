import { DeveloppersService } from '../services/developper.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Developper } from '../models/developper';
import { Router } from '@angular/router';
import { Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-create-developper',
  templateUrl: './create-developper.component.html',
  styleUrls: ['./create-developper.component.css']
})
export class CreateDevelopperComponent implements OnInit {

  createForm: FormGroup;

  @Output() createEvent = new EventEmitter<Developper>();

  constructor(public formBuilder: FormBuilder,
              private developpersService: DeveloppersService) { }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group({
      name: '',
      firstName: ''
    });
  }

  onSubmit(developperData): void {
    this.createForm.reset();
    const developper: Developper = {
      name: developperData.name,
      firstName: developperData.firstName
    };
    this.developpersService.createDevelopper(developper).subscribe((developperResponse) => {
      this.createEvent.emit(developperResponse);
    });
  }

}
