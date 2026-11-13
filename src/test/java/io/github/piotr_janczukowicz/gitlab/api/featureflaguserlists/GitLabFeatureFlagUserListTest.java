package io.github.piotr_janczukowicz.gitlab.api.featureflaguserlists;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabFeatureFlagUserListTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabFeatureFlagUserListBuilder builder = GitLabFeatureFlagUserListBuilder.builder(
                        FeatureflaguserlistsCatalogFixtures.featureFlagUserList())
                .id(null);

        final GitLabFeatureFlagUserList built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabFeatureFlagUserListBuilder builder = GitLabFeatureFlagUserListBuilder.builder(
                        FeatureflaguserlistsCatalogFixtures.featureFlagUserList())
                .iid(null);

        final GitLabFeatureFlagUserList built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabFeatureFlagUserListBuilder builder = GitLabFeatureFlagUserListBuilder.builder(
                        FeatureflaguserlistsCatalogFixtures.featureFlagUserList())
                .name(null);

        final GitLabFeatureFlagUserList built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserXidsIsNullable() {
        final GitLabFeatureFlagUserListBuilder builder = GitLabFeatureFlagUserListBuilder.builder(
                        FeatureflaguserlistsCatalogFixtures.featureFlagUserList())
                .userXids(null);

        final GitLabFeatureFlagUserList built = builder.build();

        assertThat(built.userXids()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabFeatureFlagUserListBuilder builder = GitLabFeatureFlagUserListBuilder.builder(
                        FeatureflaguserlistsCatalogFixtures.featureFlagUserList())
                .projectId(null);

        final GitLabFeatureFlagUserList built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabFeatureFlagUserListBuilder builder = GitLabFeatureFlagUserListBuilder.builder(
                        FeatureflaguserlistsCatalogFixtures.featureFlagUserList())
                .createdAt(null);

        final GitLabFeatureFlagUserList built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabFeatureFlagUserListBuilder builder = GitLabFeatureFlagUserListBuilder.builder(
                        FeatureflaguserlistsCatalogFixtures.featureFlagUserList())
                .updatedAt(null);

        final GitLabFeatureFlagUserList built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabFeatureFlagUserListBuilder builder = GitLabFeatureFlagUserListBuilder.builder(
                        FeatureflaguserlistsCatalogFixtures.featureFlagUserList())
                .path(null);

        final GitLabFeatureFlagUserList built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEditPathIsNullable() {
        final GitLabFeatureFlagUserListBuilder builder = GitLabFeatureFlagUserListBuilder.builder(
                        FeatureflaguserlistsCatalogFixtures.featureFlagUserList())
                .editPath(null);

        final GitLabFeatureFlagUserList built = builder.build();

        assertThat(built.editPath()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabFeatureFlagUserList value = FeatureflaguserlistsCatalogFixtures.featureFlagUserList();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("user_list");
            softly.assertThat(value.userXids()).isEqualTo("user1,user2");
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.path()).isEqualTo("path");
            softly.assertThat(value.editPath()).isEqualTo("edit_path");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabFeatureFlagUserList original = FeatureflaguserlistsCatalogFixtures.featureFlagUserList();

        final GitLabFeatureFlagUserList rebuilt =
                GitLabFeatureFlagUserListBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabFeatureFlagUserList.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id", "iid", "name", "userXids", "projectId", "createdAt", "updatedAt", "path", "editPath");
    }
}
