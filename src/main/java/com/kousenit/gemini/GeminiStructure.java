package com.kousenit.gemini;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

public class GeminiStructure {

    public record GeminiRequest(List<Content> contents) {
    }

    public record Content(List<Part> parts) {
    }

    public sealed interface Part
            permits TextPart, InlineDataPart {
    }

    public record TextPart(String text) implements Part {
    }

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public record InlineDataPart(InlineData inlineData) implements Part {
    }

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public record InlineData(String mimeType, String data) {
    }
}
