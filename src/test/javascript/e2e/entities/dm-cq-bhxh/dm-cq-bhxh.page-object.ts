import { element, by, ElementFinder } from 'protractor';

export class DmCqBhxhComponentsPage {
  createButton = element(by.id('jh-create-entity'));
  deleteButtons = element.all(by.css('jhi-dm-cq-bhxh div table .btn-danger'));
  title = element.all(by.css('jhi-dm-cq-bhxh div h2#page-heading span')).first();
  noResult = element(by.id('no-result'));
  entities = element(by.id('entities'));

  async clickOnCreateButton(): Promise<void> {
    await this.createButton.click();
  }

  async clickOnLastDeleteButton(): Promise<void> {
    await this.deleteButtons.last().click();
  }

  async countDeleteButtons(): Promise<number> {
    return this.deleteButtons.count();
  }

  async getTitle(): Promise<string> {
    return this.title.getAttribute('jhiTranslate');
  }
}

export class DmCqBhxhUpdatePage {
  pageTitle = element(by.id('jhi-dm-cq-bhxh-heading'));
  saveButton = element(by.id('save-entity'));
  cancelButton = element(by.id('cancel-save'));

  maCqbhInput = element(by.id('field_maCqbh'));
  tenInput = element(by.id('field_ten'));
  diaChiInput = element(by.id('field_diaChi'));
  maXaInput = element(by.id('field_maXa'));
  maHuyenInput = element(by.id('field_maHuyen'));
  maTinhInput = element(by.id('field_maTinh'));
  emailAccInput = element(by.id('field_emailAcc'));
  phoneNumericInput = element(by.id('field_phoneNumeric'));
  statusInput = element(by.id('field_status'));
  activeDateInput = element(by.id('field_activeDate'));
  inactiveDateInput = element(by.id('field_inactiveDate'));
  maCqbhChaInput = element(by.id('field_maCqbhCha'));
  nguoiKyInput = element(by.id('field_nguoiKy'));
  chucDanhInput = element(by.id('field_chucDanh'));
  tenNoiKyInput = element(by.id('field_tenNoiKy'));
  isActiveInput = element(by.id('field_isActive'));
  pathInput = element(by.id('field_path'));
  ngayKhoaInput = element(by.id('field_ngayKhoa'));
  soQdTlInput = element(by.id('field_soQdTl'));
  ngayQdTlInput = element(by.id('field_ngayQdTl'));
  cqKyQdInput = element(by.id('field_cqKyQd'));

  async getPageTitle(): Promise<string> {
    return this.pageTitle.getAttribute('jhiTranslate');
  }

  async setMaCqbhInput(maCqbh: string): Promise<void> {
    await this.maCqbhInput.sendKeys(maCqbh);
  }

  async getMaCqbhInput(): Promise<string> {
    return await this.maCqbhInput.getAttribute('value');
  }

  async setTenInput(ten: string): Promise<void> {
    await this.tenInput.sendKeys(ten);
  }

  async getTenInput(): Promise<string> {
    return await this.tenInput.getAttribute('value');
  }

  async setDiaChiInput(diaChi: string): Promise<void> {
    await this.diaChiInput.sendKeys(diaChi);
  }

  async getDiaChiInput(): Promise<string> {
    return await this.diaChiInput.getAttribute('value');
  }

  async setMaXaInput(maXa: string): Promise<void> {
    await this.maXaInput.sendKeys(maXa);
  }

  async getMaXaInput(): Promise<string> {
    return await this.maXaInput.getAttribute('value');
  }

  async setMaHuyenInput(maHuyen: string): Promise<void> {
    await this.maHuyenInput.sendKeys(maHuyen);
  }

  async getMaHuyenInput(): Promise<string> {
    return await this.maHuyenInput.getAttribute('value');
  }

  async setMaTinhInput(maTinh: string): Promise<void> {
    await this.maTinhInput.sendKeys(maTinh);
  }

  async getMaTinhInput(): Promise<string> {
    return await this.maTinhInput.getAttribute('value');
  }

  async setEmailAccInput(emailAcc: string): Promise<void> {
    await this.emailAccInput.sendKeys(emailAcc);
  }

  async getEmailAccInput(): Promise<string> {
    return await this.emailAccInput.getAttribute('value');
  }

