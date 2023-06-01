import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SetMinBatteryComponent } from './set-min-battery.component';

describe('SetMinBatteryComponent', () => {
  let component: SetMinBatteryComponent;
  let fixture: ComponentFixture<SetMinBatteryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SetMinBatteryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SetMinBatteryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
