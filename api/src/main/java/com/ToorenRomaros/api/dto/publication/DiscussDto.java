package com.ToorenRomaros.api.dto.publication;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

public class DiscussDto {
    private UUID id;
    @NotNull(message = "Body can not be null")
    private String body;
    @FutureOrPresent(message = "Publication date can not be past")
    private LocalDateTime publicationDateTime;
    @Min(value = 0, message = "Like count can not be negative")
    private String likeCount;
    private boolean reported;
    private String userId;
    private String postId;
}
