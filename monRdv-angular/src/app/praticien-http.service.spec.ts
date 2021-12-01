import { TestBed } from '@angular/core/testing';

import { PraticienHttpService } from './praticien-http.service';

describe('PraticienHttpService', () => {
  let service: PraticienHttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PraticienHttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
