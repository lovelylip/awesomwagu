import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'dm-cq-bhxh',
        loadChildren: () => import('./dm-cq-bhxh/dm-cq-bhxh.module').then(m => m.AwesomeaguDmCqBhxhModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class AwesomeaguEntityModule {}
