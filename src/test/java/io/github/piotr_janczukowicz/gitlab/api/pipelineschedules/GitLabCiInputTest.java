package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiInputTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiInputBuilder builder = GitLabCiInputBuilder.builder(PipelineschedulesCatalogFixtures.ciInput())
                .name(null);

        final GitLabCiInput built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabCiInputBuilder builder = GitLabCiInputBuilder.builder(PipelineschedulesCatalogFixtures.ciInput())
                .value(null);

        final GitLabCiInput built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiInput value = PipelineschedulesCatalogFixtures.ciInput();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.value()).isEqualTo("value");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiInput original = PipelineschedulesCatalogFixtures.ciInput();

        final GitLabCiInput rebuilt = GitLabCiInputBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiInput.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "value");
    }
}
