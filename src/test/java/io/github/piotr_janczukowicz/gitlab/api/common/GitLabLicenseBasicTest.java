package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabLicenseBasicTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabLicenseBasicBuilder builder = GitLabLicenseBasicBuilder.builder(
                        CommonCatalogFixtures.licenseBasic())
                .key(null);

        final GitLabLicenseBasic built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabLicenseBasicBuilder builder = GitLabLicenseBasicBuilder.builder(
                        CommonCatalogFixtures.licenseBasic())
                .name(null);

        final GitLabLicenseBasic built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNicknameIsNullable() {
        final GitLabLicenseBasicBuilder builder = GitLabLicenseBasicBuilder.builder(
                        CommonCatalogFixtures.licenseBasic())
                .nickname(null);

        final GitLabLicenseBasic built = builder.build();

        assertThat(built.nickname()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHtmlUrlIsNullable() {
        final GitLabLicenseBasicBuilder builder = GitLabLicenseBasicBuilder.builder(
                        CommonCatalogFixtures.licenseBasic())
                .htmlUrl(null);

        final GitLabLicenseBasic built = builder.build();

        assertThat(built.htmlUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceUrlIsNullable() {
        final GitLabLicenseBasicBuilder builder = GitLabLicenseBasicBuilder.builder(
                        CommonCatalogFixtures.licenseBasic())
                .sourceUrl(null);

        final GitLabLicenseBasic built = builder.build();

        assertThat(built.sourceUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabLicenseBasic value = CommonCatalogFixtures.licenseBasic();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("gpl-3.0");
            softly.assertThat(value.name()).isEqualTo("GNU General Public License v3.0");
            softly.assertThat(value.nickname()).isEqualTo("GNU GPLv3");
            softly.assertThat(value.htmlUrl()).isEqualTo("http://choosealicense.com/licenses/gpl-3.0");
            softly.assertThat(value.sourceUrl()).isEqualTo("source_url");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabLicenseBasic original = CommonCatalogFixtures.licenseBasic();

        final GitLabLicenseBasic rebuilt =
                GitLabLicenseBasicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabLicenseBasic.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "name", "nickname", "htmlUrl", "sourceUrl");
    }
}
