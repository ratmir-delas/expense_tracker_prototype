package org.example.models.admin;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import org.example.models.assistance.Assistant;

@Entity
@DiscriminatorValue("ADMIN")
@EqualsAndHashCode(callSuper = true)
@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends Assistant {

    private AdminAccessLevel adminAccessLevel;

}
