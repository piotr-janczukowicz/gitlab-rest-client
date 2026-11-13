package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabFeatureFlagStrategyTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabFeatureFlagStrategyBuilder builder = GitLabFeatureFlagStrategyBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlagStrategy())
                .id(null);

        final GitLabFeatureFlagStrategy built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabFeatureFlagStrategyBuilder builder = GitLabFeatureFlagStrategyBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlagStrategy())
                .name(null);

        final GitLabFeatureFlagStrategy built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParametersIsNullable() {
        final GitLabFeatureFlagStrategyBuilder builder = GitLabFeatureFlagStrategyBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlagStrategy())
                .parameters(null);

        final GitLabFeatureFlagStrategy built = builder.build();

        assertThat(built.parameters()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabFeatureFlagStrategyBuilder builder = GitLabFeatureFlagStrategyBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlagStrategy())
                .scopes(null);

        final GitLabFeatureFlagStrategy built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserListIsNullable() {
        final GitLabFeatureFlagStrategyBuilder builder = GitLabFeatureFlagStrategyBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlagStrategy())
                .userList(null);

        final GitLabFeatureFlagStrategy built = builder.build();

        assertThat(built.userList()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabFeatureFlagStrategy value = FeatureflagsCatalogFixtures.featureFlagStrategy();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("userWithId");
            softly.assertThat(value.parameters()).isEqualTo("{\"userIds\": \"user1\"}");
            softly.assertThat(value.scopes()).isEqualTo(List.of(FeatureflagsCatalogFixtures.featureFlagScope()));
            softly.assertThat(value.userList()).isEqualTo(FeatureflagsCatalogFixtures.featureFlagBasicUserList());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabFeatureFlagStrategy original = FeatureflagsCatalogFixtures.featureFlagStrategy();

        final GitLabFeatureFlagStrategy rebuilt =
                GitLabFeatureFlagStrategyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabFeatureFlagStrategy.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "parameters", "scopes", "userList");
    }
}
