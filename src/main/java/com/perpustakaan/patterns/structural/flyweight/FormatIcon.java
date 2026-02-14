package com.perpustakaan.patterns.structural.flyweight;

public interface FormatIcon {
    // x dan y adalah Extrinsic State (berubah-ubah per buku)
    void display(int x, int y);
}