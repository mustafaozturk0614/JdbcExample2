package com.bilgeadam.entity;

public class Futbolcu {

    private Long id;
    private String ad;
    private String mevki;
    private int formaNo;
    private double deger;
    private Long takimId;


    public Futbolcu(long id, String ad, String mevki, int formaNo, double deger, Long takimId) {
        this.id = id;
        this.ad = ad;
        this.mevki = mevki;
        this.formaNo = formaNo;
        this.deger = deger;
        this.takimId = takimId;
    }

    public Futbolcu(String ad, String mevki, int formaNo, double deger, Long takimId) {
        this.ad = ad;
        this.mevki = mevki;
        this.formaNo = formaNo;
        this.deger = deger;
        this.takimId = takimId;
    }
    public Futbolcu(String ad, String mevki, int formaNo, double deger) {
        this.ad = ad;
        this.mevki = mevki;
        this.formaNo = formaNo;
        this.deger = deger;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getMevki() {
        return mevki;
    }

    public void setMevki(String mevki) {
        this.mevki = mevki;
    }

    public int getFormaNo() {
        return formaNo;
    }

    public void setFormaNo(int formaNo) {
        this.formaNo = formaNo;
    }

    public double getDeger() {
        return deger;
    }

    public void setDeger(double deger) {
        this.deger = deger;
    }

    public Long getTakimId() {
        return takimId;
    }

    public void setTakimId(Long takimId) {
        this.takimId = takimId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Futbolcu{");
        sb.append("id=").append(id);
        sb.append(", ad='").append(ad).append('\'');
        sb.append(", mevki='").append(mevki).append('\'');
        sb.append(", formaNo='").append(formaNo).append('\'');
        sb.append(", deger=").append(deger);
        sb.append(", takimId=").append(takimId);
        sb.append('}');
        return sb.toString();
    }
}
