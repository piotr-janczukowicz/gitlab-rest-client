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
class GitLabAuditEventTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabAuditEventBuilder builder = GitLabAuditEventBuilder.builder(CommonCatalogFixtures.auditEvent())
                .id(null);

        final GitLabAuditEvent built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIdIsNullable() {
        final GitLabAuditEventBuilder builder = GitLabAuditEventBuilder.builder(CommonCatalogFixtures.auditEvent())
                .authorId(null);

        final GitLabAuditEvent built = builder.build();

        assertThat(built.authorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEntityIdIsNullable() {
        final GitLabAuditEventBuilder builder = GitLabAuditEventBuilder.builder(CommonCatalogFixtures.auditEvent())
                .entityId(null);

        final GitLabAuditEvent built = builder.build();

        assertThat(built.entityId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEntityTypeIsNullable() {
        final GitLabAuditEventBuilder builder = GitLabAuditEventBuilder.builder(CommonCatalogFixtures.auditEvent())
                .entityType(null);

        final GitLabAuditEvent built = builder.build();

        assertThat(built.entityType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEventNameIsNullable() {
        final GitLabAuditEventBuilder builder = GitLabAuditEventBuilder.builder(CommonCatalogFixtures.auditEvent())
                .eventName(null);

        final GitLabAuditEvent built = builder.build();

        assertThat(built.eventName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDetailsIsNullable() {
        final GitLabAuditEventBuilder builder = GitLabAuditEventBuilder.builder(CommonCatalogFixtures.auditEvent())
                .details(null);

        final GitLabAuditEvent built = builder.build();

        assertThat(built.details()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabAuditEventBuilder builder = GitLabAuditEventBuilder.builder(CommonCatalogFixtures.auditEvent())
                .createdAt(null);

        final GitLabAuditEvent built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAuditEvent value = CommonCatalogFixtures.auditEvent();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.authorId()).isEqualTo(1L);
            softly.assertThat(value.entityId()).isEqualTo(1L);
            softly.assertThat(value.entityType()).isEqualTo("entity_type");
            softly.assertThat(value.eventName()).isEqualTo("event_name");
            softly.assertThat(value.details()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAuditEvent original = CommonCatalogFixtures.auditEvent();

        final GitLabAuditEvent rebuilt =
                GitLabAuditEventBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAuditEvent.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("id", "authorId", "entityId", "entityType", "eventName", "details", "createdAt");
    }
}
