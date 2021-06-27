import { TestBed } from '@angular/core/testing';

import { NexusServicesService } from './nexus-services.service';

describe('NexusServicesService', () => {
  let service: NexusServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NexusServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
