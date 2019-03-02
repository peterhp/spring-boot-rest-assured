package demo.controller.dto;

public final class MessageDto {

    private String person;
    private String message;

    public MessageDto() {

    }

    public MessageDto(String person, String message) {
        this.person = person;
        this.message = message;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
