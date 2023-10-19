package xyz.starsdust.exceldatagenerator.javafx;

import javafx.beans.value.WritableValue;
import javafx.css.StyleableProperty;
import javafx.geometry.Pos;
import javafx.scene.AccessibleRole;
import javafx.scene.control.RadioButton;

public class NoRoundRadioButton extends RadioButton {
    private static final String DEFAULT_STYLE_CLASS = "toggle-button";

    public NoRoundRadioButton() {
        initialize();
    }

    public NoRoundRadioButton(String text) {
        setText(text);
        initialize();
    }

    private void initialize() {
        getStyleClass().setAll(DEFAULT_STYLE_CLASS);
        setAccessibleRole(AccessibleRole.RADIO_BUTTON);
        ((StyleableProperty<Pos>)(WritableValue<Pos>)alignmentProperty()).applyStyle(null, Pos.CENTER);
    }

    @Override
    protected Pos getInitialAlignment() {
        return Pos.CENTER;
    }
}
