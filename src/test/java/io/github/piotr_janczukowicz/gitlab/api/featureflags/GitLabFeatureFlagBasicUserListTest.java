package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabFeatureFlagBasicUserListTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabFeatureFlagBasicUserListBuilder builder = GitLabFeatureFlagBasicUserListBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlagBasicUserList())
                .id(null);

        final GitLabFeatureFlagBasicUserList built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabFeatureFlagBasicUserListBuilder builder = GitLabFeatureFlagBasicUserListBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlagBasicUserList())
                .iid(null);

        final GitLabFeatureFlagBasicUserList built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabFeatureFlagBasicUserListBuilder builder = GitLabFeatureFlagBasicUserListBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlagBasicUserList())
                .name(null);

        final GitLabFeatureFlagBasicUserList built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserXidsIsNullable() {
        final GitLabFeatureFlagBasicUserListBuilder builder = GitLabFeatureFlagBasicUserListBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlagBasicUserList())
                .userXids(null);

        final GitLabFeatureFlagBasicUserList built = builder.build();

        assertThat(built.userXids()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabFeatureFlagBasicUserList value = FeatureflagsCatalogFixtures.featureFlagBasicUserList();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("user_list");
            softly.assertThat(value.userXids()).isEqualTo("user1,user2");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabFeatureFlagBasicUserList original = FeatureflagsCatalogFixtures.featureFlagBasicUserList();

        final GitLabFeatureFlagBasicUserList rebuilt =
                GitLabFeatureFlagBasicUserListBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabFeatureFlagBasicUserList.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "iid", "name", "userXids");
    }
}
