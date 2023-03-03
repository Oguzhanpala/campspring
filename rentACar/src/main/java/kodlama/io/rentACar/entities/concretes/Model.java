package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "models")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id")
	private int id;

	@JoinColumn(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@OneToMany(mappedBy = "model")
	private List<Car> cars;
}
