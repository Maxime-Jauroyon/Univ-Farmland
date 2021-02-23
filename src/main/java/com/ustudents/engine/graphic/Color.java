package com.ustudents.engine.graphic;

import com.ustudents.engine.core.json.annotation.JsonSerializable;
import org.joml.Vector4f;

@JsonSerializable
public class Color {
    public static final Color CLEAR = new Color(0x00000000);
    public static final Color WHITE = new Color(0xFFFFFFFF);
    public static final Color BLACK = new Color(0x000000FF);
    public static final Color RED = new Color(0xFF0000FF);
    public static final Color GREEN = new Color(0x00FF00FF);
    public static final Color BLUE = new Color(0x0000FFFF);
    public static final Color LIGHT_GRAY = new Color(0xBFBFBFFF);
    public static final Color GRAY = new Color(0x7F7F7FFF);
    public static final Color DARK_GRAY = new Color(0x3F3F3FFF);
    public static final Color CYAN = new Color(0x00FFFFFF);
    public static final Color YELLOW = new Color(0xFFFF00FF);
    public static final Color MAGENTA = new Color(0xFF00FFFF);

    @JsonSerializable
    public Float r;

    @JsonSerializable
    public Float g;

    @JsonSerializable
    public Float b;

    @JsonSerializable
    public Float a;

    public Color() {
        this(0.0f, 0.0f, 0.0f, 1.0f);
    }

    public Color(float r, float g, float b) {
        this(r, g, b, 1.0f);
    }

    public Color(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Color(int rgba) {
        rgbaToColor(this, rgba);
    }

    public Color(Color color) {
        set(color);
    }

    public void set(Color color) {
        r = color.r;
        g = color.g;
        b = color.b;
        a = color.a;
    }

    public void set(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Vector4f toVector4f() {
        return new Vector4f(r, g, b, a);
    }

    public Color clone() {
        return new Color(r, g, b, a);
    }

    public static Color rgbToColor(int value) {
        Color color = new Color();
        color.r = ((value & 0xFF000000) >>> 24) / 255.0f;
        color.g = ((value & 0x00FF0000) >>> 16) / 255.0f;
        color.b = ((value & 0x0000FF00) >>> 8) / 255.0f;
        color.a = 1.0f;
        return color;
    }

    public static Color rgbaToColor(int value) {
        Color color = new Color();
        color.r = ((value & 0xFF000000) >>> 24) / 255.0f;
        color.g = ((value & 0x00FF0000) >>> 16) / 255.0f;
        color.b = ((value & 0x0000FF00) >>> 8) / 255.0f;
        color.a = ((value & 0x000000FF)) / 255.0f;
        return color;
    }

    public static void rgbaToColor(Color color, int value) {
        color.r = ((value & 0xFF000000) >>> 24) / 255.0f;
        color.g = ((value & 0x00FF0000) >>> 16) / 255.0f;
        color.b = ((value & 0x0000FF00) >>> 8) / 255.0f;
        color.a = ((value & 0x000000FF)) / 255.0f;
    }

    public boolean equals(Color color) {
        return r.floatValue() == color.r.floatValue() &&
               g.floatValue() == color.g.floatValue() &&
               b.floatValue() == color.b.floatValue() &&
               a.floatValue() == color.a.floatValue();
    }
}
