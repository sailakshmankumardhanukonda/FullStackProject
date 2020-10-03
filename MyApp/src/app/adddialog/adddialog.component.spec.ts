import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdddialogComponent } from './adddialog.component';

describe('AdddialogComponent', () => {
  let component: AdddialogComponent;
  let fixture: ComponentFixture<AdddialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdddialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdddialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
