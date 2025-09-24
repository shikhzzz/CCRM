package edu.ccrm.domain;

public final class CourseCode {
    private final String code;

    public CourseCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    // No setter, because the object is immutable
}