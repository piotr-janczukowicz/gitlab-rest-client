package io.github.piotr_janczukowicz.gitlab.api.mergetrains;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestSimpleTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMergeRequestSimpleBuilder builder = GitLabMergeRequestSimpleBuilder.builder(
                        MergetrainsCatalogFixtures.mergeRequestSimple())
                .id(null);

        final GitLabMergeRequestSimple built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabMergeRequestSimpleBuilder builder = GitLabMergeRequestSimpleBuilder.builder(
                        MergetrainsCatalogFixtures.mergeRequestSimple())
                .iid(null);

        final GitLabMergeRequestSimple built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabMergeRequestSimpleBuilder builder = GitLabMergeRequestSimpleBuilder.builder(
                        MergetrainsCatalogFixtures.mergeRequestSimple())
                .projectId(null);

        final GitLabMergeRequestSimple built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabMergeRequestSimpleBuilder builder = GitLabMergeRequestSimpleBuilder.builder(
                        MergetrainsCatalogFixtures.mergeRequestSimple())
                .title(null);

        final GitLabMergeRequestSimple built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabMergeRequestSimpleBuilder builder = GitLabMergeRequestSimpleBuilder.builder(
                        MergetrainsCatalogFixtures.mergeRequestSimple())
                .description(null);

        final GitLabMergeRequestSimple built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabMergeRequestSimpleBuilder builder = GitLabMergeRequestSimpleBuilder.builder(
                        MergetrainsCatalogFixtures.mergeRequestSimple())
                .state(null);

        final GitLabMergeRequestSimple built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabMergeRequestSimpleBuilder builder = GitLabMergeRequestSimpleBuilder.builder(
                        MergetrainsCatalogFixtures.mergeRequestSimple())
                .createdAt(null);

        final GitLabMergeRequestSimple built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabMergeRequestSimpleBuilder builder = GitLabMergeRequestSimpleBuilder.builder(
                        MergetrainsCatalogFixtures.mergeRequestSimple())
                .updatedAt(null);

        final GitLabMergeRequestSimple built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabMergeRequestSimpleBuilder builder = GitLabMergeRequestSimpleBuilder.builder(
                        MergetrainsCatalogFixtures.mergeRequestSimple())
                .webUrl(null);

        final GitLabMergeRequestSimple built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestSimple value = MergetrainsCatalogFixtures.mergeRequestSimple();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.title()).isEqualTo("Test MR 1580978354");
            softly.assertThat(value.description()).isEqualTo("Repellendus impedit et vel velit dignissimos.");
            softly.assertThat(value.state()).isEqualTo("closed");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.webUrl())
                    .isEqualTo("http://local.gitlab.test:8181/root/merge-train-race-condition/-/merge_requests/59");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestSimple original = MergetrainsCatalogFixtures.mergeRequestSimple();

        final GitLabMergeRequestSimple rebuilt =
                GitLabMergeRequestSimpleBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestSimple.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id", "iid", "projectId", "title", "description", "state", "createdAt", "updatedAt", "webUrl");
    }
}
