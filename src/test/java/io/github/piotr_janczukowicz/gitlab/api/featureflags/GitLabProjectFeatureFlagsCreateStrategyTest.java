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
class GitLabProjectFeatureFlagsCreateStrategyTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectFeatureFlagsCreateStrategyBuilder builder =
                GitLabProjectFeatureFlagsCreateStrategyBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategy())
                        .name(null);

        final GitLabProjectFeatureFlagsCreateStrategy built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParametersIsNullable() {
        final GitLabProjectFeatureFlagsCreateStrategyBuilder builder =
                GitLabProjectFeatureFlagsCreateStrategyBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategy())
                        .parameters(null);

        final GitLabProjectFeatureFlagsCreateStrategy built = builder.build();

        assertThat(built.parameters()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserListIdIsNullable() {
        final GitLabProjectFeatureFlagsCreateStrategyBuilder builder =
                GitLabProjectFeatureFlagsCreateStrategyBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategy())
                        .userListId(null);

        final GitLabProjectFeatureFlagsCreateStrategy built = builder.build();

        assertThat(built.userListId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabProjectFeatureFlagsCreateStrategyBuilder builder =
                GitLabProjectFeatureFlagsCreateStrategyBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategy())
                        .scopes(null);

        final GitLabProjectFeatureFlagsCreateStrategy built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectFeatureFlagsCreateStrategy value =
                FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategy();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.parameters()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.userListId()).isEqualTo(1L);
            softly.assertThat(value.scopes())
                    .isEqualTo(List.of(FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategyScope()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectFeatureFlagsCreateStrategy original =
                FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategy();

        final GitLabProjectFeatureFlagsCreateStrategy rebuilt =
                GitLabProjectFeatureFlagsCreateStrategyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenParametersSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabProjectFeatureFlagsCreateStrategy built = GitLabProjectFeatureFlagsCreateStrategyBuilder.builder(
                        FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategy())
                .parameters(source)
                .build();
        source.clear();

        assertThat(built.parameters()).isNotEmpty();
    }

    @Test
    void constructor_shouldCopyTheList_whenScopesSourceChangesLater() {
        final List<GitLabProjectFeatureFlagsCreateStrategyScope> source =
                new ArrayList<>(List.of(FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategyScope()));
        final GitLabProjectFeatureFlagsCreateStrategy built = GitLabProjectFeatureFlagsCreateStrategyBuilder.builder(
                        FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategy())
                .scopes(source)
                .build();
        source.clear();

        assertThat(built.scopes()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScopesIsRead() {
        final GitLabProjectFeatureFlagsCreateStrategy built =
                FeatureflagsCatalogFixtures.projectFeatureFlagsCreateStrategy();
        final List<GitLabProjectFeatureFlagsCreateStrategyScope> values = built.scopes();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectFeatureFlagsCreateStrategy.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "parameters", "userListId", "scopes");
    }
}
