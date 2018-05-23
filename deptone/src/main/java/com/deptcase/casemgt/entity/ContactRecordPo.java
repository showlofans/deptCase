package com.deptcase.casemgt.entity;

public class ContactRecordPo {
    private Long id;

    private Long ccId;

    private Long caseId;

    private String caseContact;

    private Integer recordUser;

    private String recordUserName;

    private String contactRecord;

    private Long recordTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCcId() {
        return ccId;
    }

    public void setCcId(Long ccId) {
        this.ccId = ccId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getCaseContact() {
        return caseContact;
    }

    public void setCaseContact(String caseContact) {
        this.caseContact = caseContact == null ? null : caseContact.trim();
    }

    public Integer getRecordUser() {
        return recordUser;
    }

    public void setRecordUser(Integer recordUser) {
        this.recordUser = recordUser;
    }

    public String getRecordUserName() {
        return recordUserName;
    }

    public void setRecordUserName(String recordUserName) {
        this.recordUserName = recordUserName == null ? null : recordUserName.trim();
    }

    public String getContactRecord() {
        return contactRecord;
    }

    public void setContactRecord(String contactRecord) {
        this.contactRecord = contactRecord == null ? null : contactRecord.trim();
    }

    public Long getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Long recordTime) {
        this.recordTime = recordTime;
    }
}