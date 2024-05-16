import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EncuestaDatailsComponent } from './encuesta-datails.component';

describe('EncuestaDatailsComponent', () => {
  let component: EncuestaDatailsComponent;
  let fixture: ComponentFixture<EncuestaDatailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EncuestaDatailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EncuestaDatailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
