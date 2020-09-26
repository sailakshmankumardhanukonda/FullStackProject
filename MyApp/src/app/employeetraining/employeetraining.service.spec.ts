import { TestBed } from '@angular/core/testing';

import { EmployeetrainingService } from './employeetraining.service';

describe('EmployeetrainingService', () => {
  let service: EmployeetrainingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmployeetrainingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
