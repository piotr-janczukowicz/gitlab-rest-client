package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectFeatureFlagsUpdateStrategyTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectFeatureFlagsUpdateStrategyBuilder builder =
                GitLabProjectFeatureFlagsUpdateStrategyBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategy())
                        .id(null);

        final GitLabProjectFeatureFlagsUpdateStrategy built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectFeatureFlagsUpdateStrategyBuilder builder =
                GitLabProjectFeatureFlagsUpdateStrategyBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategy())
                        .name(null);

        final GitLabProjectFeatureFlagsUpdateStrategy built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParametersIsNullable() {
        final GitLabProjectFeatureFlagsUpdateStrategyBuilder builder =
                GitLabProjectFeatureFlagsUpdateStrategyBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategy())
                        .parameters(null);

        final GitLabProjectFeatureFlagsUpdateStrategy built = builder.build();

        assertThat(built.parameters()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserListIdIsNullable() {
        final GitLabProjectFeatureFlagsUpdateStrategyBuilder builder =
                GitLabProjectFeatureFlagsUpdateStrategyBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategy())
                        .userListId(null);

        final GitLabProjectFeatureFlagsUpdateStrategy built = builder.build();

        assertThat(built.userListId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestroyIsNullable() {
        final GitLabProjectFeatureFlagsUpdateStrategyBuilder builder =
                GitLabProjectFeatureFlagsUpdateStrategyBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategy())
                        .destroy(null);

        final GitLabProjectFeatureFlagsUpdateStrategy built = builder.build();

        assertThat(built.destroy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabProjectFeatureFlagsUpdateStrategyBuilder builder =
                GitLabProjectFeatureFlagsUpdateStrategyBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategy())
                        .scopes(null);

        final GitLabProjectFeatureFlagsUpdateStrategy built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectFeatureFlagsUpdateStrategy value =
                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategy();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.parameters()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.userListId()).isEqualTo(1L);
            softly.assertThat(value.destroy()).isEqualTo(true);
            softly.assertThat(value.scopes())
                    .isEqualTo(List.of(FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategyScope()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectFeatureFlagsUpdateStrategy original =
                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategy();

        final GitLabProjectFeatureFlagsUpdateStrategy rebuilt =
                GitLabProjectFeatureFlagsUpdateStrategyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenParametersSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabProjectFeatureFlagsUpdateStrategy built = GitLabProjectFeatureFlagsUpdateStrategyBuilder.builder(
                        FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategy())
                .parameters(source)
                .build();
        source.clear();

        assertThat(built.parameters()).isNotEmpty();
    }

    @Test
    void constructor_shouldCopyTheList_whenScopesSourceChangesLater() {
        final List<GitLabProjectFeatureFlagsUpdateStrategyScope> source =
                new ArrayList<>(List.of(FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategyScope()));
        final GitLabProjectFeatureFlagsUpdateStrategy built = GitLabProjectFeatureFlagsUpdateStrategyBuilder.builder(
                        FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategy())
                .scopes(source)
                .build();
        source.clear();

        assertThat(built.scopes()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScopesIsRead() {
        final GitLabProjectFeatureFlagsUpdateStrategy built =
                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateStrategy();
        final List<GitLabProjectFeatureFlagsUpdateStrategyScope> values = built.scopes();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectFeatureFlagsUpdateStrategy.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "parameters", "userListId", "destroy", "scopes");
    }
}
