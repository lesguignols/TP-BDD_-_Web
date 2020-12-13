package fr.istv.bug_tracking.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Developper {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private int id;
    private String name;
    private String firstName;
    @OneToMany
    private List<Bug> bugs;
}
