
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AwesomeaguButtonDemoModule } from './buttons/button/buttondemo.module';
import { AwesomeaguSplitbuttonDemoModule } from './buttons/splitbutton/splitbuttondemo.module';

import { AwesomeaguDialogDemoModule } from './overlay/dialog/dialogdemo.module';
import { AwesomeaguConfirmDialogDemoModule } from './overlay/confirmdialog/confirmdialogdemo.module';
import { AwesomeaguLightboxDemoModule } from './overlay/lightbox/lightboxdemo.module';
import { AwesomeaguTooltipDemoModule } from './overlay/tooltip/tooltipdemo.module';
import { AwesomeaguOverlayPanelDemoModule } from './overlay/overlaypanel/overlaypaneldemo.module';
import { AwesomeaguSideBarDemoModule } from './overlay/sidebar/sidebardemo.module';

import { AwesomeaguKeyFilterDemoModule } from './inputs/keyfilter/keyfilterdemo.module';
import { AwesomeaguInputTextDemoModule } from './inputs/inputtext/inputtextdemo.module';
import { AwesomeaguInputTextAreaDemoModule } from './inputs/inputtextarea/inputtextareademo.module';
import { AwesomeaguInputGroupDemoModule } from './inputs/inputgroup/inputgroupdemo.module';
import { AwesomeaguCalendarDemoModule } from './inputs/calendar/calendardemo.module';
import { AwesomeaguCheckboxDemoModule } from './inputs/checkbox/checkboxdemo.module';
import { AwesomeaguChipsDemoModule } from './inputs/chips/chipsdemo.module';
import { AwesomeaguColorPickerDemoModule } from './inputs/colorpicker/colorpickerdemo.module';
import { AwesomeaguInputMaskDemoModule } from './inputs/inputmask/inputmaskdemo.module';
import { AwesomeaguInputSwitchDemoModule } from './inputs/inputswitch/inputswitchdemo.module';
import { AwesomeaguPasswordIndicatorDemoModule } from './inputs/passwordindicator/passwordindicatordemo.module';
import { AwesomeaguAutoCompleteDemoModule } from './inputs/autocomplete/autocompletedemo.module';
import { AwesomeaguSliderDemoModule } from './inputs/slider/sliderdemo.module';
import { AwesomeaguSpinnerDemoModule } from './inputs/spinner/spinnerdemo.module';
import { AwesomeaguRatingDemoModule } from './inputs/rating/ratingdemo.module';
import { AwesomeaguSelectDemoModule } from './inputs/select/selectdemo.module';
import { AwesomeaguSelectButtonDemoModule } from './inputs/selectbutton/selectbuttondemo.module';
import { AwesomeaguListboxDemoModule } from './inputs/listbox/listboxdemo.module';
import { AwesomeaguRadioButtonDemoModule } from './inputs/radiobutton/radiobuttondemo.module';
import { AwesomeaguToggleButtonDemoModule } from './inputs/togglebutton/togglebuttondemo.module';
import { AwesomeaguEditorDemoModule } from './inputs/editor/editordemo.module';

import { AwesomeaguMessagesDemoModule } from './messages/messages/messagesdemo.module';
import { AwesomeaguToastDemoModule } from './messages/toast/toastdemo.module';
import { AwesomeaguGalleriaDemoModule } from './multimedia/galleria/galleriademo.module';

import { AwesomeaguFileUploadDemoModule } from './fileupload/fileupload/fileuploaddemo.module';

import { AwesomeaguAccordionDemoModule } from './panel/accordion/accordiondemo.module';
import { AwesomeaguPanelDemoModule } from './panel/panel/paneldemo.module';
import { AwesomeaguTabViewDemoModule } from './panel/tabview/tabviewdemo.module';
import { AwesomeaguFieldsetDemoModule } from './panel/fieldset/fieldsetdemo.module';
import { AwesomeaguToolbarDemoModule } from './panel/toolbar/toolbardemo.module';
import { AwesomeaguScrollPanelDemoModule } from './panel/scrollpanel/scrollpaneldemo.module';
import { AwesomeaguCardDemoModule } from './panel/card/carddemo.module';
import { AwesomeaguFlexGridDemoModule } from './panel/flexgrid/flexgriddemo.module';

