package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTodoTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabTodoBuilder builder =
                GitLabTodoBuilder.builder(CommonCatalogFixtures.todo()).id(null);

        final GitLabTodo built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabTodoBuilder builder =
                GitLabTodoBuilder.builder(CommonCatalogFixtures.todo()).project(null);

        final GitLabTodo built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIsNullable() {
        final GitLabTodoBuilder builder =
                GitLabTodoBuilder.builder(CommonCatalogFixtures.todo()).group(null);

        final GitLabTodo built = builder.build();

        assertThat(built.group()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabTodoBuilder builder =
                GitLabTodoBuilder.builder(CommonCatalogFixtures.todo()).author(null);

        final GitLabTodo built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActionNameIsNullable() {
        final GitLabTodoBuilder builder =
                GitLabTodoBuilder.builder(CommonCatalogFixtures.todo()).actionName(null);

        final GitLabTodo built = builder.build();

        assertThat(built.actionName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetTypeIsNullable() {
        final GitLabTodoBuilder builder =
                GitLabTodoBuilder.builder(CommonCatalogFixtures.todo()).targetType(null);

        final GitLabTodo built = builder.build();

        assertThat(built.targetType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetIsNullable() {
        final GitLabTodoBuilder builder =
                GitLabTodoBuilder.builder(CommonCatalogFixtures.todo()).target(null);

        final GitLabTodo built = builder.build();

        assertThat(built.target()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetUrlIsNullable() {
        final GitLabTodoBuilder builder =
                GitLabTodoBuilder.builder(CommonCatalogFixtures.todo()).targetUrl(null);

        final GitLabTodo built = builder.build();

        assertThat(built.targetUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabTodoBuilder builder =
                GitLabTodoBuilder.builder(CommonCatalogFixtures.todo()).body(null);

        final GitLabTodo built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabTodoBuilder builder =
                GitLabTodoBuilder.builder(CommonCatalogFixtures.todo()).state(null);

        final GitLabTodo built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabTodoBuilder builder =
                GitLabTodoBuilder.builder(CommonCatalogFixtures.todo()).createdAt(null);

        final GitLabTodo built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabTodoBuilder builder =
                GitLabTodoBuilder.builder(CommonCatalogFixtures.todo()).updatedAt(null);

        final GitLabTodo built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTodo value = CommonCatalogFixtures.todo();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.project()).isEqualTo(CommonCatalogFixtures.projectIdentity());
            softly.assertThat(value.group()).isEqualTo(CommonCatalogFixtures.namespaceBasic());
            softly.assertThat(value.author()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.actionName()).isEqualTo("assigned");
            softly.assertThat(value.targetType()).isEqualTo("Issue");
            softly.assertThat(value.target()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.targetUrl()).isEqualTo("http://example.com/foo/bar/-/issues/1");
            softly.assertThat(value.body()).isEqualTo("Task description");
            softly.assertThat(value.state()).isEqualTo("pending");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTodo original = CommonCatalogFixtures.todo();

        final GitLabTodo rebuilt = GitLabTodoBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTodo.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "project",
                        "group",
                        "author",
                        "actionName",
                        "targetType",
                        "target",
                        "targetUrl",
                        "body",
                        "state",
                        "createdAt",
                        "updatedAt");
    }
}
