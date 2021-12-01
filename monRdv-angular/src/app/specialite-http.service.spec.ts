import { TestBed } from '@angular/core/testing';

import { SpecialiteHttpService } from './specialite-http.service';

describe('SpecialiteHttpService', () => {
  let service: SpecialiteHttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SpecialiteHttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