import { AwesomeaguTableDemoModule } from './data/table/tabledemo.module';
import { AwesomeaguVirtualScrollerDemoModule } from './data/virtualscroller/virtualscrollerdemo.module';
import { AwesomeaguPickListDemoModule } from './data/picklist/picklistdemo.module';
import { AwesomeaguOrderListDemoModule } from './data/orderlist/orderlistdemo.module';
import { AwesomeaguFullCalendarDemoModule } from './data/fullcalendar/fullcalendardemo.module';
import { AwesomeaguTreeDemoModule } from './data/tree/treedemo.module';
import { AwesomeaguTreeTableDemoModule } from './data/treetable/treetabledemo.module';
import { AwesomeaguPaginatorDemoModule } from './data/paginator/paginatordemo.module';
import { AwesomeaguGmapDemoModule } from './data/gmap/gmapdemo.module';
import { AwesomeaguOrgChartDemoModule } from './data/orgchart/orgchartdemo.module';
import { AwesomeaguCarouselDemoModule } from './data/carousel/carouseldemo.module';
import { AwesomeaguDataViewDemoModule } from './data/dataview/dataviewdemo.module';

import { AwesomeaguBarchartDemoModule } from './charts/barchart/barchartdemo.module';
import { AwesomeaguDoughnutchartDemoModule } from './charts/doughnutchart/doughnutchartdemo.module';
import { AwesomeaguLinechartDemoModule } from './charts/linechart/linechartdemo.module';
import { AwesomeaguPiechartDemoModule } from './charts/piechart/piechartdemo.module';
import { AwesomeaguPolarareachartDemoModule } from './charts/polarareachart/polarareachartdemo.module';
import { AwesomeaguRadarchartDemoModule } from './charts/radarchart/radarchartdemo.module';

import { AwesomeaguDragDropDemoModule } from './dragdrop/dragdrop/dragdropdemo.module';

import { AwesomeaguMenuDemoModule } from './menu/menu/menudemo.module';
import { AwesomeaguContextMenuDemoModule } from './menu/contextmenu/contextmenudemo.module';
import { AwesomeaguPanelMenuDemoModule } from './menu/panelmenu/panelmenudemo.module';
import { AwesomeaguStepsDemoModule } from './menu/steps/stepsdemo.module';
import { AwesomeaguTieredMenuDemoModule } from './menu/tieredmenu/tieredmenudemo.module';
import { AwesomeaguBreadcrumbDemoModule } from './menu/breadcrumb/breadcrumbdemo.module';
import { AwesomeaguMegaMenuDemoModule } from './menu/megamenu/megamenudemo.module';
import { AwesomeaguMenuBarDemoModule } from './menu/menubar/menubardemo.module';
import { AwesomeaguSlideMenuDemoModule } from './menu/slidemenu/slidemenudemo.module';
import { AwesomeaguTabMenuDemoModule } from './menu/tabmenu/tabmenudemo.module';

import { AwesomeaguBlockUIDemoModule } from './misc/blockui/blockuidemo.module';
import { AwesomeaguCaptchaDemoModule } from './misc/captcha/captchademo.module';
import { AwesomeaguDeferDemoModule } from './misc/defer/deferdemo.module';
import { AwesomeaguInplaceDemoModule } from './misc/inplace/inplacedemo.module';
import { AwesomeaguProgressBarDemoModule } from './misc/progressbar/progressbardemo.module';
import { AwesomeaguRTLDemoModule } from './misc/rtl/rtldemo.module';
import { AwesomeaguTerminalDemoModule } from './misc/terminal/terminaldemo.module';
import { AwesomeaguValidationDemoModule } from './misc/validation/validationdemo.module';
import { AwesomeaguProgressSpinnerDemoModule } from './misc/progressspinner/progressspinnerdemo.module';

