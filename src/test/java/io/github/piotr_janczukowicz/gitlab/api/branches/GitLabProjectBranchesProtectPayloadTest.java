package io.github.piotr_janczukowicz.gitlab.api.branches;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectBranchesProtectPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDevelopersCanPushIsNullable() {
        final GitLabProjectBranchesProtectPayloadBuilder builder = GitLabProjectBranchesProtectPayloadBuilder.builder(
                        BranchesCatalogFixtures.projectBranchesProtectPayload())
                .developersCanPush(null);

        final GitLabProjectBranchesProtectPayload built = builder.build();

        assertThat(built.developersCanPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDevelopersCanMergeIsNullable() {
        final GitLabProjectBranchesProtectPayloadBuilder builder = GitLabProjectBranchesProtectPayloadBuilder.builder(
                        BranchesCatalogFixtures.projectBranchesProtectPayload())
                .developersCanMerge(null);

        final GitLabProjectBranchesProtectPayload built = builder.build();

        assertThat(built.developersCanMerge()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectBranchesProtectPayload value = BranchesCatalogFixtures.projectBranchesProtectPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.developersCanPush()).isEqualTo(true);
            softly.assertThat(value.developersCanMerge()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectBranchesProtectPayload original = BranchesCatalogFixtures.projectBranchesProtectPayload();

        final GitLabProjectBranchesProtectPayload rebuilt =
                GitLabProjectBranchesProtectPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectBranchesProtectPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("developersCanPush", "developersCanMerge");
    }
}
