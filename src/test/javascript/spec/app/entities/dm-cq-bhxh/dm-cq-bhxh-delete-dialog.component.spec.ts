import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { AwesomeaguTestModule } from '../../../test.module';
import { MockEventManager } from '../../../helpers/mock-event-manager.service';
import { MockActiveModal } from '../../../helpers/mock-active-modal.service';
import { DmCqBhxhDeleteDialogComponent } from 'app/entities/dm-cq-bhxh/dm-cq-bhxh-delete-dialog.component';
import { DmCqBhxhService } from 'app/entities/dm-cq-bhxh/dm-cq-bhxh.service';

describe('Component Tests', () => {
  describe('DmCqBhxh Management Delete Component', () => {
    let comp: DmCqBhxhDeleteDialogComponent;
    let fixture: ComponentFixture<DmCqBhxhDeleteDialogComponent>;
    let service: DmCqBhxhService;
    let mockEventManager: MockEventManager;
    let mockActiveModal: MockActiveModal;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [AwesomeaguTestModule],
        declarations: [DmCqBhxhDeleteDialogComponent],
      })
        .overrideTemplate(DmCqBhxhDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(DmCqBhxhDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(DmCqBhxhService);
      mockEventManager = TestBed.get(JhiEventManager);
      mockActiveModal = TestBed.get(NgbActiveModal);
    });

    describe('confirmDelete', () => {
      it('Should call delete service on confirmDelete', inject(
        [],
        fakeAsync(() => {
          // GIVEN
          spyOn(service, 'delete').and.returnValue(of({}));

          // WHEN
          comp.confirmDelete(123);
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith(123);
          expect(mockActiveModal.closeSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));

      it('Should not call delete service on clear', () => {
        // GIVEN
        spyOn(service, 'delete');

        // WHEN
        comp.cancel();

        // THEN
        expect(service.delete).not.toHaveBeenCalled();
        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
      });
    });
  });
});
