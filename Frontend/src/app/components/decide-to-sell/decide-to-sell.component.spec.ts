import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DecideToSellComponent } from './decide-to-sell.component';

describe('DecideToSellComponent', () => {
  let component: DecideToSellComponent;
  let fixture: ComponentFixture<DecideToSellComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DecideToSellComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DecideToSellComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
