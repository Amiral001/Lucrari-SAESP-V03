package com.nicholas.utils;

import javax.swing.*;
import java.awt.*;

public class ModifiableJOptionPane extends JOptionPane {

    private boolean resizable;

    public ModifiableJOptionPane() {
        super();
    }

    /**
     * @param message
     */
    public ModifiableJOptionPane(Object message) {
        super(message);
    }

    /**
     * @param message
     * @param messageType
     */
    public ModifiableJOptionPane(Object message, int messageType) {
        super(message, messageType);
    }

    /**
     * @param message
     * @param messageType
     * @param optionType
     */
    public ModifiableJOptionPane(Object message, int messageType, int optionType) {
        super(message, messageType, optionType);
    }

    /**
     * @param message
     * @param messageType
     * @param optionType
     * @param icon
     */
    public ModifiableJOptionPane(Object message, int messageType, int optionType,
                                 Icon icon) {
        super(message, messageType, optionType, icon);
    }

    /**
     * @param message
     * @param messageType
     * @param optionType
     * @param icon
     * @param options
     */
    public ModifiableJOptionPane(Object message, int messageType, int optionType,
                                 Icon icon, Object[] options) {
        super(message, messageType, optionType, icon, options);
    }

    /**
     * @param message
     * @param messageType
     * @param optionType
     * @param icon
     * @param options
     * @param initialValue
     */
    public ModifiableJOptionPane(Object message, int messageType, int optionType,
                                 Icon icon, Object[] options, Object initialValue) {
        super(message, messageType, optionType, icon, options, initialValue);
    }


    /**
     * @see javax.swing.JOptionPane#createDialog(java.awt.Component, java.lang.String)
     */
    public JDialog createDialog(Component parentComponent, String title)
            throws HeadlessException {
        JDialog dialog = super.createDialog(parentComponent, title);
        dialog.setResizable(isResizable());
        return dialog;
    }


    /**
     * @see javax.swing.JOptionPane#createInternalFrame(java.awt.Component, java.lang.String)
     */
    public JInternalFrame createInternalFrame(Component parentComponent,
                                              String title) {
        JInternalFrame frame = super.createInternalFrame(parentComponent, title);
        frame.setResizable(isResizable());
        return frame;
    }

    public void setResizable(boolean b) {
        this.resizable = b;
    }

    public boolean isResizable() {
        return resizable;
    }

}
