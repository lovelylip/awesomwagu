import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { AwesomeaguTestModule } from '../../../test.module';
import { DmCqBhxhDetailComponent } from 'app/entities/dm-cq-bhxh/dm-cq-bhxh-detail.component';
import { DmCqBhxh } from 'app/shared/model/dm-cq-bhxh.model';

describe('Component Tests', () => {
  describe('DmCqBhxh Management Detail Component', () => {
    let comp: DmCqBhxhDetailComponent;
    let fixture: ComponentFixture<DmCqBhxhDetailComponent>;
    const route = ({ data: of({ dmCqBhxh: new DmCqBhxh(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [AwesomeaguTestModule],
        declarations: [DmCqBhxhDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(DmCqBhxhDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(DmCqBhxhDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load dmCqBhxh on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.dmCqBhxh).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
