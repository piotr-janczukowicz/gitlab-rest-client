package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPagesDomainCertificateTest {

    @Test
    void constructor_shouldAcceptNull_whenSubjectIsNullable() {
        final GitLabPagesDomainCertificateBuilder builder = GitLabPagesDomainCertificateBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomainCertificate())
                .subject(null);

        final GitLabPagesDomainCertificate built = builder.build();

        assertThat(built.subject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiredIsNullable() {
        final GitLabPagesDomainCertificateBuilder builder = GitLabPagesDomainCertificateBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomainCertificate())
                .expired(null);

        final GitLabPagesDomainCertificate built = builder.build();

        assertThat(built.expired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCertificateIsNullable() {
        final GitLabPagesDomainCertificateBuilder builder = GitLabPagesDomainCertificateBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomainCertificate())
                .certificate(null);

        final GitLabPagesDomainCertificate built = builder.build();

        assertThat(built.certificate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCertificateTextIsNullable() {
        final GitLabPagesDomainCertificateBuilder builder = GitLabPagesDomainCertificateBuilder.builder(
                        PagesdomainsCatalogFixtures.pagesDomainCertificate())
                .certificateText(null);

        final GitLabPagesDomainCertificate built = builder.build();

        assertThat(built.certificateText()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPagesDomainCertificate value = PagesdomainsCatalogFixtures.pagesDomainCertificate();

        assertSoftly(softly -> {
            softly.assertThat(value.subject()).isEqualTo("subject");
            softly.assertThat(value.expired()).isEqualTo("expired");
            softly.assertThat(value.certificate()).isEqualTo("certificate");
            softly.assertThat(value.certificateText()).isEqualTo("certificate_text");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPagesDomainCertificate original = PagesdomainsCatalogFixtures.pagesDomainCertificate();

        final GitLabPagesDomainCertificate rebuilt =
                GitLabPagesDomainCertificateBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPagesDomainCertificate.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("subject", "expired", "certificate", "certificateText");
    }
}
