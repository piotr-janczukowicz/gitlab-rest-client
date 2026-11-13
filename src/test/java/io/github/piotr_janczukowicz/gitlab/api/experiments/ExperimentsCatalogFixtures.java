package io.github.piotr_janczukowicz.gitlab.api.experiments;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.util.List;
import java.util.Map;

public final class ExperimentsCatalogFixtures {

    private ExperimentsCatalogFixtures() {}

    public static GitLabExperiment experiment() {
        return GitLabExperimentBuilder.builder()
                .key("code_quality_walkthrough")
                .context(List.of("user"))
                .definition(CommonCatalogFixtures.featureDefinition())
                .currentStatus(ExperimentsCatalogFixtures.experimentCurrentStatus())
                .build();
    }

    public static GitLabExperimentAssignment experimentAssignment() {
        return GitLabExperimentAssignmentBuilder.builder()
                .experiment("lightweight_trial_registration_redesign")
                .variant("candidate")
                .contextKey("abc123def456")
                .cached(true)
                .build();
    }

    public static GitLabExperimentCurrentStatus experimentCurrentStatus() {
        return GitLabExperimentCurrentStatusBuilder.builder()
                .state("on")
                .gates(CommonCatalogFixtures.featureGate())
                .build();
    }

    public static GitLabExperimentsCreateAssignmentPayload experimentsCreateAssignmentPayload() {
        return GitLabExperimentsCreateAssignmentPayloadBuilder.builder()
                .variant("variant")
                .context(Map.of("key", "value"))
                .build();
    }
}
