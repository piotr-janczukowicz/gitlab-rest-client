package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestChangesUserTest {

    @Test
    void constructor_shouldAcceptNull_whenCanMergeIsNullable() {
        final GitLabMergeRequestChangesUserBuilder builder = GitLabMergeRequestChangesUserBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestChangesUser())
                .canMerge(null);

        final GitLabMergeRequestChangesUser built = builder.build();

        assertThat(built.canMerge()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestChangesUser value = MergerequestsCatalogFixtures.mergeRequestChangesUser();

        assertThat(value.canMerge()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestChangesUser original = MergerequestsCatalogFixtures.mergeRequestChangesUser();

        final GitLabMergeRequestChangesUser rebuilt =
                GitLabMergeRequestChangesUserBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestChangesUser.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("canMerge");
    }
}
