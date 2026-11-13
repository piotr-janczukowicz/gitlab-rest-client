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
class GitLabGroupGroupsUpdateDebianDistributionPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSuiteIsNullable() {
        final GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder builder =
                GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload())
                        .suite(null);

        final GitLabGroupGroupsUpdateDebianDistributionPayload built = builder.build();

        assertThat(built.suite()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOriginIsNullable() {
        final GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder builder =
                GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload())
                        .origin(null);

        final GitLabGroupGroupsUpdateDebianDistributionPayload built = builder.build();

        assertThat(built.origin()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelIsNullable() {
        final GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder builder =
                GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload())
                        .label(null);

        final GitLabGroupGroupsUpdateDebianDistributionPayload built = builder.build();

        assertThat(built.label()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder builder =
                GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload())
                        .description(null);

        final GitLabGroupGroupsUpdateDebianDistributionPayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValidTimeDurationSecondsIsNullable() {
        final GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder builder =
                GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload())
                        .validTimeDurationSeconds(null);

        final GitLabGroupGroupsUpdateDebianDistributionPayload built = builder.build();

        assertThat(built.validTimeDurationSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenComponentsIsNullable() {
        final GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder builder =
                GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload())
                        .components(null);

        final GitLabGroupGroupsUpdateDebianDistributionPayload built = builder.build();

        assertThat(built.components()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchitecturesIsNullable() {
        final GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder builder =
                GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload())
                        .architectures(null);

        final GitLabGroupGroupsUpdateDebianDistributionPayload built = builder.build();

        assertThat(built.architectures()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsUpdateDebianDistributionPayload value =
                GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload();

        assertSoftly(softly -> {
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
        final GitLabGroupGroupsUpdateDebianDistributionPayload original =
                GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload();

        final GitLabGroupGroupsUpdateDebianDistributionPayload rebuilt =
                GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenComponentsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("components"));
        final GitLabGroupGroupsUpdateDebianDistributionPayload built =
                GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload())
                        .components(source)
                        .build();
        source.clear();

        assertThat(built.components()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenComponentsIsRead() {
        final GitLabGroupGroupsUpdateDebianDistributionPayload built =
                GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload();
        final List<String> values = built.components();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenArchitecturesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("architectures"));
        final GitLabGroupGroupsUpdateDebianDistributionPayload built =
                GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload())
                        .architectures(source)
                        .build();
        source.clear();

        assertThat(built.architectures()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenArchitecturesIsRead() {
        final GitLabGroupGroupsUpdateDebianDistributionPayload built =
                GroupsCatalogFixtures.groupGroupsUpdateDebianDistributionPayload();
        final List<String> values = built.architectures();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupsUpdateDebianDistributionPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "suite",
                        "origin",
                        "label",
                        "description",
                        "validTimeDurationSeconds",
                        "components",
                        "architectures");
    }
}
