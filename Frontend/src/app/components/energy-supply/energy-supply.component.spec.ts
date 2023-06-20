import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnergySupplyComponent } from './energy-supply.component';

describe('EnergySupplyComponent', () => {
  let component: EnergySupplyComponent;
  let fixture: ComponentFixture<EnergySupplyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnergySupplyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnergySupplyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
