package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPagesDomainTest {

    @Test
    void constructor_shouldAcceptNull_whenDomainIsNullable() {
        final GitLabPagesDomainBuilder builder = GitLabPagesDomainBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomain())
                .domain(null);

        final GitLabPagesDomain built = builder.build();

        assertThat(built.domain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabPagesDomainBuilder builder = GitLabPagesDomainBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomain())
                .url(null);

        final GitLabPagesDomain built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVerifiedIsNullable() {
        final GitLabPagesDomainBuilder builder = GitLabPagesDomainBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomain())
                .verified(null);

        final GitLabPagesDomain built = builder.build();

        assertThat(built.verified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVerificationCodeIsNullable() {
        final GitLabPagesDomainBuilder builder = GitLabPagesDomainBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomain())
                .verificationCode(null);

        final GitLabPagesDomain built = builder.build();

        assertThat(built.verificationCode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledUntilIsNullable() {
        final GitLabPagesDomainBuilder builder = GitLabPagesDomainBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomain())
                .enabledUntil(null);

        final GitLabPagesDomain built = builder.build();

        assertThat(built.enabledUntil()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoSslEnabledIsNullable() {
        final GitLabPagesDomainBuilder builder = GitLabPagesDomainBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomain())
                .autoSslEnabled(null);

        final GitLabPagesDomain built = builder.build();

        assertThat(built.autoSslEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCertificateIsNullable() {
        final GitLabPagesDomainBuilder builder = GitLabPagesDomainBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomain())
                .certificate(null);

        final GitLabPagesDomain built = builder.build();

        assertThat(built.certificate()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPagesDomain value = PagesdomainsCatalogFixtures.pagesDomain();

        assertSoftly(softly -> {
            softly.assertThat(value.domain()).isEqualTo("domain");
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.verified()).isEqualTo("verified");
            softly.assertThat(value.verificationCode()).isEqualTo("verification_code");
            softly.assertThat(value.enabledUntil()).isEqualTo("enabled_until");
            softly.assertThat(value.autoSslEnabled()).isEqualTo("auto_ssl_enabled");
            softly.assertThat(value.certificate()).isEqualTo(PagesdomainsCatalogFixtures.pagesDomainCertificate());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPagesDomain original = PagesdomainsCatalogFixtures.pagesDomain();

        final GitLabPagesDomain rebuilt =
                GitLabPagesDomainBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPagesDomain.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "domain",
                        "url",
                        "verified",
                        "verificationCode",
                        "enabledUntil",
                        "autoSslEnabled",
                        "certificate");
    }
}
