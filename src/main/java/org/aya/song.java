package org.aya;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class song {
    private Integer songId;
    private String songName;
    private String singerName;
}
