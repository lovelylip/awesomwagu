import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CommonModule} from '@angular/common';
import { AwesomeaguSharedModule } from '../../../shared/shared.module';
import {ToastModule} from 'primeng/toast';
import {TerminalModule} from 'primeng/terminal';
import {WizardModule} from 'primeng-extensions/components/wizard/wizard.js';
import {MessageService} from 'primeng/api';

import {
    TerminalDemoComponent,
    terminalDemoRoute
} from './';

const PRIMENG_STATES = [
    terminalDemoRoute];

@NgModule({
    imports: [
        AwesomeaguSharedModule,
        CommonModule,
        BrowserAnimationsModule,
        ToastModule,
        TerminalModule,
        WizardModule,
        RouterModule.forRoot(PRIMENG_STATES, { useHash: true })
    ],
    declarations: [
        TerminalDemoComponent
    ],
    providers: [MessageService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AwesomeaguTerminalDemoModule {}
