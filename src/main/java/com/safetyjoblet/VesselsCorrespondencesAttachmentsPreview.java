package com.safetyjoblet;

import org.web4thejob.orm.AbstractHibernateEntity;
import org.web4thejob.orm.annotation.MediaHolder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lena on 31/5/2014.
 */
@Entity
@Table(name="VESSELS_CORRESPONDENCES_ATTACHMENTS_PREVIEW")
public class VesselsCorrespondencesAttachmentsPreview extends AbstractHibernateEntity {

    @Id
    @Column(name = "VCRA_CODE")
    @GeneratedValue
    private int vcraCode;

    @OneToOne(targetEntity = VesselsCorrespondencesAttachments.class)
    @JoinColumn(name = "VCRA_CODE")
    private VesselsCorrespondencesAttachments vesselsCorrespondencesAttachments;

    @MediaHolder
    private byte[] vcraAttachmentPreview;

    public int getVcraCode() {
        return this.vcraCode;
    }

    public void setVcraCode(int vcraCode) {
        this.vcraCode = vcraCode;
    }

    public VesselsCorrespondencesAttachments getVesselsCorrespondencesAttachments()
    {
        return this.vesselsCorrespondencesAttachments;
    }

    public void setVesselsCorrespondencesAttachments(VesselsCorrespondencesAttachments vesselsCorrespondencesAttachments) {
        this.vesselsCorrespondencesAttachments = vesselsCorrespondencesAttachments;
    }

    public byte[] getVcraAttachmentPreview()
    { return  this.vcraAttachmentPreview; }

    public  void setVcraAttachmentPreview(byte[] vcraAttachmentPreview)
    {
        this.vcraAttachmentPreview = vcraAttachmentPreview;
    }

    @Override
    public Serializable getIdentifierValue() {
        return vcraCode;
    }

    @Override
    public void setAsNew() {
        vcraCode = 0;
    }

}
