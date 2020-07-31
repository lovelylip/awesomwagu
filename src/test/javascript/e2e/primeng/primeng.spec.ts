import { browser, element, by } from 'protractor';

describe('administration', () => {

    const username = element(by.id('username'));
    const password = element(by.id('password'));
    const accountMenu = element(by.id('account-menu'));
    const primengMenu = element(by.id('primeng-menu'));
    const login = element(by.id('login'));
    const logout = element(by.id('logout'));

    beforeAll(() => {
        browser.get('/');

        accountMenu.click();
        login.click();

        username.sendKeys('admin');
        password.sendKeys('admin');
        element(by.css('button[type=submit]')).click();
        browser.waitForAngular();
    });

    beforeEach(() => {
        primengMenu.click();
    });

    it('should load BarChart', () => {
        element(by.css('[routerLink="barchart"]')).click();
            const expect1 = /primeng.barchart.home.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load DoughnutChart', () => {
        element(by.css('[routerLink="doughnutchart"]')).click();
            const expect1 = /primeng.doughnutchart.home.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load LineChart', () => {
        element(by.css('[routerLink="linechart"]')).click();
            const expect1 = /primeng.linechart.home.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load PieChart', () => {
        element(by.css('[routerLink="piechart"]')).click();
            const expect1 = /primeng.piechart.home.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load PolarAreaChart', () => {
        element(by.css('[routerLink="polarareachart"]')).click();
            const expect1 = /primeng.polarareachart.home.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load RadarChart', () => {
        element(by.css('[routerLink="radarchart"]')).click();
            const expect1 = /primeng.radarchart.home.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load InputText', () => {
        element(by.css('[routerLink="inputtext"]')).click();
            const expect1 = /primeng.inputs.inputtext.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load InputGroup', () => {
        element(by.css('[routerLink="inputgroup"]')).click();
            const expect1 = /primeng.inputs.inputgroup.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load InputTextArea', () => {
        element(by.css('[routerLink="inputtextarea"]')).click();
            const expect1 = /primeng.inputs.inputtextarea.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Calendar', () => {
        element(by.css('[routerLink="calendar"]')).click();
            const expect1 = /primeng.inputs.calendar.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Chips', () => {
        element(by.css('[routerLink="chips"]')).click();
            const expect1 = /primeng.inputs.chips.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load InputSwitch', () => {
        element(by.css('[routerLink="inputswitch"]')).click();
            const expect1 = /primeng.inputs.inputswitch.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load InputMask', () => {
        element(by.css('[routerLink="inputmask"]')).click();
            const expect1 = /primeng.inputs.inputmask.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load PasswordIndicator', () => {
        element(by.css('[routerLink="password"]')).click();
            const expect1 = /primeng.inputs.password.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Rating', () => {
        element(by.css('[routerLink="rating"]')).click();
            const expect1 = /primeng.inputs.rating.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Spinner', () => {
        element(by.css('[routerLink="spinner"]')).click();
            const expect1 = /primeng.inputs.spinner.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load ToggleButton', () => {
        element(by.css('[routerLink="togglebutton"]')).click();
            const expect1 = /primeng.inputs.togglebutton.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load AutoComplete', () => {
        element(by.css('[routerLink="autocomplete"]')).click();
            const expect1 = /primeng.inputs.autocomplete.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Checkbox', () => {
        element(by.css('[routerLink="checkbox"]')).click();
            const expect1 = /primeng.inputs.checkbox.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load ColorPicker', () => {
        element(by.css('[routerLink="ColorPicker"]')).click();
            const expect1 = /primeng.inputs.colorpicker.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Editor', () => {
        element(by.css('[routerLink="editor"]')).click();
            const expect1 = /primeng.inputs.editor.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Listbox', () => {
        element(by.css('[routerLink="listbox"]')).click();
            const expect1 = /primeng.inputs.listbox.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Select', () => {
        element(by.css('[routerLink="select"]')).click();
            const expect1 = /primeng.inputs.select.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load RadioButton', () => {
        element(by.css('[routerLink="select"]')).click();
            const expect1 = /primeng.inputs.select.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Slider', () => {
        element(by.css('[routerLink="slider"]')).click();
            const expect1 = /primeng.inputs.slider.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load SelectButton', () => {
        element(by.css('[routerLink="selectbutton"]')).click();
            const expect1 = /primeng.inputs.selectbutton.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Carousel', () => {
        element(by.css('[routerLink="carousel"]')).click();
            const expect1 = /primeng.data.carousel.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load OrderList', () => {
        element(by.css('[routerLink="orderlist"]')).click();
            const expect1 = /primeng.data.orderlist.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Paginator', () => {
        element(by.css('[routerLink="paginator"]')).click();
            const expect1 = /primeng.data.paginator.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load FullCalendar', () => {
        element(by.css('[routerLink="fullcalendar"]')).click();
            const expect1 = /primeng.data.fullcalendar.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load TreeTable', () => {
        element(by.css('[routerLink="treetable"]')).click();
            const expect1 = /primeng.data.treetable.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load VirtualScroller', () => {
        element(by.css('[routerLink="virtualscroller"]')).click();
            const expect1 = /primeng.data.virtualscroller.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load OrgChart', () => {
        element(by.css('[routerLink="orgchart"]')).click();
            const expect1 = /primeng.data.orgchart.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Gmap', () => {
        element(by.css('[routerLink="gmap"]')).click();
            const expect1 = /primeng.data.gmap.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load PickList', () => {
        element(by.css('[routerLink="picklist"]')).click();
            const expect1 = /primeng.data.picklist.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Tree', () => {
        element(by.css('[routerLink="tree"]')).click();
            const expect1 = /primeng.data.tree.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Accordion', () => {
        element(by.css('[routerLink="accordion"]')).click();
            const expect1 = /primeng.panel.accordion.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load FlexGrid', () => {
        element(by.css('[routerLink="flexgrid"]')).click();
            const expect1 = /primeng.panel.flexgrid.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Panel', () => {
        element(by.css('[routerLink="panel"]')).click();
            const expect1 = /primeng.panel.panel.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load TabView', () => {
        element(by.css('[routerLink="tabview"]')).click();
            const expect1 = /primeng.panel.tabview.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Fieldset', () => {
        element(by.css('[routerLink="fieldset"]')).click();
            const expect1 = /primeng.panel.fieldset.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Grid', () => {
        element(by.css('[routerLink="grid"]')).click();
            const expect1 = /primeng.panel.grid.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Toolbar', () => {
        element(by.css('[routerLink="toolbar"]')).click();
            const expect1 = /primeng.panel.toolbar.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load sidebar', () => {
        element(by.css('[routerLink="sidebar"]')).click();
            const expect1 = /primeng.overlay.sidebar.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Dialog', () => {
        element(by.css('[routerLink="dialog"]')).click();
            const expect1 = /primeng.overlay.dialog.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load ConfirmDialog', () => {
        element(by.css('[routerLink="confirmdialog"]')).click();
            const expect1 = /primeng.overlay.confirmdialog.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load LightBox', () => {
        element(by.css('[routerLink="lightbox"]')).click();
            const expect1 = /primeng.overlay.lightbox.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load OverlayPanel', () => {
        element(by.css('[routerLink="overlaypanel"]')).click();
            const expect1 = /primeng.overlay.overlaypanel.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Tooltip', () => {
        element(by.css('[routerLink="tooltip"]')).click();
            const expect1 = /primeng.overlay.tooltip.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load FileUpload', () => {
        element(by.css('[routerLink="fileupload"]')).click();
            const expect1 = /primeng.fileupload.fileupload.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Menu', () => {
        element(by.css('[routerLink="menu"]')).click();
            const expect1 = /primeng.menu.menu.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load ContextMenu', () => {
        element(by.css('[routerLink="contextmenu"]')).click();
            const expect1 = /primeng.menu.contextmenu.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load PanelMenu', () => {
        element(by.css('[routerLink="panelmenu"]')).click();
            const expect1 = /primeng.menu.panelmenu.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Steps', () => {
        element(by.css('[routerLink="steps"]')).click();
            const expect1 = /primeng.menu.steps.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load TieredMenu', () => {
        element(by.css('[routerLink="tieredmenu"]')).click();
            const expect1 = /primeng.menu.tieredmenu.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Breadcrumb', () => {
        element(by.css('[routerLink="breadcrumb"]')).click();
            const expect1 = /primeng.menu.breadcrumb.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load MegaMenu', () => {
        element(by.css('[routerLink="megamenu"]')).click();
            const expect1 = /primeng.menu.megamenu.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Menubar', () => {
        element(by.css('[routerLink="menubar"]')).click();
            const expect1 = /primeng.menu.menubar.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load SlideMenu', () => {
        element(by.css('[routerLink="slidemenu"]')).click();
            const expect1 = /primeng.menu.slidemenu.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load TabMenu', () => {
        element(by.css('[routerLink="tabmenu"]')).click();
            const expect1 = /primeng.menu.tabmenu.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Messages', () => {
        element(by.css('[routerLink="messages"]')).click();
            const expect1 = /primeng.messages.messages.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Toast', () => {
        element(by.css('[routerLink="toast"]')).click();
            const expect1 = /primeng.messages.toast.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Galleria', () => {
        element(by.css('[routerLink="galleria"]')).click();
            const expect1 = /primeng.multimedia.galleria.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load DragDrop', () => {
        element(by.css('[routerLink="dragdrop"]')).click();
            const expect1 = /primeng.dragdrop.dragdrop.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Captcha', () => {
        element(by.css('[routerLink="captcha"]')).click();
            const expect1 = /primeng.multimedia.captcha.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Defer', () => {
        element(by.css('[routerLink="defer"]')).click();
            const expect1 = /primeng.misc.defer.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load RTL', () => {
        element(by.css('[routerLink="rtl"]')).click();
            const expect1 = /primeng.misc.rtl.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load BlockUI', () => {
        element(by.css('[routerLink="blockui"]')).click();
            const expect1 = /primeng.misc.blockui.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Terminal', () => {
        element(by.css('[routerLink="terminal"]')).click();
            const expect1 = /primeng.misc.terminal.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Inplace', () => {
        element(by.css('[routerLink="inplace"]')).click();
            const expect1 = /primeng.misc.inplace.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load ProgressBar', () => {
        element(by.css('[routerLink="progressbar"]')).click();
            const expect1 = /primeng.misc.progressbar.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Validation', () => {
        element(by.css('[routerLink="validation"]')).click();
            const expect1 = /primeng.misc.validation.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Progress Spinner', () => {
        element(by.css('[routerLink="progressspinner"]')).click();
            const expect1 = /primeng.misc.progressspinner.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load Button', () => {
        element(by.css('[routerLink="button"]')).click();
            const expect1 = /primeng.buttons.button.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    it('should load SplitButton', () => {
        element(by.css('[routerLink="splitbutton"]')).click();
            const expect1 = /primeng.buttons.splitbutton.title/;
        element.all(by.css('h2 span')).first().getAttribute('jhiTranslate').then((value) => {
            expect(value).toMatch(expect1);
        });
    });

    afterAll(() => {
        accountMenu.click();
        logout.click();
    });
});
