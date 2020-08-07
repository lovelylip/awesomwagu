import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IDmCqBhxh } from 'app/shared/model/dm-cq-bhxh.model';

@Component({
  selector: 'jhi-dm-cq-bhxh-detail',
  templateUrl: './dm-cq-bhxh-detail.component.html',
})
export class DmCqBhxhDetailComponent implements OnInit {
  dmCqBhxh: IDmCqBhxh | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ dmCqBhxh }) => (this.dmCqBhxh = dmCqBhxh));
  }

  previousState(): void {
    window.history.back();
  }
}
