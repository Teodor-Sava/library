/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.helpers;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Live
 */
public class TextFieldStringValidator extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        try {
            if (text.trim().length() > 1) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
