package com.silk.awesomeagu.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;

/**
 * A DmCqBhxh.
 */
@Entity
@Table(name = "dm_cq_bhxh")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "dmcqbhxh")
public class DmCqBhxh implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "ma_cqbh", nullable = false)
    private String maCqbh;

    @Column(name = "ten")
    private String ten;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "ma_xa")
    private String maXa;

    @Column(name = "ma_huyen")
    private String maHuyen;

    @Column(name = "ma_tinh")
    private String maTinh;

    @Column(name = "email_acc")
    private String emailAcc;

    @Column(name = "phone_numeric")
    private String phoneNumeric;

    @Column(name = "status")
    private String status;

    @Column(name = "active_date")
    private Long activeDate;

    @Column(name = "inactive_date")
    private Long inactiveDate;

    @Column(name = "ma_cqbh_cha")
    private String maCqbhCha;

    @Column(name = "nguoi_ky")
    private String nguoiKy;

    @Column(name = "chuc_danh")
    private String chucDanh;

    @Column(name = "ten_noi_ky")
    private String tenNoiKy;

    @Column(name = "is_active")
    private Long isActive;

    @Column(name = "path")
    private String path;

    @Column(name = "ngay_khoa")
    private Long ngayKhoa;

    @Column(name = "so_qd_tl")
    private String soQdTl;

    @Column(name = "ngay_qd_tl")
    private Long ngayQdTl;

    @Column(name = "cq_ky_qd")
    private String cqKyQd;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaCqbh() {
        return maCqbh;
    }

    public DmCqBhxh maCqbh(String maCqbh) {
        this.maCqbh = maCqbh;
        return this;
    }

    public void setMaCqbh(String maCqbh) {
        this.maCqbh = maCqbh;
    }

    public String getTen() {
        return ten;
    }

    public DmCqBhxh ten(String ten) {
        this.ten = ten;
        return this;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public DmCqBhxh diaChi(String diaChi) {
        this.diaChi = diaChi;
        return this;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaXa() {
        return maXa;
    }

    public DmCqBhxh maXa(String maXa) {
        this.maXa = maXa;
        return this;
    }

    public void setMaXa(String maXa) {
        this.maXa = maXa;
    }

    public String getMaHuyen() {
        return maHuyen;
    }

    public DmCqBhxh maHuyen(String maHuyen) {
        this.maHuyen = maHuyen;
        return this;
    }

    public void setMaHuyen(String maHuyen) {
        this.maHuyen = maHuyen;
    }

    public String getMaTinh() {
        return maTinh;
    }

    public DmCqBhxh maTinh(String maTinh) {
        this.maTinh = maTinh;
        return this;
    }

    public void setMaTinh(String maTinh) {
        this.maTinh = maTinh;
    }

    public String getEmailAcc() {
        return emailAcc;
    }

    public DmCqBhxh emailAcc(String emailAcc) {
        this.emailAcc = emailAcc;
        return this;
    }

    public void setEmailAcc(String emailAcc) {
        this.emailAcc = emailAcc;
    }

    public String getPhoneNumeric() {
        return phoneNumeric;
    }

    public DmCqBhxh phoneNumeric(String phoneNumeric) {
        this.phoneNumeric = phoneNumeric;
        return this;
    }

    public void setPhoneNumeric(String phoneNumeric) {
        this.phoneNumeric = phoneNumeric;
    }

    public String getStatus() {
        return status;
    }

    public DmCqBhxh status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getActiveDate() {
        return activeDate;
    }

    public DmCqBhxh activeDate(Long activeDate) {
        this.activeDate = activeDate;
        return this;
    }

    public void setActiveDate(Long activeDate) {
        this.activeDate = activeDate;
    }

    public Long getInactiveDate() {
        return inactiveDate;
    }

    public DmCqBhxh inactiveDate(Long inactiveDate) {
        this.inactiveDate = inactiveDate;
        return this;
    }

    public void setInactiveDate(Long inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getMaCqbhCha() {
        return maCqbhCha;
    }

    public DmCqBhxh maCqbhCha(String maCqbhCha) {
        this.maCqbhCha = maCqbhCha;
        return this;
    }

    public void setMaCqbhCha(String maCqbhCha) {
        this.maCqbhCha = maCqbhCha;
    }

    public String getNguoiKy() {
        return nguoiKy;
    }

    public DmCqBhxh nguoiKy(String nguoiKy) {
        this.nguoiKy = nguoiKy;
        return this;
    }

    public void setNguoiKy(String nguoiKy) {
        this.nguoiKy = nguoiKy;
    }

    public String getChucDanh() {
        return chucDanh;
    }

    public DmCqBhxh chucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
        return this;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    public String getTenNoiKy() {
        return tenNoiKy;
    }

    public DmCqBhxh tenNoiKy(String tenNoiKy) {
        this.tenNoiKy = tenNoiKy;
        return this;
    }

    public void setTenNoiKy(String tenNoiKy) {
        this.tenNoiKy = tenNoiKy;
    }

    public Long getIsActive() {
        return isActive;
    }

    public DmCqBhxh isActive(Long isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public String getPath() {
        return path;
    }

    public DmCqBhxh path(String path) {
        this.path = path;
        return this;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getNgayKhoa() {
        return ngayKhoa;
    }

    public DmCqBhxh ngayKhoa(Long ngayKhoa) {
        this.ngayKhoa = ngayKhoa;
        return this;
    }

    public void setNgayKhoa(Long ngayKhoa) {
        this.ngayKhoa = ngayKhoa;
    }

    public String getSoQdTl() {
        return soQdTl;
    }

    public DmCqBhxh soQdTl(String soQdTl) {
        this.soQdTl = soQdTl;
        return this;
    }

    public void setSoQdTl(String soQdTl) {
        this.soQdTl = soQdTl;
    }

    public Long getNgayQdTl() {
        return ngayQdTl;
    }

    public DmCqBhxh ngayQdTl(Long ngayQdTl) {
        this.ngayQdTl = ngayQdTl;
        return this;
    }

    public void setNgayQdTl(Long ngayQdTl) {
        this.ngayQdTl = ngayQdTl;
    }

    public String getCqKyQd() {
        return cqKyQd;
    }

    public DmCqBhxh cqKyQd(String cqKyQd) {
        this.cqKyQd = cqKyQd;
        return this;
    }

    public void setCqKyQd(String cqKyQd) {
        this.cqKyQd = cqKyQd;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DmCqBhxh)) {
            return false;
        }
        return id != null && id.equals(((DmCqBhxh) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DmCqBhxh{" +
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
