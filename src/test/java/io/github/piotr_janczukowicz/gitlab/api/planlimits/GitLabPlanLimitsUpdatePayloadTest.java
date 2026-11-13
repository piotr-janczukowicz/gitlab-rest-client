package io.github.piotr_janczukowicz.gitlab.api.planlimits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPlanLimitsUpdatePayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenPlanNameIsNull() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .planName(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("planName");
    }

    @Test
    void constructor_shouldAcceptNull_whenCargoMaxFileSizeIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .cargoMaxFileSize(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.cargoMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiInstanceLevelVariablesIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .ciInstanceLevelVariables(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.ciInstanceLevelVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPipelineSizeIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .ciPipelineSize(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.ciPipelineSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPipelineVariablesCountIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .ciPipelineVariablesCount(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.ciPipelineVariablesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiVariableValueSizeIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .ciVariableValueSize(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.ciVariableValueSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiVariableFileValueSizeIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .ciVariableFileValueSize(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.ciVariableFileValueSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiActiveJobsIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .ciActiveJobs(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.ciActiveJobs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiProjectSubscriptionsIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .ciProjectSubscriptions(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.ciProjectSubscriptions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPipelineSchedulesIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .ciPipelineSchedules(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.ciPipelineSchedules()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiNeedsSizeLimitIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .ciNeedsSizeLimit(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.ciNeedsSizeLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiJobVariablesCountIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .ciJobVariablesCount(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.ciJobVariablesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiRegisteredGroupRunnersIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .ciRegisteredGroupRunners(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.ciRegisteredGroupRunners()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiRegisteredProjectRunnersIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .ciRegisteredProjectRunners(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.ciRegisteredProjectRunners()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConanMaxFileSizeIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .conanMaxFileSize(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.conanMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDotenvSizeIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .dotenvSize(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.dotenvSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDotenvVariablesIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .dotenvVariables(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.dotenvVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDraftNotesPerMergeRequestIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .draftNotesPerMergeRequest(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.draftNotesPerMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforcementLimitIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .enforcementLimit(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.enforcementLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGenericPackagesMaxFileSizeIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .genericPackagesMaxFileSize(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.genericPackagesMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHelmMaxFileSizeIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .helmMaxFileSize(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.helmMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMavenMaxFileSizeIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .mavenMaxFileSize(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.mavenMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotificationLimitIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .notificationLimit(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.notificationLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNpmMaxFileSizeIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .npmMaxFileSize(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.npmMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNugetMaxFileSizeIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .nugetMaxFileSize(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.nugetMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationHooksIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .organizationHooks(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.organizationHooks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPypiMaxFileSizeIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .pypiMaxFileSize(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.pypiMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceDeskOutboundEmailsPerHourIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .serviceDeskOutboundEmailsPerHour(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.serviceDeskOutboundEmailsPerHour()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceDeskOutboundEmailsPerDayIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .serviceDeskOutboundEmailsPerDay(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.serviceDeskOutboundEmailsPerDay()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSwiftMaxFileSizeIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .swiftMaxFileSize(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.swiftMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformModuleMaxFileSizeIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .terraformModuleMaxFileSize(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.terraformModuleMaxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStorageSizeLimitIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .storageSizeLimit(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.storageSizeLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineHierarchySizeIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .pipelineHierarchySize(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.pipelineHierarchySize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebHookCallsIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .webHookCalls(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.webHookCalls()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebHookCallsLowIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .webHookCallsLow(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.webHookCallsLow()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebHookCallsMidIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .webHookCallsMid(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.webHookCallsMid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIntegrationExecutionsIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .integrationExecutions(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.integrationExecutions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIntegrationExecutionsDatadogIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .integrationExecutionsDatadog(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.integrationExecutionsDatadog()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxPipelinesPerMergeTrainIsNullable() {
        final GitLabPlanLimitsUpdatePayloadBuilder builder = GitLabPlanLimitsUpdatePayloadBuilder.builder(
                        PlanlimitsCatalogFixtures.planLimitsUpdatePayload())
                .maxPipelinesPerMergeTrain(null);

        final GitLabPlanLimitsUpdatePayload built = builder.build();

        assertThat(built.maxPipelinesPerMergeTrain()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPlanLimitsUpdatePayload value = PlanlimitsCatalogFixtures.planLimitsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.planName()).isEqualTo(GitLabPlanLimitsUpdatePlanName.DEFAULT);
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
            softly.assertThat(value.dotenvSize()).isEqualTo(1L);
            softly.assertThat(value.dotenvVariables()).isEqualTo(1);
            softly.assertThat(value.draftNotesPerMergeRequest()).isEqualTo(1);
            softly.assertThat(value.enforcementLimit()).isEqualTo(1);
            softly.assertThat(value.genericPackagesMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.helmMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.mavenMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.notificationLimit()).isEqualTo(1);
            softly.assertThat(value.npmMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.nugetMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.organizationHooks()).isEqualTo(1);
            softly.assertThat(value.pypiMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.serviceDeskOutboundEmailsPerHour()).isEqualTo(1);
            softly.assertThat(value.serviceDeskOutboundEmailsPerDay()).isEqualTo(1);
            softly.assertThat(value.swiftMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.terraformModuleMaxFileSize()).isEqualTo(1L);
            softly.assertThat(value.storageSizeLimit()).isEqualTo(1);
            softly.assertThat(value.pipelineHierarchySize()).isEqualTo(1L);
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
        final GitLabPlanLimitsUpdatePayload original = PlanlimitsCatalogFixtures.planLimitsUpdatePayload();

        final GitLabPlanLimitsUpdatePayload rebuilt =
                GitLabPlanLimitsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPlanLimitsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "planName",
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
                        "dotenvSize",
                        "dotenvVariables",
                        "draftNotesPerMergeRequest",
                        "enforcementLimit",
                        "genericPackagesMaxFileSize",
                        "helmMaxFileSize",
                        "mavenMaxFileSize",
                        "notificationLimit",
                        "npmMaxFileSize",
                        "nugetMaxFileSize",
                        "organizationHooks",
                        "pypiMaxFileSize",
                        "serviceDeskOutboundEmailsPerHour",
                        "serviceDeskOutboundEmailsPerDay",
                        "swiftMaxFileSize",
                        "terraformModuleMaxFileSize",
                        "storageSizeLimit",
                        "pipelineHierarchySize",
                        "webHookCalls",
                        "webHookCallsLow",
                        "webHookCallsMid",
                        "integrationExecutions",
                        "integrationExecutionsDatadog",
                        "maxPipelinesPerMergeTrain");
    }
}
