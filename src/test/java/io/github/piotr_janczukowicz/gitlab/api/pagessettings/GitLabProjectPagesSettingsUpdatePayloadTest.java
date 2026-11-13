package io.github.piotr_janczukowicz.gitlab.api.pagessettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPagesSettingsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenPagesUniqueDomainEnabledIsNullable() {
        final GitLabProjectPagesSettingsUpdatePayloadBuilder builder =
                GitLabProjectPagesSettingsUpdatePayloadBuilder.builder(
                                PagessettingsCatalogFixtures.projectPagesSettingsUpdatePayload())
                        .pagesUniqueDomainEnabled(null);

        final GitLabProjectPagesSettingsUpdatePayload built = builder.build();

        assertThat(built.pagesUniqueDomainEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesHttpsOnlyIsNullable() {
        final GitLabProjectPagesSettingsUpdatePayloadBuilder builder =
                GitLabProjectPagesSettingsUpdatePayloadBuilder.builder(
                                PagessettingsCatalogFixtures.projectPagesSettingsUpdatePayload())
                        .pagesHttpsOnly(null);

        final GitLabProjectPagesSettingsUpdatePayload built = builder.build();

        assertThat(built.pagesHttpsOnly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesPrimaryDomainIsNullable() {
        final GitLabProjectPagesSettingsUpdatePayloadBuilder builder =
                GitLabProjectPagesSettingsUpdatePayloadBuilder.builder(
                                PagessettingsCatalogFixtures.projectPagesSettingsUpdatePayload())
                        .pagesPrimaryDomain(null);

        final GitLabProjectPagesSettingsUpdatePayload built = builder.build();

        assertThat(built.pagesPrimaryDomain()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPagesSettingsUpdatePayload value =
                PagessettingsCatalogFixtures.projectPagesSettingsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.pagesUniqueDomainEnabled()).isEqualTo(true);
            softly.assertThat(value.pagesHttpsOnly()).isEqualTo(true);
            softly.assertThat(value.pagesPrimaryDomain()).isEqualTo("pages_primary_domain");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPagesSettingsUpdatePayload original =
                PagessettingsCatalogFixtures.projectPagesSettingsUpdatePayload();

        final GitLabProjectPagesSettingsUpdatePayload rebuilt =
                GitLabProjectPagesSettingsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPagesSettingsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("pagesUniqueDomainEnabled", "pagesHttpsOnly", "pagesPrimaryDomain");
    }
}
