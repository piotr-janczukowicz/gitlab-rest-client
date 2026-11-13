package io.github.piotr_janczukowicz.gitlab.api.tags;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.Map;

public final class TagsCatalogFixtures {

    private TagsCatalogFixtures() {}

    public static GitLabProjectTagsCreatePayload projectTagsCreatePayload() {
        return GitLabProjectTagsCreatePayloadBuilder.builder()
                .tagName("v.1.0.0")
                .ref("2695effb5807a22ff3d138d593fd856244e155e7")
                .message("Release 1.0.0")
                .build();
    }

    public static GitLabTag tag() {
        return GitLabTagBuilder.builder()
                .name("v1.0.0")
                .message("Release v1.0.0")
                .target("2695effb5807a22ff3d138d593fd856244e155e7")
                .commit(CommonCatalogFixtures.commit())
                .release(TagsCatalogFixtures.tagRelease())
                .protectedValue(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabTagRelease tagRelease() {
        return GitLabTagReleaseBuilder.builder()
                .tagName("1.0.0")
                .description("Amazing release. Wow")
                .build();
    }

    public static GitLabTagSignature tagSignature() {
        return GitLabTagSignatureBuilder.builder()
                .signatureType("PGP")
                .signature(Map.of("key", "value"))
                .build();
    }
}
