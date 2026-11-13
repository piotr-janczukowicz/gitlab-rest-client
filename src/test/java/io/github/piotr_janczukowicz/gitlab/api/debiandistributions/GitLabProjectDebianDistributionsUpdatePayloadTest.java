package io.github.piotr_janczukowicz.gitlab.api.debiandistributions;

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
class GitLabProjectDebianDistributionsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSuiteIsNullable() {
        final GitLabProjectDebianDistributionsUpdatePayloadBuilder builder =
                GitLabProjectDebianDistributionsUpdatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsUpdatePayload())
                        .suite(null);

        final GitLabProjectDebianDistributionsUpdatePayload built = builder.build();

        assertThat(built.suite()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOriginIsNullable() {
        final GitLabProjectDebianDistributionsUpdatePayloadBuilder builder =
                GitLabProjectDebianDistributionsUpdatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsUpdatePayload())
                        .origin(null);

        final GitLabProjectDebianDistributionsUpdatePayload built = builder.build();

        assertThat(built.origin()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelIsNullable() {
        final GitLabProjectDebianDistributionsUpdatePayloadBuilder builder =
                GitLabProjectDebianDistributionsUpdatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsUpdatePayload())
                        .label(null);

        final GitLabProjectDebianDistributionsUpdatePayload built = builder.build();

        assertThat(built.label()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectDebianDistributionsUpdatePayloadBuilder builder =
                GitLabProjectDebianDistributionsUpdatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsUpdatePayload())
                        .description(null);

        final GitLabProjectDebianDistributionsUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValidTimeDurationSecondsIsNullable() {
        final GitLabProjectDebianDistributionsUpdatePayloadBuilder builder =
                GitLabProjectDebianDistributionsUpdatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsUpdatePayload())
                        .validTimeDurationSeconds(null);

        final GitLabProjectDebianDistributionsUpdatePayload built = builder.build();

        assertThat(built.validTimeDurationSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenComponentsIsNullable() {
        final GitLabProjectDebianDistributionsUpdatePayloadBuilder builder =
                GitLabProjectDebianDistributionsUpdatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsUpdatePayload())
                        .components(null);

        final GitLabProjectDebianDistributionsUpdatePayload built = builder.build();

        assertThat(built.components()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchitecturesIsNullable() {
        final GitLabProjectDebianDistributionsUpdatePayloadBuilder builder =
                GitLabProjectDebianDistributionsUpdatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsUpdatePayload())
                        .architectures(null);

        final GitLabProjectDebianDistributionsUpdatePayload built = builder.build();

        assertThat(built.architectures()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDebianDistributionsUpdatePayload value =
                DebiandistributionsCatalogFixtures.projectDebianDistributionsUpdatePayload();

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
        final GitLabProjectDebianDistributionsUpdatePayload original =
                DebiandistributionsCatalogFixtures.projectDebianDistributionsUpdatePayload();

        final GitLabProjectDebianDistributionsUpdatePayload rebuilt =
                GitLabProjectDebianDistributionsUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenComponentsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("components"));
        final GitLabProjectDebianDistributionsUpdatePayload built =
                GitLabProjectDebianDistributionsUpdatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsUpdatePayload())
                        .components(source)
                        .build();
        source.clear();

        assertThat(built.components()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenComponentsIsRead() {
        final GitLabProjectDebianDistributionsUpdatePayload built =
                DebiandistributionsCatalogFixtures.projectDebianDistributionsUpdatePayload();
        final List<String> values = built.components();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenArchitecturesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("architectures"));
        final GitLabProjectDebianDistributionsUpdatePayload built =
                GitLabProjectDebianDistributionsUpdatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsUpdatePayload())
                        .architectures(source)
                        .build();
        source.clear();

        assertThat(built.architectures()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenArchitecturesIsRead() {
        final GitLabProjectDebianDistributionsUpdatePayload built =
                DebiandistributionsCatalogFixtures.projectDebianDistributionsUpdatePayload();
        final List<String> values = built.architectures();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDebianDistributionsUpdatePayload.class.getRecordComponents())
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
