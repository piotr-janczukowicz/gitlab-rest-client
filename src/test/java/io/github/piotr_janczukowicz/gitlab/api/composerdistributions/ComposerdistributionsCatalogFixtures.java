package io.github.piotr_janczukowicz.gitlab.api.composerdistributions;

public final class ComposerdistributionsCatalogFixtures {

    private ComposerdistributionsCatalogFixtures() {}

    public static GitLabProjectComposerDistributionsCreatePayload projectComposerDistributionsCreatePayload() {
        return GitLabProjectComposerDistributionsCreatePayloadBuilder.builder()
                .branch("release")
                .tag("v1.0.0")
                .build();
    }
}
