export interface IDmCqBhxh {
  id?: number;
  maCqbh?: string;
  ten?: string;
  diaChi?: string;
  maXa?: string;
  maHuyen?: string;
  maTinh?: string;
  emailAcc?: string;
  phoneNumeric?: string;
  status?: string;
  activeDate?: number;
  inactiveDate?: number;
  maCqbhCha?: string;
  nguoiKy?: string;
  chucDanh?: string;
  tenNoiKy?: string;
  isActive?: number;
  path?: string;
  ngayKhoa?: number;
  soQdTl?: string;
  ngayQdTl?: number;
  cqKyQd?: string;
}

export class DmCqBhxh implements IDmCqBhxh {
  constructor(
    public id?: number,
    public maCqbh?: string,
    public ten?: string,
    public diaChi?: string,
    public maXa?: string,
    public maHuyen?: string,
    public maTinh?: string,
    public emailAcc?: string,
    public phoneNumeric?: string,
    public status?: string,
    public activeDate?: number,
    public inactiveDate?: number,
    public maCqbhCha?: string,
    public nguoiKy?: string,
    public chucDanh?: string,
    public tenNoiKy?: string,
    public isActive?: number,
    public path?: string,
    public ngayKhoa?: number,
    public soQdTl?: string,
    public ngayQdTl?: number,
    public cqKyQd?: string
  ) {}
}
