import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DevelopperDetailComponent } from './developper-detail.component';

describe('DevelopperDetailComponent', () => {
  let component: DevelopperDetailComponent;
  let fixture: ComponentFixture<DevelopperDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DevelopperDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DevelopperDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
