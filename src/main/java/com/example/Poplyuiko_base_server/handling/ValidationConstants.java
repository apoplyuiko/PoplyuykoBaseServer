package com.example.Poplyuiko_base_server.handling;

public interface ValidationConstants {
    String USERNAME_SIZE_NOT_VALID = "Username size should be between 3 and 25";

    String NEWS_DESCRIPTION_SIZE_NOT_VALID = "News description size should be between 3 and 130";

    String NEWS_DESCRIPTION_HAS_TO_BE_PRESENT = "News description mustn't be null";

    String ID_MUST_BE_POSITIVE = "ID must be greater than zero";

    String REQUIRED_INT_PARAM_PAGE_IS_NOT_PRESENT = "Parameter page mustn't be null";

    String REQUIRED_INT_PARAM_PER_PAGE_IS_NOT_PRESENT = "Parameter perPage mustn't be null";

    String USERNAME_HAS_TO_BE_PRESENT = "Username mustn't be null";

    String TAGS_NOT_VALID = "Tags invalid";

    String NEWS_IMAGE_HAS_TO_BE_PRESENT = "Image mustn't be null";

    String USER_WITH_THIS_EMAIL_ALREADY_EXIST = "User with this email already exists";

    String USER_PASSWORD_NOT_VALID = "User password should be more than 6 symbols";

    String USER_AVATAR_NOT_NULL = "User avatar mustn't be null";

    String USER_AVATAR_NOT_VALID = "User avatar should be between 3 and 130";

    String MAX_UPLOAD_SIZE_EXCEEDED = "Maximum upload size exceeded";

    String PER_PAGE_MAX_NOT_VALID = "perPage must be less or equal to 100";

    String PER_PAGE_MIN_NOT_VALID = "perPage must be greater or equal to 1";

    String PAGE_SIZE_NOT_VALID = "news page must be greater or equal to 1";

    String USER_EMAIL_NOT_VALID = "User email must be a well-formed email address";

    String PARAM_PER_PAGE_NOT_NULL = "Required Integer parameter 'perPage' is not present";

    String PARAM_PAGE_NOT_NULL = "Required Integer parameter 'page' is not present";

    String NEWS_TITLE_NOT_NULL = "Title has to be present";

    String NEWS_TITLE_SIZE = "News title size not valid";

    String USER_ROLE_NOT_VALID = "User role should be between 3 and 25";

    String USER_PASSWORD_NULL = "User password must be null";

    String USER_EMAIL_NOT_NULL = "User email mustn't be null";

    String ROLE_SIZE_NOT_VALID = "Role size not valid";

    String EMAIL_SIZE_NOT_VALID = "Email size not valid";

    String TOKEN_NOT_PROVIDED = "JWT token not provided";

    String USER_ID_NULL = "User id must be null";

    String USERNAME_NULL = "Username must be null";

    String USER_ROLE_NULL = "User role must be null";

    String TOKEN_POSITION_MISMATCH = "Token must be in authorization header";

    String NEWS_IMAGE_LENGTH = "Image link length should be between 3 and 130";

    String NEWS_ID_NULL = "News id must be null";

    String PASSWORD_NOT_VALID = "Password not valid";

    String USER_NAME_HAS_TO_BE_PRESENT = "User name has to be present";

    String TODO_TEXT_NOT_NULL = "Todo text not null";

    String TODO_TEXT_SIZE_NOT_VALID = "Size not valid";

    String TODO_STATUS_NOT_NULL = "Todo status not null";

    String TASK_NOT_FOUND = "Task not found";

    String TASK_PATCH_UPDATED_NOT_CORRECT_COUNT = "Task patch updated not correct count";

    String TASKS_PAGE_GREATER_OR_EQUAL_1 = "Task page greater or equal 1";

    String TASKS_PER_PAGE_GREATER_OR_EQUAL_1 = "Tasks per page greater or equal 1";

    String TASKS_PER_PAGE_LESS_OR_EQUAL_100 = "Tasks per page less or equal 100";

    String HTTP_MESSAGE_NOT_READABLE_EXCEPTION = "Http request not valid";

    private void exampleMethod() {

    }
}
