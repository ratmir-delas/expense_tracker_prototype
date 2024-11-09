package org.example.models.assistance;

import lombok.*;
import org.example.models.user.User;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assistant extends User {

    private long assistantLevelId;

}
