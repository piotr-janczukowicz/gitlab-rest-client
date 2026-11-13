package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDetailedStatusEntityTest {

    @Test
    void constructor_shouldAcceptNull_whenIconIsNullable() {
        final GitLabDetailedStatusEntityBuilder builder = GitLabDetailedStatusEntityBuilder.builder(
                        CommonCatalogFixtures.detailedStatusEntity())
                .icon(null);

        final GitLabDetailedStatusEntity built = builder.build();

        assertThat(built.icon()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTextIsNullable() {
        final GitLabDetailedStatusEntityBuilder builder = GitLabDetailedStatusEntityBuilder.builder(
                        CommonCatalogFixtures.detailedStatusEntity())
                .text(null);

        final GitLabDetailedStatusEntity built = builder.build();

        assertThat(built.text()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelIsNullable() {
        final GitLabDetailedStatusEntityBuilder builder = GitLabDetailedStatusEntityBuilder.builder(
                        CommonCatalogFixtures.detailedStatusEntity())
                .label(null);

        final GitLabDetailedStatusEntity built = builder.build();

        assertThat(built.label()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIsNullable() {
        final GitLabDetailedStatusEntityBuilder builder = GitLabDetailedStatusEntityBuilder.builder(
                        CommonCatalogFixtures.detailedStatusEntity())
                .group(null);

        final GitLabDetailedStatusEntity built = builder.build();

        assertThat(built.group()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTooltipIsNullable() {
        final GitLabDetailedStatusEntityBuilder builder = GitLabDetailedStatusEntityBuilder.builder(
                        CommonCatalogFixtures.detailedStatusEntity())
                .tooltip(null);

        final GitLabDetailedStatusEntity built = builder.build();

        assertThat(built.tooltip()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasDetailsIsNullable() {
        final GitLabDetailedStatusEntityBuilder builder = GitLabDetailedStatusEntityBuilder.builder(
                        CommonCatalogFixtures.detailedStatusEntity())
                .hasDetails(null);

        final GitLabDetailedStatusEntity built = builder.build();

        assertThat(built.hasDetails()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDetailsPathIsNullable() {
        final GitLabDetailedStatusEntityBuilder builder = GitLabDetailedStatusEntityBuilder.builder(
                        CommonCatalogFixtures.detailedStatusEntity())
                .detailsPath(null);

        final GitLabDetailedStatusEntity built = builder.build();

        assertThat(built.detailsPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIllustrationIsNullable() {
        final GitLabDetailedStatusEntityBuilder builder = GitLabDetailedStatusEntityBuilder.builder(
                        CommonCatalogFixtures.detailedStatusEntity())
                .illustration(null);

        final GitLabDetailedStatusEntity built = builder.build();

        assertThat(built.illustration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFaviconIsNullable() {
        final GitLabDetailedStatusEntityBuilder builder = GitLabDetailedStatusEntityBuilder.builder(
                        CommonCatalogFixtures.detailedStatusEntity())
                .favicon(null);

        final GitLabDetailedStatusEntity built = builder.build();

        assertThat(built.favicon()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActionIsNullable() {
        final GitLabDetailedStatusEntityBuilder builder = GitLabDetailedStatusEntityBuilder.builder(
                        CommonCatalogFixtures.detailedStatusEntity())
                .action(null);

        final GitLabDetailedStatusEntity built = builder.build();

        assertThat(built.action()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDetailedStatusEntity value = CommonCatalogFixtures.detailedStatusEntity();

        assertSoftly(softly -> {
            softly.assertThat(value.icon()).isEqualTo("status_success");
            softly.assertThat(value.text()).isEqualTo("passed");
            softly.assertThat(value.label()).isEqualTo("passed");
            softly.assertThat(value.group()).isEqualTo("success");
            softly.assertThat(value.tooltip()).isEqualTo("passed");
            softly.assertThat(value.hasDetails()).isEqualTo(true);
            softly.assertThat(value.detailsPath()).isEqualTo("/test-group/test-project/-/pipelines/287");
            softly.assertThat(value.illustration()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.favicon()).isEqualTo("/assets/ci_favicons/favicon_status_success.png");
            softly.assertThat(value.action()).isEqualTo(CommonCatalogFixtures.detailedStatusEntityAction());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDetailedStatusEntity original = CommonCatalogFixtures.detailedStatusEntity();

        final GitLabDetailedStatusEntity rebuilt =
                GitLabDetailedStatusEntityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDetailedStatusEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "icon",
                        "text",
                        "label",
                        "group",
                        "tooltip",
                        "hasDetails",
                        "detailsPath",
                        "illustration",
                        "favicon",
                        "action");
    }
}
