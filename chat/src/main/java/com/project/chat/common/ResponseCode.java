package com.project.chat.common;

public interface ResponseCode {

    // 200
    String SUCCESS = "SU";

    //
    String VALIDATION_FAIL = "VF";
    String DUPLICATE_ID = "DI";

    // 401
    String SIGN_IN_FAIL = "SF";
    String CERTIFICATION_FAIL = "CF";

    // Mail Fail error
    String MESSAGE_FAILED = "MF";

    // DB error
    String DATABASE_ERROR = "DBE";

}
