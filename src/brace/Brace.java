package brace;

import java.util.Objects;

public class Brace {
    private char brace;
    private int index;

    public Brace(char brace, int index) {
        this.brace = brace;
        this.index = index;
    }

    public Brace() {
    }

    public char getBrace() {
        return brace;
    }

    public void setBrace(char brace) {
        this.brace = brace;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Brace brace1 = (Brace) o;
        return brace == brace1.brace && index == brace1.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brace, index);
    }

    @Override
    public String toString() {
        return "Brace{" +
                "brace=" + brace +
                ", index=" + index +
                '}';
    }
}