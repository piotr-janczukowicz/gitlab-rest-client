package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPagesDomainCertificateExpirationTest {

    @Test
    void constructor_shouldAcceptNull_whenExpiredIsNullable() {
        final GitLabPagesDomainCertificateExpirationBuilder builder =
                GitLabPagesDomainCertificateExpirationBuilder.builder(
                                PagesdomainsCatalogFixtures.pagesDomainCertificateExpiration())
                        .expired(null);

        final GitLabPagesDomainCertificateExpiration built = builder.build();

        assertThat(built.expired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpirationIsNullable() {
        final GitLabPagesDomainCertificateExpirationBuilder builder =
                GitLabPagesDomainCertificateExpirationBuilder.builder(
                                PagesdomainsCatalogFixtures.pagesDomainCertificateExpiration())
                        .expiration(null);

        final GitLabPagesDomainCertificateExpiration built = builder.build();

        assertThat(built.expiration()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPagesDomainCertificateExpiration value =
                PagesdomainsCatalogFixtures.pagesDomainCertificateExpiration();

        assertSoftly(softly -> {
            softly.assertThat(value.expired()).isEqualTo("expired");
            softly.assertThat(value.expiration()).isEqualTo("expiration");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPagesDomainCertificateExpiration original =
                PagesdomainsCatalogFixtures.pagesDomainCertificateExpiration();

        final GitLabPagesDomainCertificateExpiration rebuilt =
                GitLabPagesDomainCertificateExpirationBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPagesDomainCertificateExpiration.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("expired", "expiration");
    }
}
