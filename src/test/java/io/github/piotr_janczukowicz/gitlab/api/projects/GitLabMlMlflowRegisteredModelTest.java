package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMlMlflowRegisteredModelTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabMlMlflowRegisteredModelBuilder builder = GitLabMlMlflowRegisteredModelBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRegisteredModel())
                .name(null);

        final GitLabMlMlflowRegisteredModel built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreationTimestampIsNullable() {
        final GitLabMlMlflowRegisteredModelBuilder builder = GitLabMlMlflowRegisteredModelBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRegisteredModel())
                .creationTimestamp(null);

        final GitLabMlMlflowRegisteredModel built = builder.build();

        assertThat(built.creationTimestamp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUpdatedTimestampIsNullable() {
        final GitLabMlMlflowRegisteredModelBuilder builder = GitLabMlMlflowRegisteredModelBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRegisteredModel())
                .lastUpdatedTimestamp(null);

        final GitLabMlMlflowRegisteredModel built = builder.build();

        assertThat(built.lastUpdatedTimestamp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabMlMlflowRegisteredModelBuilder builder = GitLabMlMlflowRegisteredModelBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRegisteredModel())
                .description(null);

        final GitLabMlMlflowRegisteredModel built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabMlMlflowRegisteredModelBuilder builder = GitLabMlMlflowRegisteredModelBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRegisteredModel())
                .userId(null);

        final GitLabMlMlflowRegisteredModel built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsIsNullable() {
        final GitLabMlMlflowRegisteredModelBuilder builder = GitLabMlMlflowRegisteredModelBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRegisteredModel())
                .tags(null);

        final GitLabMlMlflowRegisteredModel built = builder.build();

        assertThat(built.tags()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLatestVersionsIsNullable() {
        final GitLabMlMlflowRegisteredModelBuilder builder = GitLabMlMlflowRegisteredModelBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRegisteredModel())
                .latestVersions(null);

        final GitLabMlMlflowRegisteredModel built = builder.build();

        assertThat(built.latestVersions()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMlMlflowRegisteredModel value = ProjectsCatalogFixtures.mlMlflowRegisteredModel();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.creationTimestamp()).isEqualTo(1);
            softly.assertThat(value.lastUpdatedTimestamp()).isEqualTo(1);
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.userId()).isEqualTo("user_id");
            softly.assertThat(value.tags()).isEqualTo(List.of(ProjectsCatalogFixtures.mlMlflowKeyValue()));
            softly.assertThat(value.latestVersions())
                    .isEqualTo(List.of(ProjectsCatalogFixtures.mlMlflowModelVersion()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMlMlflowRegisteredModel original = ProjectsCatalogFixtures.mlMlflowRegisteredModel();

        final GitLabMlMlflowRegisteredModel rebuilt =
                GitLabMlMlflowRegisteredModelBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMlMlflowRegisteredModel.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "creationTimestamp",
                        "lastUpdatedTimestamp",
                        "description",
                        "userId",
                        "tags",
                        "latestVersions");
    }
}
