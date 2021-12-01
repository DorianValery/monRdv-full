import { TestBed } from '@angular/core/testing';

import { PraticienLieuHttpService } from './praticien-lieu-http.service';

describe('PraticienLieuHttpService', () => {
  let service: PraticienLieuHttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PraticienLieuHttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
