import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CommonModule} from '@angular/common';
import { AwesomeaguSharedModule } from '../../../shared/shared.module';
import {ToastModule} from 'primeng/toast';
import {MenuModule} from 'primeng/menu';
import {ButtonModule} from 'primeng/button';
import {WizardModule} from 'primeng-extensions/components/wizard/wizard.js';
import {MessageService} from 'primeng/api';

import {
    MenuDemoComponent,
    menuDemoRoute
} from './';

const PRIMENG_STATES = [
    menuDemoRoute
];

@NgModule({
    imports: [
        AwesomeaguSharedModule,
        CommonModule,
        BrowserAnimationsModule,
        MenuModule,
        ToastModule,
        ButtonModule,
        WizardModule,
        RouterModule.forRoot(PRIMENG_STATES, { useHash: true })
    ],
    declarations: [
        MenuDemoComponent
    ],
    providers: [MessageService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AwesomeaguMenuDemoModule {}
