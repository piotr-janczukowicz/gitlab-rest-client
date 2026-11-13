package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPipelineSchedulesCreateInputTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectPipelineSchedulesCreateInputBuilder builder =
                GitLabProjectPipelineSchedulesCreateInputBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateInput())
                        .name(null);

        final GitLabProjectPipelineSchedulesCreateInput built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectPipelineSchedulesCreateInputBuilder builder =
                GitLabProjectPipelineSchedulesCreateInputBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateInput())
                        .value(null);

        final GitLabProjectPipelineSchedulesCreateInput built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelineSchedulesCreateInput value =
                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateInput();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("deploy_strategy");
            softly.assertThat(value.value()).isEqualTo(List.of("value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelineSchedulesCreateInput original =
                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateInput();

        final GitLabProjectPipelineSchedulesCreateInput rebuilt =
                GitLabProjectPipelineSchedulesCreateInputBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenValueSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("value"));
        final GitLabProjectPipelineSchedulesCreateInput built =
                GitLabProjectPipelineSchedulesCreateInputBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateInput())
                        .value(source)
                        .build();
        source.clear();

        assertThat(built.value()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenValueIsRead() {
        final GitLabProjectPipelineSchedulesCreateInput built =
                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateInput();
        final List<String> values = built.value();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPipelineSchedulesCreateInput.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "value");
    }
}
