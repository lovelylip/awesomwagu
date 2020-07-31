import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CommonModule} from '@angular/common';
import { AwesomeaguSharedModule } from '../../../shared/shared.module';
import {ToastModule} from 'primeng/toast';
import {ButtonModule} from 'primeng/button';
import {FileUploadModule} from 'primeng/fileupload';
import {CheckboxModule} from 'primeng/checkbox';
import {WizardModule} from 'primeng-extensions/components/wizard/wizard.js';
import {APP_BASE_HREF} from '@angular/common';
import {MessageService} from 'primeng/api';

import {
    FileUploadDemoComponent,
    fileuploadDemoRoute
} from './';

const PRIMENG_STATES = [
    fileuploadDemoRoute
];

@NgModule({
    imports: [
        AwesomeaguSharedModule,
        CommonModule,
        BrowserAnimationsModule,
        FileUploadModule,
        CheckboxModule,
        ToastModule,
        ButtonModule,
        WizardModule,
        RouterModule.forRoot(PRIMENG_STATES, { useHash: true })
    ],
    declarations: [
        FileUploadDemoComponent
    ],
    providers: [{provide: APP_BASE_HREF, useValue: '/'}, MessageService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AwesomeaguFileUploadDemoModule {}
