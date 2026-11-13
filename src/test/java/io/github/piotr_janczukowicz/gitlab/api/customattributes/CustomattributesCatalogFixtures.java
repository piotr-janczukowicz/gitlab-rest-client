package io.github.piotr_janczukowicz.gitlab.api.customattributes;

public final class CustomattributesCatalogFixtures {

    private CustomattributesCatalogFixtures() {}

    public static GitLabGroupCustomAttributesUpdatePayload groupCustomAttributesUpdatePayload() {
        return GitLabGroupCustomAttributesUpdatePayloadBuilder.builder()
                .value("value")
                .build();
    }

    public static GitLabInstanceCustomAttributesUpdatePayload instanceCustomAttributesUpdatePayload() {
        return GitLabInstanceCustomAttributesUpdatePayloadBuilder.builder()
                .value("value")
                .build();
    }

    public static GitLabProjectCustomAttributesUpdatePayload projectCustomAttributesUpdatePayload() {
        return GitLabProjectCustomAttributesUpdatePayloadBuilder.builder()
                .value("value")
                .build();
    }
}
