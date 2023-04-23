import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnergyFlowComponent } from './energy-flow.component';

describe('EnergyFlowComponent', () => {
  let component: EnergyFlowComponent;
  let fixture: ComponentFixture<EnergyFlowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnergyFlowComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnergyFlowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
