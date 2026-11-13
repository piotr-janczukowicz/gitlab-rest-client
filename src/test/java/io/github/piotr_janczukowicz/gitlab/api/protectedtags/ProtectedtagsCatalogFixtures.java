package io.github.piotr_janczukowicz.gitlab.api.protectedtags;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.util.List;
import java.util.Map;

public final class ProtectedtagsCatalogFixtures {

    private ProtectedtagsCatalogFixtures() {}

    public static GitLabProjectProtectedTagsCreatePayload projectProtectedTagsCreatePayload() {
        return GitLabProjectProtectedTagsCreatePayloadBuilder.builder()
                .name("release-1-0")
                .createAccessLevel(GitLabProjectProtectedTagsCreateAccessLevel.DEVELOPER)
                .allowedToCreate(List.of(Map.of("key", "value")))
                .build();
    }

    public static GitLabProtectedTag protectedTag() {
        return GitLabProtectedTagBuilder.builder()
                .name("release-1-0")
                .createAccessLevels(List.of(CommonCatalogFixtures.protectedRefAccess()))
                .build();
    }
}
