import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeetrainingComponent } from './employeetraining.component';

describe('EmployeetrainingComponent', () => {
  let component: EmployeetrainingComponent;
  let fixture: ComponentFixture<EmployeetrainingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeetrainingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeetrainingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
