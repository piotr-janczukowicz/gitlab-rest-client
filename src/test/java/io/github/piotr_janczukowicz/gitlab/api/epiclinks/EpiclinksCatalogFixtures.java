package io.github.piotr_janczukowicz.gitlab.api.epiclinks;

public final class EpiclinksCatalogFixtures {

    private EpiclinksCatalogFixtures() {}

    public static GitLabGroupEpicLinksCreatePayload groupEpicLinksCreatePayload() {
        return GitLabGroupEpicLinksCreatePayloadBuilder.builder()
                .title("Epic title")
                .confidential(true)
                .build();
    }

    public static GitLabGroupEpicLinksUpdatePayload groupEpicLinksUpdatePayload() {
        return GitLabGroupEpicLinksUpdatePayloadBuilder.builder()
                .moveBeforeId(1L)
                .moveAfterId(1L)
                .build();
    }
}
