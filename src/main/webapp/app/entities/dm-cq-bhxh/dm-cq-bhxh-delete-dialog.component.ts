import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IDmCqBhxh } from 'app/shared/model/dm-cq-bhxh.model';
import { DmCqBhxhService } from './dm-cq-bhxh.service';

@Component({
  templateUrl: './dm-cq-bhxh-delete-dialog.component.html',
})
export class DmCqBhxhDeleteDialogComponent {
  dmCqBhxh?: IDmCqBhxh;

  constructor(protected dmCqBhxhService: DmCqBhxhService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.dmCqBhxhService.delete(id).subscribe(() => {
      this.eventManager.broadcast('dmCqBhxhListModification');
      this.activeModal.close();
    });
  }
}
