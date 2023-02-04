import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Inventaire_eggComponent } from './inventaire_egg.component';

describe('Inventaire_eggComponent', () => {
  let component: Inventaire_eggComponent;
  let fixture: ComponentFixture<Inventaire_eggComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Inventaire_eggComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Inventaire_eggComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
