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
class GitLabProjectDebianDistributionsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenCodenameIsNullable() {
        final GitLabProjectDebianDistributionsCreatePayloadBuilder builder =
                GitLabProjectDebianDistributionsCreatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsCreatePayload())
                        .codename(null);

        final GitLabProjectDebianDistributionsCreatePayload built = builder.build();

        assertThat(built.codename()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuiteIsNullable() {
        final GitLabProjectDebianDistributionsCreatePayloadBuilder builder =
                GitLabProjectDebianDistributionsCreatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsCreatePayload())
                        .suite(null);

        final GitLabProjectDebianDistributionsCreatePayload built = builder.build();

        assertThat(built.suite()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOriginIsNullable() {
        final GitLabProjectDebianDistributionsCreatePayloadBuilder builder =
                GitLabProjectDebianDistributionsCreatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsCreatePayload())
                        .origin(null);

        final GitLabProjectDebianDistributionsCreatePayload built = builder.build();

        assertThat(built.origin()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelIsNullable() {
        final GitLabProjectDebianDistributionsCreatePayloadBuilder builder =
                GitLabProjectDebianDistributionsCreatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsCreatePayload())
                        .label(null);

        final GitLabProjectDebianDistributionsCreatePayload built = builder.build();

        assertThat(built.label()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectDebianDistributionsCreatePayloadBuilder builder =
                GitLabProjectDebianDistributionsCreatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsCreatePayload())
                        .description(null);

        final GitLabProjectDebianDistributionsCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValidTimeDurationSecondsIsNullable() {
        final GitLabProjectDebianDistributionsCreatePayloadBuilder builder =
                GitLabProjectDebianDistributionsCreatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsCreatePayload())
                        .validTimeDurationSeconds(null);

        final GitLabProjectDebianDistributionsCreatePayload built = builder.build();

        assertThat(built.validTimeDurationSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenComponentsIsNullable() {
        final GitLabProjectDebianDistributionsCreatePayloadBuilder builder =
                GitLabProjectDebianDistributionsCreatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsCreatePayload())
                        .components(null);

        final GitLabProjectDebianDistributionsCreatePayload built = builder.build();

        assertThat(built.components()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchitecturesIsNullable() {
        final GitLabProjectDebianDistributionsCreatePayloadBuilder builder =
                GitLabProjectDebianDistributionsCreatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsCreatePayload())
                        .architectures(null);

        final GitLabProjectDebianDistributionsCreatePayload built = builder.build();

        assertThat(built.architectures()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDebianDistributionsCreatePayload value =
                DebiandistributionsCatalogFixtures.projectDebianDistributionsCreatePayload();

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
        final GitLabProjectDebianDistributionsCreatePayload original =
                DebiandistributionsCatalogFixtures.projectDebianDistributionsCreatePayload();

        final GitLabProjectDebianDistributionsCreatePayload rebuilt =
                GitLabProjectDebianDistributionsCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenComponentsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("components"));
        final GitLabProjectDebianDistributionsCreatePayload built =
                GitLabProjectDebianDistributionsCreatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsCreatePayload())
                        .components(source)
                        .build();
        source.clear();

        assertThat(built.components()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenComponentsIsRead() {
        final GitLabProjectDebianDistributionsCreatePayload built =
                DebiandistributionsCatalogFixtures.projectDebianDistributionsCreatePayload();
        final List<String> values = built.components();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenArchitecturesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("architectures"));
        final GitLabProjectDebianDistributionsCreatePayload built =
                GitLabProjectDebianDistributionsCreatePayloadBuilder.builder(
                                DebiandistributionsCatalogFixtures.projectDebianDistributionsCreatePayload())
                        .architectures(source)
                        .build();
        source.clear();

        assertThat(built.architectures()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenArchitecturesIsRead() {
        final GitLabProjectDebianDistributionsCreatePayload built =
                DebiandistributionsCatalogFixtures.projectDebianDistributionsCreatePayload();
        final List<String> values = built.architectures();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDebianDistributionsCreatePayload.class.getRecordComponents())
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
