package io.github.piotr_janczukowicz.gitlab.api.labels;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectLabelsPromotePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectLabelsPromotePayloadBuilder builder = GitLabProjectLabelsPromotePayloadBuilder.builder(
                        LabelsCatalogFixtures.projectLabelsPromotePayload())
                .name(null);

        final GitLabProjectLabelsPromotePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectLabelsPromotePayload value = LabelsCatalogFixtures.projectLabelsPromotePayload();

        assertThat(value.name()).isEqualTo("name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectLabelsPromotePayload original = LabelsCatalogFixtures.projectLabelsPromotePayload();

        final GitLabProjectLabelsPromotePayload rebuilt =
                GitLabProjectLabelsPromotePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectLabelsPromotePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name");
    }
}
