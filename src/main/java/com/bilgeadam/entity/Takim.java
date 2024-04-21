package com.bilgeadam.entity;

public class Takim {

    private Long id;
    private String isim;

    public Takim(Long id, String isim) {
        this.id = id;
        this.isim = isim;
    }

    public Takim(String isim) {
        this.isim = isim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Takim{");
        sb.append("id=").append(id);
        sb.append(", isim='").append(isim).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
