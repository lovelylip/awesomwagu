import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IDmCqBhxh, DmCqBhxh } from 'app/shared/model/dm-cq-bhxh.model';
import { DmCqBhxhService } from './dm-cq-bhxh.service';
import { DmCqBhxhComponent } from './dm-cq-bhxh.component';
import { DmCqBhxhDetailComponent } from './dm-cq-bhxh-detail.component';
import { DmCqBhxhUpdateComponent } from './dm-cq-bhxh-update.component';

@Injectable({ providedIn: 'root' })
export class DmCqBhxhResolve implements Resolve<IDmCqBhxh> {
  constructor(private service: DmCqBhxhService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IDmCqBhxh> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((dmCqBhxh: HttpResponse<DmCqBhxh>) => {
          if (dmCqBhxh.body) {
            return of(dmCqBhxh.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new DmCqBhxh());
  }
}

export const dmCqBhxhRoute: Routes = [
  {
    path: '',
    component: DmCqBhxhComponent,
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'awesomeaguApp.dmCqBhxh.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: DmCqBhxhDetailComponent,
    resolve: {
      dmCqBhxh: DmCqBhxhResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'awesomeaguApp.dmCqBhxh.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: DmCqBhxhUpdateComponent,
    resolve: {
      dmCqBhxh: DmCqBhxhResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'awesomeaguApp.dmCqBhxh.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: DmCqBhxhUpdateComponent,
    resolve: {
      dmCqBhxh: DmCqBhxhResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'awesomeaguApp.dmCqBhxh.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
