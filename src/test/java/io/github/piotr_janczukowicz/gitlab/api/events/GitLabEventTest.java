package io.github.piotr_janczukowicz.gitlab.api.events;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabEventTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).id(null);

        final GitLabEvent built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).projectId(null);

        final GitLabEvent built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActionNameIsNullable() {
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).actionName(null);

        final GitLabEvent built = builder.build();

        assertThat(built.actionName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetIdIsNullable() {
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).targetId(null);

        final GitLabEvent built = builder.build();

        assertThat(built.targetId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetIidIsNullable() {
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).targetIid(null);

        final GitLabEvent built = builder.build();

        assertThat(built.targetIid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetTypeIsNullable() {
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).targetType(null);

        final GitLabEvent built = builder.build();

        assertThat(built.targetType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIdIsNullable() {
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).authorId(null);

        final GitLabEvent built = builder.build();

        assertThat(built.authorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetTitleIsNullable() {
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).targetTitle(null);

        final GitLabEvent built = builder.build();

        assertThat(built.targetTitle()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).createdAt(null);

        final GitLabEvent built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteIsNullable() {
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).note(null);

        final GitLabEvent built = builder.build();

        assertThat(built.note()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).author(null);

        final GitLabEvent built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageIsNullable() {
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).wikiPage(null);

        final GitLabEvent built = builder.build();

        assertThat(built.wikiPage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedIsNullable() {
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).imported(null);

        final GitLabEvent built = builder.build();

        assertThat(built.imported()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedFromIsNullable() {
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).importedFrom(null);

        final GitLabEvent built = builder.build();

        assertThat(built.importedFrom()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushDataIsNullable() {
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).pushData(null);

        final GitLabEvent built = builder.build();

        assertThat(built.pushData()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorUsernameIsNullable() {
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).authorUsername(null);

        final GitLabEvent built = builder.build();

        assertThat(built.authorUsername()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabEvent value = EventsCatalogFixtures.event();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.actionName()).isEqualTo("closed");
            softly.assertThat(value.targetId()).isEqualTo(1L);
            softly.assertThat(value.targetIid()).isEqualTo(1L);
            softly.assertThat(value.targetType()).isEqualTo("Issue");
            softly.assertThat(value.authorId()).isEqualTo(1L);
            softly.assertThat(value.targetTitle()).isEqualTo("Public project search field");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.note()).isEqualTo(CommonCatalogFixtures.note());
            softly.assertThat(value.author()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.wikiPage()).isEqualTo(CommonCatalogFixtures.wikiPageBasic());
            softly.assertThat(value.imported()).isEqualTo(true);
            softly.assertThat(value.importedFrom()).isEqualTo("none");
            softly.assertThat(value.pushData()).isEqualTo(EventsCatalogFixtures.pushEventPayload());
            softly.assertThat(value.authorUsername()).isEqualTo("root");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabEvent original = EventsCatalogFixtures.event();

        final GitLabEvent rebuilt = GitLabEventBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabEventBuilder builder =
                GitLabEventBuilder.builder(EventsCatalogFixtures.event()).createdAt(instant);

        final GitLabEvent built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabEvent.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "projectId",
                        "actionName",
                        "targetId",
                        "targetIid",
                        "targetType",
                        "authorId",
                        "targetTitle",
                        "createdAt",
                        "note",
                        "author",
                        "wikiPage",
                        "imported",
                        "importedFrom",
                        "pushData",
                        "authorUsername");
    }
}
