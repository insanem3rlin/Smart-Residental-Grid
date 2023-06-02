import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatapointTableComponent } from './datapoint-table.component';

describe('DatapointTableComponent', () => {
  let component: DatapointTableComponent;
  let fixture: ComponentFixture<DatapointTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DatapointTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DatapointTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