  async setPhoneNumericInput(phoneNumeric: string): Promise<void> {
    await this.phoneNumericInput.sendKeys(phoneNumeric);
  }

  async getPhoneNumericInput(): Promise<string> {
    return await this.phoneNumericInput.getAttribute('value');
  }

  async setStatusInput(status: string): Promise<void> {
    await this.statusInput.sendKeys(status);
  }

  async getStatusInput(): Promise<string> {
    return await this.statusInput.getAttribute('value');
  }

  async setActiveDateInput(activeDate: string): Promise<void> {
    await this.activeDateInput.sendKeys(activeDate);
  }

  async getActiveDateInput(): Promise<string> {
    return await this.activeDateInput.getAttribute('value');
  }

  async setInactiveDateInput(inactiveDate: string): Promise<void> {
    await this.inactiveDateInput.sendKeys(inactiveDate);
  }

  async getInactiveDateInput(): Promise<string> {
    return await this.inactiveDateInput.getAttribute('value');
  }

  async setMaCqbhChaInput(maCqbhCha: string): Promise<void> {
    await this.maCqbhChaInput.sendKeys(maCqbhCha);
  }

  async getMaCqbhChaInput(): Promise<string> {
    return await this.maCqbhChaInput.getAttribute('value');
  }

  async setNguoiKyInput(nguoiKy: string): Promise<void> {
    await this.nguoiKyInput.sendKeys(nguoiKy);
  }

  async getNguoiKyInput(): Promise<string> {
    return await this.nguoiKyInput.getAttribute('value');
  }

  async setChucDanhInput(chucDanh: string): Promise<void> {
    await this.chucDanhInput.sendKeys(chucDanh);
  }

  async getChucDanhInput(): Promise<string> {
    return await this.chucDanhInput.getAttribute('value');
  }

  async setTenNoiKyInput(tenNoiKy: string): Promise<void> {
    await this.tenNoiKyInput.sendKeys(tenNoiKy);
  }

  async getTenNoiKyInput(): Promise<string> {
    return await this.tenNoiKyInput.getAttribute('value');
  }

  async setIsActiveInput(isActive: string): Promise<void> {
    await this.isActiveInput.sendKeys(isActive);
  }

  async getIsActiveInput(): Promise<string> {
    return await this.isActiveInput.getAttribute('value');
  }

  async setPathInput(path: string): Promise<void> {
    await this.pathInput.sendKeys(path);
  }

  async getPathInput(): Promise<string> {
    return await this.pathInput.getAttribute('value');
  }

  async setNgayKhoaInput(ngayKhoa: string): Promise<void> {
    await this.ngayKhoaInput.sendKeys(ngayKhoa);
  }

  async getNgayKhoaInput(): Promise<string> {
    return await this.ngayKhoaInput.getAttribute('value');
  }

  async setSoQdTlInput(soQdTl: string): Promise<void> {
    await this.soQdTlInput.sendKeys(soQdTl);
  }

  async getSoQdTlInput(): Promise<string> {
    return await this.soQdTlInput.getAttribute('value');
  }

  async setNgayQdTlInput(ngayQdTl: string): Promise<void> {
    await this.ngayQdTlInput.sendKeys(ngayQdTl);
  }

  async getNgayQdTlInput(): Promise<string> {
    return await this.ngayQdTlInput.getAttribute('value');
  }

  async setCqKyQdInput(cqKyQd: string): Promise<void> {
    await this.cqKyQdInput.sendKeys(cqKyQd);
  }

  async getCqKyQdInput(): Promise<string> {
    return await this.cqKyQdInput.getAttribute('value');
  }

  async save(): Promise<void> {
    await this.saveButton.click();
  }

  async cancel(): Promise<void> {
    await this.cancelButton.click();
  }

  getSaveButton(): ElementFinder {
    return this.saveButton;
  }
}

export class DmCqBhxhDeleteDialog {
  private dialogTitle = element(by.id('jhi-delete-dmCqBhxh-heading'));
  private confirmButton = element(by.id('jhi-confirm-delete-dmCqBhxh'));

  async getDialogTitle(): Promise<string> {
    return this.dialogTitle.getAttribute('jhiTranslate');
  }

  async clickOnConfirmButton(): Promise<void> {
    await this.confirmButton.click();
  }
}
