package com.websystique.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TASKMILESTONE")
public class TaskMilestone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="SSOID", nullable=false)
	private String ssoId;
	
	@NotNull
	@Column(name="DENEMEID", nullable=false)
	private Integer denemeId;
	
	@Column(name="TYTTURKCE")
	private Float tytTurkce;
	
	@Column(name="TYTMATEMATIK")
	private Float tytMatematik;
		
	@Column(name="TYTTARIH")
	private Float tytTarih;
	
	@Column(name="TYTCOGRAFYA")
	private Float tytCografya;
	
	@Column(name="TYTFELSEFE")
	private Float tytFelsefe;
		
	@Column(name="TYTDIN")
	private Float tytDin;
	
	@Column(name="TYTFIZIK")
	private Float tytFizik;
	
	@Column(name="TYTKIMYA")
	private Float tytKimya;
		
	@Column(name="TYTBIYOLOJI")
	private Float tytBiyoloji;
	
	@Column(name="YKSMATEMATIK")
	private Float yksMatematik;
	
	@Column(name="YKSEDEBIYAT")
	private Float yksEdebiyat;
	
	@Column(name="YKSCOGRAFYA1")
	private Float yksCografya1;
	
	@Column(name="YKSTARIH1")
	private Float yksTarih1;
	
	@Column(name="YKSCOGRAFYA2")
	private Float yksCografya2;
	
	@Column(name="YKSTARIH2")
	private Float yksTarih2;
	
	@Column(name="YKSFELSEFE")
	private Float yksFelsefe;
	
	@Column(name="YKSDIN")
	private Float yksDin;
	
	@Column(name="YKSFIZIK")
	private Float yksFizik;
	
	@Column(name="YKSKIMYA")
	private Float yksKimya;
	
	@Column(name="YKSBIYOLOJI")
	private Float yksBiyoloji;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	public Integer getDenemeId() {
		return denemeId;
	}

	public void setDenemeId(Integer denemeId) {
		this.denemeId = denemeId;
	}

	public Float getTytTurkce() {
		return tytTurkce;
	}

	public void setTytTurkce(Float tytTurkce) {
		this.tytTurkce = tytTurkce;
	}

	public Float getTytMatematik() {
		return tytMatematik;
	}

	public void setTytMatematik(Float tytMatematik) {
		this.tytMatematik = tytMatematik;
	}

	public Float getTytTarih() {
		return tytTarih;
	}

	public void setTytTarih(Float tytTarih) {
		this.tytTarih = tytTarih;
	}

	public Float getTytCografya() {
		return tytCografya;
	}

	public void setTytCografya(Float tytCografya) {
		this.tytCografya = tytCografya;
	}

	public Float getTytFelsefe() {
		return tytFelsefe;
	}

	public void setTytFelsefe(Float tytFelsefe) {
		this.tytFelsefe = tytFelsefe;
	}

	public Float getTytDin() {
		return tytDin;
	}

	public void setTytDin(Float tytDin) {
		this.tytDin = tytDin;
	}

	public Float getTytFizik() {
		return tytFizik;
	}

	public void setTytFizik(Float tytFizik) {
		this.tytFizik = tytFizik;
	}

	public Float getTytKimya() {
		return tytKimya;
	}

	public void setTytKimya(Float tytKimya) {
		this.tytKimya = tytKimya;
	}

	public Float getTytBiyoloji() {
		return tytBiyoloji;
	}

	public void setTytBiyoloji(Float tytBiyoloji) {
		this.tytBiyoloji = tytBiyoloji;
	}

	public Float getYksMatematik() {
		return yksMatematik;
	}

	public void setYksMatematik(Float yksMatematik) {
		this.yksMatematik = yksMatematik;
	}

	public Float getYksEdebiyat() {
		return yksEdebiyat;
	}

	public void setYksEdebiyat(Float yksEdebiyat) {
		this.yksEdebiyat = yksEdebiyat;
	}

	public Float getYksCografya1() {
		return yksCografya1;
	}

	public void setYksCografya1(Float yksCografya1) {
		this.yksCografya1 = yksCografya1;
	}

	public Float getYksTarih1() {
		return yksTarih1;
	}

	public void setYksTarih1(Float yksTarih1) {
		this.yksTarih1 = yksTarih1;
	}

	public Float getYksCografya2() {
		return yksCografya2;
	}

	public void setYksCografya2(Float yksCografya2) {
		this.yksCografya2 = yksCografya2;
	}

	public Float getYksTarih2() {
		return yksTarih2;
	}

	public void setYksTarih2(Float yksTarih2) {
		this.yksTarih2 = yksTarih2;
	}

	public Float getYksFelsefe() {
		return yksFelsefe;
	}

	public void setYksFelsefe(Float yksFelsefe) {
		this.yksFelsefe = yksFelsefe;
	}

	public Float getYksDin() {
		return yksDin;
	}

	public void setYksDin(Float yksDin) {
		this.yksDin = yksDin;
	}

	public Float getYksFizik() {
		return yksFizik;
	}

	public void setYksFizik(Float yksFizik) {
		this.yksFizik = yksFizik;
	}

	public Float getYksKimya() {
		return yksKimya;
	}

	public void setYksKimya(Float yksKimya) {
		this.yksKimya = yksKimya;
	}

	public Float getYksBiyoloji() {
		return yksBiyoloji;
	}

	public void setYksBiyoloji(Float yksBiyoloji) {
		this.yksBiyoloji = yksBiyoloji;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
		result = prime * result + ((denemeId == null) ? 0 : denemeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskMilestone other = (TaskMilestone) obj;
		if (denemeId == null) {
			if (other.denemeId != null)
				return false;
		} else if (!denemeId.equals(other.denemeId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ssoId == null) {
			if (other.ssoId != null)
				return false;
		} else if (!ssoId.equals(other.ssoId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaskMilestone [id=" + id + ", ssoId=" + ssoId + ", denemeId=" + denemeId + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
