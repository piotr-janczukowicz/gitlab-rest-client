package io.github.piotr_janczukowicz.gitlab.api.branches;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectBranchesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBranchIsNullable() {
        final GitLabProjectBranchesCreatePayloadBuilder builder = GitLabProjectBranchesCreatePayloadBuilder.builder(
                        BranchesCatalogFixtures.projectBranchesCreatePayload())
                .branch(null);

        final GitLabProjectBranchesCreatePayload built = builder.build();

        assertThat(built.branch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectBranchesCreatePayloadBuilder builder = GitLabProjectBranchesCreatePayloadBuilder.builder(
                        BranchesCatalogFixtures.projectBranchesCreatePayload())
                .ref(null);

        final GitLabProjectBranchesCreatePayload built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectBranchesCreatePayload value = BranchesCatalogFixtures.projectBranchesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.branch()).isEqualTo("branch");
            softly.assertThat(value.ref()).isEqualTo("ref");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectBranchesCreatePayload original = BranchesCatalogFixtures.projectBranchesCreatePayload();

        final GitLabProjectBranchesCreatePayload rebuilt =
                GitLabProjectBranchesCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectBranchesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("branch", "ref");
    }
}
