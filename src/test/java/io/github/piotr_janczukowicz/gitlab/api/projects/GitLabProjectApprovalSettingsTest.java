package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectApprovalSettingsTest {

    @Test
    void constructor_shouldAcceptNull_whenRulesIsNullable() {
        final GitLabProjectApprovalSettingsBuilder builder = GitLabProjectApprovalSettingsBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettings())
                .rules(null);

        final GitLabProjectApprovalSettings built = builder.build();

        assertThat(built.rules()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFallbackApprovalsRequiredIsNullable() {
        final GitLabProjectApprovalSettingsBuilder builder = GitLabProjectApprovalSettingsBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettings())
                .fallbackApprovalsRequired(null);

        final GitLabProjectApprovalSettings built = builder.build();

        assertThat(built.fallbackApprovalsRequired()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectApprovalSettings value = ProjectsCatalogFixtures.projectApprovalSettings();

        assertSoftly(softly -> {
            softly.assertThat(value.rules()).isEqualTo(List.of(ProjectsCatalogFixtures.projectApprovalSettingRule()));
            softly.assertThat(value.fallbackApprovalsRequired()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectApprovalSettings original = ProjectsCatalogFixtures.projectApprovalSettings();

        final GitLabProjectApprovalSettings rebuilt =
                GitLabProjectApprovalSettingsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectApprovalSettings.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("rules", "fallbackApprovalsRequired");
    }
}
