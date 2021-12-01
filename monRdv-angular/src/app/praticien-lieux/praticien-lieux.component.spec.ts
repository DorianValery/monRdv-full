import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PraticienLieuxComponent } from './praticien-lieux.component';

describe('PraticienLieuxComponent', () => {
  let component: PraticienLieuxComponent;
  let fixture: ComponentFixture<PraticienLieuxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PraticienLieuxComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PraticienLieuxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
