package io.github.piotr_janczukowicz.gitlab.api.errortracking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabErrorTrackingProjectSettingTest {

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabErrorTrackingProjectSettingBuilder builder = GitLabErrorTrackingProjectSettingBuilder.builder(
                        ErrortrackingCatalogFixtures.errorTrackingProjectSetting())
                .active(null);

        final GitLabErrorTrackingProjectSetting built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectNameIsNullable() {
        final GitLabErrorTrackingProjectSettingBuilder builder = GitLabErrorTrackingProjectSettingBuilder.builder(
                        ErrortrackingCatalogFixtures.errorTrackingProjectSetting())
                .projectName(null);

        final GitLabErrorTrackingProjectSetting built = builder.build();

        assertThat(built.projectName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSentryExternalUrlIsNullable() {
        final GitLabErrorTrackingProjectSettingBuilder builder = GitLabErrorTrackingProjectSettingBuilder.builder(
                        ErrortrackingCatalogFixtures.errorTrackingProjectSetting())
                .sentryExternalUrl(null);

        final GitLabErrorTrackingProjectSetting built = builder.build();

        assertThat(built.sentryExternalUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabErrorTrackingProjectSettingBuilder builder = GitLabErrorTrackingProjectSettingBuilder.builder(
                        ErrortrackingCatalogFixtures.errorTrackingProjectSetting())
                .apiUrl(null);

        final GitLabErrorTrackingProjectSetting built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIntegratedIsNullable() {
        final GitLabErrorTrackingProjectSettingBuilder builder = GitLabErrorTrackingProjectSettingBuilder.builder(
                        ErrortrackingCatalogFixtures.errorTrackingProjectSetting())
                .integrated(null);

        final GitLabErrorTrackingProjectSetting built = builder.build();

        assertThat(built.integrated()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabErrorTrackingProjectSetting value = ErrortrackingCatalogFixtures.errorTrackingProjectSetting();

        assertSoftly(softly -> {
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.projectName()).isEqualTo("sample sentry project");
            softly.assertThat(value.sentryExternalUrl()).isEqualTo("https://sentry.io/myawesomeproject/project");
            softly.assertThat(value.apiUrl()).isEqualTo("https://sentry.io/api/0/projects/myawesomeproject/project");
            softly.assertThat(value.integrated()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabErrorTrackingProjectSetting original = ErrortrackingCatalogFixtures.errorTrackingProjectSetting();

        final GitLabErrorTrackingProjectSetting rebuilt =
                GitLabErrorTrackingProjectSettingBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabErrorTrackingProjectSetting.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("active", "projectName", "sentryExternalUrl", "apiUrl", "integrated");
    }
}
