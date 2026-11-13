package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestUserTest {

    @Test
    void constructor_shouldAcceptNull_whenCanMergeIsNullable() {
        final GitLabMergeRequestUserBuilder builder = GitLabMergeRequestUserBuilder.builder(
                        CommonCatalogFixtures.mergeRequestUser())
                .canMerge(null);

        final GitLabMergeRequestUser built = builder.build();

        assertThat(built.canMerge()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestUser value = CommonCatalogFixtures.mergeRequestUser();

        assertThat(value.canMerge()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestUser original = CommonCatalogFixtures.mergeRequestUser();

        final GitLabMergeRequestUser rebuilt =
                GitLabMergeRequestUserBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestUser.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("canMerge");
    }
}
