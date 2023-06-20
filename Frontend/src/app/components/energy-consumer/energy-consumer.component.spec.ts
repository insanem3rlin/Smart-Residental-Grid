import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnergyConsumerComponent } from './energy-consumer.component';

describe('EnergyConsumerComponent', () => {
  let component: EnergyConsumerComponent;
  let fixture: ComponentFixture<EnergyConsumerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnergyConsumerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnergyConsumerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
