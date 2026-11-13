package io.github.piotr_janczukowicz.gitlab.api.resourcelabelevents;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabResourceLabelEventTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabResourceLabelEventBuilder builder = GitLabResourceLabelEventBuilder.builder(
                        ResourcelabeleventsCatalogFixtures.resourceLabelEvent())
                .id(null);

        final GitLabResourceLabelEvent built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabResourceLabelEventBuilder builder = GitLabResourceLabelEventBuilder.builder(
                        ResourcelabeleventsCatalogFixtures.resourceLabelEvent())
                .user(null);

        final GitLabResourceLabelEvent built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabResourceLabelEventBuilder builder = GitLabResourceLabelEventBuilder.builder(
                        ResourcelabeleventsCatalogFixtures.resourceLabelEvent())
                .createdAt(null);

        final GitLabResourceLabelEvent built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceTypeIsNullable() {
        final GitLabResourceLabelEventBuilder builder = GitLabResourceLabelEventBuilder.builder(
                        ResourcelabeleventsCatalogFixtures.resourceLabelEvent())
                .resourceType(null);

        final GitLabResourceLabelEvent built = builder.build();

        assertThat(built.resourceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceIdIsNullable() {
        final GitLabResourceLabelEventBuilder builder = GitLabResourceLabelEventBuilder.builder(
                        ResourcelabeleventsCatalogFixtures.resourceLabelEvent())
                .resourceId(null);

        final GitLabResourceLabelEvent built = builder.build();

        assertThat(built.resourceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelIsNullable() {
        final GitLabResourceLabelEventBuilder builder = GitLabResourceLabelEventBuilder.builder(
                        ResourcelabeleventsCatalogFixtures.resourceLabelEvent())
                .label(null);

        final GitLabResourceLabelEvent built = builder.build();

        assertThat(built.label()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActionIsNullable() {
        final GitLabResourceLabelEventBuilder builder = GitLabResourceLabelEventBuilder.builder(
                        ResourcelabeleventsCatalogFixtures.resourceLabelEvent())
                .action(null);

        final GitLabResourceLabelEvent built = builder.build();

        assertThat(built.action()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabResourceLabelEvent value = ResourcelabeleventsCatalogFixtures.resourceLabelEvent();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.resourceType()).isEqualTo("Issue");
            softly.assertThat(value.resourceId()).isEqualTo(1L);
            softly.assertThat(value.label()).isEqualTo(CommonCatalogFixtures.labelBasic());
            softly.assertThat(value.action()).isEqualTo("add");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabResourceLabelEvent original = ResourcelabeleventsCatalogFixtures.resourceLabelEvent();

        final GitLabResourceLabelEvent rebuilt =
                GitLabResourceLabelEventBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabResourceLabelEvent.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "user", "createdAt", "resourceType", "resourceId", "label", "action");
    }
}
