package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMlMlflowKeyValueTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabMlMlflowKeyValueBuilder builder = GitLabMlMlflowKeyValueBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowKeyValue())
                .key(null);

        final GitLabMlMlflowKeyValue built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabMlMlflowKeyValueBuilder builder = GitLabMlMlflowKeyValueBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowKeyValue())
                .value(null);

        final GitLabMlMlflowKeyValue built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMlMlflowKeyValue value = ProjectsCatalogFixtures.mlMlflowKeyValue();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.value()).isEqualTo("value");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMlMlflowKeyValue original = ProjectsCatalogFixtures.mlMlflowKeyValue();

        final GitLabMlMlflowKeyValue rebuilt =
                GitLabMlMlflowKeyValueBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMlMlflowKeyValue.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value");
    }
}
