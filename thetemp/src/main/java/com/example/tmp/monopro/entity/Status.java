package com.example.tmp.monopro.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "azstatus", schema = "azspace")
public class Status  implements Serializable {
    private static final long serialVersionUID = 1234172041950251411L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusid;

    private int userid;
    private String filename;
    private boolean processed;
    private boolean mailsend;
    private String satname;
    private String azconfig;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime processdate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedate;
    private String azdescription;


    public int getStatusid() {
        return statusid;
    }

    public void setStatusid(int statusid) {
        this.statusid = statusid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public boolean isMailsend() {
        return mailsend;
    }

    public void setMailsend(boolean mailsend) {
        this.mailsend = mailsend;
    }

    public String getAzconfig() {
        return azconfig;
    }

    public void setAzconfig(String azconfig) {
        this.azconfig = azconfig;
    }

    public LocalDateTime getProcessdate() {
        return processdate;
    }

    public void setProcessdate(LocalDateTime processdate) {
        this.processdate = processdate;
    }

    public LocalDateTime getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(LocalDateTime updatedate) {
        this.updatedate = updatedate;
    }

    public String getAzdescription() {
        return azdescription;
    }

    public void setAzdescription(String azdescription) {
        this.azdescription = azdescription;
    }

    public String getSatname() {
        return satname;
    }

    public void setSatname(String satname) {
        this.satname = satname;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusid=" + statusid +
                ", userid=" + userid +
                ", filename='" + filename + '\'' +
                ", processed=" + processed +
                ", mailsend=" + mailsend +
                ", satname='" + satname + '\'' +
                ", azconfig='" + azconfig + '\'' +
                ", processdate=" + processdate +
                ", updatedate=" + updatedate +
                ", azdescription='" + azdescription + '\'' +
                '}';
    }
}