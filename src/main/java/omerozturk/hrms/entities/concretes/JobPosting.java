package omerozturk.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import omerozturk.hrms.entities.enums.PlaceOfWorking;
import omerozturk.hrms.entities.enums.WayOfWorking;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="JobPostings")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "jobDescription")
	private String jobDescription;

	@Column(name = "minSalary")
	private double minSalary;

	@Column(name = "maxSalary")
	private double maxSalary;

	@Column(name = "openPositionCount")
	private int openPositionCount;

	@Column(name = "applicationDeadline")
	private LocalDate applicationDeadline;

	@Column(name = "releaseDate")
	private LocalDate releaseDate;

	@Column(name="wayOfWorking")
	private WayOfWorking wayOfWorking;

	@Column(name="placeOfWorking")
	private PlaceOfWorking placeOfWorking;

	@Column(name = "status")
	private boolean status;

	@Column(name="verifiedBySystem")
	private boolean verifiedBySystem;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

}