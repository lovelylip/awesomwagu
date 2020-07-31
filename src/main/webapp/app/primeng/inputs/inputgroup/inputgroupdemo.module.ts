import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AwesomeaguSharedModule } from '../../../shared/shared.module';
import {FormsModule} from '@angular/forms';
import {InputTextModule} from 'primeng/inputtext';
import {CheckboxModule} from 'primeng/checkbox';
import {RadioButtonModule} from 'primeng/radiobutton';
import {ButtonModule} from 'primeng/button';
import {ToastModule} from 'primeng/toast';
import {WizardModule} from 'primeng-extensions/components/wizard/wizard.js';
import {MessageService} from 'primeng/api';

import {
    InputGroupDemoComponent,
    inputGroupDemoRoute
} from './';

const PRIMENG_STATES = [
    inputGroupDemoRoute
];

@NgModule({
    imports: [
        AwesomeaguSharedModule,
        FormsModule,
        InputTextModule,
        CheckboxModule,
        RadioButtonModule,
        ButtonModule,
        ToastModule,
        WizardModule,
        RouterModule.forRoot(PRIMENG_STATES, { useHash: true })
    ],
    declarations: [
        InputGroupDemoComponent
    ],
    providers: [MessageService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AwesomeaguInputGroupDemoModule {}
