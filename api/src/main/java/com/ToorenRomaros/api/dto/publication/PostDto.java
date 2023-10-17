package com.ToorenRomaros.api.dto.publication;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

public class PostDto {
    private UUID id;
    @FutureOrPresent(message = "Publication date can not be past")
    private LocalDateTime publicationDateTime;
    @Min(value = 0, message = "Like count can not be negative")
    private int likeCount;
    @NotNull(message = "Tittle can not be null")
    private String tittle;
    @NotNull(message = "Synthesis can not be null")
    private String synthesis;
//    private @blob body;
    private String userId;
    private String postId;
}
