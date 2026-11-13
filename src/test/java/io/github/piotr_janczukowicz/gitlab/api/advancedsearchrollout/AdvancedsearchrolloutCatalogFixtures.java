package io.github.piotr_janczukowicz.gitlab.api.advancedsearchrollout;

public final class AdvancedsearchrolloutCatalogFixtures {

    private AdvancedsearchrolloutCatalogFixtures() {}

    public static GitLabAdvancedSearchRolloutUpdateRollbackPayload advancedSearchRolloutUpdateRollbackPayload() {
        return GitLabAdvancedSearchRolloutUpdateRollbackPayloadBuilder.builder()
                .percentage(1)
                .plan(GitLabAdvancedSearchRolloutUpdateRollbackPlan.BRONZE)
                .build();
    }

    public static GitLabAdvancedSearchRolloutUpdateRolloutPayload advancedSearchRolloutUpdateRolloutPayload() {
        return GitLabAdvancedSearchRolloutUpdateRolloutPayloadBuilder.builder()
                .percentage(1)
                .plan(GitLabAdvancedSearchRolloutUpdateRolloutPlan.BRONZE)
                .build();
    }
}
