package school;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Indication {
    private Student indicated;
    private Student indicator;
    private LocalDateTime indicationDate;

    public Indication(Student indicated, Student indicator) {
        this.indicated = indicated;
        this.indicator = indicator;
        this.indicationDate = LocalDateTime.now();
    }

    public Student getIndicated() {
        return indicated;
    }

    public Student getIndicator() {
        return indicator;
    }

    public LocalDateTime getIndicationDate() {
        return indicationDate;
    }
}
