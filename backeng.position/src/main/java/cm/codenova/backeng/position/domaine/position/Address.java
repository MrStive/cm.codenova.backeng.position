package cm.codenova.backeng.position.domaine.position;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Setter;

@Embeddable
@Setter
public class Address {
    @Column(name = "c_street")
    private String street;
    @Column(name = "c_city")
    private String city;
    @Column(name = "c_district")
    private String district;
    @Column(name = "c_country")
    private String country;
}
