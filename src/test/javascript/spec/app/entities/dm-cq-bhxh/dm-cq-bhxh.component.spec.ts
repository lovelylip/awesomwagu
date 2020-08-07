import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, convertToParamMap } from '@angular/router';

import { AwesomeaguTestModule } from '../../../test.module';
import { DmCqBhxhComponent } from 'app/entities/dm-cq-bhxh/dm-cq-bhxh.component';
import { DmCqBhxhService } from 'app/entities/dm-cq-bhxh/dm-cq-bhxh.service';
import { DmCqBhxh } from 'app/shared/model/dm-cq-bhxh.model';

describe('Component Tests', () => {
  describe('DmCqBhxh Management Component', () => {
    let comp: DmCqBhxhComponent;
    let fixture: ComponentFixture<DmCqBhxhComponent>;
    let service: DmCqBhxhService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [AwesomeaguTestModule],
        declarations: [DmCqBhxhComponent],
        providers: [
          {
            provide: ActivatedRoute,
            useValue: {
              data: of({
                defaultSort: 'id,asc',
              }),
              queryParamMap: of(
                convertToParamMap({
                  page: '1',
                  size: '1',
                  sort: 'id,desc',
                })
              ),
            },
          },
        ],
      })
        .overrideTemplate(DmCqBhxhComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(DmCqBhxhComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(DmCqBhxhService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new DmCqBhxh(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.dmCqBhxhs && comp.dmCqBhxhs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new DmCqBhxh(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.dmCqBhxhs && comp.dmCqBhxhs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should calculate the sort attribute for an id', () => {
      // WHEN
      comp.ngOnInit();
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['id,desc']);
    });

    it('should calculate the sort attribute for a non-id attribute', () => {
      // INIT
      comp.ngOnInit();

      // GIVEN
      comp.predicate = 'name';

      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['name,desc', 'id']);
    });
  });
});