@NgModule({
    imports: [

        AwesomeaguMenuDemoModule,
        AwesomeaguContextMenuDemoModule,
        AwesomeaguPanelMenuDemoModule,
        AwesomeaguStepsDemoModule,
        AwesomeaguTieredMenuDemoModule,
        AwesomeaguBreadcrumbDemoModule,
        AwesomeaguMegaMenuDemoModule,
        AwesomeaguMenuBarDemoModule,
        AwesomeaguSlideMenuDemoModule,
        AwesomeaguTabMenuDemoModule,

        AwesomeaguBlockUIDemoModule,
        AwesomeaguCaptchaDemoModule,
        AwesomeaguDeferDemoModule,
        AwesomeaguInplaceDemoModule,
        AwesomeaguProgressBarDemoModule,
        AwesomeaguInputMaskDemoModule,
        AwesomeaguRTLDemoModule,
        AwesomeaguTerminalDemoModule,
        AwesomeaguValidationDemoModule,

        AwesomeaguButtonDemoModule,
        AwesomeaguSplitbuttonDemoModule,

        AwesomeaguInputTextDemoModule,
        AwesomeaguInputTextAreaDemoModule,
        AwesomeaguInputGroupDemoModule,
        AwesomeaguCalendarDemoModule,
        AwesomeaguChipsDemoModule,
        AwesomeaguInputMaskDemoModule,
        AwesomeaguInputSwitchDemoModule,
        AwesomeaguPasswordIndicatorDemoModule,
        AwesomeaguAutoCompleteDemoModule,
        AwesomeaguSliderDemoModule,
        AwesomeaguSpinnerDemoModule,
        AwesomeaguRatingDemoModule,
        AwesomeaguSelectDemoModule,
        AwesomeaguSelectButtonDemoModule,
        AwesomeaguListboxDemoModule,
        AwesomeaguRadioButtonDemoModule,
        AwesomeaguToggleButtonDemoModule,
        AwesomeaguEditorDemoModule,
        AwesomeaguColorPickerDemoModule,
        AwesomeaguCheckboxDemoModule,
        AwesomeaguKeyFilterDemoModule,

        AwesomeaguMessagesDemoModule,
        AwesomeaguToastDemoModule,
        AwesomeaguGalleriaDemoModule,

        AwesomeaguFileUploadDemoModule,

        AwesomeaguAccordionDemoModule,
        AwesomeaguPanelDemoModule,
        AwesomeaguTabViewDemoModule,
        AwesomeaguFieldsetDemoModule,
        AwesomeaguToolbarDemoModule,
        AwesomeaguScrollPanelDemoModule,
        AwesomeaguCardDemoModule,
        AwesomeaguFlexGridDemoModule,

        AwesomeaguBarchartDemoModule,
        AwesomeaguDoughnutchartDemoModule,
        AwesomeaguLinechartDemoModule,
        AwesomeaguPiechartDemoModule,
        AwesomeaguPolarareachartDemoModule,
        AwesomeaguRadarchartDemoModule,

        AwesomeaguDragDropDemoModule,

        AwesomeaguDialogDemoModule,
        AwesomeaguConfirmDialogDemoModule,
        AwesomeaguLightboxDemoModule,
        AwesomeaguTooltipDemoModule,
        AwesomeaguOverlayPanelDemoModule,
        AwesomeaguSideBarDemoModule,

        AwesomeaguTableDemoModule,
        AwesomeaguDataViewDemoModule,
        AwesomeaguVirtualScrollerDemoModule,
        AwesomeaguFullCalendarDemoModule,
        AwesomeaguOrderListDemoModule,
        AwesomeaguPickListDemoModule,
        AwesomeaguTreeDemoModule,
        AwesomeaguTreeTableDemoModule,
        AwesomeaguPaginatorDemoModule,
        AwesomeaguOrgChartDemoModule,
        AwesomeaguGmapDemoModule,
        AwesomeaguCarouselDemoModule,
        AwesomeaguProgressSpinnerDemoModule

    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AwesomeaguprimengModule {}
