
package com.proyecto.portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
