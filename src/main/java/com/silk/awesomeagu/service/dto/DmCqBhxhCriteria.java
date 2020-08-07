package com.silk.awesomeagu.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link com.silk.awesomeagu.domain.DmCqBhxh} entity. This class is used
 * in {@link com.silk.awesomeagu.web.rest.DmCqBhxhResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /dm-cq-bhxhs?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class DmCqBhxhCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter maCqbh;

    private StringFilter ten;

    private StringFilter diaChi;

    private StringFilter maXa;

    private StringFilter maHuyen;

    private StringFilter maTinh;

    private StringFilter emailAcc;

    private StringFilter phoneNumeric;

    private StringFilter status;

    private LongFilter activeDate;

    private LongFilter inactiveDate;

    private StringFilter maCqbhCha;

    private StringFilter nguoiKy;

    private StringFilter chucDanh;

    private StringFilter tenNoiKy;

    private LongFilter isActive;

    private StringFilter path;

    private LongFilter ngayKhoa;

    private StringFilter soQdTl;

    private LongFilter ngayQdTl;

    private StringFilter cqKyQd;

    public DmCqBhxhCriteria() {
    }

    public DmCqBhxhCriteria(DmCqBhxhCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.maCqbh = other.maCqbh == null ? null : other.maCqbh.copy();
        this.ten = other.ten == null ? null : other.ten.copy();
        this.diaChi = other.diaChi == null ? null : other.diaChi.copy();
        this.maXa = other.maXa == null ? null : other.maXa.copy();
        this.maHuyen = other.maHuyen == null ? null : other.maHuyen.copy();
        this.maTinh = other.maTinh == null ? null : other.maTinh.copy();
        this.emailAcc = other.emailAcc == null ? null : other.emailAcc.copy();
        this.phoneNumeric = other.phoneNumeric == null ? null : other.phoneNumeric.copy();
        this.status = other.status == null ? null : other.status.copy();
        this.activeDate = other.activeDate == null ? null : other.activeDate.copy();
        this.inactiveDate = other.inactiveDate == null ? null : other.inactiveDate.copy();
        this.maCqbhCha = other.maCqbhCha == null ? null : other.maCqbhCha.copy();
        this.nguoiKy = other.nguoiKy == null ? null : other.nguoiKy.copy();
        this.chucDanh = other.chucDanh == null ? null : other.chucDanh.copy();
        this.tenNoiKy = other.tenNoiKy == null ? null : other.tenNoiKy.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.path = other.path == null ? null : other.path.copy();
        this.ngayKhoa = other.ngayKhoa == null ? null : other.ngayKhoa.copy();
        this.soQdTl = other.soQdTl == null ? null : other.soQdTl.copy();
        this.ngayQdTl = other.ngayQdTl == null ? null : other.ngayQdTl.copy();
        this.cqKyQd = other.cqKyQd == null ? null : other.cqKyQd.copy();
    }

    @Override
    public DmCqBhxhCriteria copy() {
        return new DmCqBhxhCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getMaCqbh() {
        return maCqbh;
    }

    public void setMaCqbh(StringFilter maCqbh) {
        this.maCqbh = maCqbh;
    }

    public StringFilter getTen() {
        return ten;
    }

    public void setTen(StringFilter ten) {
        this.ten = ten;
    }

    public StringFilter getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(StringFilter diaChi) {
        this.diaChi = diaChi;
    }

    public StringFilter getMaXa() {
        return maXa;
    }

    public void setMaXa(StringFilter maXa) {
        this.maXa = maXa;
    }

    public StringFilter getMaHuyen() {
        return maHuyen;
    }

    public void setMaHuyen(StringFilter maHuyen) {
        this.maHuyen = maHuyen;
    }

    public StringFilter getMaTinh() {
        return maTinh;
    }

    public void setMaTinh(StringFilter maTinh) {
        this.maTinh = maTinh;
    }

    public StringFilter getEmailAcc() {
        return emailAcc;
    }

    public void setEmailAcc(StringFilter emailAcc) {
        this.emailAcc = emailAcc;
    }

    public StringFilter getPhoneNumeric() {
        return phoneNumeric;
    }

    public void setPhoneNumeric(StringFilter phoneNumeric) {
        this.phoneNumeric = phoneNumeric;
    }

    public StringFilter getStatus() {
        return status;
    }

    public void setStatus(StringFilter status) {
        this.status = status;
    }

    public LongFilter getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(LongFilter activeDate) {
        this.activeDate = activeDate;
    }

    public LongFilter getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(LongFilter inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public StringFilter getMaCqbhCha() {
        return maCqbhCha;
    }

    public void setMaCqbhCha(StringFilter maCqbhCha) {
        this.maCqbhCha = maCqbhCha;
    }

    public StringFilter getNguoiKy() {
        return nguoiKy;
    }

    public void setNguoiKy(StringFilter nguoiKy) {
        this.nguoiKy = nguoiKy;
    }

    public StringFilter getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(StringFilter chucDanh) {
        this.chucDanh = chucDanh;
    }

    public StringFilter getTenNoiKy() {
        return tenNoiKy;
    }

    public void setTenNoiKy(StringFilter tenNoiKy) {
        this.tenNoiKy = tenNoiKy;
    }

    public LongFilter getIsActive() {
        return isActive;
    }

    public void setIsActive(LongFilter isActive) {
        this.isActive = isActive;
    }

    public StringFilter getPath() {
        return path;
    }

    public void setPath(StringFilter path) {
        this.path = path;
    }

    public LongFilter getNgayKhoa() {
        return ngayKhoa;
    }

    public void setNgayKhoa(LongFilter ngayKhoa) {
        this.ngayKhoa = ngayKhoa;
    }

    public StringFilter getSoQdTl() {
        return soQdTl;
    }

    public void setSoQdTl(StringFilter soQdTl) {
        this.soQdTl = soQdTl;
    }

    public LongFilter getNgayQdTl() {
        return ngayQdTl;
    }

    public void setNgayQdTl(LongFilter ngayQdTl) {
        this.ngayQdTl = ngayQdTl;
    }

    public StringFilter getCqKyQd() {
        return cqKyQd;
    }

    public void setCqKyQd(StringFilter cqKyQd) {
        this.cqKyQd = cqKyQd;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final DmCqBhxhCriteria that = (DmCqBhxhCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(maCqbh, that.maCqbh) &&
            Objects.equals(ten, that.ten) &&
            Objects.equals(diaChi, that.diaChi) &&
            Objects.equals(maXa, that.maXa) &&
            Objects.equals(maHuyen, that.maHuyen) &&
            Objects.equals(maTinh, that.maTinh) &&
            Objects.equals(emailAcc, that.emailAcc) &&
            Objects.equals(phoneNumeric, that.phoneNumeric) &&
            Objects.equals(status, that.status) &&
            Objects.equals(activeDate, that.activeDate) &&
            Objects.equals(inactiveDate, that.inactiveDate) &&
            Objects.equals(maCqbhCha, that.maCqbhCha) &&
            Objects.equals(nguoiKy, that.nguoiKy) &&
            Objects.equals(chucDanh, that.chucDanh) &&
            Objects.equals(tenNoiKy, that.tenNoiKy) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(path, that.path) &&
            Objects.equals(ngayKhoa, that.ngayKhoa) &&
            Objects.equals(soQdTl, that.soQdTl) &&
            Objects.equals(ngayQdTl, that.ngayQdTl) &&
            Objects.equals(cqKyQd, that.cqKyQd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        maCqbh,
        ten,
        diaChi,
        maXa,
        maHuyen,
        maTinh,
        emailAcc,
        phoneNumeric,
        status,
        activeDate,
        inactiveDate,
        maCqbhCha,
        nguoiKy,
        chucDanh,
        tenNoiKy,
        isActive,
        path,
        ngayKhoa,
        soQdTl,
        ngayQdTl,
        cqKyQd
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DmCqBhxhCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (maCqbh != null ? "maCqbh=" + maCqbh + ", " : "") +
                (ten != null ? "ten=" + ten + ", " : "") +
                (diaChi != null ? "diaChi=" + diaChi + ", " : "") +
                (maXa != null ? "maXa=" + maXa + ", " : "") +
                (maHuyen != null ? "maHuyen=" + maHuyen + ", " : "") +
                (maTinh != null ? "maTinh=" + maTinh + ", " : "") +
                (emailAcc != null ? "emailAcc=" + emailAcc + ", " : "") +
                (phoneNumeric != null ? "phoneNumeric=" + phoneNumeric + ", " : "") +
                (status != null ? "status=" + status + ", " : "") +
                (activeDate != null ? "activeDate=" + activeDate + ", " : "") +
                (inactiveDate != null ? "inactiveDate=" + inactiveDate + ", " : "") +
                (maCqbhCha != null ? "maCqbhCha=" + maCqbhCha + ", " : "") +
                (nguoiKy != null ? "nguoiKy=" + nguoiKy + ", " : "") +
                (chucDanh != null ? "chucDanh=" + chucDanh + ", " : "") +
                (tenNoiKy != null ? "tenNoiKy=" + tenNoiKy + ", " : "") +
                (isActive != null ? "isActive=" + isActive + ", " : "") +
                (path != null ? "path=" + path + ", " : "") +
                (ngayKhoa != null ? "ngayKhoa=" + ngayKhoa + ", " : "") +
                (soQdTl != null ? "soQdTl=" + soQdTl + ", " : "") +
                (ngayQdTl != null ? "ngayQdTl=" + ngayQdTl + ", " : "") +
                (cqKyQd != null ? "cqKyQd=" + cqKyQd + ", " : "") +
            "}";
    }

}
