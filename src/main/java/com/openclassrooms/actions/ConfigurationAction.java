package com.openclassrooms.actions;

import com.openclassrooms.biblioback.ws.test.BorrowingExtendRequest;
import com.openclassrooms.config.PropSource;
import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConfigurationAction extends ActionSupport {

    int BorrowingId;
    String extensionDuration;
    String borrowingDuration;


    PropSource propSource = new PropSource();
    //Properties props = propSource.getProp();

    public String execute() {
        propSource.getProp();
        return SUCCESS;
    }

    public String changeConfig() {
        propSource.setProp(extensionDuration,borrowingDuration);
        return SUCCESS;
    }

    public int getBorrowingId() {
        return BorrowingId;
    }

    public void setBorrowingId(int borrowingId) {
        BorrowingId = borrowingId;
    }

    public String getExtensionDuration() {
        return extensionDuration;
    }

    public void setExtensionDuration(String extensionDuration) {
        this.extensionDuration = extensionDuration;
    }

    public String getBorrowingDuration() {
        return borrowingDuration;
    }

    public void setBorrowingDuration(String borrowingDuration) {
        this.borrowingDuration = borrowingDuration;
    }
}
