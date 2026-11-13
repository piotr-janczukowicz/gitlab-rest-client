package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabLicenseTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabLicenseBuilder builder =
                GitLabLicenseBuilder.builder(CommonCatalogFixtures.license()).key(null);

        final GitLabLicense built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabLicenseBuilder builder =
                GitLabLicenseBuilder.builder(CommonCatalogFixtures.license()).name(null);

        final GitLabLicense built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNicknameIsNullable() {
        final GitLabLicenseBuilder builder =
                GitLabLicenseBuilder.builder(CommonCatalogFixtures.license()).nickname(null);

        final GitLabLicense built = builder.build();

        assertThat(built.nickname()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHtmlUrlIsNullable() {
        final GitLabLicenseBuilder builder =
                GitLabLicenseBuilder.builder(CommonCatalogFixtures.license()).htmlUrl(null);

        final GitLabLicense built = builder.build();

        assertThat(built.htmlUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceUrlIsNullable() {
        final GitLabLicenseBuilder builder =
                GitLabLicenseBuilder.builder(CommonCatalogFixtures.license()).sourceUrl(null);

        final GitLabLicense built = builder.build();

        assertThat(built.sourceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPopularIsNullable() {
        final GitLabLicenseBuilder builder =
                GitLabLicenseBuilder.builder(CommonCatalogFixtures.license()).popular(null);

        final GitLabLicense built = builder.build();

        assertThat(built.popular()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabLicenseBuilder builder =
                GitLabLicenseBuilder.builder(CommonCatalogFixtures.license()).description(null);

        final GitLabLicense built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConditionsIsNullable() {
        final GitLabLicenseBuilder builder =
                GitLabLicenseBuilder.builder(CommonCatalogFixtures.license()).conditions(null);

        final GitLabLicense built = builder.build();

        assertThat(built.conditions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPermissionsIsNullable() {
        final GitLabLicenseBuilder builder =
                GitLabLicenseBuilder.builder(CommonCatalogFixtures.license()).permissions(null);

        final GitLabLicense built = builder.build();

        assertThat(built.permissions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLimitationsIsNullable() {
        final GitLabLicenseBuilder builder =
                GitLabLicenseBuilder.builder(CommonCatalogFixtures.license()).limitations(null);

        final GitLabLicense built = builder.build();

        assertThat(built.limitations()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabLicenseBuilder builder =
                GitLabLicenseBuilder.builder(CommonCatalogFixtures.license()).content(null);

        final GitLabLicense built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabLicense value = CommonCatalogFixtures.license();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("gpl-3.0");
            softly.assertThat(value.name()).isEqualTo("GNU General Public License v3.0");
            softly.assertThat(value.nickname()).isEqualTo("GNU GPLv3");
            softly.assertThat(value.htmlUrl()).isEqualTo("http://choosealicense.com/licenses/gpl-3.0");
            softly.assertThat(value.sourceUrl()).isEqualTo("source_url");
            softly.assertThat(value.popular()).isEqualTo(true);
            softly.assertThat(value.description()).isEqualTo("A simple license");
            softly.assertThat(value.conditions()).isEqualTo(List.of("include-copyright"));
            softly.assertThat(value.permissions()).isEqualTo(List.of("commercial-use"));
            softly.assertThat(value.limitations()).isEqualTo(List.of("liability"));
            softly.assertThat(value.content()).isEqualTo("GNU GENERAL PUBLIC LICENSE");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabLicense original = CommonCatalogFixtures.license();

        final GitLabLicense rebuilt = GitLabLicenseBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabLicense.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "key",
                        "name",
                        "nickname",
                        "htmlUrl",
                        "sourceUrl",
                        "popular",
                        "description",
                        "conditions",
                        "permissions",
                        "limitations",
                        "content");
    }
}
