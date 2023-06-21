package com.travel.travtronics.response;

import java.util.Map;

import lombok.Data;

@Data
public class APIResponseObject {
    private int status;
    private String message;
    private Map<String, Object> data;

    public APIResponseObject(int status, String message, Map<String, Object> responseData) {
        this.status = status;
        this.message = message;
        this.data = responseData;
    }

	public APIResponseObject(int value, String message2, Object responseData) {
		// TODO Auto-generated constructor stub
	}

    // Getters and setters

    // Other methods as needed
}

