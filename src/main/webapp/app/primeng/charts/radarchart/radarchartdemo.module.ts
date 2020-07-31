import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AwesomeaguSharedModule } from '../../../shared/shared.module';
import { ChartModule } from 'primeng/chart';
import {MessageService} from 'primeng/api';

import {
    RadarchartDemoComponent,
    radarchartDemoRoute
} from '../../charts/radarchart';

const PRIMENG_STATES = [
    radarchartDemoRoute
];

@NgModule({
    imports: [
        AwesomeaguSharedModule,
        ChartModule,
        RouterModule.forRoot(PRIMENG_STATES, { useHash: true })
    ],
    declarations: [
        RadarchartDemoComponent
    ],
    providers: [MessageService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AwesomeaguRadarchartDemoModule {}
