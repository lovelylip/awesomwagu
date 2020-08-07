import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { AwesomeaguTestModule } from '../../../test.module';
import { DmCqBhxhUpdateComponent } from 'app/entities/dm-cq-bhxh/dm-cq-bhxh-update.component';
import { DmCqBhxhService } from 'app/entities/dm-cq-bhxh/dm-cq-bhxh.service';
import { DmCqBhxh } from 'app/shared/model/dm-cq-bhxh.model';

describe('Component Tests', () => {
  describe('DmCqBhxh Management Update Component', () => {
    let comp: DmCqBhxhUpdateComponent;
    let fixture: ComponentFixture<DmCqBhxhUpdateComponent>;
    let service: DmCqBhxhService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [AwesomeaguTestModule],
        declarations: [DmCqBhxhUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(DmCqBhxhUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(DmCqBhxhUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(DmCqBhxhService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new DmCqBhxh(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new DmCqBhxh();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
