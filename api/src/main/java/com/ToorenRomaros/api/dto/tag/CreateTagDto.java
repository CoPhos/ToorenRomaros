package com.ToorenRomaros.api.dto.tag;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public class CreateTagDto {
    @Size(max = 36, message = "max size is 36 characters")
    @NotNull(message = "Tag name can not be null")
    private String tag;
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
}
