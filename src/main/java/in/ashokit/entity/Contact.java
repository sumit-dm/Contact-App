package in.ashokit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CONTACT_DTLS")
@Data
public class Contact {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "CONTACT_ID")
	    private Integer contactId;

	    @Column(name = "CONTACT_NAME")
	    private String contactName;

	    @Column(name = "CONTACT_EMAIL")
	    private String contactEmail;

	    @Column(name = "CONTACT_NUMBER")
	    private Long contactNumber;

	    @Column(name = "ACTIVE_SW")
	    private Character activeSwitch;

	    @Column(name = "CREATED_DATE", updatable = false) //col. should not be updated.
	    @CreationTimestamp
	    private LocalDate createdDate;

	    @Column(name = "UPDATED_DATE", insertable = false) //not able to insert manually.
	    @UpdateTimestamp
	    private LocalDate updatedDate;
}
