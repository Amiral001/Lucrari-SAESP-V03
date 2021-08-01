package com.nicholas.utils;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class FixedJComboBox<E>
        extends JComboBox<E> {
    // Copied constructors
    public FixedJComboBox() {
        super();
    }

    public FixedJComboBox(ComboBoxModel<E> aModel) {
        super(aModel);
    }

    public FixedJComboBox(E[] items) {
        super(items);
    }

    public FixedJComboBox(Vector<E> items) {
        super(items);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);

        // The arrow is the first (and only) component
        // that is added by default
        Component[] comps = getComponents();
        if (comps != null && comps.length >= 1) {
            Component arrow = comps[0];
            // 20 is the default width of the arrow (for me at least)
            arrow.setSize(20, height);
            arrow.setLocation(width - arrow.getWidth(), 0);
        }
    }
}