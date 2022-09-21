package byfayzullayev.startup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question extends Base {

 @Column(columnDefinition="text")
private String content;
private String image;
private String option1;
private String option2;
private String option3;
private String option4;
private String option5;
private String answer;
 @ManyToOne
 private Quiz quiz;
}
