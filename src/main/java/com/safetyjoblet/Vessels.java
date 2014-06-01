package com.safetyjoblet;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
@Entity
@PrimaryKeyJoinColumn(name="ASSET_CODE")
public class Vessels extends Assets {

	@NotNull
	@ManyToOne (targetEntity = OwnerCompanies.class)
	@JoinColumn(name="OWNC_CODE")
	private OwnerCompanies ownerCompanies;
//	@NotNull
	@OneToOne (targetEntity = Assets.class)
	@JoinColumn(name="ASSET_CODE", insertable = false, updatable = false)
	private Assets assets;
	@NotNull
	@ManyToOne (targetEntity = VesselTypes.class)
	@JoinColumn(name="VSTP_CODE")
	private VesselTypes vesselTypes;
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = AuthoritiesCountries.class)
	@JoinColumn(name="ATHCNT_CODE")
	private AuthoritiesCountries authoritiesCountries;
	@NotBlank
	@Column(name="VESS_IMO_NUMBER")
	private String vessImoNumber;
	@Column(name="VESS_DWT")	
	private BigDecimal vessDwt;
	@Column(name="VESS_BUILT")
	private Date vessBuilt;
	@Column(name="VESS_YARD")
	private String vessYard;
	@Column(name="VESS_IS_SOLD")
	private Boolean vessIsSold;
	@OneToMany (targetEntity=VesselsRiskProfileHistory.class)
	private Set<VesselsRiskProfileHistory> vesselsRiskProfileHistories = new HashSet<VesselsRiskProfileHistory>(
			0);
	@OneToMany (targetEntity=VesselsCorrespondences.class)
	private Set<VesselsCorrespondences> vesselsCorrespondenceses = new HashSet<VesselsCorrespondences>(
			0);

    @OneToOne(targetEntity=VesselsLastRiskProfile.class)
    @JoinColumn(name="ASSET_CODE")
    private VesselsLastRiskProfile vesselsLastRiskProfile;

	public OwnerCompanies getOwnerCompanies() {
		return this.ownerCompanies;
	}

	public void setOwnerCompanies(OwnerCompanies ownerCompanies) {
		this.ownerCompanies = ownerCompanies;
	}

	public Assets getAssets() {
		return this.assets;
	}

	public void setAssets(Assets assets) {
		this.assets = assets;
	}

	public VesselTypes getVesselTypes() {
		return this.vesselTypes;
	}

	public void setVesselTypes(VesselTypes vesselTypes) {
		this.vesselTypes = vesselTypes;
	}

	public AuthoritiesCountries getAuthoritiesCountries() {
		return this.authoritiesCountries;
	}

	public void setAuthoritiesCountries(
			AuthoritiesCountries authoritiesCountries) {
		this.authoritiesCountries = authoritiesCountries;
	}

	public String getVessImoNumber() {
		return this.vessImoNumber;
	}

	public void setVessImoNumber(String vessImoNumber) {
		this.vessImoNumber = vessImoNumber;
	}

	public BigDecimal getVessDwt() {
		return this.vessDwt;
	}

	public void setVessDwt(BigDecimal vessDwt) {
		this.vessDwt = vessDwt;
	}

	public Date getVessBuilt() {
		return this.vessBuilt;
	}

	public void setVessBuilt(Date vessBuilt) {
		this.vessBuilt = vessBuilt;
	}

	public String getVessYard() {
		return this.vessYard;
	}

	public void setVessYard(String vessYard) {
		this.vessYard = vessYard;
	}

	public Boolean getVessIsSold() {
		return this.vessIsSold;
	}

	public void setVessIsSold(Boolean vessIsSold) {
		this.vessIsSold = vessIsSold;
	}

	public Set<VesselsRiskProfileHistory> getVesselsRiskProfileHistories() {
		return this.vesselsRiskProfileHistories;
	}

	public void setVesselsRiskProfileHistories(
			Set<VesselsRiskProfileHistory> vesselsRiskProfileHistories) {
		this.vesselsRiskProfileHistories = vesselsRiskProfileHistories;
	}

	public Set<VesselsCorrespondences> getVesselsCorrespondenceses() {
		return this.vesselsCorrespondenceses;
	}

	public void setVesselsCorrespondenceses(
			Set<VesselsCorrespondences> vesselsCorrespondenceses) {
		this.vesselsCorrespondenceses = vesselsCorrespondenceses;
	}

    public VesselsLastRiskProfile getVesselsLastRiskProfile() {
        return vesselsLastRiskProfile;
    }

    public void setVesselsLastRiskProfile(
            VesselsLastRiskProfile vesselsLastRiskProfile)
    {
        this.vesselsLastRiskProfile = vesselsLastRiskProfile;
    }

}
