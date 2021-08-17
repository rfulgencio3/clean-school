package school;

public class Email {
    private String description;

    public Email(String description) {
        if (description == null ||
                !description.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\"")){
            throw new IllegalArgumentException("Invalid e-mail address.");
        }
        this.description = description;
    }
}
