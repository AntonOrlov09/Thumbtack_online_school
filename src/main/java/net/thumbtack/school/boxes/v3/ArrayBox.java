package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.ClosedFigure;

public class ArrayBox<T extends ClosedFigure> {
    private T[] content;

    public ArrayBox(T[] content) {
        this.content = content;
    }

    public T[] getContent() {
        return content;
    }

    public void setContent(T[] content) {
        this.content = content;
    }

    public T getElement(int index) {
        return content[index];
    }

    public void setElement(int index, T content) {
        this.content[index] = content;
    }

    public boolean isSameSize(ArrayBox<? extends ClosedFigure> anotherArrayBox) {
        return getContent().length == anotherArrayBox.getContent().length;
    }
}
