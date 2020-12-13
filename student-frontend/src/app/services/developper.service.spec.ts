import { TestBed } from '@angular/core/testing';

import { DeveloppersService } from './developper.service';

describe('DeveloppersService', () => {
  let service: DeveloppersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeveloppersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
