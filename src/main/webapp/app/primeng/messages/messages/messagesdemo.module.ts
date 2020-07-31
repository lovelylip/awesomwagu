import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AwesomeaguSharedModule } from '../../../shared/shared.module';
import {ButtonModule} from 'primeng/button';
import {MessagesModule} from 'primeng/messages';
import {ToastModule} from 'primeng/toast';
import {WizardModule} from 'primeng-extensions/components/wizard/wizard.js';
import {MessageService} from 'primeng/api';

import {
    MessagesDemoComponent,
    messagesDemoRoute
} from './';

const PRIMENG_STATES = [
    messagesDemoRoute
];

@NgModule({
    imports: [
        AwesomeaguSharedModule,
        ButtonModule,
        MessagesModule,
        ToastModule,
        WizardModule,
        RouterModule.forRoot(PRIMENG_STATES, { useHash: true })
    ],
    declarations: [
        MessagesDemoComponent
    ],
    providers: [MessageService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AwesomeaguMessagesDemoModule {}
