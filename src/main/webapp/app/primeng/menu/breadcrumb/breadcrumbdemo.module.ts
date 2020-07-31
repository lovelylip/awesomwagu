import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CommonModule} from '@angular/common';
import { AwesomeaguSharedModule } from '../../../shared/shared.module';
import {ToastModule} from 'primeng/toast';
import {BreadcrumbModule} from 'primeng/breadcrumb';
import {WizardModule} from 'primeng-extensions/components/wizard/wizard.js';
import {MessageService} from 'primeng/api';

import {
    BreadcrumbDemoComponent,
    breadcrumbDemoRoute
} from './';

const PRIMENG_STATES = [
    breadcrumbDemoRoute
];

@NgModule({
    imports: [
        AwesomeaguSharedModule,
        CommonModule,
        BrowserAnimationsModule,
        ToastModule,
        BreadcrumbModule,
        WizardModule,
        RouterModule.forRoot(PRIMENG_STATES, { useHash: true })
    ],
    declarations: [
        BreadcrumbDemoComponent
    ],
    providers: [MessageService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AwesomeaguBreadcrumbDemoModule {}
