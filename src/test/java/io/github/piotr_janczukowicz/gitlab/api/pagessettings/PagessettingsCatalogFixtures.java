package io.github.piotr_janczukowicz.gitlab.api.pagessettings;

public final class PagessettingsCatalogFixtures {

    private PagessettingsCatalogFixtures() {}

    public static GitLabProjectPagesSettingsUpdatePayload projectPagesSettingsUpdatePayload() {
        return GitLabProjectPagesSettingsUpdatePayloadBuilder.builder()
                .pagesUniqueDomainEnabled(true)
                .pagesHttpsOnly(true)
                .pagesPrimaryDomain("pages_primary_domain")
                .build();
    }
}
