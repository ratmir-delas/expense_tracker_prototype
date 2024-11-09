package org.example.models.admin;

import lombok.*;
import org.example.models.assistance.Assistant;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends Assistant {

    private AdminAccessLevel adminAccessLevel;

}
