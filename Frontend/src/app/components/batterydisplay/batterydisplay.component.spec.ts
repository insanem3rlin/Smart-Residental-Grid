import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BatterydisplayComponent } from './batterydisplay.component';

describe('BatterydisplayComponent', () => {
  let component: BatterydisplayComponent;
  let fixture: ComponentFixture<BatterydisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BatterydisplayComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BatterydisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
