package app.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visitations")
public class Visitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date visitationDate;

    @Column(columnDefinition = "TEXT")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "patient")
    private Patient patient;

    public Visitation() {
    }

    public Visitation(Date visitationDate, String comments, Patient patient) {
        this.setVisitationDate(visitationDate);
        this.setComments(comments);
        this.setPatient(patient);
    }

    public Date getVisitationDate() {
        return this.visitationDate;
    }

    public void setVisitationDate(Date visitationDate) {
        this.visitationDate = visitationDate;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}