import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DecideToBuyComponent } from './decide-to-buy.component';

describe('DecideToBuyComponent', () => {
  let component: DecideToBuyComponent;
  let fixture: ComponentFixture<DecideToBuyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DecideToBuyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DecideToBuyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
