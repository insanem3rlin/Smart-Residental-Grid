import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PowerdisplayComponent } from './powerdisplay.component';

describe('PowerdisplayComponent', () => {
  let component: PowerdisplayComponent;
  let fixture: ComponentFixture<PowerdisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PowerdisplayComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PowerdisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
