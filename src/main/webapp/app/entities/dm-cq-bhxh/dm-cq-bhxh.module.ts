import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AwesomeaguSharedModule } from 'app/shared/shared.module';
import { DmCqBhxhComponent } from './dm-cq-bhxh.component';
import { DmCqBhxhDetailComponent } from './dm-cq-bhxh-detail.component';
import { DmCqBhxhUpdateComponent } from './dm-cq-bhxh-update.component';
import { DmCqBhxhDeleteDialogComponent } from './dm-cq-bhxh-delete-dialog.component';
import { dmCqBhxhRoute } from './dm-cq-bhxh.route';

@NgModule({
  imports: [AwesomeaguSharedModule, RouterModule.forChild(dmCqBhxhRoute)],
  declarations: [DmCqBhxhComponent, DmCqBhxhDetailComponent, DmCqBhxhUpdateComponent, DmCqBhxhDeleteDialogComponent],
  entryComponents: [DmCqBhxhDeleteDialogComponent],
})
export class AwesomeaguDmCqBhxhModule {}
