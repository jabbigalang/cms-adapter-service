package com.chrisen.cms.exception;

public class CmsRecordNotFoundException extends RuntimeException {
    public CmsRecordNotFoundException () {
        super();
    }

    public CmsRecordNotFoundException(String message) {
        super(message);
    }
}
