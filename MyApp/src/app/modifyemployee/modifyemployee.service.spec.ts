import { TestBed } from '@angular/core/testing';

import { ModifyemployeeService } from './modifyemployee.service';

describe('ModifyemployeeService', () => {
  let service: ModifyemployeeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModifyemployeeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
