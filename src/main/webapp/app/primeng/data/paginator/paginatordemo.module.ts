import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AwesomeaguSharedModule } from '../../../shared/shared.module';
import {PaginatorModule} from 'primeng/paginator';
import {ToastModule} from 'primeng/toast';
import {WizardModule} from 'primeng-extensions/components/wizard/wizard.js';
import {MessageService} from 'primeng/api';

import {
    PaginatorDemoComponent,
    paginatorDemoRoute
} from './';

const PRIMENG_STATES = [
    paginatorDemoRoute
];

@NgModule({
    imports: [
        AwesomeaguSharedModule,
        PaginatorModule,
        WizardModule,
        ToastModule,
        RouterModule.forRoot(PRIMENG_STATES, { useHash: true })
    ],
    declarations: [
        PaginatorDemoComponent
    ],
    providers: [MessageService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AwesomeaguPaginatorDemoModule {}
