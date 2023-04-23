import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnergyPriceComponent } from './energy-price.component';

describe('EnergyPriceComponent', () => {
  let component: EnergyPriceComponent;
  let fixture: ComponentFixture<EnergyPriceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnergyPriceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnergyPriceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
