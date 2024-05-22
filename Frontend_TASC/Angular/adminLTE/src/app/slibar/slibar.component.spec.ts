/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { SlibarComponent } from './slibar.component';

describe('SlibarComponent', () => {
  let component: SlibarComponent;
  let fixture: ComponentFixture<SlibarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlibarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlibarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
