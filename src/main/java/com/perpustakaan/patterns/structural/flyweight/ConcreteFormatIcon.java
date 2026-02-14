package com.perpustakaan.patterns.structural.flyweight;

public class ConcreteFormatIcon implements FormatIcon {
    private final String formatType; // Intrinsic State (Shared)
    // Simulasi data berat (misal: image bytes)
    private final String heavyAsciiArt;

    public ConcreteFormatIcon(String formatType) {
        this.formatType = formatType;
        // Simulasi loading aset berat
        System.out.println("... Loading heavy icon resources for: " + formatType + " to memory ...");
        this.heavyAsciiArt = switch (formatType) {
            case "PDF" -> "[PDF ICON]";
            case "AUDIO" -> "[AUDIO ICON]";
            case "EPUB" -> "[EPUB ICON]";
            default -> "[?]";
        };
    }

    @Override
    public void display(int x, int y) {
        // Menggabungkan Intrinsic State (Icon) dengan Extrinsic State (Koordinat)
        System.out.println("    Displaying " + heavyAsciiArt + " at screen coords (" + x + "," + y + ")");
    }
}