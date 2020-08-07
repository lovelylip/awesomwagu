import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { DmCqBhxhComponentsPage, DmCqBhxhDeleteDialog, DmCqBhxhUpdatePage } from './dm-cq-bhxh.page-object';

const expect = chai.expect;

describe('DmCqBhxh e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let dmCqBhxhComponentsPage: DmCqBhxhComponentsPage;
  let dmCqBhxhUpdatePage: DmCqBhxhUpdatePage;
  let dmCqBhxhDeleteDialog: DmCqBhxhDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load DmCqBhxhs', async () => {
    await navBarPage.goToEntity('dm-cq-bhxh');
    dmCqBhxhComponentsPage = new DmCqBhxhComponentsPage();
    await browser.wait(ec.visibilityOf(dmCqBhxhComponentsPage.title), 5000);
    expect(await dmCqBhxhComponentsPage.getTitle()).to.eq('awesomeaguApp.dmCqBhxh.home.title');
    await browser.wait(ec.or(ec.visibilityOf(dmCqBhxhComponentsPage.entities), ec.visibilityOf(dmCqBhxhComponentsPage.noResult)), 1000);
  });

  it('should load create DmCqBhxh page', async () => {
    await dmCqBhxhComponentsPage.clickOnCreateButton();
    dmCqBhxhUpdatePage = new DmCqBhxhUpdatePage();
    expect(await dmCqBhxhUpdatePage.getPageTitle()).to.eq('awesomeaguApp.dmCqBhxh.home.createOrEditLabel');
    await dmCqBhxhUpdatePage.cancel();
  });

  it('should create and save DmCqBhxhs', async () => {
    const nbButtonsBeforeCreate = await dmCqBhxhComponentsPage.countDeleteButtons();

    await dmCqBhxhComponentsPage.clickOnCreateButton();

    await promise.all([
      dmCqBhxhUpdatePage.setMaCqbhInput('maCqbh'),
      dmCqBhxhUpdatePage.setTenInput('ten'),
      dmCqBhxhUpdatePage.setDiaChiInput('diaChi'),
      dmCqBhxhUpdatePage.setMaXaInput('maXa'),
      dmCqBhxhUpdatePage.setMaHuyenInput('maHuyen'),
      dmCqBhxhUpdatePage.setMaTinhInput('maTinh'),
      dmCqBhxhUpdatePage.setEmailAccInput('emailAcc'),
      dmCqBhxhUpdatePage.setPhoneNumericInput('phoneNumeric'),
      dmCqBhxhUpdatePage.setStatusInput('status'),
      dmCqBhxhUpdatePage.setActiveDateInput('5'),
      dmCqBhxhUpdatePage.setInactiveDateInput('5'),
      dmCqBhxhUpdatePage.setMaCqbhChaInput('maCqbhCha'),
      dmCqBhxhUpdatePage.setNguoiKyInput('nguoiKy'),
      dmCqBhxhUpdatePage.setChucDanhInput('chucDanh'),
      dmCqBhxhUpdatePage.setTenNoiKyInput('tenNoiKy'),
      dmCqBhxhUpdatePage.setIsActiveInput('5'),
      dmCqBhxhUpdatePage.setPathInput('path'),
      dmCqBhxhUpdatePage.setNgayKhoaInput('5'),
      dmCqBhxhUpdatePage.setSoQdTlInput('soQdTl'),
      dmCqBhxhUpdatePage.setNgayQdTlInput('5'),
      dmCqBhxhUpdatePage.setCqKyQdInput('cqKyQd'),
    ]);

    expect(await dmCqBhxhUpdatePage.getMaCqbhInput()).to.eq('maCqbh', 'Expected MaCqbh value to be equals to maCqbh');
    expect(await dmCqBhxhUpdatePage.getTenInput()).to.eq('ten', 'Expected Ten value to be equals to ten');
    expect(await dmCqBhxhUpdatePage.getDiaChiInput()).to.eq('diaChi', 'Expected DiaChi value to be equals to diaChi');
    expect(await dmCqBhxhUpdatePage.getMaXaInput()).to.eq('maXa', 'Expected MaXa value to be equals to maXa');
    expect(await dmCqBhxhUpdatePage.getMaHuyenInput()).to.eq('maHuyen', 'Expected MaHuyen value to be equals to maHuyen');
    expect(await dmCqBhxhUpdatePage.getMaTinhInput()).to.eq('maTinh', 'Expected MaTinh value to be equals to maTinh');
    expect(await dmCqBhxhUpdatePage.getEmailAccInput()).to.eq('emailAcc', 'Expected EmailAcc value to be equals to emailAcc');
    expect(await dmCqBhxhUpdatePage.getPhoneNumericInput()).to.eq(
      'phoneNumeric',
      'Expected PhoneNumeric value to be equals to phoneNumeric'
    );
    expect(await dmCqBhxhUpdatePage.getStatusInput()).to.eq('status', 'Expected Status value to be equals to status');
    expect(await dmCqBhxhUpdatePage.getActiveDateInput()).to.eq('5', 'Expected activeDate value to be equals to 5');
    expect(await dmCqBhxhUpdatePage.getInactiveDateInput()).to.eq('5', 'Expected inactiveDate value to be equals to 5');
    expect(await dmCqBhxhUpdatePage.getMaCqbhChaInput()).to.eq('maCqbhCha', 'Expected MaCqbhCha value to be equals to maCqbhCha');
    expect(await dmCqBhxhUpdatePage.getNguoiKyInput()).to.eq('nguoiKy', 'Expected NguoiKy value to be equals to nguoiKy');
    expect(await dmCqBhxhUpdatePage.getChucDanhInput()).to.eq('chucDanh', 'Expected ChucDanh value to be equals to chucDanh');
    expect(await dmCqBhxhUpdatePage.getTenNoiKyInput()).to.eq('tenNoiKy', 'Expected TenNoiKy value to be equals to tenNoiKy');
    expect(await dmCqBhxhUpdatePage.getIsActiveInput()).to.eq('5', 'Expected isActive value to be equals to 5');
    expect(await dmCqBhxhUpdatePage.getPathInput()).to.eq('path', 'Expected Path value to be equals to path');
    expect(await dmCqBhxhUpdatePage.getNgayKhoaInput()).to.eq('5', 'Expected ngayKhoa value to be equals to 5');
    expect(await dmCqBhxhUpdatePage.getSoQdTlInput()).to.eq('soQdTl', 'Expected SoQdTl value to be equals to soQdTl');
    expect(await dmCqBhxhUpdatePage.getNgayQdTlInput()).to.eq('5', 'Expected ngayQdTl value to be equals to 5');
    expect(await dmCqBhxhUpdatePage.getCqKyQdInput()).to.eq('cqKyQd', 'Expected CqKyQd value to be equals to cqKyQd');

    await dmCqBhxhUpdatePage.save();
    expect(await dmCqBhxhUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await dmCqBhxhComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last DmCqBhxh', async () => {
    const nbButtonsBeforeDelete = await dmCqBhxhComponentsPage.countDeleteButtons();
    await dmCqBhxhComponentsPage.clickOnLastDeleteButton();

    dmCqBhxhDeleteDialog = new DmCqBhxhDeleteDialog();
    expect(await dmCqBhxhDeleteDialog.getDialogTitle()).to.eq('awesomeaguApp.dmCqBhxh.delete.question');
    await dmCqBhxhDeleteDialog.clickOnConfirmButton();

    expect(await dmCqBhxhComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
