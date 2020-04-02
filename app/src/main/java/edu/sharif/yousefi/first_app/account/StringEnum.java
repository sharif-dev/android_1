package edu.sharif.yousefi.first_app.account;

enum StrnigEnum {
    incorrect_password("Password is wrong"),
    user_not_found("User not found"),
    undefine_exception("Undefine Exception"),
    username_exist("Username exist");

    private String message;

    // getter method
    public String getMessage() {
        return this.message;
    }

    private StrnigEnum(String message) {
        this.message = message;
    }
}

