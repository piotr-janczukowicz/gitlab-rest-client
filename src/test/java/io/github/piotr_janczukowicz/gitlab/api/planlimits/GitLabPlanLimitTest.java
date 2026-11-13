package io.github.piotr_janczukowicz.gitlab.api.planlimits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPlanLimitTest {

    @Test
    void constructor_shouldAcceptNull_whenCargoMaxFileSizeIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .cargoMaxFileSize(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.cargoMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiInstanceLevelVariablesIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .ciInstanceLevelVariables(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.ciInstanceLevelVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPipelineSizeIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .ciPipelineSize(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.ciPipelineSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPipelineVariablesCountIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .ciPipelineVariablesCount(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.ciPipelineVariablesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiVariableValueSizeIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .ciVariableValueSize(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.ciVariableValueSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiVariableFileValueSizeIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .ciVariableFileValueSize(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.ciVariableFileValueSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiActiveJobsIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .ciActiveJobs(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.ciActiveJobs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiProjectSubscriptionsIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .ciProjectSubscriptions(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.ciProjectSubscriptions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPipelineSchedulesIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .ciPipelineSchedules(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.ciPipelineSchedules()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiNeedsSizeLimitIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .ciNeedsSizeLimit(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.ciNeedsSizeLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiJobVariablesCountIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .ciJobVariablesCount(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.ciJobVariablesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiRegisteredGroupRunnersIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .ciRegisteredGroupRunners(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.ciRegisteredGroupRunners()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiRegisteredProjectRunnersIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .ciRegisteredProjectRunners(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.ciRegisteredProjectRunners()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConanMaxFileSizeIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .conanMaxFileSize(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.conanMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDotenvVariablesIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .dotenvVariables(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.dotenvVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDotenvSizeIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .dotenvSize(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.dotenvSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDraftNotesPerMergeRequestIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .draftNotesPerMergeRequest(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.draftNotesPerMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforcementLimitIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .enforcementLimit(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.enforcementLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGenericPackagesMaxFileSizeIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .genericPackagesMaxFileSize(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.genericPackagesMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHelmMaxFileSizeIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .helmMaxFileSize(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.helmMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLimitsHistoryIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .limitsHistory(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.limitsHistory()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMavenMaxFileSizeIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .mavenMaxFileSize(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.mavenMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotificationLimitIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .notificationLimit(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.notificationLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNpmMaxFileSizeIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .npmMaxFileSize(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.npmMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNugetMaxFileSizeIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .nugetMaxFileSize(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.nugetMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationHooksIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .organizationHooks(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.organizationHooks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineHierarchySizeIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .pipelineHierarchySize(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.pipelineHierarchySize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPypiMaxFileSizeIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .pypiMaxFileSize(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.pypiMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceDeskOutboundEmailsPerHourIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .serviceDeskOutboundEmailsPerHour(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.serviceDeskOutboundEmailsPerHour()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceDeskOutboundEmailsPerDayIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .serviceDeskOutboundEmailsPerDay(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.serviceDeskOutboundEmailsPerDay()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSwiftMaxFileSizeIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .swiftMaxFileSize(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.swiftMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformModuleMaxFileSizeIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .terraformModuleMaxFileSize(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.terraformModuleMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStorageSizeLimitIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .storageSizeLimit(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.storageSizeLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebHookCallsIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .webHookCalls(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.webHookCalls()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebHookCallsLowIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .webHookCallsLow(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.webHookCallsLow()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebHookCallsMidIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .webHookCallsMid(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.webHookCallsMid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIntegrationExecutionsIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .integrationExecutions(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.integrationExecutions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIntegrationExecutionsDatadogIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .integrationExecutionsDatadog(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.integrationExecutionsDatadog()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxPipelinesPerMergeTrainIsNullable() {
        final GitLabPlanLimitBuilder builder = GitLabPlanLimitBuilder.builder(PlanlimitsCatalogFixtures.planLimit())
                .maxPipelinesPerMergeTrain(null);

        final GitLabPlanLimit built = builder.build();

        assertThat(built.maxPipelinesPerMergeTrain()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPlanLimit value = PlanlimitsCatalogFixtures.planLimit();

        assertSoftly(softly -> {
            softly.assertThat(value.cargoMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.ciInstanceLevelVariables()).isEqualTo(1);
            softly.assertThat(value.ciPipelineSize()).isEqualTo(1L);
            softly.assertThat(value.ciPipelineVariablesCount()).isEqualTo(1);
            softly.assertThat(value.ciVariableValueSize()).isEqualTo(1L);
            softly.assertThat(value.ciVariableFileValueSize()).isEqualTo(1L);
            softly.assertThat(value.ciActiveJobs()).isEqualTo(1);
            softly.assertThat(value.ciProjectSubscriptions()).isEqualTo(1);
            softly.assertThat(value.ciPipelineSchedules()).isEqualTo(1);
            softly.assertThat(value.ciNeedsSizeLimit()).isEqualTo(1);
            softly.assertThat(value.ciJobVariablesCount()).isEqualTo(1);
            softly.assertThat(value.ciRegisteredGroupRunners()).isEqualTo(1);
            softly.assertThat(value.ciRegisteredProjectRunners()).isEqualTo(1);
            softly.assertThat(value.conanMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.dotenvVariables()).isEqualTo(1);
            softly.assertThat(value.dotenvSize()).isEqualTo(1L);
            softly.assertThat(value.draftNotesPerMergeRequest()).isEqualTo(1);
            softly.assertThat(value.enforcementLimit()).isEqualTo(1);
            softly.assertThat(value.genericPackagesMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.helmMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.limitsHistory()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.mavenMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.notificationLimit()).isEqualTo(1);
            softly.assertThat(value.npmMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.nugetMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.organizationHooks()).isEqualTo(1);
            softly.assertThat(value.pipelineHierarchySize()).isEqualTo(1L);
            softly.assertThat(value.pypiMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.serviceDeskOutboundEmailsPerHour()).isEqualTo(1);
            softly.assertThat(value.serviceDeskOutboundEmailsPerDay()).isEqualTo(1);
            softly.assertThat(value.swiftMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.terraformModuleMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.storageSizeLimit()).isEqualTo(1);
            softly.assertThat(value.webHookCalls()).isEqualTo(1);
            softly.assertThat(value.webHookCallsLow()).isEqualTo(1);
            softly.assertThat(value.webHookCallsMid()).isEqualTo(1);
            softly.assertThat(value.integrationExecutions()).isEqualTo(1);
            softly.assertThat(value.integrationExecutionsDatadog()).isEqualTo(1);
            softly.assertThat(value.maxPipelinesPerMergeTrain()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPlanLimit original = PlanlimitsCatalogFixtures.planLimit();

        final GitLabPlanLimit rebuilt = GitLabPlanLimitBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPlanLimit.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "cargoMaxFileSize",
                        "ciInstanceLevelVariables",
                        "ciPipelineSize",
                        "ciPipelineVariablesCount",
                        "ciVariableValueSize",
                        "ciVariableFileValueSize",
                        "ciActiveJobs",
                        "ciProjectSubscriptions",
                        "ciPipelineSchedules",
                        "ciNeedsSizeLimit",
                        "ciJobVariablesCount",
                        "ciRegisteredGroupRunners",
                        "ciRegisteredProjectRunners",
                        "conanMaxFileSize",
                        "dotenvVariables",
                        "dotenvSize",
                        "draftNotesPerMergeRequest",
                        "enforcementLimit",
                        "genericPackagesMaxFileSize",
                        "helmMaxFileSize",
                        "limitsHistory",
                        "mavenMaxFileSize",
                        "notificationLimit",
                        "npmMaxFileSize",
                        "nugetMaxFileSize",
                        "organizationHooks",
                        "pipelineHierarchySize",
                        "pypiMaxFileSize",
                        "serviceDeskOutboundEmailsPerHour",
                        "serviceDeskOutboundEmailsPerDay",
                        "swiftMaxFileSize",
                        "terraformModuleMaxFileSize",
                        "storageSizeLimit",
                        "webHookCalls",
                        "webHookCallsLow",
                        "webHookCallsMid",
                        "integrationExecutions",
                        "integrationExecutionsDatadog",
                        "maxPipelinesPerMergeTrain");
    }
}
