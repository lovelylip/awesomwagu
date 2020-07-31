import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AwesomeaguSharedModule } from '../../../shared/shared.module';
import {FormsModule} from '@angular/forms';
import {SelectButtonModule} from 'primeng/selectbutton';
import {ToastModule} from 'primeng/toast';
import {WizardModule} from 'primeng-extensions/components/wizard/wizard.js';
import {MessageService} from 'primeng/api';

import {
    SelectButtonDemoComponent,
    selectbuttonDemoRoute
} from './';

const PRIMENG_STATES = [
    selectbuttonDemoRoute
];

@NgModule({
    imports: [
        AwesomeaguSharedModule,
        FormsModule,
        SelectButtonModule,
        ToastModule,
        SelectButtonModule,
        WizardModule,
        RouterModule.forRoot(PRIMENG_STATES, { useHash: true })
    ],
    declarations: [
        SelectButtonDemoComponent
    ],
    providers: [MessageService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AwesomeaguSelectButtonDemoModule {}
