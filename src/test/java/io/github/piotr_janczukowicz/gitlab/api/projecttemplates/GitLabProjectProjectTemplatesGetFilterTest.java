package io.github.piotr_janczukowicz.gitlab.api.projecttemplates;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectTemplatesGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSourceTemplateProjectIdIsNullable() {
        final GitLabProjectProjectTemplatesGetFilterBuilder builder =
                GitLabProjectProjectTemplatesGetFilterBuilder.builder(
                                GitLabProjectProjectTemplatesGetFilterBuilder.builder()
                                        .sourceTemplateProjectId(1L)
                                        .project("project")
                                        .fullname("fullname")
                                        .build())
                        .sourceTemplateProjectId(null);

        final GitLabProjectProjectTemplatesGetFilter built = builder.build();

        assertThat(built.sourceTemplateProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabProjectProjectTemplatesGetFilterBuilder builder =
                GitLabProjectProjectTemplatesGetFilterBuilder.builder(
                                GitLabProjectProjectTemplatesGetFilterBuilder.builder()
                                        .sourceTemplateProjectId(1L)
                                        .project("project")
                                        .fullname("fullname")
                                        .build())
                        .project(null);

        final GitLabProjectProjectTemplatesGetFilter built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullnameIsNullable() {
        final GitLabProjectProjectTemplatesGetFilterBuilder builder =
                GitLabProjectProjectTemplatesGetFilterBuilder.builder(
                                GitLabProjectProjectTemplatesGetFilterBuilder.builder()
                                        .sourceTemplateProjectId(1L)
                                        .project("project")
                                        .fullname("fullname")
                                        .build())
                        .fullname(null);

        final GitLabProjectProjectTemplatesGetFilter built = builder.build();

        assertThat(built.fullname()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectTemplatesGetFilter value = GitLabProjectProjectTemplatesGetFilterBuilder.builder()
                .sourceTemplateProjectId(1L)
                .project("project")
                .fullname("fullname")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.sourceTemplateProjectId()).isEqualTo(1L);
            softly.assertThat(value.project()).isEqualTo("project");
            softly.assertThat(value.fullname()).isEqualTo("fullname");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectTemplatesGetFilter original = GitLabProjectProjectTemplatesGetFilterBuilder.builder()
                .sourceTemplateProjectId(1L)
                .project("project")
                .fullname("fullname")
                .build();

        final GitLabProjectProjectTemplatesGetFilter rebuilt =
                GitLabProjectProjectTemplatesGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectTemplatesGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sourceTemplateProjectId", "project", "fullname");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectTemplatesGetFilter empty = GitLabProjectProjectTemplatesGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectTemplatesGetFilter filter = GitLabProjectProjectTemplatesGetFilterBuilder.builder()
                .sourceTemplateProjectId(1L)
                .project("project")
                .fullname("fullname")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("source_template_project_id", "1"),
                        Map.entry("project", "project"),
                        Map.entry("fullname", "fullname"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectTemplatesGetFilter filter = GitLabProjectProjectTemplatesGetFilterBuilder.builder()
                .sourceTemplateProjectId(1L)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("source_template_project_id", "1"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectTemplatesGetFilter filter = GitLabProjectProjectTemplatesGetFilterBuilder.builder()
                .sourceTemplateProjectId(1L)
                .project("project")
                .fullname("fullname")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
