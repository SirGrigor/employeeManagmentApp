package tech.ilgrig.employeemanagmentapp.exception;

public class EmployeeAppErrorMessage {
    public enum Message {
        USER_WITH_USERNAME_ALREADY_EXISTS("user with email: %s, already exists"),
        USER_EMAIL_NOT_VALID_SEMANTICALLY("this email: %s, is not semantically valid"),
        USER_NOT_FOUND_BY_USERNAME("User with email: %s, not found"),
        USER_NOT_FOUND_BY_ID("User with id:%d, is not found in db"),
        USER_ALREADY_EXISTS("User with email: %s, already exists"),
        FAILED_TO_SEND_EMAIL_ERROR("Failed to send email with the following error:"),
        FAILED_TO_SEND_EMAIL("Failed to send email");

        private String messageText;

        Message(String text) {
            this.messageText = text;
        }

        public String getMessageText() {
            return this.messageText;
        }
    }

    public static String getMessage(Message message, String name) {
        return String.format(message.getMessageText(), name);
    }

    public static String getMessage(Message message, Long name) {
        return String.format(message.getMessageText(), name);
    }

    public static String getMessage(Message message, EmployeeAppErrorMessage error) {
        return String.format(message.getMessageText(), error);
    }

    public static String getMessage(Message message) {
        return String.format(message.getMessageText());
    }
}
