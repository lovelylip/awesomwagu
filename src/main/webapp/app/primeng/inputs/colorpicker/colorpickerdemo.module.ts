import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AwesomeaguSharedModule } from '../../../shared/shared.module';
import {FormsModule} from '@angular/forms';
import {ColorPickerModule} from 'primeng/colorpicker';
import {ToastModule} from 'primeng/toast';
import {WizardModule} from 'primeng-extensions/components/wizard/wizard.js';
import {MessageService} from 'primeng/api';

import {
    ColorpickerDemoComponent,
    colorpickerDemoRoute
} from './';

const PRIMENG_STATES = [
    colorpickerDemoRoute
];

@NgModule({
    imports: [
        AwesomeaguSharedModule,
        FormsModule,
        ColorPickerModule,
        ToastModule,
        WizardModule,
        RouterModule.forRoot(PRIMENG_STATES, { useHash: true })
    ],
    declarations: [
        ColorpickerDemoComponent
    ],
    providers: [MessageService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AwesomeaguColorPickerDemoModule {}
