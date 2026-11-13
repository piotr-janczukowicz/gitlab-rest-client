package io.github.piotr_janczukowicz.gitlab.api.branches;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBranchTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabBranchBuilder builder =
                GitLabBranchBuilder.builder(BranchesCatalogFixtures.branch()).name(null);

        final GitLabBranch built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitIsNullable() {
        final GitLabBranchBuilder builder =
                GitLabBranchBuilder.builder(BranchesCatalogFixtures.branch()).commit(null);

        final GitLabBranch built = builder.build();

        assertThat(built.commit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergedIsNullable() {
        final GitLabBranchBuilder builder =
                GitLabBranchBuilder.builder(BranchesCatalogFixtures.branch()).merged(null);

        final GitLabBranch built = builder.build();

        assertThat(built.merged()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedValueIsNullable() {
        final GitLabBranchBuilder builder =
                GitLabBranchBuilder.builder(BranchesCatalogFixtures.branch()).protectedValue(null);

        final GitLabBranch built = builder.build();

        assertThat(built.protectedValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDevelopersCanPushIsNullable() {
        final GitLabBranchBuilder builder =
                GitLabBranchBuilder.builder(BranchesCatalogFixtures.branch()).developersCanPush(null);

        final GitLabBranch built = builder.build();

        assertThat(built.developersCanPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDevelopersCanMergeIsNullable() {
        final GitLabBranchBuilder builder =
                GitLabBranchBuilder.builder(BranchesCatalogFixtures.branch()).developersCanMerge(null);

        final GitLabBranch built = builder.build();

        assertThat(built.developersCanMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanPushIsNullable() {
        final GitLabBranchBuilder builder =
                GitLabBranchBuilder.builder(BranchesCatalogFixtures.branch()).canPush(null);

        final GitLabBranch built = builder.build();

        assertThat(built.canPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultValueIsNullable() {
        final GitLabBranchBuilder builder =
                GitLabBranchBuilder.builder(BranchesCatalogFixtures.branch()).defaultValue(null);

        final GitLabBranch built = builder.build();

        assertThat(built.defaultValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabBranchBuilder builder =
                GitLabBranchBuilder.builder(BranchesCatalogFixtures.branch()).webUrl(null);

        final GitLabBranch built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBranch value = BranchesCatalogFixtures.branch();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("master");
            softly.assertThat(value.commit()).isEqualTo(CommonCatalogFixtures.commit());
            softly.assertThat(value.merged()).isEqualTo(true);
            softly.assertThat(value.protectedValue()).isEqualTo(true);
            softly.assertThat(value.developersCanPush()).isEqualTo(true);
            softly.assertThat(value.developersCanMerge()).isEqualTo(true);
            softly.assertThat(value.canPush()).isEqualTo(true);
            softly.assertThat(value.defaultValue()).isEqualTo(true);
            softly.assertThat(value.webUrl()).isEqualTo("https://gitlab.example.com/Commit921/the-dude/-/tree/master");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBranch original = BranchesCatalogFixtures.branch();

        final GitLabBranch rebuilt = GitLabBranchBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBranch.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "commit",
                        "merged",
                        "protectedValue",
                        "developersCanPush",
                        "developersCanMerge",
                        "canPush",
                        "defaultValue",
                        "webUrl");
    }
}
