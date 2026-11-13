package io.github.piotr_janczukowicz.gitlab.api.resourcestateevents;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabResourceStateEventTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabResourceStateEventBuilder builder = GitLabResourceStateEventBuilder.builder(
                        ResourcestateeventsCatalogFixtures.resourceStateEvent())
                .id(null);

        final GitLabResourceStateEvent built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabResourceStateEventBuilder builder = GitLabResourceStateEventBuilder.builder(
                        ResourcestateeventsCatalogFixtures.resourceStateEvent())
                .user(null);

        final GitLabResourceStateEvent built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabResourceStateEventBuilder builder = GitLabResourceStateEventBuilder.builder(
                        ResourcestateeventsCatalogFixtures.resourceStateEvent())
                .createdAt(null);

        final GitLabResourceStateEvent built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceTypeIsNullable() {
        final GitLabResourceStateEventBuilder builder = GitLabResourceStateEventBuilder.builder(
                        ResourcestateeventsCatalogFixtures.resourceStateEvent())
                .resourceType(null);

        final GitLabResourceStateEvent built = builder.build();

        assertThat(built.resourceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceIdIsNullable() {
        final GitLabResourceStateEventBuilder builder = GitLabResourceStateEventBuilder.builder(
                        ResourcestateeventsCatalogFixtures.resourceStateEvent())
                .resourceId(null);

        final GitLabResourceStateEvent built = builder.build();

        assertThat(built.resourceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceCommitIsNullable() {
        final GitLabResourceStateEventBuilder builder = GitLabResourceStateEventBuilder.builder(
                        ResourcestateeventsCatalogFixtures.resourceStateEvent())
                .sourceCommit(null);

        final GitLabResourceStateEvent built = builder.build();

        assertThat(built.sourceCommit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceMergeRequestIdIsNullable() {
        final GitLabResourceStateEventBuilder builder = GitLabResourceStateEventBuilder.builder(
                        ResourcestateeventsCatalogFixtures.resourceStateEvent())
                .sourceMergeRequestId(null);

        final GitLabResourceStateEvent built = builder.build();

        assertThat(built.sourceMergeRequestId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabResourceStateEventBuilder builder = GitLabResourceStateEventBuilder.builder(
                        ResourcestateeventsCatalogFixtures.resourceStateEvent())
                .state(null);

        final GitLabResourceStateEvent built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabResourceStateEvent value = ResourcestateeventsCatalogFixtures.resourceStateEvent();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.resourceType()).isEqualTo("Issue");
            softly.assertThat(value.resourceId()).isEqualTo(1L);
            softly.assertThat(value.sourceCommit()).isEqualTo("7b09ce7e6f80347baf0316c8c94cdba9a0a7e91d");
            softly.assertThat(value.sourceMergeRequestId()).isEqualTo(1L);
            softly.assertThat(value.state()).isEqualTo("opened");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabResourceStateEvent original = ResourcestateeventsCatalogFixtures.resourceStateEvent();

        final GitLabResourceStateEvent rebuilt =
                GitLabResourceStateEventBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabResourceStateEvent.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "user",
                        "createdAt",
                        "resourceType",
                        "resourceId",
                        "sourceCommit",
                        "sourceMergeRequestId",
                        "state");
    }
}
