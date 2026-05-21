package com.wanted.membership.professor.model.dto;

import java.sql.Date;

public class ProfessorDTO {

    private int profNo;

    private String profId;

    private String profPw;

    private String profName;

    private String profEmail;

    private String profPhone;

    private String profAddress;

    private String profCode;

    private java.sql.Date enrollDate;

    public ProfessorDTO(int profNo, String profId, String profPw, String profName, String profEmail, String profPhone, String profAddress, String profCode, Date enrollDate) {
        this.profNo = profNo;
        this.profId = profId;
        this.profPw = profPw;
        this.profName = profName;
        this.profEmail = profEmail;
        this.profPhone = profPhone;
        this.profAddress = profAddress;
        this.profCode = profCode;
        this.enrollDate = enrollDate;
    }

    public int getProfNo() {
        return profNo;
    }

    public void setProfNo(int profNo) {
        this.profNo = profNo;
    }

    public String getProfId() {
        return profId;
    }

    public void setProfId(String profId) {
        this.profId = profId;
    }

    public String getProfPw() {
        return profPw;
    }

    public void setProfPw(String profPw) {
        this.profPw = profPw;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getProfEmail() {
        return profEmail;
    }

    public void setProfEmail(String profEmail) {
        this.profEmail = profEmail;
    }

    public String getProfPhone() {
        return profPhone;
    }

    public void setProfPhone(String profPhone) {
        this.profPhone = profPhone;
    }

    public String getProfAddress() {
        return profAddress;
    }

    public void setProfAddress(String profAddress) {
        this.profAddress = profAddress;
    }

    public String getProfCode() {
        return profCode;
    }

    public void setProfCode(String profCode) {
        this.profCode = profCode;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Override
    public String toString() {
        return "ProfessorDTO{" +
                "profNo=" + profNo +
                ", profId='" + profId + '\'' +
                ", profPw='" + profPw + '\'' +
                ", profName='" + profName + '\'' +
                ", profEmail='" + profEmail + '\'' +
                ", profPhone='" + profPhone + '\'' +
                ", profAddress='" + profAddress + '\'' +
                ", profCode='" + profCode + '\'' +
                ", enrollDate=" + enrollDate +
                '}';
    }
}
