package fr.istv.bug_tracking.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Bug {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private int id;
    private String title;
    private String description;
    private String priority;
    private String advancement;
    @ManyToOne
    private Developper dev;
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
}
