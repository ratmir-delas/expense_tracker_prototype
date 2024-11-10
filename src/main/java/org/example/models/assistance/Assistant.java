package org.example.models.assistance;

import jakarta.persistence.*;
import lombok.*;
import org.example.models.user.User;

@Entity
@DiscriminatorValue("ASSISTANT")
@EqualsAndHashCode(callSuper = true)
@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Assistant extends User {

    @ManyToOne
    private AssistantLevel assistantLevel;

}
