package com.library.LMS.Payload;

public enum Status{

    SUCCESS(200),
    CREATED(201),
    BAD_REQUEST(400),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500), FAILURE(204);
 private final int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
