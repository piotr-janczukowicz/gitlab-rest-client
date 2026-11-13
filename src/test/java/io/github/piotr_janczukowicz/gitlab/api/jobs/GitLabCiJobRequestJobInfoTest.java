package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobRequestJobInfoTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .id(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .name(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStageIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .stage(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.stage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagListIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .tagList(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.tagList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineIdIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .pipelineId(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.pipelineId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .projectId(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectNameIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .projectName(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.projectName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectFullPathIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .projectFullPath(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.projectFullPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIdIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .namespaceId(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.namespaceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRootNamespaceIdIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .rootNamespaceId(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.rootNamespaceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationIdIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .organizationId(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.organizationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInstanceIdIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .instanceId(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.instanceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInstanceUuidIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .instanceUuid(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.instanceUuid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .userId(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopedUserIdIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .scopedUserId(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.scopedUserId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeInQueueSecondsIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .timeInQueueSeconds(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.timeInQueueSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectJobsRunningOnInstanceRunnersCountIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .projectJobsRunningOnInstanceRunnersCount(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.projectJobsRunningOnInstanceRunnersCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenQueueSizeIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .queueSize(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.queueSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenQueueDepthIsNullable() {
        final GitLabCiJobRequestJobInfoBuilder builder = GitLabCiJobRequestJobInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestJobInfo())
                .queueDepth(null);

        final GitLabCiJobRequestJobInfo built = builder.build();

        assertThat(built.queueDepth()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobRequestJobInfo value = JobsCatalogFixtures.ciJobRequestJobInfo();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo("id");
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.stage()).isEqualTo("stage");
            softly.assertThat(value.tagList()).isEqualTo(List.of("docker"));
            softly.assertThat(value.pipelineId()).isEqualTo("pipeline_id");
            softly.assertThat(value.projectId()).isEqualTo("project_id");
            softly.assertThat(value.projectName()).isEqualTo("project_name");
            softly.assertThat(value.projectFullPath()).isEqualTo("project_full_path");
            softly.assertThat(value.namespaceId()).isEqualTo("namespace_id");
            softly.assertThat(value.rootNamespaceId()).isEqualTo("root_namespace_id");
            softly.assertThat(value.organizationId()).isEqualTo("organization_id");
            softly.assertThat(value.instanceId()).isEqualTo("instance_id");
            softly.assertThat(value.instanceUuid()).isEqualTo("instance_uuid");
            softly.assertThat(value.userId()).isEqualTo("user_id");
            softly.assertThat(value.scopedUserId()).isEqualTo("scoped_user_id");
            softly.assertThat(value.timeInQueueSeconds()).isEqualTo("time_in_queue_seconds");
            softly.assertThat(value.projectJobsRunningOnInstanceRunnersCount())
                    .isEqualTo("project_jobs_running_on_instance_runners_count");
            softly.assertThat(value.queueSize()).isEqualTo("queue_size");
            softly.assertThat(value.queueDepth()).isEqualTo("queue_depth");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobRequestJobInfo original = JobsCatalogFixtures.ciJobRequestJobInfo();

        final GitLabCiJobRequestJobInfo rebuilt =
                GitLabCiJobRequestJobInfoBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobRequestJobInfo.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "name",
                        "stage",
                        "tagList",
                        "pipelineId",
                        "projectId",
                        "projectName",
                        "projectFullPath",
                        "namespaceId",
                        "rootNamespaceId",
                        "organizationId",
                        "instanceId",
                        "instanceUuid",
                        "userId",
                        "scopedUserId",
                        "timeInQueueSeconds",
                        "projectJobsRunningOnInstanceRunnersCount",
                        "queueSize",
                        "queueDepth");
    }
}
