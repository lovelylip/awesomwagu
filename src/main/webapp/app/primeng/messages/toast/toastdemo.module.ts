import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AwesomeaguSharedModule } from '../../../shared/shared.module';
import {ButtonModule} from 'primeng/button';
import {ToastModule} from 'primeng/toast';
import {WizardModule} from 'primeng-extensions/components/wizard/wizard.js';
import {MessageService} from 'primeng/api';

import {
    ToastDemoComponent,
    toastDemoRoute
} from './';

const PRIMENG_STATES = [
    toastDemoRoute
];

@NgModule({
    imports: [
        AwesomeaguSharedModule,
        ButtonModule,
        ToastModule,
        WizardModule,
        RouterModule.forRoot(PRIMENG_STATES, { useHash: true })
    ],
    declarations: [
        ToastDemoComponent
    ],
    providers: [MessageService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AwesomeaguToastDemoModule {}
