import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { DmCqBhxhService } from 'app/entities/dm-cq-bhxh/dm-cq-bhxh.service';
import { IDmCqBhxh, DmCqBhxh } from 'app/shared/model/dm-cq-bhxh.model';

describe('Service Tests', () => {
  describe('DmCqBhxh Service', () => {
    let injector: TestBed;
    let service: DmCqBhxhService;
    let httpMock: HttpTestingController;
    let elemDefault: IDmCqBhxh;
    let expectedResult: IDmCqBhxh | IDmCqBhxh[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(DmCqBhxhService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new DmCqBhxh(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a DmCqBhxh', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new DmCqBhxh()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a DmCqBhxh', () => {
        const returnedFromService = Object.assign(
          {
            maCqbh: 'BBBBBB',
            ten: 'BBBBBB',
            diaChi: 'BBBBBB',
            maXa: 'BBBBBB',
            maHuyen: 'BBBBBB',
            maTinh: 'BBBBBB',
            emailAcc: 'BBBBBB',
            phoneNumeric: 'BBBBBB',
            status: 'BBBBBB',
            activeDate: 1,
            inactiveDate: 1,
            maCqbhCha: 'BBBBBB',
            nguoiKy: 'BBBBBB',
            chucDanh: 'BBBBBB',
            tenNoiKy: 'BBBBBB',
            isActive: 1,
            path: 'BBBBBB',
            ngayKhoa: 1,
            soQdTl: 'BBBBBB',
            ngayQdTl: 1,
            cqKyQd: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of DmCqBhxh', () => {
        const returnedFromService = Object.assign(
          {
            maCqbh: 'BBBBBB',
            ten: 'BBBBBB',
            diaChi: 'BBBBBB',
            maXa: 'BBBBBB',
            maHuyen: 'BBBBBB',
            maTinh: 'BBBBBB',
            emailAcc: 'BBBBBB',
            phoneNumeric: 'BBBBBB',
            status: 'BBBBBB',
            activeDate: 1,
            inactiveDate: 1,
            maCqbhCha: 'BBBBBB',
            nguoiKy: 'BBBBBB',
            chucDanh: 'BBBBBB',
            tenNoiKy: 'BBBBBB',
            isActive: 1,
            path: 'BBBBBB',
            ngayKhoa: 1,
            soQdTl: 'BBBBBB',
            ngayQdTl: 1,
            cqKyQd: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a DmCqBhxh', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
