package com.example.dethicuachien;

public class HangMT {
    private String hang;

    public HangMT(String hang) {
        this.hang = hang;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    @Override
    public String toString() {
        return hang;
    }
}
