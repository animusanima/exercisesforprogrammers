package utils;

import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class ClipboardUtils {

    public static void copyToClipBoard(String password) {
        if (!StringUtils.isEmpty(password)) {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable transferable = new StringSelection(password);
            clipboard.setContents(transferable, null);
        }
    }

}