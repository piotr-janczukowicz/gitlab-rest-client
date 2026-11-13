package io.github.piotr_janczukowicz.gitlab.api.groups;

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
class GitLabGroupGroupsCreateDebianDistributionPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenCodenameIsNullable() {
        final GitLabGroupGroupsCreateDebianDistributionPayloadBuilder builder =
                GitLabGroupGroupsCreateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload())
                        .codename(null);

        final GitLabGroupGroupsCreateDebianDistributionPayload built = builder.build();

        assertThat(built.codename()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuiteIsNullable() {
        final GitLabGroupGroupsCreateDebianDistributionPayloadBuilder builder =
                GitLabGroupGroupsCreateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload())
                        .suite(null);

        final GitLabGroupGroupsCreateDebianDistributionPayload built = builder.build();

        assertThat(built.suite()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOriginIsNullable() {
        final GitLabGroupGroupsCreateDebianDistributionPayloadBuilder builder =
                GitLabGroupGroupsCreateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload())
                        .origin(null);

        final GitLabGroupGroupsCreateDebianDistributionPayload built = builder.build();

        assertThat(built.origin()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelIsNullable() {
        final GitLabGroupGroupsCreateDebianDistributionPayloadBuilder builder =
                GitLabGroupGroupsCreateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload())
                        .label(null);

        final GitLabGroupGroupsCreateDebianDistributionPayload built = builder.build();

        assertThat(built.label()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupGroupsCreateDebianDistributionPayloadBuilder builder =
                GitLabGroupGroupsCreateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload())
                        .description(null);

        final GitLabGroupGroupsCreateDebianDistributionPayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValidTimeDurationSecondsIsNullable() {
        final GitLabGroupGroupsCreateDebianDistributionPayloadBuilder builder =
                GitLabGroupGroupsCreateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload())
                        .validTimeDurationSeconds(null);

        final GitLabGroupGroupsCreateDebianDistributionPayload built = builder.build();

        assertThat(built.validTimeDurationSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenComponentsIsNullable() {
        final GitLabGroupGroupsCreateDebianDistributionPayloadBuilder builder =
                GitLabGroupGroupsCreateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload())
                        .components(null);

        final GitLabGroupGroupsCreateDebianDistributionPayload built = builder.build();

        assertThat(built.components()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchitecturesIsNullable() {
        final GitLabGroupGroupsCreateDebianDistributionPayloadBuilder builder =
                GitLabGroupGroupsCreateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload())
                        .architectures(null);

        final GitLabGroupGroupsCreateDebianDistributionPayload built = builder.build();

        assertThat(built.architectures()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsCreateDebianDistributionPayload value =
                GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.codename()).isEqualTo("sid");
            softly.assertThat(value.suite()).isEqualTo("unstable");
            softly.assertThat(value.origin()).isEqualTo("Grep");
            softly.assertThat(value.label()).isEqualTo("grep.be");
            softly.assertThat(value.description()).isEqualTo("My description");
            softly.assertThat(value.validTimeDurationSeconds()).isEqualTo(1);
            softly.assertThat(value.components()).isEqualTo(List.of("components"));
            softly.assertThat(value.architectures()).isEqualTo(List.of("architectures"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsCreateDebianDistributionPayload original =
                GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload();

        final GitLabGroupGroupsCreateDebianDistributionPayload rebuilt =
                GitLabGroupGroupsCreateDebianDistributionPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenComponentsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("components"));
        final GitLabGroupGroupsCreateDebianDistributionPayload built =
                GitLabGroupGroupsCreateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload())
                        .components(source)
                        .build();
        source.clear();

        assertThat(built.components()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenComponentsIsRead() {
        final GitLabGroupGroupsCreateDebianDistributionPayload built =
                GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload();
        final List<String> values = built.components();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenArchitecturesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("architectures"));
        final GitLabGroupGroupsCreateDebianDistributionPayload built =
                GitLabGroupGroupsCreateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload())
                        .architectures(source)
                        .build();
        source.clear();

        assertThat(built.architectures()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenArchitecturesIsRead() {
        final GitLabGroupGroupsCreateDebianDistributionPayload built =
                GroupsCatalogFixtures.groupGroupsCreateDebianDistributionPayload();
        final List<String> values = built.architectures();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupsCreateDebianDistributionPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "codename",
                        "suite",
                        "origin",
                        "label",
                        "description",
                        "validTimeDurationSeconds",
                        "components",
                        "architectures");
    }
}
