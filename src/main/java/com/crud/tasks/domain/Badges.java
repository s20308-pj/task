package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Badges {
    @JsonProperty("vote")
    private int vote;
    @JsonProperty("attachmentsByType")
    private AttachmentsByType attachment;
}
