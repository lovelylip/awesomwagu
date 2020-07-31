import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

// import needed PrimeNG modules here
import {CheckboxModule} from 'primeng/checkbox';
import {SelectButtonModule} from 'primeng/selectbutton';

import { AwesomeaguSharedModule } from '../../../shared/shared.module';
import {FormsModule} from '@angular/forms';
import {CalendarModule} from 'primeng/calendar';
import {ButtonModule} from 'primeng/button';
import {ToastModule} from 'primeng/toast';
import {WizardModule} from 'primeng-extensions/components/wizard/wizard.js';
import {MessageService} from 'primeng/api';

import {
    CalendarDemoComponent,
    calendarDemoRoute
} from './';

const PRIMENG_STATES = [
    calendarDemoRoute
];

@NgModule({
    imports: [
        AwesomeaguSharedModule,
        FormsModule,
        CalendarModule,
        ToastModule,
        CheckboxModule,
        SelectButtonModule,
        ButtonModule,
        WizardModule,
        RouterModule.forRoot(PRIMENG_STATES, { useHash: true })
    ],
    declarations: [
        CalendarDemoComponent
    ],
    providers: [MessageService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AwesomeaguCalendarDemoModule {}
