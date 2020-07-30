import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { AwesomeaguSharedModule } from 'app/shared/shared.module';
import { AwesomeaguCoreModule } from 'app/core/core.module';
import { AwesomeaguAppRoutingModule } from './app-routing.module';
import { AwesomeaguHomeModule } from './home/home.module';
import { AwesomeaguEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ActiveMenuDirective } from './layouts/navbar/active-menu.directive';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    AwesomeaguSharedModule,
    AwesomeaguCoreModule,
    AwesomeaguHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    AwesomeaguEntityModule,
    AwesomeaguAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, ActiveMenuDirective, FooterComponent],
  bootstrap: [MainComponent],
})
export class AwesomeaguAppModule {}
