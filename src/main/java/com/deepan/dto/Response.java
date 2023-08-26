package com.deepan.dto;

public class Response {

    private String status;
    private String message;

    public Response(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

//immutable ---  won't be able to edit the status or message once the response is created
