package com.safetyjoblet;

import org.web4thejob.orm.AbstractHibernateEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "INSPECTIONS_AUDITS")
public class InspectionsAudits extends AbstractHibernateEntity {
    @Id
    @Column(name = "INAD_CODE")
    @GeneratedValue
    private int inadCode;
    @NotNull
    @ManyToOne(targetEntity = Assets.class)
    @JoinColumn(name = "ASSET_CODE")
    private Assets assets;
    @ManyToOne(targetEntity = InspectionAuditDescriptions.class)
    private InspectionAuditDescriptions inspectionAuditDescriptions;
    @NotNull
    @ManyToOne(targetEntity = AuthoritiesCountries.class)
    @JoinColumn(name = "ATHCNT_CODE_COUNTRY")
    private AuthoritiesCountries authoritiesCountriesByAthcntCodeCountry;
    @ManyToOne(targetEntity = InspectionAuditKinds.class)
    private InspectionAuditKinds inspectionAuditKinds;
    @NotNull
    @ManyToOne(targetEntity = Ports.class)
    private Ports ports;
    @ManyToOne(targetEntity = AuthoritiesCountries.class)
    @JoinColumn(name = "ATHCNT_CODE_AUTHORITY")
    private AuthoritiesCountries authoritiesCountriesByAthcntCodeAuthority;
    @ManyToOne(targetEntity = InspectionAuditTypes.class)
    private InspectionAuditTypes inspectionAuditTypes;
    private Integer inadId = null;
    @NotNull
    private Date inadDate;
    private String inadObservations;
    @OneToMany(targetEntity = InspectionsAuditsAttachments.class)
    private Set<InspectionsAuditsAttachments> inspectionsAuditsAttachmentses = new HashSet<InspectionsAuditsAttachments>(
            0);
    @OneToMany(targetEntity = InspectionsAuditsDeficiencies.class)
    private Set<InspectionsAuditsDeficiencies> inspectionsAuditsDeficiencieses = new HashSet<InspectionsAuditsDeficiencies>(
            0);

    public int getInadCode() {
        return this.inadCode;
    }

    public void setInadCode(int inadCode) {
        this.inadCode = inadCode;
    }

    public Assets getAssets() {
        return this.assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public InspectionAuditDescriptions getInspectionAuditDescriptions() {
        return this.inspectionAuditDescriptions;

    }

    public void setInspectionAuditDescriptions(
            InspectionAuditDescriptions inspectionAuditDescriptions) {

        this.inspectionAuditDescriptions = inspectionAuditDescriptions;
     //   setDirty();
    }

    public AuthoritiesCountries getAuthoritiesCountriesByAthcntCodeCountry() {
        return this.authoritiesCountriesByAthcntCodeCountry;
    }

    public void setAuthoritiesCountriesByAthcntCodeCountry(
            AuthoritiesCountries authoritiesCountriesByAthcntCodeCountry) {
        this.authoritiesCountriesByAthcntCodeCountry = authoritiesCountriesByAthcntCodeCountry;
        setPorts(null);
        setDirty("authoritiesCountriesByAthcntCodeCountry");
    }

    public InspectionAuditKinds getInspectionAuditKinds() {
        return this.inspectionAuditKinds;
    }

    public void setInspectionAuditKinds(InspectionAuditKinds inspectionAuditKinds) {
        this.inspectionAuditKinds = inspectionAuditKinds;
        setInspectionAuditDescriptions(null);
        setDirty("inspectionAuditKinds");
    }

    public Ports getPorts() {
        return this.ports;
    }

    public void setPorts(Ports ports) {
        this.ports = ports;
    }

    public AuthoritiesCountries getAuthoritiesCountriesByAthcntCodeAuthority() {
        return this.authoritiesCountriesByAthcntCodeAuthority;
    }

    public void setAuthoritiesCountriesByAthcntCodeAuthority(
            AuthoritiesCountries authoritiesCountriesByAthcntCodeAuthority) {
        this.authoritiesCountriesByAthcntCodeAuthority = authoritiesCountriesByAthcntCodeAuthority;
    }

    public InspectionAuditTypes getInspectionAuditTypes() {
        return this.inspectionAuditTypes;
    }

    public void setInspectionAuditTypes(
            InspectionAuditTypes inspectionAuditTypes) {
        this.inspectionAuditTypes = inspectionAuditTypes;
    }

    public Integer getInadId() {
        return this.inadId;
    }

    public void setInadId(int inadId) {
        this.inadId = inadId;
    }

    public Date getInadDate() {
        return this.inadDate;
    }

    public void setInadDate(Date inadDate) {
        this.inadDate = inadDate;
    }

    public String getInadObservations() {
        return this.inadObservations;
    }

    public void setInadObservations(String inadObservations) {
        this.inadObservations = inadObservations;
    }

    public Set<InspectionsAuditsAttachments> getInspectionsAuditsAttachmentses() {
        return this.inspectionsAuditsAttachmentses;
    }

    public void setInspectionsAuditsAttachmentses(
            Set<InspectionsAuditsAttachments> inspectionsAuditsAttachmentses) {
        this.inspectionsAuditsAttachmentses = inspectionsAuditsAttachmentses;
    }

    public Set<InspectionsAuditsDeficiencies> getInspectionsAuditsDeficiencieses() {
        return this.inspectionsAuditsDeficiencieses;
    }

    public void setInspectionsAuditsDeficiencieses(
            Set<InspectionsAuditsDeficiencies> inspectionsAuditsDeficiencieses) {
        this.inspectionsAuditsDeficiencieses = inspectionsAuditsDeficiencieses;
    }

    @Override
    public Serializable getIdentifierValue() {
        return inadCode;
    }

    @Override
    public void setAsNew() {
        inadCode = 0;
    }

    @Override
    public String toString() {
        return Integer.toString(this.inadId);
    }

}
