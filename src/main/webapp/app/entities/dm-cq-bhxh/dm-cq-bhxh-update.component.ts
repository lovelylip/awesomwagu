import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IDmCqBhxh, DmCqBhxh } from 'app/shared/model/dm-cq-bhxh.model';
import { DmCqBhxhService } from './dm-cq-bhxh.service';

@Component({
  selector: 'jhi-dm-cq-bhxh-update',
  templateUrl: './dm-cq-bhxh-update.component.html',
})
export class DmCqBhxhUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    maCqbh: [null, [Validators.required]],
    ten: [],
    diaChi: [],
    maXa: [],
    maHuyen: [],
    maTinh: [],
    emailAcc: [],
    phoneNumeric: [],
    status: [],
    activeDate: [],
    inactiveDate: [],
    maCqbhCha: [],
    nguoiKy: [],
    chucDanh: [],
    tenNoiKy: [],
    isActive: [],
    path: [],
    ngayKhoa: [],
    soQdTl: [],
    ngayQdTl: [],
    cqKyQd: [],
  });

  constructor(protected dmCqBhxhService: DmCqBhxhService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ dmCqBhxh }) => {
      this.updateForm(dmCqBhxh);
    });
  }

  updateForm(dmCqBhxh: IDmCqBhxh): void {
    this.editForm.patchValue({
      id: dmCqBhxh.id,
      maCqbh: dmCqBhxh.maCqbh,
      ten: dmCqBhxh.ten,
      diaChi: dmCqBhxh.diaChi,
      maXa: dmCqBhxh.maXa,
      maHuyen: dmCqBhxh.maHuyen,
      maTinh: dmCqBhxh.maTinh,
      emailAcc: dmCqBhxh.emailAcc,
      phoneNumeric: dmCqBhxh.phoneNumeric,
      status: dmCqBhxh.status,
      activeDate: dmCqBhxh.activeDate,
      inactiveDate: dmCqBhxh.inactiveDate,
      maCqbhCha: dmCqBhxh.maCqbhCha,
      nguoiKy: dmCqBhxh.nguoiKy,
      chucDanh: dmCqBhxh.chucDanh,
      tenNoiKy: dmCqBhxh.tenNoiKy,
      isActive: dmCqBhxh.isActive,
      path: dmCqBhxh.path,
      ngayKhoa: dmCqBhxh.ngayKhoa,
      soQdTl: dmCqBhxh.soQdTl,
      ngayQdTl: dmCqBhxh.ngayQdTl,
      cqKyQd: dmCqBhxh.cqKyQd,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const dmCqBhxh = this.createFromForm();
    if (dmCqBhxh.id !== undefined) {
      this.subscribeToSaveResponse(this.dmCqBhxhService.update(dmCqBhxh));
    } else {
      this.subscribeToSaveResponse(this.dmCqBhxhService.create(dmCqBhxh));
    }
  }

  private createFromForm(): IDmCqBhxh {
    return {
      ...new DmCqBhxh(),
      id: this.editForm.get(['id'])!.value,
      maCqbh: this.editForm.get(['maCqbh'])!.value,
      ten: this.editForm.get(['ten'])!.value,
      diaChi: this.editForm.get(['diaChi'])!.value,
      maXa: this.editForm.get(['maXa'])!.value,
      maHuyen: this.editForm.get(['maHuyen'])!.value,
      maTinh: this.editForm.get(['maTinh'])!.value,
      emailAcc: this.editForm.get(['emailAcc'])!.value,
      phoneNumeric: this.editForm.get(['phoneNumeric'])!.value,
      status: this.editForm.get(['status'])!.value,
      activeDate: this.editForm.get(['activeDate'])!.value,
      inactiveDate: this.editForm.get(['inactiveDate'])!.value,
      maCqbhCha: this.editForm.get(['maCqbhCha'])!.value,
      nguoiKy: this.editForm.get(['nguoiKy'])!.value,
      chucDanh: this.editForm.get(['chucDanh'])!.value,
      tenNoiKy: this.editForm.get(['tenNoiKy'])!.value,
      isActive: this.editForm.get(['isActive'])!.value,
      path: this.editForm.get(['path'])!.value,
      ngayKhoa: this.editForm.get(['ngayKhoa'])!.value,
      soQdTl: this.editForm.get(['soQdTl'])!.value,
      ngayQdTl: this.editForm.get(['ngayQdTl'])!.value,
      cqKyQd: this.editForm.get(['cqKyQd'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IDmCqBhxh>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
