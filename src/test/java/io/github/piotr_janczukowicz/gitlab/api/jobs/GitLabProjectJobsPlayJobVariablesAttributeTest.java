package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectJobsPlayJobVariablesAttributeTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectJobsPlayJobVariablesAttributeBuilder builder =
                GitLabProjectJobsPlayJobVariablesAttributeBuilder.builder(
                                JobsCatalogFixtures.projectJobsPlayJobVariablesAttribute())
                        .key(null);

        final GitLabProjectJobsPlayJobVariablesAttribute built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectJobsPlayJobVariablesAttributeBuilder builder =
                GitLabProjectJobsPlayJobVariablesAttributeBuilder.builder(
                                JobsCatalogFixtures.projectJobsPlayJobVariablesAttribute())
                        .value(null);

        final GitLabProjectJobsPlayJobVariablesAttribute built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectJobsPlayJobVariablesAttribute value =
                JobsCatalogFixtures.projectJobsPlayJobVariablesAttribute();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("foo");
            softly.assertThat(value.value()).isEqualTo("bar");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectJobsPlayJobVariablesAttribute original =
                JobsCatalogFixtures.projectJobsPlayJobVariablesAttribute();

        final GitLabProjectJobsPlayJobVariablesAttribute rebuilt =
                GitLabProjectJobsPlayJobVariablesAttributeBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectJobsPlayJobVariablesAttribute.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value");
    }
}
