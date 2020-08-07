package com.silk.awesomeagu.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.silk.awesomeagu.domain.DmCqBhxh} entity.
 */
public class DmCqBhxhDTO implements Serializable {
    
    private Long id;

    @NotNull
    private String maCqbh;

    private String ten;

    private String diaChi;

    private String maXa;

    private String maHuyen;

    private String maTinh;

    private String emailAcc;

    private String phoneNumeric;

    private String status;

    private Long activeDate;

    private Long inactiveDate;

    private String maCqbhCha;

    private String nguoiKy;

    private String chucDanh;

    private String tenNoiKy;

    private Long isActive;

    private String path;

    private Long ngayKhoa;

    private String soQdTl;

    private Long ngayQdTl;

    private String cqKyQd;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaCqbh() {
        return maCqbh;
    }

    public void setMaCqbh(String maCqbh) {
        this.maCqbh = maCqbh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaXa() {
        return maXa;
    }

    public void setMaXa(String maXa) {
        this.maXa = maXa;
    }

    public String getMaHuyen() {
        return maHuyen;
    }

    public void setMaHuyen(String maHuyen) {
        this.maHuyen = maHuyen;
    }

    public String getMaTinh() {
        return maTinh;
    }

    public void setMaTinh(String maTinh) {
        this.maTinh = maTinh;
    }

    public String getEmailAcc() {
        return emailAcc;
    }

    public void setEmailAcc(String emailAcc) {
        this.emailAcc = emailAcc;
    }

    public String getPhoneNumeric() {
        return phoneNumeric;
    }

    public void setPhoneNumeric(String phoneNumeric) {
        this.phoneNumeric = phoneNumeric;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Long activeDate) {
        this.activeDate = activeDate;
    }

    public Long getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(Long inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getMaCqbhCha() {
        return maCqbhCha;
    }

    public void setMaCqbhCha(String maCqbhCha) {
        this.maCqbhCha = maCqbhCha;
    }

    public String getNguoiKy() {
        return nguoiKy;
    }

    public void setNguoiKy(String nguoiKy) {
        this.nguoiKy = nguoiKy;
    }

    public String getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    public String getTenNoiKy() {
        return tenNoiKy;
    }

    public void setTenNoiKy(String tenNoiKy) {
        this.tenNoiKy = tenNoiKy;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getNgayKhoa() {
        return ngayKhoa;
    }

    public void setNgayKhoa(Long ngayKhoa) {
        this.ngayKhoa = ngayKhoa;
    }

    public String getSoQdTl() {
        return soQdTl;
    }

    public void setSoQdTl(String soQdTl) {
        this.soQdTl = soQdTl;
    }

    public Long getNgayQdTl() {
        return ngayQdTl;
    }

    public void setNgayQdTl(Long ngayQdTl) {
        this.ngayQdTl = ngayQdTl;
    }

    public String getCqKyQd() {
        return cqKyQd;
    }

    public void setCqKyQd(String cqKyQd) {
        this.cqKyQd = cqKyQd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DmCqBhxhDTO)) {
            return false;
        }

        return id != null && id.equals(((DmCqBhxhDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DmCqBhxhDTO{" +
            "id=" + getId() +
            ", maCqbh='" + getMaCqbh() + "'" +
            ", ten='" + getTen() + "'" +
            ", diaChi='" + getDiaChi() + "'" +
            ", maXa='" + getMaXa() + "'" +
            ", maHuyen='" + getMaHuyen() + "'" +
            ", maTinh='" + getMaTinh() + "'" +
            ", emailAcc='" + getEmailAcc() + "'" +
            ", phoneNumeric='" + getPhoneNumeric() + "'" +
            ", status='" + getStatus() + "'" +
            ", activeDate=" + getActiveDate() +
            ", inactiveDate=" + getInactiveDate() +
            ", maCqbhCha='" + getMaCqbhCha() + "'" +
            ", nguoiKy='" + getNguoiKy() + "'" +
            ", chucDanh='" + getChucDanh() + "'" +
            ", tenNoiKy='" + getTenNoiKy() + "'" +
            ", isActive=" + getIsActive() +
            ", path='" + getPath() + "'" +
            ", ngayKhoa=" + getNgayKhoa() +
            ", soQdTl='" + getSoQdTl() + "'" +
            ", ngayQdTl=" + getNgayQdTl() +
            ", cqKyQd='" + getCqKyQd() + "'" +
            "}";
    }
}
