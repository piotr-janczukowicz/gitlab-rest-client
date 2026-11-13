package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPagesDomainBasicTest {

    @Test
    void constructor_shouldAcceptNull_whenDomainIsNullable() {
        final GitLabPagesDomainBasicBuilder builder = GitLabPagesDomainBasicBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomainBasic())
                .domain(null);

        final GitLabPagesDomainBasic built = builder.build();

        assertThat(built.domain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabPagesDomainBasicBuilder builder = GitLabPagesDomainBasicBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomainBasic())
                .url(null);

        final GitLabPagesDomainBasic built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabPagesDomainBasicBuilder builder = GitLabPagesDomainBasicBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomainBasic())
                .projectId(null);

        final GitLabPagesDomainBasic built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVerifiedIsNullable() {
        final GitLabPagesDomainBasicBuilder builder = GitLabPagesDomainBasicBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomainBasic())
                .verified(null);

        final GitLabPagesDomainBasic built = builder.build();

        assertThat(built.verified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVerificationCodeIsNullable() {
        final GitLabPagesDomainBasicBuilder builder = GitLabPagesDomainBasicBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomainBasic())
                .verificationCode(null);

        final GitLabPagesDomainBasic built = builder.build();

        assertThat(built.verificationCode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledUntilIsNullable() {
        final GitLabPagesDomainBasicBuilder builder = GitLabPagesDomainBasicBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomainBasic())
                .enabledUntil(null);

        final GitLabPagesDomainBasic built = builder.build();

        assertThat(built.enabledUntil()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoSslEnabledIsNullable() {
        final GitLabPagesDomainBasicBuilder builder = GitLabPagesDomainBasicBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomainBasic())
                .autoSslEnabled(null);

        final GitLabPagesDomainBasic built = builder.build();

        assertThat(built.autoSslEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCertificateExpirationIsNullable() {
        final GitLabPagesDomainBasicBuilder builder = GitLabPagesDomainBasicBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomainBasic())
                .certificateExpiration(null);

        final GitLabPagesDomainBasic built = builder.build();

        assertThat(built.certificateExpiration()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPagesDomainBasic value = PagesdomainsCatalogFixtures.pagesDomainBasic();

        assertSoftly(softly -> {
            softly.assertThat(value.domain()).isEqualTo("domain");
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.projectId()).isEqualTo("project_id");
            softly.assertThat(value.verified()).isEqualTo("verified");
            softly.assertThat(value.verificationCode()).isEqualTo("verification_code");
            softly.assertThat(value.enabledUntil()).isEqualTo("enabled_until");
            softly.assertThat(value.autoSslEnabled()).isEqualTo("auto_ssl_enabled");
            softly.assertThat(value.certificateExpiration())
                    .isEqualTo(PagesdomainsCatalogFixtures.pagesDomainCertificateExpiration());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPagesDomainBasic original = PagesdomainsCatalogFixtures.pagesDomainBasic();

        final GitLabPagesDomainBasic rebuilt =
                GitLabPagesDomainBasicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPagesDomainBasic.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "domain",
                        "url",
                        "projectId",
                        "verified",
                        "verificationCode",
                        "enabledUntil",
                        "autoSslEnabled",
                        "certificateExpiration");
    }
}
