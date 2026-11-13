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
class GitLabProjectPipelineSchedulesUpdateInputTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectPipelineSchedulesUpdateInputBuilder builder =
                GitLabProjectPipelineSchedulesUpdateInputBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateInput())
                        .name(null);

        final GitLabProjectPipelineSchedulesUpdateInput built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestroyIsNullable() {
        final GitLabProjectPipelineSchedulesUpdateInputBuilder builder =
                GitLabProjectPipelineSchedulesUpdateInputBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateInput())
                        .destroy(null);

        final GitLabProjectPipelineSchedulesUpdateInput built = builder.build();

        assertThat(built.destroy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectPipelineSchedulesUpdateInputBuilder builder =
                GitLabProjectPipelineSchedulesUpdateInputBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateInput())
                        .value(null);

        final GitLabProjectPipelineSchedulesUpdateInput built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelineSchedulesUpdateInput value =
                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateInput();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("deploy_strategy");
            softly.assertThat(value.destroy()).isEqualTo(true);
            softly.assertThat(value.value()).isEqualTo(List.of("value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelineSchedulesUpdateInput original =
                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateInput();

        final GitLabProjectPipelineSchedulesUpdateInput rebuilt =
                GitLabProjectPipelineSchedulesUpdateInputBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenValueSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("value"));
        final GitLabProjectPipelineSchedulesUpdateInput built =
                GitLabProjectPipelineSchedulesUpdateInputBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateInput())
                        .value(source)
                        .build();
        source.clear();

        assertThat(built.value()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenValueIsRead() {
        final GitLabProjectPipelineSchedulesUpdateInput built =
                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateInput();
        final List<String> values = built.value();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPipelineSchedulesUpdateInput.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "destroy", "value");
    }
}
